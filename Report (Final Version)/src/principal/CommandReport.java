package principal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReport implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(args.length == 0) {
				p.sendMessage("§c§lERRO §fUtilize: /report <Jogador> <Motivo>");
				return true;
			}
			
			if(args.length > 0) {
				Player reportado = Bukkit.getPlayerExact(args[0]);
				if(reportado == null) {
					p.sendMessage("§c§lERRO §fEste jogador está offline.");
					return true;
				}
				String reportMotivo = "";
				for(int i = 1; i < args.length; i++) {
					reportMotivo = reportMotivo+args[i]+" ";
				}
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.hasPermission("staff.use")) {
						all.sendMessage(" ");
						all.sendMessage("§c§lREPORT NICK §f- "+p.getName());
						all.sendMessage("§c§lREPORT REPORTADO §f- "+reportado.getName());
						all.sendMessage("§c§lREPORT MOTIVO §f- "+reportMotivo);
						all.sendMessage(" ");
					}
					
					Bukkit.getConsoleSender().sendMessage(" ");
					Bukkit.getConsoleSender().sendMessage("§c§lREPORT NICK §f- "+p.getName());
					Bukkit.getConsoleSender().sendMessage("§c§lREPORT REPORTADO §f- "+reportado.getName());
					Bukkit.getConsoleSender().sendMessage("§c§lREPORT MOTIVO §f- "+reportMotivo);
					Bukkit.getConsoleSender().sendMessage(" ");
					
				}
				
				p.sendMessage("§aSeu report foi enviado para avaliação.");
				
			}
			
			
		}
		
		return false;
	}

}
