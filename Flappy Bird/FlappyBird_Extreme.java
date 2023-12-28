//AWT
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//IO
import java.io.File;
//SQL
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
//RANDOM
import java.util.Random;
//SWING
import javax.swing.UIManager.*;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FlappyBird_Extreme extends JPanel implements ActionListener, KeyListener, MouseListener{
	//FRAME
	static JFrame frame = new JFrame();
	static String RP = "./";
	//SQL
	public Connection con;
	public Statement st;
	public ResultSet res;
	//LABEL
	static JLabel lblpage, lblscore, lblhighscore, lblnewbest, lblbg, lblbird, lblscores, lblones, lbltens, lblhundreds, lblthousands, lblone, lblten, lblhundred, lblone2, lblten2, lblhundred2, lblcontrol, lblresolution;
	//ICON
	Icon icnframeicon = new ImageIcon("images/ic_launcher.png");
	Icon icnnewbest = new ImageIcon("images/new_best.png");
	Icon icn0 = new ImageIcon("images/0.png");
	Icon icn1 = new ImageIcon("images/1.png");
	Icon icn2 = new ImageIcon("images/2.png");
	Icon icn3 = new ImageIcon("images/3.png");
	Icon icn4 = new ImageIcon("images/4.png");
	Icon icn5 = new ImageIcon("images/5.png");
	Icon icn6 = new ImageIcon("images/6.png");
	Icon icn7 = new ImageIcon("images/7.png");
	Icon icn8 = new ImageIcon("images/8.png");
	Icon icn9 = new ImageIcon("images/9.png");
	Icon icn0s = new ImageIcon("images/0s.png");
	Icon icn1s = new ImageIcon("images/1s.png");
	Icon icn2s = new ImageIcon("images/2s.png");
	Icon icn3s = new ImageIcon("images/3s.png");
	Icon icn4s = new ImageIcon("images/4s.png");
	Icon icn5s = new ImageIcon("images/5s.png");
	Icon icn6s = new ImageIcon("images/6s.png");
	Icon icn7s = new ImageIcon("images/7s.png");
	Icon icn8s = new ImageIcon("images/8s.png");
	Icon icn9s = new ImageIcon("images/9s.png");
	//TIMER
	private Timer tm = new Timer(13, this);
	//RANDOM
	Random rnd = new Random();
	//INTEGER
	int velorangebird = 1, velbirdorange = 1, orangebirdx = 135, orangebird = 253, birdw = 53, birdh = 27, pipew = 80, pipeh = 463, floorx = 0, floor2x = 489, birdorangey = 235, pipedownx, pipeupx, pipeupx2, pipedownx2, pipeupx3, pipedownx3, gameovery = 100, finalscorey = 852, distance = 576, ratey = 324, standingy = 436, playy = 436, plus = 1, pipeupy, pipedowny, pipeupy2, pipedowny2, pipeupy3, pipedowny3, time, score, scores, random, random2, random3, randombg, randombird, randomshinex, randomshiney, shinex, shiney, birdorangecount, shinecount, shine, accelerationcount, acceleration, accelerationcount2, flashcount, flash, iconcount, iconcount2, iconcount3, iconcount4, buttoncount, scorecount, hscore, x, y, x2x = 651, x2y, x2w = 80, x2h = 80, floorspeed = 3;
	//STRING
	static String highscore, control, resolution;
	//BOOLEAN
	boolean splash = true, bgmain = false, title = false, character = false, getready = false, gameover = false, pipe = false, floor = false, birdorange1 = true, birdorange2 = false, birdorange3 = false, orangebird1 = true, orangebird2 = false, orangebird3 = false, bluebird1 = true, bluebird2 = false, bluebird3 = false, redbird1 = false, redbird2 = false, redbird3 = false, day = false, night = false, orange = false, blue = false, red = false, oranges = false, blues = false, reds = false, birdblue1 = false, birdblue2 = false, birdblue3 = false, birdred1 = false, birdred2 = false, birdred3 = false, shine1 = true, shine2 = false, shine3 = false, shines = false, bronze = false, silver = false, gold = false, white = false, deadorange = false, deadblue = false, deadred = false, gameoverflash = false, copyright = false, button = false, rate = false, powerup = true;
	//RANDOM HEIGHT OF PIPE in Y-AXIS
	private int mypipey[] = {0,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423};
	//RANDOM POSITION OF SHINE when MEDAL is acquired in X-AXIS
	private int myshinex[] = {0,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160};
	//RANDOM POSITION OF SHINE when MEDAL is acquired in Y-AXIS
	private int myshiney[] = {0,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335};
	//RANDOM BACKGROUND (if day or night)
	private String mybg[] = {"","day","night"};
	//RANDOM COLOR of BIRD (if orange, blue, or red)
	private String mybird[] = {"","orange","blue","red"};
	
public FlappyBird_Extreme(){
	CONNECT();		//SQL
	HIGHSCORE();	//SAVED HIGHSCORE
	CONTROL();		//SAVED CONTROLS
	FRAME_ICON();	//FRAME ICON
	
	tm.start();
	setLayout(null);
	
	this.requestFocus();
	addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    
    addMouseListener(this);
	
	//PAGE
	lblpage = new JLabel("0");
	lblpage.setBounds(0,0,0,0);
	lblpage.setVisible(false);
	add(lblpage);
	
	//SCORE
	lblscore = new JLabel("0");
	lblscore.setBounds(0,0,0,0);
	lblscore.setVisible(false);
	add(lblscore);
	
	lblscores = new JLabel("0");
	lblscores.setBounds(0,0,0,0);
	lblscores.setVisible(false);
	add(lblscores);
	
	//SCORE W/ ICON (LARGE)
	lblones = new JLabel();
	lblones.setBounds(210,27,icn0.getIconWidth(),icn0.getIconHeight());
	lblones.setIcon(icn0);
	lblones.setVisible(false);
	add(lblones);
	
	lbltens = new JLabel();
	lbltens.setBounds(179,27,icn0.getIconWidth(),icn0.getIconHeight());
	lbltens.setIcon(icn0);
	lbltens.setVisible(false);
	add(lbltens);
	
	lblhundreds = new JLabel();
	lblhundreds.setBounds(148,27,icn0.getIconWidth(),icn0.getIconHeight());
	lblhundreds.setIcon(icn0);
	lblhundreds.setVisible(false);
	add(lblhundreds);
	
	lblthousands = new JLabel();
	lblthousands.setBounds(117,27,icn0.getIconWidth(),icn0.getIconHeight());
	lblthousands.setIcon(icn0);
	lblthousands.setVisible(false);
	add(lblthousands);
	
	//SCORE W/ ICON (SCORE SMALL)
	lblone = new JLabel();
	lblone.setBounds(348,896,icn0s.getIconWidth(),icn0s.getIconHeight());
	lblone.setIcon(icn0s);
	add(lblone);
	
	lblten = new JLabel();
	lblten.setBounds(323,896,icn0s.getIconWidth(),icn0s.getIconHeight());
	lblten.setIcon(icn0s);
	lblten.setVisible(false);
	add(lblten);
	
	lblhundred = new JLabel();
	lblhundred.setBounds(298,896,icn0s.getIconWidth(),icn0s.getIconHeight());
	lblhundred.setIcon(icn0s);
	lblhundred.setVisible(false);
	add(lblhundred);
	
	//SCORE W/ ICON (BEST SMALL)
	lblone2 = new JLabel();
	lblone2.setBounds(348,962,icn0s.getIconWidth(),icn0s.getIconHeight());
	lblone2.setIcon(icn0s);
	add(lblone2);
	
	lblten2 = new JLabel();
	lblten2.setBounds(323,962,icn0s.getIconWidth(),icn0s.getIconHeight());
	lblten2.setIcon(icn0s);
	add(lblten2);
	
	lblhundred2 = new JLabel();
	lblhundred2.setBounds(298,962,icn0s.getIconWidth(),icn0s.getIconHeight());
	lblhundred2.setIcon(icn0s);
	add(lblhundred2);
	
	//HIGHSCORE
	lblhighscore = new JLabel("0");
	lblhighscore.setBounds(0,0,0,0);
	lblhighscore.setVisible(false);
	add(lblhighscore);
	
	//BEST
	lblnewbest = new JLabel(icnnewbest);
	lblnewbest.setBounds(264,291,icnnewbest.getIconWidth(),icnnewbest.getIconHeight());
	lblnewbest.setVisible(false);
	add(lblnewbest);
	
	//BACKGROUND (if day or night)
	lblbg = new JLabel();
	lblbg.setBounds(0,0,0,0);
	lblbg.setVisible(false);
	add(lblbg);
	
	//BIRD (if orange, blue or red)
	lblbird = new JLabel();
	lblbird.setBounds(0,0,0,0);
	lblbird.setVisible(false);
	add(lblbg);
	
	//CONTROLS
	lblcontrol = new JLabel();
	lblcontrol.setBounds(0,0,0,0);
	lblcontrol.setVisible(false);
	add(lblcontrol);
	
	//RESOLUTION
	lblresolution = new JLabel();
	lblresolution.setBounds(0,0,0,0);
	lblresolution.setVisible(false);
	add(lblresolution);
	
	//HIGHSCORE
	lblhighscore.setText(""+highscore);
	
	//CONTROLS
	lblcontrol.setText(""+control);
	
	//BACKGROUND (if day or night)
	randombg = 1 + rnd.nextInt(2);
	String bg = mybg[randombg];
	lblbg.setText(bg);
	
	if("day".equals(lblbg.getText())){
		day=true;
		night=false;
	}
	if("night".equals(lblbg.getText())){
		night=true;
		day=false;
	}
	
	//BIRD (if orange, blue or red)
	randombird = 1 + rnd.nextInt(3);
	String bird = mybird[randombird];
	lblbird.setText(bird);
	
	if("orange".equals(lblbird.getText())){
		oranges=true;
		blues=false;
		reds=false;
		
		orange=true;
		blue=false;
		red=false;
	}
	if("blue".equals(lblbird.getText())){
		blues=true;
		oranges=false;
		reds=false;
		
		blue=true;
		orange=false;
		red=false;
	}
	if("red".equals(lblbird.getText())){
		reds=true;
		oranges=false;
		blues=false;
		
		red=true;
		orange=false;
		blue=false;
	}
	
	//SHINE ANIMATION
	randomshinex = 1 + rnd.nextInt(44);
	int ishinex = myshinex[randomshinex];
	shinex = ishinex;
	
	randomshiney = 1 + rnd.nextInt(44);
	int ishiney = myshiney[randomshiney];
	shiney = ishiney;
}

public void paintComponent(Graphics g){   
	
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	Image icnsplash = Toolkit.getDefaultToolkit().getImage("images/splash.png");
	Image icnbgmain = Toolkit.getDefaultToolkit().getImage("images/bg_day.png");
	Image icnbgmain2 = Toolkit.getDefaultToolkit().getImage("images/bg_night.png");
	Image icnfloor = Toolkit.getDefaultToolkit().getImage("images/floor.png");
	Image icntitle = Toolkit.getDefaultToolkit().getImage("images/title.png");
	Image icnbirdorange1 = Toolkit.getDefaultToolkit().getImage("images/bird_orange1.png");
	Image icnbirdorange2 = Toolkit.getDefaultToolkit().getImage("images/bird_orange2.png");
	Image icnbirdorange3 = Toolkit.getDefaultToolkit().getImage("images/bird_orange3.png");
	Image icnbirdblue1 = Toolkit.getDefaultToolkit().getImage("images/bird_blue1.png");
	Image icnbirdblue2 = Toolkit.getDefaultToolkit().getImage("images/bird_blue2.png");
	Image icnbirdblue3 = Toolkit.getDefaultToolkit().getImage("images/bird_blue3.png");
	Image icnbirdred1 = Toolkit.getDefaultToolkit().getImage("images/bird_red1.png");
	Image icnbirdred2 = Toolkit.getDefaultToolkit().getImage("images/bird_red2.png");
	Image icnbirdred3 = Toolkit.getDefaultToolkit().getImage("images/bird_red3.png");
	Image icngetready = Toolkit.getDefaultToolkit().getImage("images/get_ready.png");
	Image icntutorial = Toolkit.getDefaultToolkit().getImage("images/tutorial.png");
	Image icngameover = Toolkit.getDefaultToolkit().getImage("images/game_over.png");
	Image icnpipeup = Toolkit.getDefaultToolkit().getImage("images/pipe_up.png");
	Image icnpipedown = Toolkit.getDefaultToolkit().getImage("images/pipe_down.png");
	Image icnfinalscore = Toolkit.getDefaultToolkit().getImage("images/final_score.png");
	Image icnshine1 = Toolkit.getDefaultToolkit().getImage("images/shine1.png");
	Image icnshine2 = Toolkit.getDefaultToolkit().getImage("images/shine2.png");
	Image icnshine3 = Toolkit.getDefaultToolkit().getImage("images/shine3.png");
	Image icnbronze = Toolkit.getDefaultToolkit().getImage("images/medal_bronze.png");
	Image icnsilver = Toolkit.getDefaultToolkit().getImage("images/medal_silver.png");
	Image icngold = Toolkit.getDefaultToolkit().getImage("images/medal_gold.png");
	Image icnwhite = Toolkit.getDefaultToolkit().getImage("images/medal_white.png");
	Image icndeadorange = Toolkit.getDefaultToolkit().getImage("images/dead_orange.png");
	Image icndeadblue = Toolkit.getDefaultToolkit().getImage("images/dead_blue.png");
	Image icndeadred = Toolkit.getDefaultToolkit().getImage("images/dead_red.png");
	Image icngameoverflash = Toolkit.getDefaultToolkit().getImage("images/gameover_flash.png");
	Image icncopyright = Toolkit.getDefaultToolkit().getImage("images/copyright.png");
	Image icnbtnrate = Toolkit.getDefaultToolkit().getImage("images/btn_rate.png");
	Image icnbtnplay = Toolkit.getDefaultToolkit().getImage("images/btn_play.png");
	Image icnbtnstanding = Toolkit.getDefaultToolkit().getImage("images/btn_standing.png");
	Image icnpowerupx2 = Toolkit.getDefaultToolkit().getImage("images/powerup_boost.png");
	
	//BACKGROUND
	if(bgmain==true){
		if(night==true){
			g2.drawImage(icnbgmain2, 0, 0, this);
		}
		if(day==true){
			g2.drawImage(icnbgmain, 0, 0, this);
		}
	}
	
	//SPLASH
	if(splash==true){
		g2.drawImage(icnsplash, 0, 0, this);
	}
	
	//BIRD & TITLE
	if(title==true){
		g2.drawImage(icntitle, 456/2-139, 133, this);
		if(oranges==true){
			if(birdorange3==true){
				g2.drawImage(icnbirdorange3, 456/2-26, birdorangey, this);
			}
			if(birdorange2==true){
				g2.drawImage(icnbirdorange2, 456/2-26, birdorangey, this);
			}
			if(birdorange1==true){
				g2.drawImage(icnbirdorange1, 456/2-26, birdorangey, this);
			}
		}
		if(blues==true){
			if(birdblue3==true){
				g2.drawImage(icnbirdblue3, 456/2-26, birdorangey, this);
			}
			if(birdblue2==true){
				g2.drawImage(icnbirdblue2, 456/2-26, birdorangey, this);
			}
			if(birdblue1==true){
				g2.drawImage(icnbirdblue1, 456/2-26, birdorangey, this);
			}
		}
		if(reds==true){
			if(birdred3==true){
				g2.drawImage(icnbirdred3, 456/2-26, birdorangey, this);
			}
			if(birdred2==true){
				g2.drawImage(icnbirdred2, 456/2-26, birdorangey, this);
			}
			if(birdred1==true){
				g2.drawImage(icnbirdred1, 456/2-26, birdorangey, this);
			}
		}
	}
	
	//PIPE
	if(pipe==true){
		g2.drawImage(icnpipeup, pipeupx, pipeupy, this);
		g2.drawImage(icnpipedown, pipedownx, pipedowny, this);
		
		g2.drawImage(icnpipeup, pipeupx2, pipeupy2, this);
		g2.drawImage(icnpipedown, pipedownx2, pipedowny2, this);
		
		g2.drawImage(icnpipeup, pipeupx3, pipeupy3, this);
		g2.drawImage(icnpipedown, pipedownx3, pipedowny3, this);
	}
	
	//POWER UP
	if(powerup==true){
		g2.drawImage(icnpowerupx2, x2x, x2y, this);
	}
	
	//CHARACTER
	if(character==true){
		if(orange==true){
			if(orangebird3==true){
				g2.drawImage(icnbirdorange3, orangebirdx, orangebird, this);
			}
			if(orangebird2==true){
				g2.drawImage(icnbirdorange2, orangebirdx, orangebird, this);
			}
			if(orangebird1==true){
				g2.drawImage(icnbirdorange1, orangebirdx, orangebird, this);
			}
			if(deadorange==true){
				g2.drawImage(icndeadorange, 114, 479, this);
			}
		}
		if(blue==true){
			if(bluebird3==true){
				g2.drawImage(icnbirdblue3, orangebirdx, orangebird, this);
			}
			if(bluebird2==true){
				g2.drawImage(icnbirdblue2, orangebirdx, orangebird, this);
			}
			if(bluebird1==true){
				g2.drawImage(icnbirdblue1, orangebirdx, orangebird, this);
			}
			if(deadblue==true){
				g2.drawImage(icndeadblue, 114, 479, this);
			}
		}
		if(red==true){
			if(redbird3==true){
				g2.drawImage(icnbirdred3, orangebirdx, orangebird, this);
			}
			if(redbird2==true){
				g2.drawImage(icnbirdred2, orangebirdx, orangebird, this);
			}
			if(redbird1==true){
				g2.drawImage(icnbirdred1, orangebirdx, orangebird, this);
			}
			if(deadred==true){
				g2.drawImage(icndeadred, 114, 479, this);
			}
		}
	}
	
	//BUTTON
	if(button==true){
		g2.drawImage(icnbtnstanding, 249, standingy, this);
		g2.drawImage(icnbtnplay, 43, playy, this);
	}
	
	if(rate==true){
		g2.drawImage(icnbtnrate, 180, ratey, this);
	}
	
	//GET READY & TUTORIAL
	if(getready==true){
		g2.drawImage(icngetready, 456/2-143, 130, this);
		g2.drawImage(icntutorial, 456/2-89, 243, this);
	}
	
	//FLOOR
	if(floor==true){
		g2.drawImage(icnfloor, floorx, 525, 489, 75, this);
		g2.drawImage(icnfloor, floor2x, 525, 489, 75, this);
		
		if(gameoverflash==true){
			g2.drawImage(icngameoverflash, 0, 0, this);
		}
	}
	
	//GAMEOVER
	if(gameover==true){
		g2.drawImage(icngameover, 456/2-150, gameovery, this);
		g2.drawImage(icnfinalscore, 456/2-177, finalscorey, this);
	}
	
	//MEDAL
	if(bronze==true){
		g2.drawImage(icnbronze, 91, 266, this);
	}
	if(silver==true){
		g2.drawImage(icnsilver, 91, 266, this);
	}
	if(gold==true){
		g2.drawImage(icngold, 91, 266, this);
	}
	if(white==true){
		g2.drawImage(icnwhite, 91, 266, this);
	}
	
	//SHINE
	if(shines==true){
		if(shine1==true){
			g2.drawImage(icnshine1, shinex, shiney, this);
		}
		if(shine2==true){
			g2.drawImage(icnshine2, shinex, shiney, this);
		}
		if(shine3==true){
			g2.drawImage(icnshine3, shinex, shiney, this);
		}
	}
	
	//COPYRIGHT
	if(copyright==true){
		g2.drawImage(icncopyright, 456/2-99, 553, this);
	}
	
	//g2.finalize();
    repaint();
}

public void keyPressed(KeyEvent e){
	if(Integer.parseInt(lblpage.getText())==1&&"Enter Key".equals(lblcontrol.getText())){
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_ENTER){	
			velorangebird = 0;
			velbirdorange = 0;
			getready = false;
			pipe = true;
			accelerationcount2 = 0;		
		}
	}
} 

