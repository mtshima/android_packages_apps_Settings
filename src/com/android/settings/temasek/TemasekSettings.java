package com.android.settings.temasek;

import android.os.Bundle;
import android.content.res.Resources;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.R;
import android.provider.Settings;

public class TemasekSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String TAG = "TemasekSettings";

    private static final String KEY_HEADS_UP_SETTINGS = "heads_up_enabled";

    private Preference mHeadsUp;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.temasek_settings);

        mHeadsUp = findPreference(KEY_HEADS_UP_SETTINGS);
    }

    @Override
    public void onResume() {
        super.onResume();

        boolean headsUpEnabled = Settings.System.getInt(
                getContentResolver(), Settings.System.HEADS_UP_USER_ENABLED, Settings.System.HEADS_UP_USER_ON) != 0;
        mHeadsUp.setSummary(headsUpEnabled
                ? R.string.summary_heads_up_enabled : R.string.summary_heads_up_disabled);
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        return false;
    }
}
