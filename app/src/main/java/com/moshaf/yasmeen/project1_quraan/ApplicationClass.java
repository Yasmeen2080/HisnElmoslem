package com.moshaf.yasmeen.project1_quraan;

import android.app.Application;

import com.onesignal.OneSignal;

/**
 * Created by Yasmeen on 7/4/2019.
 */

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
