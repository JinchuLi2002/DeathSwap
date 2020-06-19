package lijinchu;

//Made by Jinchu Li, in Kirkland WA
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class Core extends JavaPlugin implements Listener{
	
	
	private static Core instance;
	private int run;
	private int time;
	private boolean Switch = true;
	private Player player1;
	private Player player2;
	private Player deadPlayer;
	
	
	public static Core getInstance()
	{
		
		return instance;
	}

	@Override
	public void onEnable()
	{
		instance = this;
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		deadPlayer = event.getEntity();
		if (deadPlayer == player1 || deadPlayer == player2)
		{
		Switch = false;
		}
	}

	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
	{
		
		
		player1 = (Player) sender;
		if (command.getName().equalsIgnoreCase("swapWith"))
		{
			
			if (args.length == 1)
			{
				String argument = args[0];
				player2 = Bukkit.getPlayer(argument);
				player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYour objective is to kill " + sender.getName()));
				player1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYour objective is to kill " + player2.getName()));
				
				
				time = 0;
				run = Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), new Runnable()
				{
					
				   
				    @Override
				    public void run()
				    {
				    	time++;
				        if (time > 310)
				            time = 0;
				        
				        if (Switch == false)
				        {
				        	if (deadPlayer == player1)
				        	{
				        		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', player2.getName() + "&c IS THE WINNER!"));
				        	}
				        	else
				        	{
				        		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', player1.getName() + "&c IS THE WINNER!"));
				        	}
				        	Bukkit.getScheduler().cancelTask(run);
						
				        }
				        if (time == 10)
						{
				        	Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 5 minutes!"));
						}
						
						if (time == 10 + 60)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 4 minutes!"));
						}
						
						if (time == 10 + 60 * 2)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 3 minutes!"));
						}
						
						if (time == 10 + 60 * 3 )
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 2 minutes!"));
						}
						
						if (time == 10 + 60 * 4 )
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 1 minute!"));
						}
						
						if (time == 10 + 60 * 4 + 30)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 30 seconds!"));
						}
						
						if (time == 10 + 60 * 4 + 45)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 15 seconds!"));
						}
						if (time == 10 + 60 * 4 + 50)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 10 seconds!"));
						}
						if (time == 10 + 60 * 4 + 51)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 9 seconds!"));
						}
						if (time == 10 + 60 * 4 + 52)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 8 seconds!"));
						}
						if (time == 10 + 60 * 4 + 53)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 7 seconds!"));
						}
						
						if (time == 10 + 60 * 4 + 54)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 6 seconds!"));
						}
						if (time == 10 + 60 * 4 + 55)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 5 seconds!"));
						}
						if (time == 10 + 60 * 4 + 56)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 4 seconds!"));
						}
						if (time == 10 + 60 * 4 + 57)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 3 seconds!"));
						}
						if (time == 10 + 60 * 4 + 58)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 2 seconds!"));
						}
						if (time == 10 + 60 * 4 + 59)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSwapping in 1 second!"));
						}
						if (time == 310)
						{
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cSWAPPING"));
							Location player1Location = player1.getLocation();
							Location player2Location = player2.getLocation();
							player1.teleport(player2Location);
							player2.teleport(player1Location);
						}
				        
				    }
				}, 0, 20);
			}
			return true;
		}
		return false;
	}

}
				
				
		
