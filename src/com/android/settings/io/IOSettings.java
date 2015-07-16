package com.android.settings.io;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.slim.NavigationSettings;
import com.android.settings.slim.PieControl;
import com.android.settings.slim.PieStyleSettings;
import com.android.settings.slim.PieButtonStyleSettings;
import com.android.settings.slim.PieTriggerSettings;
import com.android.settings.slim.InputMethodsSettings;
import com.android.settings.slim.NavBarButtonStyle;
import com.android.settings.slim.NavbarStyleDimenSettings;
import com.android.settings.slim.StatusBarClockStyle;
import com.android.settings.slim.StatusBar;
import com.android.settings.io.NavigationBarSettings;
import com.android.settings.slim.NavbarSettings;
import com.android.settings.slim.RecentPanel;
import com.android.settings.slim.QsSettings;
import com.android.settings.io.PowerMenuActions;
import com.android.settings.io.About;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;


import java.util.ArrayList;
import java.util.List;

public class IOSettings extends SettingsPreferenceFragment {

    PagerTabStrip mPagerTabStrip;
    ViewPager mViewPager;

    String titleString[];

    ViewGroup mContainer;

    static Bundle mSavedState;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContainer = container;

        View view = inflater.inflate(R.layout.io_settings, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mPagerTabStrip = (PagerTabStrip) view.findViewById(R.id.pagerTabStrip);
        mPagerTabStrip.setDrawFullUnderline(true);

        StatusBarAdapter StatusBarAdapter = new StatusBarAdapter(getFragmentManager());
        mViewPager.setAdapter(StatusBarAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // After confirming PreferenceScreen is available, we call super.
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle saveState) {
        super.onSaveInstanceState(saveState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    class StatusBarAdapter extends FragmentPagerAdapter {
        String titles[] = getTitles();
        private Fragment frags[] = new Fragment[titles.length];

        public StatusBarAdapter(FragmentManager fm) {
            super(fm);
            frags[0] = new StatusBar();
            frags[1] = new NavigationBarSettings();
            frags[2] = new QsSettings();
            frags[3] = new RecentPanel();
            frags[4] = new PowerMenuActions();
            frags[5] = new About();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return frags[position];
        }

        @Override
        public int getCount() {
            return frags.length;
        }
    }

    private String[] getTitles() {
        String titleString[];
        titleString = new String[]{
                    getString(R.string.status_bar_title),
                    getString(R.string.navigation_bar_title),
                    getString(R.string.title_qs_tiles),
                    getString(R.string.recent_panel_category),
                    getString(R.string.power_menu_title),
                    getString(R.string.about_io)};
        return titleString;
    }
}
