package Player;

import java.util.HashMap;

import org.bukkit.entity.Player;

import lastOne.Cooltime.skilltype;

public class PlayerStatus
{
	Player player;
	String job;
	public Boolean SkillTreeFirst;
	public Boolean SkillTreeSecond;
	public Boolean isWriteSkillTree;	
	double magicalDefense;
	double physicalDefense;
	double FirstSkillCooldown;
	double SecondSkillCooldown;
	State state;
	
	double power;
	double intelligence;
	int accuracy;
	
	public static HashMap<skilltype, Double> CooldownMap = new HashMap<skilltype,Double>();
	
	public PlayerStatus(Player p, String Job, Boolean first, Boolean second, Boolean iswrite,  double pd, double md, double fsc, double ssc)
	{
		//�� p�� �̸��̳� �޼��� ������ ��, (������������)������ ��������. �ش� �÷��̾��� ��.��.��. ��.��.�� �� �ƴ�
		player = p;
		job = Job;
		SkillTreeFirst = first;
		SkillTreeSecond = second;
		isWriteSkillTree = iswrite;
		magicalDefense = md;
		physicalDefense = pd;
		FirstSkillCooldown = fsc;
		SecondSkillCooldown = ssc;
	}
	
	public void setPower(double d)
	{
		power = d;
	}
	
	public double getPower()
	{
		return power;
	}
	public void setIntelligence(double power2)
	{
		intelligence = power2;
	}
	
	public double getIntelligence()
	{
		return intelligence;
	}
	
	public void setAccuracy(int a)
	{
		accuracy = a;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
	public void setState(State s)
	{
		state = s;
	}
	
	public State getState()
	{
		return state;
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
	
	public double getMagicalDefense()
	{
		return magicalDefense;
	}
	
	public double getPhysicalDefense()
	{
		return physicalDefense;
	}
	
	public void setFirstSkillCooldown(double s)
	{
		FirstSkillCooldown = s;
	}
	
	public void setSecondSkillCooldown(double s)
	{
		SecondSkillCooldown = s;
	}
	public double getFirstSkillCooldown()
	{
		return FirstSkillCooldown;
	}
	
	public double getSecondSkillCooldown()
	{
		return SecondSkillCooldown;
	}
	
	public void setMagicalDefense(double s)
	{
		magicalDefense = s;
	}
	
	public void setPhysicalDefense(double s)
	{
		physicalDefense = s;
	}
}


