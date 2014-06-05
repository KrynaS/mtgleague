package mtgi;

import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StworzTurniej extends JFrame {
    int identyfikator;
    okno ok;
    StworzTurniej to;
    JButton btnOK;
    JButton btnCancel;
    JPanel panel;
    StworzTurniej.ButtonOKListener btnOKListener;
    StworzTurniej.ButtonCancelListener btnCancelListener;
    JLabel l1, l2, l3;
    JTextField field, passfield;
    JComboBox kapy;
    
    public StworzTurniej(int id, okno o) {
        to=this;
        ok=o;
        identyfikator=id;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        btnOKListener = new StworzTurniej.ButtonOKListener();
        btnCancelListener = new StworzTurniej.ButtonCancelListener();
        l1 = new JLabel("Nazwa");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Data");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        passfield = new JTextField();
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
        btnOK = new JButton("Stwórz");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        btnCancel = new JButton("Wróć");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel.addActionListener(btnCancelListener);
        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(passfield);
        panel.add(l3);
        panel.add(kapy);
        panel.add(btnOK);
        panel.add(btnCancel);
        this.add(panel);     
    }
    
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
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        System.err.println(ex);
                    }
                    try {
                        conn = DriverManager.getConnection(dbDriver, user, pass);
                    } catch (SQLException ex) {
                        System.out.println("SQLException: " + ex.getMessage());
                        JOptionPane.showMessageDialog(null,
                                "Baza danych jest wyłączona.",
                                "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    //sprawdzenie czy nazwa podana przez użytkownika jest unikalna
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
                    //jeśli nazwa jest unikalna i prawidłowa to tworzymy turniej
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
                        //odświeżenie tabeli w panelu użytkownika
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

    class ButtonCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }   
}
