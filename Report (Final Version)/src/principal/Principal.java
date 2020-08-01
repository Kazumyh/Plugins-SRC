package principal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin{
	
	public static Configs con;
	public static Configs conf;
	
	@Override
	public void onLoad() {
		
		Bukkit.getConsoleSender().sendMessage("§a§l[ReportKazumy] §ePlugin de Report sendo carregado...  - Discord: Kazumyh^^#9361");
		
	}
	
	@Override
	public void onEnable() {
	
		conf = new Configs("tempo.yml", this);
		con = new Configs("mensagens.yml", this);
		conf.saveDefaultConfig();
		con.saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage("§a§l[ReportKazumy] §ePlugin de Report carregado e habilitado!!!  - Discord: Kazumyh^^#9361");
		getCommand("report").setExecutor(new CommandReport());
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage("\n"+con.getString("Mensagem_fly").replace("&", "§"));
					
				}
				Bukkit.getConsoleSender().sendMessage("\n"+con.getString("Mensagem_fly").replace("&", "§"));
			}
		}, 480 * 20, 20 * conf.getInt("Tempo_Mensagem_Reach_Segundos"));
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage("\n"+con.getString("Mensagem_reach").replace("&", "§"));
					
				}
				Bukkit.getConsoleSender().sendMessage("\n"+con.getString("Mensagem_reach").replace("&", "§"));
			}
		}, 240 * 20, 20 * conf.getInt("Tempo_Mensagem_Fly_Segundos"));
	
	}
	
	@Override
	public void onDisable() {

		Bukkit.getConsoleSender().sendMessage("§c§l[ReportKazumy] §cPlugin de Report desabilitado!!!  - Discord: Kazumyh^^#9361");
	
	}

}