public void keyTyped(KeyEvent e){}   

public void keyReleased(KeyEvent e){}

public void mouseClicked(MouseEvent e){}

public void mouseEntered(MouseEvent e){}

public void mouseExited(MouseEvent e){}

public void mousePressed(MouseEvent e){
	if(Integer.parseInt(lblpage.getText())==1&&"Left Click".equals(lblcontrol.getText())){
		velorangebird = 0;
		velbirdorange = 0;
		getready = false;
		pipe = true;
		accelerationcount2 = 0;
		
	}
	
	x = e.getX();
	y = e.getY();
	if(button==true){
		if((x>=180&&x<=276)&&(y>=324&&y<=380)){
			ratey = 326;
		}
		if((x>=249&&x<=411)&&(y>=436&&y<=526)){
			standingy = 438;
		}
		if((x>=43&&x<=205)&&(y>=436&&y<=526)){
			playy = 438;
		}
	}
}

public void mouseReleased(MouseEvent e){
	if(button==true){
		if((x>=180&&x<=276)&&(y>=324&&y<=380)){
			ratey = 324;
		}
		if((x>=249&&x<=411)&&(y>=436&&y<=526)){
			standingy = 436;
		}
		if((x>=43&&x<=205)&&(y>=436&&y<=526)){
			playy = 436;
			PLAY();
		}
	}
}

