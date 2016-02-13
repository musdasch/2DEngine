package physics;

import objects.WorldObject;

/**
 * The CirclesCollision describe the collision from tow circles.
 * @see physics.CirclesCollision
 * @author Tim Vögtli
 * @version 0.1
 *
 */
public class CirclesCollision extends Collision {

	/**
	 * Constructor for setting tow World objects with a shape of a circle.
	 * @param firstObject - first circle object.
	 * @param secondObject - second circle object.
	 */
	public CirclesCollision(WorldObject firstObject, WorldObject secondObject) {
		super(firstObject, secondObject);
	}
	
	/**
	 * if the objects colliding.
	 */
	@Override
	public boolean isCollided(){
		return 
				this.getDistance()
				<= this.getFirstObject().getRadius()
				+ this.getSecondObject().getRadius();
	}
	
	

}
