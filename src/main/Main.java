package main;

import java.awt.Color;

import graphics.GameGraphicEllipse;
import gui.GameFrame;
import objects.World;
import objects.WorldObjectBall;
import physics.CollisionCircles;
import physics.Vector2D;

public class Main {

	public static void main(String[] args) {
		World world = new World();
		
		WorldObjectBall ball = new WorldObjectBall(
				0,
				0,
				100,
				100,
				new Vector2D( 2, 0 ) 
		);
		
		WorldObjectBall ball2 = new WorldObjectBall(
				1000,
				0,
				100,
				100,
				new Vector2D( -2.0, 0.2 ) 
		);
		
		GameGraphicEllipse ellipse = new GameGraphicEllipse(
				0,
				0,
				100 
		);
		
		ellipse.setBackgroundColor( new Color( 255, 255, 255 ) );
		
		ball.setGraphic( ellipse );
		ball2.setGraphic( ellipse );
		
		world.addWorldObject( ball );
		world.addWorldObject( ball2 );
		
		
		CollisionCircles collision = new CollisionCircles(ball, ball2);
		world.addCollision(collision);
		
		world.setGravity( new Vector2D( 0, 0.0098 ) );
		
		world.setWorldDelay( 100 );
		
		GameFrame frame = new GameFrame( "test",  1200, 600, world );
	}

}
