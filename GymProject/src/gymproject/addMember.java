
package GymProject;

/**
 *
 * @author judealaki
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class addMember extends JFrame{
    
 

    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l6;
    JLabel l7;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JButton b;
    JButton b1;
    JComboBox c1;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JPanel p5;
   
    JComboBox cb2;
    JComboBox cb3;
    JComboBox cb4;
    JComboBox cb5;
    
    
    String day[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14"
            ,"15","16","17","18","19","20","21","22","23","24","25","26","27"
            ,"28","29","30","31"};
    String month[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
    String year[]={"2022","2023"};
    String duration[]={"3 months","6 months","1 year"};
    
     public addMember() {
      setTitle("Adding new member");
      setSize(600,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      //getContentPane().setBackground(Color.PINK);
      l1=new JLabel("Enter member's information");
      l1.setFont(new Font("New Times Roman",Font.BOLD,18));
      l1.setForeground(Color.DARK_GRAY);
      l2=new JLabel("Name:");
      l3=new JLabel("Age:");
      l4=new JLabel("Phone number:");
      
      l6=new JLabel("Entry Date:");
      l7=new JLabel("Duration");
      b=new JButton("Save");
      b1=new JButton("Back");
      b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new MemberPage();
          }
      });
      l2.setForeground(Color.DARK_GRAY);
      l3.setForeground(Color.DARK_GRAY);
      l4.setForeground(Color.DARK_GRAY);
      l6.setForeground(Color.DARK_GRAY);
      l7.setForeground(Color.DARK_GRAY);
      b.setForeground(Color.PINK);
      //not working
      //b.setBackground(Color.PINK);
      b1.setForeground(Color.PINK);
      p1=new JPanel();
      p2=new JPanel();
      p3=new JPanel();
      p4=new JPanel();
      p5=new JPanel();
      
      cb2=new JComboBox(day);
      cb3=new JComboBox(month);
      cb4=new JComboBox(year);
      cb5=new JComboBox(duration);
       t2=new JTextField(10);
       t3=new JTextField(10);
       t4=new JTextField(10);
     
      l2.setFont(new Font("New Times Roman",Font.ITALIC,14));
      l3.setFont(new Font("New Times Roman",Font.ITALIC,14));
      l4.setFont(new Font("New Times Roman",Font.ITALIC,14));
      
      l6.setFont(new Font("New Times Roman",Font.ITALIC,14));
      l7.setFont(new Font("New Times Roman",Font.ITALIC,14));
      p5.add(cb2);
      p5.add(cb3);
      p5.add(cb4);
      p1.add(l1);
      p2.setLayout(new GridLayout(5,2,0,8));
      p2.add(l2);
      p2.add(t2);
      p2.add(l3);
      p2.add(t3);
      p2.add(l4);
      p2.add(t4);
      
      p2.add(l6);
      p2.add(p5);
      p2.add(l7);
      p2.add(cb5);
      p3.add(b);
      p3.add(b1);
      p1.setBackground(Color.LIGHT_GRAY);
      p2.setBackground(Color.LIGHT_GRAY);
      p5.setBackground(Color.LIGHT_GRAY);
      p3.setBackground(Color.LIGHT_GRAY);
      p4.setBackground(Color.LIGHT_GRAY);
     add(p1,BorderLayout.NORTH);
     add(p2,BorderLayout.CENTER);
     add(p3,BorderLayout.SOUTH);
     add(p4,BorderLayout.WEST);
     b.addActionListener(new addMem());
    setVisible(true);
      
      
              
      
      
     }
     private class addMem implements ActionListener {
         public void actionPerformed(ActionEvent e)
                 
         { 
         
             try{
                 
            checkTfield();
            checkAge();
            checkPhone();
           addToFile();
           }
             
           catch(handleException h)
           {
               JOptionPane.showMessageDialog(null,h.getMessage());
           }
             
             catch(Exception h)
             {
                 
             }
             
             
             
             
         }

       private void checkAge()throws handleException
     {
         try{
             Integer.parseInt(t3.getText());
         }
         catch(NumberFormatException e )
             {
                 throw new handleException("Age has to be in numbers!");
             }
         if(Integer.parseInt(t3.getText())<0||Integer.parseInt(t3.getText())>100)
         {
             throw new handleException("Age entered is wrong!");}
         
         else if(Integer.parseInt(t3.getText())<12){
             throw new handleException("People under 12 years old are not allowed");}
         
     }
    
     
     private void checkPhone()throws handleException
     {
         
          try
             {
                 Integer.parseInt(t4.getText());
                        
             }
             catch(NumberFormatException e )
             {
                 throw new NumberFormatException("Phone number has to be in numbers!");
             }
         if((t4.getText()).length()!=10)
         {
             throw new handleException("Phone number has to be 10 numbers!");
            
         }
        if((t4.getText().charAt(0))!='0'||(t4.getText().charAt(1))!='5')
        {
            throw new handleException("Phone number has to start with 05!");
        }
            
     } 
     
          private void checkTfield()throws handleException
        {
            if(t2.getText().isEmpty()||t3.getText().isEmpty()
                    ||t4.getText().isEmpty())
            {
                throw new handleException("Please fill all textfields!");
            }

  }
          
             
         public void addToFile()throws IOException
{
    String price="";
             switch (cb5.getSelectedIndex()) {
                 case 0:
                     price="2225 SR";
                     break;
                 case 1:
                     price="3650SR";
                     break;
                 case 2:
                     price="5975 SR";
                     break;
                 
             }
        
   //append in a Trainer file
   FileWriter fw = new FileWriter("Members.txt" , true);
   //to write in the file
   PrintWriter write = new PrintWriter(fw);

   write.println( t2.getText() + "    "  + t3.getText() + "   " + t4.getText()+ "\t" + 
           
             "\t"+cb5.getSelectedItem()+"\t\t"+price+ "\t\t"+cb2.getSelectedItem()+"/"+
           cb3.getSelectedItem()+"/"+cb4.getSelectedItem());
             
           
           write.close();

           
}
         
         
     }}
     
    
 
                  
              
          
             

