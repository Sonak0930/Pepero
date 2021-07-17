package SkillUseEvent;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Damage.MagicalDamage;
import Damage.PhysicalDamage;
import Player.PlayerStatus;
import Projectile.Skill_Chaos_Projectile;
import lastOne.CreateItem;
import lastOne.Main;

public class ForestArcheruseItem implements Listener
{
	private LivingEntity entity;
	private Player p;
	private int range = 8;
	private PlayerStatus ps;
	private double power;
	private int durationSec = 12;
	private double previousPower;
	
	private enum previousSkill {active,hyper};
	private double backOffDistance = 5 ;
	
	private int stackCount = 0;
	private previousSkill previous;
	private int minCoefficient;
	private int maxCoefficient;
	private PhysicalDamage physic;
	
	private int PassiveDuration;
	private int initialAccuracy;
	
	
	private boolean isCoolDown = false;
	public static double pitch[] = {0.5,       0.529732,  0.56123,   0.594604,
									0.629961,  0.667420,  0.707107,  0.749154,  
									0.793701,  0.840896,  0.890899,  0.943874,  
									1,         1.059463,  1.122462,  1.189207,
									1.259921,  1.334840,  1.414214,  1.498307,
									1.587401,  1.681793,  1.781797,  1.887749,
									2};
	private static double harmony[] = {pitch[1],pitch[5],pitch[8],pitch[13],pitch[6],pitch[10],pitch[13],pitch[18],pitch[11],pitch[15],pitch[18],pitch[23]};
	
	
	public static double currentindex = 0;
	
