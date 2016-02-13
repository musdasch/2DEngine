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
				super.getDistance()
				<= super.getFirstObject().getRadius()
				+ super.getSecondObject().getRadius();
	}
	
	/**
	 * Get the collision point between the tow circles along the x-axis.
	 * @return collision point along the x-axis.
	 */
	public double getCollisionPointX(){
		return 
				(
					(
						super.getFirstObject().getCenterX()
						* super.getSecondObject().getRadius()
					)
					+ (
						super.getSecondObject().getCenterX()
						* super.getFirstObject().getRadius()
					)
				) 
				/ (
					super.getFirstObject().getRadius()
					+ super.getSecondObject().getRadius()
				);
	}
	
	/**
	 * Get the collision point between the tow circles along the y-axis.
	 * @return collision point along the y-axis.
	 */
	public double getCollisionPoingY(){
		return 
				(
					(
						super.getFirstObject().getCenterY()
						* super.getSecondObject().getRadius()
					)
					+ (
						super.getSecondObject().getCenterY()
						* super.getFirstObject().getRadius()
					)
				) 
				/ (
					super.getFirstObject().getRadius()
					+ super.getSecondObject().getRadius()
				);
	}
	
	

}
