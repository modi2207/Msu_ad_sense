//import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
class Mailer{  
    public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
    	 final String f1=from;
    	 final String p1=password;
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
           Session session = Session.getInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(f1,p1);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  
public class SendMailSSL{   
	 String name,mail;
	int no;
	int id;
	Random rand;
	String faculty,event,pword;
	String sevent;
	public SendMailSSL(String s,String m) {
		name=s;
		mail=m;
	}
	
	public SendMailSSL(String na,String email,String fact,String event,String sevent)
	{
		System.out.println("hello world");
		   mail=email;
		   name=na;
		   faculty=fact;
		   this.event=event;
		   this.sevent=sevent;
	}
	
	public SendMailSSL(String name,String mail,String faculty,String event,int id,String pword)
	{
		System.out.println("hello");
		this.name=name;
		this.mail=mail;
		this.faculty=faculty;
		this.event=event;
		this.pword=pword;
		this.id=id;
		
	} 
   //from,password,to,subject,message  
	void SendMSG()
	{
     Mailer.send("msuadsence2020@gmail.com","msu@2000",mail,"Greetings From AdEx","Dear "+name+",\n" + 
     		"\n" + 
     		"Greetings from\n" + 
     		"AdEx!\n" + 
     		"\n" + 
     		"Thanks for subscribing. You'll now get an email each time when we publish new new post. You will regularly informed by mail.\n" + 
     		"\n" + 
     		"Thanks for the being part of MSU AdEx Family\n" + 
     		"\n" + 
     		"Thank You,\n" + 
     		"MSU AdEx"); 
	}
	
	void send1()
	{
		System.out.println("hello world1");
		Mailer.send("msuadsence2020@gmail.com","msu@2000",mail,"Greetings From AdEx","Dear "+name+",\n" + 
	     		"\n" + 
	     		"Greetings from\n" + 
	     		"AdEx!\n" + 
	     		"\n" + 
	     		"Thanks for participating in "+sevent+" of "+event+" of "+faculty+". You will regularly informed by mail.\n" + 
	     		"\n" + 
	     		"Thanks for the being part of MSU AdEx Family\n" + 
	     		"\n" + 
	     		"Thank You,\n" + 
	     		"MSU AdEx"); 
		
		System.out.println("hello world2");
	}
	int sendOtp()
	{
		try
		{
		rand=new Random();
		no=999+rand.nextInt(9000);
		//"chiragmodi2207@gmail.com","Chirag@2000"
		//"cmodi2207@gmail.com","chirag@123"
		Mailer.send("msuadsence2020@gmail.com","msu@2000",mail,"OTP VERIFICATION","Dear "+name+",\n"+
			    "\n"+"YOUR GENERATED ONE TIME PASSWORD IS\n"+no+"\n"+"THIS OTP IS VALID FOR 60 SECONDS"+"\n"+"Thank You,\n"+"MSU AdEx");
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return no;
	}
	
	void sendotp1()
	{
		System.out.println("hello world");
		//"rockers54019@gmail.com","rollingstar"
		 
		Mailer.send("msuadsence2020@gmail.com","msu@2207",mail,"Greetings From AdEx","Dear "+name+",\n" + 
	     		"\n" + 
	     		"Greetings from\n" + 
	     		"AdEx!\n" + 
	     		"\n" + 
	     		"Thanks for become HEAD of "+event+" of "+faculty+"\n"+"your User ID and Password is given below" +"\n"+
	     		"USER_ID: "+id+"\n"+
	     		"PASSWORD: "+pword+"\n"+
	     		
	     		"Thanks for the being part of MSU AdEx Family\n" + 
	     		"\n" + 
	     		"Thank You,\n" + 
	     		"MSU AdEx"); 
		
	}
	
	
}    