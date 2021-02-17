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
		System.out.println("***최후의 1인 켜짐***");
		
		Bukkit.getPluginManager().registerEvents(new ClassSelector(), this);

		Bukkit.getPluginManager().registerEvents(new ForestArcheruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new SoulHealeruseItem(), this);
		Bukkit.getPluginManager().registerEvents(new SkillTreeSelect(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeath(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new FireMagicianSKillEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SoulHealerSkillUseEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PartyInventoryClickEvent(), this);
		
		
		AllitemList.add(CreateItem.createItem("칠흑검", ChatColor.RED, Material.DIAMOND_SWORD, "",  true));
		AllitemList.add(CreateItem.createItem("표식파괴", ChatColor.RED, Material.ENCHANTED_BOOK, "", true));
		AllitemList.add(CreateItem.createItem("맹렬", ChatColor.BLUE, Material.ENCHANTED_BOOK,"" , true));
		AllitemList.add(CreateItem.createItem("저주", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", true));
		
		AllitemList.add(CreateItem.createItem("혼돈", ChatColor.GOLD, Material.BLAZE_ROD,"", true));
		AllitemList.add(CreateItem.createItem("음파", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, "", true));
		AllitemList.add( CreateItem.createItem("나비폭죽", ChatColor.DARK_PURPLE, Material.BRAIN_CORAL,"", false));
		AllitemList.add(CreateItem.createItem("광속입자파", ChatColor.BLUE, Material.SEA_LANTERN, "", false));
		
		AllitemList.add(CreateItem.createItem("정악", ChatColor.GREEN, Material.BOW, "", false));
		AllitemList.add(CreateItem.createItem("아르페지오", ChatColor.GREEN, Material.CROSSBOW,"", false));
		AllitemList.add(CreateItem.createItem("활기", ChatColor.BLUE, Material.ENCHANTED_BOOK,"" , false));
		AllitemList.add(CreateItem.createItem("음침", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", false));
		
		AllitemList.add(CreateItem.createItem("숭고한 희생", ChatColor.GREEN, Material.ENCHANTED_GOLDEN_APPLE, "", true));
		AllitemList.add(CreateItem.createItem("단죄", ChatColor.GREEN, Material.BLAZE_POWDER, "", true));
		AllitemList.add(CreateItem.createItem("신의 구원", ChatColor.BLUE, Material.NETHER_STAR, "",  true));
		AllitemList.add(CreateItem.createItem("천뇌", ChatColor.BLUE, Material.FIREWORK_ROCKET, "",  true));
		
		
		
		
	}
	//파티 이름으로 파티 찾기.
		public static Party findPartyByName(String name)
		{
			for(Party party: partyList)
			{
				if( party.getPartyName().contentEquals(name)) return party;
					
				
			}return null;
		}	
		//모든 파티에대해 플레이어가 속해있는지 테스트.
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
		System.out.println("최후의 1인 꺼짐");
	}
	
	
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
	{
		if(command.getName().equalsIgnoreCase("lastone"))
		{
			if (args.length == 0)
			{
				sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 옵션을 입력주세요.");
				sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 예시) /lastone <옵션>");
				sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 실행 가능한 옵션 : join | left | start | reset | list");
			}
			
			
			else if (args[0].equalsIgnoreCase("join"))
			{
					p1 = (Player)sender;
					p1.getInventory().clear();
					ClassSelector.openClassSelectorGUI(p1);
					p1.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.LIGHT_PURPLE + " 참가를 위해선 직업을 선택해주세요.");
			}
			else if (args[0].equalsIgnoreCase("start"))
			{
					GiveWeapon giveItem = new GiveWeapon();
					giveItem.giveItem((Player)sender);
			}
				
			else 
			{
				sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 알 수 없는 옵션입니다.");
				sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 실행 가능한 옵션 : join | left | start | clear | list");
			}
				
				
		}
		
		
		
		
		if (command.getName().equalsIgnoreCase("reset"))
		{
			isStart = false;
			GamePlayerInfoList.clear();
			partyList.clear();
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
				//이름을 입력하지 않았다면 exception.
				if(args[0] == null);
				errorcode = 1;
				if(findPartyByName(args[0]) == null);
				
			}
			catch(Exception e)
			{
				if(errorcode == 0)
				{
					sender.sendMessage("파티 이름을 입력해주세요.");
					return false;
				}
				else if(errorcode == 1)
				{
					sender.sendMessage("이미 동일한 이름의 파티가 존재합니다.");
					return false;
				}
			}
			
			//이 플레이어가 포함된 파티가 널이 아니라면.
			if(getPartywithIncludedPlayer((Player)sender) != null)
			{
				sender.sendMessage("이미 소속된 파티가 있습니다. party exit을 통해 파티를 나간 후 다시 시도하세요");
				return false;
			}
			
			//플레이어 이름으로 파티를 생성합니다.
			Party my_party = new Party();
			
			ps = findPlayerStat((Player)sender);
			my_party.setPartyName(args[0]);
			my_party.add(ps);
			partyList.add(my_party);
			sender.sendMessage(args[0]+" 파티가 개설되었습니다.");
			
			return true;
		}
			
			
			
		if(command.getName().contentEquals("join_party"))
		{
			String partyname;
			try
			{
				partyname = args[0];
				//이름을 입력하지 않았다면 exception.
				if(partyname == null);
			}
			
			catch(Exception e)
			{
				sender.sendMessage("가입할 파티 명을 입력해주세요.");
				return false;
			}
		
			//이 플레이어가 포함된 파티가 널이 아니라면.
			if(getPartywithIncludedPlayer((Player)sender) != null)
			{
				sender.sendMessage("이미 소속된 파티가 있습니다. party exit을 통해 파티를 나간 후 다시 시도하세요");
				return false;
			}
			Party party = findPartyByName(partyname);
			party.add(findPlayerStat((Player)sender));
			sender.sendMessage("파티에 가입했습니다.");
			

		}
			
		if(command.getName().contentEquals("party"))
		{
			Player p = (Player)sender;
			inven = Bukkit.createInventory(null, 27, "PartyQuest");
			
			ItemStack findParty = CreateItem.createItem("파티 관리", ChatColor.WHITE, Material.RED_MUSHROOM_BLOCK, 
					"파티를 생성합니다. \n"
					+ChatColor.BLUE+ ".. party open[이름]을 통해 파티 추가  \n"
					+ChatColor.RED+ ".. party exit 을 통해 파티 탈퇴가 가능합니다.\n"
					+ "생성된 파티가 있을 경우 파티 창이 나타납니다."
							, false);
			
			ItemStack findQuest = CreateItem.createItem("파티퀘스트 검색", ChatColor.YELLOW, Material.BOOK,
					"파티퀘스트를 검색합니다.\n"
					+"파티가 없을 경우 검색할 수 없습니다.", false);
			
			ItemStack find_TheOtherParty = CreateItem.createItem("다른 파티 검색", ChatColor.AQUA, Material.FEATHER, "", false);
			inven.setItem(13,findParty); 
			inven.setItem(11,findQuest);
			inven.setItem(15, find_TheOtherParty);
			p.openInventory(inven);
		}
		return false;		
	}
	
	
	
	//여기서부터는 각 직업군 기술구현코드
	
	
	// 돌격기사

	
	
	// 파괴마법사

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
				e.getPlayer().sendMessage("기술특성을 작성해야 기술을 사용할 수 있습니다!");
				return;
			}
		}
		catch(Exception ex)
		{
			
		}
		
		
		
		FireMagicianSKillEvent.setDamager(p1);
		
		e.setCancelled(true);
		
		
		
				
		//혼돈
		if(ps.getFirstSkill())
		{
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE+"혼돈"))
			{
				//플레이어와 velocityEvent를 받아와서 바라보는 방향 설정.
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
			
					
					
				
				
				
		//음파
		else 
		{
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase( ChatColor.BLUE +"음파"))
			{
				//플레이어와 velocityEvent를 받아와서 바라보는 방향 설정.
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
					
		
				
				
				
		//나비폭죽
		if(ps.getSecondSkill())
		{	
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE+"나비폭죽"))
			{
				butterfly(12);
			}
		}
					
		
		//광속입자파
		else
		{
			
			if(p1.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE+"광속입자파"))
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
			
			//Worker thread 작성해서 0.3초마다 아래 블럭을 실행. 이때 플러그인네임이 라스트원이면 어디서든 이 코드를 실행가능.
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("lastOne"), new Runnable() {

				@Override
				public void run() {
					
					//벡터를 생성.
					Vector v1 = p1.getEyeLocation().getDirection();
					
					randomNumber ran1 = new randomNumber(3);
					ran1.plusminus(2);
					
					//불렛 생성후 발사.
					ShulkerBullet bullet = p1.launchProjectile(ButterflyingFirework.class, v1);
					
					//불렛의 타겟을 p1을 중심으로 x y z 30크기의 정육면체 안의 가장 가까운 대상으로 지정
					bullet.setTarget(getNearest(p1,30));
					
					bullet.setVelocity(new Vector(ran1.getNum(),ran1.getNum(),ran1.getNum()));
					
					//투사체 발사시 원형으로이펙트 발생.
					for(int degree = 0; degree < 360; degree++)
					{
						//location
						Location loc = bullet.getLocation();
						
						//라디안으로 값을 변환.
						double radians = Math.toRadians(degree);
						
						//이펙트가 생길 좌표. 기존 좌표 + 라디안만큼의 반지름.을 더해 위치를 선정.
						double x = loc.getX()+Math.cos(radians);
						double z = loc.getY()+Math.sin(radians);
						
						//로케이션 지정 이때 loc의 클론 값으로 사용.
						Location loc2 = loc.clone();
						loc2.setX(x);
						loc2.setZ(z);
						
						//p.getWorld.spawnParticle은 현재 문제가 있으므로 p.spawnParticle을 사용할 것.
						
						p1.spawnParticle(Particle.HEART,loc2,1,1,1,1);
						
						
					}
					
					
					//0.6초 간격으로 재귀호출하기 위함.
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
	
		//근처 엔티티 목록을 받아오고.
		ArrayList<Entity> enlist = (ArrayList<Entity>) p.getNearbyEntities(s,s,s);
		
		//기본값은 0으로 하자.
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
			//만약에 자기자신이 대상이 되면 제외.
			if(e.getName().equalsIgnoreCase(p.getName())) continue;
			
			
			
			
			//만약 새로 검사하는 엔티티가, 가장 가까운 대상보다 가까운 경우, 가장 가까운 대상을 재설정.
			if(e.getLocation().distance(p.getLocation()) < nearest.getLocation().distance(p.getLocation()))
			{
				nearest = e;
			}
		}
		
		
		return nearest;
		
	}
	
	
		
		
	
}




