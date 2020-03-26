package cn.acyco.life.ui;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;

/**
 * @author Acyco
 * @create 2020-03-26 07:50
 */
public class Window {
    private JFrame window;
    private int width = 500;
    private int height = 600;
    private int x = 100;
    private int y = 100;
    private String title = "Acyco's Life";

    
    public Window() {
        initialization();
    }

    public Window(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public Window(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    

    private void initialization() {
        setWindow(new JFrame());
        getWindow().setTitle(title);//设置标题
        getWindow().setBounds(x,y,width,height);
        getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
