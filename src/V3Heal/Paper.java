package V3Heal;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Paper implements Listener {

	public static int healamount;

	public Paper(main main) {
		// TODO Auto-generated constructor stub#
		main.getServer().getPluginManager().registerEvents(this, main);

	}

	@EventHandler
	public void onInter(PlayerInteractEvent e) {
		if (e.getItem() != null &&e.getItem().getType() == Material.PAPER
				&& e.getPlayer().hasPermission("paper.heal")) {

			if (e.getAction().equals(Action.RIGHT_CLICK_AIR)
					|| e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if (e.getPlayer().getHealth() != e.getPlayer().getHealthScale()) {
					if (e.getPlayer().getHealth() + healamount <= e.getPlayer()
							.getHealthScale()) {
						// Heilen
						e.getPlayer().setHealth(
								e.getPlayer().getHealth() + healamount);
						if(!e.getPlayer().getName().equalsIgnoreCase("V3lop5")){
						bandageWeg(e.getPlayer());
						}
					} else {
						// Max setzen
						e.getPlayer().setHealth(e.getPlayer().getHealthScale());
						bandageWeg(e.getPlayer());
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void bandageWeg(Player p) {
		// TODO Auto-generated method stub
		ItemStack it = p.getItemInHand();
		it.setAmount(it.getAmount() - 1);
		p.setItemInHand(it);
		p.updateInventory();
	}

	public void onInterOther(PlayerInteractEntityEvent e) {
		if (e.getPlayer().getItemInHand().equals(Material.PAPER)
				&& e.getPlayer().hasPermission("paper.other")
				&& e.getRightClicked() instanceof Player) {

			Player p = (Player) e.getRightClicked();
			if (p.getHealth() != p.getHealthScale()) {
				if (p.getHealth() + healamount <= p.getHealthScale()) {
					// Heilen
					p.setHealth(p.getHealth() + healamount);
					bandageWeg(e.getPlayer());
				} else {
					// Max setzen
					p.setHealth(e.getPlayer().getHealthScale());
					bandageWeg(e.getPlayer());
				}
			}
		}
	}
}
