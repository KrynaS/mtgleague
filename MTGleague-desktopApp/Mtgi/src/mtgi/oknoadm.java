package mtgi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import mtgi.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Mateusz
 */
public class oknoadm extends javax.swing.JFrame {
    int userid;
    Connection conn;
    String nick, user, pass, dbClass, dbDriver;
    Mtgi mtgi;
    public oknoadm(int i, String nic, Mtgi m) {
        mtgi=m;
        userid=i;
        nick = nic;
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
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel Administracyjny");
        setResizable(false);

        jButton9.setText("Profil");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel1.setText("Witaj");

        jLabel2.setText("Użytkownicy");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setText("Znajdź użytkownika");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Usuń użytkownika");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Drużyny");

        jButton12.setText("Znajdź drużynę");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton3.setText("Zablokuj użytkownika");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Usuń drużynę");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Zablokuj drużynę");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("Turnieje");

        jButton6.setText("Znajdź turniej");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Usuń turniej");

        jButton10.setText("Wyloguj");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setText("Odblokuj użytkownika");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setText("Odblokuj drużynę");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(167, 167, 167))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton7))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11)))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
        }
        mtgi.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        EdycjaProfil a = null;
        try {
            a = new EdycjaProfil(this, userid);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        a.setSize(200, 280);
        int w = a.getSize().width;
        int h = a.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        a.setLocation(x, y);
        a.setTitle("Edycja Profilu");
        //a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setResizable(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String query5 = "SELECT Nazwa FROM Druzyna";
        Statement stmt5 = null;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj nazwę drużyny", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                }
            }
            if (flaga) {
                WyswietlGraczy b = null;
                b = new WyswietlGraczy(s);
                ZnajdzDruzynaAdm a = null;
                try {
                    a = new ZnajdzDruzynaAdm(this, s, b);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                a.setSize(200, 340);
                int w = a.getSize().width;
                int h = a.getSize().height;
                int x = (dim.width - w) / 2;
                int y = (dim.height - h) / 2;
                a.setLocation(x, y);
                a.setTitle("Szczegóły drużyny");
                //a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                a.setResizable(false);
                a.setVisible(true);

                b.setSize(300, 340);
                b.setLocation(x+210, y);
                b.setTitle("Lista Graczy");
                //b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.setResizable(false);
                b.setVisible(true);

            }
            else{
                JOptionPane.showMessageDialog(null,
                    "Drużyna o takiej nazwie nie istnieje!",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String query5 = "SELECT Email, Id FROM Uzytkownik";
        Statement stmt5 = null;
        int idek=-1;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        ArrayList<Integer> userzy6 = new ArrayList<Integer>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
                userzy6.add(Integer.parseInt(rs5.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj login użytkownika", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                    idek=userzy6.get(i);
                }
            }
            if (flaga) {
                String query7 = "UPDATE Uzytkownik SET czyZablokowany=1 WHERE Id="+idek+"";
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
                            "Użytkownik "+s+" został zablokowany");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Użytkownik o takim loginie nie istnieje!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String query5 = "SELECT Nazwa, Id FROM Druzyna";
        Statement stmt5 = null;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        ArrayList<Integer> userzy6 = new ArrayList<Integer>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
                userzy6.add(Integer.parseInt(rs5.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj nazwę drużyny", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                }
            }
            if (flaga) {
                String query3 = "DELETE FROM Druzyna WHERE Nazwa='" + s + "'";
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
                String query2 = "DELETE FROM DruzynaUzytkownik WHERE IdDruzyny=" + userzy6.get(0) + "";
                Statement stmt2 = null;
                try {
                    stmt2 = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    stmt2.executeUpdate(query2);
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,
                            "Drużyna "+s+" została usunięta");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Drużyna o takiej nazwie nie istnieje!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String query5 = "SELECT Nazwa, Id FROM Druzyna";
        Statement stmt5 = null;
        int idek=-1;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        ArrayList<Integer> userzy6 = new ArrayList<Integer>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
                userzy6.add(Integer.parseInt(rs5.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj nazwę drużyny", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                    idek=userzy6.get(i);
                }
            }
            if (flaga) {
                String query7 = "UPDATE Druzyna SET czyZablokowana=1 WHERE Id="+idek+"";
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
                            "Drużyna "+s+" została zablokowana");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Drużyna o takiej nazwie nie istnieje!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String query5 = "SELECT Email, Id FROM Uzytkownik";
        Statement stmt5 = null;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        ArrayList<Integer> userzy6 = new ArrayList<Integer>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
                userzy6.add(Integer.parseInt(rs5.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj login użytkownika", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                }
            }
            if (flaga) {
                String query3 = "DELETE FROM Uzytkownik WHERE Email='" + s + "'";
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
                String query2 = "DELETE FROM DruzynaUzytkownik WHERE IdUzytkownika=" + userzy6.get(0) + "";
                Statement stmt2 = null;
                try {
                    stmt2 = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    stmt2.executeUpdate(query2);
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,
                            "Użytkownik "+s+" został usunięty");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Użytkownik o takim loginie nie istnieje!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String query5 = "SELECT Email, Id FROM Uzytkownik";
        Statement stmt5 = null;
        int idek=-1;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        ArrayList<Integer> userzy6 = new ArrayList<Integer>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
                userzy6.add(Integer.parseInt(rs5.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj login użytkownika", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                    idek=userzy6.get(i);
                }
            }
            if (flaga) {
                String query7 = "UPDATE Uzytkownik SET czyZablokowany=0 WHERE Id="+idek+"";
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
                            "Użytkownik "+s+" został odblokowany");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Użytkownik o takim loginie nie istnieje!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String query5 = "SELECT Nazwa, Id FROM Druzyna";
        Statement stmt5 = null;
        int idek=-1;
        try {
            stmt5 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs5;
        ArrayList<String> userzy5 = new ArrayList<String>();
        ArrayList<Integer> userzy6 = new ArrayList<Integer>();
        try {
            rs5 = stmt5.executeQuery(query5);
            while (rs5.next()) {
                userzy5.add(rs5.getString(1));
                userzy6.add(Integer.parseInt(rs5.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = (String)JOptionPane.showInputDialog(this, "Podaj nazwę drużyny", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, null,null);
        if(s!=null){
            boolean flaga = false;
            for (int i=0;i<userzy5.size();i++){
                if(userzy5.get(i).equals(s)){
                    flaga=true;
                    idek=userzy6.get(i);
                }
            }
            if (flaga) {
                String query7 = "UPDATE Druzyna SET czyZablokowana=0 WHERE Id="+idek+"";
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
                            "Drużyna "+s+" została odblokowana");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Drużyna o takiej nazwie nie istnieje!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new okno().setVisible(true);
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
 
    void stworz() throws SQLException{
        jLabel1.setText("Witaj, "+nick);
    }   
}
