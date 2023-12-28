import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class sudoku extends JPanel implements ActionListener{
	static JFrame frame = new JFrame();
	ImageIcon myicons[]=new ImageIcon[4];
	int score, counter, level;
	static JLabel lblscore, lbllevel, lbllife, lbls;
	static JButton btnplay, btnins, btnexit, btnplace, btnchange, btncheck, btnsolve;
	static JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17, txt18, txt19, txt20, txt21, txt22, txt23, txt24, txt25, txt26, txt27, txt28;
	Timer tm = new Timer(1000,this);
	boolean level1=true, level2=true, level3=true, front=true, lvl1solve=true;
	//enemy									enemy vel
	static int ex=50,ey=50,ew=50,eh=50;		static int velye=5;
public sudoku(){
	tm.start();
	setLayout(null);
	/*this.requestFocus();
	addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);*/

    myicons[0]=new ImageIcon("play.png");
    myicons[1]=new ImageIcon("ins.png");
    myicons[2]=new ImageIcon("exit.png");
	
	//menu
	btnplay = new JButton("");
	btnplay.setBounds(115,230,200,40);
	btnplay.setIcon(myicons[0]);
	btnplay.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			front=false;level1=true;btnplay.setVisible(false);btnins.setVisible(false);btnexit.setVisible(false);lbllevel.setVisible(true);lblscore.setVisible(true);lbllife.setVisible(true);lbls.setVisible(true);btnplace.setVisible(true);btnchange.setVisible(true);btncheck.setVisible(true);btnsolve.setVisible(true);txtlevel1();
		}
	}
	);
	add(btnplay);
	
	btnins = new JButton("");
	btnins.setBounds(115,280,200,40);
	btnins.setIcon(myicons[1]);
	btnins.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			JOptionPane.showMessageDialog(null,"====================================== Sudoku Challenge ======================================\n Fill all the blank tile with numbers 1-9 to reach the next level.\n RED TILE means wrong number.\n YELLOW TILE means correct number.\n You can use the SOLVE feautre to easily complete the current level, but every time you use SOLVE, your life is deducted.");
			
		}
	}
	);
	add(btnins);
	
	btnexit = new JButton("");
	btnexit.setBounds(115,330,200,40);
	btnexit.setIcon(myicons[2]);
	btnexit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"Sudoku Challenge by Rona\n Program will now exit.");
			System.exit(0);
		}
	}
	);
	add(btnexit);
	//lls
	lbllevel = new JLabel("Level: 1");
	lbllevel.setBounds(5,0,200,50);
	lbllevel.setFont(new Font("OCR A Extended",Font.BOLD,15));
	lbllevel.setVisible(false);
	add(lbllevel);
	
	lbls = new JLabel("Score:");
	lbls.setBounds(120,0,200,50);
	lbls.setFont(new Font("OCR A Extended",Font.BOLD,15));
	lbls.setVisible(false);
	add(lbls);
	
	lblscore = new JLabel("0");
	lblscore.setBounds(180,0,200,50);
	lblscore.setFont(new Font("OCR A Extended",Font.BOLD,15));
	lblscore.setVisible(false);
	add(lblscore);
	
	lbllife = new JLabel("3 Life Remaining");
	lbllife.setBounds(250,0,200,50);
	lbllife.setFont(new Font("OCR A Extended",Font.BOLD,15));
	lbllife.setVisible(false);
	add(lbllife);
	//button
	btnplace = new JButton("Lock");
	btnplace.setBounds(31,430,90,40);
	btnplace.setVisible(false);
	btnplace.setBackground(Color.gray);
	btnplace.setFont(new Font("OCR A Extended",Font.BOLD,10));
	btnplace.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			txt1.setEnabled(false);txt2.setEnabled(false);txt3.setEnabled(false);txt4.setEnabled(false);txt5.setEnabled(false);txt6.setEnabled(false);txt7.setEnabled(false);txt8.setEnabled(false);txt9.setEnabled(false);txt10.setEnabled(false);txt11.setEnabled(false);txt12.setEnabled(false);txt13.setEnabled(false);txt14.setEnabled(false);txt15.setEnabled(false);txt16.setEnabled(false);txt17.setEnabled(false);txt18.setEnabled(false);
		}
	}
	);
	add(btnplace);
	
	btnchange = new JButton("Unlock");
	btnchange.setBounds(121,430,90,40);
	btnchange.setVisible(false);
	btnchange.setBackground(Color.gray);
	btnchange.setFont(new Font("OCR A Extended",Font.BOLD,10));
	btnchange.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			txt1.setEnabled(true);
			txt2.setEnabled(true);
			txt3.setEnabled(true);
			txt4.setEnabled(true);
			txt5.setEnabled(true);
			txt6.setEnabled(true);
			txt7.setEnabled(true);
			txt8.setEnabled(true);
			txt9.setEnabled(true);
			txt10.setEnabled(true);
			txt11.setEnabled(true);
			txt12.setEnabled(true);
			txt13.setEnabled(true);
			txt14.setEnabled(true);
			txt15.setEnabled(true);
			txt16.setEnabled(true);
			txt17.setEnabled(true);
			txt18.setEnabled(true);
		}
	}
	);
	add(btnchange);

	btncheck = new JButton("Check");
	btncheck.setBounds(211,430,90,40);
	btncheck.setVisible(false);
	btncheck.setBackground(Color.gray);
	btncheck.setFont(new Font("OCR A Extended",Font.BOLD,10));
	btncheck.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		if(lbllevel.getText()=="Level: 1"){
			if(Integer.parseInt(txt1.getText())==3){
				txt1.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt1.setBackground(Color.red);
			}
			if(Integer.parseInt(txt2.getText())==7){
				txt2.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt2.setBackground(Color.red);	
			}
			if(Integer.parseInt(txt3.getText())==8){
				txt3.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt3.setBackground(Color.red);		
			}
			if(Integer.parseInt(txt4.getText())==5){
				txt4.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt4.setBackground(Color.red);	
			}
			if(Integer.parseInt(txt5.getText())==7){
				txt5.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt5.setBackground(Color.red);
			}
			if(Integer.parseInt(txt6.getText())==6){
				txt6.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt6.setBackground(Color.red);
			}
			if(Integer.parseInt(txt7.getText())==9){
				txt7.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt7.setBackground(Color.red);
			}
			if(Integer.parseInt(txt8.getText())==2){
				txt8.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt8.setBackground(Color.red);
			}
			if(Integer.parseInt(txt9.getText())==8){
				txt9.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt9.setBackground(Color.red);
			}
			if(Integer.parseInt(txt10.getText())==5){
				txt10.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt10.setBackground(Color.red);
			}
			if(Integer.parseInt(txt11.getText())==2){
				txt11.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt11.setBackground(Color.red);
			}
			if(Integer.parseInt(txt12.getText())==1){
				txt12.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt12.setBackground(Color.red);
			}
			if(Integer.parseInt(txt13.getText())==1){
				txt13.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt13.setBackground(Color.red);
			}
			if(Integer.parseInt(txt14.getText())==8){
				txt14.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt14.setBackground(Color.red);
			}
			if(Integer.parseInt(txt15.getText())==3){
				txt15.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt15.setBackground(Color.red);
			}
			if(Integer.parseInt(txt16.getText())==6){
				txt16.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt16.setBackground(Color.red);
			}
			if(Integer.parseInt(txt17.getText())==7){
				txt17.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt17.setBackground(Color.red);
			}
			if(Integer.parseInt(txt18.getText())==8){
				txt18.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt18.setBackground(Color.red);
			}
			if((Integer.parseInt(txt1.getText())==3)&&(Integer.parseInt(txt2.getText())==7)&&(Integer.parseInt(txt3.getText())==8)&&(Integer.parseInt(txt4.getText())==5)&&(Integer.parseInt(txt5.getText())==7)&&(Integer.parseInt(txt6.getText())==6)&&(Integer.parseInt(txt7.getText())==9)&&(Integer.parseInt(txt8.getText())==2)&&(Integer.parseInt(txt9.getText())==8)&&(Integer.parseInt(txt10.getText())==5)&&(Integer.parseInt(txt11.getText())==2)&&(Integer.parseInt(txt12.getText())==1)&&(Integer.parseInt(txt13.getText())==1)&&(Integer.parseInt(txt14.getText())==8)&&(Integer.parseInt(txt15.getText())==3)&&(Integer.parseInt(txt16.getText())==6)&&(Integer.parseInt(txt17.getText())==7)&&(Integer.parseInt(txt18.getText())==8)){
				JOptionPane.showMessageDialog(null,"========== LEVEL 1 SOLVED ==========");
				level2=true;lbllevel.setText("Level: 2");txtlevel2();
				//level 2
				txt1.setBounds(111,75,34,34);txt2.setBounds(192,75,34,34);txt3.setBounds(350,75,34,34);
				txt4.setBounds(155,111,34,34);
				txt5.setBounds(40,150,34,34);txt6.setBounds(75,150,34,34);txt7.setBounds(155,150,34,34);txt8.setBounds(280,150,34,34);txt9.setBounds(315,150,34,34);txt10.setBounds(352,150,34,34);
				txt11.setBounds(75,191,34,34);txt12.setBounds(280,191,34,34);txt13.setBounds(352,191,34,34);
				txt14.setBounds(75,230,34,34);txt15.setBounds(232,230,34,34);
				txt16.setBounds(40,271,34,34);txt17.setBounds(155,271,34,34);txt18.setBounds(232,271,34,34);
				txt1.setEnabled(true);txt2.setEnabled(true);txt3.setEnabled(true);txt4.setEnabled(true);txt5.setEnabled(true);txt6.setEnabled(true);txt7.setEnabled(true);txt8.setEnabled(true);txt9.setEnabled(true);txt10.setEnabled(true);txt11.setEnabled(true);txt12.setEnabled(true);txt13.setEnabled(true);txt14.setEnabled(true);txt15.setEnabled(true);txt16.setEnabled(true);txt17.setEnabled(true);txt18.setEnabled(true);
				txt1.setText("0");txt2.setText("0");txt3.setText("0");txt4.setText("0");txt5.setText("0");txt6.setText("0");txt7.setText("0");txt8.setText("0");txt9.setText("0");txt10.setText("0");txt11.setText("0");txt12.setText("0");txt13.setText("0");txt14.setText("0");txt15.setText("0");txt16.setText("0");txt17.setText("0");txt18.setText("0");
			}
				
		}
		if(lbllevel.getText()=="Level: 2"){
			if(Integer.parseInt(txt1.getText())==5){
				txt1.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt1.setBackground(Color.red);
			}
			if(Integer.parseInt(txt2.getText())==1){
				txt2.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt2.setBackground(Color.red);
			}
			if(Integer.parseInt(txt3.getText())==7){
				txt3.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt3.setBackground(Color.red);
			}
			if(Integer.parseInt(txt4.getText())==8){
				txt4.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt4.setBackground(Color.red);
			}
			if(Integer.parseInt(txt5.getText())==4){
				txt5.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt5.setBackground(Color.red);
			}
			if(Integer.parseInt(txt6.getText())==1){
				txt6.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt6.setBackground(Color.red);
			}
			if(Integer.parseInt(txt7.getText())==2){
				txt7.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt7.setBackground(Color.red);
			}
			if(Integer.parseInt(txt8.getText())==6){
				txt8.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt8.setBackground(Color.red);
			}
			if(Integer.parseInt(txt9.getText())==5){
				txt9.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt9.setBackground(Color.red);
			}
			if(Integer.parseInt(txt10.getText())==8){
				txt10.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt10.setBackground(Color.red);
			}
			if(Integer.parseInt(txt11.getText())==6){
				txt11.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt11.setBackground(Color.red);
			}
			if(Integer.parseInt(txt12.getText())==7){
				txt12.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt12.setBackground(Color.red);
			}
			if(Integer.parseInt(txt13.getText())==2){
				txt13.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt13.setBackground(Color.red);
			}
			if(Integer.parseInt(txt14.getText())==2){
				txt14.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt14.setBackground(Color.red);
			}
			if(Integer.parseInt(txt15.getText())==8){
				txt15.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt15.setBackground(Color.red);
			}
			if(Integer.parseInt(txt16.getText())==7){
				txt16.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt16.setBackground(Color.red);
			}
			if(Integer.parseInt(txt17.getText())==5){
				txt17.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt17.setBackground(Color.red);
			}
			if(Integer.parseInt(txt18.getText())==9){
				txt18.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt18.setBackground(Color.red);
			}
			if(Integer.parseInt(txt19.getText())==3){
				txt19.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt19.setBackground(Color.red);
			}
			if(Integer.parseInt(txt20.getText())==7){
				txt20.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt20.setBackground(Color.red);
			}
			if(Integer.parseInt(txt21.getText())==9){
				txt21.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt21.setBackground(Color.red);
			}
			if(Integer.parseInt(txt22.getText())==8){
				txt22.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt22.setBackground(Color.red);
			}
			if(Integer.parseInt(txt23.getText())==5){
				txt23.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt23.setBackground(Color.red);
			}
			if(Integer.parseInt(txt24.getText())==7){
				txt24.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt24.setBackground(Color.red);
			}
			if(Integer.parseInt(txt25.getText())==7){
				txt25.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt25.setBackground(Color.red);
			}
			if(Integer.parseInt(txt26.getText())==6){
				txt26.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt26.setBackground(Color.red);
			}
			if(Integer.parseInt(txt27.getText())==8){
				txt27.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt27.setBackground(Color.red);
			}
			if(Integer.parseInt(txt28.getText())==1){
				txt28.setBackground(Color.yellow);
				score++;lblscore.setText(Integer.toString(score));
			}
			else{
				txt28.setBackground(Color.red);
			}
			if((Integer.parseInt(txt1.getText())==5)&&(Integer.parseInt(txt2.getText())==1)&&(Integer.parseInt(txt3.getText())==7)&&(Integer.parseInt(txt4.getText())==8)&&(Integer.parseInt(txt5.getText())==4)&&(Integer.parseInt(txt6.getText())==1)&&(Integer.parseInt(txt7.getText())==2)&&(Integer.parseInt(txt8.getText())==6)&&(Integer.parseInt(txt9.getText())==5)&&(Integer.parseInt(txt10.getText())==8)&&(Integer.parseInt(txt11.getText())==6)&&(Integer.parseInt(txt12.getText())==7)&&(Integer.parseInt(txt13.getText())==2)&&(Integer.parseInt(txt14.getText())==2)&&(Integer.parseInt(txt15.getText())==8)&&(Integer.parseInt(txt16.getText())==7)&&(Integer.parseInt(txt17.getText())==5)&&(Integer.parseInt(txt18.getText())==9)&&(Integer.parseInt(txt19.getText())==3)&&(Integer.parseInt(txt20.getText())==7)&&(Integer.parseInt(txt21.getText())==9)&&(Integer.parseInt(txt22.getText())==8)&&(Integer.parseInt(txt23.getText())==5)&&(Integer.parseInt(txt24.getText())==7)&&(Integer.parseInt(txt25.getText())==7)&&(Integer.parseInt(txt26.getText())==6)&&(Integer.parseInt(txt27.getText())==8)&&(Integer.parseInt(txt28.getText())==1)){
				JOptionPane.showMessageDialog(null,"========== LEVEL 2 SOLVED ==========");
				level3=true;lbllevel.setText("Level: 3");txtlevel2();
			}
		}
		}
	}
	);
	add(btncheck);

	btnsolve = new JButton("Solve");
	btnsolve.setBounds(301,430,90,40);
	btnsolve.setVisible(false);
	btnsolve.setBackground(Color.gray);
	btnsolve.setFont(new Font("OCR A Extended",Font.BOLD,10));
	btnsolve.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			counter++;
			if(counter==1){
				lbllife.setText("2 Life Remaining");
			}
			if(counter==2){
				lbllife.setText("1 Life Remaining");
			}
			if(counter==3){
				lbllife.setText("0 Life Remaining");
				JOptionPane.showMessageDialog(null,"You're out of life\n========== Game is Over! ==========");
				System.exit(0);
			}
			if(lbllevel.getText()=="Level: 1"){
				txt1.setText("3");txt1.setBackground(Color.CYAN);txt1.setEnabled(false);
				txt2.setText("7");txt2.setBackground(Color.CYAN);txt2.setEnabled(false);
				txt3.setText("8");txt3.setBackground(Color.CYAN);txt3.setEnabled(false);
				txt4.setText("5");txt4.setBackground(Color.CYAN);txt4.setEnabled(false);
				txt5.setText("7");txt5.setBackground(Color.CYAN);txt5.setEnabled(false);
				txt6.setText("6");txt6.setBackground(Color.CYAN);txt6.setEnabled(false);
				txt7.setText("9");txt7.setBackground(Color.CYAN);txt7.setEnabled(false);
				txt8.setText("2");txt8.setBackground(Color.CYAN);txt8.setEnabled(false);
				txt9.setText("8");txt9.setBackground(Color.CYAN);txt9.setEnabled(false);
				txt10.setText("5");txt10.setBackground(Color.CYAN);txt10.setEnabled(false);
				txt11.setText("2");txt11.setBackground(Color.CYAN);txt11.setEnabled(false);
				txt12.setText("1");txt12.setBackground(Color.CYAN);txt12.setEnabled(false);
				txt13.setText("1");txt13.setBackground(Color.CYAN);txt13.setEnabled(false);
				txt14.setText("8");txt14.setBackground(Color.CYAN);txt14.setEnabled(false);
				txt15.setText("3");txt15.setBackground(Color.CYAN);txt15.setEnabled(false);
				txt16.setText("6");txt16.setBackground(Color.CYAN);txt16.setEnabled(false);
				txt17.setText("7");txt17.setBackground(Color.CYAN);txt17.setEnabled(false);
				txt18.setText("8");txt18.setBackground(Color.CYAN);txt18.setEnabled(false);
			}
			if(lbllevel.getText()=="Level: 2"){
				txt1.setText("5");txt1.setBackground(Color.CYAN);txt1.setEnabled(false);
				txt2.setText("1");txt2.setBackground(Color.CYAN);txt2.setEnabled(false);
				txt3.setText("7");txt3.setBackground(Color.CYAN);txt3.setEnabled(false);
				txt4.setText("8");txt4.setBackground(Color.CYAN);txt4.setEnabled(false);
				txt5.setText("4");txt5.setBackground(Color.CYAN);txt5.setEnabled(false);
				txt6.setText("1");txt6.setBackground(Color.CYAN);txt6.setEnabled(false);
				txt7.setText("2");txt7.setBackground(Color.CYAN);txt7.setEnabled(false);
				txt8.setText("6");txt8.setBackground(Color.CYAN);txt8.setEnabled(false);
				txt9.setText("5");txt9.setBackground(Color.CYAN);txt9.setEnabled(false);
				txt10.setText("8");txt10.setBackground(Color.CYAN);txt10.setEnabled(false);
				txt11.setText("6");txt11.setBackground(Color.CYAN);txt11.setEnabled(false);
				txt12.setText("7");txt12.setBackground(Color.CYAN);txt12.setEnabled(false);
				txt13.setText("2");txt13.setBackground(Color.CYAN);txt13.setEnabled(false);
				txt14.setText("2");txt14.setBackground(Color.CYAN);txt14.setEnabled(false);
				txt15.setText("8");txt15.setBackground(Color.CYAN);txt15.setEnabled(false);
				txt16.setText("7");txt16.setBackground(Color.CYAN);txt16.setEnabled(false);
				txt17.setText("5");txt17.setBackground(Color.CYAN);txt17.setEnabled(false);
				txt18.setText("9");txt18.setBackground(Color.CYAN);txt18.setEnabled(false);
				txt19.setText("3");txt19.setBackground(Color.CYAN);txt19.setEnabled(false);
				txt20.setText("7");txt20.setBackground(Color.CYAN);txt20.setEnabled(false);
				txt21.setText("9");txt21.setBackground(Color.CYAN);txt21.setEnabled(false);
				txt22.setText("8");txt22.setBackground(Color.CYAN);txt22.setEnabled(false);
				txt23.setText("5");txt23.setBackground(Color.CYAN);txt23.setEnabled(false);
				txt24.setText("7");txt24.setBackground(Color.CYAN);txt24.setEnabled(false);
				txt25.setText("7");txt25.setBackground(Color.CYAN);txt25.setEnabled(false);
				txt26.setText("6");txt26.setBackground(Color.CYAN);txt26.setEnabled(false);
				txt27.setText("8");txt27.setBackground(Color.CYAN);txt27.setEnabled(false);
				txt28.setText("1");txt28.setBackground(Color.CYAN);txt28.setEnabled(false);
			}
		}
	}
	);
	add(btnsolve);
	//level 1
	
	level1=false;level2=false;level3=false;lvl1solve=false;
}
public void txtlevel1(){
	txt1=new JTextField("0");
	txt1.setBounds(75,75,34,34);
	txt1.setFont(new Font("Arial",Font.BOLD,30));
	txt1.setBackground(Color.RED);
	add(txt1);
	txt2=new JTextField("0");
	txt2.setBounds(350,75,34,34);
	txt2.setFont(new Font("Arial",Font.BOLD,30));
	txt2.setBackground(Color.RED);
	add(txt2);
	txt3=new JTextField("0");
	txt3.setBounds(155,111,34,34);
	txt3.setFont(new Font("Arial",Font.BOLD,30));
	txt3.setBackground(Color.RED);
	add(txt3);
	txt4=new JTextField("0");
	txt4.setBounds(193,111,34,34);
	txt4.setFont(new Font("Arial",Font.BOLD,30));
	txt4.setBackground(Color.RED);
	add(txt4);
	txt5=new JTextField("0");
	txt5.setBounds(112,150,34,34);
	txt5.setFont(new Font("Arial",Font.BOLD,30));
	txt5.setBackground(Color.RED);
	add(txt5);
	txt6=new JTextField("0");
	txt6.setBounds(279,150,34,34);
	txt6.setFont(new Font("Arial",Font.BOLD,30));
	txt6.setBackground(Color.RED);
	add(txt6);
	txt7=new JTextField("0");
	txt7.setBounds(112,191,34,34);
	txt7.setFont(new Font("Arial",Font.BOLD,30));
	txt7.setBackground(Color.RED);
	add(txt7);
	txt8=new JTextField("0");
	txt8.setBounds(75,230,34,34);
	txt8.setFont(new Font("Arial",Font.BOLD,30));
	txt8.setBackground(Color.RED);
	add(txt8);
	txt9=new JTextField("0");
	txt9.setBounds(235,230,34,34);
	txt9.setFont(new Font("Arial",Font.BOLD,30));
	txt9.setBackground(Color.RED);
	add(txt9);
	txt10=new JTextField("0");
	txt10.setBounds(279,230,34,34);
	txt10.setFont(new Font("Arial",Font.BOLD,30));
	txt10.setBackground(Color.RED);
	add(txt10);
	txt11=new JTextField("0");
	txt11.setBounds(193,271,34,34);
	txt11.setFont(new Font("Arial",Font.BOLD,30));
	txt11.setBackground(Color.RED);
	add(txt11);
	txt12=new JTextField("0");
	txt12.setBounds(279,271,34,34);
	txt12.setFont(new Font("Arial",Font.BOLD,30));
	txt12.setBackground(Color.RED);
	add(txt12);
	txt13=new JTextField("0");
	txt13.setBounds(235,315,34,34);
	txt13.setFont(new Font("Arial",Font.BOLD,30));
	txt13.setBackground(Color.RED);
	add(txt13);
	txt14=new JTextField("0");
	txt14.setBounds(75,350,34,34);
	txt14.setFont(new Font("Arial",Font.BOLD,30));
	txt14.setBackground(Color.RED);
	add(txt14);
	txt15=new JTextField("0");
	txt15.setBounds(155,350,34,34);
	txt15.setFont(new Font("Arial",Font.BOLD,30));
	txt15.setBackground(Color.RED);
	add(txt15);
	txt16=new JTextField("0");
	txt16.setBounds(350,350,34,34);
	txt16.setFont(new Font("Arial",Font.BOLD,30));
	txt16.setBackground(Color.RED);
	add(txt16);
	txt17=new JTextField("0");
	txt17.setBounds(75,390,34,34);
	txt17.setFont(new Font("Arial",Font.BOLD,30));
	txt17.setBackground(Color.RED);
	add(txt17);
	txt18=new JTextField("0");
	txt18.setBounds(279,390,34,34);
	txt18.setFont(new Font("Arial",Font.BOLD,30));
	txt18.setBackground(Color.RED);
	add(txt18);
}	
public void txtlevel2(){
	txt19=new JTextField("0");
	txt19.setBounds(352,271,34,34);
	txt19.setFont(new Font("Arial",Font.BOLD,30));
	txt19.setBackground(Color.RED);
	add(txt19);

	txt20=new JTextField("0");
	txt20.setBounds(155,315,34,34);
	txt20.setFont(new Font("Arial",Font.BOLD,30));
	txt20.setBackground(Color.RED);
	add(txt20);

	txt21=new JTextField("0");
	txt21.setBounds(40,350,34,34);
	txt21.setFont(new Font("Arial",Font.BOLD,30));
	txt21.setBackground(Color.RED);
	add(txt21);

	txt22=new JTextField("0");
	txt22.setBounds(75,350,34,34);
	txt22.setFont(new Font("Arial",Font.BOLD,30));
	txt22.setBackground(Color.RED);
	add(txt22);

	txt23=new JTextField("0");
	txt23.setBounds(232,350,34,34);
	txt23.setFont(new Font("Arial",Font.BOLD,30));
	txt23.setBackground(Color.RED);
	add(txt23);

	txt24=new JTextField("0");
	txt24.setBounds(315,350,34,34);
	txt24.setFont(new Font("Arial",Font.BOLD,30));
	txt24.setBackground(Color.RED);
	add(txt24);

	txt25=new JTextField("0");
	txt25.setBounds(75,390,34,34);
	txt25.setFont(new Font("Arial",Font.BOLD,30));
	txt25.setBackground(Color.RED);
	add(txt25);

	txt26=new JTextField("0");
	txt26.setBounds(190,390,34,34);
	txt26.setFont(new Font("Arial",Font.BOLD,30));
	txt26.setBackground(Color.RED);
	add(txt26);

	txt27=new JTextField("0");
	txt27.setBounds(280,390,34,34);
	txt27.setFont(new Font("Arial",Font.BOLD,30));
	txt27.setBackground(Color.RED);
	add(txt27);

	txt28=new JTextField("0");
	txt28.setBounds(315,390,34,34);
	txt28.setFont(new Font("Arial",Font.BOLD,30));
	txt28.setBackground(Color.RED);
	add(txt28);
}
public void paintComponent(Graphics g){
	
	super.paintComponent(g);

	Graphics2D g2 = (Graphics2D) g;
    Image img1 = Toolkit.getDefaultToolkit().getImage("level1.png");
	Image img2 = Toolkit.getDefaultToolkit().getImage("level2.png");
	Image img3 = Toolkit.getDefaultToolkit().getImage("level3.png");
	Image img4 = Toolkit.getDefaultToolkit().getImage("sudokufront.png");

	if(front==true){
    g2.drawImage(img4, 0, 0, this);
    //g2.finalize();
	}
	if(level1==true){
    g2.drawImage(img1, 0, 0, this);
    //g2.finalize();
	}
	if(level2==true){
    g2.drawImage(img2, 0, 0, this);
    //g2.finalize();
	}
	if(level3==true){
    g2.drawImage(img3, 0, 0, this);
    //g2.finalize();
	}
	
	repaint();
}
public static void main (String args[]){
	sudoku obj = new sudoku();
	frame.setTitle("Sudoku Challenge");	
	frame.setSize(440,535);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setLocation(450,10);
	frame.add(obj);
}
public void actionPerformed(ActionEvent e){

}
}
