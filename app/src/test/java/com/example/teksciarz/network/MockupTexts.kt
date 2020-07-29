package com.example.teksciarz.network

import org.jsoup.Jsoup

object MockupTexts {
    val old = Jsoup.parse(
        """<div class="lyrics">
    <!---->

    <form ng-submit="lyrics_ctrl.finish_editing()" ng-model-options="{updateOn: 'submit'}" submit-on-cmd-enter="" dirtyable="" exports-form-api="lyrics_ctrl.lyrics_form = api" class="ng-pristine ng-valid">
      <textarea ng-show="lyrics_ctrl.should_show_lyrics_edit_form()" ng-disabled="lyrics_ctrl.edit_blocked" tabindex="1" ng-model="editable.markdown" class="wysiwyg_input wysiwyg_input--full_width u-vertical_margins ng-pristine ng-untouched ng-valid ng-empty ng-hide" ng-class="{'wysiwyg_input--warning': lyrics_ctrl.editable_lyrics_stale}" style="overflow: hidden visible; overflow-wrap: break-word;"></textarea>
      <textarea ng-show="lyrics_ctrl.should_show_lyrics_edit_proposal_form()" ng-disabled="lyrics_ctrl.edit_blocked" tabindex="1" ng-model="lyrics_ctrl.lyrics_for_edit_proposal.markdown" class="wysiwyg_input wysiwyg_input--full_width u-vertical_margins ng-pristine ng-untouched ng-valid ng-empty ng-hide" ng-class="{'wysiwyg_input--warning': lyrics_ctrl.editable_lyrics_stale}" style="overflow: hidden visible; overflow-wrap: break-word;"></textarea>
    </form>

    <section ng-hide="lyrics_ctrl.should_show_lyrics_edit_form() || lyrics_ctrl.should_show_lyrics_edit_proposal_form()" text-selection-changed="lyrics_ctrl.update_selection_range(ranges[0])" class=""><p>[Intro]<br><a href="/Kendrick-lamar-humble-lyrics#note-11593050" data-id="11593050" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11593050" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Nobody pray for me<br>It's been that day for me<br>Way (Yeah, yeah)</a><br><br>[Verse 1]<br><a href="/Kendrick-lamar-humble-lyrics#note-11592574" data-id="11592574" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592574" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Ayy, I remember syrup sandwiches and crime allowances<br>Finesse a nigga with some counterfeits, but now I'm countin' this</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592958" data-id="11592958" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592958" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Parmesan where my accountant lives, in fact I'm downin' this<br>D'USSÉ with my boo bae tastes like Kool-Aid for the analysts</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592775" data-id="11592775" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592775" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Girl, I can buy your ass the world with my paystub</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11776682" data-id="11776682" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11776682" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Ooh, that pussy good, won't you sit it on my taste bloods?</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592561" data-id="11592561" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592561" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="1">I get way too petty once you let me do the extras<br>Pull up on your block, then break it down: we playin' Tetris<br>AM to the PM, PM to the AM, funk</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592897" data-id="11592897" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592897" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Piss out your per diem, you just gotta hate 'em, funk</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592781" data-id="11592781" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592781" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">If I quit your BM, I still ride Mercedes, funk</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592609" data-id="11592609" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592609" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="1">If I quit this season, I still be the greatest, funk</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592667" data-id="11592667" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592667" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="1">My left stroke just went viral<br>Right stroke put lil' baby in a spiral</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592578" data-id="11592578" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592578" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Soprano C, we like to keep it on a high note<br>It's levels to it, you and I know</a><br><br>[Chorus]<br><a href="/Kendrick-lamar-humble-lyrics#note-11592646" data-id="11592646" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592646" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Bitch, be humble (Hol' up, bitch)<br>Sit down (Hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)<br>Be humble (Hol' up, hol' up)<br>Sit down (Hol' up, hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)</a><br><defer-compile class="u-display_block" timing-label="deferred-inread-ad-loaded-desktop_song_inread" within-visibility-range="50vh"></defer-compile><br>[Verse 2]<br><a href="/Kendrick-lamar-humble-lyrics#note-11592548" data-id="11592548" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592548" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Who that nigga thinkin' that he frontin' on Man-Man? (Man-Man)<br>Get the fuck off my stage, I'm the Sandman (Sandman)</a><br><a href="/Kendrick-lamar-humble-lyrics#note-18522490" data-id="18522490" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="18522490" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Get the fuck off my dick, that ain't right</a><br>I make a play fucking up your whole life<br><a href="/Kendrick-lamar-humble-lyrics#note-11592544" data-id="11592544" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592544" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">I'm so fuckin' sick and tired of the Photoshop<br>Show me somethin' natural like afro on Richard Pryor<br>Show me somethin' natural like ass with some stretch marks</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592558" data-id="11592558" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592558" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Still will take you down right on your mama's couch in Polo socks</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592545" data-id="11592545" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592545" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Ayy, this shit way too crazy, ayy, you do not amaze me, ayy<br>I blew cool from AC, ayy, Obama just paged me, ayy<br>I don't fabricate it, ayy, most of y'all be fakin', ayy<br>I stay modest 'bout it, ayy, she elaborate it, ayy</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11592560" data-id="11592560" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592560" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">This that Grey Poupon, that Evian, that TED Talk, ayy</a><br><a href="/Kendrick-lamar-humble-lyrics#note-11593217" data-id="11593217" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11593217" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Watch my soul speak, you let the meds talk, ayy<br>If I kill a nigga, it won't be the alcohol, ayy<br>I'm the realest nigga after all</a><br><br>[Chorus]<br><a href="/Kendrick-lamar-humble-lyrics#note-11592646" data-id="11592646" class="referent referent--yellow" ng-click="open()" ng-class="{          'referent--linked_to_preview': song_ctrl.referent_has_preview(fragment_id),          'referent--linked_to_preview_active': song_ctrl.highlight_preview_referent(fragment_element_id),          'referent--purple_indicator': song_ctrl.show_preview_referent_indicator(fragment_element_id)        }" prevent-default-click="" annotation-fragment="11592646" on-hover-with-no-digest="set_current_hover_and_digest(hover ? fragment_id : undefined)" classification="accepted" image="false" pending-editorial-actions-count="0">Bitch, be humble (Hol' up, bitch)<br>Sit down (Hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)<br>Be humble (Hol' up, hol' up)<br>Sit down (Hol' up, hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)</a></p></section>

    <!----><div ng-if="can_perform('edit_lyrics') || can_perform('propose_lyrics_edit')" class="lyrics-correct_line" position-beside="${"$"}ctrl.lyrics_positioning_target || lyrics_ctrl.correction.rect" style="top: -413.001px;">
      <!---->
    </div><!---->
  </div>"""
    )

