package events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class spawner_brake implements Listener {
	
	//listen for block break
	//if block is spawner
	//give player spawner
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		//if block is spawner block give player spawner with data from block
		if (block.getType() == Material.SPAWNER) {
			ItemStack testSpawner = new ItemStack(Material.SPAWNER, 1);
			BlockStateMeta bsm = (BlockStateMeta) testSpawner.getItemMeta();
			CreatureSpawner cs = (CreatureSpawner) bsm.getBlockState();
			cs.setSpawnedType(((CreatureSpawner) block.getState()).getSpawnedType());
			bsm.setBlockState(cs);
			testSpawner.setItemMeta(bsm);
			//give player spawner
			event.getPlayer().getInventory().addItem(testSpawner);

		}
		
	}

}
