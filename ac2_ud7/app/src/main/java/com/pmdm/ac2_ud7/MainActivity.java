package com.pmdm.ac2_ud7;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Button btNotification;
    private PendingIntent pendingIntent;
    private static final String CHANNEL_ID = "NOTIFICACION";
    private static final int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNotification = findViewById(R.id.botonNtf);
        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                createNotification();
            }
        });

    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
            builder.setSmallIcon(R.drawable.ic_noti);
            builder.setContentTitle("AIRPLANE");
            builder.setContentText("Son las 9 y 11");
            builder.setColor(Color.BLUE);
            builder.setPriority(NotificationCompat.PRIORITY_HIGH);
            builder.setLights(Color.MAGENTA,100,100);
            builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
            builder.setDefaults(Notification.DEFAULT_SOUND);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }
}

        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("DEBUG", "onCreate ejecutado");

        String channelId = "mi_canal_id";
        String channelName = "Mi Canal";
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Verifica que el canal se crea
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            Log.d("DEBUG", "Canal de notificaciones creado");
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background) // Cambia a un icono genérico
                .setContentTitle("Título de prueba")
                .setContentText("Esto es una prueba")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Button btnNotificacion = findViewById(R.id.botonNtf);
        if (btnNotificacion == null) {
            Log.e("DEBUG", "El botón no se encontró en el layout");
        } else {
            btnNotificacion.setOnClickListener(v -> {
                Log.d("DEBUG", "Botón presionado");
                notificationManager.notify(1, builder.build());
                Log.d("DEBUG", "Notificación enviada");
            });
        }*/