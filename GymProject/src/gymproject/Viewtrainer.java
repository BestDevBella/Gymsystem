/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


public class Viewtrainer extends JFrame {

    JLabel l1;
    JTextField t1;
    JPanel p1;
    JButton b1;
    JButton b2;
    JPanel p2;
    JPanel p3;

    public Viewtrainer() {
        setTitle("View trainer info");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        l1 = new JLabel("Enter the trainer's name: ");
        l1.setFont(new Font("Serif", Font.BOLD, 18));
        l1.setForeground(Color.DARK_GRAY);
        t1 = new JTextField(10);
        b1 = new JButton("Search");
        b1.setForeground(Color.pink);
        //b1.setBackground(Color.PINK);
        b2=new JButton("Back");
        b2.setForeground(Color.pink);
        b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new Accesstrainer();
          } });
        p1=new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);
        p1.setBackground(Color.LIGHT_GRAY);
        p2=new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        p3=new JPanel();
        p3.setBackground(Color.LIGHT_GRAY);
       b1.addActionListener(new getinfo());
        p3.add(b2);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        
       
        setVisible(true);
    }
    private class getinfo implements ActionListener{
    
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
        
}
        public void readFile()throws IOException,handleException
    {
        boolean flag=true;
       //header
   
    try{
        
    
       File file = new File("Trainer.txt");
//       Scanner read = new Scanner(file);
       FileReader fr=new FileReader(file);
       BufferedReader br=new BufferedReader(fr);
    
       String str;
       while((str=br.readLine())!=null){
           if (str.contains(t1.getText()))
           {

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
               throw new handleException("Trainer not found!");
           }
    
           
         
}
    }
    

