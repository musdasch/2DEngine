package gui;

import java.awt.Graphics;

import javax.swing.JFrame;

import listeners.GameWindowListener;
import objects.World;


public class GameFrame extends JFrame {
	
	private GamePanel gamePanel;
	
	public GameFrame( String title, int width, int height, World world ){
		gamePanel = new GamePanel( width, height, world );
		this.setTitle( title );
		this.setSize( width, height );
		this.addWindowListener( new GameWindowListener() );
		this.add( gamePanel );
		this.setVisible( true );
	}
}
