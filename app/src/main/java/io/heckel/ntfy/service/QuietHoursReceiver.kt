package io.heckel.ntfy.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import io.heckel.ntfy.util.Log

class QuietHoursReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("ntfyQuietHours", "免打扰结束，闹钟唤醒 SubscriberService")
        val serviceIntent = Intent(context, SubscriberService::class.java)
        try {
            ContextCompat.startForegroundService(context, serviceIntent)
        } catch (e: Exception) {
            Log.e("ntfyQuietHours", "启动服务失败", e)
        }
    }
}
