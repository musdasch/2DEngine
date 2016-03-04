package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The GameWindowListener holds the functions for actions in the game.
 * @author Tim Vögtli
 * @version 0.1
 *
 */
public class GameWindowListener extends WindowAdapter {
	
	/**
	 * The Window Closing Function stops the program.
	 */
	public void windowClosing(WindowEvent e){
		 e.getWindow().dispose();
		 System.exit(0);
	}
}
