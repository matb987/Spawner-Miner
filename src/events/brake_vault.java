package events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class brake_vault implements Listener{


	//if block is Vault give player Vault block with data from block
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		//if block is spawner block give player spawner with data from block
		if (block.getType() == Material.VAULT) {
			ItemStack VAULT = new ItemStack(Material.VAULT, 1);
			BlockStateMeta bsm = (BlockStateMeta) VAULT.getItemMeta();
			CreatureSpawner cs = (CreatureSpawner) bsm.getBlockState();
			cs.setSpawnedType(((CreatureSpawner) block.getState()).getSpawnedType());
			bsm.setBlockState(cs);
			VAULT.setItemMeta(bsm);
			//give player spawner
			event.getPlayer().getInventory().addItem(VAULT);

		}
		
	}
	
	
}
