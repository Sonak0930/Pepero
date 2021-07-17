package Role;

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

import Player.PlayerStatus;
import lastOne.Cooltime;
import lastOne.Cooltime.skilltype;
import lastOne.CreateItem;
import lastOne.Main;

public class SkillTreeSelect implements Listener
{
	PlayerStatus ps;
	Player p;
	
	private ItemStack wA1,wA2,wH1,wH2,mA1,mA2,mH1,mH2,aA1,aA2,aH1,aH2,sA1,sA2,sH1,sH2;
	
	private void createItem()
	{
		wA1 = CreateItem.createItem("검기", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "기본 검 추가피해 : 3\n"+ ChatColor.WHITE + "적 타격 시, 10% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.\n", false);
		wA2 = CreateItem.createItem("원한", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기본 검 추가피해 : 1\n"+ChatColor.WHITE + "적 타격 시, 50% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.\n", false);
		wH1 =CreateItem.createItem("맹렬", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적중 가장 가까운 적에게 이동\n"+ChatColor.WHITE + "재사용 대기시간 : 7초\n"+ ChatColor.WHITE , false);
		wH2 =CreateItem.createItem("저주", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적의 이동속도를 5초간 감소\n"+ChatColor.WHITE + "재사용 대기시간 : 10초\n"+ ChatColor.WHITE , false);
	
		aA1 =CreateItem.createItem("정악", ChatColor.GREEN, Material.BOW, 
				 ChatColor.WHITE + "반경 8블럭 내 대상 1명에게 물리 피해\n"
				+ ChatColor.AQUA +"패시브 효과 : 화음 : 스킬 사용마다 데미지 10%증가 (3회)\n"
				+ ChatColor.WHITE+ "화음 종류마다 각각의 버프가 최대 3번 중첩\n"
				+ ChatColor.BLUE +"으뜸화음 : 4번째 스킬 피해량 10% 증가(12초)\n"
				+ ChatColor.GREEN+"버금딸림화음 : 정확함 10% 증가 (12초)\n"
				+ ChatColor.RED +"딸림 화음 : 신속 1단계씩 추가 (12초)\n"
				+ ChatColor.WHITE +"사거리 3블럭씩 증가", false);
		aH1 =CreateItem.createItem("피날레", ChatColor.GREEN, Material.CROSSBOW,
				ChatColor.WHITE + "전방 직선범위에 강력한 음파를  발생시켜\n"
				+ ChatColor.AQUA + "범위안의 적을 혼란에 빠뜨림.\n"
				+ ChatColor.AQUA + "혼란에 빠진 적은 잠시동안 무방비상태가 되며\n"
				+ ChatColor.AQUA + "물리 방어력이 0으로 적용\n"
				+ ChatColor.BLUE + "벽이나 장애물에 부딪힐 경우 반대방향으로 돌아옴"
				+ ChatColor.RED + "첫 피해량 : 200%+ 최대체력의 10% 물리피해\n"
				+ ChatColor.DARK_BLUE+"2타 피해량 300% + 잃은 체력의 10% 물리피해: ",false);
		aA2 =CreateItem.createItem("푸른 분쇄자", ChatColor.BLUE, Material.ENCHANTED_BOOK, 
				ChatColor.WHITE + "적 타격시 상대의 물리 방어 2 감소(최대 10중첩)\n"
				+ ChatColor.WHITE + "타격시 자신의 정확함 2% 증가(최대 10중첩)\n"
				+ ChatColor.WHITE + "100%의 물리피해\n"
				+ ChatColor.WHITE + "이동속도 1단계 증가\n"
				+ ChatColor.WHITE + "가까운 적을 더 멀리 밀쳐냄\n"
				+ ChatColor.WHITE + "2번 이상 맞출 경우 대상이 빛나며, 혜성 헬리오스가 강화됨.\n"
				, false);
			
		
		aH2 =CreateItem.createItem("헬리우스 혜성", ChatColor.BLUE, Material.ENCHANTED_BOOK, 
				ChatColor.WHITE + "포물선을 그리는 화살을 발사해 맞은 1명에게 거리 비례 피해를 입힘\n"
				+ ChatColor.WHITE + "적과의 거리가 5블럭씩 멀어질 때마다 추가 능력치를 얻음\n"
				+ ChatColor.WHITE + "적과의 거리가 5블럭씩 멀어질 때마다 추가 능력치를 얻음\n"
				+ ChatColor.WHITE + "5블럭 이내 : 100%의 물리 피해\n"
				+ ChatColor.WHITE + "10블럭 이내 : 패시브 치명적인 일격\n"
				+ ChatColor.WHITE + "[120+정확함 50%~200+정확함 50%]%의 물리 피해를 입힘\n"
				+ ChatColor.WHITE + "발동 확률이 35% 증가.\n"
				+ ChatColor.WHITE + "15블럭 이내: 치명적인 일격 확률이 75% 증가\n"
				+ ChatColor.WHITE + "물리 방어력 [15 + 정확함 10%~35+ 정확함 10%]% 무시\n"
				+ ChatColor.WHITE + "[150+정확함 75%~ 정확함 250+75%]% 무시\n"
				+ ChatColor.WHITE + "19블럭 이내: 치명적인 일격 100%\n"
				+ ChatColor.WHITE + "치명적인 일격 피해량 [170 + 정확함 125%~350+ 정확함 125%]%\n"
				+ ChatColor.WHITE + "20블럭 이상: 치명적인 일격 피해량 \n"
				+ ChatColor.WHITE + "[250 + 정확함 250% ~550+ 정확함 250%]%\n"
				+ ChatColor.WHITE + "쪽빛 혜성 헬리오스 : 푸른 분쇄자 강화형\n"
				+ ChatColor.WHITE + "헬리오스 혜성의 위력이 square[2.5+정확함 12.25%]배\n"
				+ ChatColor.WHITE + "재사용 대기시간 18초", false);
		
		mA1 = CreateItem.createItem("혼돈", ChatColor.BLUE, Material.FIRE_CHARGE, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 1\n"
				+ ChatColor.WHITE + "투사체를 발사해 맞은 적에게 '강화화상' 상태에 빠트립니다.\n"
				+ ChatColor.AQUA + "강화화상 : 체력비례피해를 지속적으로 입힙니다. \n"
				+ ChatColor.WHITE +"화상상태의 적을 투사체로 타격하면 3의 추가데미지를 줍니다. ", false);
				
		mA2 = CreateItem.createItem("음파", ChatColor.BLUE, Material.EMERALD, ChatColor.WHITE + "기본 : 마법 직격타 피해 : 3\n"
				+ChatColor.AQUA + "음파 투시 : 적 타격 시 적의 위치를 \n"
				+ChatColor.AQUA + "2초간 보이게 하고 이동속도를 늦춥니다.\n"
				+ChatColor.WHITE + "동화 : 음파를 맞춘 적에게 음파를 맞추면 \n"
				+ChatColor.WHITE + "피해량이 20% 증가하고 피해량의 30%에 해당하는 \n보호막을 얻습니다.", false);
							
		mH1 = CreateItem.createItem("나비폭죽", ChatColor.BLUE, Material.BRAIN_CORAL_FAN, ChatColor.WHITE + "기술 : 마법 직격타 피해 : 6 \n"
				+ChatColor.WHITE + "근처의 적에게 미사일을 3개 발사해 6의 피해를 입힙니다.\n"
				+ChatColor.AQUA + "최대 대상 : 3명\n"
				+ChatColor.WHITE + "강화화상상태의 적에게는 투사체 8개를 발사하며 \n"
				+ChatColor.WHITE + "투사체가 폭발을 입히면서 피해를 입힙니다.\n"
				+ChatColor.AQUA+"최대 대상 : 3명 ", false);
							
		mH2 = CreateItem.createItem("광속입자파", ChatColor.BLUE, Material.END_CRYSTAL, ChatColor.WHITE + "기술 : 마법 직격타 피해 : 30\n"
				+ChatColor.WHITE + "전방 직선범위에 마법 포격을 발사해\n 6의 피해를 5번 입힙니다.\n"
				+ChatColor.WHITE + "범위 안의 적은 1.5초동안 느려집니다. \n"
				+ChatColor.DARK_PURPLE+"이 피해는 35%의 저항을 무시합니다.\n"
				+ ChatColor.WHITE + "음파에 노출된 적인경우\n 자신의 보호막을 모두 소모해 \n"
				+ChatColor.WHITE+"상대방에게 고정피해를 입힙니다. ", false);
		
		sA1 = CreateItem.createItem("숭고한 희생", ChatColor.BLUE, Material.ENCHANTED_GOLDEN_APPLE,
				ChatColor.WHITE + "동서남북 범위에 인챈트 병을 떨어뜨려\n"
				+ ChatColor.GREEN + "경험치를 흡수한 대상의 체력을 회복시킴\n"
				+ ChatColor.RED + "적이 흡수할 경우 지능 30% 마법 피해\n"
				+ ChatColor.WHITE + "지능의 10%만큼 회복력이 강화됨\n"
				+ ChatColor.WHITE+"재사용 대기시간 1초", false);
							
		sA2 = CreateItem.createItem("단죄", ChatColor.BLUE, Material.BLAZE_POWDER,
				ChatColor.WHITE + "직접 타격시 공격속도가 2단계 증가\n"
				+ChatColor.LIGHT_PURPLE+"타격 후 3초동안 지능의 120%피해로 불태움\n"
			
				, false);
							
		sH1 = CreateItem.createItem("신의 구원", ChatColor.BLUE, Material.NETHER_STAR, 
				ChatColor.WHITE + "신의 구원"
				+ChatColor.WHITE + "반경 36블럭 이내에 있는 모든 아군에게 적용\n"
				+ChatColor.GREEN + "아군의 최대체력의 50%를 추가 체력으로 얻음.\n"
				+ChatColor.GOLD + "아군의 모든 버프를 해제하고 공격속도와 저항 3단계 버프 부여\n"
				+ChatColor.BLUE+" 기본공격시 지능 40%의 추가 피해"
				+ChatColor.WHITE + "재사용 대기시간 : 10초", false);
							
		sH2 = CreateItem.createItem("천뇌", ChatColor.BLUE, Material.FIREWORK_ROCKET,
				ChatColor.BLUE + "전방에 벼락을 쳐서 지능 100%의 피해 2번 입힘\n"
				+ChatColor.LIGHT_PURPLE + "둔화된 대상에게는 3.5배 마법피해를 입힘\n"
				+ChatColor.AQUA+"피격 대상에게는 단죄 효과가 6초동안 적용"
				+ ChatColor.WHITE + "재사용 대기시간 : 6초", false);
	}
	
	//직업특성 책과 상호작용 할 때 호출되는 이벤트핸들러
	
	private void findPS(Player player)
	{
		for(PlayerStatus ps: Main.GamePlayerInfoList)
		{
			if (ps.getPlayer().getName().equals(player.getName()))
			{
				this.ps = ps;
			}
				
		}
	}
	//lastone join이후 직업선택창 ui 띄우는 부분.
	
	
	@EventHandler
	public void useItemOpenGUI(PlayerInteractEvent e)
	{
		
		
		p = e.getPlayer();
		findPS(p);
		
		createItem();
		
		//직업을 현재 세팅하지 않았다면 굳이 처리할 이유 없음.
		if(p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) return;
		//직업 스킬 선택창
		
		try {
			if (!p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals(ChatColor.DARK_RED + "(버릴 수 없음)") || !p.getInventory().getItemInMainHand().getType().equals(Material.BOOK)) return;
				
		}
		
		catch(NullPointerException ex)
		{
			return;
		}
		
			
			
			
			//돌격기사 스킬 선택 창
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "돌격 기사 - 기술특성 책"))
			{
				openGUI(wA1,wA2,wH1,wH2,CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "",  false),
						CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
			}
			
			
			
			
			//파괴마법사 스킬 선택 창
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "파괴 마법사 - 기술특성 책"))
			{
				openGUI(mA1,mA2,mH1,mH2,
				
				CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
				CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
			
			
			
			//숲 사냥꾼 스킬 선택 창
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "숲 사냥꾼 - 기술특성 책"))
			{
				openGUI(aA1,aA2,aH1,aH2,CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
				
			}
			
			
			//영혼치유사 스킬 선택 창
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "영혼 치유사 - 기술특성 책"))
			{
				openGUI(sA1,sA2,sH1,sH2,
			CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
			CreateItem.createItem("취소", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
		
	}
	
	
	
	
	
	@EventHandler
	public void InventoryForceClose(InventoryCloseEvent e)
	{
		
		//기술특성 선택후 이벤트 처리.
		if (!e.getView().getTitle().equals("기술특성 선택")) return;
		
	
				
		//기술 특성 선택시 패스
		if (ps.isWriteSkillTree().equals(true)) return;
				
				
		else
		{	//선택을하지 않은 경우 스킬을 못 쓰게 막음.
			ps.SkillTreeFirst = false;
			ps.SkillTreeSecond = false;
			e.getView().getPlayer().sendMessage(ChatColor.DARK_RED + "기술특성을 작성해야 기술을 사용할 수 있습니다.");
			return;
		}
		
			
		
	}
	
	
	
	//직업스킬창에 대한 클릭 이벤트를 처리.
	@EventHandler
	public void choiceSkillTree(InventoryClickEvent e)
	{
		p = (Player) e.getView().getPlayer();
		
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
			
			ps.SkillTreeFirst = true;
				
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(15, CreateItem.createItem("원한", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기본 검 피해 : 2"+ChatColor.WHITE + "적 타격 시, 50% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.", false));
		}
		
		
		//전사 스타일 패시브 : 기본스킬 : 원한
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "원한"))
		{
			
			ps.SkillTreeFirst = false;
		
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(11, CreateItem.createItem("검기", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "기본 검 피해 : 4 "+ ChatColor.WHITE + "적 타격 시, 10% 확률로 타격한 적에게 표식을 남깁니다.\n"+ ChatColor.WHITE + "표식이 남겨진 적은 10초뒤에 적에게 번개가 내리칩니다.", false));
		}
		
		
		
		//전사 스타일 패시브 : 궁극기 : 맹렬
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "맹렬"))
		{
			
			ps.SkillTreeSecond = true;
	
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(33, CreateItem.createItem("저주", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적의 이동속도를 5초간 감소\n"+ChatColor.WHITE + "재사용 대기시간 : 10초\n"+ ChatColor.WHITE , false));
		}
		
		
		
		//전사 스타일 패시브 : 궁극기 : 저주
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "저주"))
		{
			
			ps.SkillTreeSecond = false;
		
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(29, CreateItem.createItem("맹렬", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 표식이 남겨진 적중 가장 가까운 적에게 이동\n"+ChatColor.WHITE + "재사용 대기시간 : 7초\n"+ ChatColor.WHITE , false));
		}
		
	
		
		
		//마법사 스타일 패시브 : 기본스킬 : 혼돈클릭시 혼돈 반환.
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "혼돈"))
		{
			
		
			ps.SkillTreeFirst = true;

		
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			//e.getInventory().setItem(15,mA1);
			
		}
		
		
		
		//마법사 스타일 패시브 : 기본스킬 : 음파
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "음파"))
		{
	
			ps.SkillTreeFirst = false;
		
	
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			//e.getInventory().setItem(11, mA2);
			
			
		}
		
		
		
		//마법사 스타일 패시브 : 궁극기 : 나비폭죽
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "나비폭죽"))
		{
			
			ps.SkillTreeSecond = true;

			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			
		}
		
		
		
		//마법사 스타일 패시브 : 궁극기 : 광속입자파
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "광속입자파"))
		{
		
			ps.SkillTreeSecond = false;
				
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		
		
		
		//궁수
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "정악"))
		{
		
			ps.SkillTreeFirst = true;

			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(15, CreateItem.createItem("재능", ChatColor.GREEN, Material.CROSSBOW, ChatColor.WHITE + "기본 : 화살 직격타 피해 : 1\n"+ ChatColor.WHITE + "적 타격 시, 자신의 이동속도가 5초간 증가 (중첩가능)\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.25초\n", false));
		}
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "푸른 분쇄자"))
		{
		
			ps.SkillTreeFirst = false;
			
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(11, CreateItem.createItem("노력", ChatColor.GREEN, Material.BOW, ChatColor.WHITE + "기본 : 화살 직격타 피해 : 2\n"+ ChatColor.WHITE + "재사용 대기시간 : 0.25초"+ ChatColor.WHITE + "", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "아르페지오"))
		{
		
			ps.SkillTreeSecond = true;
				
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(33, CreateItem.createItem("음침", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 은신\n"+ ChatColor.WHITE + "자신의 모습을 7초간 숨깁니다.\n"+ ChatColor.WHITE + "재사용 대기시간 18초", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "헬리우스 혜성"))
		{
		
			ps.SkillTreeSecond = false;
			
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(29, CreateItem.createItem("활기", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "기술 : 피해증가\n"+ ChatColor.WHITE + "기본 화살 직격타 피해가 5 증가합니다.\n"+ ChatColor.WHITE + "재사용 대기시간 : 15초", false));
		}
		
		
		
		//영혼 치유사
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "숭고한 희생"))
		{
			
			ps.SkillTreeFirst = true;
			
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "단죄"))
		{
			
			ps.SkillTreeFirst = false;
				
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "신의 구원"))
		{
	
			ps.SkillTreeSecond = true;
				
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "천뇌"))
		{
		
			ps.SkillTreeSecond = false;
					
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "",  false));
			
		}
		
		
		
		
		
		
		//확인버튼을 눌렀을 때
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "확인"))
		{
			e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", false));
			
			
			//스킬 선택후 아이템 주기
			if ((e.getInventory().getItem(11).getType().equals(Material.BARRIER) || e.getInventory().getItem(15).getType().equals(Material.BARRIER)) && (e.getInventory().getItem(29).getType().equals(Material.BARRIER) || e.getInventory().getItem(33).getType().equals(Material.BARRIER)))
			{
				
				//플레이어의 스킬 작성 데이터를 저장.
				for (PlayerStatus ps : Main.GamePlayerInfoList)
				{
					if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
					{
						
						ps.isWriteSkillTree = true;
						
						p.getInventory().remove(Material.BOOK);
						p.closeInventory();
						p.sendMessage(ChatColor.GREEN + "기술특성이 적용됐습니다.");
						
						
					
						if(ps.getJob().equalsIgnoreCase("돌격 기사") )
						{
							//기존 아이템 두 개 제거
							p.getInventory().remove(Material.DIAMOND_SWORD);
							p.getInventory().remove(Material.ENCHANTED_BOOK);
							
							if(ps.getFirstSkill())	p.getInventory().addItem(wA1);
							
							else p.getInventory().addItem(wA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(wH1);
							
							else p.getInventory().addItem(wH2);
							
							ps.setPower(10);
							
						}
						
						else if(ps.getJob().contentEquals("파괴 마법사"))
						{
							p.getInventory().remove(Material.BLAZE_ROD);
							p.getInventory().remove(Material.MUSIC_DISC_PIGSTEP);
							if(ps.getFirstSkill())	p.getInventory().addItem(mA1);
							
							else p.getInventory().addItem(mA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(mH1);
							
							else p.getInventory().addItem(mH2);
							
							ps.setIntelligence(10);
						}
						
						else if(ps.getJob().contentEquals("숲 사냥꾼"))
						{
							p.getInventory().remove(Material.BOW);
							p.getInventory().remove(Material.CROSSBOW);
							if(ps.getFirstSkill())	p.getInventory().addItem(aA1);
							
							else p.getInventory().addItem(aA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(aH1);
							
							else p.getInventory().addItem(aH2);
							
							ps.setPower(10);
						}
						
						else if(ps.getJob().contentEquals("영혼 치유사"))
						{
							p.getInventory().remove(Material.ENCHANTED_GOLDEN_APPLE);
							p.getInventory().remove(Material.BLAZE_POWDER);
							if(ps.getFirstSkill())	p.getInventory().addItem(sA1);
							
							else p.getInventory().addItem(sA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(sH1);
							
							else p.getInventory().addItem(sH2);
							
							ps.setIntelligence(10);
							
							ps.CooldownMap.put(skilltype.Active, 0.0);
							ps.CooldownMap.put(skilltype.Hyper, 0.0);
						}
						
					}
				}
				
			}
			
			else
			{
				//e.setCurrentItem(CreateItem.createItem("거부", ChatColor.DARK_RED, Material.BARRIER, "항목을 확인해주세요.", false));
				e.setCurrentItem(CreateItem.createItem("확인", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false));
			}
		}
		
		
		
		
		
		
		
		//취소 버튼
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "취소"))
		{
			//e.setCurrentItem(CreateItem.createItem("선택됨", ChatColor.WHITE, Material.BARRIER, "", "", "", false));
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
