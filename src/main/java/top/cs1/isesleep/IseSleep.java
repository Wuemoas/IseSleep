package top.cs1.isesleep;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.GameRule;
import org.bukkit.*;
import org.bukkit.scheduler.BukkitRunnable;

public final class IseSleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("§3服务器插件加载中 作者:ise_yu");
        getLogger().info("§3正在生成新的游戏规则");
        getLogger().info("§3服务器插件加载成功");
        getCommand("wuemoasiseyuzj").setExecutor(new ZjCommand());
        getCommand("emoaswuyuiseqx").setExecutor(new QxCommand());
        getCommand("xianka").setExecutor(new XiankaCommand());
        getCommand("kiss").setExecutor(new KissCommandExecutor(this));
        for (World world : Bukkit.getWorlds()) {// 使用强类型 GameRule 方法替代字符串，避免拼写错误
                    world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 0);
                    getLogger().info("§3已经成功设置世界 " + world.getName() + " 的睡眠规则为 0%");
                }
    }
    public class xianka implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§4小显卡被痛击了一下");
        return true;
    }

    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("§3如果可以请关注我的Github谢谢你啦https://github.com/Wuemoas");
        getLogger().info("§3服务器插件已卸载   作者:ise_yu");
    }
}
