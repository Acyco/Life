package cn.acyco.life.ui;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import java.awt.*;

/**
 * @author Acyco
 * @create 2020-03-26 07:50
 */
public class ACWindow {
    private JFrame window;
    private int width = 500;
    private int height = 600;
    private int x = 100;
    private int y = 100;
    private String title = "Acyco's Life";


    public ACWindow() {
        initialization();
    }

    public ACWindow(String title) {
        this.title = title;
        initialization();
    }

    public ACWindow(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public ACWindow(int x, int y) {
        this.x = x;
        this.y = y;
    }


    private void initialization() {
        setWindow(new JFrame());
        getWindow().setTitle(title);//设置标题
        getWindow().setBounds(x, y, width, height);
        getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
    
    public void setSystemTray(String img) throws Exception {
        TrayIcon trayIcon = new TrayIcon(new ImageIcon(img).getImage());
        SystemTray.getSystemTray().add(trayIcon);
    }

    public void setWidth(int width) {
        this.width = width;
        getWindow().setBounds(x,y,width,height);
    }

    public void setHeight(int height) {
        this.height = height;
        getWindow().setBounds(x,y,width,height);
    }

    public void setX(int x) {
        this.x = x;
        getWindow().setBounds(x,y,width,height);
    }

    public void setY(int y) {
        this.y = y;
        getWindow().setBounds(x,y,width,height);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
