package com.example.myapplication

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.high.setOnClickListener{
            val notification=NotificationCompat.Builder(this,app().CHANNEL_ID1)
            notification.setContentTitle(binding.notificationtitle.text.toString())
            notification.setContentText(binding.notificationcontent.text.toString())
            notification.setSmallIcon(R.drawable.notification)
            val intent=Intent(this,MyIntentService::class.java)
//            val intent=Intent(this,broadcast::class.java)
//            val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("DATA_REC",binding.notificationcontent.text.toString())
            val pendingintent=PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
//            val pendingintent=PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
//            val pendingintent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            notification.setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setColor(Color.CYAN)
                .setContentIntent(pendingintent)
                .addAction(R.drawable.notification,"back",null)
                .addAction(R.drawable.notification,"play",pendingintent)
                .addAction(R.drawable.notification,"next",null)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()
            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())
        }
        binding.low.setOnClickListener{
            val notification=NotificationCompat.Builder(this,app().CHANNEL_ID2)
            notification.setContentTitle(binding.notificationtitle.text.toString())
            notification.setContentText(binding.notificationcontent.text.toString())
            notification.setSmallIcon(R.drawable.notification)
            notification.setPriority(NotificationManager.IMPORTANCE_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.CYAN)
                .addAction(R.drawable.notification,"back",null)
                .addAction(R.drawable.notification,"play",null)
                .addAction(R.drawable.notification,"next",null)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()
            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2,notification.build())
        }
    }
}