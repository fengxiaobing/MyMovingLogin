package com.bing.mymovinglogin;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private CustomVideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    /**
     * 初始化
     */
    private void initView() {
        String url = "http://p1.pstatp.com/large/166200019850062839d3";
        String filePath = "/storage/emulated/0/Pictures/aaa.mp4";
        videoview = (CustomVideoView) findViewById(R.id.videoview);
       /* Glide.with(this)
                .load(R.mipmap.sport)
                .asGif()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(videoview);*/
      /*  Glide
                .with( this )
                .load( Uri.fromFile( new File( filePath ) ) )
                .into( videoview );*/
        videoview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.aaa));

        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
    }
}
