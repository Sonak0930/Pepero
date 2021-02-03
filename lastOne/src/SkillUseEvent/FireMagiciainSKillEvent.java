package SkillUseEvent;


import java.io.File;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import Damage.MagicalDamage;
import Player.PlayerStatus;
import lastOne.Main;
import net.md_5.bungee.api.ChatColor;


 
	

public class FireMagiciainSKillEvent implements Listener {

	private PlayerStatus ps;
	private Arrow projectile;
	LivingEntity hitentity;
	private static Player p;
	
	private ItemStack weapon;
	PlayerInventory inven;
	
	private boolean isMA1;
	private boolean isMH1;
	private boolean isMA2;
	private boolean isMH2;

	public static void setDamager(Player player)
	{
		p = player;
	}
	@EventHandler
	public void DamageHandler(EntityDamageByEntityEvent e)
	{
		
		if(e.getDamager() instanceof Arrow)
		{
			
			//엔티티를 타격한 대상 (여기서는 화살)
			projectile =  (Arrow) e.getDamager();
					
			//공격당한 엔티티
			hitentity = (LivingEntity)e.getEntity();
					
			//투사체를 발사한 플레이어 정보
			p= (Player) projectile.getShooter();
			inven = p.getInventory();
			
	
			
			//플레이어 스테이터스 리스트에서, 현재 이벤트 발생 플레이어의 스테이터스를 가져옴.
			// 정보를 가져오는 시간은 O(1)이 소요됨.
			
			ps = Main.findPlayerStat(p);
			
		
		
			//파괴마법사 화살이 아닌경우 처리하지 않음.
			if(ps.getJob().equalsIgnoreCase("파괴 마법사"))
			{
				DestroyingMagician();
			
			}
			
			
			
			
		}
		
		
		
	}
	
	private void setWeapon()
	{
		try {
			isMA1 = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "혼돈");
			isMH1 = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "나비폭죽");
			isMA2 = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "음파");
			isMH2 =	p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "광속입자파");
		}
		
		catch(Exception e)
		{
			p.sendMessage("FireMagician의 무기를 받아오지 못했습니다");
		}
	}
	private void DestroyingMagician()
	{
		
		setWeapon();
		//스타일 기본패시브가 혼돈인 경우
		if(isMA1)
		{
			
			hitentity.setFireTicks(100);
			hitentity.playEffect(EntityEffect.HURT);
			hitentity.playEffect(EntityEffect.LOVE_HEARTS);
			if(hitentity.getFireTicks() > 0)
			{
				projectile.setDamage(2);
			}
			
		}
		
		//스타일 기본 패시브가 음파인 경우.
		else if(isMA2)
		{
			hitentity.setGlowing(true);
			hitentity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,60,1));
			
			//이미 슬로우가 적용된 대상일 경우
			try {
				boolean isSlowed = hitentity.getPotionEffect(PotionEffectType.SLOW).getType().equals(PotionEffectType.SLOW);
				double intel = ps.getIntelligence();
				if(isSlowed)
				{
					
					MagicalDamage magic = new MagicalDamage();
					magic.set_coefficient(0.2 + intel * 0.05);
				
					magic.setUser(p);
					magic.setEnemy(hitentity);
					magic.setPs();
				
					magic.Damage();
					
					double damage = magic.getDamage();
					int amplifier = (int) (damage/100);
					if(amplifier == 0 ) amplifier = 1;
					p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,60,amplifier));
				
				}
				
				else
				{
					
					MagicalDamage magic = new MagicalDamage();
					magic.set_coefficient(0.1 + intel * 0.03);
				
					magic.setUser(p);
					magic.setEnemy(hitentity);
					magic.setPs();
				
					magic.Damage();
				}
			}
			
			catch(Exception ex)
			{
				
			}
		}
		
		else if(isMH2)
		{
			
		}
	}
	
	
	private void getPlayerInfoList() {
		// TODO Auto-generated method stub
		
	}

	@EventHandler
	public void BurningEventHandler(EntityDamageEvent e)
	{
		DamageCause cause;
		LivingEntity entity;
		double MagicalDefense;
		double damage;
		try
		{
			cause = e.getCause();
			entity = (LivingEntity)e.getEntity();
			if(!ps.getJob().contentEquals("파괴 마법사")) return;
		}
		
		catch(Exception ex)
		{
			return;
		}
		
		
		
		if(!ps.getFirstSkill()) return;
		

			if(cause.equals(DamageCause.FIRE_TICK) )
			{
				
				PlayerStatus ps = Main.findPlayerStat(p);
				double intel = ps.getIntelligence();
				
				MagicalDamage magic = new MagicalDamage();
				
				
				try {
					//플레이어일 경우 마법피해를 입힘
					PlayerStatus entityStat = Main.findPlayerStat((Player)entity);
					MagicalDefense = entityStat.getMagicalDefense();
					damage = entity.getHealth()*(0.03 + 0.0003*intel);
					damage = damage * (100-MagicalDefense)/	100;
					entity.damage(damage);
				}
				catch(Exception ex)
				{
					//일반 몬스터일 경우 고정피해
					damage = entity.getHealth()*(0.03 + 0.0003*intel);
					entity.damage(damage);
				}
				
				
				//잃은 체력에 비례한 고정피해를입힘.
				double lostHp = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()-entity.getHealth();
				
				entity.damage(lostHp);
				
				try {
					
					
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


	


