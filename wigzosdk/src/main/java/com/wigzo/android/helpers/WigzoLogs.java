package com.wigzo.android.helpers;

import android.util.Log;

public class WigzoLogs {
    public static final String WIGZO_SDK_TAG = "WigzoSDK";
    public static  boolean isDebug = false;

    public static void setIsDebug(boolean isDebug) {
        WigzoLogs.isDebug = isDebug;
    }

    public static void showWigzoLog(String tag, String message){
        if (isDebug) {
          if (tag != null && tag != "") {
              Log.i(tag, message);
          }else {
              Log.i(WIGZO_SDK_TAG, message);
          }
        }
    }
}
