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
import javax.swing.event.*;

public class MainPage extends JFrame {
   
/**
 *
 * @author Bylsan
 */

    private JPanel imagepanel;
    private JPanel listpanel;
    private JPanel buttonpanel;
    private JList list;
    private JScrollPane sp;
    private JButton button;
    private JButton button2;
    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel l1;
    private String[] options = {"Access Member", "Access Trainer", "Access scehdule"};

    public MainPage() {
        setTitle("Gym system");
        setSize(600, 550);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(Color.PINK);

        buildimagepanel();
        buildlistpanel();
        imagepanel.setBackground(Color.LIGHT_GRAY);
        listpanel.setBackground(Color.LIGHT_GRAY);
        add(imagepanel, BorderLayout.NORTH);
        add(listpanel, BorderLayout.CENTER);
        buttonpanel = new JPanel();
        button = new JButton("Select");
        button.addActionListener(new buttonlistener());
        button.setForeground(Color.PINK);
        button2 = new JButton("Exit");
        button2.addActionListener(new buttonlistener());
        button2.setForeground(Color.PINK);
        button.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        buttonpanel.add(button);
        buttonpanel.add(button2);
        buttonpanel.setBackground(Color.LIGHT_GRAY);
        add(buttonpanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void buildimagepanel() {
        imagepanel = new JPanel();
        image = new ImageIcon("gym.jpg");
      
        imageLabel = new JLabel(image);
        imagepanel.add(imageLabel);

    }

    public void buildlistpanel() {
        listpanel = new JPanel();
        list = new JList(options);
        list.setBackground(Color.GRAY);
        list.setForeground(Color.WHITE);
        list.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        sp = new JScrollPane(list);
        list.setVisibleRowCount(2);
        l1 = new JLabel("Select one of the folowing:  ");
        l1.setFont(new Font("Serif", Font.BOLD, 18));
        l1.setForeground(Color.WHITE);
        listpanel.add(l1);
        listpanel.add(sp);

    }
    
    private class buttonlistener implements ActionListener
    { 
        public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            if(list.getSelectedValue()=="Access Trainer"){
              new Accesstrainer();
               
            }
            else if(list.getSelectedValue()=="Access Member"){
                new MemberPage();
            
            }
            else if(list.getSelectedValue()=="Access scehdule"){
                new Schedule();
              
            }
        }
         if(e.getSource()==button2){
             System.exit(0);
         }
    }
    }
}

