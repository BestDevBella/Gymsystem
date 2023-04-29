/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymProject;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Addtrainer extends JFrame {

    private JLabel l1;
    private JLabel namelabel;
    private JLabel agelabel;
    private JLabel numberlabel;
    private JTextField f1;
    private JTextField f2;
    private JTextField f3;
    private JButton b1;
    private JButton b2;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    public Addtrainer() {
        setTitle("Adding new trainer");
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        p1 = new JPanel();
        l1 = new JLabel("Enter trainer's information");
        l1.setFont(new Font("New Times Roman", Font.BOLD, 18));
        l1.setForeground(Color.DARK_GRAY);
        p1.add(l1);
        add(p1, BorderLayout.NORTH);
        buildinfo();
        add(p2, BorderLayout.CENTER);
        p3 = new JPanel();
        b1 = new JButton("Save");
       // b1.setBackground(Color.PINK);
        b1.setForeground(Color.pink);
        b2=new JButton("Back");
        b2.setForeground(Color.pink);
        p3.add(b1);
        p3.add(b2);
        b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new Accesstrainer();
          }
      });
        add(p3, BorderLayout.SOUTH);
        p1.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.LIGHT_GRAY);
        b1.addActionListener(new addtra());
        setVisible(true);

    }

    public void buildinfo() {
        p2 = new JPanel(new GridLayout(3, 2, 20, 25));
        namelabel = new JLabel(" Name: ");
        namelabel.setForeground(Color.DARK_GRAY);
        namelabel.setFont(new Font("New Times Roman", Font.ITALIC, 18));
        f1 = new JTextField(10);
        p2.add(namelabel);
        p2.add(f1);
        agelabel = new JLabel(" Age: ");
        agelabel.setForeground(Color.DARK_GRAY);
        agelabel.setFont(new Font("New Times Roman", Font.ITALIC, 18));
        f2 = new JTextField(10);
        p2.add(agelabel);
        p2.add(f2);
        numberlabel = new JLabel(" Phone number: ");
        numberlabel.setForeground(Color.DARK_GRAY);
        numberlabel.setFont(new Font("New Times Roman", Font.ITALIC, 18));
        f3 = new JTextField(10);
        p2.add(numberlabel);
        p2.add(f3);
        p2.setBackground(Color.LIGHT_GRAY);
    }

    private class addtra implements ActionListener {
         public void actionPerformed(ActionEvent e){
                 
            try{
                 
            checkfield();
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
             Integer.parseInt(f2.getText());
         }
         catch(NumberFormatException e )
             {
                 throw new handleException("Age has to be in numbers!");
             }
         if(Integer.parseInt(f2.getText())<0||Integer.parseInt(f2.getText())>100)
         {
             throw new handleException("Age entered is wrong!");}
         
         else if(Integer.parseInt(f2.getText())<18){
             throw new handleException("Trainer can not be under 18 ");}
         
     }
          private void checkPhone()throws handleException
     {
         
          try
             {
                 Integer.parseInt(f3.getText());
                        
             }
             catch(NumberFormatException e )
             {
                 throw new NumberFormatException("Phone number has to be in numbers!");
             }
         if((f3.getText()).length()!=10)
         {
             throw new handleException("Phone number has to be 10 numbers!");
            
         }
        if((f3.getText().charAt(0))!='0'||(f3.getText().charAt(1))!='5')
        {
            throw new handleException("Phone number has to start with 05!");
        }
            
     } 
          
          private void checkfield()throws handleException
        {
            if(f1.getText().isEmpty()||f2.getText().isEmpty()
                    ||f3.getText().isEmpty())
            {
                throw new handleException("Please fill all textfields!");
            }

  }
          public void addToFile()throws IOException{
               //append in a Trainer file
   FileWriter fw = new FileWriter("Trainer.txt" , true);
   //to write in the file
   PrintWriter write = new PrintWriter(fw);

   write.println( f1.getText() + "    "  + f2.getText() + "   " + f3.getText()+ "\t" ); 
           
        
             
           
           write.close();
          }
    
    } 
}
