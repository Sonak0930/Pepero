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
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(���� �� ����)"));
			}
			else 
			{
				meta.setLore(Arrays.asList(ChatColor.DARK_RED + "(���� �� ����)", lore));
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
				//��Ʈ���� lore�� �޴´�.
				
				//lore�� \n�� �������� �������� �ɰ���.
				for (String s : lore.split("\n")) meta.setLore(Arrays.asList(s));
				
				
				//�ɰ� lore�� ��� ����Ʈ�� �ְ�, ���̸�ŭ �ݺ��� �·ξ �����Ѵ�.
				
			}
		}
		item.setItemMeta(meta);
		return item;
	}
}
