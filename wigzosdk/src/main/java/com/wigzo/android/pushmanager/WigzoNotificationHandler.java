package com.wigzo.android.pushmanager;

import android.app.Notification;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.wigzo.android.base.WigzoApplication;
import com.wigzo.android.helpers.NotificationBuilder;
import com.wigzo.android.helpers.WigzoLogs;
import com.wigzo.android.tasks.NotificationRecieved;

import org.json.JSONException;
import org.json.JSONObject;

class WigzoNotificationHandler {
     static void handleNotification(RemoteMessage message) {
        message.getNotification().getTitle();
         WigzoLogs.showWigzoLog(WigzoLogs.WIGZO_SDK_TAG, "Message received: " + message.getNotification().getBody());
         if(message.getData().size() > 0) {
            WigzoLogs.showWigzoLog(WigzoLogs.WIGZO_SDK_TAG, "Message data payload: " + message.getData());
         String pushType =    getType(message.getData().get("type"));  NotificationRecieved notificationRecieved = new NotificationRecieved();
            NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(WigzoApplication.getAppContext(), String.valueOf(1221));
             try {
                 NotificationBuilder.notificationBuilder(message.getData(), notificationBuilder);
             } catch (JSONException e) {
                 WigzoLogs.showWigzoLog(WigzoLogs.WIGZO_SDK_TAG,e.getMessage());
                 e.printStackTrace();
             }
         }
    }

      static String getType(String message) {
          String pushType = "push";
         try{
             JSONObject jsonObject = new JSONObject(message);
             String typeValue = jsonObject.getString("type");
             pushType = jsonObject.getString("pushType");
             WigzoLogs.showWigzoLog(WigzoLogs.WIGZO_SDK_TAG, "Push Type: " + pushType + " Type: " + typeValue);
         }catch (Exception e) {

         }
        return pushType;
    }


}
