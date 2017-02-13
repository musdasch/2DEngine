package main;

import graphics.GameGraphicEllipse;
import gui.GamePanel;

import java.awt.Color;

import javax.swing.JFrame;

import listeners.GameWindowListener;
import objects.World;
import objects.WorldObjectBall;
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
				600,
				100,
				new Vector2D( 0, -3 ) 
		);

		
		/**
		 * Create an graphic object for the ball.
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
		 * add the graphic to the ballO.
		 */
		ball.setGraphic( ellipse );
		
		/**
		 * add the tow balls to the world
		 */
		world.addWorldObject( ball );
		
		
		/**
		 * Set a gravity to the world
		 */
		world.setGravity( new Vector2D( 0, 0.0098 ) );
		
		/**
		 * set the world delay of 30 milliseconds for slow motion.
		 */
		world.setWorldDelay( 5 );
		
		/**
		 * Create a panel for the world
		 */
		GamePanel gamePanel = new GamePanel( world );
		
		/**
		 * Create a frame for the gamePanel.
		 */
		JFrame frame = new JFrame();
		
		frame.setTitle( "Game" );
		frame.setSize( 400, 700 );
		frame.addWindowListener( new GameWindowListener() );
		frame.add( gamePanel );
		frame.setVisible( true );
	}

}
