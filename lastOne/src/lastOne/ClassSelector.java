package lastOne;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class ClassSelector implements Listener
{
	public static void openClassSelectorGUI(Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 27, "직업 선택");

		inv.setItem(10, CreateItem.createItem("돌격 기사", ChatColor.RED, Material.RED_CONCRETE, "", "", "", false));
		inv.setItem(12, CreateItem.createItem("파괴 마법사", ChatColor.GOLD, Material.YELLOW_CONCRETE, "", "", "", false));
		inv.setItem(14, CreateItem.createItem("숲 사냥꾼", ChatColor.GREEN, Material.GREEN_CONCRETE, "", "", "", false));
		inv.setItem(16, CreateItem.createItem("영혼 치유사", ChatColor.BLUE, Material.BLUE_CONCRETE, "", "", "", false));
		inv.setItem(26, CreateItem.createItem("보류", ChatColor.WHITE, Material.BARRIER, "", "", "", false));
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void SelectedClass(InventoryClickEvent e)
	{	
		InventoryView invV = e.getView();
		
		if (!invV.getTitle().equals("직업 선택")) return;
		
		Player p = (Player) e.getWhoClicked();
		p.getInventory().clear();
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "돌격 기사"))
		{
			e.setCancelled(true);
			Main.GameJoinList.add(p);
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "돌격 기사", false, false, false, 0.7, 1.0, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 당신은" + ChatColor.RED + " '돌격 기사'" + ChatColor.GRAY + "를 선택하였습니다.");
			p.getInventory().addItem(CreateItem.createItem("돌격 기사의 갑옷파편", ChatColor.RED, Material.PRISMARINE_SHARD, "", "", "", true));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GREEN + " 최후의 1인에 참가가 완료되었습니다!");
			
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "파괴 마법사"))
		{
			e.setCancelled(true);
			Main.GameJoinList.add(p);
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "파괴 마법사", false, false, false, 1.0, 0.7, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 당신은" + ChatColor.GOLD + " '파괴 마법사'" + ChatColor.GRAY + "를 선택하였습니다.");
			p.getInventory().addItem(CreateItem.createItem("파괴 마법사의 마법기운", ChatColor.YELLOW, Material.QUARTZ, "", "", "", true));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GREEN + " 최후의 1인에 참가가 완료되었습니다!");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "숲 사냥꾼"))
		{
			e.setCancelled(true);
			Main.GameJoinList.add(p);
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "숲 사냥꾼", false, false, false, 1.0, 1.0, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 당신은" + ChatColor.GREEN + " '숲 사냥꾼'" + ChatColor.GRAY + "을 선택하였습니다.");
			p.getInventory().addItem(CreateItem.createItem("숲 사냥꾼의 화살깃털", ChatColor.GREEN, Material.FEATHER, "", "", "", true));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GREEN + " 최후의 1인에 참가가 완료되었습니다!");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "영혼 치유사"))
		{
			e.setCancelled(true);
			Main.GameJoinList.add(p);
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "영혼 치유사", false, false, false, 0.85, 0.85, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 당신은" + ChatColor.BLUE + " '영혼 치유사'" + ChatColor.GRAY + "를 선택하였습니다.");
			p.getInventory().addItem(CreateItem.createItem("영혼 치유사의 주술도구", ChatColor.BLUE, Material.NETHER_STAR, "", "", "", true));
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GREEN + " 최후의 1인에 참가가 완료되었습니다!");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "취소"))
		{
			e.setCancelled(true);
			p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 선택을 취소하였습니다.");
		}
		else
		{
			e.setCancelled(true);
		}
		p.closeInventory();
		 
	}
}
