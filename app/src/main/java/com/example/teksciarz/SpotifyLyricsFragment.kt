package com.example.teksciarz

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.teksciarz.viewmodels.SpotifyLyricsViewModel
import com.google.android.material.snackbar.Snackbar
import com.spotify.android.appremote.api.error.CouldNotFindSpotifyApp
import com.spotify.android.appremote.api.error.NotLoggedInException
import com.spotify.android.appremote.api.error.UserNotAuthorizedException
import kotlinx.android.synthetic.main.fragment_spotify_lyrics.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@FlowPreview
class SpotifyLyricsFragment : Fragment() {
    private val viewModel: SpotifyLyricsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotify_lyrics, container, false)

        val circularProgressDrawable = CircularProgressDrawable(requireContext())
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        var snackbar: Snackbar? = null

        viewModel.currentSong.observe(viewLifecycleOwner, Observer { song ->

            title.text = song.title
            artist.text = song.artist
            if (!song.lyrics.isNullOrBlank()) {
                lyrics.text = getSpannableStringWithBackground(song.lyrics, R.color.colorPrimary)
            } else {
                lyrics.text = "Nie moglem znalezc tekstu"
            }

            Glide.with(view)
                .load(
                    song.imageUrl ?: song.bitmapImage
                )
                .placeholder(circularProgressDrawable)
                .error(R.drawable.ic_launcher_foreground)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(cover)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                loadingLayout.visibility = View.VISIBLE
                mainLayout.visibility = View.INVISIBLE
                loadingDescription.text = it
            } else {
                loadingLayout.visibility = View.INVISIBLE
                mainLayout.visibility = View.VISIBLE
            }
        })

        viewModel.loadingError.observe(viewLifecycleOwner, Observer { shouldShowSnackbar ->
            if (shouldShowSnackbar) {
                snackbar =
                    Snackbar.make(scrollView, "Check your connection", Snackbar.LENGTH_INDEFINITE)
                        .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                        .setAction("Retry") {
                            viewModel.refreshSong()
                        }
                snackbar?.show()
            }
            if (!shouldShowSnackbar && snackbar?.isShown == true) {
                Log.d("SpotifyLyricsFragment", "Dismissing")
                snackbar?.dismiss()
            }
        })

        viewModel.spotifyAppNotFound.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { throwable ->
                when (throwable) {
                    is CouldNotFindSpotifyApp -> showAppNotFoundDialog()
                    is NotLoggedInException ->
                        Toast.makeText(
                            requireActivity(),
                            "You must go to the Spotify and log-in",
                            Toast.LENGTH_LONG
                        ).show()
                    is UserNotAuthorizedException -> showAuthorizationFailedDialog()
                }
            }
        })

        return view
    }

    private fun getSpannableStringWithBackground(
        text: CharSequence,
        @ColorRes color: Int
    ): SpannableStringBuilder {
        val spannableString = SpannableStringBuilder(text)
        spannableString.setSpan(
            BackgroundColorSpan(resources.getColor(color)),
            0,
            spannableString.length - 1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }

    private fun showAppNotFoundDialog() =
        showDialogWithExit("Spotify app couldn't be found", "Google Play") {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setPackage("com.android.vending")
                data =
                    Uri.parse("https://play.google.com/store/apps/details?id=com.spotify.music")
            }
            startActivity(intent)
        }

    private fun showAuthorizationFailedDialog() =
        showDialogWithExit("You must authorize the app.", "Authorize") {
            viewModel.connectToSpotify()
        }

    private fun showDialogWithExit(
        message: CharSequence,
        positiveActionMessage: CharSequence,
        onPositiveAction: () -> Unit
    ) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setMessage(message)
        builder.setNegativeButton("Exit") { _, _ ->
            requireActivity().finishAffinity()
        }
        builder.setPositiveButton(positiveActionMessage) { _, _ ->
            onPositiveAction()
        }
        builder.show()
    }
}