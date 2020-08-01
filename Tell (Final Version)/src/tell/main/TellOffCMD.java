package tell.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellOffCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
				TellCommand.telloff.add(p.getName());
				p.sendMessage("§c§lTELL §fTell desativado com sucesso!");
		}
		
		return false;
	}

}
