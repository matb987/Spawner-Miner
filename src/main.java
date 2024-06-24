import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import Bukkit.Metrics;
import events.brake_vault;
import events.spawner_brake;


public class main extends JavaPlugin {

	
	  public void onEnable() {
		  int pluginId = 22322; // <-- Replace with the id of your plugin!
	        Metrics metrics = new Metrics(this, pluginId);
		//register the config file
	    	FileConfiguration config = this.getConfig();
	    	config.addDefault("Spawner-drops", true);
	    	config.addDefault("Vault-drops", true);
	    	config.options().copyDefaults(true);
	    	saveConfig();
		  
		  //register events
	      //if Spawner-drops is true register spawner_brake
			if (config.getBoolean("Spawner-drops")) {
				getServer().getPluginManager().registerEvents(new spawner_brake(), this);
			}
		             //if Vault-drops is true register brake_vault
			if (config.getBoolean("Vault-drops")) {
				getServer().getPluginManager().registerEvents(new brake_vault(), this);
			}
	    	
	    	
	    	}
	    // Fired when plugin is disabled
	    @Override
	    public void onDisable() {

	    }
	    
	    
}
