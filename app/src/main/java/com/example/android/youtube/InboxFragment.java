package com.example.android.youtube;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InboxFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager pager;
    private String[] titles = { "MESSAGES", "NOTIFICATIONS" };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        pager = view.findViewById(R.id.pager);
        FragmentManager fragmentManager = getFragmentManager();
        pager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                if (position == 0){
                    fragment = new MessagesFragment();
                }
                else {
                    fragment = new NotificationsFragment();
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        tabLayout = view.findViewById(R.id.inbox_tab);
        tabLayout.setupWithViewPager(pager);

        return view;
    }
}
