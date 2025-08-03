package cn.littl19642.joinmessage;

import cn.littl19642.joinmessage.listener.PlayerJoinListener;
import cn.littl19642.joinmessage.listener.PlayerQuitListener;
import cn.littl19642.joinmessage.listener.TimeAnnouncer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinMessage extends JavaPlugin {

    private static JoinMessage instance;
    private FileConfiguration config;
    
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        config = getConfig();
        
        // 注册事件
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        
        // 启动整点报时任务
        if (config.getBoolean("time-announce.enabled", true)) {
            new TimeAnnouncer().runTaskTimer(this, 0, 1200); // 每分钟检查一次
        }
        
        getLogger().info("JoinMessage 已启用");
    }

    @Override
    public void onDisable() {
        getLogger().info("JoinMessage 已禁用");
    }

    public static JoinMessage getInstance() {
        return instance;
    }
}
