package tell.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellOnCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(TellCommand.telloff.contains(p.getName())) {
				TellCommand.telloff.remove(p.getName());
				p.sendMessage("§a§lTELL §fTell ativado com sucesso");
			}
			
		}
		
		return false;
	}

}
