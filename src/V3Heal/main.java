package V3Heal;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{

	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
		System.out.println("[PaperHeal] Plugin wird geladen!");
		new Paper(this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getCommand("setlive").setExecutor(new setliveCMD());
		
		Paper.healamount = getConfig().getInt("Heal.Amount");
		System.out.println("[PaperHeal] Plugin erfolgreich geladen!");
	}
}