    val new = Jsoup.parse(
        "<div class=\"SongPageGrid-sc-1vi6xda-0 DGVcp Lyrics__Root-sc-1ynbvzw-0 jvlKWy\"><div class=\"Lyrics__Container-sc-1ynbvzw-2 jgQsqn\">[Intro]<br><a href=\"/11593050/Kendrick-lamar-humble/Nobody-pray-for-me-its-been-that-day-for-me-way-yeah-yeah\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Nobody pray for me<br>It's been that day for me<br>Way (Yeah, yeah)</span></a><br><br>[Verse 1]<br><a href=\"/11592574/Kendrick-lamar-humble/Ayy-i-remember-syrup-sandwiches-and-crime-allowances-finesse-a-nigga-with-some-counterfeits-but-now-im-countin-this\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Ayy, I remember syrup sandwiches and crime allowances<br>Finesse a nigga with some counterfeits, but now I’m countin' this</span></a><br><a href=\"/11592958/Kendrick-lamar-humble/Parmesan-where-my-accountant-lives-in-fact-im-downin-this-dusse-with-my-boo-bae-tastes-like-kool-aid-for-the-analysts\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Parmesan where my accountant lives, in fact I'm downin’ this<br>D'USSÉ with my boo bae tastes like Kool-Aid for the analysts</span></a><br><a href=\"/11592775/Kendrick-lamar-humble/Girl-i-can-buy-your-ass-the-world-with-my-paystub\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Girl, I can buy your ass the world with my paystub</span></a><br><a href=\"/11776682/Kendrick-lamar-humble/Ooh-that-pussy-good-wont-you-sit-it-on-my-taste-bloods\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Ooh, that pussy good, won't you sit it on my taste bloods?</span></a><br><a href=\"/11592561/Kendrick-lamar-humble/I-get-way-too-petty-once-you-let-me-do-the-extras-pull-up-on-your-block-then-break-it-down-we-playin-tetris-am-to-the-pm-pm-to-the-am-funk\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">I get way too petty once you let me do the extras<br>Pull up on your block, then break it down: we playin' Tetris<br>AM to the PM, PM to the AM, funk</span></a><br><a href=\"/11592897/Kendrick-lamar-humble/Piss-out-your-per-diem-you-just-gotta-hate-em-funk\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Piss out your per diem, you just gotta hate 'em, funk</span></a><br><a href=\"/11592781/Kendrick-lamar-humble/If-i-quit-your-bm-i-still-ride-mercedes-funk\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">If I quit your BM, I still ride Mercedes, funk</span></a><br><a href=\"/11592609/Kendrick-lamar-humble/If-i-quit-this-season-i-still-be-the-greatest-funk\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">If I quit this season, I still be the greatest, funk</span></a><br><a href=\"/11592667/Kendrick-lamar-humble/My-left-stroke-just-went-viral-right-stroke-put-lil-baby-in-a-spiral\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">My left stroke just went viral<br>Right stroke put lil' baby in a spiral</span></a><br><a href=\"/11592578/Kendrick-lamar-humble/Soprano-c-we-like-to-keep-it-on-a-high-note-its-levels-to-it-you-and-i-know\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Soprano C, we like to keep it on a high note<br>It's levels to it, you and I know</span></a><br><br>[Chorus]<br><a href=\"/11592646/Kendrick-lamar-humble/Bitch-be-humble-hol-up-bitch-sit-down-hol-up-lil-hol-up-lil-bitch-be-humble-hol-up-bitch-sit-down-hol-up-sit-down-lil-sit-down-lil-bitch-be-humble-hol-up-hol-up-bitch-sit-down-hol-up-hol-up-lil-bitch-be-humble-lil-bitch-hol-up-bitch-sit-down-hol-up-hol-up-hol-up-hol-up-be-humble-hol-up-hol-up-sit-down-hol-up-hol-up-lil-hol-up-lil-bitch-be-humble-hol-up-bitch-sit-down-hol-up-sit-down-lil-sit-down-lil-bitch-be-humble-hol-up-hol-up-bitch-sit-down-hol-up-hol-up-lil-bitch-be-humble-lil-bitch-hol-up-b\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Bitch, be humble (Hol' up, bitch)<br>Sit down (Hol’ up, lil’, hol' up, lil’ bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil’ bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)<br>Be humble (Hol' up, hol' up)<br>Sit down (Hol' up, hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)</span></a><br></div><div class=\"RightSidebar-pajcl2-0 eGLQob\"><div class=\"SidebarAd__Container-sc-1cw85h6-0 kuDvzY\"><div id=\"div-gpt-ad-desktop_song_lyrics_sidebar-desktop_song_lyrics_sidebar-1\" class=\"DfpAd__Container-sc-1tnbv7f-0 jVnzAo\" data-google-query-id=\"CO7Irs3y8OoCFRbKuwgd460Iag\" style=\"\"><div id=\"google_ads_iframe_/342026871/desktop_song_lyrics_sidebar_0__container__\" style=\"border: 0pt none;\"><iframe id=\"google_ads_iframe_/342026871/desktop_song_lyrics_sidebar_0\" title=\"3rd party ad content\" name=\"google_ads_iframe_/342026871/desktop_song_lyrics_sidebar_0\" width=\"300\" height=\"600\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" srcdoc=\"\" style=\"border: 0px; vertical-align: bottom;\" data-google-container-id=\"2\" data-load-complete=\"true\"></iframe></div></div></div></div><div class=\"Lyrics__Container-sc-1ynbvzw-2 jgQsqn\"><div class=\"InreadAd__Container-sc-1pp8jgt-0 hFVRqM\"><div id=\"div-gpt-ad-desktop_song_lyrics_inread-desktop_song_lyrics_inread-1\" class=\"DfpAd__Container-sc-1tnbv7f-0 jVnzAo\" data-google-query-id=\"CLWo4pvz8OoCFQfiuwgdVBUPfA\" style=\"\"><div id=\"google_ads_iframe_/342026871/desktop_song_lyrics_inread_0__container__\" style=\"border: 0pt none;\"><iframe id=\"google_ads_iframe_/342026871/desktop_song_lyrics_inread_0\" title=\"3rd party ad content\" name=\"google_ads_iframe_/342026871/desktop_song_lyrics_inread_0\" width=\"970\" height=\"250\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" srcdoc=\"\" style=\"border: 0px; vertical-align: bottom;\" data-google-container-id=\"3\" data-load-complete=\"true\"></iframe></div></div></div></div><div class=\"Lyrics__Container-sc-1ynbvzw-2 jgQsqn\">[Verse 2]<br><a href=\"/11592548/Kendrick-lamar-humble/Who-that-nigga-thinkin-that-he-frontin-on-man-man-man-man-get-the-fuck-off-my-stage-im-the-sandman-sandman\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Who that nigga thinkin' that he frontin' on Man-Man? (Man-Man)<br>Get the fuck off my stage, I'm the Sandman (Sandman)</span></a><br><a href=\"/18522490/Kendrick-lamar-humble/Get-the-fuck-off-my-dick-that-aint-right\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Get the fuck off my dick, that ain't right</span></a><br>I make a play fucking up your whole life<br><a href=\"/11592544/Kendrick-lamar-humble/Im-so-fuckin-sick-and-tired-of-the-photoshop-show-me-somethin-natural-like-afro-on-richard-pryor-show-me-somethin-natural-like-ass-with-some-stretch-marks\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">I'm so fuckin' sick and tired of the Photoshop<br>Show me somethin' natural like afro on Richard Pryor<br>Show me somethin' natural like ass with some stretch marks</span></a><br><a href=\"/11592558/Kendrick-lamar-humble/Still-will-take-you-down-right-on-your-mamas-couch-in-polo-socks\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Still will take you down right on your mama's couch in Polo socks</span></a><br><a href=\"/11592545/Kendrick-lamar-humble/Ayy-this-shit-way-too-crazy-ayy-you-do-not-amaze-me-ayy-i-blew-cool-from-ac-ayy-obama-just-paged-me-ayy-i-dont-fabricate-it-ayy-most-of-yall-be-fakin-ayy-i-stay-modest-bout-it-ayy-she-elaborate-it-ayy\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Ayy, this shit way too crazy, ayy, you do not amaze me, ayy<br>I blew cool from AC, ayy, Obama just paged me, ayy<br>I don't fabricate it, ayy, most of y'all be fakin', ayy<br>I stay modest 'bout it, ayy, she elaborate it, ayy</span></a><br><a href=\"/11592560/Kendrick-lamar-humble/This-that-grey-poupon-that-evian-that-ted-talk-ayy\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">This that Grey Poupon, that Evian, that TED Talk, ayy</span></a><br><a href=\"/11593217/Kendrick-lamar-humble/Watch-my-soul-speak-you-let-the-meds-talk-ayy-if-i-kill-a-nigga-it-wont-be-the-alcohol-ayy-im-the-realest-nigga-after-all\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Watch my soul speak, you let the meds talk, ayy<br>If I kill a nigga, it won't be the alcohol, ayy<br>I'm the realest nigga after all</span></a><br><br>[Chorus]<br><a href=\"/11592646/Kendrick-lamar-humble/Bitch-be-humble-hol-up-bitch-sit-down-hol-up-lil-hol-up-lil-bitch-be-humble-hol-up-bitch-sit-down-hol-up-sit-down-lil-sit-down-lil-bitch-be-humble-hol-up-hol-up-bitch-sit-down-hol-up-hol-up-lil-bitch-be-humble-lil-bitch-hol-up-bitch-sit-down-hol-up-hol-up-hol-up-hol-up-be-humble-hol-up-hol-up-sit-down-hol-up-hol-up-lil-hol-up-lil-bitch-be-humble-hol-up-bitch-sit-down-hol-up-sit-down-lil-sit-down-lil-bitch-be-humble-hol-up-hol-up-bitch-sit-down-hol-up-hol-up-lil-bitch-be-humble-lil-bitch-hol-up-b\" class=\"ReferentFragment__ClickTarget-oqvzi6-0 BjqYT\"><span class=\"ReferentFragment__Highlight-oqvzi6-1 gPoGLU\">Bitch, be humble (Hol' up, bitch)<br>Sit down (Hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)<br>Be humble (Hol' up, hol' up)<br>Sit down (Hol' up, hol' up, lil', hol' up, lil' bitch)<br>Be humble (Hol' up, bitch)<br>Sit down (Hol' up, sit down, lil', sit down, lil' bitch)<br>Be humble (Hol' up, hol' up)<br>Bitch, sit down (Hol' up, hol' up, lil' bitch)<br>Be humble (Lil' bitch, hol' up, bitch)<br>Sit down (Hol' up, hol' up, hol' up, hol' up)</span></a></div><div class=\"RightSidebar-pajcl2-0 eGLQob\"><div class=\"SidebarAd__Container-sc-1cw85h6-0 bDikLl\"><div id=\"div-gpt-ad-desktop_song_lyrics_sidebar2-desktop_song_lyrics_sidebar2-1\" class=\"DfpAd__Container-sc-1tnbv7f-0 jVnzAo\" data-google-query-id=\"CMfS8Zvz8OoCFUJC5QodQrQJYQ\" style=\"\"><div id=\"google_ads_iframe_/342026871/desktop_song_lyrics_sidebar2_0__container__\" style=\"border: 0pt none;\"><iframe id=\"google_ads_iframe_/342026871/desktop_song_lyrics_sidebar2_0\" title=\"3rd party ad content\" name=\"google_ads_iframe_/342026871/desktop_song_lyrics_sidebar2_0\" width=\"300\" height=\"250\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" srcdoc=\"\" style=\"border: 0px; vertical-align: bottom;\" data-google-container-id=\"4\" data-load-complete=\"true\"></iframe></div></div></div></div></div>"
    )

}