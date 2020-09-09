package com.example.teksciarz

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.teksciarz.viewmodels.SpotifyLyricsViewModel
import com.google.android.material.snackbar.Snackbar
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
                val spannableString = SpannableStringBuilder(song.lyrics)
                spannableString.setSpan(
                    BackgroundColorSpan(resources.getColor(R.color.colorPrimary)),
                    0,
                    spannableString.length - 1,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                lyrics.text = spannableString
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

        return view
    }


}