package lastOne;

import java.util.ArrayList;



import java.util.List;

import Projectile.ButterflyingFirework;
import Projectile.Skill_Chaos_Projectile;
import Role.ClassSelector;
import Role.GiveWeapon;
import Role.SkillTreeSelect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
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
import org.bukkit.entity.Fireball;
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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.mojang.datafixers.Products.P2;
import CustomEvent.EntityDeath;
import Party.Party;
import Party.PartyInventoryClickEvent;
import Player.PlayerStatus;
import SkillUseEvent.ForestArcheruseItem;
import SkillUseEvent.FireMagicianSKillEvent;
import SkillUseEvent.SoulHealerSkillUseEvent;
import SkillUseEvent.SoulHealeruseItem;
import org.bukkit.World;


public class Main extends JavaPlugin implements Listener{
	
	public static ArrayList<PlayerStatus> GamePlayerInfoList = new ArrayList<PlayerStatus>();

	public static ArrayList<ItemStack> AllitemList = new ArrayList<ItemStack>();
	public static ArrayList<LivingEntity> AttackKnightLightning = new ArrayList<LivingEntity>();
	public static boolean isStart = false;
	private static ArrayList<Party> partyList = new ArrayList<Party>();
	private Player p1;
	private static PlayerStatus ps;
	
