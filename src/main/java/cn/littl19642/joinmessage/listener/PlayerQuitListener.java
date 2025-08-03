package cn.littl19642.joinmessage.listener;

import cn.littl19642.joinmessage.JoinMessage;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        JoinMessage plugin = JoinMessage.getInstance();
        
        // 覆盖退出消息
        String quitMsg = plugin.getConfig().getString("messages.quit", "&e%player% 离开了游戏");
        quitMsg = PlaceholderAPI.setPlaceholders(player, quitMsg);
        e.setQuitMessage(quitMsg);
    }
}
