package tell.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellCommand implements CommandExecutor{
	
	public static List<String> telloff = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§c§lTELL §fUtilize: /tell <Nome do Jogador> <Mensagem>");
				return true;
			}
			if(args.length > 0) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					p.sendMessage("§c§lTELL §fJogador offline");
					return true;
				}
				String mensagemTell = "";
				for(int i = 1; i < args.length; i++) {
					mensagemTell = mensagemTell+""+args[i]+" ";
				}
				
				if(telloff.contains(target.getName())) {
					p.sendMessage("§c§lTELL §fJogador está com o tell desativado.");
					return true;
				}else {
					target.sendMessage("§aMensagem de "+p.getName()+": "+mensagemTell);
					p.sendMessage("§aMensagem para "+target.getName()+": "+mensagemTell);
				}
				
			}
		}
		
		return false;
	}

}
