package net.zcmusicbox.test.util.ui.event;

/**
 * 这个程序利用GridLayout来实现一个界面，然后当按每一个按钮的时候，按钮的颜色发生变化
 */
 
/**
 * @author Rollen Holt
 * @version 25/5/2011
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class TestActionListener extends JFrame implements ActionListener{
    JButton buttonBlue;
    JButton buttonRed;
    JButton buttonWhite;
    JButton buttonGreen;
    JButton buttonYellow;
    JButton buttonBlack;
    JButton buttonOrange;
    JButton buttonPurple;
    JButton buttonPink;
    JButton buttonLightBlue;
     
    Panel panel;
     
    TestActionListener(){
            setTitle("GridLayout");
            setSize(500,500);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
            buttonBlue=new JButton("Blue");
            buttonRed=new JButton("Red");
            buttonWhite=new JButton("White");
            buttonGreen=new JButton("Green");
            buttonYellow=new JButton("Yellow");
            buttonBlack=new JButton("Black");
            buttonOrange=new JButton("Orange");
            buttonPurple=new JButton("Purple");
            buttonPink=new JButton("Pink");
            buttonLightBlue=new JButton("LightBlue");
             
            panel=new Panel();
            panel.setLayout(new GridLayout(5,2));
            panel.add(buttonBlue);
            panel.add(buttonRed);
            panel.add(buttonWhite);
            panel.add(buttonBlack);
            panel.add(buttonGreen);
            panel.add(buttonYellow);
            panel.add(buttonOrange);
            panel.add(buttonLightBlue);
            panel.add(buttonPink);
            panel.add(buttonPurple);
            add(panel);
             
            buttonBlue.addActionListener(this);
            buttonRed.addActionListener(this);
            buttonLightBlue.addActionListener(this);
            buttonWhite.addActionListener(this);
            buttonPink.addActionListener(this);
            buttonGreen.addActionListener(this);
            buttonOrange.addActionListener(this);
            buttonPurple.addActionListener(this);
            buttonYellow.addActionListener(this);
            buttonBlack.addActionListener(this);
             
        }
    public void actionPerformed(ActionEvent event){
            if(event.getSource()==buttonBlue){
                buttonBlue.setBackground(Color.BLUE);
            }
            if(event.getSource()==buttonBlack){
                buttonBlack.setBackground(Color.BLACK);
            }
            if(event.getSource()==buttonRed){
                buttonRed.setBackground(Color.RED);
            }
            if(event.getSource()==buttonPink){
                buttonPink.setBackground(Color.PINK);
            }
            if(event.getSource()==buttonOrange){
                buttonOrange.setBackground(Color.ORANGE);
            }
            if(event.getSource()==buttonYellow){
                buttonYellow.setBackground(Color.YELLOW);
            }
            if(event.getSource()==buttonPurple){
                buttonPurple.setBackground(new Color(128,0,255));
            }
            if(event.getSource()==buttonLightBlue){
                buttonLightBlue.setBackground(Color.CYAN);
            }
            if(event.getSource()==buttonWhite){
                buttonWhite.setBackground(Color.WHITE);
            }
            if(event.getSource()==buttonGreen){
                buttonGreen.setBackground(Color.GREEN);
            }
        }
 
    public static void main(String[] args){
        new TestActionListener();
    }
}   
