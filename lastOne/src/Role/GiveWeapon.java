package Role;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import lastOne.CreateItem;
import lastOne.Main;

public class GiveWeapon
{
	public void giveItem(Player p)
	{
		if (p.getInventory().contains(CreateItem.createItem("돌격 기사의 갑옷파편", ChatColor.RED, Material.PRISMARINE_SHARD, "",true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(0));
			p.getInventory().addItem(Main.AllitemList.get(1));
			p.getInventory().addItem(CreateItem.createItem("돌격 기사 - 기술특성 책", ChatColor.RED, Material.BOOK, "",  true));
			//스킬트리 열고,
		}
		else if (p.getInventory().contains(CreateItem.createItem("파괴 마법사의 마법기운", ChatColor.YELLOW, Material.QUARTZ, "", true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(4));
			p.getInventory().addItem(Main.AllitemList.get(5));
			p.getInventory().addItem(CreateItem.createItem("파괴 마법사 - 기술특성 책", ChatColor.YELLOW, Material.BOOK, "",  true));
			//스킬트리 열고,
		}
		else if (p.getInventory().contains(CreateItem.createItem("숲 사냥꾼의 화살깃털", ChatColor.GREEN, Material.FEATHER, "", true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(8));
			p.getInventory().addItem(Main.AllitemList.get(9));
			p.getInventory().addItem(CreateItem.createItem("숲 사냥꾼 - 기술특성 책", ChatColor.GREEN, Material.BOOK, "",  true));
			//스킬트리 열고,
		}
		else if (p.getInventory().contains(CreateItem.createItem("영혼 치유사의 주술도구", ChatColor.BLUE, Material.NETHER_STAR, "",true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(12));
			p.getInventory().addItem(Main.AllitemList.get(13));
			p.getInventory().addItem(CreateItem.createItem("영혼 치유사 - 기술특성 책", ChatColor.BLUE, Material.BOOK, "",  true));
			//스킬트리 열고,
		}
		
	}
}
