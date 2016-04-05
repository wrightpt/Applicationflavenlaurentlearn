package com.example.c.applicationflavenlaurentlearn;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

import com.example.c.applicationflavenlaurentlearn.fragment.*;
import com.google.android.youtube.player.*;

/**
 * Created by Flavien Laurent (flavienlaurent.com) on 23/08/13.
 */
public class YoutubeActivity extends YouTubeBaseActivity {

    private YouTubePlayerView playerView;
    String API_KEY = "AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48";
    String VIDEO_ID = "WhnDvvNS8zQ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

       YoutubeFragment fragment = new YoutubeFragment();
         //YoutubeFragment ytfragment = YoutubeFragment.newInstance();
        android.app.FragmentManager manager = getFragmentManager();
       manager.beginTransaction()
                .replace(R.id.draggable_panel, fragment,"hey")
                .addToBackStack(null)
                .commit();

      //  playerView = (YouTubePlayerView)findViewById(R.id.player_view);
       // playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
         //   @Override
         //   public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

          //      if(!b){
             //       youTubePlayer.cueVideo(VIDEO_ID);

           // }}

         //   @Override
         //   public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

         //   }
      //  });

        //   YouTubeFragment1 fragment = (YouTubeFragment1) getFragmentManager().findFragmentById(R.id.fragment_youtube);
       // fragment.setVideoId("WhnDvvNS8zQ");

      // final FrameLayout frameLayout = (FrameLayout)findViewById(R.id.header);

       //  Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment);
       // final TextView viewHeader = (TextView) findViewById(R.id.header);
        final YoutubeLayout youtubeLayout = (YoutubeLayout) findViewById(R.id.dragLayout);
        final ListView listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // frameLayout.setText(listView.getAdapter().getItem(i).toString());
               youtubeLayout.setVisibility(View.VISIBLE);
                youtubeLayout.maximize();
            }
        });

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
               return 50;
            }

            @Override
            public String getItem(int i) {
             return "object" + i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View rView, ViewGroup viewGroup) {
                View view = rView;
                if (view == null) {
                    view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                }
                ((TextView) view.findViewById(android.R.id.text1)).setText(getItem(i));
                return view;
            }
        });
    }
}
