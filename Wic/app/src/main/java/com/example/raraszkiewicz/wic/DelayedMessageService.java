package com.example.raraszkiewicz.wic;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class DelayedMessageService extends IntentService {

    private Object sync = new Object();
    public static final String EXTRA_MESSAGE = "message";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this)
        {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                Log.e(getClass().getSimpleName(), e.toString());
            }
            String text = intent.getStringExtra(EXTRA_MESSAGE);
            showText(text);
        }
    }

    private Handler handler;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }

    private void showText(String text)
    {
        final String message = "Message: "+text;
        Log.v(getClass().getSimpleName(), message);
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
        sendNotification(message);
    }

    private PendingIntent createPendingIntent()
    {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(MainActivity.class);
        taskStackBuilder.addNextIntent(mainActivityIntent);
        return taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private Notification buildNotification(String text)
    {
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(text)
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)
                .setContentIntent(createPendingIntent())
                .build();
        return notification;
    }

    private void sendNotification(String text)
    {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, buildNotification(text));
    }

    private static final int NOTIFICATION_ID = 5334;
}
