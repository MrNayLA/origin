package sg.edu.nus.iss.usstore;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class MyKeyListener extends KeyAdapter {
		
	public void keyPressed(KeyEvent evt) {
		/*if (evt.getKeyChar() == 'a') {
			System.out.println("Check for key characters: " + evt.getKeyChar());
		}*/
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
		      //System.out.println("Check for key codes: " + evt.getKeyCode());/* For debugging */
		}
	}
}


