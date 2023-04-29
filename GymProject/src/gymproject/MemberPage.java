/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author judealaki
 */
public class MemberPage extends JFrame {
   JLabel l1;
   JRadioButton jr1;
   JRadioButton jr2;
   ButtonGroup bg;
   JPanel p;
   JPanel p1;
   
   JButton b1;
   JButton b2;
   JPanel lpanel;
    int width=600;
    int height = 300;
    public MemberPage(){
        setTitle("Access Member");
      setSize(width,height);
      setLayout(new BorderLayout(5,50));
      
      //setLayout(new BorderLayout(5,40));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      //setLayout(new BorderLayout());
      getContentPane().setBackground(Color.LIGHT_GRAY);
      l1=new JLabel("You have accessed member ");
      jr1=new JRadioButton("Add member");
      jr2=new JRadioButton("view member's info");
      jr1.setForeground(Color.GRAY);
      jr2.setForeground(Color.GRAY);
     
      Font newRadioButtonFont=new Font(jr1.getFont().getName(),Font.BOLD,jr1.getFont().getSize());
      Font newRadioButtonFont2=new Font(jr2.getFont().getName(),Font.BOLD,jr2.getFont().getSize());
      jr1.setFont( newRadioButtonFont);
      jr2.setFont( newRadioButtonFont2);
      bg=new ButtonGroup();
      b1=new JButton("Select");
      b2=new JButton("Back");     
      p=new JPanel();
      p1=new JPanel();
      l1.setFont(new Font("Serif",Font.BOLD,18));
      l1.setBackground(Color.WHITE);
      l1.setForeground(Color.DARK_GRAY);
      lpanel=new JPanel();
      lpanel.add(l1);
      lpanel.setBackground(Color.LIGHT_GRAY);
      add(lpanel,BorderLayout.NORTH);
      l1.setBackground(Color.LIGHT_GRAY);
      p.setBackground(Color.LIGHT_GRAY);
      p1.setBackground(Color.LIGHT_GRAY);
      b1.setBackground(Color.WHITE);
      b1.setForeground(Color.PINK);
      b2.setBackground(Color.WHITE);
      b2.setForeground(Color.PINK);
      b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new MainPage();
          }
      });
      bg.add(jr1);
      bg.add(jr2);
      add(lpanel,BorderLayout.NORTH);
      p.add(jr1);
      p.add(jr2);
      p1.add(b1);
      p1.add(b2);
      add(p,BorderLayout.CENTER);
      add(p1,BorderLayout.SOUTH);
      b1.addActionListener(new buttonListe());
      setVisible(true);
}
    private class buttonListe implements ActionListener{
        public void actionPerformed(ActionEvent e) 
        {
            if(jr1.isSelected())
            {
                
             new addMember();
            }
            else if(jr2.isSelected())
                new getMemInfo();
        }
        
        
    }
}
