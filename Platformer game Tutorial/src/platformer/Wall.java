package platformer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wall {
	
	int x,y,height,width;
	
	Rectangle hitBox;
	
	public Wall(int x,int y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		hitBox=new Rectangle(x,y,width,height);
	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.WHITE);
		gtd.drawRect(x,y,width,height);
		gtd.setColor(Color.RED);
		gtd.fillRect(x+1, y+1, width-2, height-2);
	}

}
