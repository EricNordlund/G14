/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import controller.Controller2;
import dal.Dal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 *
 * @author Olle
 */
public class testMain {
    
    testFrame myFrame;
    
    public testMain() {
        myFrame = new testFrame();
        
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

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
    
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        testMain testM = new testMain();
        testM.link();

    }
    
    private void link() throws SQLException {
        Dal dal = new Dal();

        Controller2 controller = new Controller2(dal);
        
        myFrame.setController(controller);
        
        /*controller.insertStudent("Kalle","Orsa");*/
        ResultSet rs = controller.getStudent(921028);
       if(rs.next()) {
            System.out.println(rs.getString(1)+rs.getString(2)
            +rs.getString(3));
        }
        
    }
    
}
