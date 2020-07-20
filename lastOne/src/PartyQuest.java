import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import lastOne.CreateItem;

public class PartyQuest extends JavaPlugin implements Listener {

	@Override
	public void onEnable()
	{
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	private Inventory inven;
	private Inventory commercial;
	private Inventory party;
	private Inventory event;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("quest"))
		{
			Player p = (Player)sender;
			inven = Bukkit.createInventory(null, 27, "PartyQuest");
			
			inven.setItem(13,new ItemStack(Material.RED_MUSHROOM_BLOCK)); 
			inven.setItem(11,new ItemStack(Material.CHORUS_FLOWER));
			inven.setItem(15, new ItemStack(Material.HONEYCOMB_BLOCK));
			p.openInventory(inven);
			
		}
		
		return false;
	}
	
	@EventHandler
	public void Inventory(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		InventoryView inview = e.getView();
		if(!inview.getTitle().equals("PartyQuest")) return;
		
		p.sendMessage(""+e.getCurrentItem().getType());
		if(e.getCurrentItem().getType() == Material.RED_MUSHROOM_BLOCK)
		{
			//clickable but not movable..
			e.setCancelled(true);
			p.closeInventory();
			
			CreateItem wheat = new CreateItem();
			ItemStack wheatstack = wheat.createItem("우리밀 64개", ChatColor.WHITE, Material.WHEAT, "우리밀은 늘 환영이랍니다. ", "밀가루 빼빼로의 재료", "", false);
			commercial =  Bukkit.createInventory(null, 81, "Commercial");
			commercial.setItem(10, wheatstack);
			
			p.openInventory(commercial);
		}
		
		if(e.getCurrentItem().getType() == Material.APPLE)
		{
			e.setCancelled(true);
			p.setFoodLevel(20);
			p.sendMessage("I'm full..");
			p.closeInventory();
		}
		
		if(e.getCurrentItem().getType() == Material.BONE)
		{
			e.setCancelled(true);
			p.setHealth(0);
			p.sendMessage("Oops");
			p.closeInventory();
		}
		
		
	}
}
