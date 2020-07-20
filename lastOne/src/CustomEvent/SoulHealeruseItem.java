package CustomEvent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import lastOne.CreateItem;
import lastOne.Main;
import lastOne.PlayerStatus;

public class SoulHealeruseItem implements Listener
{
	@EventHandler
	public void useItem(PlayerInteractEvent e)
	{
		if (Main.isStart)
		{
			Player p = e.getPlayer();
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(p.getName()))
				{
					if (p.getInventory().getItemInMainHand().equals(CreateItem.createItem("수확", ChatColor.BLUE, Material.BLAZE_ROD, "", "", "", true)))
					{
						if (ps.isWriteSkillTree().equals(true))
						{
							if (ps.getFirstSkill().equals(true))
							{
								
							}
							else
							{
								
							}
						}
						else
						{
							p.sendMessage("기술특성을 먼저 작성해주세요!");
						}
					}
					else if (p.getInventory().getItemInMainHand().equals(CreateItem.createItem("사령술", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", "", "", true)))
					{
						if (ps.isWriteSkillTree().equals(true))
						{
							if (ps.getSecondSkill().equals(true))
							{
								
							}
							else
							{
								
							}
						}
						else
						{
							p.sendMessage("기술특성을 먼저 작성해주세요!");
						}
					}
				}
			}
		}
	}
}
