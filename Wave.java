package Game;

import java.awt.*;
import javax.swing.*;

public class Wave{
	
	public void update(){
		double x = Math.random() * (1490 - 900) + 1490;
		int k = 0;
		if(GamePanel.enemies.size() < 3){
			x = Math.random() * (1490 - 900) + 1490;
			Enemy newE = new Enemy(x); 
			for(int i = 0; i < GamePanel.enemies.size(); i++ ){
				Enemy e = GamePanel.enemies.get(i);
				double ex = e.getX();
				double ey = e.getY();
				
				double newEx = newE.getX();
				double newEy = newE.getY();
				
				double dx = ex - newEx;
				double dy = ey - newEy;
				
				double dist = Math.sqrt(dx * dx + dy * dy);
				if((int)dist >= e.getR() + newE.getR() + 35){
					k++;
				}
			}
			if(k == GamePanel.enemies.size()) createEnemies(x);
		}
	}
	
	public void createEnemies(double x){
		GamePanel.enemies.add(new Enemy(x));
	}
	
	
}