package cn.acyco.life;

import cn.acyco.life.ui.ACDialog;
import cn.acyco.life.ui.ACWindow;
import cn.acyco.life.ui.DialogPosition;

/**
 * @author Acyco
 * @create 2020-03-26 07:02
 */
public class Life {
    public static void main(String[] args){
        ACWindow window = new ACWindow();
        window.setX(300);
        window.setY(300);
        window.getWindow().setVisible(true);
        ACDialog dialog = new ACDialog(window.getWindow(), DialogPosition.CENTER);
        dialog.setModal(false);
       dialog.setVisible(true);
    }
}
