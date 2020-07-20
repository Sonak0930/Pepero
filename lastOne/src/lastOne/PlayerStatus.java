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
		//이 p는 이름이나 메세지 보내는 등, (선언했을떄의)과거의 데이터임. 해당 플레이어의 실.시.간. 데.이.터 가 아님
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
