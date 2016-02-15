package physics;

import objects.WorldObject;

/**
 * The Collision class is for watching a collision between tow world objects.
 * world objects.
 * @see objects.WorldObject
 * @author Tim Vögtli
 * @version 0.1
 */
public class Collision {
	
	/**
	 * Enable the collision.
	 */
	private boolean activ = true;

	/**
	 * The tow world object between a collision
	 * can happen.
	 */
	private WorldObject
		firstObject,
		secondObject;
	
	/**
	 * Constructor for set the tow world objects
	 * @param object1 - first object that can collide with the second object.
	 * @param object2 - second object that can collide with the first one.
	 */
	public Collision( WorldObject firstObject, WorldObject secondObject ){
		this.firstObject = firstObject;
		this.secondObject = secondObject;
	}
	
	/**
	 * Method to provide the collision.
	 */
	public void collisionDetection(){
		if( this.isActiv() ){
			if( this.isCollided() ){
				this.onCollision();
			}
		}
	}
	
	/**
	 * Method to check a collision is happened.
	 * it is to be overwritten by a child.
	 * @return if is a collision happened.
	 */
	public boolean isCollided(){
		return false;
	}
	
	/**
	 * Method for control the object after an collision.
	 * it is to be overwritten by a child.
	 */
	public void onCollision(){
		
	}
	
	/**
	 * Returns if the collision object active or not.
	 * @return returns <strong>true</strong> if it active. 
	 */
	public boolean isActiv(){
		return this.activ;
	}
	
	/**
	 * Returns the first object in the collision object.
	 * @return first WorldObject.
	 */
	public WorldObject getFirstObject(){
		return this.firstObject;
	}
	
	/**
	 * Returns the second object in the collision object.
	 * @return second WorldObject.
	 */
	public WorldObject getSecondObject(){
		return this.secondObject;
	}
	
	/**
	 * Returns the distance between the tow objects.
	 * @return Distance between the tow Objects.
	 */
	/**
	 * Returns the distance between the tow objects.
	 * @return distance between the tow objects.
	 */
	public double getDistance(){
		return Math.sqrt(
				(
					Math.pow(
						this.getFirstObject().getCenterX()
						- this.getSecondObject().getCenterX()
					, 2 )
	            )
				+ (
					Math.pow(
						this.getFirstObject().getCenterY()
						- this.getSecondObject().getCenterY()
					, 2 )
				)
			);
	}
	
	/**
	 * Returns the angle form the first object to the second object in radians.
	 * @return Angle to the second object in radians.
	 */
	public double getFirstAngle(){
		return Math.atan( 
				(
						this.getFirstObject().getCenterY()
						- this.getSecondObject().getCenterY()
				)
				/ (
						this.getFirstObject().getCenterX()
						- this.getSecondObject().getCenterX()
				)
			);
	}
	
	/**
	 * Returns the angle form the second object to the first object in radians.
	 * @return Angle to the fist object in radians.
	 */
	public double getSecondAngle(){
		return Math.atan( 
				(
						this.getSecondObject().getCenterY()
						- this.getFirstObject().getCenterY()
				)
				/ (
						this.getSecondObject().getCenterX()
						- this.getFirstObject().getCenterX()
				)
			);
	}
	
	/**
	 * Deactivate the collision detection.
	 */
	public void disable(){
		this.activ = false;
	}
	
	/**
	 * Activate the collision detection.
	 */
	public void enable(){
		this.activ = true;
	}
	
	/**
	 * Set the active status of the collision object.
	 */
	public void setStatus( boolean avtive ){
		this.activ = avtive;
	}
	
	/**
	 * Override the first object.
	 * @param firsObject - object that override the first object.
	 */
	public void setFirsObject( WorldObject firsObject ){
		this.firstObject = firsObject;
	}
	
	/**
	 * Override the second object.
	 * @param secondObject - object that override the second object.
	 */
	public void setSecondObject( WorldObject secondObject ){
		this.secondObject = secondObject;
	}
	
}
