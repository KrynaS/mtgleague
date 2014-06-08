


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadController")
@MultipartConfig
public class UploadController extends HttpServlet {
private static final long serialVersionUID = 1L;
       
 // database connection settings
private String dbURL = "jdbc:mysql://localhost:3306/AppDB";
private String dbUser = "root";
private String dbPass = "secret";

protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
        try {
Class.forName("com.mysql.jdbc.Driver");        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
String firstName = request.getParameter("autor");
String lastName = request.getParameter("tytul");
String blokada = request.getParameter("blokada");
String nr = request.getParameter("nr");
InputStream inputStream = null; // input stream of the upload file
Part filePart = request.getPart("file");
if (filePart != null) {
System.out.println(filePart.getName());
System.out.println(filePart.getSize());
System.out.println(filePart.getContentType());
inputStream = filePart.getInputStream();
}

Connection conn = null; // connection to the database
String message = null;

try {

conn=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     
// constructs SQL statement
String sql = "INSERT INTO Druzyna (Nazwa,Haslo,Kapitan,czyZablokowana , Logo) values (?, ?, ?, ?, ?)";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, firstName);
statement.setString(2, lastName);
statement.setString(3, nr);
statement.setString(4, blokada);
if (inputStream != null) {
statement.setBlob(5, inputStream);
}

// sends the statement to the database server
int row = statement.executeUpdate();
if (row > 0) {
message = "File uploaded and saved into database";
}
} catch (SQLException ex) {
message = "ERROR: " + ex.getMessage();
ex.printStackTrace();
} finally {
if (conn != null) {
// closes the database connection
try {
conn.close();
} catch (SQLException ex) {
ex.printStackTrace();
}
}

}
}
}


