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
public class StworzTurniej extends JFrame {
    int identyfikator;
    okno ok;
    File file;
    FileInputStream fis=null;
    PreparedStatement ps;
    StworzTurniej to;
    JFileChooser jFileChooser1;
    class ButtonOKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(field.getText()==null || passfield.getText()==null){
                JOptionPane.showMessageDialog(null,
                            "Nie podano nazwy lub daty.",
                            "Error Message",
                            JOptionPane.ERROR_MESSAGE);
            }
            else {
                String datka=passfield.getText();
                boolean flag=true;  //jesli dobra data to true
                for(int i=0;i<10;i++){
                    boolean temp=true;
                    if(i!=4 && i!=7){
                        temp=Character.isDigit(datka.charAt(i));
                    }
                    else{
                        if(datka.charAt(i)!='-'){
                            temp=false;
                        }
                    }
                    if(!temp){
                        flag=false;
                    }
                }
                boolean flag2=true;  //jesli dobra data to true
                if(datka.charAt(0)-'0'>2 || datka.charAt(5)-'0'>1  || datka.charAt(8)-'0'>3|| (datka.charAt(5)-'0'==1 && datka.charAt(6)-'0'>2) || (datka.charAt(8)-'0'==3 && datka.charAt(9)-'0'>1)){
                    //System.out.println(datka.charAt(0)+" "+datka.charAt(5)+" "+datka.charAt(5)+datka.charAt(6)+" "+datka.charAt(8)+" "+datka.charAt(8)+datka.charAt(9));
                    flag2=false;
                }  
                if (datka.length() != 10 || !flag || !flag2) {
                    JOptionPane.showMessageDialog(null,
                                "Data musi być w formacie YYYY-MM-DD i musi być prawdziwa!",
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
                    String query = "Select Nazwa FROM Turniej";
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
                        if (field.getText().equals(userzy1.get(i)) || field.getText().length() >= 60 || field.getText().length() == 0) {
                            flaga = true;
                        }
                    }
                    if (!flaga) {
                        Statement stmt2 = null;
                        try {
                            stmt2 = conn.createStatement();
                        } catch (SQLException ex) {
                            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            stmt2.executeUpdate("INSERT INTO Turniej (Nazwa, Data, Typ, Zalozyciel) VALUES ('" + field.getText() + "', '" + passfield.getText() + "', '" + kapy.getSelectedItem() + "', " + identyfikator + ")");
                        } catch (SQLException ex) {
                            Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        JOptionPane.showMessageDialog(null,
                                "Stworzono turniej o nazwie: " + field.getText());
                        try {
                            ok.stworz();
                        } catch (SQLException ex) {
                            Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        setVisible(false);
                        dispose();
                    } 
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Wystąpił jeden z błędów:\n"
                                + "Drużyna o podanej nazwie już istnieje;\n"
                                + "Nazwa, którą podałeś ma 0 lub więcej niż 60 znaków;",
                                "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
//    class ButtonRegListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            
//        }
//    }
//    class ButtonWybListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            fis=null;
//            jFileChooser1 = new javax.swing.JFileChooser();
//            jFileChooser1.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG and PNG", new String[] { "JPG", "PNG" }));
//            jFileChooser1.setForeground(java.awt.Color.white);
//            int flaga = jFileChooser1.showOpenDialog(to);
//            if (flaga == javax.swing.JFileChooser.APPROVE_OPTION) {
//                file = jFileChooser1.getSelectedFile();
//                String nazwa=file.getName();
//                try {
//                    if (nazwa.charAt(nazwa.length() - 4) == '.' && nazwa.charAt(nazwa.length() - 1) == 'g'
//                        && ((nazwa.charAt(nazwa.length() - 3) == 'p' && nazwa.charAt(nazwa.length() - 2) == 'n')
//                        || (nazwa.charAt(nazwa.length() - 3) == 'j' && nazwa.charAt(nazwa.length() - 2) == 'p'))) {
//                        if (file.length() < 65536) {
//                            fis = new FileInputStream(file);
//                        }
//                        else {
//                            JOptionPane.showMessageDialog(null,
//                                    "Plik jest zbyt duży! Maksymalny rozmiar pliku to 64 KB.",
//                                    "Error Message",
//                                    JOptionPane.ERROR_MESSAGE);
//                        }
//                    } 
//                    else {
//                        JOptionPane.showMessageDialog(null,
//                                "Wybrano błędny plik! Plik obrazu musi być rozszerzenia .png lub .jpg",
//                                "Error Message",
//                                JOptionPane.ERROR_MESSAGE);
//                    }
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(StworzDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }

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
    StworzTurniej.ButtonOKListener btnOKListener;
    //StworzTurniej.ButtonWybListener wybieracz;
    //DolaczDruzyna.ButtonRegListener buttonRegListener;
    StworzTurniej.ButtonCancelListener btnCancelListener;
    String druzyna;
    JLabel l1, l2, l3;
    JTextField field, passfield;
    JComboBox kapy;
    public StworzTurniej(int id, okno o) {
        fis=null;
        to=this;
        ok=o;
        identyfikator=id;
        //login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        btnOKListener = new StworzTurniej.ButtonOKListener();
        btnCancelListener = new StworzTurniej.ButtonCancelListener();
        //wybieracz = new StworzTurniej.ButtonWybListener();
        //buttonRegListener = new DolaczDruzyna.ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();
        l1 = new JLabel("Nazwa");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        //field.setText("123@wp.pl");
        //field.setColumns(10);
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Data");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        passfield = new JTextField();
        //passfield.setText("123");
        passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Typ");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        kapy = new JComboBox();
        kapy.addItem("T2 (standard)");
        kapy.addItem("Modern");
        kapy.addItem("Legacy");
        kapy.addItem("Two-Headed Giant");
        kapy.addItem("Draft");
        kapy.addItem("Pentagram");
        kapy.setSelectedIndex(0);
        kapy.setEditable(false);
        kapy.setMaximumSize(new Dimension(400,40));
        kapy.setAlignmentX(Component.CENTER_ALIGNMENT);
        //wyb = new JButton("Wybierz logo");
        //wyb.setAlignmentX(Component.CENTER_ALIGNMENT);
        //wyb.addActionListener(wybieracz);
        
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
        panel.add(kapy);
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
