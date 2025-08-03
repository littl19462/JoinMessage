package cn.littl19642.joinmessage.listener;

import cn.littl19642.joinmessage.JoinMessage;
import cn.littl19642.joinmessage.util.HitokotoFetcher;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        JoinMessage plugin = JoinMessage.getInstance();
        
        // 覆盖加入消息
        String joinMsg = plugin.getConfig().getString("messages.join", "&e%player% 加入了游戏");
        joinMsg = PlaceholderAPI.setPlaceholders(player, joinMsg);
        e.setJoinMessage(joinMsg);
        
        // 发送一言
        if (plugin.getConfig().getBoolean("hitokoto.enabled", true)) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    String hitokoto = HitokotoFetcher.getHitokoto();
                    if (hitokoto != null) {
                        String formatted = PlaceholderAPI.setPlaceholders(player, 
                                plugin.getConfig().getString("messages.hitokoto", "&b今日一言: &f%hitokoto%")
                                        .replace("%hitokoto%", hitokoto));
                        player.sendMessage(formatted);
                    }
                }
            }.runTaskLater(plugin, plugin.getConfig().getInt("hitokoto.delay", 3) * 20L);
        }
    }
}
