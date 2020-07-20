package lastOne;

import java.util.ArrayList;



import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import CustomEvent.DestroyMagicianuseItem;
import CustomEvent.HitByArrowEvent;
import CustomEvent.EntityDeath;
import CustomEvent.ForestArcheruseItem;
import CustomEvent.PlayerQuit;
import CustomEvent.SkillTreeSelect;
import CustomEvent.SoulHealeruseItem;
import CustomEvent.ThrownItem;


public class Main extends JavaPlugin implements Listener{
	
	public static ArrayList<PlayerStatus> GamePlayerInfoList = new ArrayList<PlayerStatus>();
	public static ArrayList<Player> GameJoinList = new ArrayList<Player>();
	public static ArrayList<Player> deathPlayerList = new ArrayList<Player>();
	public static ArrayList<ItemStack> AllitemList = new ArrayList<ItemStack>();
	public static ArrayList<LivingEntity> AttackKnightLightning = new ArrayList<LivingEntity>();
	public static boolean isStart = false;
	
	
	
	public static ArrayList<PlayerStatus> getPlayerInfoList ()
	{
		return GamePlayerInfoList;
	}
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		System.out.println("***������ 1�� ����***");
		Bukkit.getPluginManager().registerEvents(new ThrownItem(), this);
		Bukkit.getPluginManager().registerEvents(new ClassSelector(), this);
		Bukkit.getPluginManager().registerEvents(new DestroyMagicianuseItem(), this);
		Bukkit.getPluginManager().registerEvents(new ForestArcheruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new SoulHealeruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
		Bukkit.getPluginManager().registerEvents(new SkillTreeSelect(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeath(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new HitByArrowEvent(), this);
		
		AllitemList.add(CreateItem.createItem("ĥ���", ChatColor.RED, Material.DIAMOND_SWORD, "", "", "", true));
		AllitemList.add(CreateItem.createItem("ǥ���ı�", ChatColor.RED, Material.ENCHANTED_BOOK, "", "", "", true));
		AllitemList.add(CreateItem.createItem("ȥ��", ChatColor.GOLD, Material.BLAZE_ROD, "", "", "", true));
		AllitemList.add(CreateItem.createItem("�����", ChatColor.GOLD, Material.ENCHANTED_BOOK, "", "", "", true));
		AllitemList.add(CreateItem.createItem("�ӻ�", ChatColor.GREEN, Material.CROSSBOW, "", "", "", true));
		AllitemList.add(CreateItem.createItem("�������", ChatColor.GREEN, Material.ENCHANTED_BOOK, "", "", "", true));
		AllitemList.add(CreateItem.createItem("��Ȯ", ChatColor.BLUE, Material.BLAZE_ROD, "", "", "", true));
		AllitemList.add(CreateItem.createItem("��ɼ�", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", "", "", true));
		AllitemList.add(CreateItem.createItem("Butterflying FireWork", ChatColor.DARK_PURPLE, Material.BRAIN_CORAL_FAN, ChatColor.DARK_AQUA+"Progressive Active Skill",ChatColor.AQUA+ "��ó�� ������ ���� ������ ���� ���ظ� ������. ", ChatColor.AQUA+"����� ������ ��� ������ ��󿡰� 2/3�� ���ظ� ������.", true));
	}
	
	@Override
	public void onDisable() {
//		 TODO Auto-generated method stub
		System.out.println("������ 1�� ����");
	}
	
	
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
	{
		if(command.getName().equalsIgnoreCase("lastone"))
		{
			if (args.length == 0)
			{
				sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �ɼ��� �Է��ּ���.");
				sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " ����) /lastone <�ɼ�>");
				sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " ���� ������ �ɼ� : join | left | start | reset | list");
			}
			else
			{
				if (args[0].equalsIgnoreCase("join"))
				{
					if (sender instanceof Player)
					{
						Player p = (Player) sender;
						for (Player tp : GameJoinList)
						{
							if (tp.equals(p))
							{
								p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �̹� ���ӿ� �����Ͽ����ϴ�!");
								return true;
							}
						}
						
						if (isStart)
						{
							p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �̹� ������ ���� ���Դϴ�. ���� ���� ������ ���� �� ���� ��ٷ��ּ���.");
							return false;
						}
						p.getInventory().clear();
						ClassSelector.openClassSelectorGUI(p);
						p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.LIGHT_PURPLE + " ������ ���ؼ� ������ �������ּ���.");
					}
					else
					{
						sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �� �ɼ��� Ŀ�ǵ� â���� �� �� �����ϴ�! �÷��̾ �õ����ּ���.");
					}
				}
				else if (args[0].equalsIgnoreCase("start"))
				{
					if (GameJoinList.size() >= 1)
					{
						if (isStart)
						{
							sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �̹� ������ ���� ���Դϴ�. ���� ���� ������ ���� �� ���� ��ٷ��ּ���.");
							return false;
						}
						sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �غ����� ���! ��ٷ��ּ���. �����մϴ�.");
						isStart = true;
						for (Player tp : GameJoinList)
						{
							GiveWeapon giveItem = new GiveWeapon();
							giveItem.giveItem(tp);
						}
						//�̺κ��뿡�� ��������� TP
					}
					else
					{
						sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �÷��̾ 2(1)���̻� �����ؾ� ���� �� �� �ֽ��ϴ�.");
					}
				}
				else if (args[0].equalsIgnoreCase("left"))
				{
					if (sender instanceof Player)
					{
						Player p = (Player) sender;
						for (Player tp : GameJoinList)
						{
							if (tp.equals(p))
							{
								GameJoinList.remove(p);
								p.getInventory().clear();
								p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.RED + " ���� ���� ��Ұ� �Ϸ�Ǿ����ϴ�.");
								return true;
							}
						}
						p.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " ����� ������1�ο� �������� �ʾҽ��ϴ�.");
					}
					else
					{
						sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �� �ɼ��� Ŀ�ǵ� â���� �� �� �����ϴ�! �÷��̾ �õ����ּ���.");
					}
				}
				else if (args[0].equalsIgnoreCase("reset"))
				{
					isStart = false;
					GameJoinList.clear();
					GamePlayerInfoList.clear();
					sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GREEN + " �÷��̾� ����Ʈ �ʱ�ȭ.");
				}
				else if (args[0].equalsIgnoreCase("list"))
				{
					int index = 0;
					sender.sendMessage(ChatColor.DARK_GRAY + "-----������ �÷��̾� ����Ʈ-----");
					for (Player tp : GameJoinList)
					{
						index += 1;
						sender.sendMessage(ChatColor.GREEN + " " + index + "] " + ChatColor.LIGHT_PURPLE + tp.getName());
					}
					sender.sendMessage(ChatColor.DARK_GRAY + "-------------------------");
				}
				else if (args[0].equalsIgnoreCase("tree"))
				{
					for (PlayerStatus ps : GamePlayerInfoList)
					{
						sender.sendMessage(ps.getPlayer().getName() + ", " + ps.getJob() + ", " + ps.getFirstSkill().toString() + ", " + ps.getSecondSkill().toString() + ", " + ps.isWriteSkillTree());
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �� �� ���� �ɼ��Դϴ�.");
					sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " ���� ������ �ɼ� : join | left | start | clear | list");
				}
			}
		}
		
		
		
		if (command.getName().equalsIgnoreCase("reset"))
		{
			isStart = false;
			GameJoinList.clear();
			GamePlayerInfoList.clear();
		}
		return true;
	}
	
	
	
	//���⼭���ʹ� �� ������ ��������ڵ�
	
	
	// ���ݱ��

	@EventHandler
	public void damage(EntityDamageByEntityEvent e)
	{
		if (!(e.getDamager().getType().equals(EntityType.PLAYER))) return;
		
		try
		{
			if (!((LivingEntity) e.getEntity() instanceof LivingEntity)) return;
		}
		catch(Exception e1)
		{
			return;
		}
		
		Player Damager = (Player) e.getDamager();
		PlayerStatus DamagerStatus = null;
		
		LivingEntity Victim = (LivingEntity) e.getEntity();
		PlayerStatus VictimStatus = null; //default
		
		for (PlayerStatus PS : GamePlayerInfoList)
		{
			if (PS.getPlayer().getName().equals(Victim.getName()))
			{
				VictimStatus = PS;
			}
			
			if (PS.getPlayer().getName().equals(Damager.getName()))
			{
				DamagerStatus = PS;
			}
		}
		
		if (!Damager.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "ĥ���")) return;
			
		if (!isStart) return;
		
		if (!DamagerStatus.isWriteSkillTree())
		{
			e.setCancelled(true);
			Damager.sendMessage("���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�!");
			return;
		}
		
		
		
		
		
		
		
		if (DamagerStatus.getFirstSkill())
		{
			//�˱�

			if (VictimStatus == null)
			{
				Victim.damage(4);
			}
			else
			{
				Victim.damage(4 * VictimStatus.getPhysicsDefensive());
			}
			
			int random = (int) (Math.random() * 10);
			if (random > 0) return;
			AttackKnightLightning.add(Victim);
			if (Victim.getType().equals(EntityType.PLAYER)) Victim.sendMessage("����� " + Damager.getName() + "(���ݱ��)���� �������ϴ�!");
			Damager.sendMessage(Victim.getName() + "���� ǥ���� ������ϴ�!");

			Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable()
					{
						public void run()
						{
							if(Victim.isDead())
							{
								return;
							}
							Victim.getWorld().strikeLightning(Victim.getLocation());
							AttackKnightLightning.remove(Victim);
						}
					}, 200);
			
			return;
		}
		else if (!DamagerStatus.getFirstSkill())
		{
			//����
			
			if (VictimStatus == null)
			{
				Victim.damage(2);
			}
			else
			{
				Victim.damage(2 * VictimStatus.getPhysicsDefensive());
			}
			
			
			int random = (int) (Math.random() * 2);
			if (random == 0) return;
			AttackKnightLightning.add(Victim);
			if (Victim.getType().equals(EntityType.PLAYER)) Victim.sendMessage("����� " + Damager.getName() + "(���ݱ��)���� �������ϴ�!");
			Damager.sendMessage(Victim.getName() + "���� ǥ���� ������ϴ�!");
			
			Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable()
					{
						public void run()
						{
							if(Victim.isDead())
							{
								return;
							}
							Victim.getWorld().strikeLightning(Victim.getLocation());
							AttackKnightLightning.remove(Victim);
						}
					}, 200);
			
			return;
		}
	}
	
	
	@EventHandler
	public void attackknightUseItem(PlayerInteractEvent e)
	{
		if (!e.getHand().equals(EquipmentSlot.HAND)) return;
			
		PlayerStatus playerStatus = null;
		if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "ǥ���ı�")) return;
		
		if (!isStart) return;
		
		
		for (PlayerStatus PS : GamePlayerInfoList)
		{
			if (!PS.isWriteSkillTree())
			{
				e.getPlayer().sendMessage("���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�!");
				return;
			}
			else
			{
				playerStatus = PS;
				break;
			}
		}
		
		if (AttackKnightLightning.size() == 0)
		{
			e.getPlayer().sendMessage("ǥ���� ���� ���� �����ϴ�!");
			return;
		}
		
		if (playerStatus.getSecondSkill())
		{
			//�ͷ�
			double temp = 0;
			LivingEntity tempPlayer = null;
			for (LivingEntity LE : AttackKnightLightning)
			{
				double Coor = 0;
				
				Coor += Math.abs(LE.getLocation().getX() - e.getPlayer().getLocation().getX());
				Coor += Math.abs(LE.getLocation().getY() - e.getPlayer().getLocation().getY());
				Coor += Math.abs(LE.getLocation().getZ() - e.getPlayer().getLocation().getZ());
				if (Coor >= temp)
				{
					temp = Coor;
					tempPlayer = LE;
				}
			}
			
			e.getPlayer().sendMessage(tempPlayer.getName() + "���� �����մϴ�!");
			e.getPlayer().teleport(tempPlayer);
			
			return;
		}
		else
		{
			//����
			e.getPlayer().sendMessage("ǥ���� ���� ���� �̵��ӵ��� ����ϴ�!");
			for (LivingEntity LE : AttackKnightLightning)
			{
				LE.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 2, false, false, true));
			}
			return;
		}
	}
	
	// �ı�������

	@EventHandler
	public void magicianUseItem(PlayerInteractEvent e)
	{
		
		//�տ� �������� ��� �ִ� ��� Ȯ��.
		if (e.getHand().equals(EquipmentSlot.HAND)) 
		{
			if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "ȥ��")) return;
			//�÷��̾� üũ
			
			PlayerStatus playerStatus = null;
			for (PlayerStatus PS : GamePlayerInfoList)
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
				Player p1 = e.getPlayer();
				PlayerVelocityEvent pve = new PlayerVelocityEvent(p1,p1.getVelocity());
				
				//ȥ��
				if(playerStatus.getFirstSkill())
				{
					//�÷��̾�� velocityEvent�� �޾ƿͼ� �ٶ󺸴� ���� ����.
					Vector v1 = p1.getEyeLocation().getDirection();
					
					v1.add(v1);
					v1.add(v1);
					Arrow chaos = e.getPlayer().launchProjectile(Skill_Chaos_Projectile.class, v1);
					chaos.setGravity(false);
					chaos.setDamage(0);
					
					chaos.setShooter(p1);
					
					
					Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable()
					{
						public void run()
						{
							chaos.remove();
						}
					}, 100);
				}
				
				
				//����
				else 
				{
					
				}
			
					
			}
		}
		
		
		
		
	}
	
		
		
	
}
