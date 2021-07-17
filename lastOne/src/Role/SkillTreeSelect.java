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
		wA1 = CreateItem.createItem("�˱�", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "�⺻ �� �߰����� : 3\n"+ ChatColor.WHITE + "�� Ÿ�� ��, 10% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.\n", false);
		wA2 = CreateItem.createItem("����", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "�⺻ �� �߰����� : 1\n"+ChatColor.WHITE + "�� Ÿ�� ��, 50% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.\n", false);
		wH1 =CreateItem.createItem("�ͷ�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� ���� ����� ������ �̵�\n"+ChatColor.WHITE + "���� ���ð� : 7��\n"+ ChatColor.WHITE , false);
		wH2 =CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� �̵��ӵ��� 5�ʰ� ����\n"+ChatColor.WHITE + "���� ���ð� : 10��\n"+ ChatColor.WHITE , false);
	
		aA1 =CreateItem.createItem("����", ChatColor.GREEN, Material.BOW, 
				 ChatColor.WHITE + "�ݰ� 8�� �� ��� 1���� ���� ����\n"
				+ ChatColor.AQUA +"�нú� ȿ�� : ȭ�� : ��ų ��븶�� ������ 10%���� (3ȸ)\n"
				+ ChatColor.WHITE+ "ȭ�� �������� ������ ������ �ִ� 3�� ��ø\n"
				+ ChatColor.BLUE +"����ȭ�� : 4��° ��ų ���ط� 10% ����(12��)\n"
				+ ChatColor.GREEN+"���ݵ���ȭ�� : ��Ȯ�� 10% ���� (12��)\n"
				+ ChatColor.RED +"���� ȭ�� : �ż� 1�ܰ辿 �߰� (12��)\n"
				+ ChatColor.WHITE +"��Ÿ� 3���� ����", false);
		aH1 =CreateItem.createItem("�ǳ���", ChatColor.GREEN, Material.CROSSBOW,
				ChatColor.WHITE + "���� ���������� ������ ���ĸ�  �߻�����\n"
				+ ChatColor.AQUA + "�������� ���� ȥ���� ���߸�.\n"
				+ ChatColor.AQUA + "ȥ���� ���� ���� ��õ��� �������°� �Ǹ�\n"
				+ ChatColor.AQUA + "���� ������ 0���� ����\n"
				+ ChatColor.BLUE + "���̳� ��ֹ��� �ε��� ��� �ݴ�������� ���ƿ�"
				+ ChatColor.RED + "ù ���ط� : 200%+ �ִ�ü���� 10% ��������\n"
				+ ChatColor.DARK_BLUE+"2Ÿ ���ط� 300% + ���� ü���� 10% ��������: ",false);
		aA2 =CreateItem.createItem("Ǫ�� �м���", ChatColor.BLUE, Material.ENCHANTED_BOOK, 
				ChatColor.WHITE + "�� Ÿ�ݽ� ����� ���� ��� 2 ����(�ִ� 10��ø)\n"
				+ ChatColor.WHITE + "Ÿ�ݽ� �ڽ��� ��Ȯ�� 2% ����(�ִ� 10��ø)\n"
				+ ChatColor.WHITE + "100%�� ��������\n"
				+ ChatColor.WHITE + "�̵��ӵ� 1�ܰ� ����\n"
				+ ChatColor.WHITE + "����� ���� �� �ָ� ���ĳ�\n"
				+ ChatColor.WHITE + "2�� �̻� ���� ��� ����� ������, ���� �︮������ ��ȭ��.\n"
				, false);
			
		
		aH2 =CreateItem.createItem("�︮�콺 ����", ChatColor.BLUE, Material.ENCHANTED_BOOK, 
				ChatColor.WHITE + "�������� �׸��� ȭ���� �߻��� ���� 1���� �Ÿ� ��� ���ظ� ����\n"
				+ ChatColor.WHITE + "������ �Ÿ��� 5���� �־��� ������ �߰� �ɷ�ġ�� ����\n"
				+ ChatColor.WHITE + "������ �Ÿ��� 5���� �־��� ������ �߰� �ɷ�ġ�� ����\n"
				+ ChatColor.WHITE + "5�� �̳� : 100%�� ���� ����\n"
				+ ChatColor.WHITE + "10�� �̳� : �нú� ġ������ �ϰ�\n"
				+ ChatColor.WHITE + "[120+��Ȯ�� 50%~200+��Ȯ�� 50%]%�� ���� ���ظ� ����\n"
				+ ChatColor.WHITE + "�ߵ� Ȯ���� 35% ����.\n"
				+ ChatColor.WHITE + "15�� �̳�: ġ������ �ϰ� Ȯ���� 75% ����\n"
				+ ChatColor.WHITE + "���� ���� [15 + ��Ȯ�� 10%~35+ ��Ȯ�� 10%]% ����\n"
				+ ChatColor.WHITE + "[150+��Ȯ�� 75%~ ��Ȯ�� 250+75%]% ����\n"
				+ ChatColor.WHITE + "19�� �̳�: ġ������ �ϰ� 100%\n"
				+ ChatColor.WHITE + "ġ������ �ϰ� ���ط� [170 + ��Ȯ�� 125%~350+ ��Ȯ�� 125%]%\n"
				+ ChatColor.WHITE + "20�� �̻�: ġ������ �ϰ� ���ط� \n"
				+ ChatColor.WHITE + "[250 + ��Ȯ�� 250% ~550+ ��Ȯ�� 250%]%\n"
				+ ChatColor.WHITE + "�ʺ� ���� �︮���� : Ǫ�� �м��� ��ȭ��\n"
				+ ChatColor.WHITE + "�︮���� ������ ������ square[2.5+��Ȯ�� 12.25%]��\n"
				+ ChatColor.WHITE + "���� ���ð� 18��", false);
		
		mA1 = CreateItem.createItem("ȥ��", ChatColor.BLUE, Material.FIRE_CHARGE, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 1\n"
				+ ChatColor.WHITE + "����ü�� �߻��� ���� ������ '��ȭȭ��' ���¿� ��Ʈ���ϴ�.\n"
				+ ChatColor.AQUA + "��ȭȭ�� : ü�º�����ظ� ���������� �����ϴ�. \n"
				+ ChatColor.WHITE +"ȭ������� ���� ����ü�� Ÿ���ϸ� 3�� �߰��������� �ݴϴ�. ", false);
				
		mA2 = CreateItem.createItem("����", ChatColor.BLUE, Material.EMERALD, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 3\n"
				+ChatColor.AQUA + "���� ���� : �� Ÿ�� �� ���� ��ġ�� \n"
				+ChatColor.AQUA + "2�ʰ� ���̰� �ϰ� �̵��ӵ��� ����ϴ�.\n"
				+ChatColor.WHITE + "��ȭ : ���ĸ� ���� ������ ���ĸ� ���߸� \n"
				+ChatColor.WHITE + "���ط��� 20% �����ϰ� ���ط��� 30%�� �ش��ϴ� \n��ȣ���� ����ϴ�.", false);
							
		mH1 = CreateItem.createItem("��������", ChatColor.BLUE, Material.BRAIN_CORAL_FAN, ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 6 \n"
				+ChatColor.WHITE + "��ó�� ������ �̻����� 3�� �߻��� 6�� ���ظ� �����ϴ�.\n"
				+ChatColor.AQUA + "�ִ� ��� : 3��\n"
				+ChatColor.WHITE + "��ȭȭ������� �����Դ� ����ü 8���� �߻��ϸ� \n"
				+ChatColor.WHITE + "����ü�� ������ �����鼭 ���ظ� �����ϴ�.\n"
				+ChatColor.AQUA+"�ִ� ��� : 3�� ", false);
							
		mH2 = CreateItem.createItem("����������", ChatColor.BLUE, Material.END_CRYSTAL, ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 30\n"
				+ChatColor.WHITE + "���� ���������� ���� ������ �߻���\n 6�� ���ظ� 5�� �����ϴ�.\n"
				+ChatColor.WHITE + "���� ���� ���� 1.5�ʵ��� �������ϴ�. \n"
				+ChatColor.DARK_PURPLE+"�� ���ش� 35%�� ������ �����մϴ�.\n"
				+ ChatColor.WHITE + "���Ŀ� ����� ���ΰ��\n �ڽ��� ��ȣ���� ��� �Ҹ��� \n"
				+ChatColor.WHITE+"���濡�� �������ظ� �����ϴ�. ", false);
		
		sA1 = CreateItem.createItem("������ ���", ChatColor.BLUE, Material.ENCHANTED_GOLDEN_APPLE,
				ChatColor.WHITE + "�������� ������ ��æƮ ���� ����߷�\n"
				+ ChatColor.GREEN + "����ġ�� ����� ����� ü���� ȸ����Ŵ\n"
				+ ChatColor.RED + "���� ����� ��� ���� 30% ���� ����\n"
				+ ChatColor.WHITE + "������ 10%��ŭ ȸ������ ��ȭ��\n"
				+ ChatColor.WHITE+"���� ���ð� 1��", false);
							
		sA2 = CreateItem.createItem("����", ChatColor.BLUE, Material.BLAZE_POWDER,
				ChatColor.WHITE + "���� Ÿ�ݽ� ���ݼӵ��� 2�ܰ� ����\n"
				+ChatColor.LIGHT_PURPLE+"Ÿ�� �� 3�ʵ��� ������ 120%���ط� ���¿�\n"
			
				, false);
							
		sH1 = CreateItem.createItem("���� ����", ChatColor.BLUE, Material.NETHER_STAR, 
				ChatColor.WHITE + "���� ����"
				+ChatColor.WHITE + "�ݰ� 36�� �̳��� �ִ� ��� �Ʊ����� ����\n"
				+ChatColor.GREEN + "�Ʊ��� �ִ�ü���� 50%�� �߰� ü������ ����.\n"
				+ChatColor.GOLD + "�Ʊ��� ��� ������ �����ϰ� ���ݼӵ��� ���� 3�ܰ� ���� �ο�\n"
				+ChatColor.BLUE+" �⺻���ݽ� ���� 40%�� �߰� ����"
				+ChatColor.WHITE + "���� ���ð� : 10��", false);
							
		sH2 = CreateItem.createItem("õ��", ChatColor.BLUE, Material.FIREWORK_ROCKET,
				ChatColor.BLUE + "���濡 ������ �ļ� ���� 100%�� ���� 2�� ����\n"
				+ChatColor.LIGHT_PURPLE + "��ȭ�� ��󿡰Դ� 3.5�� �������ظ� ����\n"
				+ChatColor.AQUA+"�ǰ� ��󿡰Դ� ���� ȿ���� 6�ʵ��� ����"
				+ ChatColor.WHITE + "���� ���ð� : 6��", false);
	}
	
	//����Ư�� å�� ��ȣ�ۿ� �� �� ȣ��Ǵ� �̺�Ʈ�ڵ鷯
	
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
	//lastone join���� ��������â ui ���� �κ�.
	
	
	@EventHandler
	public void useItemOpenGUI(PlayerInteractEvent e)
	{
		
		
		p = e.getPlayer();
		findPS(p);
		
		createItem();
		
		//������ ���� �������� �ʾҴٸ� ���� ó���� ���� ����.
		if(p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) return;
		//���� ��ų ����â
		
		try {
			if (!p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals(ChatColor.DARK_RED + "(���� �� ����)") || !p.getInventory().getItemInMainHand().getType().equals(Material.BOOK)) return;
				
		}
		
		catch(NullPointerException ex)
		{
			return;
		}
		
			
			
			
			//���ݱ�� ��ų ���� â
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "���� ��� - ���Ư�� å"))
			{
				openGUI(wA1,wA2,wH1,wH2,CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "",  false),
						CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
			}
			
			
			
			
			//�ı������� ��ų ���� â
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "�ı� ������ - ���Ư�� å"))
			{
				openGUI(mA1,mA2,mH1,mH2,
				
				CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
				CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
			
			
			
			//�� ��ɲ� ��ų ���� â
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "�� ��ɲ� - ���Ư�� å"))
			{
				openGUI(aA1,aA2,aH1,aH2,CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
				
			}
			
			
			//��ȥġ���� ��ų ���� â
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "��ȥ ġ���� - ���Ư�� å"))
			{
				openGUI(sA1,sA2,sH1,sH2,
			CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
			CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
		
	}
	
	
	
	
	
	@EventHandler
	public void InventoryForceClose(InventoryCloseEvent e)
	{
		
		//���Ư�� ������ �̺�Ʈ ó��.
		if (!e.getView().getTitle().equals("���Ư�� ����")) return;
		
	
				
		//��� Ư�� ���ý� �н�
		if (ps.isWriteSkillTree().equals(true)) return;
				
				
		else
		{	//���������� ���� ��� ��ų�� �� ���� ����.
			ps.SkillTreeFirst = false;
			ps.SkillTreeSecond = false;
			e.getView().getPlayer().sendMessage(ChatColor.DARK_RED + "���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�.");
			return;
		}
		
			
		
	}
	
	
	
	//������ųâ�� ���� Ŭ�� �̺�Ʈ�� ó��.
	@EventHandler
	public void choiceSkillTree(InventoryClickEvent e)
	{
		p = (Player) e.getView().getPlayer();
		
		InventoryView invV = e.getView();
		
		HumanEntity human = invV.getPlayer();
		if (!invV.getTitle().equals("���Ư�� ����")) return;

		e.setCancelled(true);
		
		
		//�̹� ���õ� ������ �踮��� ����.
		if (e.getCurrentItem().getType().equals(Material.BARRIER))
		{
			//PASS
		}
		
		
		//���� ��Ÿ�� �нú� : �⺻��ų : �˱�
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "�˱�"))
		{
			
			ps.SkillTreeFirst = true;
				
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(15, CreateItem.createItem("����", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "�⺻ �� ���� : 2"+ChatColor.WHITE + "�� Ÿ�� ��, 50% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.", false));
		}
		
		
		//���� ��Ÿ�� �нú� : �⺻��ų : ����
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "����"))
		{
			
			ps.SkillTreeFirst = false;
		
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(11, CreateItem.createItem("�˱�", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "�⺻ �� ���� : 4 "+ ChatColor.WHITE + "�� Ÿ�� ��, 10% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.", false));
		}
		
		
		
		//���� ��Ÿ�� �нú� : �ñر� : �ͷ�
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "�ͷ�"))
		{
			
			ps.SkillTreeSecond = true;
	
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(33, CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� �̵��ӵ��� 5�ʰ� ����\n"+ChatColor.WHITE + "���� ���ð� : 10��\n"+ ChatColor.WHITE , false));
		}
		
		
		
		//���� ��Ÿ�� �нú� : �ñر� : ����
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
			
			ps.SkillTreeSecond = false;
		
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(29, CreateItem.createItem("�ͷ�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� ���� ����� ������ �̵�\n"+ChatColor.WHITE + "���� ���ð� : 7��\n"+ ChatColor.WHITE , false));
		}
		
	
		
		
		//������ ��Ÿ�� �нú� : �⺻��ų : ȥ��Ŭ���� ȥ�� ��ȯ.
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "ȥ��"))
		{
			
		
			ps.SkillTreeFirst = true;

		
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
			//e.getInventory().setItem(15,mA1);
			
		}
		
		
		
		//������ ��Ÿ�� �нú� : �⺻��ų : ����
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
	
			ps.SkillTreeFirst = false;
		
	
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
			//e.getInventory().setItem(11, mA2);
			
			
		}
		
		
		
		//������ ��Ÿ�� �нú� : �ñر� : ��������
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "��������"))
		{
			
			ps.SkillTreeSecond = true;

			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
			
		}
		
		
		
		//������ ��Ÿ�� �нú� : �ñر� : ����������
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����������"))
		{
		
			ps.SkillTreeSecond = false;
				
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		
		
		
		//�ü�
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "����"))
		{
		
			ps.SkillTreeFirst = true;

			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(15, CreateItem.createItem("���", ChatColor.GREEN, Material.CROSSBOW, ChatColor.WHITE + "�⺻ : ȭ�� ����Ÿ ���� : 1\n"+ ChatColor.WHITE + "�� Ÿ�� ��, �ڽ��� �̵��ӵ��� 5�ʰ� ���� (��ø����)\n"+ ChatColor.WHITE + "���� ���ð� : 0.25��\n", false));
		}
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Ǫ�� �м���"))
		{
		
			ps.SkillTreeFirst = false;
			
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(11, CreateItem.createItem("���", ChatColor.GREEN, Material.BOW, ChatColor.WHITE + "�⺻ : ȭ�� ����Ÿ ���� : 2\n"+ ChatColor.WHITE + "���� ���ð� : 0.25��"+ ChatColor.WHITE + "", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "�Ƹ�������"))
		{
		
			ps.SkillTreeSecond = true;
				
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(33, CreateItem.createItem("��ħ", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ����\n"+ ChatColor.WHITE + "�ڽ��� ����� 7�ʰ� ����ϴ�.\n"+ ChatColor.WHITE + "���� ���ð� 18��", false));
		}
		
		
		
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "�︮�콺 ����"))
		{
		
			ps.SkillTreeSecond = false;
			
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			//e.getInventory().setItem(29, CreateItem.createItem("Ȱ��", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ��������\n"+ ChatColor.WHITE + "�⺻ ȭ�� ����Ÿ ���ذ� 5 �����մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 15��", false));
		}
		
		
		
		//��ȥ ġ����
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "������ ���"))
		{
			
			ps.SkillTreeFirst = true;
			
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
			
			ps.SkillTreeFirst = false;
				
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "���� ����"))
		{
	
			ps.SkillTreeSecond = true;
				
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "õ��"))
		{
		
			ps.SkillTreeSecond = false;
					
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "",  false));
			
		}
		
		
		
		
		
		
		//Ȯ�ι�ư�� ������ ��
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Ȯ��"))
		{
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			
			
			//��ų ������ ������ �ֱ�
			if ((e.getInventory().getItem(11).getType().equals(Material.BARRIER) || e.getInventory().getItem(15).getType().equals(Material.BARRIER)) && (e.getInventory().getItem(29).getType().equals(Material.BARRIER) || e.getInventory().getItem(33).getType().equals(Material.BARRIER)))
			{
				
				//�÷��̾��� ��ų �ۼ� �����͸� ����.
				for (PlayerStatus ps : Main.GamePlayerInfoList)
				{
					if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
					{
						
						ps.isWriteSkillTree = true;
						
						p.getInventory().remove(Material.BOOK);
						p.closeInventory();
						p.sendMessage(ChatColor.GREEN + "���Ư���� ����ƽ��ϴ�.");
						
						
					
						if(ps.getJob().equalsIgnoreCase("���� ���") )
						{
							//���� ������ �� �� ����
							p.getInventory().remove(Material.DIAMOND_SWORD);
							p.getInventory().remove(Material.ENCHANTED_BOOK);
							
							if(ps.getFirstSkill())	p.getInventory().addItem(wA1);
							
							else p.getInventory().addItem(wA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(wH1);
							
							else p.getInventory().addItem(wH2);
							
							ps.setPower(10);
							
						}
						
						else if(ps.getJob().contentEquals("�ı� ������"))
						{
							p.getInventory().remove(Material.BLAZE_ROD);
							p.getInventory().remove(Material.MUSIC_DISC_PIGSTEP);
							if(ps.getFirstSkill())	p.getInventory().addItem(mA1);
							
							else p.getInventory().addItem(mA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(mH1);
							
							else p.getInventory().addItem(mH2);
							
							ps.setIntelligence(10);
						}
						
						else if(ps.getJob().contentEquals("�� ��ɲ�"))
						{
							p.getInventory().remove(Material.BOW);
							p.getInventory().remove(Material.CROSSBOW);
							if(ps.getFirstSkill())	p.getInventory().addItem(aA1);
							
							else p.getInventory().addItem(aA2);
							
							if(ps.getSecondSkill()) p.getInventory().addItem(aH1);
							
							else p.getInventory().addItem(aH2);
							
							ps.setPower(10);
						}
						
						else if(ps.getJob().contentEquals("��ȥ ġ����"))
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
				//e.setCurrentItem(CreateItem.createItem("�ź�", ChatColor.DARK_RED, Material.BARRIER, "�׸��� Ȯ�����ּ���.", false));
				e.setCurrentItem(CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false));
			}
		}
		
		
		
		
		
		
		
		//��� ��ư
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "���"))
		{
			//e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", "", "", false));
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				ps.SkillTreeFirst = false;
				ps.SkillTreeSecond = false;
			}
			e.getView().getPlayer().closeInventory();
			e.getView().getPlayer().sendMessage(ChatColor.DARK_RED + "���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�.");
		}
	}
		

	
	public static void openGUI(ItemStack firstSelector, ItemStack secondSelector, ItemStack thirdSelector, ItemStack fourthSelector, ItemStack Ok, ItemStack Cancel, Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 54, "���Ư�� ����");
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
