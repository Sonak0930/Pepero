package CustomEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import lastOne.ChoiceMessage;
import lastOne.Main;

public class PlayerQuit implements Listener
{
	@EventHandler
	public void isJoinPlayerQuit(PlayerQuitEvent e)
	{
		if (Main.isStart)
		{
			Player exitP = e.getPlayer();
			for (Player elementP : Main.GameJoinList)
			{
				if (elementP.equals(exitP))
				{
					ChoiceMessage.Message(Main.GameJoinList, ChatColor.AQUA + elementP.getName() + ChatColor.GRAY + "님이 중도퇴장 하였습니다.");
//					Main.deathPlayerList.add(elementP);
					Main.GameJoinList.remove(elementP);
				}
			}
		}
	}
}
