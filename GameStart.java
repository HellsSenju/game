

import java.awt.*;
import javax.swing.*;

import Game.*;

public class GameStart{
	public static void main(String[] args){
		
		JFrame w = new JFrame("Window");

		GamePanel panel = new GamePanel();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setContentPane(panel);
		

		
		w.pack(); //чтобы фрэйм занимал столько места, сколько занимают его компоненты
		
		w.setLocationRelativeTo(null); //устанавливае позицию относительно какого-то объекта
		// в данном случае из за null относительно никакого объекта(по центру)
		panel.start();
		w.add(new GamePanel());		
		w.setVisible(true);
	}
}