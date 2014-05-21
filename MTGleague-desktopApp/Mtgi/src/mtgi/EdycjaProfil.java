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
    okno ok;
    String user;
    String pass;
    String dbClass;
    String dbDriver;
    Connection conn;
    EdycjaProfil to;
    //int idDruzynki;
    int idek;
    ArrayList<String>uzytkownicy;
    
    
    class ButtonOKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            haslo=field3.getText();
//            kapitan=(String)(kapy.getSelectedItem());
//            
//            ps = null;
//            String INSERT_PICTURE = "UPDATE Druzyna SET Logo =? WHERE Nazwa='" + druzynapoczatek + "'";
//            try {
//                conn.setAutoCommit(false);
//                try {
//                    fis = new FileInputStream(image);
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                ps = conn.prepareStatement(INSERT_PICTURE);
//                ps.setBinaryStream(1, fis, (int) image.length());
//                ps.executeUpdate();
//                conn.commit();
//            } catch (SQLException ex) {
//                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                conn.setAutoCommit(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            int kap=0;
//            String query2 = "Select id FROM Uzytkownik WHERE Nick='"+kapitan+"'";
//            Statement stmt2 = null;
//            try {
//                stmt2 = conn.createStatement();
//            } catch (SQLException ex) {
//                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ResultSet rs2;
//            //ArrayList<Integer> uzytkownicy = new ArrayList<Integer>();
//            try {
//                rs2 = stmt2.executeQuery(query2);
//                while (rs2.next()) {
//                    kap = (Integer.parseInt(rs2.getString(1)));
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ZarzadzajDruzyna.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            
//            
//            String query7 = "UPDATE Druzyna SET Kapitan='" + kap + "', Haslo='" + haslo + "' WHERE Nazwa='" + druzynapoczatek + "'";
//            Statement stmt7 = null;
//            try {
//                stmt7 = conn.createStatement();
//            } catch (SQLException ex) {
//                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                stmt7.executeUpdate(query7);
//            } catch (SQLException ex) {
//                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            String query3 = "DELETE FROM DruzynaUzytkownik WHERE idDruzyny=" + idek + " ";
//            for (int i = 0; i < uzytkownicy.size(); i++) {
//                query3 = query3 + " AND idUzytkownika!=(SELECT id FROM Uzytkownik WHERE Nick='"+uzytkownicy.get(i)+"')";
//                
////                if (i != uzytkownicy.size() - 1) {
////                    query3 = query3 + " AND idUzytkownika!=";
////                }
//            }
//            //System.out.println(query3);
//            //query3 = query3 + ")";
//            Statement stmt3 = null;
//            try {
//                stmt3 = conn.createStatement();
//            } catch (SQLException ex) {
//                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                stmt3.executeUpdate(query3);
//            } catch (SQLException ex) {
//                Logger.getLogger(okno.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            //file2.delete();
//            //image.delete();
//            File image2=new File("java.png"); 
//            image2.delete();
//            JOptionPane.showMessageDialog(null,
//                            "Zmiany zostały wprowadzone");
        }
    }
