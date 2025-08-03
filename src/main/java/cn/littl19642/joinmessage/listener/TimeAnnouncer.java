package cn.littl19642.joinmessage.listener;

import cn.littl19642.joinmessage.JoinMessage;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeAnnouncer extends BukkitRunnable {

    @Override
    public void run() {
        LocalTime now = LocalTime.now();
        if (now.getMinute() == 0) { // 整点检查
            JoinMessage plugin = JoinMessage.getInstance();
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm"));
            
            String message = plugin.getConfig().getString("time-announce.message", "&a现在是北京时间: &6%time%")
                    .replace("%time%", time);
            
            // 广播整点消息
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.sendMessage(PlaceholderAPI.setPlaceholders(player, message));
            });
        }
    }
}
