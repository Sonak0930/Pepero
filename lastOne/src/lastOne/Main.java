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
		System.out.println("***최후의 1인 켜짐***");
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
		
		AllitemList.add(CreateItem.createItem("칠흑검", ChatColor.RED, Material.DIAMOND_SWORD, "", "", "", true));
		AllitemList.add(CreateItem.createItem("표식파괴", ChatColor.RED, Material.ENCHANTED_BOOK, "", "", "", true));
		AllitemList.add(CreateItem.createItem("혼돈", ChatColor.GOLD, Material.BLAZE_ROD, "", "", "", true));
		AllitemList.add(CreateItem.createItem("Butterflying FireWork", ChatColor.DARK_PURPLE, Material.BRAIN_CORAL_FAN, ChatColor.DARK_AQUA+"Progressive Active Skill",ChatColor.AQUA+ "근처의 적에게 나비 폭죽을 날려 피해를 입힌다. ", ChatColor.AQUA+"대상이 여럿일 경우 복수의 대상에게 2/3의 피해를 입힌다.", true));
		AllitemList.add(CreateItem.createItem("속사", ChatColor.GREEN, Material.CROSSBOW, "", "", "", true));
		AllitemList.add(CreateItem.createItem("일촉즉발", ChatColor.GREEN, Material.ENCHANTED_BOOK, "", "", "", true));
		AllitemList.add(CreateItem.createItem("수확", ChatColor.BLUE, Material.BLAZE_ROD, "", "", "", true));
		AllitemList.add(CreateItem.createItem("사령술", ChatColor.BLUE, Material.ENCHANTED_BOOK, "", "", "", true));
		
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
								p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 이미 게임에 참가하였습니다!");
								return true;
							}
						}
						
						if (isStart)
						{
							p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 이미 게임이 진행 중입니다. 진행 중인 게임이 끝날 때 까지 기다려주세요.");
							return false;
						}
						p.getInventory().clear();
						ClassSelector.openClassSelectorGUI(p);
						p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.LIGHT_PURPLE + " 참가를 위해선 직업을 선택해주세요.");
					}
					else
					{
						sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 이 옵션은 커맨드 창에서 할 수 없습니다! 플레이어가 시도해주세요.");
					}
				}
				else if (args[0].equalsIgnoreCase("start"))
				{
					if (GameJoinList.size() >= 1)
					{
						if (isStart)
						{
							sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 이미 게임이 진행 중입니다. 진행 중인 게임이 끝날 때 까지 기다려주세요.");
							return false;
						}
						sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 준비중인 기능! 기다려주세요. 감사합니다.");
						isStart = true;
						for (Player tp : GameJoinList)
						{
							GiveWeapon giveItem = new GiveWeapon();
							giveItem.giveItem(tp);
						}
						//이부분쯤에서 경기장으로 TP
					}
					else
					{
						sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 플레이어가 2(1)명이상 참가해야 시작 할 수 있습니다.");
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
								p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.RED + " 게임 참가 취소가 완료되었습니다.");
								return true;
							}
						}
						p.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 당신은 최후의1인에 참가하지 않았습니다.");
					}
					else
					{
						sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 이 옵션은 커맨드 창에서 할 수 없습니다! 플레이어가 시도해주세요.");
					}
				}
				else if (args[0].equalsIgnoreCase("reset"))
				{
					isStart = false;
					GameJoinList.clear();
					GamePlayerInfoList.clear();
					sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GREEN + " 플레이어 리스트 초기화.");
				}
				else if (args[0].equalsIgnoreCase("list"))
				{
					int index = 0;
					sender.sendMessage(ChatColor.DARK_GRAY + "-----참가한 플레이어 리스트-----");
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
					sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 알 수 없는 옵션입니다.");
					sender.sendMessage(ChatColor.YELLOW + "[최후의 1인]" + ChatColor.GRAY + " 실행 가능한 옵션 : join | left | start | clear | list");
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
	
	
	
	//여기서부터는 각 직업군 기술구현코드
	
	
	// 돌격기사

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
		
		if (!Damager.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "칠흑검")) return;
			
		if (!isStart) return;
		
		if (!DamagerStatus.isWriteSkillTree())
		{
			e.setCancelled(true);
			Damager.sendMessage("기술특성을 작성해야 기술을 사용할 수 있습니다!");
			return;
		}
		
		
		
		
		
		
		
		if (DamagerStatus.getFirstSkill())
		{
			//검기

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
			if (Victim.getType().equals(EntityType.PLAYER)) Victim.sendMessage("당신은 " + Damager.getName() + "(돌격기사)에게 찍혔습니다!");
			Damager.sendMessage(Victim.getName() + "에게 표식을 남겼습니다!");

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
			//원한
			
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
			if (Victim.getType().equals(EntityType.PLAYER)) Victim.sendMessage("당신은 " + Damager.getName() + "(돌격기사)에게 찍혔습니다!");
			Damager.sendMessage(Victim.getName() + "에게 표식을 남겼습니다!");
			
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
		if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "표식파괴")) return;
		
		if (!isStart) return;
		
		
		for (PlayerStatus PS : GamePlayerInfoList)
		{
			if (!PS.isWriteSkillTree())
			{
				e.getPlayer().sendMessage("기술특성을 작성해야 기술을 사용할 수 있습니다!");
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
			e.getPlayer().sendMessage("표식이 붙은 적이 없습니다!");
			return;
		}
		
		if (playerStatus.getSecondSkill())
		{
			//맹렬
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
			
			e.getPlayer().sendMessage(tempPlayer.getName() + "에게 돌진합니다!");
			e.getPlayer().teleport(tempPlayer);
			
			return;
		}
		else
		{
			//저주
			e.getPlayer().sendMessage("표식이 붙은 적의 이동속도를 늦춥니다!");
			for (LivingEntity LE : AttackKnightLightning)
			{
				LE.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 2, false, false, true));
			}
			return;
		}
	}
	
	// 파괴마법사

	@EventHandler
	public void magicianUseItem(PlayerInteractEvent e)
	{
		
		//손에 아이템을 들고 있는 경우 확인.
		if (e.getHand().equals(EquipmentSlot.HAND)) 
		{
			if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "혼돈")) return;
			//플레이어 체크
			
			PlayerStatus playerStatus = null;
			for (PlayerStatus PS : GamePlayerInfoList)
			{
				if (PS.getPlayer().getName().equals(e.getPlayer().getName()))
				{
					//현재 나의 플레이어 스테이터스를 playerStatus에 저장.
					playerStatus = PS;		
				}
			}
			
			
			
		
			if (!playerStatus.isWriteSkillTree())
			{
				e.getPlayer().sendMessage("기술특성을 작성해야 기술을 사용할 수 있습니다!");
				return;
			}
			
			else
			{
				Player p1 = e.getPlayer();
				PlayerVelocityEvent pve = new PlayerVelocityEvent(p1,p1.getVelocity());
				
				//혼돈
				if(playerStatus.getFirstSkill())
				{
					//플레이어와 velocityEvent를 받아와서 바라보는 방향 설정.
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
				
				
				//음파
				else 
				{
					//플레이어와 velocityEvent를 받아와서 바라보는 방향 설정.
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
		}
		
		
		
		
	}
	
		
		
	
}
