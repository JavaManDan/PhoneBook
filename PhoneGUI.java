import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class PhoneGUI {
	
	private JFrame frame;
	private JPanel central;
	private JPanel leftContent;
	private JPanel leftPanels;
	
	
	private JPanel MainArea;
	private JPanel topbanner;
	private JPanel topspacer;

	//food items (JButtons) selection on left panel.
	private JButton LookUp;
	private JButton Add;
	private JButton Del;
	private JButton filler;
	private JButton Logo;
	
	private static Image find;
	private static Image add;
	private static Image del;
	private static Image logo;
	
	private JButton send;
	
	private JTextArea jt;
	
	private PhoneDynamics pd;
	
	private JScrollPane sp;
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
			@SuppressWarnings("unused")
			PhoneGUI GUI = new PhoneGUI();
	}


	public PhoneGUI() {
		pd = new PhoneDynamics();
		imageSetup();
		GUILayoutSetup();
		UIManager.put("Panel.background",  new Color(155, 163, 178));
		UIManager.put("OptionPane.background", new Color(155, 163, 178));
		
	}
	
	public void topSetup() {
		JLabel test = new JLabel(" Enter A Name...");
		test.setVerticalAlignment(JLabel.CENTER);
		jt = new JTextArea(test.getText());
		
		jt.setBorder(new LineBorder(Color.BLACK));
		jt.setPreferredSize(new Dimension(250,40));
		Font font = new Font("Calibri", Font.BOLD, 20);
		jt.setFont(font);
	
		// search btn
	    send = new JButton("Search");
	    send.setBackground(Color.LIGHT_GRAY);
	    send.setFont(font);
		send.addActionListener(e -> search());
		send.setPreferredSize(new Dimension(65,40));
		send.setBorder(new LineBorder(Color.BLACK));
		send.setFocusPainted(false);
		
		//TODO center text and make it not hug the wall?
	
	}
	
	public void search() {
		System.out.println(jt.getText());
		MainArea.removeAll();
		int MainAreaSize = 0;
		MainArea.setLayout(new FlowLayout());
		//search the match
		pd.searchMatch(jt.getText());
		
		for(JTextArea j : pd.addToo()) {
			
			  j.setPreferredSize(new Dimension(310,40));
	
			  MainArea.add(j);
			  MainAreaSize++;
		 }
		
		MainArea.setPreferredSize(new Dimension(320,46 * MainAreaSize));
		
		
		GUI_Refresh();
		
	}
	
	public void getAll() {
		System.out.println(jt.getText());
		jt.setText("");
		MainArea.removeAll();
		int MainAreaSize = 0;
		MainArea.setLayout(new FlowLayout());
		//search the match
		pd.getAll();
		boolean caretPos = true;
		for(JTextArea j : pd.addToo()) {
			  if(caretPos) {
				  //sets the scroll bar back at top instead of relative to bottom text area
				  j.setCaretPosition(0);
				  caretPos = false;
			  }
			  j.setPreferredSize(new Dimension(310,40));
			  
			  MainArea.add(j);
			  MainAreaSize++;
		 }
		
		MainArea.setPreferredSize(new Dimension(320,46 * MainAreaSize));
		
		
		GUI_Refresh();
		
	}
	
	
	
	public void imageSetup() {
		
		java.net.URL img1 = getClass().getResource("/find.PNG");
		find = Toolkit.getDefaultToolkit().getImage(img1);
		
		java.net.URL img2 = getClass().getResource("/add.PNG");
		add = Toolkit.getDefaultToolkit().getImage(img2);
		
		java.net.URL img3 = getClass().getResource("/del.PNG");
		del = Toolkit.getDefaultToolkit().getImage(img3);
		
		java.net.URL img4 = getClass().getResource("/logo.PNG");
		logo = Toolkit.getDefaultToolkit().getImage(img4);
			
	}
	
	public boolean passInfo( String name, String phone) {
		return pd.addToArray(name , phone);
		
	
	}
	
	public void addContactPopUp() {
		UIManager.put("Panel.background",  new Color(155, 163, 178));
		UIManager.put("OptionPane.background", new Color(155, 163, 178));
		JPanel userInput = new JPanel();
		userInput.setLayout(new GridLayout(6,1,7,7));
		JTextArea name = new JTextArea();
		JTextArea phone = new JTextArea();
		JButton btn = new JButton("ADD");
		//btn.addActionListener(e -> passInfo(name.getText(), phone.getText()));
		JLabel noNum = new JLabel("Only names with alphabetic characters are valid");
		JLabel nameL = new JLabel("Enter Name :");
		userInput.add(nameL);
		nameL.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.add(name);
		name.setPreferredSize(new Dimension(140,20));
		name.setBorder(new LineBorder(Color.BLACK));
		JLabel phoneL = new JLabel("Enter Phone :");
		userInput.add(phoneL);
		phoneL.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.add(phone);
		phone.setPreferredSize(new Dimension(140,20));
		phone.setBorder(new LineBorder(Color.BLACK));
		//userInput.add(btn);
		btn.setPreferredSize(new Dimension(60,20));
		btn.setBorder(new LineBorder(Color.BLACK));		
		Object[] adding = {btn};
		userInput.add(noNum);
		
		JOptionPane pane = new JOptionPane();
		pane.setMessage(userInput);
		pane.setOptions(adding);
		pane.setMessageType(JOptionPane.PLAIN_MESSAGE);
		
		JDialog jd = pane.createDialog(MainArea, "Add Contact:");		
		jd.setLocationRelativeTo(sp);
		
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				jd.dispose();
				UIManager.put("Panel.background",  new Color(144, 255, 130));
				UIManager.put("OptionPane.background", new Color(144, 255, 130));
				jd.dispose();
				if(passInfo(name.getText(), phone.getText())) {
				JOptionPane conf = new JOptionPane();
				JLabel jl = new JLabel("Successfully Added");
				jl.setHorizontalAlignment(SwingConstants.CENTER);
				conf.setMessage(jl);
				conf.setMessageType(JOptionPane.PLAIN_MESSAGE);
				JDialog outro = conf.createDialog(MainArea, "Added");
				
				outro.setLocationRelativeTo(sp);
				outro.setVisible(true);
				
				}
			}
		});
        
        
		jd.setVisible(true);
		
		
	}
	
	public void deleteRecord() {
		UIManager.put("Panel.background",  new Color(255, 132, 132));
		UIManager.put("OptionPane.background", new Color(255, 132, 132));
		JPanel userInput = new JPanel();
		userInput.setLayout(new GridLayout(5,1,7,7));
		JTextArea name = new JTextArea();
		JTextArea phone = new JTextArea();
		JButton btn = new JButton("Delete");
		//btn.addActionListener(e -> passInfo(name.getText(), phone.getText()));
		
		JLabel nameL = new JLabel("Enter Name :");
		userInput.add(nameL);
		nameL.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.add(name);
		name.setPreferredSize(new Dimension(140,20));
		name.setBorder(new LineBorder(Color.BLACK));
		JLabel phoneL = new JLabel("Enter Phone :");
		userInput.add(phoneL);
		phoneL.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.add(phone);
		phone.setPreferredSize(new Dimension(140,20));
		phone.setBorder(new LineBorder(Color.BLACK));
		//userInput.add(btn);
		btn.setPreferredSize(new Dimension(60,20));
		btn.setBorder(new LineBorder(Color.BLACK));		
		Object[] adding = {btn};
		
		JOptionPane pane = new JOptionPane();
		
		pane.setMessage(userInput);
		pane.setOptions(adding);
		pane.setMessageType(JOptionPane.PLAIN_MESSAGE);
		
		JDialog jd = pane.createDialog(MainArea, "Delete Contact:");
		jd.setLocationRelativeTo(sp);
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub			
				jd.dispose();
				if(pd.delArrayIndex(name.getText(), phone.getText())) {
				UIManager.put("Panel.background",  new Color(144, 255, 130));
				UIManager.put("OptionPane.background", new Color(144, 255, 130));
				MainArea.removeAll();
				GUI_Refresh();
				JOptionPane conf = new JOptionPane();
				JLabel jl = new JLabel("Successfully Deleted");
				jl.setHorizontalAlignment(SwingConstants.CENTER);
				conf.setMessage(jl);
				conf.setMessageType(JOptionPane.PLAIN_MESSAGE);
				JDialog outro = conf.createDialog(MainArea, "Deleted");
				outro.setLocationRelativeTo(sp);
				outro.setVisible(true);
				
				}
				
			}
		});
        
        
		jd.setVisible(true);
		
	}
	

	public void GUILayoutSetup() {
		frame = new JFrame("Improved Java PhoneBook");
		LookUp = new JButton();
		Add = new JButton();
		Del = new JButton();
		Logo = new JButton();
		filler = new JButton();
		
		MainArea = new JPanel();
		MainArea.setBackground(new Color(197, 205, 219));
		topbanner = new JPanel();
		topbanner.setBackground(new Color(155, 163, 178));
		topspacer = new JPanel();
		
		central = new JPanel();
		leftContent = new JPanel();
		leftPanels = new JPanel();
		
		//jt area steup
		topSetup();
		
	    frame.setLayout(new BorderLayout());
	    central.setBorder(new LineBorder(Color.BLACK, 1));	
	    central.setLayout(new FlowLayout());
	   
	    //everything will be added to frame all layout managers and jpanels etc...
	
	    //will contain the food items...
	    leftContent.setBorder(new LineBorder(Color.BLACK));
	    leftContent.setBackground(Color.WHITE);
	    //will be left of screen WEST.
	    frame.add(leftContent, BorderLayout.WEST);
	    //set preffered dimension.
	    leftContent.setPreferredSize(new Dimension(110, 575));
	    leftPanels.setBorder(new LineBorder(Color.BLACK));
	    leftPanels.setLayout(new GridLayout(4,1));
	    //all our buttons...
	    leftPanels.add(LookUp);
	    LookUp.setIcon(new ImageIcon(find));
	    leftPanels.add(Add);
	    Add.addActionListener(e -> addContactPopUp());
	    Add.setIcon(new ImageIcon(add));
	    leftPanels.add(Del);
	    Del.setIcon(new ImageIcon(del)); 
	    Del.addActionListener(e -> deleteRecord());
	    leftPanels.add(Logo);
	    Logo.setIcon(new ImageIcon(logo));
	    Logo.addActionListener(e -> getAll());
	
	    MainArea.setLayout(new GridLayout(3,3,7,7 ));
	    
	    //add all leftpanel stuff to leftcontent container.
	    leftPanels.setPreferredSize(new Dimension(92, 390));
	    leftContent.add(leftPanels);
	     
	    topbanner.setBorder(new LineBorder(Color.BLACK));
	    //topspacer.setBorder(new LineBorder(Color.BLACK));
	    MainArea.setBorder(new LineBorder(Color.BLACK));	   
	    //GUIMainAreaColor();
	    
	    //set our sizes...
	    //the part that allows scrolling must be bigger than the sp e.g main area cant be same size as sp
	    sp = new JScrollPane(MainArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    sp.setPreferredSize(new Dimension(340,400));
	    sp.setBorder(new LineBorder(Color.BLACK));
	    MainArea.setPreferredSize(new Dimension(320,400));
	    
	   
	
	    topspacer.setPreferredSize(new Dimension(340,12));
	    topbanner.setPreferredSize(new Dimension(340, 97));
	    
	    central.add(topbanner);
	    topbanner.setLayout(new FlowLayout());
	    
	    topbanner.add(jt);
	    topbanner.add(send);
	    
	    central.add(topspacer);
	    central.add(sp);	
	    
	    leftContent.setBackground(new Color(4, 24, 58));
	    central.setBackground(new Color(112, 161, 255));
	    topspacer.setBackground(new Color(112, 161, 255));
	    //add all our stuff to the frame so it can be seen.
	    frame.add(central, BorderLayout.CENTER);
	    frame.setSize(480,575);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    GUI_Refresh();
	    
	 	    
	}
	
	public void GUI_Refresh() {
		frame.setVisible(true);	
		frame.repaint();
	}
	
	

}
