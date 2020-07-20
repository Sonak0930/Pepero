package CustomEvent;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import lastOne.Main;

public class EntityDeath implements Listener
{
	@EventHandler
	public void isEntityDead(EntityDeathEvent e)
	{
		if (!Main.isStart) return;
		
		int count = -1;
		for (LivingEntity LE : Main.AttackKnightLightning)
		{
			count += 1;
			if (!LE.getUniqueId().equals(e.getEntity().getUniqueId())) continue;
			Main.AttackKnightLightning.remove(count);
		}
	}
}
