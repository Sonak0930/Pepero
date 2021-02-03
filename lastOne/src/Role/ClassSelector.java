package Role;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import Player.PlayerStatus;
import lastOne.CreateItem;
import lastOne.Main;

public class ClassSelector implements Listener
{
	public static void openClassSelectorGUI(Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 27, "���� ����");

		inv.setItem(10, CreateItem.createItem("���� ���", ChatColor.RED, Material.RED_CONCRETE, "", false));
		inv.setItem(12, CreateItem.createItem("�ı� ������", ChatColor.GOLD, Material.YELLOW_CONCRETE, "",  false));
		inv.setItem(14, CreateItem.createItem("�� ��ɲ�", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false));
		inv.setItem(16, CreateItem.createItem("��ȥ ġ����", ChatColor.BLUE, Material.BLUE_CONCRETE, "", false));
		inv.setItem(26, CreateItem.createItem("����", ChatColor.WHITE, Material.BARRIER, "",  false));
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void SelectedClass(InventoryClickEvent e)
	{	
		InventoryView invV = e.getView();
		
		if (!invV.getTitle().equals("���� ����")) return;
		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();
		p.getInventory().clear();
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "���� ���"))
		{
			e.setCancelled(true);
			
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "���� ���", false, false, false, 0.7, 1.0, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �����" + ChatColor.RED + " '���� ���'" + ChatColor.GRAY + "�� �����Ͽ����ϴ�.");
			p.getInventory().addItem(CreateItem.createItem("���� ����� ��������", ChatColor.RED, Material.PRISMARINE_SHARD, "",  true));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GREEN + " ������ 1�ο� ������ �Ϸ�Ǿ����ϴ�!");
			
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "�ı� ������"))
		{
			e.setCancelled(true);
		
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "�ı� ������", false, false, false, 1.0, 0.7, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �����" + ChatColor.GOLD + " '�ı� ������'" + ChatColor.GRAY + "�� �����Ͽ����ϴ�.");
			p.getInventory().addItem(CreateItem.createItem("�ı� �������� �������", ChatColor.YELLOW, Material.QUARTZ, "", true));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GREEN + " ������ 1�ο� ������ �Ϸ�Ǿ����ϴ�!");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "�� ��ɲ�"))
		{
			e.setCancelled(true);
			
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "�� ��ɲ�", false, false, false, 1.0, 1.0, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �����" + ChatColor.GREEN + " '�� ��ɲ�'" + ChatColor.GRAY + "�� �����Ͽ����ϴ�.");
			p.getInventory().addItem(CreateItem.createItem("�� ��ɲ��� ȭ�����", ChatColor.GREEN, Material.FEATHER, "", true));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GREEN + " ������ 1�ο� ������ �Ϸ�Ǿ����ϴ�!");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "��ȥ ġ����"))
		{
			e.setCancelled(true);
			
			Main.GamePlayerInfoList.add(new PlayerStatus(p, "��ȥ ġ����", false, false, false, 0.85, 0.85, 0, 0));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �����" + ChatColor.BLUE + " '��ȥ ġ����'" + ChatColor.GRAY + "�� �����Ͽ����ϴ�.");
			p.getInventory().addItem(CreateItem.createItem("��ȥ ġ������ �ּ�����", ChatColor.BLUE, Material.NETHER_STAR, "",  true));
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GREEN + " ������ 1�ο� ������ �Ϸ�Ǿ����ϴ�!");
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "���"))
		{
			e.setCancelled(true);
			p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " ������ ����Ͽ����ϴ�.");
		}
		else
		{
			e.setCancelled(true);
		}
		p.closeInventory();
		 
	}
}
