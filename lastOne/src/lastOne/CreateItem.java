package lastOne;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItem
{
	public static ItemStack createItem(String name, ChatColor color, Material material, String lore, Boolean isSeal)
	{
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(color + name);
		
		if (isSeal)
		{
			if (lore.equals(""))
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(버릴 수 없음)"));
			}
			else 
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(버릴 수 없음)", lore));
			}
			
		}
		
		
		
		else
		{
			if (lore.equals(""))
			{
				//pass
			}
			else
			{
				//스트링을 lore로 받는다.
				
				//lore를 \n을 기준으로 여러개로 쪼갠다.
				for (String s : lore.split("\n")) meta.setLore(Arrays.asList(s));
				
				
				//쪼갠 lore를 어레이 리스트에 넣고, 길이만큼 반복해 셋로어를 실행한다.
				
			}
		}
		item.setItemMeta(meta);
		return item;
	}
}
