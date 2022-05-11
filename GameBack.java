package Game;

import java.awt.*;
import javax.swing.*;

public class GameBack{
	
	private Color color;
	private Color color1 = new Color(230, 230, 230);
	
	static Image img1 = new ImageIcon("res/fon.png").getImage();
	static Image img2 = new ImageIcon("res/fon.png").getImage();
	
	public static boolean GameOver = false;
	
	private static int XMove;
	private static int XMove1 = 1500;
	private static int speed = 15;
	
	Image adress [] = {img1, img2};
	
	public GameBack(){
		//color = Color.BLUE;
		
	}
	
	//functions
	public void update(){
		XMove -= speed;
		XMove1 -= speed;
		
		if(XMove == -1500){
			XMove = 0;
		}
		if(XMove1 == 0){
			XMove1 = 1500;
		}
	}
	
	public void draw(Graphics2D g){
		g.setColor(color1);
		//g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		g.drawImage(adress[0], XMove, 0, null);
		g.drawImage(adress[1], XMove1, 0, null);
		String str = "fooled enemies: " + String.valueOf(Enemy.kolE);
		g.drawString(str, 40, 40);
	}
	
	
}