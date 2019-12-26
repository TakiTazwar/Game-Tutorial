package platformer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		setSize(700,700);
		//frame.setLocation(200, 200);
		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(screenSize.getWidth()/2-getSize().getWidth()/2),(int)(screenSize.getHeight()/2-getSize().getHeight()/2));
		setVisible(true);
		setResizable(false);
		setTitle("TGOP Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		GamePanel panel=new GamePanel();
		panel.setLocation(0,0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		this.add(panel);
		
		addKeyListener(new KeyChecker(panel));
		
	}

}
