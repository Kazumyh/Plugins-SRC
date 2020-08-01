package tell.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TellMain extends JavaPlugin{
	
	@Override
	public void onLoad() {
	
		Bukkit.getConsoleSender().sendMessage("§a§l[TellKazumy] §ePlugin de Tell sendo carregado...  - Discord: Kazumyh^^#9361");
	
	}

	@Override
	public void onEnable() {
	
		Bukkit.getConsoleSender().sendMessage("§a§l[TellKazumy] §ePlugin de Tell carregado e habilitado...  - Discord: Kazumyh^^#9361");
		getCommand("tell").setExecutor(new TellCommand());
		getCommand("telloff").setExecutor(new TellOffCMD());
		getCommand("tellon").setExecutor(new TellOnCMD());
	}
	
	@Override
	public void onDisable() {
	
		Bukkit.getConsoleSender().sendMessage("§a§l[TellKazumy] §cPlugin de Tell desabilitado...  - Discord: Kazumyh^^#9361");
	
	}
	
}
