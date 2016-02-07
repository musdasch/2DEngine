package objects;

import java.awt.Graphics;
import java.util.ArrayList;

import org.omg.CORBA.Object;

import gui.GamePanel;
import physics.Vector2D;

/**
 * The World object holds all WorldObjects and run all of this. It also contains the GamePanel
 * and draw all WorldObjets if they have his motion complete.
 * @author Tim Vögtli
 * @version 0.1
 *
 */
public class World extends Thread {
	
	/**
	 * Holds the gravity vector.
	 * @see physics.Vector2D
	 */
	private Vector2D gravity;
	
	/**
	 * A list of WorldObjects they are in the world.
	 * @see objects.WorldObject
	 */
	private ArrayList<WorldObject> worldObjects = new ArrayList<>();
	
	/**
	 * The GamePanel for draw the World on it.
	 * @see gui.GamePanel
	 */
	private GamePanel gamePanel;
	
	/**
	 * The delay of the world, it is for slow down the world.
	 */
	private int worldDelay = 1;
	
	/**
	 * It's for add WorldObjects to interact with World.
	 * @see objects.WorldObject
	 * @param object - WorldObject.
	 */
	public void addWorldObject( WorldObject object ){
		worldObjects.add( object );
	}
	
	/**
	 * Set the GamePanel to draw the world on it.
	 * @see gui.GamePanel
	 * @param gamePanel GamePanel for drawing.
	 */
	public void setGamePanel( GamePanel gamePanel ){
		this.gamePanel = gamePanel;
	}
	
	/**
	 * Set the gravity in this world.
	 * @param vector - the vector of gravity force.
	 */
	public void setGravity( Vector2D vector ){
		this.gravity = vector;
	}
	
	/**
	 * Set the worldDelay to slow down the world.
	 * @param worldDilay - The length of time to sleep in milliseconds.
	 */
	public void setWorldDelay( int worldDilay ){
		this.worldDelay = worldDilay;
	}
	
	/**
	 * Return the gravity vector for this world.
	 * @return The current gravity vector.
	 */
	public Vector2D getGravity(){
		return this.gravity;
	}
	
	/**
	 * Return the world delay in milliseconds.
	 * @return The current world delay in milliseconds.
	 */
	public int getWorldDelay(){
		return this.worldDelay;
	}
	
	/**
	 * Remove the gravity in the world.
	 */
	public void removeGravity(){
		this.gravity = null;
	}
	
	/**
	 * Paint the world on the GamePanel.
	 * @see gui.GamePanel
	 * @param g - The graphics object form the GamePanel.
	 */
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
	
	/**
	 * Run the world and paint it on the GamePanel.
	 * @see gui.GamePanel
	 */
	@Override
	public void run(){
		while( true ){
			
			/**
			 * Run all world objects.
			 */
			for (WorldObject worldObject : worldObjects) {
				worldObject.move();
				
				if( gravity != null ){
					worldObject.addVector( gravity );
				}
			}
			
			/**
			 * Repaint the GamePanel.
			 */
			this.gamePanel.repaint();
			
			/**
			 * Slow down the world.
			 */
			try{
				Thread.sleep( worldDelay );
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
