package Projectile;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class ChoiceMessage
{
	public static void Message(ArrayList<Player> playerList, String content)
	{
		for (Player p : playerList)
		{
			p.sendMessage(content);
		}
	}

}
