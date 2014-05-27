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
public class ZnajdzDruzynaAdm extends JFrame {
    oknoadm okadm;
    WyswietlGraczy wg;
    String user;
    String pass;
    String dbClass;
    String dbDriver;
    Connection conn;
    class ButtonCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                conn.close();
                wg.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
            }
            wg.setVisible(false);
            setVisible(false);
            wg.dispose();
            dispose();
        }
    }
    JButton btnCancel;
    //JLabel lblMessage;
    JPanel panel;
    //ZarzadzajDruzyna.ButtonOKListener btnOKListener;
    //DolaczDruzyna.ButtonRegListener buttonRegListener;
    ZnajdzDruzynaAdm.ButtonCancelListener btnCancelListener;
    //String druzyna;
    JLabel l1, l2, l14;
    JTextField field, field2;
    //JPasswordField passfield;
    public ZnajdzDruzynaAdm(oknoadm o, String naz, WyswietlGraczy wgx) throws FileNotFoundException, IOException {
        okadm=o;
        wg=wgx;
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
        String query = "Select Nazwa, Nick, czyZablokowana, Logo FROM Druzyna d, Uzytkownik u WHERE d.Kapitan=u.Id AND Nazwa='"+naz+"'";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        ArrayList<String> userzy1 = new ArrayList<String>();
        ArrayList<String> userzy2 = new ArrayList<String>();
        ArrayList<Integer> userzy5 = new ArrayList<Integer>();
        File image = new File("java.png"); 
        FileOutputStream fos = new FileOutputStream(image);
        
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userzy1.add(rs.getString(1));
                userzy2.add(rs.getString(2));
                userzy5.add(Integer.parseInt(rs.getString(3)));
                byte[] buffer = new byte[1];
                InputStream is = rs.getBinaryStream(4);
                while (is.read(buffer) > 0) {
                    fos.write(buffer);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        fos.close();
        //login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //btnOKListener = new ZarzadzajDruzyna.ButtonOKListener();
        btnCancelListener = new ZnajdzDruzynaAdm.ButtonCancelListener();
        //buttonRegListener = new DolaczDruzyna.ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();
        BufferedImage img=ImageIO.read(image);
        final Image scaleImage;
        if(img!=null){
             scaleImage= img.getScaledInstance(194, 194,Image.SCALE_DEFAULT);
        }
        else{
            img=ImageIO.read(new File("empty.png"));
            scaleImage=img;
        }
        JPanel pane = new JPanel() {
        @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //AffineTransform at = AffineTransform.getScaleInstance(50, 50);
                //g.drawRenderedImage(img, at);
                g.drawImage(scaleImage, 0, 0, this);
            }
        };
        //pane.setSize(new Dimension(190,190));
        //boolean Graphics.drawImage(img,10, 10,null);
        //pane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        l1 = new JLabel("Drużyna");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setText(userzy1.get(0));
        field.setEditable(false);
        field.setMaximumSize(new Dimension(400,40));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Kapitan");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //passfield = new JPasswordField();
        //passfield.setText("123");
        //passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
        field2 = new JTextField();
        field2.setText(userzy2.get(0));
        field2.setEditable(false);
        field2.setMaximumSize(new Dimension(400,40));
        field2.setAlignmentX(Component.CENTER_ALIGNMENT);
        if(userzy5.get(0)==0){
            l14 = new JLabel("Drużyna gotowa do rozgrywek");
        }
        else{
            l14 = new JLabel("Drużyna zablokowana");
        }
        l14.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
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
        panel.add(pane);
        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(field2);
        panel.add(l14);
        
        
        //panel.add(passfield);
        //panel.add(btnOK);
        //panel.add(register);
        panel.add(btnCancel);
        //panel.add(lblMessage);
        
        this.add(panel);
        image.delete();
        
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
