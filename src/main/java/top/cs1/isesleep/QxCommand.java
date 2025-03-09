package top.cs1.isesleep;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QxCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                target.setOp(false);
                sender.sendMessage("§c已移除玩家 §b" + target.getName() + " §c的管理员权限！");
                return true;
            } else {
                sender.sendMessage("§c玩家不存在或未在线！");
            }
        }
        return false;
    }
}