	@EventHandler
	public void useItem(PlayerInteractEvent e)
	{
		p = e.getPlayer();
		ps = Main.findPlayerStat(p);
		power = ps.getPower();
		
		
	
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.GREEN+"Á¤¾Ç"))
			{
				
				entity = (LivingEntity) Main.getNearest(p, range);
				PhysicalDamage physic = new PhysicalDamage();
				physic.setUser(p);
				physic.setEnemy(entity);
				physic.setPs();
				
				MagicalDamage magic = new MagicalDamage();
				magic.setUser(p);
				magic.setEnemy(entity);
				magic.setPs();
				
				
				
				// 1~3 Level
				if(currentindex <4)
				{
					if(currentindex%4 == 0)
					{
						physic.set_coefficient(1);
						previousPower = ps.getPower();
					}
					
					else if(currentindex%4 == 1)
					{
						physic.set_coefficient(1.1);
					}
					
					else if(currentindex%4==2)
					{
						physic.set_coefficient(1.2);
					}
					
					else if(currentindex%4 == 3)
					{
						physic.set_coefficient(1.3);
						//p.getWorld().spawnParticle(Particle.BUBBLE_POP,physic.getEnemy().getLocation(),50,10,10,10,true);
					}
					
				
				}
				
				// 
				else if( currentindex >=4 && currentindex <8)
				{
					if(currentindex%4 == 0)
					{
						physic.set_coefficient(1);
						ps.setPower(power * 1.1);
					}
					
					else if(currentindex%4 == 1)
					{
						physic.set_coefficient(1.1);
						ps.setPower(power * 1.2);
						
					}
					
					else if(currentindex%4==2)
					{
						physic.set_coefficient(1.2);
						ps.setPower(power * 1.3);
					}
					
					else if(currentindex%4 == 3)
					{
						physic.set_coefficient(1.3);
						ps.setPower(power * 1.4);
						
						p.getWorld().strikeLightning(entity.getLocation());
						ps.setIntelligence(power);
						//p.getWorld().spawnParticle(Particle.BUBBLE_POP,physic.getEnemy().getLocation(),50,10,10,10,true);
						
						magic.Damage();
					}
						
						
				}
				
				else if(currentindex >=8 && currentindex <12)
				{
					if(currentindex == 8)
					{
						ps.setPower(previousPower);
						p.sendMessage("Power clear started");
						physic.set_coefficient(1);
						range++;
					}
					
					else if(currentindex%4 == 1)
					{
						physic.set_coefficient(1.1);
						range++;
						
						
					}
					
					else if(currentindex%4==2)
					{
						physic.set_coefficient(1.2);
						range++;
						
					}
					
					else if(currentindex%4 == 3)
					{
						//p.getWorld().spawnParticle(Particle.BUBBLE_POP,physic.getEnemy().getLocation(),50,10,10,10,true);
						
						physic.set_coefficient(1.3);
						range += 3;
						
					}
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*12,(int) (currentindex%4),true,true));
					
				}
			
				
				//p.getWorld().spawnParticle(Particle.BUBBLE_POP,physic.getEnemy().getLocation(),10,1,1,1,true);
				physic.Damage();
				p.sendMessage(""+physic.getDamage());
				float pit = (float) RotateHarmony();
				//ÇÑ ¹ÙÄû µ¹ ¶§¸¸.
				if(currentindex == 12)
				{
					currentindex = 0;
				}
				
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1,pit);
				
			}
			
			
			else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "Çª¸¥ ºÐ¼âÀÚ"))
			{
				
				physic = new PhysicalDamage();
				physic.setUser(p);
				
				physic.setPs();
				
				
				//launch projectile to the vector that player is looking.
				Vector v1 = p.getEyeLocation().getDirection();
						
				v1.add(v1);
				v1.add(v1);
				Arrow chaos = (Arrow) e.getPlayer().launchProjectile(Arrow.class, v1);
				chaos.setGravity(false);	
				
				
				
				previous = previousSkill.active;
				
				
				
			}
			
			else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE+"Çï¸®¿ì½º Çý¼º"))
			{
				
				physic = new PhysicalDamage();
				physic.setUser(p);
				
				physic.setPs();
				//ÇÃ·¹ÀÌ¾î¿Í velocityEvent¸¦ ¹Þ¾Æ¿Í¼­ ¹Ù¶óº¸´Â ¹æÇâ ¼³Á¤.
				Vector v1 = p.getEyeLocation().getDirection();
						
				v1.add(v1);
				v1.add(v1);
				Arrow chaos = (Arrow) e.getPlayer().launchProjectile(Arrow.class, v1);
				chaos.setGravity(true);
				
				previous = previousSkill.hyper;
			}
		}
	
	
	@EventHandler
	public void HitByArrow(EntityDamageEvent e)
	{
		//this secetion checks whether the event is about targeted event.
		if(!ps.getJob().contentEquals("½£ »ç³É²Û")) return;
		
		if(ps.getFirstSkill()) return;
		if(ps.getSecondSkill()) return;
		
		if(!p.getInventory().getItemInMainHand().getType().equals(Material.ENCHANTED_BOOK)) return;

		//ignore case that is not arrow.
		if(!e.getCause().equals(DamageCause.PROJECTILE)) return;
		if(isCoolDown) return;
		
		//critical section for not executing simultaneously.
		isCoolDown = true;
		entity = (LivingEntity) e.getEntity();
		
	
		physic.setEnemy(entity);
		
		//case 1 : active skill.
		if(previous == previousSkill.active)
		{
			physic.set_coefficient(1.0);
			physic.setEnemy((LivingEntity)e.getEntity());
			physic.Damage();
			
			physic.getEnemy().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,100,10));
			//caculate the vector towards enemy.
			//Location back = p.getLocation().subtract(physic.getEnemy().getLocation());
			
			//vector for push back a enemy.
			double theta = Math.asin(p.getLocation().getZ()/p.getLocation().toVector().length());
			//Vector backVector = back.toVector().normalize().multiply(backOffDistance).divide( back.toVector());
			//double z =physic.getEnemy().getLocation().toVector().getZ() * Math.cos(theta);
			//double x =physic.getEnemy().getLocation().toVector().getZ() * Math.sin(theta);
			
			Location back = new Location(p.getWorld(),3,0,3);
			Location direction = physic.getEnemy().getLocation().subtract(p.getLocation());
			Location teleport = physic.getEnemy().getLocation().add(direction.toVector().normalize().multiply(back.toVector()));
			physic.getEnemy().teleport(teleport);
			
			//p.playSound(physic.getEnemy().getLocation(), arg1, arg2, arg3);
			stackCount ++;
			if(stackCount == 0)
			{
				initialAccuracy = ps.getAccuracy();
			}
			
			else if(stackCount <= 10)
			{
				ps.setAccuracy((int)(ps.getAccuracy() * 1.02));
			}
			
			
			//change the state of isCoolDown to false so that next event can occur.
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("lastOne"), new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
						isCoolDown = false;
				}
				
			
			},(long) (3));
			
			//restore the initial Accuracy status.
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("lastOne"), new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
						ps.setAccuracy(initialAccuracy);
				}
				
			
			},(long) (20)*10);
		}
		
		//case2 : hyper skill
		else if(previous == previousSkill.hyper)
		{
			physic.set_coefficient(1.0);
			physic.setEnemy((LivingEntity)e.getEntity());
			
			Location distance = physic.getEnemy().getLocation().subtract(p.getLocation());
			
			
			//calculate the damage depending on the distance between player and target.
			if(distance.length() <= 5)
			{
				
			}
			
			else if(distance.length() <= 10)
			{
				physic.set_coefficient((1.2+ ps.getAccuracy()*0.005) + Math.random()*(ps.getAccuracy()*0.005+1));
			}
			
			else if(distance.length() <= 15)
			{
				if(Math.random() < 0.35)
				{
					physic.set_coefficient((1.5+ ps.getAccuracy()*0.075) + Math.random()*(ps.getAccuracy()*0.075+2.5));
				}
				
			}
			
			else if (distance.length() <= 19)
			{
				if(Math.random() < 0.75)
				{
					physic.set_coefficient((1.7+ ps.getAccuracy()*0.0125) + Math.random()*(ps.getAccuracy()*0.0125+3.5));
					
					
				}
				
				if(physic.getEnemy().getType().equals(EntityType.PLAYER))
				{
					// if entity type is player, reduce its physical defense.
					try {
						PlayerStatus enemyPs = Main.findPlayerStat(((Player)physic.getEnemy()));
						enemyPs.setPhysicalDefense(enemyPs.getPhysicalDefense() * (1.0-(0.15+ps.getAccuracy()*0.001+ Math.random()*(ps.getAccuracy()*0.001+0.2))));
					
					}
					
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				//for monster, give an additional damage 35%.
				else {
					physic.set_coefficient((1.5+ ps.getAccuracy()*0.0075) + Math.random()*(ps.getAccuracy()*0.025+2) + 0.35);
					
					
				}
			}
			
			else if (distance.length() >= 20)
			{
				physic.set_coefficient((2.5+ ps.getAccuracy()*0.025) + Math.random()*(ps.getAccuracy()*0.025+5.5));
				
			}
			
			if(stackCount >= 2)
			{
				physic.set_coefficient(physic.get_coefficient() * Math.sqrt(2.5+ ps.getAccuracy() * 0.01225));
			}
			
			//give the damage to enemy.
			physic.Damage();
			p.sendMessage(distance.length()+"m");
			//change the state of isCoolDown to false so that next event can occur.
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("lastOne"), new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
						isCoolDown = false;
				}
				
			
			},(long) (20*3));
			
			
		}
		
	}
	
	
		
		
	
	
	
	public static void clearCurrentNote()
	{
		currentindex =0;
	}
	double RotateHarmony()
	{
		currentindex++;
		return harmony[(int) (currentindex-1)];
		
		
	}
	
}



