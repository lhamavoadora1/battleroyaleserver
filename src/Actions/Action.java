package Actions;
import Utils.*;
import VOs.*;

import java.util.ArrayList;
import java.util.List;

import Things.*;

public class Action extends Intention {
	
	public Action(Life attacker, Direction direction, Arena arena) {
		super("attack", attacker, direction, arena);
	}
	
	public UI attackUI() throws Exception {
		return attackUI(this.attacker, this.direction, this.arena);
	}
	
	public static UI attackUI(Life attacker, Direction direction, Arena arena) throws Exception {
		
		if (attacker instanceof Player) {
			
			Player player = (Player)attacker;
			
			switch (direction) {
				case UP:
					return attack(player, Axis.Y, 1, 1, arena);
				case DOWN:
					return attack(player, Axis.Y, -1, 1, arena);
				case LEFT:
					return attack(player, Axis.X, -1, 1, arena);
				case RIGHT:
					return attack(player, Axis.X, 1, 1, arena);
			}
		}
		
		return null;
		
	}
	
	static UI attack(Player attacker, Axis axis, Integer frontModifier, Integer sideLength, Arena arena) throws Exception {
		
//		Integer[][] attackDistance = attacker.getWeapon().getDistance();
//		Integer frontDistance = attackDistance.length;
//		Integer sideDistance = attackDistance[0].length;
//		
//		Coordinate attackerCoordinate = attacker.getPosition();
		Coordinate targetCoordinate = attacker.getPosition().get(axis, frontModifier);
		
//		for (Integer fd = 0; fd < frontDistance; fd++) {
//			for (Integer sd = 0; sd < sideDistance; sd++) {
				try {
					Entity entity = arena.getEntityFromCoordinate(targetCoordinate);
					if (entity != null && entity.isAttackable()) {
						Life target = (Life)entity;
						
						Weapon attackerWeapon = attacker.getWeapon();
						target.damage(attackerWeapon.getDamage());
						
						List<String> messages = new ArrayList<String>();
						
						messages.add(String.format("{0} {1} suffered {2} damage from {3} {4}'s {5} {6}!", 
									 new Object[]{target.getType(), target.getName(), String.valueOf(attackerWeapon.getDamage()),
											 attacker.getType(), attacker.getName(), attackerWeapon.getType(), attackerWeapon.getName()}));
						
						if (target.isDead()) {
							arena.removeEntityFromCoordinate(target, target.getPosition());
							messages.add(String.format("{0} {1} is dead!", 
								 	     new Object[]{target.getType(), target.getName()}));
						} else if (target.isUnconscious() && target instanceof Player) {
							messages.add(String.format("{0} {1} is unconscious!", 
									 	 new Object[]{target.getType(), target.getName()}));
						} else if (target.isUnconscious() && target instanceof Item) {
							arena.removeEntityFromCoordinate(target, target.getPosition());
							messages.add(String.format("{0} {1} is destroyed!", 
								 	 new Object[]{target.getType(), target.getName()}));
						}
						
						return new UI(String.join("\n", messages), true);
					} else {
						System.out.println("Cell not found on Arena grid or Entity is not attackable!");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage() + " - " + e.getStackTrace());
				}
//			}
//		}
				
		return null;
		
	}
	
}
