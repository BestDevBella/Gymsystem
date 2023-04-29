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
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author judealaki
 */
public class getMemInfo extends JFrame{
    JLabel l1;
    JTextField t1;
    JButton b1;
    JButton b2;
    JPanel p1;
    JPanel p2;
    JPanel p3;
//    JLabel l2;
//    JLabel l3;
//    JLabel l4;
//    JLabel l5;
//    JLabel l6;
   
    
    public getMemInfo(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("View members' info");
       
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        l1=new JLabel("Enter the member's name:");
        l1.setForeground(Color.darkGray);
        l1.setFont(new Font("Serif",Font.BOLD,18));
        //setBackground(Color.LIGHT_GRAY);
        t1=new JTextField(10);
        b1=new JButton("Search");
        b2=new JButton("Back");
        b1.setForeground(Color.PINK);
        b2.setForeground(Color.PINK);
        b2.addActionListener(new ActionListener(){
        
          public void actionPerformed(ActionEvent e){
              new MemberPage();
          }
      });
       

        
        
      p1=new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        p1.add (l1);
        p1.add(t1);
        p1.add(b1);
        p1.setBackground(Color.LIGHT_GRAY);
        p2=new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        p2=new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        p3=new JPanel();
        p3.setBackground(Color.LIGHT_GRAY);
        b1.addActionListener(new getInfo());
        p3.add(b2);
        add(p2,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
       
        
        setVisible(true);
    }
    
    
    
    private class getInfo implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           
            try {
                if (t1.getText().isEmpty())
                {
                    throw new handleException("Write a name!");
                }
                    
                readFile();
            }
            catch (Exception h) {
                JOptionPane.showMessageDialog(null, h.getMessage()  );
            }
            
        }
        
        
        public void readFile()throws IOException,handleException
    {
        boolean flag=true;
       //header
   
    try{
        
    
       File file = new File("Members.txt");
//       Scanner read = new Scanner(file);
       FileReader fr=new FileReader(file);
       BufferedReader br=new BufferedReader(fr);
    
       String str;
       while((str=br.readLine())!=null){
           if (str.contains(t1.getText()))
           {
//               JOptionPane.showMessageDialog(null,"NAME\tAGE\tPHONE\t\tDURATION"
//                       + "\tENTRY DATE\tPRICE\n"+str);
                  JOptionPane.showMessageDialog(null,str);
               flag=false;
           }
       }
    }
           catch(FileNotFoundException e)
               {
               }
    
               if (flag)
           {
               throw new handleException("Member not found!");
           }
    
           
         
}
    }
}
