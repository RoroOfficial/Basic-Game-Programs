import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.io.*;
import java.awt.Image.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Toolkit;

public class tictactoe extends JPanel implements ActionListener, KeyListener{
	static JFrame frame = new JFrame();
	Timer tm = new Timer(10, this);
	static int velx=0,vely=0, velticx=1, veltoex=1;
	static int tx=50,ty=-97;
	static int px=95,py=600;
	static int ax=95,ay=600;
	static int ex=95,ey=600;
	static int xx=0,xy=0;
	static int ox=395,oy=420;
	static int arx=-59,ary=200;
	static int p1x=-230,p1y=25, p2x=220,p2y=25;
	static int ticx=0,tacx=190,toex=390;
	static int turn1x=5, turn2x=220;
	int rxx1, rxy2, rox1, roy2, rtoss, con;
	int counter=395, counter2=2, count=0, score, sec;
	static int counts;
	String p1, p2;
	boolean menu=true;
	boolean playerone=true, playertwo=true, life=true, banner=true, game=true;
	Random rndxx1=new Random();
	Random rndxy2=new Random();
	Random rndox1=new Random();
	Random rndoy2=new Random();
	Random rndtoss=new Random();
	ImageIcon myicons[]=new ImageIcon[4];
	static JLabel lblkey, lbltoss, lblplayerone, lblplayertwo, lblp1, lblp2, lblturn;
	static JTextField txtplayerone, txtplayertwo;
	static JButton btnclick, btntoss, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnreset;
public tictactoe(){
	tm.start();
	setLayout(null);
	this.requestFocus();
	addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
	setBackground(Color.BLACK);

	myicons[0]=new ImageIcon("image/not.gif");
	myicons[1]=new ImageIcon("image/cross.gif");
	myicons[2]=new ImageIcon("image/reset.png");

	lblkey=new JLabel("0");
	lblkey.setBounds(0,0,10,10);
	lblkey.setVisible(false);
	add(lblkey);

	txtplayerone=new JTextField("Player 1");
	txtplayerone.setBounds(115,150,219,36);
	txtplayerone.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,36));
	txtplayerone.setBackground(Color.GREEN);
	txtplayerone.setHorizontalAlignment(JTextField.CENTER);
	txtplayerone.setVisible(false);
	add(txtplayerone);

	txtplayertwo=new JTextField("Player 2");
	txtplayertwo.setBounds(115,150,219,36);
	txtplayertwo.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,36));
	txtplayertwo.setBackground(Color.RED);
	txtplayertwo.setHorizontalAlignment(JTextField.CENTER);
	txtplayertwo.setVisible(false);
	add(txtplayertwo);

	Icon click = new ImageIcon("image/click.png");
	btnclick=new JButton("");
	btnclick.setBounds(175,200,102,36);
	btnclick.setIcon(click);
	btnclick.setVisible(false);
	btnclick.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count++;
			if(count==1){
				playerone=false;playertwo=true;
				txtplayerone.setVisible(false);txtplayertwo.setVisible(true);
			}
			if(count==2){
				playertwo=false;
				txtplayertwo.setVisible(false);
				btnclick.setVisible(false);
				p1=txtplayerone.getText();
				lblplayerone.setText("Player 1: "+p1);
				lblplayerone.setVisible(true);
				p2=txtplayertwo.getText();
				lblplayertwo.setText("Player 2: "+p2);
				lblplayertwo.setVisible(true);
				game=true;
				btn1.setVisible(true);btn2.setVisible(true);btn3.setVisible(true);btn4.setVisible(true);btn5.setVisible(true);btn6.setVisible(true);btn7.setVisible(true);btn8.setVisible(true);btn9.setVisible(true);
				lblkey.setText("1");btnreset.setVisible(true);
			}
		}
	}
	);
	add(btnclick);

	lblplayerone=new JLabel("");
	lblplayerone.setBounds(10,0,210,12);
	lblplayerone.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,12));
	lblplayerone.setVisible(false);
	lblplayerone.setForeground(Color.green);
	lblplayerone.setHorizontalAlignment(JTextField.CENTER);
	add(lblplayerone);

	lblplayertwo=new JLabel("");
	lblplayertwo.setBounds(215,0,210,12);
	lblplayertwo.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,12));
	lblplayertwo.setVisible(false);
	lblplayertwo.setForeground(Color.red);
	lblplayertwo.setHorizontalAlignment(JTextField.CENTER);
	add(lblplayertwo);

	//tira
	final Icon cross = new ImageIcon("image/cross.gif");
	final Icon not = new ImageIcon("image/not.gif");
	btn1=new JButton("");
	btn1.setBackground(Color.black);
	btn1.setBounds(60,80,100,100);
	btn1.setVisible(false);
	btn1.addActionListener(this);
	add(btn1);

	btn2=new JButton("");
	btn2.setBackground(Color.black);
	btn2.setBounds(170,80,100,100);
	btn2.setVisible(false);
	btn2.addActionListener(this);
	add(btn2);

	btn3=new JButton("");
	btn3.setBackground(Color.black);
	btn3.setBounds(280,80,100,100);
	btn3.setVisible(false);
	btn3.addActionListener(this);
	add(btn3);

	btn4=new JButton("");
	btn4.setBackground(Color.black);
	btn4.setBounds(60,190,100,100);
	btn4.setVisible(false);
	btn4.addActionListener(this);
	add(btn4);

	btn5=new JButton("");
	btn5.setBackground(Color.black);
	btn5.setBounds(170,190,100,100);
	btn5.setVisible(false);
	btn5.addActionListener(this);
	add(btn5);

	btn6=new JButton("");
	btn6.setBackground(Color.black);
	btn6.setBounds(280,190,100,100);
	btn6.setVisible(false);
	btn6.addActionListener(this);
	add(btn6);

	btn7=new JButton("");
	btn7.setBackground(Color.black);
	btn7.setBounds(60,300,100,100);
	btn7.setVisible(false);
	btn7.addActionListener(this);
	add(btn7);

	btn8=new JButton("");
	btn8.setBackground(Color.black);
	btn8.setBounds(170,300,100,100);
	btn8.setVisible(false);
	btn8.addActionListener(this);
	add(btn8);

	btn9=new JButton("");
	btn9.setBackground(Color.black);
	btn9.setBounds(280,300,100,100);
	btn9.setVisible(false);
	btn9.addActionListener(this);
	add(btn9);

	btnreset=new JButton("Reset");
	btnreset.setBackground(Color.yellow);
	btnreset.setForeground(Color.black);
	btnreset.setBounds(160,420,100,20);
	btnreset.setVisible(false);
	btnreset.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);
		btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);btn7.setEnabled(true);btn8.setEnabled(true);btn9.setEnabled(true);
		}
	}
	);
	add(btnreset);

	playerone=false;playertwo=false;game=false;
}
public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	Image background = Toolkit.getDefaultToolkit().getImage("image/title.png");
	Image play = Toolkit.getDefaultToolkit().getImage("image/play.png");
	Image about = Toolkit.getDefaultToolkit().getImage("image/about.png");
	Image exit = Toolkit.getDefaultToolkit().getImage("image/exit.png");
	Image x = Toolkit.getDefaultToolkit().getImage("image/x.png");
	Image o = Toolkit.getDefaultToolkit().getImage("image/o.png");
	Image arrow = Toolkit.getDefaultToolkit().getImage("image/arrow.png");
	Image player1 = Toolkit.getDefaultToolkit().getImage("image/player1.png");
	Image player2 = Toolkit.getDefaultToolkit().getImage("image/player2.png");
	Image toss = Toolkit.getDefaultToolkit().getImage("image/toss.png");
	Image player1life = Toolkit.getDefaultToolkit().getImage("image/p1life.png");
	Image player2life = Toolkit.getDefaultToolkit().getImage("image/p2life.png");
	Image tic = Toolkit.getDefaultToolkit().getImage("image/ticbanner.png");
	Image tac = Toolkit.getDefaultToolkit().getImage("image/tacbanner.png");
	Image toe = Toolkit.getDefaultToolkit().getImage("image/toebanner.png");
	Image ttt = Toolkit.getDefaultToolkit().getImage("image/tictactoe.png");
	Image turn = Toolkit.getDefaultToolkit().getImage("image/turn.png");
	g2.drawImage(x, xx, xy ,this);
	g2.drawImage(o, ox, oy ,this);
	if(menu==true){
	g2.drawImage(background, tx, ty ,this);
	g2.drawImage(arrow, arx, ary ,this);
	g2.drawImage(play, px, py ,this);
	g2.drawImage(about, ax, ay ,this);
	g2.drawImage(exit, ex, ey ,this);
	}
	if(playerone==true){
	g2.drawImage(player1, 115, 100 ,this);
	}
	if(playertwo==true){
	g2.drawImage(player2, 115, 100 ,this);
	}
	if(game==true){
	g2.drawImage(player2life, p1x, p1y ,this);
	g2.drawImage(player1life, p2x, p2y ,this);
	g2.drawImage(tic, ticx, 450 ,this);
	g2.drawImage(tac, tacx, 450 ,this);
	g2.drawImage(toe, toex, 450 ,this);
	g2.drawImage(ttt, 50, 70 ,this);
	g2.drawImage(turn, turn1x, 5 ,this);
	}
	//g2.finalize();
	repaint();
}
public void keyPressed(KeyEvent e){
if(lblkey.getText()=="0"){
	int c=e.getKeyCode();

    if(c==KeyEvent.VK_S){
		vely=+40;
    }
    if(c==KeyEvent.VK_W){
        vely=-40;
    }
    if(c==KeyEvent.VK_ENTER){
		if(arx==59&&ary==200){
			menu=false;
			playerone=true;
			txtplayerone.setVisible(true);
			btnclick.setVisible(true);
		}
		if(arx==59&&ary==280){
			int con = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","",JOptionPane.YES_NO_OPTION);
			if(con == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	}
}
if(lblkey.getText()=="1"){
	int c=e.getKeyCode();

    if(c==KeyEvent.VK_ESCAPE){
		menu=true;game=false;
		lblplayerone.setVisible(false);lblplayertwo.setVisible(false);
		btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);btn7.setVisible(false);btn8.setVisible(false);btn9.setVisible(false);
		lblkey.setText("0");
    }
}
}

public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e){
}
public static void main(String[] args)throws IOException
{
	tictactoe obj = new tictactoe();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(450,500);
	frame.setLocation(400,50);
	frame.setResizable(false);
	frame.setTitle("Tic-Tac-Toe");
	frame.setVisible(true);
	frame.add(obj);
}
public void actionPerformed(ActionEvent e)
{
	rxx1=rndxx1.nextInt(counter)+count;
	rxy2=rndxy2.nextInt(counter)+count;
	rox1=rndox1.nextInt(counter)+count;
	roy2=rndoy2.nextInt(counter)+count;
	xx=rxx1;
	xy=rxy2;
	ox=rox1;
	oy=roy2;
	//title
	ty=ty+2;
	if(ty>50)
	{
		ty=50;
	}
	py=py-6;
	if(py<200)
	{
		py=200;
		ay=ay-6;
		if(ay<240)
		{
			ay=240;
			ey=ey-6;
			if(ey<280)
			{
				ey=280;
				arx=arx+4;
				if(arx>59)
				{
					arx=59;
				}
			}
		}
	}
	if(ary<200)
	{
		ary=200;
		vely=0;
	}
	if(ary>280)
	{
		ary=280;
		vely=0;
	}
	ary=ary+vely;

	if(ticx<0||ticx>130){
		velticx=-velticx;
	}
		ticx=ticx+velticx;
	if(toex<260||toex>390){
		veltoex=-veltoex;
	}
		toex=toex+veltoex;
	//play
if(turn1x==5){
	if(e.getSource()==btn1){
		btn1.setIcon(myicons[0]);btn1.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn2){
		btn2.setIcon(myicons[0]);btn2.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn3){
		btn3.setIcon(myicons[0]);btn3.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn4){
		btn4.setIcon(myicons[0]);btn4.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn5){
		btn5.setIcon(myicons[0]);btn5.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn6){
		btn6.setIcon(myicons[0]);btn6.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn7){
		btn7.setIcon(myicons[0]);btn7.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn8){
		btn8.setIcon(myicons[0]);btn8.setEnabled(false);
		turn1x=220;
	}
	if(e.getSource()==btn9){
		btn9.setIcon(myicons[0]);btn9.setEnabled(false);
		turn1x=220;
	}
}
else if(turn1x==220){
	if(e.getSource()==btn1){
		btn1.setIcon(myicons[1]);btn1.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn2){
		btn2.setIcon(myicons[1]);btn2.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn3){
		btn3.setIcon(myicons[1]);btn3.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn4){
		btn4.setIcon(myicons[1]);btn4.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn5){
		btn5.setIcon(myicons[1]);btn5.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn6){
		btn6.setIcon(myicons[1]);btn6.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn7){
		btn7.setIcon(myicons[1]);btn7.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn8){
		btn8.setIcon(myicons[1]);btn8.setEnabled(false);
		turn1x=5;
	}
	if(e.getSource()==btn9){
		btn9.setIcon(myicons[1]);btn9.setEnabled(false);
		turn1x=5;
	}
	//O Win
	if((btn1.getIcon()==myicons[0]&&btn2.getIcon()==myicons[0]&&btn3.getIcon()==myicons[0])||(btn4.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0]&&btn6.getIcon()==myicons[0])||(btn7.getIcon()==myicons[0]&&btn8.getIcon()==myicons[0]&&btn9.getIcon()==myicons[0])||(btn1.getIcon()==myicons[0]&&btn4.getIcon()==myicons[0]&&btn7.getIcon()==myicons[0])||(btn2.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0]&&btn8.getIcon()==myicons[0])||(btn3.getIcon()==myicons[0]&&btn6.getIcon()==myicons[0]&&btn9.getIcon()==myicons[0])||(btn1.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0]&&btn9.getIcon()==myicons[0])||(btn3.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0]&&btn7.getIcon()==myicons[0])){
		JOptionPane.showMessageDialog(null,"Player 1 Won!");
		btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);
		btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);btn7.setEnabled(true);btn8.setEnabled(true);btn9.setEnabled(true);
		turn1x=5;
		p1x=p1x+20;p2x=p2x+20;
		if(p1x==0){
			JOptionPane.showMessageDialog(null,"Game Over\n Player 1:  "+p1+"  Won!");
		}
	}
	//X Win
	if((btn1.getIcon()==myicons[1]&&btn2.getIcon()==myicons[1]&&btn3.getIcon()==myicons[1])||(btn4.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1]&&btn6.getIcon()==myicons[1])||(btn7.getIcon()==myicons[1]&&btn8.getIcon()==myicons[1]&&btn9.getIcon()==myicons[1])||(btn1.getIcon()==myicons[1]&&btn4.getIcon()==myicons[1]&&btn7.getIcon()==myicons[1])||(btn2.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1]&&btn8.getIcon()==myicons[1])||(btn3.getIcon()==myicons[1]&&btn6.getIcon()==myicons[1]&&btn9.getIcon()==myicons[1])||(btn1.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1]&&btn9.getIcon()==myicons[1])||(btn3.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1]&&btn7.getIcon()==myicons[1])){
		JOptionPane.showMessageDialog(null,"Player 2 Won!");
		btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);
		btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);btn7.setEnabled(true);btn8.setEnabled(true);btn9.setEnabled(true);
		turn1x=220;
		p1x=p1x-20;p2x=p2x-20;
		if(p2x==0){
			JOptionPane.showMessageDialog(null,"Game Over\n Player 2:  "+p2+"  Won!");
		}
	}
}
}
}
