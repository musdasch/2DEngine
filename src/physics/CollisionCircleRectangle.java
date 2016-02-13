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

	public CollisionCircleRectangle(WorldObject firstObject, WorldObject secondObject) {
		super(firstObject, secondObject);
	}

}
