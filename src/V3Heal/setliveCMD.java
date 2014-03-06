package V3Heal;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setliveCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command arg1, String arg2,
			String[] args) {
		// TODO Auto-generated method stub
		
		if(cs instanceof Player){
			if(args.length == 1){
				Player p = (Player) cs;
				int i = Integer.valueOf(args[0]);
				p.setMaxHealth(i);
			}else{
				cs.sendMessage("Nutze: §c/setlive [1-99999]");
			}
					
		}else{
			cs.sendMessage("Only Player");
		}
		return false;
	}

}
