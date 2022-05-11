package Game;

import java.awt.*;
import javax.swing.*;

public class Menue extends JFrame{
	
	private int buttonW = 120;
	private int buttonH = 60;
	private Color color1 = new Color(51, 102, 255);
	private String s = "Play";
	public String name;
	
	
	
	public JButton button1 = new JButton("Play");
	public JTextField t = new JTextField();
	public JPanel menueP;
	
	public Menue(){
		super();
		createGUI();
	}
	
	public void createGUI() {
		add(button1);
	}
	
	
	public void update(){
		// if(GamePanel.mouseX > GamePanel.WIDTH/2 - buttonW/2 && 
			// GamePanel.mouseX < GamePanel.WIDTH/2 + buttonW/2 && 
			// GamePanel.mouseY > GamePanel.HEIGHT/2 - buttonH/2 &&
			// GamePanel.mouseY < GamePanel.HEIGHT/2 + buttonH/2 )
		
		
	}
	
	// public void RememberRes(){
		// try {
			// FileWriter writer = new FileWriter("scores.txt",true);
			// String SCCOres = Integer.toString(Score);
			// writer.write(name);
			// writer.write(" ");
			// writer.write(SCCOres);
			// writer.append('\n');
			// writer.close();
			// //System.exit(0);

		// }catch (IOException e) {
			// System.out.print("error");
			// e.printStackTrace();
		// }
	// }
	
	public void draw(Graphics2D g){
		
		// menueP = new JPanel();
		
		
		// g.setColor(color1);
		// button1.setForeground(Color.BLACK);
        // button1.setBounds(110 , 142, 90, 45);
        // button1.setText("Play");
        // button1.setBorderPainted(false);
        // button1.setBackground(Color.GRAY);
        // button1.setBorder(null);
		// button1.setVisible(true);
		// g.add(button1);
		repaint();
		
		
		
		
		
		// g.setColor(color1);
		// g.setStroke(new BasicStroke(5));//обводка кнопки в 5 пикселей
		// g.drawRect(GamePanel.WIDTH/2 - buttonW/2, GamePanel.HEIGHT/2 - buttonH/2, buttonW, buttonH);
		// g.setStroke(new BasicStroke(1));
		// g.setColor(color1);
		// g.setFont(new Font("Consolas", Font.BOLD, 40));
		// long length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		// g.drawString(s, (int)(GamePanel.WIDTH/2 - length/2), (int) (GamePanel.HEIGHT/2 + buttonH/4));
	}
	
	
	
	
	
	
	
}