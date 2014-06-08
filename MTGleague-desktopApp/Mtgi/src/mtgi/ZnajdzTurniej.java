/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mateusz
 */
public class ZnajdzTurniej extends JFrame {
    okno ok;
    //WyswietlDruzyny wg;
    String user;
    String pass;
    String dbClass;
    String dbDriver;
    Connection conn;
    class ButtonCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                conn.close();
                //wg.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
            }
            //wg.setVisible(false);
            setVisible(false);
            //wg.dispose();
            dispose();
        }
    }
    JButton btnCancel;
    //JLabel lblMessage;
    JPanel panel;
    //ZarzadzajDruzyna.ButtonOKListener btnOKListener;
    //DolaczDruzyna.ButtonRegListener buttonRegListener;
    ZnajdzTurniej.ButtonCancelListener btnCancelListener;
    //String druzyna;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField field, field2, field3, field4;
    //JPasswordField passfield;
    public ZnajdzTurniej(okno o, String naz) throws FileNotFoundException, IOException {
        ok=o;
        //wg=wgx;
        user = "mtgadmin";
        pass = "mtglol123";
        dbClass = "com.mysql.jdbc.Driver";
        dbDriver = "jdbc:mysql://db4free.net:3306/mtgleague";
        conn = null;
        try {
            Class.forName(dbClass).newInstance();
            //System.out.println("driver loaded");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println(ex);
        }
        try {
            conn = DriverManager.getConnection(dbDriver, user, pass);
            //System.out.println("connected");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Baza danych jest wyłączona.",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
        String query = "Select Nazwa, Data, Nick, Typ FROM Uzytkownik u, Turniej t WHERE Nazwa='"+naz+"' AND Zalozyciel=u.Id";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        ArrayList<String> userzy1 = new ArrayList<String>();
        ArrayList<String> userzy2 = new ArrayList<String>();
        ArrayList<String> userzy3 = new ArrayList<String>();
        ArrayList<String> userzy4 = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userzy1.add(rs.getString(1));
                userzy2.add(rs.getString(2));
                userzy3.add(rs.getString(3));
                userzy4.add(rs.getString(4));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        //login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //btnOKListener = new ZarzadzajDruzyna.ButtonOKListener();
        btnCancelListener = new ZnajdzTurniej.ButtonCancelListener();
        //pane.setSize(new Dimension(190,190));
        //boolean Graphics.drawImage(img,10, 10,null);
        //pane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        l1 = new JLabel("Nazwa");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setText(userzy1.get(0));
        field.setEditable(false);
        field.setMaximumSize(new Dimension(400,40));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Data");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        field2 = new JTextField();
        field2.setText(userzy2.get(0));
        field2.setEditable(false);
        field2.setMaximumSize(new Dimension(400,40));
        field2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Nick");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        field3 = new JTextField();
        field3.setText(userzy3.get(0));
        field3.setEditable(false);
        field3.setMaximumSize(new Dimension(400,40));
        field3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4 = new JLabel("Typ");
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        field4 = new JTextField();
        field4.setText(userzy4.get(0));
        field4.setEditable(false);
        field4.setMaximumSize(new Dimension(400,40));
        field4.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //btnOK = new JButton("Dołącz");
        //btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        //btnOK.addActionListener(btnOKListener);
        
        //register = new JButton("Zarejestruj");
        //register.setAlignmentX(Component.CENTER_ALIGNMENT);
        //register.addActionListener(buttonRegListener);
        btnCancel = new JButton("Wróć");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel.addActionListener(btnCancelListener);
        
        //lblMessage = new JLabel();
        //panel.add(pane);
        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(field2);
        panel.add(l3);
        panel.add(field3);
        panel.add(l4);
        panel.add(field4);
        
        //panel.add(passfield);
        //panel.add(btnOK);
        //panel.add(register);
        panel.add(btnCancel);
        //panel.add(lblMessage);
        
        this.add(panel);
        //image.delete();
        
    }
    
//    void zamknij() {
//        this.setVisible(false);
//    }

//    public static void main(String[] args) throws SQLException {
//        //DolaczDruzyna GUI = new DolaczDruzyna();
//        
//        
//    }
}
