package Game;

import java.awt.*;
import javax.swing.*;
//import java.​awt.​event.​KeyEvent;
import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener{
	
	Player player = new Player();
	
	public void keyPressed(KeyEvent e){
		
		double key = e.getKeyCode();
		if(key == KeyEvent.VK_W){
			player.up = true;
			
		}
		if(key == KeyEvent.VK_D){
			player.right = true;
		}
		if(key == KeyEvent.VK_A){
			player.left = true;
		}
		
	}
	
	
	public void keyReleased(KeyEvent e){
		double key = e.getKeyCode();
		if(key == KeyEvent.VK_D){
			player.right = false;
		}
		if(key == KeyEvent.VK_A){
			player.left = false;
		}
	}
	
	public void keyTyped(KeyEvent e){
		
	}

	public void mouseDragged(MouseEvent e){
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();
	}

	public void mouseMoved(MouseEvent e){
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}

	public void mousePressed(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1) //если нажата кнопка 1 
		{
			GamePanel.leftMouse = true;
		}
	}

	public void mouseReleased(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.leftMouse = false;
		}
	}

	public void mouseExited(MouseEvent e){
		
	}
	
	
	
	
	
	
	
	
}