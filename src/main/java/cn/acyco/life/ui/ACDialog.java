package cn.acyco.life.ui;

import org.omg.CORBA.OMGVMCID;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.util.function.Predicate;

/**
 * @author Acyco
 * @create 2020-03-26 12:23
 */
public class ACDialog {
    
    private String title = "设置";
    private String content = "这是一个对话框";
    private JFrame window;
    private JDialog dialog = new JDialog(window);
    private int x= 100;
    private int y= 100;
    private int width= 100;
    private int height= 100;
    private DialogPosition DIALOGPOSITION = DialogPosition.DEFAULT;


    public ACDialog( JFrame window,String title, String content) {
        this.title = title;
        this.content = content;
        this.window = window;
        initialization();
    }

    public ACDialog(JFrame window, DialogPosition dialogPosition) {
        this.window = window;
        this.DIALOGPOSITION = dialogPosition;
        initialization();
    }
    public ACDialog(String title, String content, JFrame window,DialogPosition dialogPosition) {
        this.title = title;
        this.content = content;
        this.window = window;
        this.DIALOGPOSITION = dialogPosition;
        initialization();
    }

    public ACDialog(JFrame window) {
        this.title = title;
        this.content = content;
        this.window = window;
        initialization();
    }

    private void initialization() {
    
        Container container = dialog.getContentPane();
        container.add(new JLabel(this.content));
     this.setBounds(x,y,width,height);
        dialog.setModal(true);
      
    }
   
    
    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

 
    public void setBounds(int x,int y, int width,int height) {
        if (DIALOGPOSITION == DialogPosition.DEFAULT) {
            dialog.setBounds(x,y,width,height);
        }else{
            int windowX = window.getX();
            int windowY = window.getY();
            int windowW = window.getHeight();
            int windowH = window.getWidth();
            Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
            //int centerX = window
            dialog.setLocationRelativeTo(null);
            switch (DIALOGPOSITION) {
                case CENTER:
                    dialog.setBounds(windowX+(windowW/2-width/2),windowY+(windowH/2-height/2),width,height);
                    System.out.println("center"+windowH/2);
                    break;
            }
        }
       // dialog.setBounds(x,y,width,height);
    }


    public void setX(int x) {
        this.x = x;
        this.setBounds(x,y,width,height);
    }

    public void setY(int y) {
        this.y = y;
        this.setBounds(x,y,width,height);
    }

    public void setWidth(int width) {
        this.width = width;
        this.setBounds(x,y,width,height);
    }

    public void setHeight(int height) {
        this.height = height;
        this.setBounds(x,y,width,height);
    }
    
    public void setModal(Boolean b) {
        dialog.setModal(b);
    }
    
    
}
