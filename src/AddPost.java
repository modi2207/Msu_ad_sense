import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



class Post extends JFrame implements ActionListener,ItemListener
{
	 Container c;
	 JComboBox faculty_jcb,event_jcb;
	 JLabel select_img,select_faculty,select_event,p_name,img_lab;
	 JFileChooser jf;
	 JPanel tp,lp,rp;
	 JTextField img_text,post_text;
	 JTextArea description;
	 JButton jb,jb1,jb2;
	 Font f;
	 BufferedImage img=null;
	 JScrollPane jsp,jsp1;
	 String fa[]={"FACULTY OF ARTS","FACULTY OF SCIENCE","FACULTY OF EDUCATION AND PSYCHOLOGY","FACULY OF COMMERCE","FACULTY OF MEDICINE","FACULTY OF TECHNOLOGY AND ENGINEERING","FACULTY OF LAW","FACULTY OF FINE ARTS","FACULTY OF FAMILTY AND COMMUNITY SCIENCES","FACULTY OF SOCIAL WORK","FACULY OF PERFORMING ARTS","FACULTY OF MANAGEMENT STUDIES","FACULY OF JOURNALISM AND COMMUNICATION","BARODA SANSKRIT MAHAVIDYALAYA"};
	 
	 Post()
	 {
		c=getContentPane();
		c.setLayout(null);
		tp=new JPanel();
		rp=new JPanel();
//	    //jsp=new JScrollPane(rp);
//	    //jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	    //jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//	    //jsp.setPreferredSize(new Dimension(1000,800));
	  
	    // jsp.setPreferredSize(new Dimension(300,190));
		
		jsp1=new JScrollPane(rp,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(100,100,1050,800);
		description=new JTextArea();
		event_jcb=new JComboBox();
		jb1=new JButton("SHOW");
		
		f=new Font("Aerial",Font.BOLD,20);
		lp=new JPanel();
		
		tp.setBounds(0,0,1200,100);
		tp.setBackground(Color.gray);
		//rp.setBounds(100,100,1100,900);
		rp.setBackground(Color.cyan);
	    lp.setBounds(0,100,100,900);
		lp.setBackground(Color.black);
		faculty_jcb=new JComboBox();
		post_text=new JTextField();
		post_text.setBounds(360,150,200,20);
		rp.setLayout(null);
		faculty_jcb.setBounds(360,50,200,20);
	  
		 for(int i=0;i<fa.length;i++)
		 {
			faculty_jcb.addItem(fa[i]); 
		 }
		select_img=new JLabel("SELECT IMAGE FILE:- ");
		select_faculty=new JLabel("CHOOSE FACULTY:- ");
		select_event=new JLabel("CHOOSE EVENT:- ");
		p_name=new JLabel("POST NAME:- ");
		p_name.setBounds(50,150,300,20);
		p_name.setFont(f);
		select_event.setFont(f);
		select_faculty.setFont(f);
		select_event.setBounds(50,100,300,20);
		select_faculty.setBounds(50,50,300,20);
		select_img.setBounds(50,200,300,20);
		//select_img.setForeground(Color.gray);
		select_img.setFont(f);
		img_text=new JTextField();
		img_text.setBounds(360,200,300,20);
		jb=new JButton("CHOOSE FILE");
	    jb2=new JButton("SUBMIT");
	    jb2.setBounds(300,400,100,20);
	     
		jb.setBounds(680,200,150,20);
		jb1.setBounds(850,200,100,20);
		jb1.addActionListener(this);
		jf=new JFileChooser();
		jf.setCurrentDirectory(new File(System.getProperty("user.home")));
	
        jb.addActionListener(this); 
        int index=faculty_jcb.getSelectedIndex();
        //System.out.println(index);
        event_jcb.setEnabled(false);
        faculty_jcb.addItemListener(this);
        event_jcb.setBounds(360,100,200,20);
       
//         img_lab=new JLabel();
//         
//         img_lab.setIcon(new ImageIcon("src//img2.jpg"));
         
		//	img_lab.setBounds(50,300,1050,500);
        
   	  img_lab=new JLabel();
	  img_lab.setBounds(50,240,500,600);
	  img_lab.setVisible(false);
     
      JScrollPane jsp=new JScrollPane(description,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      jsp.setBounds(550,240,500,300);
     
     jb2.addActionListener(this);  
	 //rp.add(img_lab);
		 rp.add(img_lab);
		rp.add(jf);
		rp.add(img_text);
		rp.add(select_event);
		rp.add(faculty_jcb);
		rp.add(event_jcb);
	    rp.add(select_img);
	    rp.add(jb);
	    rp.add(select_faculty);
	    rp.add(p_name);
	    rp.add(post_text);
	    rp.add(jb1);
	    rp.add(jb2);
	   // rp.add(description);
	    rp.add(jsp);
	    c.add(tp);
	    c.add(jsp1);
	    c.add(lp);
	    //c.add(jsp);
	    
	   // c.add(jsp);
		  
	}
	 public static BufferedImage resizeImage(final Image image, int width, int height) {
	        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        final Graphics2D graphics2D = bufferedImage.createGraphics();
	        graphics2D.setComposite(AlphaComposite.Src);
	        //below three lines are for RenderingHints for better image quality at cost of higher processing time
	        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
	        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        graphics2D.drawImage(image, 0, 0, width, height, null);
	        graphics2D.dispose();
	        return bufferedImage;
	    }

	 public void actionPerformed(ActionEvent ae)
	 {
		String na=ae.getActionCommand();
		if(na.equals("CHOOSE FILE"))
		{
			jf.showOpenDialog(this);		
			File f=jf.getSelectedFile();
			System.out.println(f.toString());
			img_text.setText(f.toString());
		}
		else if(na.equals("SHOW"))
		{
			String ta=img_text.getText();
			
		      img_lab.setIcon(new ImageIcon(ta));
		    
		  img_lab.setVisible(true);
		}
		else if(na.equals("SUBMIT"))
		{
			
			  
			   
		}
		
	 }
	 
	 public void itemStateChanged(ItemEvent ie)
	 {
		 //System.out.print(ie.getItem());
		 
		     String temp=ie.getItem().toString();
			  event_jcb.setEnabled(true);
			  event_jcb.removeAllItems();
			  File f=new File("C:\\proj_java\\"+temp);
			  String event[]=f.list();
			  for(int i=0;i<event.length;i++)
			  {
				    event_jcb.addItem(event[i]);
			  }
		  }
		  
		 
	 }

public class AddPost 
{
	public static void main(String[] st)
	{
		  
		          Post p=new Post();
		          p.setVisible(true);
		          p.setSize(1200,1000);
	              
	}

}
