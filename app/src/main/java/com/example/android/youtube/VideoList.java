package com.example.android.youtube;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class VideoList {
    private static VideoList sVideoList;
    private List<Video> mVideos;

    public static VideoList get(Context context) {
        if (sVideoList == null) {
            sVideoList = new VideoList(context);
        }
        return sVideoList;
    }

    private VideoList(Context context) {
        mVideos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Video video = new Video();
            video.setTitle("Video #" + i);
            mVideos.add(video);
        }
    }

    public List<Video> getVideos() {
        return mVideos;
    }

}
