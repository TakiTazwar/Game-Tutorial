package platformer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends KeyAdapter {
	GamePanel panel;
	
	
	public KeyChecker(GamePanel panel) {
		this.panel=panel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		panel.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		panel.keyReleased(e);
	}

}
