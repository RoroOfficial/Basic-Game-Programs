import java.util.Random;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class ColorGame extends JFrame implements ActionListener
{
	JButton btndraw;
	JButton btnred, btngreen, btnblue, btnyellow, btnpink, btnwhite, btnreset;
	JLabel lbl1, lbl2, lbl3;
	JTextField txtr1, txtg1, txtb1, txty1, txtp1, txtw1, txtr2, txtg2, txtb2, txty2, txtp2, txtw2;
	Timer tmr1=new Timer(100,this);
	Timer tmr2=new Timer(100,this);
	Timer tmr3=new Timer(100,this);
    Random rnd1=new Random();
	Random rnd2=new Random();
	Random rnd3=new Random();
	ImageIcon myicons[]=new ImageIcon[7];
    int random1, random2, random3, segundo, r1, g1, b1, y1, p1, w1 ,r2, g2, b2, y2, p2, w2, r3, g3, b3, y3, p3, w3;
	int counter=0;
	int count=6;

public static void main(String[] args)throws IOException
{
	new ColorGame();
}

public ColorGame()
{
    setLocation(450,100);
	setTitle("Color Game");
	setSize(380,570);
	setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	myicons[0]=new ImageIcon("red.jpg");
	myicons[1]=new ImageIcon("green.jpg");
	myicons[2]=new ImageIcon("blue.jpg");
	myicons[3]=new ImageIcon("yellow.jpg");
	myicons[4]=new ImageIcon("pink.jpg");
	myicons[5]=new ImageIcon("white.jpg");

	btnred=new JButton("");
	btnred.setBounds(20,20,100,100);
	btnred.setIcon(myicons[0]);
	btnred.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{	
			txtr1.setEnabled(true);
			txtr1.setText("");
			txtr1.setBackground(Color.white);
			txtr2.setBackground(Color.white);
		}
	}
	);
	add(btnred);

	btngreen=new JButton("");
	btngreen.setBounds(130,20,100,100);
	btngreen.setIcon(myicons[1]);
	btngreen.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{	
			txtg1.setEnabled(true);
			txtg1.setText("");
			txtg1.setBackground(Color.white);
			txtg2.setBackground(Color.white);
		}
	}
	);
	add(btngreen);

	btnblue=new JButton("");
	btnblue.setBounds(240,20,100,100);
	btnblue.setIcon(myicons[2]);
	btnblue.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{	
			txtb1.setEnabled(true);
			txtb1.setText("");
			txtb1.setBackground(Color.white);
			txtb2.setBackground(Color.white);
		}
	}
	);
	add(btnblue);

	btnyellow=new JButton("");
	btnyellow.setBounds(20,160,100,100);
	btnyellow.setIcon(myicons[3]);
	btnyellow.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{	
			txty1.setEnabled(true);
			txty1.setText("");
			txty1.setBackground(Color.white);
			txty2.setBackground(Color.white);
		}
	}
	);
	add(btnyellow);

	btnpink=new JButton("");
	btnpink.setBounds(130,160,100,100);
	btnpink.setIcon(myicons[4]);
	btnpink.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{	
			txtp1.setEnabled(true);
			txtp1.setText("");
			txtp1.setBackground(Color.white);
			txtp2.setBackground(Color.white);
		}
	}
	);
	add(btnpink);

	btnwhite=new JButton("");
	btnwhite.setBounds(240,160,100,100);
	btnwhite.setIcon(myicons[5]);
	btnwhite.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{	
			txtw1.setEnabled(true);
			txtw1.setText("");
			txtw1.setBackground(Color.white);
			txtw2.setBackground(Color.white);
		}
	}
	);
	add(btnwhite);

	btndraw=new JButton("Draw");
	btndraw.setBounds(140,430,75,20);
	btndraw.setMnemonic('A');
	btndraw.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
		{
    		tmr1.start();
			tmr2.start();
			tmr3.start();
    	}
    }
    );
	add(btndraw);

	btnreset=new JButton("Reset");
	btnreset.setBounds(140,490,75,20);
	btnreset.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
		{
    		txtr1.setText("0");
			txtg1.setText("0");
			txtb1.setText("0");
			txty1.setText("0");
			txtw1.setText("0");
			txtp1.setText("0");
			txtr2.setText("0");
			txtg2.setText("0");
			txtb2.setText("0");
			txty2.setText("0");
			txtw2.setText("0");
			txtp2.setText("0");
			txtr2.setBackground(Color.white);
			txtg2.setBackground(Color.white);
			txtb2.setBackground(Color.white);
			txty2.setBackground(Color.white);
			txtp2.setBackground(Color.white);
			txtw2.setBackground(Color.white);
			txtr1.setEnabled(false);
			txtg1.setEnabled(false);
			txtb1.setEnabled(false);
			txty1.setEnabled(false);
			txtp1.setEnabled(false);
			txtw1.setEnabled(false);
    	}
    }
    );
	add(btnreset);

	txtr1=new JTextField("0");
	txtr1.setBounds(20,130,45,20);
	txtr1.setEnabled(false);
	add(txtr1);

	txtr2=new JTextField("0");
	txtr2.setBounds(70,130,45,20);
	txtr2.setEnabled(false);
	add(txtr2);

	txtg1=new JTextField("0");
	txtg1.setBounds(130,130,45,20);
	txtg1.setEnabled(false);
	add(txtg1);
	
	txtg2=new JTextField("0");
	txtg2.setBounds(180,130,45,20);
	txtg2.setEnabled(false);
	add(txtg2);

	txtb1=new JTextField("0");
	txtb1.setBounds(240,130,45,20);
	txtb1.setEnabled(false);
	add(txtb1);

	txtb2=new JTextField("0");
	txtb2.setBounds(290,130,45,20);
	txtb2.setEnabled(false);
	add(txtb2);

	txty1=new JTextField("0");
	txty1.setBounds(20,270,45,20);
	txty1.setEnabled(false);
	add(txty1);

	txty2=new JTextField("0");
	txty2.setBounds(70,270,45,20);
	txty2.setEnabled(false);
	add(txty2);

	txtp1=new JTextField("0");
	txtp1.setBounds(130,270,45,20);
	txtp1.setEnabled(false);
	add(txtp1);

	txtp2=new JTextField("0");
	txtp2.setBounds(180,270,45,20);
	txtp2.setEnabled(false);
	add(txtp2);

	txtw1=new JTextField("0");
	txtw1.setBounds(240,270,45,20);
	txtw1.setEnabled(false);
	add(txtw1);

	txtw2=new JTextField("0");
	txtw2.setBounds(290,270,45,20);
	txtw2.setEnabled(false);
	add(txtw2);

	lbl1=new JLabel("");
	lbl1.setBounds(20,300,100,100);
	lbl1.setIcon(myicons[0]);
	add(lbl1);

	lbl2=new JLabel("");
	lbl2.setBounds(130,300,100,100);
	lbl2.setIcon(myicons[1]);
	add(lbl2);

	lbl3=new JLabel("");
	lbl3.setBounds(240,300,100,100);
	lbl3.setIcon(myicons[2]);
	add(lbl3);

	setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
	segundo=segundo+1;
    random1=rnd1.nextInt(count)+counter;
	random2=rnd2.nextInt(count)+counter;
	random3=rnd3.nextInt(count)+counter;
    lbl1.setIcon(myicons[random1]);
    lbl2.setIcon(myicons[random2]);
    lbl3.setIcon(myicons[random3]);

	if(segundo==20)
	{
		segundo=0;
		tmr1.stop();
		tmr2.stop();
		tmr3.stop();

		txtr2.setBackground(Color.white);
		txtg2.setBackground(Color.white);
		txtb2.setBackground(Color.white);
		txty2.setBackground(Color.white);
		txtp2.setBackground(Color.white);
		txtw2.setBackground(Color.white);
		//1st shuffle
		if((myicons[random1])==(myicons[0]))
		{
			r1=Integer.parseInt(txtr1.getText())*2;
   			txtr2.setText(Integer.toString(r1));
			txtr2.setBackground(Color.yellow);
		}
		if((myicons[random1])==(myicons[1]))
		{
			g1=Integer.parseInt(txtg1.getText())*2;
   			txtg2.setText(Integer.toString(g1));
			txtg2.setBackground(Color.yellow);
		}
		if((myicons[random1])==(myicons[2]))
		{
			b1=Integer.parseInt(txtb1.getText())*2;
   			txtb2.setText(Integer.toString(b1));
			txtb2.setBackground(Color.yellow);
		}
		if((myicons[random1])==(myicons[3]))
		{
			y1=Integer.parseInt(txty1.getText())*2;
   			txty2.setText(Integer.toString(y1));
			txty2.setBackground(Color.yellow);
		}
		if((myicons[random1])==(myicons[4]))
		{
			p1=Integer.parseInt(txtp1.getText())*2;
   			txtp2.setText(Integer.toString(p1));
			txtp2.setBackground(Color.yellow);
		}
		if((myicons[random1])==(myicons[5]))
		{
			w1=Integer.parseInt(txtw1.getText())*2;
   			txtw2.setText(Integer.toString(w1));
			txtw2.setBackground(Color.yellow);
		}
		//2nd shuffle
		if((myicons[random2])==(myicons[0]))
		{
			r2=Integer.parseInt(txtr1.getText())*2;
   			txtr2.setText(Integer.toString(r2));
			txtr2.setBackground(Color.yellow);
		}
		if((myicons[random2])==(myicons[1]))
		{
			g2=Integer.parseInt(txtg1.getText())*2;
   			txtg2.setText(Integer.toString(g2));
			txtg2.setBackground(Color.yellow);
		}
		if((myicons[random2])==(myicons[2]))
		{
			b2=Integer.parseInt(txtb1.getText())*2;
   			txtb2.setText(Integer.toString(b2));
			txtb2.setBackground(Color.yellow);
		}
		if((myicons[random2])==(myicons[3]))
		{
			y2=Integer.parseInt(txty1.getText())*2;
   			txty2.setText(Integer.toString(y2));
			txty2.setBackground(Color.yellow);
		}
		if((myicons[random2])==(myicons[4]))
		{
			p2=Integer.parseInt(txtp1.getText())*2;
   			txtp2.setText(Integer.toString(p2));
			txtp2.setBackground(Color.yellow);
		}
		if((myicons[random2])==(myicons[5]))
		{
			w2=Integer.parseInt(txtw1.getText())*2;
   			txtw2.setText(Integer.toString(w2));
			txtw2.setBackground(Color.yellow);
		}
		//3rd shuffle
		if((myicons[random3])==(myicons[0]))
		{
			r3=Integer.parseInt(txtr1.getText())*2;
   			txtr2.setText(Integer.toString(r3));
			txtr2.setBackground(Color.yellow);
		}
		if((myicons[random3])==(myicons[1]))
		{
			g3=Integer.parseInt(txtg1.getText())*2;
   			txtg2.setText(Integer.toString(g3));
			txtg2.setBackground(Color.yellow);
		}
		if((myicons[random3])==(myicons[2]))
		{
			b3=Integer.parseInt(txtb1.getText())*2;
   			txtb2.setText(Integer.toString(b3));
			txtb2.setBackground(Color.yellow);
		}
		if((myicons[random3])==(myicons[3]))
		{
			y3=Integer.parseInt(txty1.getText())*2;
   			txty2.setText(Integer.toString(y3));
			txty2.setBackground(Color.yellow);
		}
		if((myicons[random3])==(myicons[4]))
		{
			p3=Integer.parseInt(txtp1.getText())*2;
   			txtp2.setText(Integer.toString(p3));
			txtp2.setBackground(Color.yellow);
		}
		if((myicons[random3])==(myicons[5]))
		{
			w3=Integer.parseInt(txtw1.getText())*2;
   			txtw2.setText(Integer.toString(w3));
			txtw2.setBackground(Color.yellow);
		}
		//double
		if(((myicons[random1])==(myicons[0])&&(myicons[random2])==(myicons[0])))
		{
			r1=Integer.parseInt(txtr1.getText())*3;
   			txtr2.setText(Integer.toString(r1));
			txtr2.setBackground(Color.orange);
		}
		if(((myicons[random2])==(myicons[0])&&(myicons[random3])==(myicons[0])))
		{
			r1=Integer.parseInt(txtr1.getText())*3;
   			txtr2.setText(Integer.toString(r1));
			txtr2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[0])&&(myicons[random3])==(myicons[0])))
		{
			r1=Integer.parseInt(txtr1.getText())*3;
   			txtr2.setText(Integer.toString(r1));
			txtr2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[1])&&(myicons[random2])==(myicons[1])))
		{
			g1=Integer.parseInt(txtg1.getText())*3;
   			txtg2.setText(Integer.toString(g1));
			txtg2.setBackground(Color.orange);
		}
		if(((myicons[random2])==(myicons[1])&&(myicons[random3])==(myicons[1])))
		{
			g1=Integer.parseInt(txtg1.getText())*3;
   			txtg2.setText(Integer.toString(g1));
			txtg2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[1])&&(myicons[random3])==(myicons[1])))
		{
			g1=Integer.parseInt(txtg1.getText())*3;
   			txtg2.setText(Integer.toString(g1));
			txtg2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[2])&&(myicons[random2])==(myicons[2])))
		{
			b1=Integer.parseInt(txtb1.getText())*3;
   			txtb2.setText(Integer.toString(b1));
			txtb2.setBackground(Color.orange);
		}
		if(((myicons[random2])==(myicons[2])&&(myicons[random3])==(myicons[2])))
		{
			b1=Integer.parseInt(txtb1.getText())*3;
   			txtb2.setText(Integer.toString(b1));
			txtb2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[2])&&(myicons[random3])==(myicons[2])))
		{
			b1=Integer.parseInt(txtb1.getText())*3;
   			txtb2.setText(Integer.toString(b1));
			txtb2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[3])&&(myicons[random2])==(myicons[3])))
		{
			y1=Integer.parseInt(txty1.getText())*3;
   			txty2.setText(Integer.toString(y1));
			txty2.setBackground(Color.orange);
		}
		if(((myicons[random2])==(myicons[3])&&(myicons[random3])==(myicons[3])))
		{
			y1=Integer.parseInt(txty1.getText())*3;
   			txty2.setText(Integer.toString(y1));
			txty2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[3])&&(myicons[random3])==(myicons[3])))
		{
			y1=Integer.parseInt(txty1.getText())*3;
   			txty2.setText(Integer.toString(y1));
			txty2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[4])&&(myicons[random2])==(myicons[4])))
		{
			p1=Integer.parseInt(txtp1.getText())*3;
   			txtp2.setText(Integer.toString(p1));
			txtp2.setBackground(Color.orange);
		}
		if(((myicons[random2])==(myicons[4])&&(myicons[random3])==(myicons[4])))
		{
			p1=Integer.parseInt(txtp1.getText())*3;
   			txtp2.setText(Integer.toString(p1));
			txtp2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[4])&&(myicons[random3])==(myicons[4])))
		{
			p1=Integer.parseInt(txtp1.getText())*3;
   			txtp2.setText(Integer.toString(p1));
			txtp2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[5])&&(myicons[random2])==(myicons[5])))
		{
			w1=Integer.parseInt(txtw1.getText())*3;
   			txtw2.setText(Integer.toString(w1));
			txtw2.setBackground(Color.orange);
		}
		if(((myicons[random2])==(myicons[5])&&(myicons[random3])==(myicons[5])))
		{
			w1=Integer.parseInt(txtw1.getText())*3;
   			txtw2.setText(Integer.toString(w1));
			txtw2.setBackground(Color.orange);
		}
		if(((myicons[random1])==(myicons[5])&&(myicons[random3])==(myicons[5])))
		{
			w1=Integer.parseInt(txtw1.getText())*3;
   			txtw2.setText(Integer.toString(w1));
			txtw2.setBackground(Color.orange);
		}
		//triple
		if((((myicons[random1])==(myicons[0])&&(myicons[random2])==(myicons[0])&&(myicons[random3])==(myicons[0]))))
		{
			r1=Integer.parseInt(txtr1.getText())*4;
   			txtr2.setText(Integer.toString(r1));
			txtr2.setBackground(Color.red);
		}
		if((((myicons[random1])==(myicons[1])&&(myicons[random2])==(myicons[1])&&(myicons[random3])==(myicons[1]))))
		{
			g1=Integer.parseInt(txtg1.getText())*4;
   			txtg2.setText(Integer.toString(g1));
			txtg2.setBackground(Color.red);
		}
		if((((myicons[random1])==(myicons[2])&&(myicons[random2])==(myicons[2])&&(myicons[random3])==(myicons[2]))))
		{
			b1=Integer.parseInt(txtb1.getText())*4;
   			txtb2.setText(Integer.toString(b1));
			txtb2.setBackground(Color.red);
		}
		if((((myicons[random1])==(myicons[3])&&(myicons[random2])==(myicons[3])&&(myicons[random3])==(myicons[3]))))
		{
			y1=Integer.parseInt(txty1.getText())*4;
   			txty2.setText(Integer.toString(y1));
			txty2.setBackground(Color.red);
		}
		if((((myicons[random1])==(myicons[4])&&(myicons[random2])==(myicons[4])&&(myicons[random3])==(myicons[4]))))
		{
			p1=Integer.parseInt(txtp1.getText())*4;
   			txtp2.setText(Integer.toString(p1));
			txtp2.setBackground(Color.red);
		}
		if((((myicons[random1])==(myicons[5])&&(myicons[random2])==(myicons[5])&&(myicons[random3])==(myicons[5]))))
		{
			w1=Integer.parseInt(txtw1.getText())*4;
   			txtw2.setText(Integer.toString(w1));
			txtw2.setBackground(Color.red);
		}
	}
}
}
