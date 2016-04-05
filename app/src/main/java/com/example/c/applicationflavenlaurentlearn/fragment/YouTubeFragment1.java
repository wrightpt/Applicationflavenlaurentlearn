package com.example.c.applicationflavenlaurentlearn.fragment;

import android.os.*;
import android.widget.*;

//import com.eden.youtubesample.*;
import com.example.c.applicationflavenlaurentlearn.*;
import com.google.android.youtube.player.*;

/***********************************************************************************
 * The MIT License (MIT)

 * Copyright (c) 2015 Scott Cooper

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ***********************************************************************************/

/**
 * A sample implementation of a fragment extending YouTubePlayerFragment.
 * This will take care of most of the work necessary to load and play a video
 */
public class YouTubeFragment1 extends YouTubePlayerFragment {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    private static final String KEY_VIDEO_ID = "WhnDvvNS8zQ";

    private String mVideoId;

    //Empty constructor
    public YouTubeFragment1() {
    }

    /**
     * Returns a new instance of this Fragment
     *
     * @param videoId The ID of the video to play
     */
    public static YouTubeFragment1 newInstance(final String videoId) {
        final YouTubeFragment1 youTubeFragment = new YouTubeFragment1();
        final Bundle bundle = new Bundle();
        bundle.putString(KEY_VIDEO_ID, videoId);
        youTubeFragment.setArguments(bundle);
        return youTubeFragment;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        final Bundle arguments = getArguments();

        if (bundle != null && bundle.containsKey(KEY_VIDEO_ID)) {
            mVideoId = bundle.getString(KEY_VIDEO_ID);
        } else if (arguments != null && arguments.containsKey(KEY_VIDEO_ID)) {
            mVideoId = arguments.getString(KEY_VIDEO_ID);
        }

        initialize("AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (mVideoId != null) {
                    if (b) {
                        youTubePlayer.play();
                    } else {
                        youTubePlayer.loadVideo(mVideoId);
                    }
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                if (youTubeInitializationResult.isUserRecoverableError()) {
                    youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
                } else {
                    //Handle the failure
                    Toast.makeText(getActivity(), "failure", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Set the video id and initialize the player
     * This can be used when including the Fragment in an XML layout
     * @param videoId The ID of the video to play
     */
    public void setVideoId(final String videoId) {
        mVideoId = videoId;
        initialize("AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (mVideoId != null) {
                    if (b) {
                        youTubePlayer.play();
                    } else {
                        youTubePlayer.loadVideo(mVideoId);
                    }
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                if (youTubeInitializationResult.isUserRecoverableError()) {
                    youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
                } else {
                    //Handle the failure
                    Toast.makeText(getActivity(), "failure", Toast.LENGTH_LONG).show();
                }
            }
        });

            }



   // @Override
   // public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean restored) {

     //   if (mVideoId != null) {
     //       if (restored) {
       //         youTubePlayer.play();
       //     } else {
      //          youTubePlayer.loadVideo(mVideoId);
      //      }
     //   }
  //  }

    //@Override
  //  public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
    //    if (youTubeInitializationResult.isUserRecoverableError()) {
    //        youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
    //    } else {
            //Handle the failure
    //       Toast.makeText(getActivity(), "failure", Toast.LENGTH_LONG).show();
      //  }
   // }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(KEY_VIDEO_ID, mVideoId);
    }
}
