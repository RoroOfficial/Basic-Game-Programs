//AWT
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//IO
import java.io.File;
//SQL
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
//SWING
import javax.swing.UIManager.*;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Main extends JPanel implements ActionListener{
	//FRAME
	static JFrame frame = new JFrame();
	static String RP = "./";
	//SQL
	public Connection con;
	public Statement st;
	public ResultSet res;
	//LABEL
	static JLabel lblname;
	//BUTTON
	static JButton btnplay, btnquit;
	//COMBOBOX
	static JComboBox combotypecontrol, combotypegamemode;
	static String comboitemcontrol, comboitemgamemode = "";
	//FONT
	Font f1 = new Font("Calibri",Font.PLAIN,13);
	//ICON
	Icon icnframeicon = new ImageIcon("images/ic_launcher.png");
	//STRING
	static String control, gamemode;
	
public Main(){
	connect();				//SQL
	conTrol();				//SAVED CONTROL
	gameMode();				//SAVED GAMEMODE
	uiManager();			//DESIGN
	
	setLayout(null);
    
    //PLAY BUTTON
	btnplay = new JButton("Play!");
	btnplay.setBounds(291,370,73,25);
	btnplay.setForeground(Color.BLACK);
	btnplay.addActionListener(this);
	add(btnplay);
	
	//QUIT BUTTON
	btnquit = new JButton("Quit");
	btnquit.setBounds(379,370,73,25);
	btnquit.setForeground(Color.BLACK);
	btnquit.addActionListener(this);
	add(btnquit);
	
	//LABEL
	
	lblname = new JLabel("Control");
	lblname.setBounds(125,255,130,25);
	lblname.setFont(f1);
	lblname.setForeground(Color.BLACK);
	add(lblname);
	
	lblname = new JLabel("Game Mode");
	lblname.setBounds(125,285,130,25);
	lblname.setFont(f1);
	lblname.setForeground(Color.BLACK);
	add(lblname);
	
	//COMBOBOX
	
	combotypecontrol = new JComboBox();
	combotypecontrol.setEditable(false);
	combotypecontrol.addItem("Left Click");
	combotypecontrol.addItem("Enter Key");
	combotypecontrol.setBounds(215, 255, 130, 25);
	combotypecontrol.setFont(f1);
	combotypecontrol.setForeground(Color.BLACK);
	combotypecontrol.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			comboitemcontrol = (String)combotypecontrol.getSelectedItem();	
		}
	});
	add(combotypecontrol);
	
	combotypegamemode = new JComboBox();
	combotypegamemode.setEditable(false);
	combotypegamemode.addItem("Normal");
	combotypegamemode.addItem("Extreme");
	combotypegamemode.setBounds(215, 285, 130, 25);
	combotypegamemode.setFont(f1);
	combotypegamemode.setForeground(Color.BLACK);
	combotypegamemode.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			comboitemgamemode = (String)combotypegamemode.getSelectedItem();	
		}
	});
	add(combotypegamemode);
	
	//CONTROL
	combotypecontrol.setSelectedItem(""+control);
	
	//GAMEMODE
	combotypegamemode.setSelectedItem(""+gamemode);
}

public void paintComponent(Graphics g){   
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	Image icnbg = Toolkit.getDefaultToolkit().getImage("images/bg_main.png");
	
	g2.drawImage(icnbg, 0, 0, this);

	
	//g2.finalize();
    repaint();
}

//UPDATE CONTROL
public void updateControl(){
	try{
		st.executeUpdate("update tblcontrol set Control = '"+ combotypecontrol.getSelectedItem()+"'");
	}
	catch(Exception error){
		JOptionPane.showMessageDialog(null,error);
	}
}

//CONTROL
public void conTrol(){
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

//UPDATE GAMEMODE
public void updateGamemode(){
	try{
		st.executeUpdate("update tblgamemode set GameMode = '"+ combotypegamemode.getSelectedItem()+"'");
	}
	catch(Exception error){
		JOptionPane.showMessageDialog(null,error);
	}
}

//GAMEMODE
public void gameMode(){
	try{
        res = st.executeQuery("select * from tblgamemode");
        if(res.next()){
			gamemode = res.getString("GameMode");
        } 
    }
    catch(Exception error){
        JOptionPane.showMessageDialog(null,error);
    }
}

//CONNECT
public void connect(){
	try{
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbflappybird","root","");
		st = con.createStatement();
	}
	catch(Exception error){
		System.out.println("error: "+error);
	}
} 

public void uiManager(){
	try{
		for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
			if("Nimbus".equals(info.getName())){
				UIManager.setLookAndFeel(info.getClassName());
		        break;
		    }
		    else{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		    }
		}
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(new File(RP +icnframeicon).getCanonicalPath()));
	}
	catch(Exception error){
		// If Nimbus is not available, you can set the GUI to another look and feel.
	}
}

public static void main(String[]args){
	Main obj = new Main();
	frame.setSize(470,434);
	frame.setTitle("Flappy Bird Configuration");
	frame.setResizable(false);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(448,167);
	frame.add(obj);
}

public void actionPerformed(ActionEvent e){
	
	//PLAY BUTTON
	if(e.getSource()==btnplay){
		if(combotypegamemode.getSelectedItem()=="Normal"){
			FlappyBird obj2 = new FlappyBird();
			FlappyBird.frame.setSize(456,628);
			FlappyBird.frame.setTitle("Flappy Bird");
			FlappyBird.frame.setResizable(false);
			FlappyBird.frame.setVisible(true);
			FlappyBird.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FlappyBird.frame.setLocationRelativeTo(null);
			FlappyBird.frame.add(obj2);
				
			if(combotypecontrol.getSelectedItem()=="Left Click"){
				FlappyBird.lblcontrol.setText("Left Click");
			}
			if(combotypecontrol.getSelectedItem()=="Enter Key"){
				FlappyBird.lblcontrol.setText("Enter Key");
			}
		}
		if(combotypegamemode.getSelectedItem()=="Extreme"){
		}
		
		frame.setVisible(false);
		
		try{
			st.executeUpdate("update tblcontrol set Control = '"+ combotypecontrol.getSelectedItem() +"'");
			st.executeUpdate("update tblgamemode set GameMode = '"+ combotypegamemode.getSelectedItem() +"'");
		}
		catch(Exception error){
			JOptionPane.showMessageDialog(null,error);
		}
	}
	
	//QUIT BUTTON
	if(e.getSource()==btnquit){
		System.exit(0);
	}
}
}
