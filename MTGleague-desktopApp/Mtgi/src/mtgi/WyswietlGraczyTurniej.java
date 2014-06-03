/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;

import java.awt.BorderLayout;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Mateusz
 */
public class WyswietlGraczyTurniej extends JFrame{
    String user;
    String pass;
    String dbClass;
    String dbDriver;
    Connection conn;
    String druzyna;
    JPanel panel;
    JLabel l1;
    ArrayList<String> userzy1;
    public WyswietlGraczyTurniej(String naz){
        druzyna=naz;
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
    void stworz(){
        String query = "Select Nick FROM Turniej d, Uzytkownik u , UzytkownikTurniej du WHERE d.Id=du.IdTurnieju AND du.IdUzytkownika=u.Id AND Nazwa='"+druzyna+"'";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        userzy1 = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userzy1.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        narysuj();
    }
    void narysuj(){
        Component[] comp = this.getContentPane().getComponents();
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] instanceof JPanel) {
                this.remove(comp[i]);
            }
        }
        this.revalidate();
        this.repaint();
        Box box = Box.createVerticalBox();
        for (int i = 0; i < userzy1.size(); i++) {
            box.add(new JLabel(userzy1.get(i)));
        }
        JScrollPane listScroller = new JScrollPane(box);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel("Lista graczy turnieju: " + druzyna);
        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0, 5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Container contentPane = getContentPane();
        contentPane.add(listPane, BorderLayout.CENTER);
        //pack();
        this.revalidate();
        this.repaint();
    }
}
