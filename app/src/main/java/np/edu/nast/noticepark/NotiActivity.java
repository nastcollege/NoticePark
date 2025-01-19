package np.edu.nast.noticepark;

import android.app.Notification;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        EditText etTitle = findViewById(R.id.etTitle);
        EditText etDetail = findViewById(R.id.etDetail);
        Button btnOne = findViewById(R.id.btnCh1);
        Button btnTwo = findViewById(R.id.btnCh2);


        btnOne.setOnClickListener(view -> {
            Notification notification = new
                    NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_1_ID)
                    .setContentTitle(etTitle.getText().toString())
                    .setTicker("one")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText(etDetail.getText().toString())
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    android.Manifest.permission.POST_NOTIFICATIONS) !=
                    PackageManager.PERMISSION_GRANTED) {
                //code for request new permission
                return;
            }
            notificationManager.notify(1, notification);
        });

        btnTwo.setOnClickListener(view -> {
            Notification notification2 = new
                    NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_2_ID)
                    .setContentTitle(etTitle.getText().toString())
                    .setTicker("two")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText(etDetail.getText().toString())
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    android.Manifest.permission.POST_NOTIFICATIONS) !=
                    PackageManager.PERMISSION_GRANTED) {
                return;
            }
            notificationManager.notify(2, notification2);
        });
    }
}