//POWER UP 2X
public void POWERUP_X2(){
	if(x2y+x2h>=orangebird&&x2x+x2w>=orangebirdx&&x2x<=orangebirdx+birdw&&x2y<=orangebird){
		powerup = false;
		//plus = 2;
		//distance = 650;
		floorspeed = 6;
	}
}

//SCORE
public void SCORE(){
	score=score+plus;
	lblscore.setText(Integer.toString(score));
	
	iconcount++;
	if(iconcount==1){
		lblones.setIcon(icn1);
	}
	if(iconcount==2){
		lblones.setIcon(icn2);
	}
	if(iconcount==3){
		lblones.setIcon(icn3);
	}
	if(iconcount==4){
		lblones.setIcon(icn4);
	}
	if(iconcount==5){
		lblones.setIcon(icn5);
	}
	if(iconcount==6){
		lblones.setIcon(icn6);
	}
	if(iconcount==7){
		lblones.setIcon(icn7);
	}
	if(iconcount==8){
		lblones.setIcon(icn8);
	}
	if(iconcount==9){
		lblones.setIcon(icn9);
	}
	if(iconcount==10){
		lblones.setIcon(icn0);
		iconcount=0;
			
		iconcount2++;
		if(iconcount2==1){
			lbltens.setIcon(icn1);
		}
		if(iconcount2==2){
			lbltens.setIcon(icn2);
		}
		if(iconcount2==3){
			lbltens.setIcon(icn3);
		}
		if(iconcount2==4){
			lbltens.setIcon(icn4);
		}
		if(iconcount2==5){
			lbltens.setIcon(icn5);
		}
		if(iconcount2==6){
			lbltens.setIcon(icn6);
		}
		if(iconcount2==7){
			lbltens.setIcon(icn7);
		}
		if(iconcount2==8){
			lbltens.setIcon(icn8);
		}
		if(iconcount2==9){
			lbltens.setIcon(icn9);
		}
		if(iconcount2==10){
			lbltens.setIcon(icn0);
			iconcount2=0;
				
			iconcount3++;
			if(iconcount3==1){
				lblhundreds.setIcon(icn1);
			}
			if(iconcount3==2){
				lblhundreds.setIcon(icn2);
			}
			if(iconcount3==3){
				lblhundreds.setIcon(icn3);
			}
			if(iconcount3==4){
				lblhundreds.setIcon(icn4);
			}
			if(iconcount3==5){
				lblhundreds.setIcon(icn5);
			}
			if(iconcount3==6){
				lblhundreds.setIcon(icn6);
			}
			if(iconcount3==7){
				lblhundreds.setIcon(icn7);
			}
			if(iconcount3==8){
				lblhundreds.setIcon(icn8);
			}
			if(iconcount3==9){
				lblhundreds.setIcon(icn9);
			}
			if(iconcount3==10){
				lblhundreds.setIcon(icn0);
				iconcount3=0;
				lblthousands.setVisible(true);
					
				iconcount4++;
				if(iconcount4==1){
					lblthousands.setIcon(icn1);
				}
			}
		}
	}
		
	if(score==10){
		lbltens.setVisible(true);
		lbltens.setLocation(197,27);
		lblones.setLocation(228,27);
	}
	if(score==100){
		lblhundreds.setVisible(true);
		lblhundreds.setLocation(179,27);
		lbltens.setLocation(210,27);
		lblones.setLocation(241,27);
	}
}

