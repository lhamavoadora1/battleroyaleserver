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
		if (this.isFilled()) {
			if (this.life instanceof Player) {
				
				Player player = (Player)this.life;
				
				switch (this.direction) {
					case UP:
						return attack(player, Axis.Y, 1, this.arena);
					case DOWN:
						return attack(player, Axis.Y, -1, this.arena);
					case LEFT:
						return attack(player, Axis.X, -1, this.arena);
					case RIGHT:
						return attack(player, Axis.X, 1, this.arena);
				}
			}
			
			return null;
		}
		throw new Exception("Action must be instantiated first!");
		
	}
	
	UI attack(Player attacker, Axis axis, Integer frontModifier, Arena arena) throws Exception {
		
		Integer[][] attackDistance = attacker.getWeapon().getDistance();
		Integer frontLength = attackDistance.length;
		Integer sideLength = attackDistance[0].length;
		
		for (Integer fd = 0; fd < frontLength; fd++) {
			
			Coordinate targetCoordinate = attacker.getPosition().get(axis, (fd + 1) * frontModifier);
			
			Integer limit;
			if (sideLength > 0) {
				limit = 2;
			} else {
				limit = 1;
			}
			
			for (Integer i = 0; i < limit; i++) {
				Coordinate auxCoordinate = new Coordinate(targetCoordinate);
				switch (i) {
					case 1:
						auxCoordinate = targetCoordinate.get(axis, frontModifier, Direction.LEFT);
						break;
					case 2:
						auxCoordinate = targetCoordinate.get(axis, frontModifier, Direction.RIGHT);
						break;
				}
				for (Integer sd = 0; sd <= sideLength; sd++) {
					try {
						auxCoordinate = auxCoordinate.get(axis, sd * frontModifier);
						Entity entity = arena.getEntityFromCoordinate(auxCoordinate);
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
							
							Queue.add(this);
							
							return new UI(String.join("\n", messages), true);
						} else if (entity == null) {
							System.out.println("Cell not found on Arena grid!");
						} else if (!entity.isAttackable()) {
							System.out.println("Entity is not attackable!");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage() + " - " + e.getStackTrace());
					}
				}
			}
		}
				
		return null;
		
	}
	
}
