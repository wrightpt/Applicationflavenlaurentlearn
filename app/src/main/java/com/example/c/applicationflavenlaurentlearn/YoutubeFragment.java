package com.example.c.applicationflavenlaurentlearn;

/**
 * Created by c on 4/4/16.
 */

import android.annotation.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import com.google.android.youtube.player.*;
import com.google.android.youtube.player.YouTubePlayer.*;


public class YoutubeFragment extends android.app.Fragment implements OnInitializedListener {
    // API キー
    private static final String API_KEY = "AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48";

    // YouTubeのビデオID
    private static String VIDEO_ID = "WhnDvvNS8zQ";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_youtube, container, false);


        // YouTubeフラグメントインスタンスを取得
        Log.d("initialize1", "initialize1");
        YouTubePlayerFragment youTubePlayerFragment = YouTubePlayerFragment.newInstance();

        // レイアウトにYouTubeフラグメントを追加
        android.app.FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
       transaction.add(R.id.header, youTubePlayerFragment).commit();

        // YouTubeフラグメントのプレーヤーを初期化する
        Log.d("initialize", "initialize");
        youTubePlayerFragment.initialize(API_KEY,this);

                //new OnInitializedListener() {

  /*          // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(PlayerStyle.MINIMAL);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });
*/

        return rootView;

    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {

            youTubePlayer.setPlayerStyle(PlayerStyle.MINIMAL);
            youTubePlayer.loadVideo(VIDEO_ID);
            youTubePlayer.play();

        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        String errorMessage = youTubeInitializationResult.toString();
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
        Log.d("errorMessage:", errorMessage);

    }
}