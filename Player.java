package Game;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent;

public class Player{
	
	static Image imgP = new ImageIcon("res/player.png").getImage();
	
	private double x;
	private double xP;
	private double y;
	private double yP = 469;
	private int r;
	private int speed;
	private double health;
	public static double plus = 0.12;
	public static double a = -5 + (plus * 4);
	
	
	private Color color1;
	private Color color2;
	
	public static boolean up;
	public static boolean left;
	public static boolean right;
	
	public static boolean F1 = false;
	public static boolean F2 = false;

	//WIDTH = 1500;
	//HEIGHT = 720;

	
	public Player(){
		x = GamePanel.WIDTH - 1400; //x = 100
		y = GamePanel.HEIGHT - 251; // y = 469
		health = 1;
		r = 5;
		speed = 10;
		color1 = Color.WHITE;
		
		up = false;
		left = false;
		right = false;
		
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return yP;
	}

	public int getR(){
		return r;
	}
	
	int perem = 0;
	int perem2 = 0;
	
	public void update(){
		

		if(up == true){
			
			float b = (float)((Math.cos(a)) * 200); // 350 - расстояние вверх, на которое прыгает
			float c = (float)(-((Math.cos(a)) * 5));
			perem = (int) b;
			perem2 = (int) c;
			x += perem2;
			yP += perem;
			a += plus; //скорость прыжка
			//System.out.println("-----------------------------------------------");
			//System.out.println(perem2);
			
			if(a > -1 - (plus * 8) ){
				up = false;
				a = -5 + (plus * 4);
				perem = 0;
				perem2 = 0;
				yP = 469;
				//System.out.println("-----------------------------------------------");
			} 
		}
		else if(left == true){
			if(x >= 5){
				x -= speed;
				xP -= speed;
			}
		}
		else if(right == true){
			if(x <= 1400){
				x += speed;
				xP += speed;
			}
		}			
	}
	
	public void hit(){
		health--;
	}
	
	public boolean remove(){
		if(health <= 0){
			return true;
		}
		return false;
	}

	
	
	public void draw(Graphics2D g){
		g.setColor(color1);
		g.drawImage(imgP, (int) (x), (int) (y + perem), null);
		//g.fillRect((int) ((x - r) + perem2), (int) ((y - r) + perem), r * 9  , r * 9);
	}
	
	
}




