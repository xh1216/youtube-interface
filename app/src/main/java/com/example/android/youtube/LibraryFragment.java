package com.example.android.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class LibraryFragment extends Fragment {

    private RecyclerView mVideoRecyclerView;
    private LibraryFragment.VideoAdapter mVideoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_library, container, false);
        mVideoRecyclerView = view.findViewById(R.id.video_recycler_view);
        mVideoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        updateUI();

        return view;
    }

    private void updateUI() {
        VideoList videoList = VideoList.get(getActivity());
        List<Video> videos = videoList.getVideos();

        mVideoAdapter = new LibraryFragment.VideoAdapter(videos);
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
            Intent intent = new Intent(getActivity(), VideoActivity.class);
            startActivity(intent);
        }
    }

    private class VideoAdapter extends RecyclerView.Adapter<LibraryFragment.VideoHolder> {

        private List<Video> mVideos;

        public VideoAdapter(List<Video> videos) {
            mVideos = videos;
        }

        @Override
        public LibraryFragment.VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new LibraryFragment.VideoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(LibraryFragment.VideoHolder holder, int position) {
            Video video = mVideos.get(position);
            holder.bind(video);
        }

        @Override
        public int getItemCount() {
            return mVideos.size();
        }
    }
}
