package top.cs1.isesleep;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KissCommandExecutor implements CommandExecutor {
    private final IseSleep plugin;

    public KissCommandExecutor(IseSleep plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            Player target = plugin.getServer().getPlayer(args[0]);
            if (target != null) {
                executeParticleEffect(target);
                sender.sendMessage("§d你向 §b" + target.getName() + " §d发送了一个亲亲～");
                return true;
            }
            sender.sendMessage("§c目标玩家不存在或未在线！");
        }
        return false;
    }

    private void executeParticleEffect(Player target) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        target.getWorld().spawnParticle(Particle.HEART,
                                target.getLocation().add(0, 1, 0),
                                5, 0.5, 0.5, 0.5);
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    plugin.getLogger().warning("粒子效果执行异常: " + e.getMessage());
                }
            }
        }.runTaskAsynchronously(plugin);
    }
}