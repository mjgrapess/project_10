/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.userscreen;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import operations.ErrorHandler;

/**
 *
 * @author Grapess
 */
public class BackPanel extends JPanel{
    private Image back_image;

    public BackPanel() {
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/pics/background.jpg"));
            back_image = icon.getImage();
        } catch (Exception ex) {
            ErrorHandler.showStackTrace(ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (back_image != null) {
            g.drawImage(back_image, 0, 0, getWidth(), getHeight(), this);
        } else {
            super.paintComponent(g);
        }
    }
}