//GAME OVER
public void GAME_OVER(){
	accelerationcount=0;
	accelerationcount2=0;
	
	floorx=floorx+3;
	floor2x=floor2x+3;
		
	pipeupx=pipeupx+3;
	pipedownx=pipedownx+3;
	pipeupx2=pipeupx2+3;
	pipedownx2=pipedownx2+3;
	pipeupx3=pipeupx3+3;
	pipedownx3=pipedownx3+3;
	
	x2x=x2x+3;
		
	flash++;
	if(flash==3){
		tm.stop();
		flash=0;
		tm.start();
		
		flashcount++;
		if(flashcount==1){
			gameoverflash=true;
		}
		if(flashcount==2){
			gameoverflash=false;
		}
	}
		
	orangebird=orangebird+13;
	if(orangebird>488){
		orangebird=700;
		deadorange = true;
		deadblue = true;
		deadred = true;
		orangebird1 = false;
		orangebird2 = false;
		orangebird3 = false;
		bluebird1 = false;
		bluebird2 = false;
		bluebird3 = false;
		redbird1 = false;
		redbird2 = false;
		redbird3 = false;
		gameover = true;
		
		gameovery=gameovery-2;
		if(gameovery<100){
			gameovery=100;
			
			lblone.setLocation(lblone.getX(), lblone.getY()-15);
			lblten.setLocation(lblten.getX(), lblten.getY()-15);
			lblhundred.setLocation(lblhundred.getX(), lblhundred.getY()-15);
			if(lblone.getY()<254||lblten.getY()<254||lblhundred.getY()<254){
				lblone.setLocation(348,254);
				lblten.setLocation(323,254);
				lblhundred.setLocation(298,254);
			}
			
			lblone2.setLocation(lblone2.getX(), lblone2.getY()-15);
			lblten2.setLocation(lblten2.getX(), lblten2.getY()-15);
			lblhundred2.setLocation(lblhundred2.getX(), lblhundred2.getY()-15);
			if(lblone2.getY()<320||lblten2.getY()<320||lblhundred2.getY()<320){
				lblone2.setLocation(348,320);
				lblten2.setLocation(323,320);
				lblhundred2.setLocation(298,320);
			}
	
			finalscorey=finalscorey-15;
			if(finalscorey<200){
				finalscorey=200;
				
				lblone.setVisible(true);
				lblone2.setVisible(true);
				
				if(scores==0){
					lblone.setIcon(icn0s);
				}
				if(scores==1){
					lblone.setIcon(icn1s);
				}
				if(scores==2){
					lblone.setIcon(icn2s);
				}
				if(scores==3){
					lblone.setIcon(icn3s);
				}
				if(scores==4){
					lblone.setIcon(icn4s);
				}
				if(scores==5){
					lblone.setIcon(icn5s);
				}
				if(scores==6){
					lblone.setIcon(icn6s);
				}
				if(scores==7){
					lblone.setIcon(icn7s);
				}
				if(scores==8){
					lblone.setIcon(icn8s);
				}
				if(scores==9){
					lblone.setIcon(icn9s);
				}
				if(scores==10){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn1s);
					lblten.setVisible(true);
				}
				if(scores==11){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn1s);
				}
				if(scores==12){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn1s);
				}
				if(scores==13){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn1s);
				}
				if(scores==14){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn1s);
				}
				if(scores==15){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn1s);
				}
				if(scores==16){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn1s);
				}
				if(scores==17){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn1s);
				}
				if(scores==18){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn1s);
				}
				if(scores==19){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn1s);
				}
				if(scores==20){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn2s);
				}
				if(scores==21){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn2s);
				}
				if(scores==22){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn2s);
				}
				if(scores==23){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn2s);
				}
				if(scores==24){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn2s);
				}
				if(scores==25){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn2s);
				}
				if(scores==26){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn2s);
				}
				if(scores==27){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn2s);
				}
				if(scores==28){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn2s);
				}
				if(scores==29){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn2s);
				}
				if(scores==30){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn3s);
				}
				if(scores==31){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn3s);
				}
				if(scores==32){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn3s);
				}
				if(scores==33){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn3s);
				}
				if(scores==34){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn3s);
				}
				if(scores==35){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn3s);
				}
				if(scores==36){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn3s);
				}
				if(scores==37){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn3s);
				}
				if(scores==38){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn3s);
				}
				if(scores==39){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn3s);
				}
				if(scores==40){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn4s);
				}
				if(scores==41){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn4s);
				}
				if(scores==42){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn4s);
				}
				if(scores==43){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn4s);
				}
				if(scores==44){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn4s);
				}
				if(scores==45){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn4s);
				}
				if(scores==46){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn4s);
				}
				if(scores==47){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn4s);
				}
				if(scores==48){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn4s);
				}
				if(scores==49){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn4s);
				}
				if(scores==50){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn5s);
				}
				if(scores==51){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn5s);
				}
				if(scores==52){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn5s);
				}
				if(scores==53){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn5s);
				}
				if(scores==54){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn5s);
				}
				if(scores==55){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn5s);
				}
				if(scores==56){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn5s);
				}
				if(scores==57){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn5s);
				}
				if(scores==58){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn5s);
				}
				if(scores==59){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn5s);
				}
				if(scores==60){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn6s);
				}
				if(scores==61){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn6s);
				}
				if(scores==62){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn6s);
				}
				if(scores==63){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn6s);
				}
				if(scores==64){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn6s);
				}
				if(scores==65){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn6s);
				}
				if(scores==66){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn6s);
				}
				if(scores==67){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn6s);
				}
				if(scores==68){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn6s);
				}
				if(scores==69){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn6s);
				}
				if(scores==70){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn7s);
				}
				if(scores==71){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn7s);
				}
				if(scores==72){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn7s);
				}
				if(scores==73){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn7s);
				}
				if(scores==74){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn7s);
				}
				if(scores==75){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn7s);
				}
				if(scores==76){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn7s);
				}
				if(scores==77){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn7s);
				}
				if(scores==78){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn7s);
				}
				if(scores==79){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn7s);
				}
				if(scores==80){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn8s);
				}
				if(scores==81){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn8s);
				}
				if(scores==82){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn8s);
				}
				if(scores==83){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn8s);
				}
				if(scores==84){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn8s);
				}
				if(scores==85){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn8s);
				}
				if(scores==86){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn8s);
				}
				if(scores==87){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn8s);
				}
				if(scores==88){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn8s);
				}
				if(scores==89){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn8s);
				}
				if(scores==90){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn9s);
				}
				if(scores==91){
					lblone.setIcon(icn1s);
					lblten.setIcon(icn9s);
				}
				if(scores==92){
					lblone.setIcon(icn2s);
					lblten.setIcon(icn9s);
				}
				if(scores==93){
					lblone.setIcon(icn3s);
					lblten.setIcon(icn9s);
				}
				if(scores==94){
					lblone.setIcon(icn4s);
					lblten.setIcon(icn9s);
				}
				if(scores==95){
					lblone.setIcon(icn5s);
					lblten.setIcon(icn9s);
				}
				if(scores==96){
					lblone.setIcon(icn6s);
					lblten.setIcon(icn9s);
				}
				if(scores==97){
					lblone.setIcon(icn7s);
					lblten.setIcon(icn9s);
				}
				if(scores==98){
					lblone.setIcon(icn8s);
					lblten.setIcon(icn9s);
				}
				if(scores==99){
					lblone.setIcon(icn9s);
					lblten.setIcon(icn9s);
				}
				if(scores==100){
					lblone.setIcon(icn0s);
					lblten.setIcon(icn0s);
					lblhundred.setIcon(icn1s);
					lblhundred.setVisible(true);
				}
				
				scores++;
				lblscores.setText(Integer.toString(scores));
				
				if(scores>score){
					scores--;
					lblscores.setText(Integer.toString(scores));
					
					SHINE_ANIMATION();
					shines = true;
					button = true;
					
					if(score>=0&&score<=9){
						shines = false;
					}
					if(score>=10&&score<=19){
						bronze = true;
						silver = false;
						gold = false;
						white = false;
					}
					if(score>=20&&score<=29){
						silver = true;
						bronze = false;
						gold = false;
						white = false;
					}
					if(score>=30&&score<=39){
						gold = true;
						silver = false;
						bronze = false;
						white = false;
					}
					if(score>39){
						white = true;
						gold = false;
						silver = false;
						bronze = false;
					}
						
					int hs = Integer.parseInt(highscore);
					if(score>hs){
						lblnewbest.setVisible(true);
						
						try{
							st.executeUpdate("update tblscore set Score = '"+ score +"'");
							lblhighscore.setText(Integer.toString(score));
						}
						catch(Exception error){
							JOptionPane.showMessageDialog(null,error);
						}
					}
					else{
						lblnewbest.setVisible(false);
					}
				}
			}
		}
		if(gameovery<110){
			lblones.setVisible(false);
			lbltens.setVisible(false);
			lblhundreds.setVisible(false);
			lblthousands.setVisible(false);
		}
	}
	
	hscore = Integer.parseInt(lblhighscore.getText());
	if(hscore>=0&&hscore<=9){
		lblone2.setVisible(true);
		lblten2.setVisible(false);
		lblhundred2.setVisible(false);
	}
	if(hscore>=10&&hscore<=99){
		lblone2.setVisible(true);
		lblten2.setVisible(true);
		lblhundred2.setVisible(false);
	}
	if(hscore>99){
		lblone2.setVisible(true);
		lblten2.setVisible(true);
		lblhundred2.setVisible(true);
	}
		
	if(hscore==0){
		lblone2.setIcon(icn0s);
	}
	if(hscore==1){
		lblone2.setIcon(icn1s);
	}
	if(hscore==2){
		lblone2.setIcon(icn2s);
	}
	if(hscore==3){
		lblone2.setIcon(icn3s);
	}
	if(hscore==4){
		lblone2.setIcon(icn4s);
	}
	if(hscore==5){
		lblone2.setIcon(icn5s);
	}
	if(hscore==6){
		lblone2.setIcon(icn6s);
	}
	if(hscore==7){
		lblone2.setIcon(icn7s);
	}
	if(hscore==8){
		lblone2.setIcon(icn8s);
	}
	if(hscore==9){
		lblone2.setIcon(icn9s);
	}
	if(hscore==10){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==11){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==12){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==13){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==14){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==15){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==16){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==17){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==18){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==19){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn1s);
	}
	if(hscore==20){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==21){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==22){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==23){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==24){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==25){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==26){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==27){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==28){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==29){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn2s);
	}
	if(hscore==30){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==31){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==32){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==33){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==34){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==35){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==36){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==37){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==38){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==39){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn3s);
	}
	if(hscore==40){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==41){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==42){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==43){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==44){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==45){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==46){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==47){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==48){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==49){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn4s);
	}
	if(hscore==50){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==51){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==52){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==53){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==54){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==55){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==56){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==57){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==58){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==59){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn5s);
	}
	if(hscore==60){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==61){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==62){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==63){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==64){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==65){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==66){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==67){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==68){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==69){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn6s);
	}
	if(hscore==70){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==71){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==72){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==73){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==74){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==75){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==76){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==77){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==78){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==79){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn7s);
	}
	if(hscore==80){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==81){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==82){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==83){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==84){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==85){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==86){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==87){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==88){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==89){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn8s);
	}
	if(hscore==90){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==91){
		lblone2.setIcon(icn1s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==92){
		lblone2.setIcon(icn2s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==93){
		lblone2.setIcon(icn3s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==94){
		lblone2.setIcon(icn4s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==95){
		lblone2.setIcon(icn5s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==96){
		lblone2.setIcon(icn6s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==97){
		lblone2.setIcon(icn7s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==98){
		lblone2.setIcon(icn8s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==99){
		lblone2.setIcon(icn9s);
		lblten2.setIcon(icn9s);
	}
	if(hscore==100){
		lblone2.setIcon(icn0s);
		lblten2.setIcon(icn0s);
		lblhundred2.setIcon(icn1s);
	}
}

//COLLISION
public void COLLISION(){
	if((pipedowny+pipeh>=orangebird&&pipedownx+pipew>=orangebirdx&&pipedownx<=orangebirdx+birdw&&pipedowny<=orangebird)||(pipeupy+pipeh>=orangebird&&pipeupx+pipew>=orangebirdx&&pipeupx<=orangebirdx+birdw&&pipeupy<=orangebird)||(pipedowny2+pipeh>=orangebird&&pipedownx2+pipew>=orangebirdx&&pipedownx2<=orangebirdx+birdw&&pipedowny2<=orangebird)||(pipeupy2+pipeh>=orangebird&&pipeupx2+pipew>=orangebirdx&&pipeupx2<=orangebirdx+birdw&&pipeupy2<=orangebird)||(pipedowny3+pipeh>=orangebird&&pipedownx3+pipew>=orangebirdx&&pipedownx3<=orangebirdx+birdw&&pipedowny3<=orangebird)||(pipeupy3+pipeh>=orangebird&&pipeupx3+pipew>=orangebirdx&&pipeupx3<=orangebirdx+birdw&&pipeupy3<=orangebird)||orangebird>488){
		lblpage.setText("2");		
	}
}

//SPLASH ANIMATION
public void SPLASH_ANIMATION(){
	time=0;
	splash = false;
	bgmain = true;
	title = true;
	floor = true;
	copyright = true;
	button = true;
	rate = true;
}

//BIRD ANIMATION
public void BIRD_ANIMATION(){
	tm.stop();
	time=0;
	tm.start();
	birdorangecount++;
	if(birdorangecount==1){
		birdorange1=false;
		birdorange2=true;
			
		birdblue1=false;
		birdblue2=true;
			
		birdred1=false;
		birdred2=true;
			
		orangebird1=false;
		orangebird2=true;
			
		bluebird1=false;
		bluebird2=true;
			
		redbird1=false;
		redbird2=true;
	}
	if(birdorangecount==2){
		birdorange2=false;
		birdorange3=true;
			
		birdblue2=false;
		birdblue3=true;
			
		birdred2=false;
		birdred3=true;
			
		orangebird2=false;
		orangebird3=true;
			
		bluebird2=false;
		bluebird3=true;
			
		redbird2=false;
		redbird3=true;
	}
	if(birdorangecount==3){
		birdorange3=false;
		birdorange2=true;
			
		birdblue3=false;
		birdblue2=true;
			
		birdred3=false;
		birdred2=true;
			
		orangebird3=false;
		orangebird2=true;
			
		bluebird3=false;
		bluebird2=true;
			
		redbird3=false;
		redbird2=true;
	}
	if(birdorangecount==4){
		birdorange2=false;
		birdorange1=true;	
			
		birdblue2=false;
		birdblue1=true;
			
		birdred2=false;
		birdred1=true;
			
		orangebird2=false;
		orangebird1=true;
			
		bluebird2=false;
		bluebird1=true;
			
		redbird2=false;
		redbird1=true;
				
		birdorangecount=0;
	}
}

//SHINE ANIMATION
public void SHINE_ANIMATION(){
	shine++;	
	if(shine==5){
		tm.stop();
		shine=0;
		tm.start();
		
		shinecount++;
		if(shinecount==1){
			shine1=true;
			shine2=false;
			shine3=false;
		}
		if(shinecount==2){
			shine2=true;
			shine1=false;
			shine3=false;
		}
		if(shinecount==3){
			shine3=true;
			shine2=false;
			shine1=false;
		}
		if(shinecount==4){
			shine2=true;
			shine3=false;
			shine1=false;
		}
		if(shinecount==5){
			shine1=true;
			shine2=false;
			shine3=false;
		}
		if(shinecount==6){
			shine1=false;
			
			shinecount=0;
			
			randomshinex = 1 + rnd.nextInt(70);
			int ishinex = myshinex[randomshinex];
			shinex = ishinex;
			
			randomshiney = 1 + rnd.nextInt(70);
			int ishiney = myshiney[randomshiney];
			shiney = ishiney;
		}
	}
}

//PLAY
public void PLAY(){
	orangebirdx = 114;
	orangebird = 276;
	velbirdorange = 0;
	velorangebird = 1;
	gameovery = 120;
	finalscorey = 852;
	scores = 0;
	flashcount = 0;
	iconcount = 0;
	iconcount2 = 0;
	iconcount3 = 0;
	iconcount4 = 0;
		
	pipedownx = 651;
	pipeupx = 651;
	pipedownx2 = 897;
	pipeupx2 = 897;
	pipedownx3 = 1140;
	pipeupx3 = 1140;
		
	lblone.setIcon(icn0s);
	lblten.setIcon(icn0s);
	lblhundred.setIcon(icn0s);
	lblone2.setIcon(icn0s);
	lblten2.setIcon(icn0s);
	lblhundred2.setIcon(icn0s);
	lblones.setIcon(icn0);
	lbltens.setIcon(icn0);
	lblhundreds.setIcon(icn0);
	lblthousands.setIcon(icn0);
	lblones.setLocation(210,27);
	lbltens.setLocation(179,27);
	lblhundreds.setLocation(148,27);
	lblthousands.setLocation(117,27);
	lblones.setVisible(true);
	lblhighscore.setVisible(false);
	lblnewbest.setVisible(false);
	lblscores.setVisible(false);
	lblten.setVisible(false);
	lblhundred.setVisible(false);
	lblone.setLocation(348,896);
	lblten.setLocation(323,896);
	lblhundred.setLocation(298,896);
	lblone2.setLocation(348,962);
	lblten2.setLocation(323,962);
	lblhundred2.setLocation(298,962);
		
	title = false;
	gameover = false;
	shines = false;
	bronze = false;
	silver = false;
	gold = false;
	white = false;
	pipe = false;
	deadorange = false;
	deadblue = false;
	deadred = false;
	copyright = false;
	button = false;
	rate = false;
	getready = true;
	character = true;
		
	lblpage.setText("1");
		
	score = 0;
	lblscore.setText(Integer.toString(score));
		
	random = 1 + rnd.nextInt(280);
	int pipey = mypipey[random];
	pipedowny = pipey;
	pipeupy = pipey - distance;
		
	random2 = 1 + rnd.nextInt(280);
	int pipey2 = mypipey[random2];
	pipedowny2 = pipey2;
	pipeupy2 = pipey2 - distance;
		
	random3 = 1 + rnd.nextInt(280);
	int pipey3 = mypipey[random3];
	pipedowny3 = pipey3;
	pipeupy3 = pipey3 - distance;
		
	randombg = 1 + rnd.nextInt(2);
	String bg = mybg[randombg];
	lblbg.setText(bg);
		
	buttoncount++;
	if(buttoncount==1){}
		
	if(buttoncount>1){
		if("day".equals(lblbg.getText())){
			day=true;
			night=false;
		}
		if("night".equals(lblbg.getText())){
			night=true;
			day=false;
		}
			
		randombird = 1 + rnd.nextInt(3);
		String bird = mybird[randombird];
		lblbird.setText(bird);
			
		if("orange".equals(lblbird.getText())){
			oranges=true;
			blues=false;
			reds=false;
				
			orange=true;
			blue=false;
			red=false;
		}
		if("blue".equals(lblbird.getText())){
			blues=true;
			oranges=false;
			reds=false;
				
			blue=true;
			orange=false;
			red=false;
		}
		if("red".equals(lblbird.getText())){
			reds=true;
			oranges=false;
			blues=false;
				
			red=true;
			orange=false;
			blue=false;
		}
	}
}

//PIPE RANDOM
public void PIPE_RANDOM(){
	if(pipedownx<=-80){
		pipedownx = 651;
		pipeupx = 651;
			
		random = 1 + rnd.nextInt(280);
		int pipey = mypipey[random];
		pipedowny = pipey;
		pipeupy = pipey - distance;
		x2y = pipey - 80;
	}
	
	if(pipedownx2<=-80){
		pipedownx2 = 651;
		pipeupx2 = 651;
			
		random2 = 1 + rnd.nextInt(280);
		int pipey2 = mypipey[random2];
		pipedowny2 = pipey2;
		pipeupy2 = pipey2 - distance;
	}
	
	if(pipedownx3<=-80){
		pipedownx3 = 651;
		pipeupx3 = 651;
			
		random3 = 1 + rnd.nextInt(280);
		int pipey3 = mypipey[random3];
		pipedowny3 = pipey3;
		pipeupy3 = pipey3 - distance;
	}
	
	if(x2x<=-80){
		x2x = 651;
	}
}

//BIRD MOVEMENT
public void BIRD_MOVEMENT(){
	if(orangebird<-37){
		orangebird=-37;
	}
		
	acceleration++;
	if(acceleration==1){
		tm.stop();
		acceleration=0;
		tm.start();
			
		accelerationcount2++;
		if(accelerationcount2==1){
			orangebird=orangebird-5;
		}
		if(accelerationcount2==2){
			orangebird=orangebird-7;
		}
		if(accelerationcount2==3){
			orangebird=orangebird-9;
		}
		if(accelerationcount2==4){
			orangebird=orangebird-11;
		}
		if(accelerationcount2==5){
			orangebird=orangebird-13;
		}
		if(accelerationcount2==6){
			orangebird=orangebird-15;
		}
		if(accelerationcount2==7){
			orangebird=orangebird-17;
		}
		if(accelerationcount2==8){
			orangebird=orangebird-19;
		}
		if(accelerationcount2==9){
			orangebird=orangebird-21;
			accelerationcount=0;
		}
			
		accelerationcount++;
		if(accelerationcount<=10){
			orangebird=orangebird+0;
		}
		if(accelerationcount>=11&&accelerationcount<=15){
			orangebird=orangebird+1;
		}
		if(accelerationcount>=16&&accelerationcount<=19){
			orangebird=orangebird+2;
		}
		if(accelerationcount>=20&&accelerationcount<=22){
			orangebird=orangebird+3;
		}
		if(accelerationcount>=23&&accelerationcount<=24){
			orangebird=orangebird+4;
		}
		if(accelerationcount==25){
			orangebird=orangebird+5;
		}
		if(accelerationcount==26){
			orangebird=orangebird+6;
		}
		if(accelerationcount==27){
			orangebird=orangebird+7;
		}
		if(accelerationcount==28){
			orangebird=orangebird+8;
		}
		if(accelerationcount==29){
			orangebird=orangebird+9;
		}
		if(accelerationcount>=30){
			orangebird=orangebird+10;
		}
	}
}

//PIPE ANIMATION
public void PIPE_ANIMATION(){
	pipeupx=pipeupx-floorspeed;
	pipedownx=pipedownx-floorspeed;
		
	pipeupx2=pipeupx2-floorspeed;
	pipedownx2=pipedownx2-floorspeed;
	
	pipeupx3=pipeupx3-floorspeed;
	pipedownx3=pipedownx3-floorspeed;
	
	x2x=x2x-3;
}

//UPDATE HIGHSCORE
public void UPDATE_HIGHSCORE(){
	try{
		st.executeUpdate("update tblscore set Score = '"+ lblscore.getText()+"'");
	}
	catch(Exception error){
		JOptionPane.showMessageDialog(null,error);
	}
}

//HIGHSCORE
public void HIGHSCORE(){
	try{
        res = st.executeQuery("select * from tblscore");
        if(res.next()){
			highscore = res.getString("Score");
        } 
    }
    catch(Exception error){
        JOptionPane.showMessageDialog(null,error);
    }
}

//CONTROL
public void CONTROL(){
	try{
        res = st.executeQuery("select * from tblcontrol");
        if(res.next()){
			control = res.getString("Control");
        } 
    }
    catch(Exception error){
        JOptionPane.showMessageDialog(null,error);
    }
}

public void CONNECT(){
	try{
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbflappybird","root","root");
		st = con.createStatement();
	}
	catch(Exception error){
		System.out.println("error: "+error);
	}
}   

public void FRAME_ICON(){
	try{
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(new File(RP +icnframeicon).getCanonicalPath()));
	}
	catch(Exception error){
		// If Nimbus is not available, you can set the GUI to another look and feel.
	}
}

public static void main(String[]args){
	FlappyBird_Extreme obj = new FlappyBird_Extreme();
	frame.setSize(456,628);
	frame.setTitle("Flappy Bird Extreme");
	frame.setResizable(false);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.add(obj);
}

public void actionPerformed(ActionEvent e){

//PLAYING	
if(pipe==true&&"1".equals(lblpage.getText())){
	//SCORE
	if(orangebirdx==pipedownx||orangebirdx==pipedownx2||orangebirdx==pipedownx3){
		SCORE();
	}
	
	//COLLISION
	COLLISION();
	
	//POWER UP
	POWERUP_X2();
}

//GAME OVER
if(pipe==true&&"2".equals(lblpage.getText())){
	GAME_OVER();
}

	//SPLASH ANIMATION
	time++;
	if(time==50){
		SPLASH_ANIMATION();
	}
	
	//BIRD ANIMATION
	if(splash==false&&time==4){
		BIRD_ANIMATION();
	}
	
	if(birdorangey<235||birdorangey>250){
		velbirdorange=-velbirdorange;
	}
		birdorangey=birdorangey+velbirdorange;
		
	if(orangebird<276||orangebird>286){
		velorangebird=-velorangebird;
	}
		orangebird=orangebird+velorangebird;
		
	//FLOOR ANIMATION
	floorx=floorx-floorspeed;
	floor2x=floor2x-floorspeed;
	if(floorx<=-489){
		floorx=489;
	}
	if(floor2x<=-489){
		floor2x=489;
	}	
	
	//PIPE RANDOM
	PIPE_RANDOM();
	
	if((getready==false&&pipe==true)||(getready==false&&character==true)){
		//BIRD MOVEMENT
		BIRD_MOVEMENT();
		
		//PIPE ANIMATION
		PIPE_ANIMATION();
	}
}
}
