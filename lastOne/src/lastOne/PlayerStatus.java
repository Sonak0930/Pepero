package lastOne;

import org.bukkit.entity.Player;

public class PlayerStatus
{
	Player player;
	String job;
	public Boolean SkillTreeFirst;
	public Boolean SkillTreeSecond;
	public Boolean isWriteSkillTree;	
	double magicDefensive;
	double physicsDefensive;
	int FirstSkillCooldown;
	int SecondSkillCooldown;
	
	PlayerStatus(Player p, String Job, Boolean first, Boolean second, Boolean iswrite,  double pd, double md, int fsc, int ssc)
	{
		//�� p�� �̸��̳� �޼��� ������ ��, (������������)������ ��������. �ش� �÷��̾��� ��.��.��. ��.��.�� �� �ƴ�
		player = p;
		job = Job;
		SkillTreeFirst = first;
		SkillTreeSecond = second;
		isWriteSkillTree = iswrite;
		magicDefensive = md;
		physicsDefensive = pd;
		FirstSkillCooldown = fsc;
		SecondSkillCooldown = ssc;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public String getJob()
	{
		return job;
	}
	
	public Boolean getFirstSkill()
	{
		return SkillTreeFirst;
	}
	
	public Boolean getSecondSkill()
	{
		return SkillTreeSecond;
	}
	
	public Boolean isWriteSkillTree()
	{
		return isWriteSkillTree;
	}
	
	public double getMagicDefensive()
	{
		return magicDefensive;
	}
	
	public double getPhysicsDefensive()
	{
		return physicsDefensive;
	}
	
	public double getFirstSkillCooldown()
	{
		return FirstSkillCooldown;
	}
	
	public double getSecondSkillCooldown()
	{
		return SecondSkillCooldown;
	}
}
