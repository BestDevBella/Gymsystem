/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymProject;

/**
 *
 * @author Bylsan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.event.*;

public class Assign extends JFrame {

    private JLabel l1;
    private JLabel l2;
    private JRadioButton Yoga;
    private JRadioButton  Cardio;
    private JRadioButton  Dumbbell;
    private JTextField f1;
    private ButtonGroup gp;

    private JButton b1;
    private JButton b2;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    public Assign() {
        setTitle("Assign members");
        setSize(600, 300);
        setLayout(new BorderLayout(5,50));
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        p1 = new JPanel();
        l1 = new JLabel("Assign member to workout ");
        l1.setFont(new Font("Serif",Font.BOLD,18));
        l1.setForeground(Color.darkGray);
        l2=new JLabel("Member's name:");
        l2.setFont(new Font("New Times Roman",Font.ITALIC,14));
        l2.setForeground(Color.darkGray);
        p1.add(l1);
        add(p1, BorderLayout.NORTH);
        buildinfo();
        add(p2, BorderLayout.CENTER);
        p3 = new JPanel();
        b1 = new JButton("Save");
        b1.addActionListener(new listener());
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.PINK);
        b2=new JButton("Back");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.PINK);
        b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new Schedule();
          }
      });
        b2.setForeground(Color.PINK);
        p3.add(b2);
        p3.add(b1);
        add(p3, BorderLayout.SOUTH);
        p1.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.LIGHT_GRAY);

        setVisible(true);

    }

    public void buildinfo() {
        p2=new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        
        f1 = new JTextField(10);
        Yoga = new JRadioButton ("Yoga");
        Yoga.setBackground(Color.LIGHT_GRAY);
        Dumbbell = new JRadioButton ("Dumbbell");
        Dumbbell.setBackground(Color.LIGHT_GRAY);
        Cardio = new JRadioButton ("Cardio");
        Cardio.setBackground(Color.LIGHT_GRAY);
        Font newRadioButtonFont=new Font(Yoga.getFont().getName(),Font.BOLD,Yoga.getFont().getSize());
        Font newRadioButtonFont2=new Font(Dumbbell.getFont().getName(),Font.BOLD,Dumbbell.getFont().getSize());
        Font newRadioButtonFont3=new Font(Cardio.getFont().getName(),Font.BOLD,Cardio.getFont().getSize());
        Yoga.setFont( newRadioButtonFont);
        Dumbbell.setFont( newRadioButtonFont2);
        Cardio.setFont( newRadioButtonFont3);
        Yoga.setForeground(Color.gray);
        Dumbbell.setForeground(Color.gray);
        Cardio.setForeground(Color.gray);
        gp=new ButtonGroup();
        gp.add(Yoga);
        gp.add(Dumbbell);
        gp.add(Cardio);
        p2.add(l2);
        p2.add(f1);
        p2.add(Yoga);
        p2.add(Dumbbell);
        p2.add(Cardio);

    }
    private class listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
           try{
                 
            
           addToFile();
           selected();
           }
             
          
             catch(Exception b)
             {
                JOptionPane.showMessageDialog(null,b.getMessage());
          
             }
        }
        public void selected()throws handleException
        {
           if (!(Yoga.isSelected())&&!(Dumbbell.isSelected())&&Cardio.isSelected())
           {
               throw new handleException("Select a class!");
           }
        }
        public void addToFile()throws IOException,handleException{
            String input=f1.getText();
            boolean flag=true;
            try{
  
       File file = new File("Members.txt");
//       Scanner read = new Scanner(file);
       FileReader fr=new FileReader(file);
       BufferedReader br=new BufferedReader(fr);
    
       String str;
       while((str=br.readLine())!=null){
           if (str.contains(input))
           {
               if(Yoga.isSelected()){
                 FileWriter fw = new FileWriter("Yoga.txt" , true);
             PrintWriter write = new PrintWriter(fw);
              write.println(input+"\t");
               write.close();
               flag=false;
             }
             else if(Dumbbell.isSelected()){
                 FileWriter fw = new FileWriter("Dumbbell.txt" , true);
             PrintWriter write = new PrintWriter(fw);
              write.println(input+"\t");
               write.close();
               flag=false;
             }
             else if(Cardio.isSelected()){
                 FileWriter fw = new FileWriter("Cardio.txt" , true);
             PrintWriter write = new PrintWriter(fw);
              write.println(input+"\t");
               write.close();
               flag=false;
             }
                 
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
    

