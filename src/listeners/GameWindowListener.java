package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindowListener extends WindowAdapter {
	
	public void windowClosing(WindowEvent e){
		 e.getWindow().dispose();
		 System.exit(0);
	}
}
