package main;

import java.awt.Color;

import graphics.GameGraphicEllipse;
import gui.GameFrame;
import objects.World;
import objects.WorldObjectBall;
import physics.Vector2D;

public class Main {

	public static void main(String[] args) {
		World world = new World();
		
		WorldObjectBall ball = new WorldObjectBall(
				0,
				0,
				100,
				100,
				new Vector2D( 0.5, 0 ) 
		);
		
		GameGraphicEllipse ellipse = new GameGraphicEllipse(
				0,
				0,
				200 
		);
		
		ellipse.setBackgroundColor( new Color( 255, 255, 255 ) );
		
		ball.setGraphic( ellipse );
		
		world.addWorldObject( ball );
		
		GameFrame frame = new GameFrame( "test",  1200, 600, world );
	}

}
