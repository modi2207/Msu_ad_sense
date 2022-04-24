import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;



class Terms extends JFrame implements ActionListener
{
	JPanel tp,main,title;
	Container con;
	JButton close,minimize;
	JScrollPane jsp;
	Font f1;
	JLabel tit;
	JTextArea tx;
	Terms()
	{
		
		this.setUndecorated(true);
		this.setLocation(500,300);
		this.setBackground(Color.gray);
		con=getContentPane();
		con.setLayout(null);
	   
		f1=new Font("TimesRoman",Font.BOLD,30);
		tp=new JPanel();
        tp.setBounds(0,0,600,50);
		tp.setBackground(Color.BLUE);
		tp.setLayout(null);
		
		main=new JPanel();
		main.setBounds(0,100,600,500);
		main.setBackground(Color.darkGray);
		
		title=new JPanel();
		title.setBackground(Color.LIGHT_GRAY);
		title.setBounds(0,50,600,50);
		
		title.setLayout(null);
		
		tit=new JLabel();
		tit.setText("TERMS & CONDITION");
        tit.setFont(f1);
        tit.setBounds(150,10,400,30);
        tit.setForeground(Color.WHITE);
		
		   close=new JButton();
	       close.setBounds(0,0,30,30);
	       close.setBorder(new LineBorder(Color.red,1));
	       close.setActionCommand("cl");
	       close.setFocusable(false);
	       close.setBackground(Color.black);
	       close.setToolTipText("CLOSE");
	       
	       
	       
	       minimize=new JButton();
	       minimize.setBounds(40,0,30,30);
	       minimize.setBorder(new LineBorder(Color.YELLOW,1));
	       minimize.setActionCommand("mm");
	       minimize.setFocusable(false);
	       minimize.setBackground(Color.black);
	       minimize.setToolTipText("MINIMIZE");
	       main.setLayout(null);
	       
	       tx=new JTextArea(600,700);
	       tx.setBackground(Color.DARK_GRAY);
	       tx.setForeground(Color.white);
	       tx.setText("The registration begins with the click on the registration button on the respective eco event website containing the event information. The event information noted on this website as well as brochures, invitations or newsletters does not represent a binding offer from eco. It represents a request from eco to the participant to make a binding offer to eco with the registration.");
	       jsp=new JScrollPane(tx,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	       jsp.setBounds(0,0,600,300);
	       tx.setLineWrap(true);
		   tx.setWrapStyleWord(true);
			
	      
		con.add(tp);
		con.add(main);
		con.add(title);
		tp.add(close);
		tp.add(minimize);
	    title.add(tit);
		main.add(jsp);
	    close.addActionListener(this);
	    minimize.addActionListener(this);
	    
	    close.addMouseListener(new MouseListener()
	    {
	    	 public void mouseEntered(MouseEvent me)
	    	 {
	    		 if(me.getSource().equals(close))
	    		 {
	    			 close.setBackground(Color.RED);
	    		 }
	    		 else if(me.getSource().equals(minimize))
	    		 {
	    			 minimize.setBackground(Color.yellow);
	    		 }
	    	 }
	    	 public void mouseClicked(MouseEvent me)
	    	 {
	    		 
	    	 }
	    	 public void mouseExited(MouseEvent me)
	    	 {
	    		 if(me.getSource().equals(close))
	    		 {
	    			  close.setBackground(Color.black);
	    		 }
	    		 else if(me.getSource().equals(minimize))
	    		 {
	    			 minimize.setBackground(Color.black);
	    		 }
	    	 }
	    	 public void mouseReleased(MouseEvent me)
	    	 {
	    		  
	    	 }
	    	 public void mousePressed(MouseEvent me)
	    	 {
	    		 
	    	 }
	    });
	    	
	    minimize.addMouseListener(new MouseListener()
	    {
	    	 public void mouseEntered(MouseEvent me)
	    	 {
	    		 if(me.getSource().equals(close))
	    		 {
	    			 close.setBackground(Color.RED);
	    		 }
	    		 else if(me.getSource().equals(minimize))
	    		 {
	    			 minimize.setBackground(Color.yellow);
	    		 }
	    	 }
	    	 public void mouseClicked(MouseEvent me)
	    	 {
	    		 
	    	 }
	    	 public void mouseExited(MouseEvent me)
	    	 {
	    		 if(me.getSource().equals(close))
	    		 {
	    			  close.setBackground(Color.black);
	    		 }
	    		 else if(me.getSource().equals(minimize))
	    		 {
	    			 minimize.setBackground(Color.black);
	    		 }
	    	 }
	    	 public void mouseReleased(MouseEvent me)
	    	 {
	    		  
	    	 }
	    	 public void mousePressed(MouseEvent me)
	    	 {
	    		 
	    	 }
	    });
	
	    
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().toString().equals("cl"))
		{
			 this.dispose();
		}
		else if(ae.getActionCommand().toString().equals("mm"))
		{
			setState(this.ICONIFIED);
		}
		   
	}
}
