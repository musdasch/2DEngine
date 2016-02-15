package main;

import java.awt.Color;

import graphics.GameGraphicEllipse;
import gui.GameFrame;
import objects.World;
import objects.WorldObjectBall;
import physics.CirclesCollision;
import physics.Vector2D;

/**
 * It is the test area.
 * @author Tim Vögtli
 * @version 0.2
 */
public class Main {

	public static void main(String[] args) {
		
		/**
		 * Create a world.
		 */
		World world = new World();
		
		
		/**
		 * Create an circle.
		 */
		WorldObjectBall ball = new WorldObjectBall(
				0,
				0,
				100,
				new Vector2D( 2, 0 ) 
		);
		
		/**
		 * Create an oder circle.
		 */
		WorldObjectBall ball2 = new WorldObjectBall(
				1000,
				0,
				100,
				new Vector2D( -2.0, 0.2 ) 
		);
		
		/**
		 * Create an graphic object for the tow balls.
		 */
		GameGraphicEllipse ellipse = new GameGraphicEllipse(
				0,
				0,
				100 
		);
		
		/**
		 * Set the color of the graphic.
		 */
		ellipse.setBackgroundColor( new Color( 255, 255, 255 ) );
		
		
		/**
		 * add the graphic to the tow balls.
		 */
		ball.setGraphic( ellipse );
		ball2.setGraphic( ellipse );
		
		/**
		 * add the tow balls to the world
		 */
		world.addWorldObject( ball );
		world.addWorldObject( ball2 );
		
		/**
		 * Create a collision between the tow balls.
		 */
		CirclesCollision collision = new CirclesCollision(ball, ball2);
		world.addCollision(collision);
		
		/**
		 * Set a gravity to the world
		 */
		world.setGravity( new Vector2D( 0, 0.0098 ) );
		
		/**
		 * set the world delay of 30 milliseconds for slow motion.
		 */
		world.setWorldDelay( 30 );
		
		/**
		 * Create a frame for the world.
		 */
		GameFrame frame = new GameFrame( "test",  1200, 600, world );
	}

}
