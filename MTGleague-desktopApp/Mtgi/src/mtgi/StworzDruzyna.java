/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
public class StworzDruzyna extends JFrame {
    int identyfikator;
    okno ok;
    File file;
    FileInputStream fis=null;
    PreparedStatement ps;
    StworzDruzyna to;
    JFileChooser jFileChooser1;
    class ButtonOKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(field.getText()==null || passfield.getText()==null  || fis==null){
                JOptionPane.showMessageDialog(null,
                            "Nie podano nazwy, loga lub hasła.",
                            "Error Message",
                            JOptionPane.ERROR_MESSAGE);
            }
            else {
                String user = "mtgadmin";
                String pass = "mtglol123";
                String dbClass = "com.mysql.jdbc.Driver";
                String dbDriver = "jdbc:mysql://db4free.net:3306/mtgleague";
                Connection conn = null;
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
                String query = "Select Nazwa FROM Druzyna";
                Statement stmt = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet rs;
                ArrayList<String> userzy1 = new ArrayList<String>();
                try {
                    rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        userzy1.add(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                }
                boolean flaga = false;
                for (int i = 0; i < userzy1.size(); i++) {
                    if (field.getText().equals(userzy1.get(i)) || field.getText().length()>=60 || field.getText().length()==0 || passfield.getText().length() >= 255 || passfield.getText().length()==0) {
                        flaga = true;
                    }
                }
                if (!flaga) {

//                    Statement stmt2 = null;
//                    try {
//                        stmt2 = conn.createStatement();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    try {
//                        stmt2.executeUpdate("INSERT INTO Druzyna (Nazwa, Haslo, Logo, Kapitan) VALUES ('" + field.getText() + "', '" + passfield.getText() + "', " + null + ", " + identyfikator + ")");
//                    } catch (SQLException ex) {
//                        Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    ps = null;
                    String INSERT_PICTURE = "INSERT INTO Druzyna (Nazwa, Haslo, Logo, Kapitan) VALUES (?, ?, ?, ?)";
                    try {
                        conn.setAutoCommit(false);
                        //fis = new FileInputStream(file);
                        ps = conn.prepareStatement(INSERT_PICTURE);
                        ps.setString(1, field.getText());
                        ps.setString(2, passfield.getText());
                        ps.setBinaryStream(3, fis, (int) file.length());
                        ps.setInt(4, identyfikator);
                        ps.executeUpdate();
                        conn.commit();
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(StworzDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        conn.setAutoCommit(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(StworzDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    String query4 = "Select Id FROM Druzyna WHERE Nazwa='" + field.getText() + "'";
                    Statement stmt4 = null;
                    try {
                        stmt4 = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ResultSet rs4;
                    ArrayList<Integer> userzy4 = new ArrayList<Integer>();
                    //ArrayList<String> userzy4 = new ArrayList<String>();
                    try {
                        rs4 = stmt4.executeQuery(query4);
                        while (rs4.next()) {
                            userzy4.add(Integer.parseInt(rs4.getString(1)));
                            //userzy4.add(rs3.getString(2));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Statement stmt3 = null;
                    try {
                        stmt3 = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        stmt3.executeUpdate("INSERT INTO DruzynaUzytkownik VALUES (" + userzy4.get(0) + ", " + identyfikator + ")");
                    } catch (SQLException ex) {
                        Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Stworzono drużynę: " + field.getText());
                    try {
                        ok.stworz();
                    } catch (SQLException ex) {
                        Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        ps.close();
                        fis.close();
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(StworzDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Wystąpił jeden z błędów:\n"
                            + "Drużyna o podanej nazwie już istnieje;\n"
                            + "Nazwa, którą podałeś ma 0 lub więcej niż 60 znaków;\n"
                            + "Hasło, które podałeś ma 0 lub więcej niż 255 znaków.",
                            "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }
//    class ButtonRegListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            
//        }
//    }
    class ButtonWybListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fis=null;
            jFileChooser1 = new javax.swing.JFileChooser();
            jFileChooser1.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG and PNG", new String[] { "JPG", "PNG" }));
            jFileChooser1.setForeground(java.awt.Color.white);
            int flaga = jFileChooser1.showOpenDialog(to);
            if (flaga == javax.swing.JFileChooser.APPROVE_OPTION) {
                file = jFileChooser1.getSelectedFile();
                String nazwa=file.getName();
                try {
                    if (nazwa.charAt(nazwa.length() - 4) == '.' && nazwa.charAt(nazwa.length() - 1) == 'g'
                        && ((nazwa.charAt(nazwa.length() - 3) == 'p' && nazwa.charAt(nazwa.length() - 2) == 'n')
                        || (nazwa.charAt(nazwa.length() - 3) == 'j' && nazwa.charAt(nazwa.length() - 2) == 'p'))) {
                        if (file.length() < 65536) {
                            fis = new FileInputStream(file);
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Plik jest zbyt duży! Maksymalny rozmiar pliku to 64 KB.",
                                    "Error Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Wybrano błędny plik! Plik obrazu musi być rozszerzenia .png lub .jpg",
                                "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(StworzDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class ButtonCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //lblMessage.setText("The Cancel button was clicked");
            setVisible(false);
            dispose();
        }
    }

    JButton btnOK, wyb;
    JButton btnCancel;
    //JLabel lblMessage;
    JPanel panel;
    StworzDruzyna.ButtonOKListener btnOKListener;
    StworzDruzyna.ButtonWybListener wybieracz;
    //DolaczDruzyna.ButtonRegListener buttonRegListener;
    StworzDruzyna.ButtonCancelListener btnCancelListener;
    String druzyna;
    JLabel l1, l2, l3;
    JTextField field, passfield;
    public StworzDruzyna(int id, okno o) {
        fis=null;
        to=this;
        ok=o;
        identyfikator=id;
        //login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        btnOKListener = new StworzDruzyna.ButtonOKListener();
        btnCancelListener = new StworzDruzyna.ButtonCancelListener();
        wybieracz = new StworzDruzyna.ButtonWybListener();
        //buttonRegListener = new DolaczDruzyna.ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();
        l1 = new JLabel("Drużyna");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        //field.setText("123@wp.pl");
        //field.setColumns(10);
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Hasło");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        passfield = new JTextField();
        //passfield.setText("123");
        passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Logo");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        wyb = new JButton("Wybierz logo");
        wyb.setAlignmentX(Component.CENTER_ALIGNMENT);
        wyb.addActionListener(wybieracz);
        
        btnOK = new JButton("Stwórz");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        
        //register = new JButton("Zarejestruj");
        //register.setAlignmentX(Component.CENTER_ALIGNMENT);
        //register.addActionListener(buttonRegListener);
        btnCancel = new JButton("Wróć");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel.addActionListener(btnCancelListener);
        
        //lblMessage = new JLabel();
        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(passfield);
        panel.add(l3);
        panel.add(wyb);
        panel.add(btnOK);
        //panel.add(register);
        panel.add(btnCancel);
        //panel.add(lblMessage);
        
        this.add(panel);
        
        
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
