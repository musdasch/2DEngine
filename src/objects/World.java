package objects;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.GamePanel;
import physics.Vector2D;

public class World extends Thread {
	
	private Vector2D gravity;
	
	private ArrayList<WorldObject> worldObjects = new ArrayList<>();
	
	private GamePanel gamePanel;
	
	private int worldDilay = 1;
	
	public void addWorldObject( WorldObject object ){
		worldObjects.add( object );
	}
	
	public void addGamePanel( GamePanel gamePanel ){
		this.gamePanel = gamePanel;
	}
	
	public void setGravity( Vector2D vector ){
		this.gravity = vector;
	}
	
	public void paint(Graphics g){
		for (WorldObject worldObject : worldObjects) {
			if( 
					worldObject.getX() < this.gamePanel.getWidth() &&
					worldObject.getY() < this.gamePanel.getHeight()
					){
				worldObject.paint(g);
			}
		}
	}
	
	@Override
	public void run(){
		while( true ){
			for (WorldObject worldObject : worldObjects) {
				worldObject.move();
				
				if( gravity != null ){
					worldObject.addVector( gravity );
				}
			}
			
			this.gamePanel.repaint();
			
			try{
				Thread.sleep( worldDilay );
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
