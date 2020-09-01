package lastOne;

import java.util.ArrayList;



import java.util.List;

import Projectile.ButterflyingFirework;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
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
import org.bukkit.entity.ShulkerBullet;
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

import CustomEvent.EntityDeath;
import CustomEvent.PlayerQuit;
import CustomEvent.SkillTreeSelect;
import CustomEvent.ThrownItem;

import SkillUseEvent.ForestArcheruseItem;
import SkillUseEvent.HitByArrowEvent;
import SkillUseEvent.SoulHealeruseItem;
import org.bukkit.World;


public class Main extends JavaPlugin implements Listener{
	
	public static ArrayList<PlayerStatus> GamePlayerInfoList = new ArrayList<PlayerStatus>();
	public static ArrayList<Player> GameJoinList = new ArrayList<Player>();
	public static ArrayList<Player> deathPlayerList = new ArrayList<Player>();
	public static ArrayList<ItemStack> AllitemList = new ArrayList<ItemStack>();
	public static ArrayList<LivingEntity> AttackKnightLightning = new ArrayList<LivingEntity>();
	public static boolean isStart = false;
	
	private Player p1;
	private PlayerStatus playerstatus;
	
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

		Bukkit.getPluginManager().registerEvents(new ForestArcheruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new SoulHealeruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
		Bukkit.getPluginManager().registerEvents(new SkillTreeSelect(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeath(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new HitByArrowEvent(), this);
		
		AllitemList.add(CreateItem.createItem("ĥ���", ChatColor.RED, Material.DIAMOND_SWORD, "",  true));
		AllitemList.add(CreateItem.createItem("ǥ���ı�", ChatColor.RED, Material.ENCHANTED_BOOK, "", true));
		AllitemList.add(CreateItem.createItem("ȥ��", ChatColor.GOLD, Material.BLAZE_ROD,
				ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 1\n"
			+ ChatColor.WHITE + "����ü�� �߻��� ���� ������ '��ȭȭ��' ���¿� ��Ʈ���ϴ�.\n"
			+ ChatColor.WHITE + "��ȭȭ�� : ü�º�����ظ� ���������� �����ϴ�.\n"
			+ ChatColor.WHITE+ "ȭ������� ���� ����ü�� Ÿ���ϸ� 3�� �߰��������� �ݴϴ�. ", false));
		AllitemList.add(CreateItem.createItem("����", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, 
				ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 2\n"
				+ChatColor.WHITE + "�� Ÿ�� ��, ���� ��ġ�� 2�ʰ� ���̰� �ϰ� �̵��ӵ��� ����ϴ�.\n"
				+ ChatColor.WHITE + "���� ���ð� : 0.5��", false));
		AllitemList.add( CreateItem.createItem("��������", ChatColor.DARK_PURPLE, Material.BRAIN_CORAL,
				ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 6 \n"
		+ChatColor.WHITE + "��ó�� ������ �̻����� 3�� �߻��� 6�� ���ظ� �����ϴ�.\n"
		+ChatColor.LIGHT_PURPLE+ " �ִ� ��� : 3��\n"
		+ ChatColor.WHITE + "��ȭȭ������� �����Դ� ����ü 8���� �߻��ϸ� "
		+ChatColor.AQUA+ "\n����ü�� ������ �����鼭 �ִ�ü�¿� ����� ���ظ� �����ϴ�. \n"
		+ChatColor.LIGHT_PURPLE+ "�ִ� ��� : 3�� ", false));
		AllitemList.add(CreateItem.createItem("����������", ChatColor.BLUE, Material.SEA_LANTERN, ChatColor.WHITE
				+ "��� : ���� ����Ÿ ���� : 30\n"+ChatColor.WHITE + "���� ���������� ���� ������ �߻��� 6�� ���ظ� 5�� �����ϴ�.\n���� ���� ���� 1.5�ʵ��� �����մϴ�. "
				+ "\n�� ���ش� 35%�� ������ �����մϴ�."+ ChatColor.WHITE + "���Ŀ� ����� ���ΰ�� �ڽ��� ��ȣ���� ��� �Ҹ��� \n���濡�� �������ظ� �����ϴ�. ", false));
		AllitemList.add(CreateItem.createItem("�ӻ�", ChatColor.GREEN, Material.CROSSBOW, "", true));
		AllitemList.add(CreateItem.createItem("�������", ChatColor.GREEN, Material.ENCHANTED_BOOK, "", true));
		AllitemList.add(CreateItem.createItem("��Ȯ", ChatColor.BLUE, Material.BLAZE_ROD, "",  true));
		AllitemList.add(CreateItem.createItem("��ɼ�", ChatColor.BLUE, Material.ENCHANTED_BOOK, "",  true));
		
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
		
		if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) 
			{
			
			return;
			}
			
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
		String itemName;
		
		try
		{
			itemName = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName();
		}
		
		catch(Exception ex) 
		{
			return;
		}
		
		
		for (PlayerStatus PS : GamePlayerInfoList)
		{
			if (PS.getPlayer().getName().equals(e.getPlayer().getName()))
			{
				//���� ���� �÷��̾� �������ͽ��� playerStatus�� ����.
				playerstatus = PS;		
			}
		}
		
		if (!playerstatus.isWriteSkillTree())
		{
			e.getPlayer().sendMessage("���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�!");
			return;
		}
		
		p1 = e.getPlayer();
	
		
		
		
		
				
		//ȥ��
		if(playerstatus.getFirstSkill())
		{
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"ȥ��"))
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
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase( ChatColor.GOLD+"����"))
			{

				//�÷��̾�� velocityEvent�� �޾ƿͼ� �ٶ󺸴� ���� ����.
				Vector v1 = p1.getEyeLocation().getDirection();
						
				v1.add(v1);
				v1.add(v1);
				Arrow chaos = e.getPlayer().launchProjectile(Skill_Chaos_Projectile.class, v1);
				chaos.setGravity(false);
				chaos.setDamage(3);
						
				chaos.setShooter(p1);
						
						
				Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable()
				{
					public void run()
					{
						chaos.remove();
					}
				}, 100);
			}
		}
					
		
				
				
				
		//��������
		if(playerstatus.getSecondSkill())
		{
					
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE+"��������"))
			{

				recursion(5);
			}
		}
					
		
		//����������
		else
		{
					
		}
				
	}//get first skill

}//event handler
	
		
		
	public void recursion(double time)	
	{
		if(time == 0) return;
		
		else
		{
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("LastOne"), new Runnable() {

				@Override
				public void run() {
					
					
					Vector v1 = p1.getEyeLocation().getDirection();
					
					ShulkerBullet bullet = p1.launchProjectile(ButterflyingFirework.class, v1);
					bullet.setTarget(getNearest(p1,15));
					// TODO Auto-generated method stub
					//����ü �߻�� �������� �÷��� ����Ʈ �߻�.
					for(int degree = 0; degree < 360; degree++)
					{
						Location loc = bullet.getLocation();
						double radians = Math.toRadians(degree);
						double x = loc.getX()+Math.cos(radians);
						double z = loc.getY()+Math.sin(radians);
						
						Location loc2 = loc;
						loc2.setX(x);
						loc2.setZ(z);
						
						randomNumber ran = new randomNumber(3);
						ran.plusminus(3);
						loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,loc2,1,ran.getNum(),ran.getNum(),ran.getNum());
						
						
						
						
					}
					
					recursion(time-1);
				}
				
			},6);
		}
		
	}
	
	
	public Entity getNearest(Player player, double square)
	{
		Player p;
		Entity nearest;
		double s =  square;
		
		p = player;
		Location median = p.getLocation();
		
		World world = p.getWorld();
		ArrayList<Entity> enlist = (ArrayList<Entity>) world.getNearbyEntities(median,s,s,s);
		
		nearest = enlist.get(0);
		
		if(enlist.size() <2) return p;
		
		for(Entity e : enlist)
		{
			if(e.getName().equalsIgnoreCase(p.getName())) continue;
			
			if(e.getLocation().distance(p.getLocation()) < nearest.getLocation().distance(p.getLocation()))
			{
				
				nearest = e;
			}
		}
		
		return nearest;
		
	}
}


