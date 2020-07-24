package CustomEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
	@EventHandler
	public void useItemOpenGUI(PlayerInteractEvent e)
	{
		if (!e.getHand().equals(EquipmentSlot.HAND)) return;
		
		Player p = e.getPlayer();
		// �Ʒ� �׸�鿡 ���� ���� ���� ä�� �� ****************************************************************************
		if (p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals(ChatColor.DARK_RED + "(���� �� ����)") && p.getInventory().getItemInMainHand().getType().equals(Material.BOOK))
		{
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "���� ��� - ���Ư�� å"))
			{
				openGUI(CreateItem.createItem("�˱�", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "�⺻ �� �߰����� : 3\n"+ ChatColor.WHITE + "�� Ÿ�� ��, 10% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.\n", false),
						CreateItem.createItem("����", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "�⺻ �� �߰����� : 1\n"+ChatColor.WHITE + "�� Ÿ�� ��, 50% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.\n", false),
						CreateItem.createItem("�ͷ�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� ���� ����� ������ �̵�\n"+ChatColor.WHITE + "���� ���ð� : 7��\n"+ ChatColor.WHITE , false),
						CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� �̵��ӵ��� 5�ʰ� ����\n"+ChatColor.WHITE + "���� ���ð� : 10��\n"+ ChatColor.WHITE , false),
						CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "",  false),
						CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
			}
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "�ı� ������ - ���Ư�� å"))
			{
				openGUI(CreateItem.createItem("ȥ��", ChatColor.GOLD, Material.FIRE_CHARGE, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 1\n"+ ChatColor.WHITE + "����ü�� �߻��� ���� ������ '��ȭȭ��' ���¿� ��Ʈ���ϴ�.\n"+ ChatColor.WHITE + "��ȭȭ�� : ü�º�����ظ� ���������� �����ϴ�. \nȭ������� ���� ����ü�� Ÿ���ϸ� 3�� �߰��������� �ݴϴ�. ", false),
						CreateItem.createItem("����", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 3\n"+ChatColor.WHITE + "���� ���� : �� Ÿ�� �� ���� ��ġ�� \n2�ʰ� ���̰� �ϰ� �̵��ӵ��� ����ϴ�.\n"+ ChatColor.WHITE + "��ȭ : ���ĸ� ���� ������ ���ĸ� ���߸� \n���ط��� 20% �����ϰ� ���ط��� 30%�� �ش��ϴ� \n��ȣ���� ����ϴ�.", false),
						CreateItem.createItem("��������", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 6 \n"+ChatColor.WHITE + "��ó�� ������ �̻����� 3�� �߻��� 6�� ���ظ� �����ϴ�.\n �ִ� ��� : 3��"+ ChatColor.WHITE + "��ȭȭ������� �����Դ� ����ü 8���� �߻��ϸ� \n����ü�� ������ �����鼭 �ִ�ü�¿� ����� ���ظ� �����ϴ�. \n�ִ� ��� : 3�� ", false),
						CreateItem.createItem("����������", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 30\n"+ChatColor.WHITE + "���� ���������� ���� ������ �߻��� 6�� ���ظ� 5�� �����ϴ�.\n���� ���� ���� 1.5�ʵ��� �����մϴ�. \n�� ���ش� 35%�� ������ �����մϴ�."+ ChatColor.WHITE + "���Ŀ� ����� ���ΰ�� �ڽ��� ��ȣ���� ��� �Ҹ��� \n���濡�� �������ظ� �����ϴ�. ", false),
						CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "�� ��ɲ� - ���Ư�� å"))
			{
				openGUI(CreateItem.createItem("���", ChatColor.GREEN, Material.BOW, ChatColor.WHITE + "�⺻ : ȭ�� ����Ÿ ���� : 2\n"+ ChatColor.WHITE + "���� ���ð� : 0.25��\n"+ ChatColor.WHITE , false),
						CreateItem.createItem("���", ChatColor.GREEN, Material.CROSSBOW, ChatColor.WHITE + "�⺻ : ȭ�� ����Ÿ ���� : 1\n"+ ChatColor.WHITE + "�� Ÿ�� ��, �ڽ��� �̵��ӵ��� 5�ʰ� ���� (��ø����)\n"+ ChatColor.WHITE + "���� ���ð� : 0.25��", false),
						CreateItem.createItem("Ȱ��", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ��������\n"+ ChatColor.WHITE + "�⺻ ȭ�� ����Ÿ ���ذ� 5 �����մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 15��", false),
						CreateItem.createItem("��ħ", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ����\n"+ ChatColor.WHITE + "�ڽ��� ����� 7�ʰ� ����ϴ�.\n"+ ChatColor.WHITE + "���� ���ð� 18��", false),
						CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "",  false), p);
				
			}
			else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "��ȥ ġ���� - ���Ư�� å"))
			{
				openGUI(CreateItem.createItem("����", ChatColor.BLUE, Material.BLAZE_POWDER, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 2\n"+ ChatColor.WHITE + "�� Ÿ�� ��, ü���� 1 ȸ���մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 0.5��", false),
						CreateItem.createItem("�ټ�", ChatColor.BLUE, Material.NETHERITE_SWORD, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 1"+ChatColor.WHITE + "�� Ÿ�� ��, ü���� 2 ȸ���մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 0.5��", false),
						CreateItem.createItem("�ı�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���� ��ȯ"+ChatColor.WHITE + "25�ʵ��� ������ �޷���� ���� ��ȯ�մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 10��", false),
						CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���̷��� ��ȯ"+ChatColor.WHITE + "25�ʵ��� ���� �����ϴ� ���̷����� ��ȯ�մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 10��", false),
						CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false),
						CreateItem.createItem("���", ChatColor.RED, Material.RED_CONCRETE, "", false), p);
				
			}
		}
	}
	
	@EventHandler
	public void InventoryForceClose(InventoryCloseEvent e)
	{
		if (!e.getView().getTitle().equals("���Ư�� ����")) return;
		
		for (PlayerStatus ps : Main.GamePlayerInfoList)
		{
			if (ps.getPlayer().getName().equals(e.getPlayer().getName()))
			{
				if (ps.isWriteSkillTree().equals(true)) return;
				
				ps.SkillTreeFirst = false;
				ps.SkillTreeSecond = false;
				e.getView().getPlayer().sendMessage(ChatColor.DARK_RED + "���Ư���� �ۼ��ؾ� ����� ����� �� �ֽ��ϴ�.");
				return;
			}
		}
	}
	
	@EventHandler
	public void choiceSkillTree(InventoryClickEvent e)
	{
		InventoryView invV = e.getView();
		
		if (!invV.getTitle().equals("���Ư�� ����")) return;

		e.setCancelled(true);
		// �� �׸���� ä��� �̺κ� ���� ***********************************************************
		if (e.getCurrentItem().getType().equals(Material.BARRIER))
		{
			//PASS
		}
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "�˱�"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("����", ChatColor.RED, Material.ENCHANTED_BOOK, ChatColor.WHITE + "�⺻ �� ���� : 2"+ChatColor.WHITE + "�� Ÿ�� ��, 50% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "����"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("�˱�", ChatColor.RED, Material.DIAMOND_SWORD, ChatColor.WHITE + "�⺻ �� ���� : 4 "+ ChatColor.WHITE + "�� Ÿ�� ��, 10% Ȯ���� Ÿ���� ������ ǥ���� ����ϴ�.\n"+ ChatColor.WHITE + "ǥ���� ������ ���� 10�ʵڿ� ������ ������ ����Ĩ�ϴ�.", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "�ͷ�"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� �̵��ӵ��� 5�ʰ� ����\n"+ChatColor.WHITE + "���� ���ð� : 10��\n"+ ChatColor.WHITE , false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(29, CreateItem.createItem("�ͷ�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ǥ���� ������ ���� ���� ����� ������ �̵�\n"+ChatColor.WHITE + "���� ���ð� : 7��\n"+ ChatColor.WHITE , false));
		}
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "����"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("����", ChatColor.GOLD, Material.MUSIC_DISC_PIGSTEP, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 2\n"+ChatColor.WHITE + "�� Ÿ�� ��, ���� ��ġ�� 2�ʰ� ���̰� �ϰ� �̵��ӵ��� ����ϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 0.5��", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "���"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("ȥ��", ChatColor.GOLD, Material.FIRE_CHARGE, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 1\n"+ ChatColor.WHITE + "����ü�� �߻��� ���� ������ '��ȭȭ��' ���¿� ��Ʈ���ϴ�."+ ChatColor.WHITE + "��ȭȭ�� : ü�º�����ظ� ���������� �����ϴ�. \nȭ������� ���� ����ü�� Ÿ���ϸ� 3�� �߰��������� �ݴϴ�. ", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "�г�"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 6\n"+ChatColor.WHITE + "���� ���ð� : 10��\n"+ ChatColor.WHITE , false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(29, CreateItem.createItem("�г�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���� ����Ÿ ���� : 2\n"+ChatColor.WHITE + "�� Ÿ�� ��, 2�ʰ� �����Ǹ� ��Ʈ���ϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 7��\n", false));
		}
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "���"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("���", ChatColor.GREEN, Material.CROSSBOW, ChatColor.WHITE + "�⺻ : ȭ�� ����Ÿ ���� : 1\n"+ ChatColor.WHITE + "�� Ÿ�� ��, �ڽ��� �̵��ӵ��� 5�ʰ� ���� (��ø����)\n"+ ChatColor.WHITE + "���� ���ð� : 0.25��\n", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "���"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("���", ChatColor.GREEN, Material.BOW, ChatColor.WHITE + "�⺻ : ȭ�� ����Ÿ ���� : 2\n"+ ChatColor.WHITE + "���� ���ð� : 0.25��"+ ChatColor.WHITE + "", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Ȱ��"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("��ħ", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ����\n"+ ChatColor.WHITE + "�ڽ��� ����� 7�ʰ� ����ϴ�.\n"+ ChatColor.WHITE + "���� ���ð� 18��", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "��ħ"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(29, CreateItem.createItem("Ȱ��", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ��������\n"+ ChatColor.WHITE + "�⺻ ȭ�� ����Ÿ ���ذ� 5 �����մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 15��", false));
		}
		else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(15, CreateItem.createItem("�ټ�", ChatColor.BLUE, Material.NETHERITE_SWORD, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 1\n"+ChatColor.WHITE + "�� Ÿ�� ��, ü���� 2 ȸ���մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 0.5��", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "�ټ�"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeFirst = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(11, CreateItem.createItem("����", ChatColor.BLUE, Material.BLAZE_POWDER, ChatColor.WHITE + "�⺻ : ���� ����Ÿ ���� : 2\n"+ ChatColor.WHITE + "�� Ÿ�� ��, ü���� 1 ȸ���մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 0.5��", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "�ı�"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = true;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			e.getInventory().setItem(33, CreateItem.createItem("����", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���̷��� ��ȯ\n"+ChatColor.WHITE + "25�ʵ��� ���� �����ϴ� ���̷����� ��ȯ�մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 10��", false));
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "����"))
		{
			for (PlayerStatus ps : Main.GamePlayerInfoList)
			{
				if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
				{
					ps.SkillTreeSecond = false;
					break;
				}
			}
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "",  false));
			e.getInventory().setItem(29, CreateItem.createItem("�ı�", ChatColor.BLUE, Material.ENCHANTED_BOOK, ChatColor.WHITE + "��� : ���� ��ȯ\n"+ChatColor.WHITE + "25�ʵ��� ������ �޷���� ���� ��ȯ�մϴ�.\n"+ ChatColor.WHITE + "���� ���ð� : 10��", false));
		}
		//!!!!!!!!! Ȯ�� / ��� �κ� !!!!!!!!!!!
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Ȯ��"))
		{
			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", false));
			if ((e.getInventory().getItem(11).getType().equals(Material.BARRIER) || e.getInventory().getItem(15).getType().equals(Material.BARRIER)) && (e.getInventory().getItem(29).getType().equals(Material.BARRIER) || e.getInventory().getItem(33).getType().equals(Material.BARRIER)))
			{
				// ������ �����͵� �����ؾ���
				for (PlayerStatus ps : Main.GamePlayerInfoList)
				{
					if (ps.getPlayer().getName().equals(e.getView().getPlayer().getName()))
					{
						//������ ������ �� ��ųƮ�� ���뿡 ���Ѱ͵� �ۼ�
						ps.isWriteSkillTree = true;
						
						e.getView().getPlayer().getInventory().remove(Material.BOOK);
						e.getView().getPlayer().closeInventory();
						e.getView().getPlayer().sendMessage(ChatColor.GREEN + "���Ư���� ����ƽ��ϴ�.");
						return;
					}
				}
				Player p = (Player) e.getView().getPlayer();
				p.kickPlayer(ChatColor.DARK_RED + "�� �÷��̾�� ����, ����� �����մϴ�.");
			}
			else
			{
//				e.setCurrentItem(CreateItem.createItem("�ź�", ChatColor.DARK_RED, Material.BARRIER, "�׸��� Ȯ�����ּ���.", "", "", false));
				e.setCurrentItem(CreateItem.createItem("Ȯ��", ChatColor.GREEN, Material.GREEN_CONCRETE, "", false));
			}
		}
		else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "���"))
		{
//			e.setCurrentItem(CreateItem.createItem("���õ�", ChatColor.WHITE, Material.BARRIER, "", "", "", false));
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
