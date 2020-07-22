package lastOne;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Skill_ButterflySupplantation  implements Listener {
	
	public void BSskill(PlayerInteractEvent e)
	{
		//�տ� �������� ��� �ִ� ��� Ȯ��.
				if (!e.getHand().equals(EquipmentSlot.HAND)) return;
				
				if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Butterflying FireWork")) return;
				//�÷��̾� üũ
				
				PlayerStatus playerStatus = null;
				for (PlayerStatus PS : Main.getPlayerInfoList())
				{
					if (PS.getPlayer().getName().equals(e.getPlayer().getName()))
					{
						//���� ���� �÷��̾� �������ͽ��� playerStatus�� ����.
						playerStatus = PS;		
					}
				}
				
				if (!playerStatus.isWriteSkillTree())
				{
					e.getPlayer().sendMessage("���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�!");
					return;
				}
				
				else
				{
					
					//�÷��̾�� velocityEvent�� �޾ƿͼ� �ٶ󺸴� ���� ����.
					Player p1 = e.getPlayer();
					PlayerVelocityEvent pve = new PlayerVelocityEvent(p1,p1.getVelocity());
					
					//���� �÷��̾ �ٶ󺸰� �ִ� ���������� ���͸� ������.
					Vector v1 = p1.getEyeLocation().getDirection();
					
					v1.add(v1);
					v1.add(v1);
					
					Projectile butterfly = e.getPlayer().launchProjectile(Skill_Chaos_Projectile.class, v1);
					butterfly.setGravity(false);
					
					Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable()
					{
						public void run()
						{
							butterfly.remove();
						}
					}, 100);
				}

	}

	
}


