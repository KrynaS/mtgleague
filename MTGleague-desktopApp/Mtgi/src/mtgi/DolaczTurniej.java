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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DolaczTurniej extends JFrame {
    int identyfikator;
    okno ok;
    DolaczTurniej dt;
    class ButtonOKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
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
            String query = "Select Nazwa, Typ, Id FROM Turniej";
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
            try {
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    userzy1.add(rs.getString(1));
                    userzy2.add(rs.getString(2));
                    userzy5.add(Integer.parseInt(rs.getString(3)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean flaga=false;
            boolean flaga2=false;
            for(int i=0; i<userzy1.size();i++){
                if (field.getText().equals(userzy1.get(i))) {
                    flaga2 = true;
                    if (userzy2.get(i).equals("Two-Headed Giant")) {
                        String query8 = "Select Nazwa, Id FROM Druzyna, DruzynaUzytkownik Where Id=IdDruzyny AND IdUzytkownika=" + identyfikator + " AND czyZablokowana=0";
                        Statement stmt8 = null;
                        ArrayList<String> druzyny = new ArrayList<String>();
                        ArrayList<Integer> ajdiki = new ArrayList<Integer>();
                        try {
                            stmt8 = conn.createStatement();
                            ResultSet rs8;
                            rs8 = stmt8.executeQuery(query8);
                            //jComboBox1.removeAllItems();
                            while (rs8.next()) {
                                druzyny.add(rs8.getString(1));
                                ajdiki.add(Integer.parseInt(rs8.getString(2)));
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(DolaczTurniej.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Object[] metody = new Object[druzyny.size()];
                        for (int j = 0; j < druzyny.size(); j++) {
                            metody[j] = druzyny.get(j);
                        }
                        String s2 = (String) JOptionPane.showInputDialog(dt, "Wybrany turniej jest turniejem drużynowym.\n Wybierz drużynę, której jesteś kapitanem.", "Wybierz drużynę", JOptionPane.PLAIN_MESSAGE, null, metody, null);
                        if (s2 != null) {
                            int idteamu=-1;
                            for (int j = 0; j < druzyny.size(); j++) {
                                if(s2.equals(druzyny.get(j))){
                                    idteamu=ajdiki.get(j);
                                }
                            }
                            druzyna = userzy1.get(i);
                            idek = userzy5.get(i);
                            String query3 = "Select IdTurnieju FROM DruzynaTurniej WHERE IdDruzyny=" + idteamu + " AND IdTurnieju=" + idek + "";
                            Statement stmt3 = null;
                            try {
                                stmt3 = conn.createStatement();
                            } catch (SQLException ex) {
                                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ResultSet rs3;
                            ArrayList<String> userzy3 = new ArrayList<String>();
                            //ArrayList<String> userzy4 = new ArrayList<String>();
                            try {
                                rs3 = stmt3.executeQuery(query3);
                                while (rs3.next()) {
                                    userzy3.add(rs3.getString(1));
                                    //userzy4.add(rs3.getString(2));
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (userzy3.size() == 0) {
                                Statement stmt2 = null;
                                try {
                                    stmt2 = conn.createStatement();
                                } catch (SQLException ex) {
                                    Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    stmt2.executeUpdate("INSERT INTO DruzynaTurniej VALUES (" + idteamu + ", " + idek + ")");
                                } catch (SQLException ex) {
                                    Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                flaga = true;
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Wybrana drużyna jest już zapisana do tego turnieju!",
                                        "Error Message",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }  
                    } 
                    else {
                        druzyna = userzy1.get(i);
                        idek = userzy5.get(i);
                        String query3 = "Select IdTurnieju FROM UzytkownikTurniej WHERE IdUzytkownika=" + identyfikator + " AND IdTurnieju=" + idek + "";
                        Statement stmt3 = null;
                        try {
                            stmt3 = conn.createStatement();
                        } catch (SQLException ex) {
                            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ResultSet rs3;
                        ArrayList<String> userzy3 = new ArrayList<String>();
                        //ArrayList<String> userzy4 = new ArrayList<String>();
                        try {
                            rs3 = stmt3.executeQuery(query3);
                            while (rs3.next()) {
                                userzy3.add(rs3.getString(1));
                                //userzy4.add(rs3.getString(2));
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (userzy3.size() == 0) {
                            Statement stmt2 = null;
                            try {
                                stmt2 = conn.createStatement();
                            } catch (SQLException ex) {
                                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                stmt2.executeUpdate("INSERT INTO UzytkownikTurniej VALUES (" + identyfikator + ", " + idek + ")");
                            } catch (SQLException ex) {
                                Logger.getLogger(DolaczDruzyna.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            flaga = true;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Jesteś już zapisany do tego turnieju!",
                                    "Error Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            if (flaga) {
                JOptionPane.showMessageDialog(null,
                        "Dołączono do turnieju: "+druzyna);
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
            } else {
                if(!flaga2){
                    JOptionPane.showMessageDialog(null,
                        "Turniej o podanej nazwie nie istnieje",
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

    class ButtonCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //lblMessage.setText("The Cancel button was clicked");
            setVisible(false);
            dispose();
        }
    }

    JButton btnOK,register;
    JButton btnCancel;
    //JLabel lblMessage;
    JPanel panel;
    DolaczTurniej.ButtonOKListener btnOKListener;
    //DolaczDruzyna.ButtonRegListener buttonRegListener;
    DolaczTurniej.ButtonCancelListener btnCancelListener;
    String druzyna;
    int idek;
    JLabel l1, l2;
    JTextField field;
    JPasswordField passfield;
    public DolaczTurniej(int id, okno o) {
        ok=o;
        dt=this;
        identyfikator=id;
        //login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        btnOKListener = new DolaczTurniej.ButtonOKListener();
        btnCancelListener = new DolaczTurniej.ButtonCancelListener();
        //buttonRegListener = new DolaczDruzyna.ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();
        l1 = new JLabel("Nazwa Turnieju");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        //field.setText("123@wp.pl");
        //field.setColumns(10);
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
//        l2 = new JLabel("Hasło");
//        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
//        passfield = new JPasswordField();
//        //passfield.setText("123");
//        passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnOK = new JButton("Dołącz");
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
//        panel.add(l2);
//        panel.add(passfield);
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
