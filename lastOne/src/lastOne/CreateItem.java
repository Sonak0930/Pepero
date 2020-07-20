package lastOne;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItem
{
	public static ItemStack createItem(String name, ChatColor color, Material material, String lore1, String lore2, String lore3, Boolean isSeal)
	{
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(color + name);
		if (isSeal)
		{
			if (lore1.equals(""))
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(버릴 수 없음)"));
			}
			else if (lore2.equals(""))
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(버릴 수 없음)", lore1));
			}
			else if (lore3.equals(""))
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(버릴 수 없음)", lore1, lore2));
			}
			else
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(버릴 수 없음)", lore1, lore2, lore3));
			}
		}
		
		
		
		else
		{
			if (lore1.equals(""))
			{
				//pass
			}
			else if(lore2.equals(""))
			{
				meta.setLore(Arrays.asList(lore1));
			}
			else if(lore3.equals(""))
			{
				meta.setLore(Arrays.asList(lore1, lore2));
			}
			else
			{
				meta.setLore(Arrays.asList(lore1, lore2, lore3));
			}
		}
		item.setItemMeta(meta);
		return item;
	}
}
