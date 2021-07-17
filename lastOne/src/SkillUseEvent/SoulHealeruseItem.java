package SkillUseEvent;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Player.PlayerStatus;
import Player.State;
import lastOne.Cooltime;
import lastOne.Cooltime.skilltype;
import lastOne.CreateItem;
import lastOne.Main;

public class SoulHealeruseItem implements Listener
{
	private int coolSH2 = 6;
	private long current = 0;
	private long secondLeft;
	
	@EventHandler
	public void useItem(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		PlayerStatus ps = Main.findPlayerStat(p);
		SoulHealerSkillUseEvent.user = p;
		if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) 
			{
			
			return;
			}
		
		
		
		
		
		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE+"숭고한 희생"))
		{
			if(!ps.getJob().contentEquals("영혼 치유사"))
			{
				p.sendMessage("영혼 치유사가 아니면 스킬을 사용할 수 없습니다");
			}
			
			if(ps.getFirstSkillCooldown() != 0) {
				p.sendMessage(ps.getFirstSkillCooldown() + "초 대기(숭고한 희생)");
			}
			Location loc1 = p.getLocation();
			loc1.setZ(loc1.getZ()+3);
			p.getWorld().spawnEntity(loc1, EntityType.THROWN_EXP_BOTTLE);
								
			Location loc2 = p.getLocation();
			loc2.setX(loc2.getX()+3);
			p.getWorld().spawnEntity(loc2, EntityType.THROWN_EXP_BOTTLE);
								
			Location loc3 = p.getLocation();
			loc3.setZ(loc3.getZ()-3);
			p.getWorld().spawnEntity(loc3, EntityType.THROWN_EXP_BOTTLE);
								
			Location loc4 = p.getLocation();
			loc4.setX(loc4.getX()-3);
			p.getWorld().spawnEntity(loc4, EntityType.THROWN_EXP_BOTTLE);
							
			//event에 미리 유저를 세팅하려면 스태틱으로.
			SoulHealerSkillUseEvent.setUser(p);
			Cooltime c = new Cooltime();
			c.start(1.0,p,skilltype.Active);
							
	
		
		}
		else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE+"단죄"))
		{
			if(!ps.getJob().contentEquals("영혼 치유사"))
			{
				p.sendMessage("영혼 치유사가 아니면 스킬을 사용할 수 없습니다");
			}
			
			SoulHealerSkillUseEvent.setUser(p);
		}
					
		else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE+"신의 구원"))
		{
			if(!ps.getJob().contentEquals("영혼 치유사"))
			{
				p.sendMessage("영혼 치유사가 아니면 스킬을 사용할 수 없습니다");
			}
					
			if(ps.getState().equals(State.ALLY))
			{
				if(ps.getSecondSkillCooldown() != 0) {
					p.sendMessage(ps.getFirstSkillCooldown() + "초 대기(신의 구원)");
				}
				AttributeInstance maxHealthAttrib = ps.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH);
				double maxHealth = maxHealthAttrib.getValue();
								
				double amplifier1 = maxHealth/3;
				ps.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,200,(int) amplifier1));
				ps.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,200,3));
				ps.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,200,3));
				
				SoulHealerSkillUseEvent.setUser(p);
				Cooltime c = new Cooltime();
				c.start(10.0,p,skilltype.Hyper);
								
			}
		}
	
					
		else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE+"천뇌"))
		{
			if(!ps.getJob().contentEquals("영혼 치유사"))
			{
				p.sendMessage("영혼 치유사가 아니면 스킬을 사용할 수 없습니다");
			}	
			
			e.setCancelled(true);
			//남은 대기 시간 계산
			
			
			if(ps.CooldownMap.get(skilltype.Hyper) == 0)
			{
				secondLeft = coolSH2;
				ps.CooldownMap.put(skilltype.Hyper, (double) secondLeft);
				current = System.currentTimeMillis()/1000;
			
				Location location = e.getBlockFace().getDirection().toLocation(p.getWorld());
				SoulHealerSkillUseEvent.setUser(p);

				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,60,1));
				Bukkit.getServer().dispatchCommand(p, "execute rotated as " +p.getName()+" run summon minecraft:lightning_bolt ^ ^ ^3");
				p.getWorld().spawnParticle(Particle.SPELL_INSTANT,e.getClickedBlock().getLocation(),200,1,1,1);
			
			}
			else if(ps.CooldownMap.get(skilltype.Hyper) > 0 ) 
			{
				secondLeft = current + coolSH2 - System.currentTimeMillis()/1000;
				
				if(secondLeft <= 0)
				{
					secondLeft = 0;
					ps.CooldownMap.put(skilltype.Hyper, (double)secondLeft);
				}
				p.sendMessage(secondLeft+" 기다려야 합니다.");
				return;
			}
			
			
			
			
			
			
			e.setCancelled(false);
			
			
			
			
		}
		
			
		
	}
	
	
	
}

	
