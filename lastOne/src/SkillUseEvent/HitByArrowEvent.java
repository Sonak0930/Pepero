package SkillUseEvent;


import java.io.File;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lastOne.Main;
import lastOne.PlayerStatus;


 
	

public class HitByArrowEvent implements Listener {

	private PlayerStatus ps;

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
			PlayerInventory inven = p.getInventory();
			
			
			
			//플레이어 스테이터스 리스트에서, 현재 이벤트 발생 플레이어의 스테이터스를 가져옴.
			// 정보를 가져오는 시간은 O(1)이 소요됨.
			
			ArrayList<PlayerStatus> playerlist = Main.getPlayerInfoList();
			
			
			for (PlayerStatus stat : playerlist)
			{
				if(stat.getPlayer().getName() == p.getName())
				{
					ps = stat;
					break;
				}
			}
		
			//스타일 기본패시브가 혼돈인 경우
			if(ps.getFirstSkill())
			{
				hitentity.setFireTicks(100);
				hitentity.setGlowing(true);
				hitentity.playEffect(EntityEffect.HURT);
				hitentity.playEffect(EntityEffect.LOVE_HEARTS);
				if(hitentity.getFireTicks() > 0)
				{
					projectile.setDamage(2);
				}
				
			}
			
			//스타일 기본 패시브가 음파인 경우.
			else
			{
				
			}
			
		}
		
		
		
	}
	
	private void getPlayerInfoList() {
		// TODO Auto-generated method stub
		
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


	


