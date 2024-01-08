package com.wigzo.android.pushmanager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.wigzo.android.helpers.WigzoLogs;
import com.wigzo.android.tasks.FCMMapper;

public class WigzoNotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        WigzoLogs.showWigzoLog(WigzoLogs.WIGZO_SDK_TAG, "onMessageReceived" + remoteMessage);
        WigzoNotificationHandler.handleNotification(remoteMessage);
    }
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        FCMMapper fcmMapper = new FCMMapper(token);
        fcmMapper.push();
    }



}
