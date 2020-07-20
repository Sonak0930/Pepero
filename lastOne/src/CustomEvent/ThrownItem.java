package CustomEvent;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ThrownItem implements Listener{
	
	@EventHandler
	public void isDropItem(PlayerDropItemEvent e)
	{
		if (e.getItemDrop().getItemStack().getItemMeta().getLore().get(0).equals(ChatColor.DARK_RED + "(버릴 수 없음)"))
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void isDragItem(InventoryClickEvent e)
	{
		if (e.getCurrentItem().getItemMeta().getLore().get(0).equals(ChatColor.DARK_RED + "(버릴 수 없음)"))
		{
			e.setCancelled(true);
		}
	}
}
