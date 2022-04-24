import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


class Sam extends JFrame
{
	 Container con;
	 JScrollPane jsp;
	 JPanel jp,jp1;
	JTextArea jta,jta1;
	JTextField jf[]=new JTextField[100];
	JLabel jl[]=new JLabel[100];
	JPanel jk[]=new JPanel[10];
	 
	Sam()
	{
		con=getContentPane();
		
		con.setLayout(new BorderLayout());
	
	   	   jta=new JTextArea(120,500);

		   jta.setLayout(new BorderLayout());
	 
		  jp=new JPanel();
		  jp.setSize(1000,6000);
		  jp.setBackground(Color.blue);
		
		  jsp=new JScrollPane(jta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		  jp.setLayout(null);
		    for(int i=0;i<100;i++)
			{
			   jl[i]=new JLabel();
			   jl[i].setBounds(100,20+30*i,100,20);
			   jf[i]=new JTextField();
			   jf[i].setBounds(230,20+30*i,100,20);
			   jl[i].setText("HELLO "+i);
			   jp.add(jl[i]);
			   jp.add(jf[i]);
			
			}
			

		      for(int i=0;i<10;i++)
		      {
		    	  
		    	    jk[i]=new JPanel();
		    	    
		    	    jk[i].setBounds(400,100+200*i,100,100);
		    	    jk[i].setBackground(Color.green);
		    	    
		    	    jp.add(jk[i]);
		      }
		  
		  
		  con.add(jsp,BorderLayout.CENTER);
		  
		  jta.add(jp,BorderLayout.CENTER);
	   
	}
}

public class Sample1
{

	  public static void main(String[] st)
	  {
	   
		      Sam s1=new Sam();
		      s1.setVisible(true);
		      s1.setSize(1200,800);
		      
	  }
}

