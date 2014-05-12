/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;
import java.awt.BorderLayout;
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
            }
            String query = "Select Email, Haslo, Id, Nick FROM Uzytkownik";
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
            try {
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    //wyswietlDaneZBazy(rs);
                    userzy1.add(rs.getString(1));
                    userzy2.add(rs.getString(2));
                    userzy3.add(Integer.parseInt(rs.getString(3)));
                    userzy4.add(rs.getString(4));
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
            for(int i=0; i<userzy1.size();i++){
                if (field.getText().equals(userzy1.get(i)) && String.valueOf(passfield.getPassword()).equals(userzy2.get(i))) {
                    login = field.getText();
                    pass = String.valueOf(passfield.getPassword());
                    id=userzy3.get(i);
                    nick=userzy4.get(i);
                    //System.out.println(nick+"  "+userzy4.get(i));
                    flaga=true;
                }
            }
            
            if (flaga) {
                JOptionPane.showMessageDialog(null,
                        "Zalogowano jako: "+login);
                okno okno = new okno(id, nick);
                zamknij();
                try {
                    okno.stworz();
                } catch (SQLException ex) {
                    Logger.getLogger(Mtgi.class.getName()).log(Level.SEVERE, null, ex);
                }
                okno.setVisible(true);
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
            
        }
    }

//    class ButtonCancelListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            lblMessage.setText("The Cancel button was clicked");
//        }
//    }

    JButton btnOK,register;
    //JButton btnCancel;
    JLabel lblMessage;
    JPanel panel;
    ButtonOKListener btnOKListener;
    ButtonRegListener buttonRegListener;
    //ButtonCancelListener btnCancelListener;
    String login,pass,nick;
    int id;
    JTextField field;
    JPasswordField passfield;
    public Mtgi() {
        login=null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        btnOKListener = new ButtonOKListener();
        buttonRegListener = new ButtonRegListener();
        //btnCancelListener = new ButtonCancelListener();
        field = new JTextField();
        //field.setColumns(10);
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        passfield = new JPasswordField();
        passfield.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnOK = new JButton("Zaloguj");
        btnOK.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOK.addActionListener(btnOKListener);
        
        register = new JButton("Zarejestruj");
        register.setAlignmentX(Component.CENTER_ALIGNMENT);
        register.addActionListener(buttonRegListener);
        //btnCancel = new JButton("Cancel");
        //btnCancel.addActionListener(btnCancelListener);
        
        lblMessage = new JLabel();
        panel.add(field);
        panel.add(passfield);
        panel.add(btnOK);
        panel.add(register);
        //pnlHolder.add(btnCancel);
        panel.add(lblMessage);
        
        this.add(panel);
        
        
    }
    
    void zamknij() {
        this.setVisible(false);
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
        GUI.setSize(200, 130);
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
