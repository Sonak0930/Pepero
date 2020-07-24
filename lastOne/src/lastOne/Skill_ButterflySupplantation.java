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
		//손에 아이템을 들고 있는 경우 확인.
				if (!e.getHand().equals(EquipmentSlot.HAND)) return;
				
				if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "나비 폭죽")) return;
				//플레이어 체크
				
				PlayerStatus playerStatus = null;
				for (PlayerStatus PS : Main.getPlayerInfoList())
				{
					if (PS.getPlayer().getName().equals(e.getPlayer().getName()))
					{
						//현재 나의 플레이어 스테이터스를 playerStatus에 저장.
						playerStatus = PS;		
					}
				}
				
				if (!playerStatus.isWriteSkillTree())
				{
					e.getPlayer().sendMessage("기술특성을 작성해야 기술을 사용할 수 있습니다!");
					return;
				}
				
				else
				{
					
					//플레이어와 velocityEvent를 받아와서 바라보는 방향 설정.
					Player p1 = e.getPlayer();
					PlayerVelocityEvent pve = new PlayerVelocityEvent(p1,p1.getVelocity());
					
					//현재 플레이어가 바라보고 있는 방향으로의 벡터를 가져옴.
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


