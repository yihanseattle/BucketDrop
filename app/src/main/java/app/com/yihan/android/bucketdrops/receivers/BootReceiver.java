package app.com.yihan.android.bucketdrops.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import app.com.yihan.android.bucketdrops.extras.Util;

public class BootReceiver extends BroadcastReceiver {
    public static final String TAG="VIVZ";
    public BootReceiver() {
        Log.d(TAG, "BootReceiver: ");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        Util.scheduleAlarm(context);
    }
}
