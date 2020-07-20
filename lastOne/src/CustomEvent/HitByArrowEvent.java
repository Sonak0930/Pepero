package CustomEvent;


import java.io.File;

import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


 
	

public class HitByArrowEvent implements Listener {

	
	
	@EventHandler
	public void DamageHandler(EntityDamageByEntityEvent e)
	{
		
		if(e.getDamager() instanceof Arrow)
		{
			//엔티티를 타격한 대상 (여기서는 화살)
			Arrow projectile =  (Arrow) e.getDamager();
					
			//공격당한 엔티티
			LivingEntity hitentity = (LivingEntity)e.getEntity();
					
			//투사체를 발사한 플레이어 정보
			Player p= (Player) projectile.getShooter();
			
			
			if(hitentity.getFireTicks() > 0)
			{
				projectile.setDamage(2);
			}
			hitentity.setFireTicks(100);
			
			hitentity.setGlowing(true);
		}
		
		
		
	}
	
	@EventHandler
	public void BurningEventHandler(EntityDamageEvent e)
	{
		DamageCause cause = e.getCause();
		LivingEntity entity = (LivingEntity)e.getEntity();
		
		

			if(entity.isGlowing() && cause.equals(DamageCause.FIRE_TICK) )
			{
				
				double damage = entity.getHealth()*0.1;
				entity.damage(damage + entity.getHealth() * 0.1 + entity.getLastDamage());
				
				try {
					double health = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
					Bukkit.broadcastMessage(""+health);
					if(entity.getFireTicks() <= 20)
					{
							entity.setGlowing(false);
					}
				}
				
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
				}
				
			}
			
		
	}
	
}


	


