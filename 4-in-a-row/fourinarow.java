import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.io.*;
import java.awt.Image.*;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class fourinarow extends JPanel implements ActionListener{
	static JFrame frame = new JFrame();
	Timer tm = new Timer(10, this);
	ImageIcon myicons[]=new ImageIcon[4];
	static JButton btnplay, btnabout, btnexit, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btni, btnj, btnk, btnl, btnm, btnn, btno, btnp, btnq, btnr, btns, btnt, btnu, btnv, btnw, btnx, btny, btnz, btndel, btnenter, btnback;
	static JLabel lblp1, lblp2, lblplayer1, lblplayer2, lblpage, lbls1, lbls2, lblred, lblyellow;
	static JTextField txtp1, txtp2;
	boolean bg=true, maingame=true;
	static int turnx=5;
	int del, del2, count, score1, score2;
	int red=21, yellow=21;
	String chr="", chr2="", p1, p2;
public fourinarow(){
	tm.start();
	setLayout(null);
	setBackground(Color.BLUE);

	myicons[0]=new ImageIcon("image/redstar.png");
	myicons[1]=new ImageIcon("image/yellowstar.png");
	myicons[2]=new ImageIcon("image/reset.png");

	lblpage=new JLabel("0");
	lblpage.setBounds(0,0,50,50);
	lblpage.setVisible(false);
	add(lblpage);

	Icon play = new ImageIcon("image/play.png");
	Icon about = new ImageIcon("image/about.png");
	Icon exit = new ImageIcon("image/exit.png");
	btnplay=new JButton("");
	btnplay.setBounds(120,200,250,50);
	btnplay.setIcon(play);
	btnplay.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			bg=false;
			btnplay.setVisible(false);btnabout.setVisible(false);btnexit.setVisible(false);
			p1();keyboard();
			lblpage.setText("1");
		}
	}
	);
	add(btnplay);

	btnabout=new JButton("");
	btnabout.setBounds(120,260,250,50);
	btnabout.setIcon(about);
	btnabout.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"                                                      4 in a Row\n Make 4 star straight vertically, horizontally, slash style, or backslash style.");
		}
	}
	);
	add(btnabout);

	btnexit=new JButton("");
	btnexit.setBounds(120,320,250,50);
	btnexit.setIcon(exit);
	btnexit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int con = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","",JOptionPane.YES_NO_OPTION);
			if(con == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	}
	);
	add(btnexit);

	maingame=false;
}
public void p1(){
	lblp1=new JLabel("Player 1");
	lblp1.setBounds(160,50,300,50);
	lblp1.setFont(new Font("Rockwell Extra Bold",Font.BOLD,30));
	lblp1.setForeground(Color.red);
	add(lblp1);

	txtp1=new JTextField("");
	txtp1.setBounds(50,100,400,30);
	txtp1.setFont(new Font("Rockwell Extra Bold",Font.BOLD,30));
	txtp1.setHorizontalAlignment(JTextField.CENTER);
	txtp1.setEditable(false);
	txtp1.setForeground(Color.red);
	txtp1.setBackground(Color.gray);
	add(txtp1);
}
public void p2(){
	lblp2=new JLabel("Player 2");
	lblp2.setBounds(160,50,300,50);
	lblp2.setFont(new Font("Rockwell Extra Bold",Font.BOLD,30));
	lblp2.setForeground(Color.yellow);
	add(lblp2);

	txtp2=new JTextField("");
	txtp2.setBounds(50,100,400,30);
	txtp2.setFont(new Font("Rockwell Extra Bold",Font.BOLD,30));
	txtp2.setHorizontalAlignment(JTextField.CENTER);
	txtp2.setEditable(false);
	txtp2.setForeground(Color.yellow);
	txtp2.setBackground(Color.gray);
	add(txtp2);
}
public void name(){
	lblplayer1=new JLabel("");
	lblplayer1.setBounds(5,0,200,20);
	lblplayer1.setFont(new Font("Rockwell Extra Bold",Font.BOLD,17));
	lblplayer1.setHorizontalAlignment(JTextField.LEFT);
	lblplayer1.setForeground(Color.red);
	add(lblplayer1);

	lblplayer2=new JLabel("");
	lblplayer2.setBounds(290,0,200,20);
	lblplayer2.setFont(new Font("Rockwell Extra Bold",Font.BOLD,17));
	lblplayer2.setHorizontalAlignment(JTextField.RIGHT);
	lblplayer2.setForeground(Color.yellow);
	add(lblplayer2);

	lbls1=new JLabel("0");
	lbls1.setBounds(173,42,50,34);
	lbls1.setFont(new Font("Rockwell Extra Bold",Font.BOLD,31));
	lbls1.setHorizontalAlignment(JTextField.CENTER);
	lbls1.setForeground(Color.red);
	add(lbls1);

	lbls2=new JLabel("0");
	lbls2.setBounds(278,42,50,34);
	lbls2.setFont(new Font("Rockwell Extra Bold",Font.BOLD,31));
	lbls2.setHorizontalAlignment(JTextField.CENTER);
	lbls2.setForeground(Color.yellow);
	add(lbls2);

	lblred=new JLabel("21");
	lblred.setBounds(12,48,50,28);
	lblred.setFont(new Font("Rockwell Extra Bold",Font.BOLD,25));
	lblred.setForeground(Color.blue);
	add(lblred);

	lblyellow=new JLabel("21");
	lblyellow.setBounds(453,48,50,28);
	lblyellow.setFont(new Font("Rockwell Extra Bold",Font.BOLD,25));
	lblyellow.setForeground(Color.blue);
	add(lblyellow);

	Icon back = new ImageIcon("image/back.png");
	btnback=new JButton(back);
	btnback.setBounds(320,500,174,22);
	btnback.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int back = JOptionPane.showConfirmDialog(null, "Game will reset, Are you sure you want to go back to main menu?","",JOptionPane.YES_NO_OPTION);
			if(back == JOptionPane.YES_OPTION)
			{
				btnplay.setVisible(true);btnabout.setVisible(true);btnexit.setVisible(true);lbls1.setVisible(false);lbls2.setVisible(false);lblplayer1.setVisible(false);lblplayer2.setVisible(false);btnback.setVisible(false);btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);btn7.setVisible(false);btn8.setVisible(false);btn9.setVisible(false);btn10.setVisible(false);btnk.setVisible(false);btn11.setVisible(false);btn12.setVisible(false);btn13.setVisible(false);btn14.setVisible(false);btn15.setVisible(false);btn16.setVisible(false);btn17.setVisible(false);btn18.setVisible(false);btn19.setVisible(false);btn20.setVisible(false);btn21.setVisible(false);btn22.setVisible(false);btn23.setVisible(false);btn24.setVisible(false);btn25.setVisible(false);btn26.setVisible(false);btn27.setVisible(false);btn28.setVisible(false);btn29.setVisible(false);btn30.setVisible(false);btn31.setVisible(false);btn32.setVisible(false);btn33.setVisible(false);btn34.setVisible(false);btn35.setVisible(false);btn36.setVisible(false);btn37.setVisible(false);btn38.setVisible(false);btn39.setVisible(false);btn40.setVisible(false);btn41.setVisible(false);btn42.setVisible(false);
				lblpage.setText("0");
				bg=true;maingame=false;
				count=0;
				chr="";chr2="";txtp1.setText("");txtp2.setText("");
			}
			
		}
	}
	);
	add(btnback);
}
public void keyboard(){
	//1st row
	Icon q = new ImageIcon("image/q.png");
	btnq=new JButton(q);
	btnq.setBounds(40,200,39,30);
	btnq.addActionListener(this);
	add(btnq);

	Icon w = new ImageIcon("image/w.png");
	btnw=new JButton(w);
	btnw.setBounds(82,200,39,30);
	btnw.addActionListener(this);
	add(btnw);

	Icon e = new ImageIcon("image/e.png");
	btne=new JButton(e);
	btne.setBounds(124,200,39,30);
	btne.addActionListener(this);
	add(btne);

	Icon r = new ImageIcon("image/r.png");
	btnr=new JButton(r);
	btnr.setBounds(166,200,39,30);
	btnr.addActionListener(this);
	add(btnr);

	Icon t = new ImageIcon("image/t.png");
	btnt=new JButton(t);
	btnt.setBounds(208,200,39,30);
	btnt.addActionListener(this);
	add(btnt);

	Icon y = new ImageIcon("image/y.png");
	btny=new JButton(y);
	btny.setBounds(250,200,39,30);
	btny.addActionListener(this);
	add(btny);

	Icon u = new ImageIcon("image/u.png");
	btnu=new JButton(u);
	btnu.setBounds(292,200,39,30);
	btnu.addActionListener(this);
	add(btnu);

	Icon i = new ImageIcon("image/i.png");
	btni=new JButton(i);
	btni.setBounds(334,200,39,30);
	btni.addActionListener(this);
	add(btni);

	Icon o = new ImageIcon("image/o.png");
	btno=new JButton(o);
	btno.setBounds(376,200,39,30);
	btno.addActionListener(this);
	add(btno);

	Icon p = new ImageIcon("image/p.png");
	btnp=new JButton(p);
	btnp.setBounds(418,200,39,30);
	btnp.addActionListener(this);
	add(btnp);
	//2nd row
	Icon a = new ImageIcon("image/a.png");
	btna=new JButton(a);
	btna.setBounds(61,233,39,30);
	btna.addActionListener(this);
	add(btna);

	Icon s = new ImageIcon("image/s.png");
	btns=new JButton(s);
	btns.setBounds(103,233,39,30);
	btns.addActionListener(this);
	add(btns);

	Icon d = new ImageIcon("image/d.png");
	btnd=new JButton(d);
	btnd.setBounds(145,233,39,30);
	btnd.addActionListener(this);
	add(btnd);

	Icon f = new ImageIcon("image/f.png");
	btnf=new JButton(f);
	btnf.setBounds(187,233,39,30);
	btnf.addActionListener(this);
	add(btnf);

	Icon g = new ImageIcon("image/g.png");
	btng=new JButton(g);
	btng.setBounds(229,233,39,30);
	btng.addActionListener(this);
	add(btng);

	Icon h = new ImageIcon("image/h.png");
	btnh=new JButton(h);
	btnh.setBounds(271,233,39,30);
	btnh.addActionListener(this);
	add(btnh);

	Icon j = new ImageIcon("image/j.png");
	btnj=new JButton(j);
	btnj.setBounds(313,233,39,30);
	btnj.addActionListener(this);
	add(btnj);

	Icon k = new ImageIcon("image/k.png");
	btnk=new JButton(k);
	btnk.setBounds(355,233,39,30);
	btnk.addActionListener(this);
	add(btnk);

	Icon l = new ImageIcon("image/l.png");
	btnl=new JButton(l);
	btnl.setBounds(397,233,39,30);
	btnl.addActionListener(this);
	add(btnl);
	//3rd row
	Icon z = new ImageIcon("image/z.png");
	btnz=new JButton(z);
	btnz.setBounds(82,266,39,30);
	btnz.addActionListener(this);
	add(btnz);

	Icon x = new ImageIcon("image/x.png");
	btnx=new JButton(x);
	btnx.setBounds(124,266,39,30);
	btnx.addActionListener(this);
	add(btnx);

	Icon c = new ImageIcon("image/c.png");
	btnc=new JButton(c);
	btnc.setBounds(166,266,39,30);
	btnc.addActionListener(this);
	add(btnc);

	Icon v = new ImageIcon("image/v.png");
	btnv=new JButton(v);
	btnv.setBounds(208,266,39,30);
	btnv.addActionListener(this);
	add(btnv);

	Icon b = new ImageIcon("image/b.png");
	btnb=new JButton(b);
	btnb.setBounds(250,266,39,30);
	btnb.addActionListener(this);
	add(btnb);

	Icon n = new ImageIcon("image/n.png");
	btnn=new JButton(n);
	btnn.setBounds(292,266,39,30);
	btnn.addActionListener(this);
	add(btnn);

	Icon m = new ImageIcon("image/m.png");
	btnm=new JButton(m);
	btnm.setBounds(334,266,39,30);
	btnm.addActionListener(this);
	add(btnm);

	Icon del = new ImageIcon("image/del.png");
	btndel=new JButton(del);
	btndel.setBounds(376,266,39,30);
	btndel.setEnabled(false);
	btndel.addActionListener(this);
	add(btndel);
	//4th row
	Icon enter = new ImageIcon("image/enter.png");
	btnenter=new JButton(enter);
	btnenter.setBounds(199,299,102,30);
	btnenter.setEnabled(false);
	btnenter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count++;
			if(count==1){
				p2();lblp1.setVisible(false);txtp1.setVisible(false);lblpage.setText("2");btndel.setEnabled(false);btnenter.setEnabled(false);
			}
			if(count==2){
				lblp2.setVisible(false);txtp2.setVisible(false);
				maingame=true;
				board();name();
				p1=txtp1.getText();
				lblplayer1.setText(p1);
				p2=txtp2.getText();
				lblplayer2.setText(p2);
				btna.setVisible(false);btnb.setVisible(false);btnc.setVisible(false);btnd.setVisible(false);btne.setVisible(false);btnf.setVisible(false);btng.setVisible(false);btnh.setVisible(false);btni.setVisible(false);btnj.setVisible(false);btnk.setVisible(false);btnl.setVisible(false);btnm.setVisible(false);btnn.setVisible(false);btno.setVisible(false);btnp.setVisible(false);btnq.setVisible(false);btnr.setVisible(false);btns.setVisible(false);btnt.setVisible(false);btnu.setVisible(false);btnv.setVisible(false);btnw.setVisible(false);btnx.setVisible(false);btny.setVisible(false);btnz.setVisible(false);btnenter.setVisible(false);btndel.setVisible(false);
			}
		}
	}
	);
	add(btnenter);
}
public void board(){
	btn1=new JButton("");
	btn1.setBounds(50,420,30,30);
	btn1.setBackground(Color.black);
	btn1.addActionListener(this);
	add(btn1);

	btn2=new JButton("");
	btn2.setBounds(110,420,30,30);
	btn2.setBackground(Color.black);
	btn2.addActionListener(this);
	add(btn2);

	btn3=new JButton("");
	btn3.setBounds(170,420,30,30);
	btn3.setBackground(Color.black);
	btn3.addActionListener(this);
	add(btn3);

	btn4=new JButton("");
	btn4.setBounds(230,420,30,30);
	btn4.setBackground(Color.black);
	btn4.addActionListener(this);
	add(btn4);

	btn5=new JButton("");
	btn5.setBounds(290,420,30,30);
	btn5.setBackground(Color.black);
	btn5.addActionListener(this);
	add(btn5);

	btn6=new JButton("");
	btn6.setBounds(350,420,30,30);
	btn6.setBackground(Color.black);
	btn6.addActionListener(this);
	add(btn6);

	btn7=new JButton("");
	btn7.setBounds(410,420,30,30);
	btn7.setBackground(Color.black);
	btn7.addActionListener(this);
	add(btn7);

	btn8=new JButton("");
	btn8.setBounds(50,360,30,30);
	btn8.setBackground(Color.black);
	btn8.addActionListener(this);
	btn8.setEnabled(false);
	add(btn8);

	btn9=new JButton("");
	btn9.setBounds(110,360,30,30);
	btn9.setBackground(Color.black);
	btn9.addActionListener(this);
	btn9.setEnabled(false);
	add(btn9);

	btn10=new JButton("");
	btn10.setBounds(170,360,30,30);
	btn10.setBackground(Color.black);
	btn10.addActionListener(this);
	btn10.setEnabled(false);
	add(btn10);

	btn11=new JButton("");
	btn11.setBounds(230,360,30,30);
	btn11.setBackground(Color.black);
	btn11.addActionListener(this);
	btn11.setEnabled(false);
	add(btn11);

	btn12=new JButton("");
	btn12.setBounds(290,360,30,30);
	btn12.setBackground(Color.black);
	btn12.addActionListener(this);
	btn12.setEnabled(false);
	add(btn12);

	btn13=new JButton("");
	btn13.setBounds(350,360,30,30);
	btn13.setBackground(Color.black);
	btn13.addActionListener(this);
	btn13.setEnabled(false);
	add(btn13);

	btn14=new JButton("");
	btn14.setBounds(410,360,30,30);
	btn14.setBackground(Color.black);
	btn14.addActionListener(this);
	btn14.setEnabled(false);
	add(btn14);

	btn15=new JButton("");
	btn15.setBounds(50,300,30,30);
	btn15.setBackground(Color.black);
	btn15.addActionListener(this);
	btn15.setEnabled(false);
	add(btn15);

	btn16=new JButton("");
	btn16.setBounds(110,300,30,30);
	btn16.setBackground(Color.black);
	btn16.addActionListener(this);
	btn16.setEnabled(false);
	add(btn16);

	btn17=new JButton("");
	btn17.setBounds(170,300,30,30);
	btn17.setBackground(Color.black);
	btn17.addActionListener(this);
	btn17.setEnabled(false);
	add(btn17);

	btn18=new JButton("");
	btn18.setBounds(230,300,30,30);
	btn18.setBackground(Color.black);
	btn18.addActionListener(this);
	btn18.setEnabled(false);
	add(btn18);

	btn19=new JButton("");
	btn19.setBounds(290,300,30,30);
	btn19.setBackground(Color.black);
	btn19.addActionListener(this);
	btn19.setEnabled(false);
	add(btn19);

	btn20=new JButton("");
	btn20.setBounds(350,300,30,30);
	btn20.setBackground(Color.black);
	btn20.addActionListener(this);
	btn20.setEnabled(false);
	add(btn20);

	btn21=new JButton("");
	btn21.setBounds(410,300,30,30);
	btn21.setBackground(Color.black);
	btn21.addActionListener(this);
	btn21.setEnabled(false);
	add(btn21);

	btn22=new JButton("");
	btn22.setBounds(50,240,30,30);
	btn22.setBackground(Color.black);
	btn22.addActionListener(this);
	btn22.setEnabled(false);
	add(btn22);

	btn23=new JButton("");
	btn23.setBounds(110,240,30,30);
	btn23.setBackground(Color.black);
	btn23.addActionListener(this);
	btn23.setEnabled(false);
	add(btn23);

	btn24=new JButton("");
	btn24.setBounds(170,240,30,30);
	btn24.setBackground(Color.black);
	btn24.addActionListener(this);
	btn24.setEnabled(false);
	add(btn24);

	btn25=new JButton("");
	btn25.setBounds(230,240,30,30);
	btn25.setBackground(Color.black);
	btn25.addActionListener(this);
	btn25.setEnabled(false);
	add(btn25);

	btn26=new JButton("");
	btn26.setBounds(290,240,30,30);
	btn26.setBackground(Color.black);
	btn26.addActionListener(this);
	btn26.setEnabled(false);
	add(btn26);

	btn27=new JButton("");
	btn27.setBounds(350,240,30,30);
	btn27.setBackground(Color.black);
	btn27.addActionListener(this);
	btn27.setEnabled(false);
	add(btn27);

	btn28=new JButton("");
	btn28.setBounds(410,240,30,30);
	btn28.setBackground(Color.black);
	btn28.addActionListener(this);
	btn28.setEnabled(false);
	add(btn28);

	btn29=new JButton("");
	btn29.setBounds(50,180,30,30);
	btn29.setBackground(Color.black);
	btn29.addActionListener(this);
	btn29.setEnabled(false);
	add(btn29);

	btn30=new JButton("");
	btn30.setBounds(110,180,30,30);
	btn30.setBackground(Color.black);
	btn30.addActionListener(this);
	btn30.setEnabled(false);
	add(btn30);

	btn31=new JButton("");
	btn31.setBounds(170,180,30,30);
	btn31.setBackground(Color.black);
	btn31.addActionListener(this);
	btn31.setEnabled(false);
	add(btn31);

	btn32=new JButton("");
	btn32.setBounds(230,180,30,30);
	btn32.setBackground(Color.black);
	btn32.addActionListener(this);
	btn32.setEnabled(false);
	add(btn32);

	btn33=new JButton("");
	btn33.setBounds(290,180,30,30);
	btn33.setBackground(Color.black);
	btn33.addActionListener(this);
	btn33.setEnabled(false);
	add(btn33);

	btn34=new JButton("");
	btn34.setBounds(350,180,30,30);
	btn34.setBackground(Color.black);
	btn34.addActionListener(this);
	btn34.setEnabled(false);
	add(btn34);

	btn35=new JButton("");
	btn35.setBounds(410,180,30,30);
	btn35.setBackground(Color.black);
	btn35.addActionListener(this);
	btn35.setEnabled(false);
	add(btn35);

	btn36=new JButton("");
	btn36.setBounds(50,120,30,30);
	btn36.setBackground(Color.black);
	btn36.addActionListener(this);
	btn36.setEnabled(false);
	add(btn36);

	btn37=new JButton("");
	btn37.setBounds(110,120,30,30);
	btn37.setBackground(Color.black);
	btn37.addActionListener(this);
	btn37.setEnabled(false);
	add(btn37);

	btn38=new JButton("");
	btn38.setBounds(170,120,30,30);
	btn38.setBackground(Color.black);
	btn38.addActionListener(this);
	btn38.setEnabled(false);
	add(btn38);

	btn39=new JButton("");
	btn39.setBounds(230,120,30,30);
	btn39.setBackground(Color.black);
	btn39.addActionListener(this);
	btn39.setEnabled(false);
	add(btn39);

	btn40=new JButton("");
	btn40.setBounds(290,120,30,30);
	btn40.setBackground(Color.black);
	btn40.addActionListener(this);
	btn40.setEnabled(false);
	add(btn40);

	btn41=new JButton("");
	btn41.setBounds(350,120,30,30);
	btn41.setBackground(Color.black);
	btn41.addActionListener(this);
	btn41.setEnabled(false);
	add(btn41);

	btn42=new JButton("");
	btn42.setBounds(410,120,30,30);
	btn42.setBackground(Color.black);
	btn42.addActionListener(this);
	btn42.setEnabled(false);
	add(btn42);
}
public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	Image background = Toolkit.getDefaultToolkit().getImage("image/background.png");
	Image game = Toolkit.getDefaultToolkit().getImage("image/game.png");
	Image turn = Toolkit.getDefaultToolkit().getImage("image/turn.png");
	Image stats = Toolkit.getDefaultToolkit().getImage("image/stats.png");
	if(bg==true){
	g2.drawImage(background, 45 ,40 ,this);
	}
	if(maingame==true){
	g2.drawImage(game, 30 , 100 ,this);
	g2.drawImage(stats, 0 , 0 ,this);
	g2.drawImage(turn, turnx , 25 ,this);
	g2.finalize();
	}
	repaint();
}
public static void main(String[] args)throws IOException
{
	fourinarow obj = new fourinarow();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,550);
	frame.setLocation(430,50);
	frame.setResizable(false);
	frame.setTitle("4-in-a-Row");
	frame.setVisible(true);
	frame.add(obj);
}
public void actionPerformed(ActionEvent e)
{
//player 1
if(lblpage.getText()=="1"){
if(e.getSource()==btna){
	chr+="a";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}   
else if(e.getSource()==btnb){
	chr+="b";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnc){
	chr+="c";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnd){
	chr+="d";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btne){
	chr+="e";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnf){
	chr+="f";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btng){
	chr+="g";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnh){
	chr+="h";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btni){
	chr+="i";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnj){
	chr+="j";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnk){
	chr+="k";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnl){
	chr+="l";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnm){
	chr+="m";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnn){
	chr+="n";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btno){
	chr+="o";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnp){
	chr+="p";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnq){
	chr+="q";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnr){
	chr+="r";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btns){
	chr+="s";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnt){
	chr+="t";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnu){
	chr+="u";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnv){
	chr+="v";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnw){
	chr+="w";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnx){
	chr+="x";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btny){
	chr+="y";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnz){
	chr+="z";
	txtp1.setText(chr);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btndel){
	chr="";
	txtp1.setText("");btnenter.setEnabled(false);btndel.setEnabled(false);
}
}
//player 2
if(lblpage.getText()=="2"){
if(e.getSource()==btna){
	chr2+="a";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}   
else if(e.getSource()==btnb){
	chr2+="b";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnc){
	chr2+="c";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnd){
	chr2+="d";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btne){
	chr2+="e";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnf){
	chr2+="f";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btng){
	chr2+="g";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnh){
	chr2+="h";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btni){
	chr2+="i";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnj){
	chr2+="j";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnk){
	chr2+="k";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnl){
	chr2+="l";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnm){
	chr2+="m";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnn){
	chr2+="n";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btno){
	chr2+="o";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnp){
	chr2+="p";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnq){
	chr2+="q";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnr){
	chr2+="r";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btns){
	chr2+="s";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnt){
	chr2+="t";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnu){
	chr2+="u";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnv){
	chr2+="v";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnw){
	chr2+="w";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnx){
	chr2+="x";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btny){
	chr2+="y";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btnz){
	chr2+="z";
	txtp2.setText(chr2);btnenter.setEnabled(true);btndel.setEnabled(true);
}
else if(e.getSource()==btndel){
	chr2="";
	txtp2.setText("");btnenter.setEnabled(false);btndel.setEnabled(false);
}
}
//play
if(turnx==5){
	//1st row
	if(e.getSource()==btn1){
		btn1.setIcon(myicons[0]);btn8.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn2){
		btn2.setIcon(myicons[0]);btn9.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn3){
		btn3.setIcon(myicons[0]);btn10.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn4){
		btn4.setIcon(myicons[0]);btn11.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn5){
		btn5.setIcon(myicons[0]);btn12.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn6){
		btn6.setIcon(myicons[0]);btn13.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn7){
		btn7.setIcon(myicons[0]);btn14.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	//2nd row
	if(e.getSource()==btn8){
		btn8.setIcon(myicons[0]);btn15.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn9){
		btn9.setIcon(myicons[0]);btn16.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn10){
		btn10.setIcon(myicons[0]);btn17.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn11){
		btn11.setIcon(myicons[0]);btn18.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn12){
		btn12.setIcon(myicons[0]);btn19.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn13){
		btn13.setIcon(myicons[0]);btn20.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn14){
		btn14.setIcon(myicons[0]);btn21.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	//3rd row
	if(e.getSource()==btn15){
		btn15.setIcon(myicons[0]);btn22.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn16){
		btn16.setIcon(myicons[0]);btn23.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn17){
		btn17.setIcon(myicons[0]);btn24.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn18){
		btn18.setIcon(myicons[0]);btn25.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn19){
		btn19.setIcon(myicons[0]);btn26.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn20){
		btn20.setIcon(myicons[0]);btn27.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn21){
		btn21.setIcon(myicons[0]);btn28.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	//4th row
	if(e.getSource()==btn22){
		btn22.setIcon(myicons[0]);btn29.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn23){
		btn23.setIcon(myicons[0]);btn30.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn24){
		btn24.setIcon(myicons[0]);btn31.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn25){
		btn25.setIcon(myicons[0]);btn32.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn26){
		btn26.setIcon(myicons[0]);btn33.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn27){
		btn27.setIcon(myicons[0]);btn34.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn28){
		btn28.setIcon(myicons[0]);btn35.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	//5th row
	if(e.getSource()==btn29){
		btn29.setIcon(myicons[0]);btn36.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn30){
		btn30.setIcon(myicons[0]);btn37.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn31){
		btn31.setIcon(myicons[0]);btn38.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn32){
		btn32.setIcon(myicons[0]);btn39.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn33){
		btn33.setIcon(myicons[0]);btn40.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn34){
		btn34.setIcon(myicons[0]);btn41.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn35){
		btn35.setIcon(myicons[0]);btn42.setEnabled(true);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	//6th row
	if(e.getSource()==btn36){
		btn36.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn37){
		btn37.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn38){
		btn38.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn39){
		btn39.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn40){
		btn40.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn41){
		btn41.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
	if(e.getSource()==btn42){
		btn42.setIcon(myicons[0]);
		turnx=442;red--;lblred.setText(Integer.toString(red));
	}
}
else if(turnx==442){
	//1st row
	if(e.getSource()==btn1){
		btn1.setIcon(myicons[1]);btn8.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn2){
		btn2.setIcon(myicons[1]);btn9.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn3){
		btn3.setIcon(myicons[1]);btn10.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn4){
		btn4.setIcon(myicons[1]);btn11.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn5){
		btn5.setIcon(myicons[1]);btn12.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn6){
		btn6.setIcon(myicons[1]);btn13.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn7){
		btn7.setIcon(myicons[1]);btn14.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	//2nd row
	if(e.getSource()==btn8){
		btn8.setIcon(myicons[1]);btn15.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn9){
		btn9.setIcon(myicons[1]);btn16.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn10){
		btn10.setIcon(myicons[1]);btn17.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn11){
		btn11.setIcon(myicons[1]);btn18.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn12){
		btn12.setIcon(myicons[1]);btn19.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn13){
		btn13.setIcon(myicons[1]);btn20.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn14){
		btn14.setIcon(myicons[1]);btn21.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	//3rd row
	if(e.getSource()==btn15){
		btn15.setIcon(myicons[1]);btn22.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn16){
		btn16.setIcon(myicons[1]);btn23.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn17){
		btn17.setIcon(myicons[1]);btn24.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn18){
		btn18.setIcon(myicons[1]);btn25.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn19){
		btn19.setIcon(myicons[1]);btn26.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn20){
		btn20.setIcon(myicons[1]);btn27.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn21){
		btn21.setIcon(myicons[1]);btn28.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	//4th row
	if(e.getSource()==btn22){
		btn22.setIcon(myicons[1]);btn29.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn23){
		btn23.setIcon(myicons[1]);btn30.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn24){
		btn24.setIcon(myicons[1]);btn31.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn25){
		btn25.setIcon(myicons[1]);btn32.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn26){
		btn26.setIcon(myicons[1]);btn33.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn27){
		btn27.setIcon(myicons[1]);btn34.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn28){
		btn28.setIcon(myicons[1]);btn35.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	//5th row
	if(e.getSource()==btn29){
		btn29.setIcon(myicons[1]);btn36.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn30){
		btn30.setIcon(myicons[1]);btn37.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn31){
		btn31.setIcon(myicons[1]);btn38.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn32){
		btn32.setIcon(myicons[1]);btn39.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn33){
		btn33.setIcon(myicons[1]);btn40.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn34){
		btn34.setIcon(myicons[1]);btn41.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn35){
		btn35.setIcon(myicons[1]);btn42.setEnabled(true);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	//6th row
	if(e.getSource()==btn36){
		btn36.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn37){
		btn37.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn38){
		btn38.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn39){
		btn39.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn40){
		btn40.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn41){
		btn41.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
	if(e.getSource()==btn42){
		btn42.setIcon(myicons[1]);
		turnx=5;yellow--;lblyellow.setText(Integer.toString(yellow));
	}
}
//draw
if(red==0&&yellow==0){
	JOptionPane.showMessageDialog(null,"Game is Draw!","Draw",JOptionPane.INFORMATION_MESSAGE);
	red=21; yellow=21; lblred.setText(Integer.toString(red));	lblyellow.setText(Integer.toString(yellow));
	btn1.setIcon(myicons[2]);	btn10.setIcon(myicons[2]);	btn19.setIcon(myicons[2]);	btn27.setIcon(myicons[2]);	btn35.setIcon(myicons[2]);	btn2.setIcon(myicons[2]);	btn11.setIcon(myicons[2]);	btn20.setIcon(myicons[2]);	btn28.setIcon(myicons[2]);	btn36.setIcon(myicons[2]);	btn3.setIcon(myicons[2]);	btn12.setIcon(myicons[2]);	btn21.setIcon(myicons[2]);	btn29.setIcon(myicons[2]);	btn37.setIcon(myicons[2]);	btn4.setIcon(myicons[2]);	btn13.setIcon(myicons[2]);	btn22.setIcon(myicons[2]);	btn30.setIcon(myicons[2]);	btn38.setIcon(myicons[2]);	
	btn5.setIcon(myicons[2]);	btn14.setIcon(myicons[2]);	btn23.setIcon(myicons[2]);	btn31.setIcon(myicons[2]);	btn39.setIcon(myicons[2]);	btn6.setIcon(myicons[2]);	btn15.setIcon(myicons[2]);	btn24.setIcon(myicons[2]);	btn32.setIcon(myicons[2]);	btn40.setIcon(myicons[2]);	btn7.setIcon(myicons[2]);	btn16.setIcon(myicons[2]);	btn25.setIcon(myicons[2]);	btn33.setIcon(myicons[2]);	btn41.setIcon(myicons[2]);	btn8.setIcon(myicons[2]);	btn17.setIcon(myicons[2]);	btn26.setIcon(myicons[2]);	btn34.setIcon(myicons[2]);	btn42.setIcon(myicons[2]);	
	btn9.setIcon(myicons[2]);	btn18.setIcon(myicons[2]);
	btn8.setEnabled(false);btn14.setEnabled(false);btn20.setEnabled(false);btn26.setEnabled(false);btn32.setEnabled(false);btn38.setEnabled(false);btn9.setEnabled(false);btn15.setEnabled(false);btn21.setEnabled(false);btn27.setEnabled(false);btn33.setEnabled(false);btn39.setEnabled(false);btn10.setEnabled(false);btn16.setEnabled(false);btn22.setEnabled(false);btn28.setEnabled(false);btn34.setEnabled(false);btn40.setEnabled(false);btn11.setEnabled(false);btn17.setEnabled(false);btn23.setEnabled(false);btn29.setEnabled(false);btn35.setEnabled(false);btn41.setEnabled(false);btn12.setEnabled(false);btn18.setEnabled(false);btn24.setEnabled(false);btn30.setEnabled(false);btn36.setEnabled(false);btn42.setEnabled(false);btn13.setEnabled(false);btn19.setEnabled(false);btn25.setEnabled(false);btn31.setEnabled(false);btn37.setEnabled(false);
}
if(lblpage.getText()=="2"){
//red win
if((btn1.getIcon()==myicons[0]&&btn2.getIcon()==myicons[0]&&btn3.getIcon()==myicons[0]&&btn4.getIcon()==myicons[0])||(btn2.getIcon()==myicons[0]&&btn3.getIcon()==myicons[0]&&btn4.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0])||(btn3.getIcon()==myicons[0]&&btn4.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0]&&btn6.getIcon()==myicons[0])||(btn4.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0]&&btn6.getIcon()==myicons[0]&&btn7.getIcon()==myicons[0])||(btn8.getIcon()==myicons[0]&&btn9.getIcon()==myicons[0]&&btn10.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0])||(btn9.getIcon()==myicons[0]&&btn10.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0])||(btn10.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0]&&btn13.getIcon()==myicons[0])||(btn11.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0]&&btn13.getIcon()==myicons[0]&&btn14.getIcon()==myicons[0])||(btn15.getIcon()==myicons[0]&&btn16.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0])||(btn16.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0])||(btn17.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0])||(btn18.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0]&&btn21.getIcon()==myicons[0])||(btn22.getIcon()==myicons[0]&&btn23.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0])||(btn23.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0])||(btn24.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0])||(btn25.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0]&&btn28.getIcon()==myicons[0])||(btn29.getIcon()==myicons[0]&&btn30.getIcon()==myicons[0]&&btn31.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0])||(btn30.getIcon()==myicons[0]&&btn31.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0])||(btn31.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0]&&btn34.getIcon()==myicons[0])||(btn32.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0]&&btn34.getIcon()==myicons[0]&&btn35.getIcon()==myicons[0])||(btn36.getIcon()==myicons[0]&&btn37.getIcon()==myicons[0]&&btn38.getIcon()==myicons[0]&&btn39.getIcon()==myicons[0])||(btn37.getIcon()==myicons[0]&&btn38.getIcon()==myicons[0]&&btn39.getIcon()==myicons[0]&&btn40.getIcon()==myicons[0])||(btn38.getIcon()==myicons[0]&&btn39.getIcon()==myicons[0]&&btn40.getIcon()==myicons[0]&&btn41.getIcon()==myicons[0])||(btn39.getIcon()==myicons[0]&&btn40.getIcon()==myicons[0]&&btn41.getIcon()==myicons[0]&&btn42.getIcon()==myicons[0])||(btn1.getIcon()==myicons[0]&&btn8.getIcon()==myicons[0]&&btn15.getIcon()==myicons[0]&&btn22.getIcon()==myicons[0])||(btn8.getIcon()==myicons[0]&&btn15.getIcon()==myicons[0]&&btn22.getIcon()==myicons[0]&&btn29.getIcon()==myicons[0])||(btn15.getIcon()==myicons[0]&&btn22.getIcon()==myicons[0]&&btn29.getIcon()==myicons[0]&&btn36.getIcon()==myicons[0])||(btn2.getIcon()==myicons[0]&&btn9.getIcon()==myicons[0]&&btn16.getIcon()==myicons[0]&&btn23.getIcon()==myicons[0])||(btn9.getIcon()==myicons[0]&&btn16.getIcon()==myicons[0]&&btn23.getIcon()==myicons[0]&&btn30.getIcon()==myicons[0])||(btn16.getIcon()==myicons[0]&&btn23.getIcon()==myicons[0]&&btn30.getIcon()==myicons[0]&&btn37.getIcon()==myicons[0])||(btn3.getIcon()==myicons[0]&&btn10.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0])||(btn10.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn31.getIcon()==myicons[0])||(btn17.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn31.getIcon()==myicons[0]&&btn38.getIcon()==myicons[0])||(btn4.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0])||(btn11.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0])||(btn18.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0]&&btn39.getIcon()==myicons[0])||(btn5.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0])||(btn12.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0])||(btn19.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0]&&btn40.getIcon()==myicons[0])||(btn6.getIcon()==myicons[0]&&btn13.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0])||(btn13.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0]&&btn34.getIcon()==myicons[0])||(btn20.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0]&&btn34.getIcon()==myicons[0]&&btn41.getIcon()==myicons[0])||(btn7.getIcon()==myicons[0]&&btn14.getIcon()==myicons[0]&&btn21.getIcon()==myicons[0]&&btn28.getIcon()==myicons[0])||(btn14.getIcon()==myicons[0]&&btn21.getIcon()==myicons[0]&&btn28.getIcon()==myicons[0]&&btn35.getIcon()==myicons[0])||(btn21.getIcon()==myicons[0]&&btn28.getIcon()==myicons[0]&&btn35.getIcon()==myicons[0]&&btn42.getIcon()==myicons[0])||(btn1.getIcon()==myicons[0]&&btn9.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0])||(btn9.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0])||(btn17.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0]&&btn41.getIcon()==myicons[0])||(btn2.getIcon()==myicons[0]&&btn10.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0])||(btn10.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn34.getIcon()==myicons[0])||(btn18.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn34.getIcon()==myicons[0]&&btn42.getIcon()==myicons[0])||(btn3.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0])||(btn11.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0]&&btn35.getIcon()==myicons[0])||(btn4.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0]&&btn28.getIcon()==myicons[0])||(btn8.getIcon()==myicons[0]&&btn16.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0])||(btn16.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0]&&btn40.getIcon()==myicons[0])||(btn15.getIcon()==myicons[0]&&btn23.getIcon()==myicons[0]&&btn31.getIcon()==myicons[0]&&btn39.getIcon()==myicons[0])||(btn36.getIcon()==myicons[0]&&btn30.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0])||(btn30.getIcon()==myicons[0]&&btn24.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0])||(btn24.getIcon()==myicons[0]&&btn18.getIcon()==myicons[0]&&btn12.getIcon()==myicons[0]&&btn6.getIcon()==myicons[0])||(btn37.getIcon()==myicons[0]&&btn31.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0])||(btn31.getIcon()==myicons[0]&&btn25.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn13.getIcon()==myicons[0])||(btn25.getIcon()==myicons[0]&&btn19.getIcon()==myicons[0]&&btn13.getIcon()==myicons[0]&&btn7.getIcon()==myicons[0])||(btn38.getIcon()==myicons[0]&&btn32.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0])||(btn32.getIcon()==myicons[0]&&btn26.getIcon()==myicons[0]&&btn20.getIcon()==myicons[0]&&btn14.getIcon()==myicons[0])||(btn39.getIcon()==myicons[0]&&btn33.getIcon()==myicons[0]&&btn27.getIcon()==myicons[0]&&btn21.getIcon()==myicons[0])||(btn29.getIcon()==myicons[0]&&btn23.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0])||(btn23.getIcon()==myicons[0]&&btn17.getIcon()==myicons[0]&&btn11.getIcon()==myicons[0]&&btn5.getIcon()==myicons[0])||(btn22.getIcon()==myicons[0]&&btn16.getIcon()==myicons[0]&&btn10.getIcon()==myicons[0]&&btn4.getIcon()==myicons[0])){

	JOptionPane.showMessageDialog(null,p1+"  is BINGO!");turnx=5;
	btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);btn10.setIcon(myicons[2]);btn11.setIcon(myicons[2]);btn12.setIcon(myicons[2]);btn13.setIcon(myicons[2]);btn14.setIcon(myicons[2]);btn15.setIcon(myicons[2]);btn16.setIcon(myicons[2]);btn17.setIcon(myicons[2]);btn18.setIcon(myicons[2]);btn19.setIcon(myicons[2]);btn20.setIcon(myicons[2]);btn21.setIcon(myicons[2]);btn22.setIcon(myicons[2]);btn23.setIcon(myicons[2]);btn24.setIcon(myicons[2]);btn25.setIcon(myicons[2]);btn26.setIcon(myicons[2]);btn27.setIcon(myicons[2]);btn28.setIcon(myicons[2]);btn29.setIcon(myicons[2]);btn30.setIcon(myicons[2]);btn31.setIcon(myicons[2]);btn32.setIcon(myicons[2]);btn33.setIcon(myicons[2]);btn34.setIcon(myicons[2]);btn35.setIcon(myicons[2]);btn36.setIcon(myicons[2]);btn37.setIcon(myicons[2]);btn38.setIcon(myicons[2]);btn39.setIcon(myicons[2]);btn40.setIcon(myicons[2]);btn41.setIcon(myicons[2]);btn42.setIcon(myicons[2]);btn8.setEnabled(false);btn9.setEnabled(false);btn10.setEnabled(false);btn11.setEnabled(false);btn12.setEnabled(false);btn13.setEnabled(false);btn14.setEnabled(false);btn15.setEnabled(false);btn16.setEnabled(false);btn17.setEnabled(false);btn18.setEnabled(false);btn19.setEnabled(false);btn20.setEnabled(false);btn21.setEnabled(false);btn22.setEnabled(false);btn23.setEnabled(false);btn24.setEnabled(false);btn25.setEnabled(false);btn26.setEnabled(false);btn27.setEnabled(false);btn28.setEnabled(false);btn29.setEnabled(false);btn30.setEnabled(false);btn31.setEnabled(false);btn32.setEnabled(false);btn33.setEnabled(false);btn34.setEnabled(false);btn35.setEnabled(false);btn36.setEnabled(false);btn37.setEnabled(false);btn38.setEnabled(false);btn39.setEnabled(false);btn40.setEnabled(false);btn41.setEnabled(false);btn42.setEnabled(false);
	score1++;lbls1.setText(Integer.toString(score1));
	red=21;yellow=21;lblred.setText("21");lblyellow.setText("21");
}
//yellow win
if((btn1.getIcon()==myicons[1]&&btn2.getIcon()==myicons[1]&&btn3.getIcon()==myicons[1]&&btn4.getIcon()==myicons[1])||(btn2.getIcon()==myicons[1]&&btn3.getIcon()==myicons[1]&&btn4.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1])||(btn3.getIcon()==myicons[1]&&btn4.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1]&&btn6.getIcon()==myicons[1])||(btn4.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1]&&btn6.getIcon()==myicons[1]&&btn7.getIcon()==myicons[1])||(btn8.getIcon()==myicons[1]&&btn9.getIcon()==myicons[1]&&btn10.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1])||(btn9.getIcon()==myicons[1]&&btn10.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1])||(btn10.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1]&&btn13.getIcon()==myicons[1])||(btn11.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1]&&btn13.getIcon()==myicons[1]&&btn14.getIcon()==myicons[1])||(btn15.getIcon()==myicons[1]&&btn16.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1])||(btn16.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1])||(btn17.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1])||(btn18.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1]&&btn21.getIcon()==myicons[1])||(btn22.getIcon()==myicons[1]&&btn23.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1])||(btn23.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1])||(btn24.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1])||(btn25.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1]&&btn28.getIcon()==myicons[1])||(btn29.getIcon()==myicons[1]&&btn30.getIcon()==myicons[1]&&btn31.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1])||(btn30.getIcon()==myicons[1]&&btn31.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1])||(btn31.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1]&&btn34.getIcon()==myicons[1])||(btn32.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1]&&btn34.getIcon()==myicons[1]&&btn35.getIcon()==myicons[1])||(btn36.getIcon()==myicons[1]&&btn37.getIcon()==myicons[1]&&btn38.getIcon()==myicons[1]&&btn39.getIcon()==myicons[1])||(btn37.getIcon()==myicons[1]&&btn38.getIcon()==myicons[1]&&btn39.getIcon()==myicons[1]&&btn40.getIcon()==myicons[1])||(btn38.getIcon()==myicons[1]&&btn39.getIcon()==myicons[1]&&btn40.getIcon()==myicons[1]&&btn41.getIcon()==myicons[1])||(btn39.getIcon()==myicons[1]&&btn40.getIcon()==myicons[1]&&btn41.getIcon()==myicons[1]&&btn42.getIcon()==myicons[1])||(btn1.getIcon()==myicons[1]&&btn8.getIcon()==myicons[1]&&btn15.getIcon()==myicons[1]&&btn22.getIcon()==myicons[1])||(btn8.getIcon()==myicons[1]&&btn15.getIcon()==myicons[1]&&btn22.getIcon()==myicons[1]&&btn29.getIcon()==myicons[1])||(btn15.getIcon()==myicons[1]&&btn22.getIcon()==myicons[1]&&btn29.getIcon()==myicons[1]&&btn36.getIcon()==myicons[1])||(btn2.getIcon()==myicons[1]&&btn9.getIcon()==myicons[1]&&btn16.getIcon()==myicons[1]&&btn23.getIcon()==myicons[1])||(btn9.getIcon()==myicons[1]&&btn16.getIcon()==myicons[1]&&btn23.getIcon()==myicons[1]&&btn30.getIcon()==myicons[1])||(btn16.getIcon()==myicons[1]&&btn23.getIcon()==myicons[1]&&btn30.getIcon()==myicons[1]&&btn37.getIcon()==myicons[1])||(btn3.getIcon()==myicons[1]&&btn10.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1])||(btn10.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn31.getIcon()==myicons[1])||(btn17.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn31.getIcon()==myicons[1]&&btn38.getIcon()==myicons[1])||(btn4.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1])||(btn11.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1])||(btn18.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1]&&btn39.getIcon()==myicons[1])||(btn5.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1])||(btn12.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1])||(btn19.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1]&&btn40.getIcon()==myicons[1])||(btn6.getIcon()==myicons[1]&&btn13.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1])||(btn13.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1]&&btn34.getIcon()==myicons[1])||(btn20.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1]&&btn34.getIcon()==myicons[1]&&btn41.getIcon()==myicons[1])||(btn7.getIcon()==myicons[1]&&btn14.getIcon()==myicons[1]&&btn21.getIcon()==myicons[1]&&btn28.getIcon()==myicons[1])||(btn14.getIcon()==myicons[1]&&btn21.getIcon()==myicons[1]&&btn28.getIcon()==myicons[1]&&btn35.getIcon()==myicons[1])||(btn21.getIcon()==myicons[1]&&btn28.getIcon()==myicons[1]&&btn35.getIcon()==myicons[1]&&btn42.getIcon()==myicons[1])||(btn1.getIcon()==myicons[1]&&btn9.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1])||(btn9.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1])||(btn17.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1]&&btn41.getIcon()==myicons[1])||(btn2.getIcon()==myicons[1]&&btn10.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1])||(btn10.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn34.getIcon()==myicons[1])||(btn18.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn34.getIcon()==myicons[1]&&btn42.getIcon()==myicons[1])||(btn3.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1])||(btn11.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1]&&btn35.getIcon()==myicons[1])||(btn4.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1]&&btn28.getIcon()==myicons[1])||(btn8.getIcon()==myicons[1]&&btn16.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1])||(btn16.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1]&&btn40.getIcon()==myicons[1])||(btn15.getIcon()==myicons[1]&&btn23.getIcon()==myicons[1]&&btn31.getIcon()==myicons[1]&&btn39.getIcon()==myicons[1])||(btn36.getIcon()==myicons[1]&&btn30.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1])||(btn30.getIcon()==myicons[1]&&btn24.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1])||(btn24.getIcon()==myicons[1]&&btn18.getIcon()==myicons[1]&&btn12.getIcon()==myicons[1]&&btn6.getIcon()==myicons[1])||(btn37.getIcon()==myicons[1]&&btn31.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1])||(btn31.getIcon()==myicons[1]&&btn25.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn13.getIcon()==myicons[1])||(btn25.getIcon()==myicons[1]&&btn19.getIcon()==myicons[1]&&btn13.getIcon()==myicons[1]&&btn7.getIcon()==myicons[1])||(btn38.getIcon()==myicons[1]&&btn32.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1])||(btn32.getIcon()==myicons[1]&&btn26.getIcon()==myicons[1]&&btn20.getIcon()==myicons[1]&&btn14.getIcon()==myicons[1])||(btn39.getIcon()==myicons[1]&&btn33.getIcon()==myicons[1]&&btn27.getIcon()==myicons[1]&&btn21.getIcon()==myicons[1])||(btn29.getIcon()==myicons[1]&&btn23.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1])||(btn23.getIcon()==myicons[1]&&btn17.getIcon()==myicons[1]&&btn11.getIcon()==myicons[1]&&btn5.getIcon()==myicons[1])||(btn22.getIcon()==myicons[1]&&btn16.getIcon()==myicons[1]&&btn10.getIcon()==myicons[1]&&btn4.getIcon()==myicons[1])){

	JOptionPane.showMessageDialog(null,p2+"  is BINGO!");turnx=442;
	btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);btn10.setIcon(myicons[2]);btn11.setIcon(myicons[2]);btn12.setIcon(myicons[2]);btn13.setIcon(myicons[2]);btn14.setIcon(myicons[2]);btn15.setIcon(myicons[2]);btn16.setIcon(myicons[2]);btn17.setIcon(myicons[2]);btn18.setIcon(myicons[2]);btn19.setIcon(myicons[2]);btn20.setIcon(myicons[2]);btn21.setIcon(myicons[2]);btn22.setIcon(myicons[2]);btn23.setIcon(myicons[2]);btn24.setIcon(myicons[2]);btn25.setIcon(myicons[2]);btn26.setIcon(myicons[2]);btn27.setIcon(myicons[2]);btn28.setIcon(myicons[2]);btn29.setIcon(myicons[2]);btn30.setIcon(myicons[2]);btn31.setIcon(myicons[2]);btn32.setIcon(myicons[2]);btn33.setIcon(myicons[2]);btn34.setIcon(myicons[2]);btn35.setIcon(myicons[2]);btn36.setIcon(myicons[2]);btn37.setIcon(myicons[2]);btn38.setIcon(myicons[2]);btn39.setIcon(myicons[2]);btn40.setIcon(myicons[2]);btn41.setIcon(myicons[2]);btn42.setIcon(myicons[2]);btn8.setEnabled(false);btn9.setEnabled(false);btn10.setEnabled(false);btn11.setEnabled(false);btn12.setEnabled(false);btn13.setEnabled(false);btn14.setEnabled(false);btn15.setEnabled(false);btn16.setEnabled(false);btn17.setEnabled(false);btn18.setEnabled(false);btn19.setEnabled(false);btn20.setEnabled(false);btn21.setEnabled(false);btn22.setEnabled(false);btn23.setEnabled(false);btn24.setEnabled(false);btn25.setEnabled(false);btn26.setEnabled(false);btn27.setEnabled(false);btn28.setEnabled(false);btn29.setEnabled(false);btn30.setEnabled(false);btn31.setEnabled(false);btn32.setEnabled(false);btn33.setEnabled(false);btn34.setEnabled(false);btn35.setEnabled(false);btn36.setEnabled(false);btn37.setEnabled(false);btn38.setEnabled(false);btn39.setEnabled(false);btn40.setEnabled(false);btn41.setEnabled(false);btn42.setEnabled(false);
	score2++;lbls2.setText(Integer.toString(score2));
	red=21;yellow=21;lblred.setText("21");lblyellow.setText("21");
}
if(lblred.getText()=="0"){
	JOptionPane.showMessageDialog(null,p1+" is out of star.\n"+p2+"  is BINGO");
	btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);btn10.setIcon(myicons[2]);btn11.setIcon(myicons[2]);btn12.setIcon(myicons[2]);btn13.setIcon(myicons[2]);btn14.setIcon(myicons[2]);btn15.setIcon(myicons[2]);btn16.setIcon(myicons[2]);btn17.setIcon(myicons[2]);btn18.setIcon(myicons[2]);btn19.setIcon(myicons[2]);btn20.setIcon(myicons[2]);btn21.setIcon(myicons[2]);btn22.setIcon(myicons[2]);btn23.setIcon(myicons[2]);btn24.setIcon(myicons[2]);btn25.setIcon(myicons[2]);btn26.setIcon(myicons[2]);btn27.setIcon(myicons[2]);btn28.setIcon(myicons[2]);btn29.setIcon(myicons[2]);btn30.setIcon(myicons[2]);btn31.setIcon(myicons[2]);btn32.setIcon(myicons[2]);btn33.setIcon(myicons[2]);btn34.setIcon(myicons[2]);btn35.setIcon(myicons[2]);btn36.setIcon(myicons[2]);btn37.setIcon(myicons[2]);btn38.setIcon(myicons[2]);btn39.setIcon(myicons[2]);btn40.setIcon(myicons[2]);btn41.setIcon(myicons[2]);btn42.setIcon(myicons[2]);btn8.setEnabled(false);btn9.setEnabled(false);btn10.setEnabled(false);btn11.setEnabled(false);btn12.setEnabled(false);btn13.setEnabled(false);btn14.setEnabled(false);btn15.setEnabled(false);btn16.setEnabled(false);btn17.setEnabled(false);btn18.setEnabled(false);btn19.setEnabled(false);btn20.setEnabled(false);btn21.setEnabled(false);btn22.setEnabled(false);btn23.setEnabled(false);btn24.setEnabled(false);btn25.setEnabled(false);btn26.setEnabled(false);btn27.setEnabled(false);btn28.setEnabled(false);btn29.setEnabled(false);btn30.setEnabled(false);btn31.setEnabled(false);btn32.setEnabled(false);btn33.setEnabled(false);btn34.setEnabled(false);btn35.setEnabled(false);btn36.setEnabled(false);btn37.setEnabled(false);btn38.setEnabled(false);btn39.setEnabled(false);btn40.setEnabled(false);btn41.setEnabled(false);btn42.setEnabled(false);
	score1++;lbls1.setText(Integer.toString(score1));
}
if(lblyellow.getText()=="0"){
	JOptionPane.showMessageDialog(null,p2+" is out of star.\n"+p1+"  is BINGO");
	btn1.setIcon(myicons[2]);btn2.setIcon(myicons[2]);btn3.setIcon(myicons[2]);btn4.setIcon(myicons[2]);btn5.setIcon(myicons[2]);btn6.setIcon(myicons[2]);btn7.setIcon(myicons[2]);btn8.setIcon(myicons[2]);btn9.setIcon(myicons[2]);btn10.setIcon(myicons[2]);btn11.setIcon(myicons[2]);btn12.setIcon(myicons[2]);btn13.setIcon(myicons[2]);btn14.setIcon(myicons[2]);btn15.setIcon(myicons[2]);btn16.setIcon(myicons[2]);btn17.setIcon(myicons[2]);btn18.setIcon(myicons[2]);btn19.setIcon(myicons[2]);btn20.setIcon(myicons[2]);btn21.setIcon(myicons[2]);btn22.setIcon(myicons[2]);btn23.setIcon(myicons[2]);btn24.setIcon(myicons[2]);btn25.setIcon(myicons[2]);btn26.setIcon(myicons[2]);btn27.setIcon(myicons[2]);btn28.setIcon(myicons[2]);btn29.setIcon(myicons[2]);btn30.setIcon(myicons[2]);btn31.setIcon(myicons[2]);btn32.setIcon(myicons[2]);btn33.setIcon(myicons[2]);btn34.setIcon(myicons[2]);btn35.setIcon(myicons[2]);btn36.setIcon(myicons[2]);btn37.setIcon(myicons[2]);btn38.setIcon(myicons[2]);btn39.setIcon(myicons[2]);btn40.setIcon(myicons[2]);btn41.setIcon(myicons[2]);btn42.setIcon(myicons[2]);btn8.setEnabled(false);btn9.setEnabled(false);btn10.setEnabled(false);btn11.setEnabled(false);btn12.setEnabled(false);btn13.setEnabled(false);btn14.setEnabled(false);btn15.setEnabled(false);btn16.setEnabled(false);btn17.setEnabled(false);btn18.setEnabled(false);btn19.setEnabled(false);btn20.setEnabled(false);btn21.setEnabled(false);btn22.setEnabled(false);btn23.setEnabled(false);btn24.setEnabled(false);btn25.setEnabled(false);btn26.setEnabled(false);btn27.setEnabled(false);btn28.setEnabled(false);btn29.setEnabled(false);btn30.setEnabled(false);btn31.setEnabled(false);btn32.setEnabled(false);btn33.setEnabled(false);btn34.setEnabled(false);btn35.setEnabled(false);btn36.setEnabled(false);btn37.setEnabled(false);btn38.setEnabled(false);btn39.setEnabled(false);btn40.setEnabled(false);btn41.setEnabled(false);btn42.setEnabled(false);
	score2++;lbls2.setText(Integer.toString(score2));
}
}
}
}
