package lastOne;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GiveWeapon
{
	public void giveItem(Player p)
	{
		if (p.getInventory().contains(CreateItem.createItem("���� ����� ��������", ChatColor.RED, Material.PRISMARINE_SHARD, "",true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(0));
			p.getInventory().addItem(Main.AllitemList.get(1));
			p.getInventory().addItem(CreateItem.createItem("���� ��� - ���Ư�� å", ChatColor.RED, Material.BOOK, "",  true));
			//��ųƮ�� ����,
		}
		else if (p.getInventory().contains(CreateItem.createItem("�ı� �������� �������", ChatColor.YELLOW, Material.QUARTZ, "", true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(2));
			p.getInventory().addItem(Main.AllitemList.get(3));
			p.getInventory().addItem(CreateItem.createItem("�ı� ������ - ���Ư�� å", ChatColor.YELLOW, Material.BOOK, "",  true));
			//��ųƮ�� ����,
		}
		else if (p.getInventory().contains(CreateItem.createItem("�� ��ɲ��� ȭ�����", ChatColor.GREEN, Material.FEATHER, "", true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(4));
			p.getInventory().addItem(Main.AllitemList.get(5));
			p.getInventory().addItem(CreateItem.createItem("�� ��ɲ� - ���Ư�� å", ChatColor.GREEN, Material.BOOK, "",  true));
			//��ųƮ�� ����,
		}
		else if (p.getInventory().contains(CreateItem.createItem("��ȥ ġ������ �ּ�����", ChatColor.BLUE, Material.NETHER_STAR, "",true)))
		{
			p.getInventory().clear();
			p.getInventory().addItem(Main.AllitemList.get(6));
			p.getInventory().addItem(Main.AllitemList.get(7));
			p.getInventory().addItem(CreateItem.createItem("��ȥ ġ���� - ���Ư�� å", ChatColor.BLUE, Material.BOOK, "",  true));
			//��ųƮ�� ����,
		}
		
	}
}
