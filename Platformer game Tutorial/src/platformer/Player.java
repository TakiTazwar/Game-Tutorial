package platformer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
	
	GamePanel panel;
	int x,y,height,width;
	
	double xspeed,yspeed;
	
	Rectangle hitBox;
	
	int ground;
	
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	
	public Player(int x,int y,GamePanel panel) {
		this.panel=panel;
		this.x=x;
		this.y=y;
		ground=y;
		
		width=50;
		height=100;
		
		hitBox=new Rectangle(x,y,width,height);
	}
	
	public void set() {
		if(keyLeft && keyRight || !keyLeft && !keyRight ) {
			xspeed *=0.8;
		}
		
		if(keyLeft && !keyRight) {
			 xspeed --;
		}
		
		if(keyRight && !keyLeft) {
			 xspeed ++;
		}
		if(xspeed<0.75 && xspeed>0) {
			xspeed=0;
		}
		if(xspeed<0 && xspeed>-0.75) {
			xspeed=0;
		}
		
		if(xspeed>5) {
			xspeed=5;
		}
		
		if(xspeed<-5) {
			xspeed=-5;
		}		
		if(keyUp) {	
			hitBox.y++;
			for(Wall wall:panel.walls) {
				if(wall.hitBox.intersects(hitBox)) {
					yspeed=-11;
				}
			}
			hitBox.y--;			
		}
		
		yspeed+=.4;  //Gravity
		//Horizontal Collision
		hitBox.x+=xspeed;
		for(Wall wall:panel.walls) {
			if(hitBox.intersects(wall.hitBox)) {
				hitBox.x-=xspeed;
				while(!wall.hitBox.intersects(hitBox)) {
					hitBox.x+=Math.signum(xspeed);
				}
				hitBox.x-=Math.signum(xspeed);//Beacause of pre condition loop;
				xspeed=0;
				x=hitBox.x;
			}
		}
		//Vertical Collision
		hitBox.y+=yspeed;
		for(Wall wall:panel.walls) {
			if(hitBox.intersects(wall.hitBox)) {
				hitBox.y-=yspeed;
				while(!wall.hitBox.intersects(hitBox)) {
					hitBox.y+=Math.signum(yspeed);
				}
				hitBox.y-=Math.signum(yspeed);//Beacause of pre condition loop;
				yspeed=0;
				y=hitBox.y;
			}
		}
		
		
		x+=xspeed;
		y+=yspeed;
		
		hitBox.x=x;
		hitBox.y=y;
	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.black);
		gtd.fillRect(x,y,width,height);
	}

}
