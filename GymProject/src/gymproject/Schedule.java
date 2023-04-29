/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GymProject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bylsan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.swing.event.*;

public class Schedule extends JFrame {

    private JPanel radiopanel;
    private JPanel buttonpanel;
    private JPanel lpanel;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private ButtonGroup group;
    private JList list;

    private JButton button;
    private JButton button2;
    private JLabel l2;

    private JLabel l1;

    public Schedule() {
        setTitle("Access Schedule");
        setSize(600, 300);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        buildradiopanel();
        l2 = new JLabel("You have accessed Schedule");
        l2.setFont(new Font("Serif", Font.BOLD, 18));
        l2.setForeground(Color.darkGray);
        setLayout(new BorderLayout(5,50));
        lpanel = new JPanel();
        lpanel.setBackground(Color.LIGHT_GRAY);
        lpanel.add(l2);
        add(lpanel, BorderLayout.NORTH);
        add(radiopanel, BorderLayout.CENTER);
        buttonpanel = new JPanel();
        button = new JButton("Select");
        button.addActionListener(new butlistener());
        button.setBackground(Color.WHITE);
        button.setForeground(Color.PINK);

        button2 = new JButton("Back");
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.PINK);
         button2.addActionListener(new butlistener());
        buttonpanel.add(button);
        buttonpanel.add(button2);
        add(buttonpanel, BorderLayout.SOUTH);
        buttonpanel.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }

    public void buildradiopanel() {
        radiopanel = new JPanel();
        radiopanel.setBackground(Color.LIGHT_GRAY);
        r1 = new JRadioButton("Set Schedule");
        r2 = new JRadioButton("Diplay Schedule");
        r3 = new JRadioButton("Assign members to schedule");
        Font newRadioButtonFont=new Font(r1.getFont().getName(),Font.BOLD,r1.getFont().getSize());
        Font newRadioButtonFont2=new Font(r2.getFont().getName(),Font.BOLD,r2.getFont().getSize());
        Font newRadioButtonFont3=new Font(r3.getFont().getName(),Font.BOLD,r3.getFont().getSize());
        r1.setFont( newRadioButtonFont);
        r2.setFont( newRadioButtonFont2);
        r3.setFont( newRadioButtonFont3);
        r1.setBackground(Color.LIGHT_GRAY);
        r2.setBackground(Color.LIGHT_GRAY);
        r3.setBackground(Color.LIGHT_GRAY);
        r1.setForeground(Color.GRAY);
        r2.setForeground(Color.GRAY);
        r3.setForeground(Color.GRAY);
        group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        radiopanel.add(r1);
        radiopanel.add(r2);
        radiopanel.add(r3);

    }
    private class butlistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==button){
                if(r1.isSelected()){
                    new setSchedule();
                }
                else if(r2.isSelected()){
                    try{
                    dispSched();
                    }
                    catch(Exception h)
                    {
                        JOptionPane.showMessageDialog(null, h.getMessage());
                    }
                }
                
                else if(r3.isSelected()){
                    new Assign();
                }
                    
            }
            if(e.getSource()==button2){
                new MainPage();
            }
        }
        
        
        
        public void dispSched()throws IOException,handleException
        {

   
       //header
       try{
           
       
       File file = new File("Schedule.txt");
//       Scanner read = new Scanner(file);
       FileReader fr=new FileReader(file);
       BufferedReader br=new BufferedReader(fr);
    
       String str1,str2;
       str1=br.readLine();
       str2=br.readLine();
      JOptionPane.showMessageDialog(null, str1+"\t"+str2);
       }
       catch(FileNotFoundException e)
       {
           throw new handleException("File not found");
       }
   }
        }
    }


