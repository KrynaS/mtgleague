/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Label;
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
public class Mtgi extends JFrame {
    class ButtonOKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user = "mtgadmin";
            String pass = "mtglol123";
            String dbClass = "com.mysql.jdbc.Driver";
            String dbDriver = "jdbc:mysql://db4free.net:3306/mtgleague";
            Connection conn = null;
            try {
                Class.forName(dbClass).newInstance();
                System.out.println("driver loaded");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                System.err.println(ex);
            }
            try {
                conn = DriverManager.getConnection(dbDriver, user, pass);
                System.out.println("connected");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                JOptionPane.showMessageDialog(null,
                        "Baza danych jest wyłączona.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
            String query = "Select Email, Haslo, Id, Nick, prawaAdmin FROM Uzytkownik";
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs;
            ArrayList<String> userzy1 = new ArrayList<String>();
            ArrayList<String> userzy2 = new ArrayList<String>();
            ArrayList<Integer> userzy3 = new ArrayList<Integer>();
            ArrayList<String> userzy4 = new ArrayList<String>();
            ArrayList<Integer> userzy5 = new ArrayList<Integer>();
            try {
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    //wyswietlDaneZBazy(rs);
                    userzy1.add(rs.getString(1));
                    userzy2.add(rs.getString(2));
                    userzy3.add(Integer.parseInt(rs.getString(3)));
                    userzy4.add(rs.getString(4));
                    userzy5.add(Integer.parseInt(rs.getString(5)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            boolean flaga=false;
            int adminek=0;
            for(int i=0; i<userzy1.size();i++){
                if (field.getText().equals(userzy1.get(i)) && String.valueOf(passfield.getPassword()).equals(userzy2.get(i))) {
                    login = field.getText();
                    pass = String.valueOf(passfield.getPassword());
                    id=userzy3.get(i);
                    nick=userzy4.get(i);
                    //System.out.println(nick+"  "+userzy4.get(i));
                    flaga=true;
                    if(userzy5.get(i)==1){
                        adminek=1;
                    }
                }
            }
            
            if (flaga) {
                if(adminek==1){
                    JOptionPane.showMessageDialog(null,
                            "Zalogowano jako: " + nick);
                    oknoadm oknoadm = new oknoadm(id, nick, mtgi);
                    zamknij();
                    try {
                        oknoadm.stworz();
                    } catch (SQLException ex) {
                        Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    //oknoadm.setSize(500, 215);
                    int w = oknoadm.getSize().width;
                    int h = oknoadm.getSize().height;
                    int x = (dim.width - w) / 2;
                    int y = (dim.height - h) / 2;
                    oknoadm.setLocation(x, y);
                    oknoadm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    oknoadm.setResizable(false);
                    oknoadm.setVisible(true); 
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Zalogowano jako: " + nick);
                    okno okno = new okno(id, nick, mtgi);
                    zamknij();
                    try {
                        okno.stworz();
                    } catch (SQLException ex) {
                        Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    okno.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Zły login lub hasło. Spróbuj ponownie",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class ButtonRegListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,
                            "Reejstracja dostępna na naszej stronie.");
        }
    }

//    class ButtonCancelListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            lblMessage.setText("The Cancel button was clicked");
//        }
//    }
    Mtgi mtgi;
    JButton btnOK,register;
    //JButton btnCancel;
    //JLabel lblMessage;
    JPanel panel;
    ButtonOKListener btnOKListener;
    ButtonRegListener buttonRegListener;
    //ButtonCancelListener btnCancelListener;
    String login,pass,nick;
    int id;
    JLabel l1, l2;
    JTextField field;
    JPasswordField passfield;
    public Mtgi() {
        mtgi=this;
        login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        btnOKListener = new ButtonOKListener();
        buttonRegListener = new ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();
        l1 = new JLabel("Login");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        field = new JTextField();
        field.setText("123@wp.pl");
        //field.setText("rhynos15@o2.pl");
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Hasło");
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        passfield = new JPasswordField();
        passfield.setText("123");
        //passfield.setText("haslo123");
        
        passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnOK = new JButton("Zaloguj");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        
        register = new JButton("Zarejestruj");
        register.setAlignmentX(Component.CENTER_ALIGNMENT);
        register.addActionListener(buttonRegListener);
        //btnCancel = new JButton("Cancel");
        //btnCancel.addActionListener(btnCancelListener);
        
        //lblMessage = new JLabel();
        panel.add(l1);
        panel.add(field);
        panel.add(l2);
        panel.add(passfield);
        panel.add(btnOK);
        panel.add(register);
        //pnlHolder.add(btnCancel);
        //panel.add(lblMessage);
        
        this.add(panel);
        
        
    }
    
    void zamknij() {
        this.setVisible(false);
        //this.dispose();
    }
//    static String daneZBazy;
//    static void wyswietlDaneZBazy(ResultSet rs){
//		try{
//		daneZBazy = rs.getString(1);
//		System.out.println("\n" + daneZBazy + " ");
//		daneZBazy = rs.getString(2);
//		System.out.println(daneZBazy + " ");
//		//daneZBazy = rs.getString(3);
//		//System.out.println(daneZBazy);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

    public static void main(String[] args) throws SQLException {
        Mtgi GUI = new Mtgi();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        GUI.setSize(200, 160);
        int w = GUI.getSize().width;
        int h = GUI.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        GUI.setLocation(x, y);
        GUI.setTitle("Logowanie");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setResizable(false);
        //GUI.pack();
        GUI.setVisible(true);
    }
}
