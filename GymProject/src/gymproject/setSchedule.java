/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author judealaki
 */
public class setSchedule extends JFrame{
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    //JLabel l5;  
    JTextField t2;
    JTextField t3;
    JTextField t4;
//    JTextField t5;   
    JButton b1;
    JButton b2;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    public setSchedule()
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("Set schedule");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        l1=new JLabel("Set schedule");
        l1.setFont(new Font("Serif", Font.BOLD, 18));
        l1.setForeground(Color.DARK_GRAY);
        l2=new JLabel("Yoga");
        l3=new JLabel("Dumbbell");
        l4=new JLabel("Cardio");
//        l5=new JLabel("Tabata");
        l2.setForeground(Color.darkGray);
        l3.setForeground(Color.darkGray);
        l4.setForeground(Color.darkGray);
//        l5.setForeground(Color.darkGray);
        l2.setFont(new Font("New Times Roman",Font.ITALIC,14));
        l3.setFont(new Font("New Times Roman",Font.ITALIC,14));
        l4.setFont(new Font("New Times Roman",Font.ITALIC,14));
//        l5.setFont(new Font("New Times Roman",Font.ITALIC,14));
        t2=new JTextField(6);
        t3=new JTextField(6);
        t4=new JTextField(6);
//        t5=new JTextField(6);
        b1=new JButton("Save");
        b2=new JButton("Back");
        b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new Schedule();
          } });
              
        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2));
        p3=new JPanel();
        p1=new JPanel();
        b1.setForeground(Color.PINK);
        b2.setForeground(Color.PINK);
        p3.add(b1);
        p3.add(b2);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
//        p2.add(l5);
      //  p2.add(t5);
        p1.add(l1);
        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.LIGHT_GRAY);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        b1.addActionListener(new buttonListener());
        
        setVisible(true);
        
    
     
    }
    private class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent a)
        {
           try{
            checkTfield();
            checkTrainer();
            setSched();
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null,e.getMessage());
          
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
        
        private void checkTrainer() throws handleException, IOException
        {
           boolean flag2=false,flag3=false,flag4=false;
            try{
            File file = new File("Trainer.txt");
//       Scanner read = new Scanner(file);
       FileReader fr=new FileReader(file);
       BufferedReader br=new BufferedReader(fr);
       
       String str;
       while((str=br.readLine())!=null){
           if (str.contains(t2.getText()))
           {
               flag2=true;
               
                       
           }
           else if(str.contains(t3.getText()))
           {
               flag3=true;
               
           }
           else if(str.contains(t4.getText()))
           {
               flag4=true;
               
           }
       }
       if(!flag2)
       {
           throw new handleException("Trainer not found"); 
                       
       }
       if(!flag3)
       {
        throw new handleException("Trainer not found");    
       }
       if(!flag4)
       {
           throw new handleException("Trainer not found"); 
       }
            }
           catch(FileNotFoundException e)
               {
               }
    
           
    
        }
    
     
        private void setSched() throws IOException
        {
             //append in a Trainer file
   FileWriter fw = new FileWriter("Schedule.txt" , true);
   //to write in the file
   PrintWriter write = new PrintWriter(fw);

   write.println("Yoga: "+t2.getText()+"\nDumbbbell: "+t3.getText()+"\nCardio:"+
           t4.getText());
           
           write.close();

        }
     }
}