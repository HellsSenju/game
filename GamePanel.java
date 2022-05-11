package Game;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.ArrayList;
//import java.​awt.​event.​*;

public class GamePanel extends JPanel implements Runnable{
	
	
	//field
	public static int WIDTH = 1500;
	public static int HEIGHT = 720;
	
	public static int mouseX;
	public static int mouseY;
	public static boolean leftMouse;
	
	public static ArrayList<Image> boxi;

	
	private Thread thread;//создаем поток
	
	private BufferedImage image; //холст
	private Graphics2D g; //кисточка
	
	public static enum STATES{
		MENUE,
		PLAY
	}
	
	public static STATES state = STATES.PLAY;
	
	
	
	
	public static GameBack background;
	public static Wave wave;
	public static Menue menue;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<Player> player;
	
	
	
	//constructor
	public GamePanel(){
		super();
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus(); //чтобы сделать активным верхнее
		
		addKeyListener(new Listeners()); //привязываем "слушателя"
		addMouseMotionListener(new Listeners());
		addMouseListener(new Listeners());
	}

	//functions
	
	public void start()//отдельный метод для запуска потока
	{
		thread = new Thread(this);
		thread.start();//запускаем поток(запускаем метод run)	
		
	}
	
	public void run(){
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D)image.getGraphics(); //привязываем к кисточке холст
		//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//сглаживание 
		
		background = new GameBack();
		wave = new Wave();
		menue = new Menue();
		enemies = new ArrayList<Enemy>();
		player = new ArrayList<Player>();
		
		leftMouse = false;
		player.add(new Player());
		
		enemies.add(new Enemy(1480));
		enemies.add(new Enemy(1160));
		enemies.add(new Enemy(900));
		
		
		while(true){
			if(state.equals(STATES.MENUE)){
				background.update();
				background.draw(g);
				//menue.update();
				//menue.draw(g);
				gameDraw();
			}
			if(state.equals(STATES.PLAY)){
				gameUpdate();
				gameRender();
				gameDraw();
				if(Enemy.kolE == 5 || player.size() == 0){
					System.exit(0);
				}
			}
			
			try{
				thread.sleep(33); //(в millis) количество милисек должно меняться в зависимости от того
				//сколько времени ему понадобилось на проход цикла
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	//тут будут обновляться данные
	public void gameUpdate()
	{

		//обновление бэка
		background.update();
		
		//обновление игрока
		//player.update();
		if(player.size() > 0){
			player.get(0).update();
		}
		
		//обновление врагов
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).update();
			boolean remove = enemies.get(i).remove();
			if(remove == true){
				enemies.remove(i);
				i--;
			}
		}
		
		//столкновение игрока и врага
		
		for(int i = 0; i < enemies.size(); i++){
			Enemy e = enemies.get(i);
			if(player.size() > 0){
				Player p = player.get(0);
				double ex = e.getX();
				double ey = e.getY();
				
				double px = p.getX();
				double py = p.getY();
				double dx = ex - px;
				double dy = ey - py;
				double dist = Math.sqrt(dx * dx + dy * dy);
				if((int)dist <= e.getR() + p.getR()){
					p.hit();
					boolean remove = p.remove();
					if(remove == true){
						player.remove(0);
					}
					
				}
			}
		}
		
		wave.update();
		
		
	}
	
	public void gameRender()//тут будет обновляться графика
	{
		//рисование бэка
		background.draw(g);
		
		//рисование игрока
		// if(player.size() > 0){
			// player.get(0).draw(g);
		// }
		for(int i = 0; i < player.size(); i++ ){
			player.get(0).draw(g);
		}
		
		
		
		//рисование врагов
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).draw(g);
		}
		
		
		
	}
	
	private void gameDraw()//передача изображения
	{
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();//очищение буфера
		
	}
	
	
	
	
}