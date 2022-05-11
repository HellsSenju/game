package Game;

import java.awt.*;
import javax.swing.*;

public class Enemy{
	
	static Image imgE = new ImageIcon("res/enemy.png").getImage();
	
	private double x;
	private double y;
	private int r;
	
	private double speed; 
	private double dx;
	private double dy;
	
	public static int kolE = 0;

	private int type;
	private int rank;
	
	
	private Color colorEn;
	
	public Enemy(double X){
		x = X; 
		y = 467;
		r = 20;
		speed = 8;
	}
	
	
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public int getR(){
		return r;
	}
	
	
	public boolean remove(){
		if(x < 0){
			
			kolE++;
			return true;
		}
		return false;
	}
	
	
	
	
	public void update(){
		//createEnemies();
		x -= speed;

		
	}
	
	public void draw(Graphics2D g){
		g.setColor(colorEn);
		//g.fillOval((int)(x - r), (int)(y - r), 8 * r, 8 * r);
		g.drawImage(imgE, (int)(x) , (int)(y), null);
		
		
	}
	
}