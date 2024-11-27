package com.pmdm.ac2_ud7;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
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
        }
    }

}