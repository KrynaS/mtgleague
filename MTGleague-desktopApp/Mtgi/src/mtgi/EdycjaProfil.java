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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
public class EdycjaProfil extends JFrame {
    okno ok=null;
    oknoadm okadm=null;
    String user;
    String pass;
    String dbClass;
    String dbDriver;
    Connection conn;
    EdycjaProfil to;
    int idek, blok;
    String imie, nazwisko, nick, haslo, email;
    class ButtonOKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //var reg = "/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/";
            //if (field5.getText().contains(" ") == false && field5.getText().matches(".+@.+\\.[a-z]+")) {
            if(field.getText().length() < 60 && field.getText().length()>0){
                if(field2.getText().length() < 60 && field2.getText().length()>0){
                    if(field3.getText().length() < 60 && field3.getText().length()>0){
                        if (field4.getText().length() < 60 && field4.getText().length()>0){
                            imie = field.getText();
                            nazwisko = field2.getText();
                            nick = field3.getText();
                            haslo = field4.getText();
                            //email = field5.getText();


                            String query7 = "UPDATE Uzytkownik SET Imie='" + imie + "', Nazwisko='" + nazwisko + "', Nick='" + nick + "', Haslo='" + haslo + "' WHERE id='" + idek + "'"; //"', Email='" + email +
                            Statement stmt7 = null;
                            try {
                                stmt7 = conn.createStatement();
                            } catch (SQLException ex) {
                                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                stmt7.executeUpdate(query7);
                            } catch (SQLException ex) {
                                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            JOptionPane.showMessageDialog(null,
                                    "Zmiany zostały wprowadzone");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                    "Hasło musi być krótsze niż 60 znaków i nie puste!",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,
                    "Nick musi być krótszy niż 60 znaków i nie puste!",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,
                    "Nazwisko musi być krótsze niż 60 znaków i nie puste!",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,
                    "Imię musi być krótsze niż 60 znaków i nie puste!",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ButtonCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(okadm==null){
                    ok.stworz();
                }
                else{
                    okadm.stworz();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            dispose();
        }
    }
    
    
    

    JButton btnOK;
    JButton btnCancel;
    JPanel panel;
    EdycjaProfil.ButtonOKListener btnOKListener;
    EdycjaProfil.ButtonCancelListener btnCancelListener;
    JLabel l1, l2, l3, l4, l5, l14;
    JTextField field, field2, field3, field4 ,field5;
    public EdycjaProfil(okno o, int nic) throws FileNotFoundException, IOException {
        ok=o;
        idek=nic;
        panel = new JPanel();
        to=this;
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
        stworz();
    }
    
    public EdycjaProfil(oknoadm o, int nic) throws FileNotFoundException, IOException {
        okadm=o;
        idek=nic;
        panel = new JPanel();
        to=this;
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
        stworz();
    }
    
    void stworz() throws FileNotFoundException, IOException{
        String query = "Select Imie, Nazwisko, Nick, Haslo, Email, czyZablokowany FROM Uzytkownik WHERE Id='"+idek+"'";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
       // ArrayList<String> userzy1 = new ArrayList<String>();
        //ArrayList<String> userzy2 = new ArrayList<String>();
        //ArrayList<String> userzy3 = new ArrayList<String>();
        //ArrayList<Integer> userzy5 = new ArrayList<Integer>();
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                imie=rs.getString(1);
                nazwisko=rs.getString(2);
                nick=rs.getString(3);
                haslo=rs.getString(4);
                email=rs.getString(5);
                blok=Integer.parseInt(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        narysuj();
        
    }
    void narysuj() throws IOException{
        panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        btnOKListener = new EdycjaProfil.ButtonOKListener();
        btnCancelListener = new EdycjaProfil.ButtonCancelListener();

        l1 = new JLabel("Imię");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setText(imie);
        field.setMaximumSize(new Dimension(400,40));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Nazwisko");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        field2 = new JTextField();
        field2.setText(nazwisko);
        field2.setMaximumSize(new Dimension(400,40));
        field2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Nick");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        field3 = new JTextField();
        field3.setText(nick);
        field3.setMaximumSize(new Dimension(400,40));
        field3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4 = new JLabel("Hasło");
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        field4 = new JTextField();
        field4.setText(haslo);
        field4.setMaximumSize(new Dimension(400,40));
        field4.setAlignmentX(Component.CENTER_ALIGNMENT);
        l5 = new JLabel("E-Mail");
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
        field5 = new JTextField();
        field5.setText(email);
        field5.setEditable(false);
        field5.setMaximumSize(new Dimension(400,40));
        field5.setAlignmentX(Component.CENTER_ALIGNMENT);
        if(blok==0){
            l14 = new JLabel("Użytkownik gotowy do rozgrywek");
        }
        else{
            l14 = new JLabel("Użytkownik zablokowany");
        }
        l14.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnOK = new JButton("Zapisz zmiany");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        btnCancel = new JButton("Wróć");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel.addActionListener(btnCancelListener);

        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(field2);
        panel.add(l3);
        panel.add(field3);
        panel.add(l4);
        panel.add(field4);
        panel.add(l5);
        panel.add(field5);
        panel.add(l14);
        panel.add(btnOK);
        panel.add(btnCancel);
        
        to.add(panel);
        to.revalidate();
        to.repaint();
    }
}
