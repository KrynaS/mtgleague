/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;

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
public class okno extends javax.swing.JFrame {
    int userid;
    Connection conn;
    String nick, user, pass, dbClass, dbDriver;
    ArrayList<Integer> idDruzyny;
    ArrayList<String> druzyny, druzynylead;
    ArrayList<String> kapitany;
    Mtgi mtgi;
    public okno(int i, String nic, Mtgi m) {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikacja Desktopowa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                " ", " ", " ", " ", " "
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Stwórz drużynę");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Zarządzaj Drużyną");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Dołącz do Drużyny");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setText("Opuść drużynę");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setText("Znajdź drużynę");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addGap(0, 216, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton8)
                    .addComponent(jButton12))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Drużyny", jPanel2);

        jButton4.setText("Zapisz się na turniej");

        jButton5.setText("Zarządzaj turniejem");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Stwórz turniej");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox2.setPreferredSize(new java.awt.Dimension(56, 23));

        jButton7.setText("Opuść turniej");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(0, 337, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Turnieje", jPanel4);

        jButton9.setText("Profil");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Wyloguj");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel1.setText("Witaj");

        jButton11.setText("Odśwież");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(0, 43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StworzDruzyna a = new StworzDruzyna(userid, this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        a.setSize(200, 200);
        int w = a.getSize().width;
        int h = a.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        a.setLocation(x, y);
        a.setTitle("Stwórz drużyne");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setResizable(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //String nazwa = jComboBox1.getSelectedItem().toString();
        Object[] kolumny = new Object[druzynylead.size()];
        for (int i=0; i<druzynylead.size();i++){
            kolumny[i]=druzynylead.get(i);
        }           
        String s = (String)JOptionPane.showInputDialog(this, "Wybierz drużynę", "Parametr",  JOptionPane.PLAIN_MESSAGE, null, kolumny,null);
        if(s!=null){
            WyswietlGraczy b = null;
            b = new WyswietlGraczy(s);
            ZarzadzajDruzyna a = null;
            try {
                a = new ZarzadzajDruzyna(this, s, b);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            a.setSize(200, 465);
            int w = a.getSize().width;
            int h = a.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;
            a.setLocation(x, y);
            a.setTitle("Zarządzaj drużyną");
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            a.setResizable(false);
            a.setVisible(true);
            
            b.setSize(300, 465);
            b.setLocation(x + 210, y);
            b.setTitle("Lista Graczy");
            b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            b.setResizable(false);
            b.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,
                        "Nie wybrałeś drużyny!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DolaczDruzyna a = new DolaczDruzyna(userid, this);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        a.setSize(200, 160);
        int w = a.getSize().width;
        int h = a.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        a.setLocation(x, y);
        a.setTitle("Dołącz do drużyny");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setResizable(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Object[] metody = new Object [druzyny.size()];
        for(int i=0;i<druzyny.size();i++){
            metody[i]=druzyny.get(i);
        }
        String s = (String) JOptionPane.showInputDialog(this, "Wybierz drużynę, którą chcesz opuścić", " ", JOptionPane.PLAIN_MESSAGE, null, metody, null);
        if (s != null) {
            boolean kapitan=false;
            String query5 = "SELECT Kapitan FROM Druzyna WHERE Nazwa='"+s+"')";
            Statement stmt5 = null;
            try {
                stmt5 = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs5;
            ArrayList<Integer> userzy5 = new ArrayList<Integer>();
            try {
                rs5 = stmt5.executeQuery(query5);
                while (rs5.next()) {
                    userzy5.add(Integer.parseInt(rs5.getString(1)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(userzy5.get(0)==userid){
                kapitan=true;
            }            
                String query = "DELETE FROM DruzynaUzytkownik Where IdUzytkownika=" + userid + " AND IdDruzyny=("
                        + "SELECT Id FROM Druzyna WHERE Nazwa='" + s + "')";
                Statement stmt = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    stmt.executeUpdate(query);
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
                String query2 = "Select IdUzytkownika FROM DruzynaUzytkownik WHERE IdDruzyny=("
                        + "SELECT Id FROM Druzyna WHERE Nazwa='" + s + "')";
                Statement stmt2 = null;
                try {
                    stmt2 = conn.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet rs2;
                ArrayList<Integer> userzy1 = new ArrayList<Integer>();
                try {
                    rs2 = stmt2.executeQuery(query2);
                    while (rs2.next()) {
                        userzy1.add(Integer.parseInt(rs2.getString(1)));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (userzy1.size() == 0) {
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
                }
                else{
                    if(kapitan){
                        String query7 = "UPDATE Druzyna SET Kapitan="+ userzy1.get(0) +" WHERE Nazwa='" + s + "'";
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
                    }
                }
                try {
                    setDruzynyTable();
                } catch (SQLException ex) {
                    Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
                }
        }       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            stworz();
        } catch (SQLException ex) {
            Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
                ZnajdzDruzyna a = null;
                try {
                    a = new ZnajdzDruzyna(this, s, b);
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
                a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                a.setResizable(false);
                a.setVisible(true);
                
                b.setSize(300, 340);
                b.setLocation(x+210, y);
                b.setTitle("Lista Graczy");
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        else{
            JOptionPane.showMessageDialog(null,
                        "Nie podałeś nazwy!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

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
        a.setSize(200, 465);
        int w = a.getSize().width;
        int h = a.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        a.setLocation(x, y);
        a.setTitle("Edycja Profilu");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setResizable(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

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
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
 
    void stworz() throws SQLException{
        jLabel1.setText("Witaj, "+nick);
        setDruzynyTable();
    }
    
    void setDruzynyTable() throws SQLException{        
        String query = "Select d.Id, Nazwa, Nick FROM Druzyna d, Uzytkownik a, DruzynaUzytkownik du Where d.Id=IdDruzyny AND IdUzytkownika="+userid+" AND Kapitan=a.Id AND czyZablokowana=0";
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet rs;
        idDruzyny = new ArrayList<Integer>();
        druzyny = new ArrayList<String>();
        druzynylead = new ArrayList<String>();
        kapitany = new ArrayList<String>();
        rs = stmt.executeQuery(query);
        //jComboBox1.removeAllItems();
        while (rs.next()) {
            idDruzyny.add(Integer.parseInt(rs.getString(1)));
            druzyny.add(rs.getString(2));
            kapitany.add(rs.getString(3));
            if(rs.getString(3).equals(nick)){
                druzynylead.add(rs.getString(2));
            }
        }
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        Object[] kolumny = new Object[3];
        kolumny[0] = "Id";
        kolumny[1] = "Nazwa";
        kolumny[2] = "Kapitan";
        Object[][] tablicaobjektow=new Object[druzyny.size()][3]; //trzeba na odwrót wysokosc z szerokoscia
        for(int i=0;i<druzyny.size();i++){
            tablicaobjektow[i][0] = idDruzyny.get(i);
            tablicaobjektow[i][1] = druzyny.get(i);
            tablicaobjektow[i][2] = kapitany.get(i);
        }
        jTable1 = new JTable(tablicaobjektow, kolumny);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);
    }
    
}
