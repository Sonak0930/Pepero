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
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
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


 
	

public class FireMagicianSKillEvent implements Listener {

	private PlayerStatus ps;
	private Projectile projectile;
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

		try
		{
			//��ƼƼ�� Ÿ���� ��� 
			projectile =   (Projectile) e.getDamager();
					
			//���ݴ��� ��ƼƼ
			hitentity = (LivingEntity)e.getEntity();
					
			//����ü�� �߻��� �÷��̾� ����
			p= (Player) projectile.getShooter();
			inven = p.getInventory();
		}
		
		catch(Exception ex)
		{
			
			return;
		}
			
			
	
			
			//�÷��̾� �������ͽ� ����Ʈ����, ���� �̺�Ʈ �߻� �÷��̾��� �������ͽ��� ������.
			// ������ �������� �ð��� O(1)�� �ҿ��.
			
			ps = Main.findPlayerStat(p);
			
		
		
			//�ı������� ����ü�� �ƴѰ�� ó������ ����.
			if(ps.getJob().equalsIgnoreCase("�ı� ������"))
			{
				DestroyingMagician();
			
			}

		
	}
	
	private void setWeapon()
	{
		try {
			isMA1 = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "ȥ��");
			isMH1 = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "��������");
			isMA2 = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "����");
			isMH2 =	p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "����������");
		}
		
		catch(Exception e)
		{
			p.sendMessage("FireMagician�� ���⸦ �޾ƿ��� ���߽��ϴ�");
		}
	}
	private void DestroyingMagician()
	{
		
		setWeapon();
		//��Ÿ�� �⺻�нú갡 ȥ���� ���
		if(isMA1)
		{
			
			hitentity.setFireTicks(100);
			hitentity.playEffect(EntityEffect.HURT);
			hitentity.playEffect(EntityEffect.LOVE_HEARTS);
			
		}
		
		//��Ÿ�� �⺻ �нú갡 ������ ���.
		else if(isMA2)
		{
			hitentity.setGlowing(true);
			hitentity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,60,1));
			
			//�̹� ���ο찡 ����� ����� ���
			try {
				boolean isSlowed = hitentity.getPotionEffect(PotionEffectType.SLOW).getType().equals(PotionEffectType.SLOW);
				double intel = ps.getIntelligence();
				if(isSlowed)
				{
					
					MagicalDamage magic = new MagicalDamage();
					magic.set_coefficient(0.35 + intel * 0.05);
				
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
					magic.set_coefficient(0.1 + intel* 0.03);
				
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
			if(!ps.getJob().contentEquals("�ı� ������")) return;
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
					//�÷��̾��� ��� �������ظ� ����
					PlayerStatus entityStat = Main.findPlayerStat((Player)entity);
					MagicalDefense = entityStat.getMagicalDefense();
					damage = entity.getHealth()*(0.03 + 0.0003*intel);
					damage = damage * (100-MagicalDefense)/	100;
					entity.damage(damage);
				}
				catch(Exception ex)
				{
					//�Ϲ� ������ ��� ��������
					damage = entity.getHealth()*(0.03 + 0.0003*intel);
					entity.damage(damage);
				}
				
				
				//���� ü�¿� ����� �������ظ�����.
				double lostHp = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()-entity.getHealth();
				
				entity.damage(lostHp*(Math.sqrt(intel)*0.01+0.1));
				
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
	
	@EventHandler
	public void EntityExplode(EntityExplodeEvent e)
	{
		if(!(p instanceof Player)) return;
		
		try {
			hitentity = (LivingEntity) e.getEntity();
		}
		
		catch(ClassCastException ex)
		{
			return;
		}
		
		
		MagicalDamage magic = new MagicalDamage();
	
		magic.setUser(p);
		magic.setEnemy(hitentity);
		magic.setPs();
	
		
		if(hitentity.isGlowing())
		{	
			magic.set_coefficient(0.07);
		}
		
		else magic.set_coefficient(0.04);
		magic.Damage();
	}
	
}


	


