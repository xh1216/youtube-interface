package com.example.android.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class VideoActivity extends AppCompatActivity {

    private RecyclerView mVideoRecyclerView;
    private VideoAdapter mVideoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mVideoRecyclerView = findViewById(R.id.video_recycler_view);
        mVideoRecyclerView.setLayoutManager(new LinearLayoutManager(VideoActivity.this, LinearLayoutManager.HORIZONTAL, false));

        updateUI();
    }

    private void updateUI() {
        VideoList videoList = VideoList.get(VideoActivity.this);
        List<Video> videos = videoList.getVideos();

        mVideoAdapter = new VideoAdapter(videos);
        mVideoRecyclerView.setAdapter(mVideoAdapter);
    }

    private class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Video mVideo;

        public VideoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_suggest_video, parent, false));
            itemView.setOnClickListener(this);
        }

        public void bind(Video video) {
            mVideo = video;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(VideoActivity.this, VideoActivity.class);
            startActivity(intent);
        }
    }

    private class VideoAdapter extends RecyclerView.Adapter<VideoHolder> {

        private List<Video> mVideos;

        public VideoAdapter(List<Video> videos) {
            mVideos = videos;
        }

        @Override
        public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(VideoActivity.this);

            return new VideoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(VideoHolder holder, int position) {
            Video video = mVideos.get(position);
            holder.bind(video);
        }

        @Override
        public int getItemCount() {
            return mVideos.size();
        }
    }
}
