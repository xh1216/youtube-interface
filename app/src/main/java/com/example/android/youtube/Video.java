package com.example.android.youtube;

public class Video {

    private String mTitle, mAuthor, mTime;
    private int mViews;

    public Video() {}

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
