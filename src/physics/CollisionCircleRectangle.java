package physics;

import objects.WorldObject;

/**
 * The CollisionCircleRectangle class holds the instructions for a collision
 * between a circle an a rectangle.
 * @see physics.Collision
 * @author Tim Vögtli
 * @version 0.1
 */
public class CollisionCircleRectangle extends Collision {

	/**
	 * Constructor for set the WorldObject.
	 * @param circleObject - The WorldObject with the shape of a circle.
	 * @param rectangleObject - The WorldObject with the shape of a rectangle.
	 */
	public CollisionCircleRectangle( WorldObject circleObject, WorldObject rectangleObject ){
		super( circleObject, rectangleObject );
	}
	
	/**
	 * if the objects colliding.
	 */
	@Override
	public boolean isCollided(){
		return this.getRecCollisionDis() + super.getFirstObject().getRadius() < super.getDistance();
	}
	
	public double getRecCollisionDis(){
		double RecCollisionDis = 0;
		
		if( Math.PI / 4 > this.getRecCollisionDis() ){
			RecCollisionDis = 
					( super.getSecondObject().getWidth() / 2 )
					/ Math.sin( this.getSecondAngle() );
		} else {
			RecCollisionDis = 
					( super.getSecondObject().getHeight() / 2 )
					/ Math.sin( this.getSecondAngle() );
		}
		
		return RecCollisionDis;
	}
	
	@Override
	public double getSecondAngle(){
		return Math.sqrt( Math.pow( super.getSecondAngle(), 2 ) );
	}

}