//    class ButtonRegListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            
//        }
//    }

    class ButtonCancelListener implements ActionListener {
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
            image.delete();
            wg.setVisible(false);
            setVisible(false);
            wg.dispose();
            dispose();
        }
    }
    
    class ButtonDelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            haslo=field3.getText();
            kapitan=(String)(kapy.getSelectedItem());
            Object[] metody = new Object[uzytkownicy.size()-1];
            int pos=0;
            for (int i = 0; i < uzytkownicy.size(); i++) {
                if(!uzytkownicy.get(i).equals(kapitanpoczatek)){
                    metody[pos] = uzytkownicy.get(i);
                    pos++;
                } 
            }
            String s = (String) JOptionPane.showInputDialog(to, "Wybierz gracza, którego chcesz usunąć", " ", JOptionPane.PLAIN_MESSAGE, null, metody, null);
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
                        "Usunięto z drużyny gracza "+s);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Nie wybrano gracza!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    JButton btnOK, btnDel;
    JButton btnCancel;
    JButton Logos;
    //JLabel lblMessage;
    JPanel panel;
    EdycjaProfil.ButtonOKListener btnOKListener;
    EdycjaProfil.ButtonLogosListener btnLogosListener;
    EdycjaProfil.ButtonDelListener btnDelListener;
    EdycjaProfil.ButtonCancelListener btnCancelListener;
    String druzyna, druzynapoczatek;
    int idek;
    JLabel l1, l2, l3, l14;
    JTextField field, field3;
    
    JComboBox kapy;
    //JPasswordField passfield;
    public EdycjaProfil(okno o, int nic) throws FileNotFoundException, IOException {
        ok=o;
        panel = new JPanel();
        fis=null;
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
        String query = "Select Nazwa, Nick, d.Haslo, czyZablokowana, Logo , d.Id FROM Druzyna d, Uzytkownik u WHERE d.Kapitan=u.Id AND Nazwa='"+druzyna+"'";
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
        image = new File("java.png"); 
        FileOutputStream fos = new FileOutputStream(image);
        
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                nazwaDruzyny=rs.getString(1);
                kapitanpoczatek=rs.getString(2);
                kapitan=rs.getString(2);
                haslo=rs.getString(3);
                czyZablokowana=Integer.parseInt(rs.getString(4));
                byte[] buffer = new byte[1];
                InputStream is = rs.getBinaryStream(5);
                while (is.read(buffer) > 0) {
                    fos.write(buffer);
                }
                idek=Integer.parseInt(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        fos.close();
        
        String query2 = "Select Nick FROM DruzynaUzytkownik du, Druzyna d, Uzytkownik u WHERE idDruzyny=d.id AND idUzytkownika=u.id AND Nazwa='"+druzyna+"'";
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
        
//        panel.revalidate();
//        panel.repaint();
//        to.revalidate();
//        to.repaint();
        
        
        panel=new JPanel();
        //panel.removeAll(); 
        //panel.updateUI();
        //panel.revalidate() ;
        //panel.repaint();
        //this.removeAll(); 
        //this.updateUI();
        //this.repaint();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        btnOKListener = new EdycjaProfil.ButtonOKListener();
        btnDelListener = new EdycjaProfil.ButtonDelListener();
        btnLogosListener = new EdycjaProfil.ButtonLogosListener();
        btnCancelListener = new EdycjaProfil.ButtonCancelListener();
        //buttonRegListener = new DolaczDruzyna.ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();        
//        BufferedImage img=ImageIO.read(image);
//        System.out.println(img);
//        final Image scaleImage = img.getScaledInstance(194, 194,Image.SCALE_DEFAULT);
//        System.out.println(scaleImage);
//        JPanel pane = new JPanel() {
//        @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                //AffineTransform at = AffineTransform.getScaleInstance(50, 50);
//                //g.drawRenderedImage(img, at);
//                System.out.println(image);
//                System.out.println(scaleImage);
//                g.drawImage(scaleImage, 0, 0, this);
//            }
//        };
        BufferedImage img=ImageIO.read(image);
        //System.out.println(image);
        JPanel pane = new JPanel();
        Image scaleImage = img.getScaledInstance(194, 194,Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(scaleImage));
        pane.add(picLabel);
        //System.out.println(image);
        //System.out.println(img);
        //System.out.println(scaleImage);
        
        //pane.setSize(new Dimension(190,190));
        //boolean Graphics.drawImage(img,10, 10,null);
        //pane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        l1 = new JLabel("Drużyna");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setText(nazwaDruzyny);
        field.setEditable(false);
        field.setMaximumSize(new Dimension(400,40));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Kapitan");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //passfield = new JPasswordField();
        //passfield.setText("123");
        //passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
//        field2 = new JTextField();
//        field2.setText(userzy2.get(0));
//        field2.setEditable(false);
//        field2.setMaximumSize(new Dimension(400,40));
//        field2.setAlignmentX(Component.CENTER_ALIGNMENT);
        kapy = new JComboBox();
        for(int i=0;i<uzytkownicy.size();i++){
            kapy.addItem(uzytkownicy.get(i));
        }
        int indeks=0;
        for(int i=0;i<uzytkownicy.size();i++){
            if(uzytkownicy.get(i).equals(kapitan)){
                indeks=i;
            }
        }
        kapy.setSelectedIndex(indeks);
        kapy.setEditable(false);
        kapy.setMaximumSize(new Dimension(400,40));
        kapy.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Hasło");
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        field3 = new JTextField();
        field3.setText(haslo);
        field3.setEditable(true);
        field3.setMaximumSize(new Dimension(400,40));
        field3.setAlignmentX(Component.CENTER_ALIGNMENT);
        if(czyZablokowana==0){
            l14 = new JLabel("Drużyna gotowa do rozgrywek");
        }
        else{
            l14 = new JLabel("Drużyna zablokowana");
        }
        l14.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        Logos = new JButton("Zmień Logo");
        Logos.setAlignmentX(Component.CENTER_ALIGNMENT);
        Logos.addActionListener(btnLogosListener);
        btnOK = new JButton("Zapisz zmiany");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        btnDel = new JButton("Usuń gracza");
        btnDel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDel.addActionListener(btnDelListener);
        btnCancel = new JButton("Wróć");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel.addActionListener(btnCancelListener);
        
        //lblMessage = new JLabel();
        panel.add(pane);
        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(kapy);
        
        panel.add(l3);
        panel.add(field3);
        panel.add(l14);
        
        panel.add(Logos);
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