	private Inventory inven;
	boolean terminated = true;
	
	
	public static PlayerStatus findPlayerStatusByName(String name)
	{
		
		for(PlayerStatus ps : GamePlayerInfoList)
		{
			if(ps.getPlayer().getName().contentEquals(name)) return ps;
		}
		
		return null;
	}
	public static ArrayList<PlayerStatus> getPlayerInfoList ()
	{
		return GamePlayerInfoList;
	}
	@Override
	public void onEnable() {
		
		Player instancep = Bukkit.getPlayer("isoboroo");
		instancep.setGameMode(GameMode.CREATIVE);
		// TODO Auto-generated method stub
		System.out.println("***������ 1�� ����***");
		
		Bukkit.getPluginManager().registerEvents(new ClassSelector(), this);

		Bukkit.getPluginManager().registerEvents(new ForestArcheruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new SoulHealeruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new SkillTreeSelect(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeath(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new FireMagicianSKillEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SoulHealerSkillUseEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PartyInventoryClickEvent(), this);
		
		
		AllitemList.add(CreateItem.createItem("ĥ���", ChatColor.RED, Material.DIAMOND_SWORD, "",  true));
		AllitemList.add(CreateItem.createItem("ǥ���ı�", ChatColor.RED, Material.ENCHANTED_BOOK, "", true));
		AllitemList.add(CreateItem.createItem("�ͷ�", ChatColor.BLUE, Material.ENCHANTED_BOOK,"" , true));
		AllitemList.add(CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", true));
		
		AllitemList.add(CreateItem.createItem("ȥ��", ChatColor.GOLD, Material.BLAZE_ROD,"", true));
		AllitemList.add(CreateItem.createItem("����", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, "", true));
		AllitemList.add( CreateItem.createItem("��������", ChatColor.DARK_PURPLE, Material.BRAIN_CORAL,"", false));
		AllitemList.add(CreateItem.createItem("����������", ChatColor.BLUE, Material.SEA_LANTERN, "", false));
		
		AllitemList.add(CreateItem.createItem("����", ChatColor.GREEN, Material.BOW, "", false));
		AllitemList.add(CreateItem.createItem("�Ƹ�������", ChatColor.GREEN, Material.CROSSBOW,"", false));
		AllitemList.add(CreateItem.createItem("Ǫ�� �м���", ChatColor.BLUE, Material.ENCHANTED_BOOK,"" , false));
		AllitemList.add(CreateItem.createItem("�︮�콺 ����", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", false));
		
		AllitemList.add(CreateItem.createItem("������ ���", ChatColor.GREEN, Material.ENCHANTED_GOLDEN_APPLE, "", true));
		AllitemList.add(CreateItem.createItem("����", ChatColor.GREEN, Material.BLAZE_POWDER, "", true));
		AllitemList.add(CreateItem.createItem("���� ����", ChatColor.BLUE, Material.NETHER_STAR, "",  true));
		AllitemList.add(CreateItem.createItem("õ��", ChatColor.BLUE, Material.FIREWORK_ROCKET, "",  true));
		
		
		
		
	}
	//��Ƽ �̸����� ��Ƽ ã��.
		public static Party findPartyByName(String name)
		{
			for(Party party: partyList)
			{
				if( party.getPartyName().contentEquals(name)) return party;
					
				
			}return null;
		}	
		//��� ��Ƽ������ �÷��̾ �����ִ��� �׽�Ʈ.
		public static Party getPartywithIncludedPlayer(Player player)
		{
			for(Party party: partyList)
			{
				if(party.isPlayerIncluded(player)) return party;
			}
				
			return null;
		}
	
	public static PlayerStatus findPlayerStat(Player player)
	{
		for(PlayerStatus playerstat : GamePlayerInfoList)
		{
			if(playerstat.getPlayer().getName().contentEquals(player.getName()))
			{
				ps = playerstat;
			}
		}
		return ps;
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
			
			
			else if (args[0].equalsIgnoreCase("join"))
			{
					p1 = (Player)sender;
					p1.getInventory().clear();
					ClassSelector.openClassSelectorGUI(p1);
					p1.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.LIGHT_PURPLE + " ������ ���ؼ� ������ �������ּ���.");
			}
			else if (args[0].equalsIgnoreCase("start"))
			{
					GiveWeapon giveItem = new GiveWeapon();
					giveItem.giveItem((Player)sender);
			}
				
			else 
			{
				sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " �� �� ���� �ɼ��Դϴ�.");
				sender.sendMessage(ChatColor.YELLOW + "[������ 1��]" + ChatColor.GRAY + " ���� ������ �ɼ� : join | left | start | clear | list");
			}
				
				
		}
		
		
		
		
		if (command.getName().equalsIgnoreCase("reset"))
		{
			isStart = false;
			GamePlayerInfoList.clear();
			partyList.clear();
			ForestArcheruseItem.clearCurrentNote();
		}
		
		if (command.getName().equalsIgnoreCase("c"))
		{
			Bukkit.getPlayer("isoboroo").setGameMode(GameMode.CREATIVE);
		}
	
		
		
		if (command.getName().equalsIgnoreCase("create_party"))
		{
			int errorcode = 0;
			try
			{
				//�̸��� �Է����� �ʾҴٸ� exception.
				if(args[0] == null);
				errorcode = 1;
				if(findPartyByName(args[0]) == null);
				
			}
			catch(Exception e)
			{
				if(errorcode == 0)
				{
					sender.sendMessage("��Ƽ �̸��� �Է����ּ���.");
					return false;
				}
				else if(errorcode == 1)
				{
					sender.sendMessage("�̹� ������ �̸��� ��Ƽ�� �����մϴ�.");
					return false;
				}
			}
			
			//�� �÷��̾ ���Ե� ��Ƽ�� ���� �ƴ϶��.
			if(getPartywithIncludedPlayer((Player)sender) != null)
			{
				sender.sendMessage("�̹� �Ҽӵ� ��Ƽ�� �ֽ��ϴ�. party exit�� ���� ��Ƽ�� ���� �� �ٽ� �õ��ϼ���");
				return false;
			}
			
			//�÷��̾� �̸����� ��Ƽ�� �����մϴ�.
			Party my_party = new Party();
			
			ps = findPlayerStat((Player)sender);
			my_party.setPartyName(args[0]);
			my_party.add(ps);
			partyList.add(my_party);
			sender.sendMessage(args[0]+" ��Ƽ�� �����Ǿ����ϴ�.");
			
			return true;
		}
			
			
			
		if(command.getName().contentEquals("join_party"))
		{
			String partyname;
			try
			{
				partyname = args[0];
				//�̸��� �Է����� �ʾҴٸ� exception.
				if(partyname == null);
			}
			
			catch(Exception e)
			{
				sender.sendMessage("������ ��Ƽ ���� �Է����ּ���.");
				return false;
			}
		
			//�� �÷��̾ ���Ե� ��Ƽ�� ���� �ƴ϶��.
			if(getPartywithIncludedPlayer((Player)sender) != null)
			{
				sender.sendMessage("�̹� �Ҽӵ� ��Ƽ�� �ֽ��ϴ�. party exit�� ���� ��Ƽ�� ���� �� �ٽ� �õ��ϼ���");
				return false;
			}
			Party party = findPartyByName(partyname);
			party.add(findPlayerStat((Player)sender));
			sender.sendMessage("��Ƽ�� �����߽��ϴ�.");
			

		}
			
		if(command.getName().contentEquals("party"))
		{
			Player p = (Player)sender;
			inven = Bukkit.createInventory(null, 27, "PartyQuest");
			
			ItemStack findParty = CreateItem.createItem("��Ƽ ����", ChatColor.WHITE, Material.RED_MUSHROOM_BLOCK, 
					"��Ƽ�� �����մϴ�. \n"
					+ChatColor.BLUE+ ".. party open[�̸�]�� ���� ��Ƽ �߰�  \n"
					+ChatColor.RED+ ".. party exit �� ���� ��Ƽ Ż�� �����մϴ�.\n"
					+ "������ ��Ƽ�� ���� ��� ��Ƽ â�� ��Ÿ���ϴ�."
							, false);
			
			ItemStack findQuest = CreateItem.createItem("��Ƽ����Ʈ �˻�", ChatColor.YELLOW, Material.BOOK,
					"��Ƽ����Ʈ�� �˻��մϴ�.\n"
					+"��Ƽ�� ���� ��� �˻��� �� �����ϴ�.", false);
			
			ItemStack find_TheOtherParty = CreateItem.createItem("�ٸ� ��Ƽ �˻�", ChatColor.AQUA, Material.FEATHER, "", false);
			inven.setItem(13,findParty); 
			inven.setItem(11,findQuest);
			inven.setItem(15, find_TheOtherParty);
			p.openInventory(inven);
		}
		return false;		
	}
	
	
	
	//���⼭���ʹ� �� ������ ��������ڵ�
	
	
	// ���ݱ��

	
	
	// �ı�������

	@EventHandler
	public void magicianUseItem(PlayerInteractEvent e)
	{
		
		if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) return;
		
		try 
		{
			p1 = e.getPlayer();
			ps = Main.findPlayerStat(e.getPlayer());
			if (!ps.isWriteSkillTree())
			{
				e.getPlayer().sendMessage("���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�!");
				return;
			}
		}
		catch(Exception ex)
		{
			
		}
		
		
		
		FireMagicianSKillEvent.setDamager(p1);
		
		e.setCancelled(true);
		
		
		
				
		//ȥ��
		if(ps.getFirstSkill())
		{
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE+"ȥ��"))
			{
				//�÷��̾�� velocityEvent�� �޾ƿͼ� �ٶ󺸴� ���� ����.
				Vector v1 = p1.getEyeLocation().getDirection();
						
				v1.add(v1);
				v1.add(v1);
				Fireball chaos = e.getPlayer().launchProjectile(Skill_Chaos_Projectile.class, v1);
				chaos.setGravity(false);
				chaos.setShooter(p1);
				p1.spawnParticle(Particle.BUBBLE_POP, p1.getLocation(), 35, 1, 1, 1 );
			
				Bukkit.getServer().getScheduler().runTaskLater(this, new Runnable()
				{
					public void run()
					{
						chaos.remove();
					}
				}, 100);
			}
		}
			
					
					
				
				
				
		//����
		else 
		{
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase( ChatColor.BLUE +"����"))
			{
				//�÷��̾�� velocityEvent�� �޾ƿͼ� �ٶ󺸴� ���� ����.
				Vector v1 = p1.getEyeLocation().getDirection();
						
				v1.add(v1);
				v1.add(v1);
				Fireball chaos = e.getPlayer().launchProjectile(Skill_Chaos_Projectile.class, v1);
				chaos.setGravity(false);	
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
		if(ps.getSecondSkill())
		{	
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE+"��������"))
			{
				butterfly(12);
			}
		}
					
		
		//����������
		else
		{
			
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE+"����������"))
			{
				lightparticle();
				
			}
		}
	
		
		e.setCancelled(false);
	

}//event handler
	
		
	//repeat time
	public void butterfly(double time)	
	{
		if(time == 0) return;
		
		else
		{
			
			//Worker thread �ۼ��ؼ� 0.3�ʸ��� �Ʒ� ���� ����. �̶� �÷����γ����� ��Ʈ���̸� ��𼭵� �� �ڵ带 ���డ��.
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("lastOne"), new Runnable() {

				@Override
				public void run() {
					
					//���͸� ����.
					Vector v1 = p1.getEyeLocation().getDirection();
					
					randomNumber ran1 = new randomNumber(3);
					ran1.plusminus(2);
					
					//�ҷ� ������ �߻�.
					ShulkerBullet bullet = p1.launchProjectile(ButterflyingFirework.class, v1);
					
					//�ҷ��� Ÿ���� p1�� �߽����� x y z 30ũ���� ������ü ���� ���� ����� ������� ����
					bullet.setTarget(getNearest(p1,30));
					
					bullet.setVelocity(new Vector(ran1.getNum(),ran1.getNum(),ran1.getNum()));
					
					//����ü �߻�� ������������Ʈ �߻�.
					for(int degree = 0; degree < 360; degree++)
					{
						//location
						Location loc = bullet.getLocation();
						
						//�������� ���� ��ȯ.
						double radians = Math.toRadians(degree);
						
						//����Ʈ�� ���� ��ǥ. ���� ��ǥ + ���ȸ�ŭ�� ������.�� ���� ��ġ�� ����.
						double x = loc.getX()+Math.cos(radians);
						double z = loc.getY()+Math.sin(radians);
						
						//�����̼� ���� �̶� loc�� Ŭ�� ������ ���.
						Location loc2 = loc.clone();
						loc2.setX(x);
						loc2.setZ(z);
						
						//p.getWorld.spawnParticle�� ���� ������ �����Ƿ� p.spawnParticle�� ����� ��.
						
						p1.spawnParticle(Particle.HEART,loc2,1,1,1,1);
						
						
					}
					
					
					//0.6�� �������� ���ȣ���ϱ� ����.
					butterfly(time-1);
				}
				
			},3);
		
		
		}
		
	}
	
	public void lightparticle()
	{
		
		Vector v1 = p1.getEyeLocation().getDirection();
		
		v1.add(v1);
		v1.add(v1);
		Fireball chaos = p1.launchProjectile(Skill_Chaos_Projectile.class, v1);
		
		chaos.setGravity(false);		
		chaos.setShooter(p1);
		
		ArrayList<Location> loclist = new ArrayList<Location>();
		
		Bukkit.getServer().getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("lastOne"), new Runnable()
				{
					@Override
					public void run() {
						// TODO Auto-generated method stub
						loclist.add(chaos.getLocation());
						Vector distance = loclist.get(0).toVector().subtract(p1.getLocation().toVector());
						
						Vector v = new Vector();
						v.copy(distance);
						v.normalize();
						
						p1.sendMessage("dist" + distance +" v " + v);
						p1.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,80,1));
						
						while(v.length() < distance.length())
						{
							chaos.getWorld().createExplosion(p1.getLocation().add(v.toLocation(p1.getWorld())), 16.0f);
							chaos.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,p1.getLocation(v.toLocation(p1.getWorld())),100,3,3,3);
							chaos.getWorld().spawnParticle(Particle.EXPLOSION_HUGE,p1.getLocation(v.toLocation(p1.getWorld())),100,3,3,3);
							v.add(v);
							
						}
							
		
		
		
					}
				},55);	
		
		
	
		
	}
				
				
		
		

		
		
	
	
	
	public static Entity getNearest(Player player, double square)
	{
		Player p;
		Entity nearest;
		double s =  square;
		
		p = player;
	
		//��ó ��ƼƼ ����� �޾ƿ���.
		ArrayList<Entity> enlist = (ArrayList<Entity>) p.getNearbyEntities(s,s,s);
		
		//�⺻���� 0���� ����.
		nearest = enlist.get(0);
		
		
		
		
		for(Entity e : enlist)
		{
			try
			{
				LivingEntity livinge = (LivingEntity) e;
			}
			
			catch(Exception err)
			{
				continue;
			}
			//���࿡ �ڱ��ڽ��� ����� �Ǹ� ����.
			if(e.getName().equalsIgnoreCase(p.getName())) continue;
			
			
			
			
			//���� ���� �˻��ϴ� ��ƼƼ��, ���� ����� ��󺸴� ����� ���, ���� ����� ����� �缳��.
			if(e.getLocation().distance(p.getLocation()) < nearest.getLocation().distance(p.getLocation()))
			{
				nearest = e;
			}
		}
		
		
		return nearest;
		
	}
	
	
		
		
	
}




