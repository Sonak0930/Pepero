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

public class DestroyMagicianuseItem implements Listener
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
					if (p.getInventory().getItemInMainHand().equals(CreateItem.createItem("ȥ��", ChatColor.GOLD, Material.BLAZE_ROD, "", "", "", true)))
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
							p.sendMessage("���Ư���� ���� �ۼ����ּ���!");
						}
					}
					else if (p.getInventory().getItemInMainHand().equals(CreateItem.createItem("�����", ChatColor.GOLD, Material.ENCHANTED_BOOK, "", "", "", true)))
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
							p.sendMessage("���Ư���� ���� �ۼ����ּ���!");
						}
					}
				}
			}
		}
	}
}
