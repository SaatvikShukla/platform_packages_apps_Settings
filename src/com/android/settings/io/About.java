/*
 * Copyright (C) 2015 crDroid Android
 * Copyright (C) 2015 InfinitiveOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.io;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class About extends SettingsPreferenceFragment {

    public static final String TAG = "About";

    Preference mSiteUrl;
    Preference mSourceUrl;
    Preference mGerritUrl;
    Preference mGoogleUrl;
    Preference mDownloadUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.io_about);

        mSiteUrl = findPreference("io_website");
        mSourceUrl = findPreference("io_source");
        mGerritUrl = findPreference("io_gerrit");
        mGoogleUrl = findPreference("io_google_plus");
        mDownloadUrl = findPreference("io_download");

    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mSiteUrl) {
            launchUrl("http://aogp-devs.com/");
        } else if (preference == mSourceUrl) {
            launchUrl("https://github.com/Infinitive-OS");
        } else if (preference == mGerritUrl) {
            launchUrl("http://gerrit.aogp-devs.com");
        } else if (preference == mGoogleUrl) {
            launchUrl("https://plus.google.com/communities/106007367793741615251");
        } else if (preference == mDownloadUrl) {
            launchUrl("http://download.aogp-devs.com");
        }

        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent donate = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(donate);
    }
}
