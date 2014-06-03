/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
import javax.swing.JTextField;

/**
 *
 * @author Mateusz
 */
public final class ZarzadzajTurniejemDr extends JFrame {
    okno ok;
    WyswietlGraczyTurniejDr wg;
    String user;
    String pass;
    String dbClass;
    String dbDriver;
    Connection conn;
    ZarzadzajTurniejemDr to;
    //int idDruzynki;
    String nazwaDruzyny;
    String kapitan, kapitanpoczatek;
    String haslo;
    int czyZablokowana;
    ArrayList<String>uzytkownicy;
    
    class ButtonOKListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String datka = field2.getText();
            boolean flag = true;  //jesli dobra data to true
            for (int i = 0; i < 10; i++) {
                boolean temp = true;
                if (i != 4 && i != 7) {
                    temp = Character.isDigit(datka.charAt(i));
                } else {
                    if (datka.charAt(i) != '-') {
                        temp = false;
                    }
                }
                if (!temp) {
                    flag = false;
                }
            }
            boolean flag2 = true;  //jesli dobra data to true
            if (datka.charAt(0) - '0' > 2 || datka.charAt(5) - '0' > 1 || datka.charAt(8) - '0' > 3 || (datka.charAt(5) - '0' == 1 && datka.charAt(6) - '0' > 2) || (datka.charAt(8) - '0' == 3 && datka.charAt(9) - '0' > 1)) {
                //System.out.println(datka.charAt(0)+" "+datka.charAt(5)+" "+datka.charAt(5)+datka.charAt(6)+" "+datka.charAt(8)+" "+datka.charAt(8)+datka.charAt(9));
                flag2 = false;
            }
            if (datka.length() != 10 || !flag || !flag2) {
                JOptionPane.showMessageDialog(null,
                        "Data musi być w formacie YYYY-MM-DD i musi być prawdziwa!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } 
            else {
                String query7 = "UPDATE Turniej SET Data='" + field2.getText() + "' WHERE id='" + idek + "'";
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
                
                String query3 = "DELETE FROM DruzynaTurniej WHERE idTurnieju=" + idek + " ";
                for (int i = 0; i < uzytkownicy.size(); i++) {
                    query3 = query3 + " AND idDruzyny!=(SELECT id FROM Druzyna WHERE Nazwa='" + uzytkownicy.get(i) + "')";

//                if (i != uzytkownicy.size() - 1) {
//                    query3 = query3 + " AND idUzytkownika!=";
//                }
                }
                //System.out.println(query3);
                //query3 = query3 + ")";
                Statement stmt3 = null;
                try {
                    stmt3 = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    stmt3.executeUpdate(query3);
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JOptionPane.showMessageDialog(null,
                        "Zmiany zostały wprowadzone");
                try {
                    ok.stworz();
                } catch (SQLException ex) {
                    Logger.getLogger(ZarzadzajTurniejem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class ButtonCancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ok.stworz();
            } catch (SQLException ex) {
                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    class ButtonDelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            data=field2.getText();
            Object[] metody = new Object[uzytkownicy.size()];
            for (int i = 0; i < uzytkownicy.size(); i++) {
                    metody[i] = uzytkownicy.get(i);
            }
            String s = (String) JOptionPane.showInputDialog(to, "Wybierz drużynę, którą chcesz usunąć", " ", JOptionPane.PLAIN_MESSAGE, null, metody, null);
            if (s != null) {
//                String query = "DELETE FROM DruzynaUzytkownik Where IdUzytkownika= ("
//                        + "SELECT Id FROM Uzytkownik WHERE Nick='" + s + "') AND IdDruzyny=("
//                        + "SELECT Id FROM Druzyna WHERE Nazwa='" + druzynapoczatek + "')";
//                Statement stmt = null;
//                try {
//                    stmt = conn.createStatement();
//                } catch (SQLException ex) {
//                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                try {
//                    stmt.executeUpdate(query);
//                } catch (SQLException ex) {
//                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
//                }
                //int indeks;
                for (int i = 0; i < uzytkownicy.size(); i++) {
                    if(uzytkownicy.get(i).equals(s)){
                        uzytkownicy.remove(i);
                    }
                }
                for (int i = 0; i < wg.userzy1.size(); i++) {
                    if(wg.userzy1.get(i).equals(s)){
                        wg.userzy1.remove(i); 
                    }
                }
                wg.narysuj();
                Component[] comp = to.getContentPane().getComponents();
                for (int i = 0; i < comp.length; i++) {
                    if (comp[i] instanceof JPanel) {
                        to.remove(comp[i]);
                    }
                }
                to.revalidate();
                to.repaint();
                try {
                    to.narysuj();
                } catch (IOException ex) {
                    Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,
                        "Usunięto z turnieju drużynę "+s);
            }
        }
    }

    JButton btnOK, btnDel;
    JButton btnCancel;
    //JLabel lblMessage;
    JPanel panel;
    ZarzadzajTurniejemDr.ButtonOKListener btnOKListener;
    ZarzadzajTurniejemDr.ButtonDelListener btnDelListener;
    ZarzadzajTurniejemDr.ButtonCancelListener btnCancelListener;
    String druzyna, druzynapoczatek, data, zalozyciel, typ;
    int idek;
    JLabel l1, l2, l3, l4;
    JTextField field, field2, field3, field4;
    
    JComboBox kapy;
    //JPasswordField passfield;
    public ZarzadzajTurniejemDr(okno o, String naz, WyswietlGraczyTurniejDr wgx) throws FileNotFoundException, IOException {
        ok=o;
        panel = new JPanel();
        druzyna=naz;
        druzynapoczatek=naz;
        wg=wgx;
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
        String query = "Select Nazwa, Data, Zalozyciel, Typ, Id FROM Turniej WHERE Nazwa='"+druzyna+"'";
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
                nazwaDruzyny=rs.getString(1);
                data=rs.getString(2);
                zalozyciel=rs.getString(3);
                typ=rs.getString(4);
                idek=Integer.parseInt(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        String query2 = "Select Nazwa FROM DruzynaTurniej du, Druzyna u WHERE idDruzyny=u.id AND idTurnieju='"+idek+"'";
        Statement stmt2 = null;
        try {
            stmt2 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs2;
        uzytkownicy = new ArrayList<String>();
        try {
            rs2 = stmt2.executeQuery(query2);
            while (rs2.next()) {
                uzytkownicy.add(rs2.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        narysuj();
        
    }
    void narysuj() throws IOException{

        panel=new JPanel();

        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        btnOKListener = new ZarzadzajTurniejemDr.ButtonOKListener();
        btnDelListener = new ZarzadzajTurniejemDr.ButtonDelListener();
        btnCancelListener = new ZarzadzajTurniejemDr.ButtonCancelListener();


        l1 = new JLabel("Nazwa");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setText(nazwaDruzyny);
        field.setEditable(false);
        field.setMaximumSize(new Dimension(400,40));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Data");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        field2 = new JTextField();
        field2.setText(data);
        //field2.setEditable(false);
        field2.setMaximumSize(new Dimension(400,40));
        field2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Typ");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        field3 = new JTextField();
        field3.setText(typ);
        field3.setEditable(false);
        field3.setMaximumSize(new Dimension(400,40));
        l4 = new JLabel("Zalozyciel");
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        field4 = new JTextField();
        field4.setText(nazwaDruzyny);
        field4.setEditable(false);
        field4.setMaximumSize(new Dimension(400,40));
        

        btnOK = new JButton("Zapisz zmiany");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        btnDel = new JButton("Usuń drużynę");
        btnDel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDel.addActionListener(btnDelListener);
        btnCancel = new JButton("Wróć");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel.addActionListener(btnCancelListener);
        
        //lblMessage = new JLabel();

        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(field2);
        panel.add(l3);
        panel.add(field3);
        panel.add(l4);
        panel.add(field4);
        
        panel.add(btnDel);
        panel.add(btnOK);
        //panel.add(register);
        panel.add(btnCancel);
        //panel.add(lblMessage);
        
        to.add(panel);
        //System.out.println(this);
        to.revalidate();
        to.repaint();
    }
}
