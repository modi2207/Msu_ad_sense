import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;


public class CountdownTimer extends JLabel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private long count;
    private long timerStart;
    JLabel jl;
    Verification v1;
    
    private DateFormat dateFormat;
   
   javax.swing.Timer timer = new javax.swing.Timer(1000, this);
   Calendar cal;

    public CountdownTimer(int minutes, int seconds,Verification v1) {
        // suppose to show as in 30 MIN 30 SEC.
        //super(" ", JLabel.CENTER);
  this.v1=v1;
  this.jl=jl;
         cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, seconds);
        count = cal.getTime().getTime();
     
        dateFormat = new SimpleDateFormat("mm:ss");

      timer.start();
        timerStart = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis()-timerStart;

         
        //System.out.println(elapsedTime);
         

    }
    
      public void actionPerformed(ActionEvent e) {
        // suppose to countdown till 00 MIN 00 SEC
        setText(dateFormat.format(count));
        
        count -= 1000;
        if (dateFormat.format(count).equalsIgnoreCase("00:00")) 
        {
            //closeWindow();
            v1.no=0;
            
            this.setVisible(false);
            v1.tl.setVisible(false);
            v1.jl.setVisible(true);
            
            // jl.setVisible(false);
         
        

        }
        
    }

    public void closeWindow() {

        System.exit(1);

    }

//        public static void main(String[] args) {
//
//        JFrame frame = new JFrame();
//
//        frame.setTitle("Countdown Timer");
//        frame.getContentPane().setBackground(Color.white);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 150);
//
//        JPanel panel = new JPanel();
//        JLabel label = new JLabel("Registration closes in: ");
//        panel.add(label);
//
//        JTextField jTextField = new JTextField();
//        panel.add(jTextField);
//
//        CountdownTimer c = new CountdownTimer(00, 60);
//
//        frame.getContentPane().add(c);
//        frame.setVisible(true);
//        frame.getContentPane().add(panel);
//        frame.setVisible(true);
  //  }
}
