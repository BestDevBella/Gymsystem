/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

public class Accesstrainer extends JFrame {

        private JPanel radiopanel;
    private JPanel buttonpanel;
    private JPanel lpanel;
    private JRadioButton r1;
    private JRadioButton r2;
    private ButtonGroup group;
    private JList list;

    private JButton button;
    private JButton button2;
    private JLabel l2;

    private JLabel l1;

    public Accesstrainer() {
        setTitle("Access Trainer");
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5,50));
        getContentPane().setBackground(Color.LIGHT_GRAY);
        buildradiopanel();
        l2 = new JLabel("You have accessed trainer");
        l2.setFont(new Font("Serif", Font.BOLD, 18));
        l2.setForeground(Color.darkGray);
        lpanel = new JPanel();
        lpanel.setBackground(Color.LIGHT_GRAY);
        lpanel.add(l2);
        add(lpanel, BorderLayout.NORTH);
        add(radiopanel, BorderLayout.CENTER);
        buttonpanel = new JPanel();
        button = new JButton("Select");
        button.setBackground(Color.WHITE);
        button.setForeground(Color.PINK);
        button.addActionListener(new butlistener());

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
        r1 = new JRadioButton("Add trainer");
        r2 = new JRadioButton("View Trainer's info");
        Font newRadioButtonFont=new Font(r1.getFont().getName(),Font.BOLD,r1.getFont().getSize());
      Font newRadioButtonFont2=new Font(r2.getFont().getName(),Font.BOLD,r2.getFont().getSize());
       r1.setFont( newRadioButtonFont);
       r2.setFont( newRadioButtonFont2);
        r1.setForeground(Color.GRAY);
        r1.setBackground(Color.LIGHT_GRAY);
        r2.setForeground(Color.GRAY);
        r2.setBackground(Color.LIGHT_GRAY);
        group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        radiopanel.add(r1);
        radiopanel.add(r2);

    }
    private class butlistener implements ActionListener{
         public void actionPerformed(ActionEvent e){
             if(e.getSource()==button){
                 if(r1.isSelected()){
                     new Addtrainer();
                 }
                 else if(r2.isSelected()){
                     new Viewtrainer();
                 }
             }
             if(e.getSource()==button2){
                 new MainPage();
             }
         }
    }
}
