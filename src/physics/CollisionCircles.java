package physics;

import objects.WorldObject;

/**
 * The CirclesCollision describe the collision from tow circles.
 * @see physics.CollisionCircles
 * @author Tim Vögtli
 * @version 0.1
 *
 */
public class CollisionCircles extends Collision {

	/**
	 * Constructor for setting tow World objects with a shape of a circle.
	 * @param firstObject - first circle object.
	 * @param secondObject - second circle object.
	 */
	public CollisionCircles(WorldObject firstObject, WorldObject secondObject) {
		super(firstObject, secondObject);
	}
	
	/**
	 * if the objects colliding.
	 */
	@Override
	public boolean isCollided(){
		return 
				super.getDistance()
				< super.getFirstObject().getRadius()
				+ super.getSecondObject().getRadius();
	}
	
	/**
	 * Override the on Collision for control the objects.
	 */
	@Override
	public void onCollision(){
		super.getFirstObject().addVector( this.getFirstNewVector() );
		super.getSecondObject().addVector( this.getSecondNewVector() );
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
	
	/**
	 * Calculate the new vector for the first object.
	 * @return new vector for the first object.
	 */
	public Vector2D getFirstNewVector(){
		return new Vector2D( 
				(
					super.getFirstObject().getVector2D().getX()
					* (
							super.getFirstObject().getMass()
							- super.getSecondObject().getMass()
					)
					+ (
							2
							* super.getSecondObject().getMass()
							* super.getSecondObject().getVector2D().getX()
					)
				)
				/ (
						super.getFirstObject().getMass()
						+ super.getSecondObject().getMass()
				),
				(
					super.getFirstObject().getVector2D().getY()
					* (
							super.getFirstObject().getMass()
							- super.getSecondObject().getMass()
					)
					+ (
							2
							* super.getSecondObject().getMass()
							* super.getSecondObject().getVector2D().getY()
					)
				)
				/ (
						super.getFirstObject().getMass()
						+ super.getSecondObject().getMass()
				)
				
			);
		}
		
		/**
		 * Calculate the new vector for the second object.
		 * @return new vector for the second object.
		 */
		public Vector2D getSecondNewVector(){
			return new Vector2D( 
					(
						super.getSecondObject().getVector2D().getX()
						* (
								super.getSecondObject().getMass()
								- super.getFirstObject().getMass()
						)
						+ (
								2
								* super.getFirstObject().getMass()
								* super.getFirstObject().getVector2D().getX()
						)
					)
					/ (
							super.getSecondObject().getMass()
							+ super.getFirstObject().getMass()
					),
					(
						super.getSecondObject().getVector2D().getY()
						* (
								super.getSecondObject().getMass()
								- super.getFirstObject().getMass()
						)
						+ (
								2
								* super.getFirstObject().getMass()
								* super.getFirstObject().getVector2D().getY()
						)
					)
					/ (
							super.getSecondObject().getMass()
							+ super.getFirstObject().getMass()
					)
					
				);
		}
}
