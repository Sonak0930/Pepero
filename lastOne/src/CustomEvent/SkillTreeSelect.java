package CustomEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import lastOne.CreateItem;
import lastOne.Main;
import lastOne.PlayerStatus;

public class SkillTreeSelect implements Listener
{
	
	//직업특성 책과 상호작용 할 때 호출되는 이벤트핸들러
	@EventHandler
	public void useItemOpenGUI(PlayerInteractEvent e)
	{
		if (!e.getHand().equals(EquipmentSlot.HAND)) return;
		
		Player p = e.getPlayer();
		
		
		
		//직업 스킬 선택창
		if (p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals(ChatColor.DARK_RED + "(버릴 수 없음)") && p.getInventory().getItemInMainHand().getType().equals(Material.BOOK))
		{
			
			//돌격기사 스킬 선택 창
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "돌격 기사 - 기술특성 책"))
			{
				openGUI(CreateItem.createItem("검기", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "기본 검 추가피해 : 3\n"+ ChatColor.WHITE + "적 타격 시, 10% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.\n", false),
						CreateItem.createItem("원한", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기본 검 추가피해 : 1\n"+ChatColor.WHITE + "적 타격 시, 50% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.\n", false),
						CreateItem.createItem("맹렬", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적중 가장 가까운 적에게 이동\n"+ChatColor.WHITE + "재사용 대기시간 : 7초\n"+ ChatColor.WHITE , false),
						CreateItem.createItem("저주", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적의 이동속도를 5초간 감소\n"+ChatColor.WHITE + "재사용 대기시간 : 10초\n"+ ChatColor.WHITE , false),
						CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "",  false),
						CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
			}
			
			
			
			
			//파괴마법사 스킬 선택 창
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "파괴 마법사 - 기술특성 책"))
			{
				openGUI(CreateItem.createItem("혼돈", ChatColor.GOLD, Material.FIRE_CHARGE, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 1\n"
			+ ChatColor.WHITE + "투사체를 발사해 맞은 적에게 '강화화상' 상태에 빠트립니다.\n"
			+ ChatColor.AQUA + "강화화상 : 체력비례피해를 지속적으로 입힙니다. \n"
			+ ChatColor.WHITE +"화상상태의 적을 투사체로 타격하면 3의 추가데미지를 줍니다. ", false),
						CreateItem.createItem("음파", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 3\n"
			+ChatColor.AQUA + "음파 투시 : 적 타격 시 적의 위치를 \n"
			+ChatColor.AQUA + "2초간 보이게 하고 이동속도를 늦춥니다.\n"
			+ChatColor.WHITE + "동화 : 음파를 맞춘 적에게 음파를 맞추면 \n"
			+ChatColor.WHITE + "피해량이 20% 증가하고 피해량의 30%에 해당하는 \n보호막을 얻습니다.", false),
						
				CreateItem.createItem("나비폭죽", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 마법 직격타 피해 : 6 \n"
			+ChatColor.WHITE + "근처의 적에게 미사일을 3개 발사해 6의 피해를 입힙니다.\n"
			+ChatColor.AQUA + "최대 대상 : 3명\n"
			+ChatColor.WHITE + "강화화상상태의 적에게는 투사체 8개를 발사하며 \n"
			+ChatColor.WHITE + "투사체가 폭발을 입히면서 최대체력에 비례한 피해를 입힙니다.\n"
			+ChatColor.AQUA+"최대 대상 : 3명 ", false),
						
				CreateItem.createItem("광속입자파", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 마법 직격타 피해 : 30\n"
			+ChatColor.WHITE + "전방 직선범위에 마법 포격을 발사해 6의 피해를 5번 입힙니다.\n"
			+ChatColor.WHITE + "범위 안의 적은 1.5초동안 기절합니다. \n"
			+ChatColor.DARK_PURPLE+"이 피해는 35%의 저항을 무시합니다.\n"
			+ ChatColor.WHITE + "음파에 노출된 적인경우 자신의 보호막을 모두 소모해 \n"
			+ChatColor.WHITE+"상대방에게 고정피해를 입힙니다. ", false),
				
				
				CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
				CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
			
			
			
			//숲 사냥꾼 스킬 선택 창
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "숲 사냥꾼 - 기술특성 책"))
			{
				openGUI(CreateItem.createItem("노력", ChatColor.GREEN, Material.BOW, ChatColor.WHITE + "기본 : 화살 직격타 피해 : 2\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.25초\n"+ ChatColor.WHITE , false),
						CreateItem.createItem("재능", ChatColor.GREEN, Material.CROSSBOW, ChatColor.WHITE + "기본 : 화살 직격타 피해 : 1\n"+ ChatColor.WHITE + "적 타격 시, 자신의 이동속도가 5초간 증가 (중첩가능)\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.25초", false),
						CreateItem.createItem("활기", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 피해증가\n"+ ChatColor.WHITE + "기본 화살 직격타 피해가 5 증가합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 15초", false),
						CreateItem.createItem("음침", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 은신\n"+ ChatColor.WHITE + "자신의 모습을 7초간 숨깁니다.\n"+ ChatColor.WHITE + "재사용 대기시간 18초", false),
						CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
				
			}
			
			
			//영혼치유사 스킬 선택 창
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "영혼 치유사 - 기술특성 책"))
			{
				openGUI(CreateItem.createItem("광기", ChatColor.BLUE, Material.BLAZE_POWDER, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 2\n"+ ChatColor.WHITE + "적 타격 시, 체력을 1 회복합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.5초", false),
						CreateItem.createItem("근성", ChatColor.BLUE, Material.NETHERITE_SWORD, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 1"+ChatColor.WHITE + "적 타격 시, 체력을 2 회복합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.5초", false),
						CreateItem.createItem("파괴", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 좀비 소환"+ChatColor.WHITE + "25초동안 적에게 달려드는 좀비를 소환합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 10초", false),
						CreateItem.createItem("협동", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 스켈레톤 소환"+ChatColor.WHITE + "25초동안 적을 공격하는 스켈레톤을 소환합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 10초", false),
						CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
		}
	}
	
	
	
	
	
	@EventHandler
	public void InventoryForceClose(InventoryCloseEvent e)
	{
		
		//기술특성 선택후 이벤트 처리.
		if (!e.getView().getTitle().equals("기술특성 선택")) return;
		
		for (PlayerStatus ps : Main.GamePlayerInfoList)
		{
			if (ps.getPlayer().getName().equals(e.getPlayer().getName()))
			{
				
				//기술 특성 선택시 패스
				if (ps.isWriteSkillTree().equals(true)) return;
				
				
				//선택을하지 않은 경우 스킬을 못 쓰게 막음.
				ps.SkillTreeFirst = false;
				ps.SkillTreeSecond = false;
				e.getView().getPlayer().sendMessage(ChatColor.DARK_RED + "기술특성을 작성해야 기술을 사용할 수 있습니다.");
				return;
			}
		}
	}
	
	
	
	//직업스킬창에 대한 클릭 이벤트를 처리.
	@EventHandler
	public void choiceSkillTree(InventoryClickEvent e)
	{
		InventoryView invV = e.getView();
		
		HumanEntity human = invV.getPlayer();
		if (!invV.getTitle().equals("기술특성 선택")) return;

		e.setCancelled(true);
		
		
		//이미 선택된 영역은 배리어로 무시.
		if (e.getCurrentItem().getType().equals(Material.BARRIER))
		{
			//PASS
		}
		
		
		//전사 스타일 패시브 : 기본스킬 : 검기
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "검기"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("원한", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기본 검 피해 : 2"+ChatColor.WHITE + "적 타격 시, 50% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.", false));
		}
		
		
		//전사 스타일 패시브 : 기본스킬 : 원한
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "원한"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("검기", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "기본 검 피해 : 4 "+ ChatColor.WHITE + "적 타격 시, 10% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.", false));
		}
		
		
		
		//전사 스타일 패시브 : 궁극기 : 맹렬
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "맹렬"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("저주", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적의 이동속도를 5초간 감소\n"+ChatColor.WHITE + "재사용 대기시간 : 10초\n"+ ChatColor.WHITE , false));
		}
		
		
		
		//전사 스타일 패시브 : 궁극기 : 저주
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "저주"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(29, CreateItem.createItem("맹렬", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적중 가장 가까운 적에게 이동\n"+ChatColor.WHITE + "재사용 대기시간 : 7초\n"+ ChatColor.WHITE , false));
		}
		
	
		
		
		//마법사 스타일 패시브 : 기본스킬 : 혼돈
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "혼돈"))
		{
			
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			e.getInventory().setItem(15, CreateItem.createItem("음파", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, 
					ChatColor.WHITE + "기본 : 마법 직격타 피해 : 2\n"
					+ChatColor.WHITE + "적 타격 시, 적의 위치를 2초간 보이게 하고 이동속도를 늦춥니다.\n"
					+ ChatColor.WHITE + "재사용 대기시간 : 0.5초", false));
			
		}
		
		
		
		//마법사 스타일 패시브 : 기본스킬 : 음파
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "음파"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			e.getInventory().setItem(11, CreateItem.createItem("혼돈", ChatColor.GOLD, Material.FIRE_CHARGE,
					ChatColor.WHITE + "기본 : 마법 직격타 피해 : 1\n"
				+ ChatColor.WHITE + "투사체를 발사해 맞은 적에게 '강화화상' 상태에 빠트립니다.\n"
				+ ChatColor.WHITE + "강화화상 : 체력비례피해를 지속적으로 입힙니다.\n"
				+ ChatColor.WHITE+ "화상상태의 적을 투사체로 타격하면 3의 추가데미지를 줍니다. ", false));
			
			
		}
		
		
		
		//마법사 스타일 패시브 : 궁극기 : 나비폭죽
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "나비폭죽"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			
			
			e.getInventory().setItem(33, CreateItem.createItem("광속입자파", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE
					+ "기술 : 마법 직격타 피해 : 30\n"+ChatColor.WHITE + "전방 직선범위에 마법 포격을 발사해 6의 피해를 5번 입힙니다.\n범위 안의 적은 1.5초동안 기절합니다. "
							+ "\n이 피해는 35%의 저항을 무시합니다."+ ChatColor.WHITE + "음파에 노출된 적인경우 자신의 보호막을 모두 소모해 \n상대방에게 고정피해를 입힙니다. ", false));
		}
		
		
		
		//마법사 스타일 패시브 : 궁극기 : 광속입자파
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "광속입자파"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(29, CreateItem.createItem("나비폭죽", ChatColor.BLUE, Material.ENCHANTED_BOOK,
					ChatColor.WHITE + "기술 : 마법 직격타 피해 : 6 \n"
			+ChatColor.WHITE + "근처의 적에게 미사일을 3개 발사해 6의 피해를 입힙니다.\n"
			+ChatColor.LIGHT_PURPLE+ " 최대 대상 : 3명\n"
			+ ChatColor.WHITE + "강화화상상태의 적에게는 투사체 8개를 발사하며 "
			+ChatColor.AQUA+ "\n투사체가 폭발을 입히면서 최대체력에 비례한 피해를 입힙니다. \n"
			+ChatColor.LIGHT_PURPLE+ "최대 대상 : 3명 ", false));
				}
		
		
		
		
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "노력"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("재능", ChatColor.GREEN, Material.CROSSBOW, ChatColor.WHITE + "기본 : 화살 직격타 피해 : 1\n"+ ChatColor.WHITE + "적 타격 시, 자신의 이동속도가 5초간 증가 (중첩가능)\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.25초\n", false));
		}
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "재능"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("노력", ChatColor.GREEN, Material.BOW, ChatColor.WHITE + "기본 : 화살 직격타 피해 : 2\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.25초"+ ChatColor.WHITE + "", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "활기"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("음침", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 은신\n"+ ChatColor.WHITE + "자신의 모습을 7초간 숨깁니다.\n"+ ChatColor.WHITE + "재사용 대기시간 18초", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "음침"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(29, CreateItem.createItem("활기", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 피해증가\n"+ ChatColor.WHITE + "기본 화살 직격타 피해가 5 증가합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 15초", false));
		}
		
		
		
		
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "광기"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("근성", ChatColor.BLUE, Material.NETHERITE_SWORD, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 1\n"+ChatColor.WHITE + "적 타격 시, 체력을 2 회복합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.5초", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "근성"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("광기", ChatColor.BLUE, Material.BLAZE_POWDER, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 2\n"+ ChatColor.WHITE + "적 타격 시, 체력을 1 회복합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.5초", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "파괴"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("협동", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 스켈레톤 소환\n"+ChatColor.WHITE + "25초동안 적을 공격하는 스켈레톤을 소환합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 10초", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "협동"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "",  false));
			e.getInventory().setItem(29, CreateItem.createItem("파괴", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 좀비 소환\n"+ChatColor.WHITE + "25초동안 적에게 달려드는 좀비를 소환합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 10초", false));
		}
		
		
		
		
		
		
		//확인버튼
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "확인"))
		{
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			if(e.getInventory().getItem(11).getType().equals(Material.BARRIER) && e.getInventory().getItem(29).getType().equals(Material.BARRIER))
			{
				//혼돈 생성 후 플레이어에게 지급.
				ItemStack chaos = CreateItem.createItem("혼돈", ChatColor.GOLD, Material.FIRE_CHARGE, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 1\n"
						+ ChatColor.WHITE + "투사체를 발사해 맞은 적에게 '강화화상' 상태에 빠트립니다.\n"
						+ ChatColor.AQUA + "강화화상 : 체력비례피해를 지속적으로 입힙니다. \n"
						+ ChatColor.WHITE +"화상상태의 적을 투사체로 타격하면 3의 추가데미지를 줍니다. ", false);
				
				//나비폭죽 생성 후 플레이어에게 지급.
				ItemStack butterflying = CreateItem.createItem("나비폭죽", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 마법 직격타 피해 : 6 \n"
						+ChatColor.WHITE + "근처의 적에게 미사일을 3개 발사해 6의 피해를 입힙니다.\n"
						+ChatColor.AQUA + "최대 대상 : 3명\n"
						+ChatColor.WHITE + "강화화상상태의 적에게는 투사체 8개를 발사하며 \n"
						+ChatColor.WHITE + "투사체가 폭발을 입히면서 최대체력에 비례한 피해를 입힙니다.\n"
						+ChatColor.AQUA+"최대 대상 : 3명 ", false);
				e.getView().getPlayer().getInventory().setItem(e.getRawSlot(), chaos);
			}
			//스킬 2가지를 모두 고르고 확인을 눌렀을 때 실행됨.
			if ((e.getInventory().getItem(11).getType().equals(Material.BARRIER) || e.getInventory().getItem(15).getType().equals(Material.BARRIER)) && (e.getInventory().getItem(29).getType().equals(Material.BARRIER) || e.getInventory().getItem(33).getType().equals(Material.BARRIER)))
			{
				Player p = (Player) e.getView().getPlayer();
				
				//플레이어의 스킬 작성 데이터를 저장.
				for (PlayerStatus ps : Main.GamePlayerInfoList)
				{
					if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
					{
						
						ps.isWriteSkillTree = true;
						
						p.getInventory().remove(Material.BOOK);
						p.closeInventory();
						p.sendMessage(ChatColor.GREEN + "기술특성이 적용됐습니다.");
						
						
						//give selected item to player
						
						if(ps.getFirstSkill()) p.getInventory().addItem(Main.AllitemList.get(2));
						
						else p.getInventory().addItem(Main.AllitemList.get(3));
						
						if(ps.getSecondSkill()) p.getInventory().addItem(Main.AllitemList.get(4));
						
						else p.getInventory().addItem(Main.AllitemList.get(5));
						
						
						return;
					}
				}
				
				//리스트에 없는 플레이어일 경우 추방
				
				p.kickPlayer(ChatColor.DARK_RED + "핵 플레이어로 간주, 당신을 추방합니다.");
			}
			
			
			
			else
			{
//				e.setCurrentItem(CreateItem.createItem("거부", ChatColor.DARK_RED, Material.BARRIER, "항목을 확인해주세요.", "", "", false));
				e.setCurrentItem(CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false));
			}
		}
		
		
		
		
		
		
		
		//취소 버튼
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "취소"))
		{
//			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", "", "", false));
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				ps.SkillTreeFirst = false;
				ps.SkillTreeSecond = false;
			}
			e.getView().getPlayer().closeInventory();
			e.getView().getPlayer().sendMessage(ChatColor.DARK_RED + "기술특성을 작성해야 기술을 사용할 수 있습니다.");
		}
		
	}
	
	public static void openGUI(ItemStack firstSelector, ItemStack secondSelector, ItemStack thirdSelector, ItemStack fourthSelector, ItemStack Ok, ItemStack Cancel, Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 54, "기술특성 선택");
		inv.setItem(11, firstSelector);
		inv.setItem(15, secondSelector);
		inv.setItem(29, thirdSelector);
		inv.setItem(33, fourthSelector);
		inv.setItem(48, Ok);
		inv.setItem(50, Cancel);
		for (int i = 0; i < 54; i++)
		{
			if (i != 10 && i != 11 && i != 12 && i != 13 && i != 14 && i != 15 && i != 16 && i != 28 && i != 29 && i != 30 && i != 31 && i != 32 && i != 33 && i != 34 && i != 46 && i != 47 && i != 48 && i != 49 && i != 50 && i != 51 && i != 52)
			{
				inv.setItem(i, new ItemStack(CreateItem.createItem("", ChatColor.WHITE, Material.BLACK_STAINED_GLASS_PANE, "",  false)));
			}
		}
		p.openInventory(inv);
	}
}
