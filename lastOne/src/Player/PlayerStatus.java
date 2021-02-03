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
	
	int power,intelligence,accuracy;
	
	public static HashMap<skilltype, Double> CooldownMap = new HashMap<skilltype,Double>();
	
	public PlayerStatus(Player p, String Job, Boolean first, Boolean second, Boolean iswrite,  double pd, double md, double fsc, double ssc)
	{
		//이 p는 이름이나 메세지 보내는 등, (선언했을떄의)과거의 데이터임. 해당 플레이어의 실.시.간. 데.이.터 가 아님
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
	
	public void setPower(int p)
	{
		power = p;
	}
	
	public int getPower()
	{
		return power;
	}
	public void setIntelligence(int i)
	{
		intelligence = i;
	}
	
	public int getIntelligence()
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
}


