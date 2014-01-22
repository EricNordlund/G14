/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import dal.DAL;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Olle
 */
public class UMSApplication {

    UMSFrame myFrame;

    public UMSApplication() {
        myFrame = new UMSFrame();

        // Adjust frame size (if necessary) and position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = myFrame.getSize();

        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }

        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        myFrame.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);

        // Exit on close
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Finally make frame visible
        myFrame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create app and link together DAL, controller & view
        UMSApplication myApp = new UMSApplication();
        myApp.link();

    }

    private void link() throws SQLException {
        DAL dal = new DAL();

        Controller controller = new Controller(dal);

        myFrame.setController(controller);

    }

}
