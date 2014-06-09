package com.example.mtgorganizer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.mysql.jdbc.CommunicationsException;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class Login_Activity extends Activity {

	private static final String url = "jdbc:mysql://mysql.cba.pl/tankitanki_cba_pl";
	private static final String user = "mtgleague";
	private static final String pass = "mtg123lol";
	private ProgressBar koleczko;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		setButtonZaloguj();
		koleczko = (ProgressBar)findViewById(R.id.progressBarLog);
		koleczko.setVisibility(View.GONE);
	}
	
	private void setButtonZaloguj() {
		Button zaloguj = (Button)findViewById(R.id.zalogujbutton);
		zaloguj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	AsyncTask<Void, Integer, String> conn = new DbConnector();
            	try {
            		koleczko.setVisibility(View.VISIBLE);
            		String response = conn.execute().get();
            		koleczko.setVisibility(View.GONE);
            		Intent myIntent = new Intent(Login_Activity.this, MainActivity.class);
            		myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            		
            		if(response.contains("SUCCESSLOGIN##%"))
            		{
            			myIntent.putExtra("login", ((EditText)findViewById(R.id.getlogin)).getText().toString());
    	            }      
            		else if(response.contains("Niepoprawny login lub haslo"))
            		{
            			Toast.makeText(getApplicationContext(), "Niepoprawny login lub haslo", Toast.LENGTH_SHORT).show();
            		}
            		else if(response.contains("B³¹d po³¹czenia z baz¹"))
            		{
            			Toast.makeText(getApplicationContext(), "B³¹d po³¹czenia z serwerem", Toast.LENGTH_SHORT).show();
            		}
            		else
            		{
            			myIntent.putExtra("login", ((EditText)findViewById(R.id.getlogin)).getText().toString());
                		Login_Activity.this.startActivity(myIntent);
            		}
            		
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			return rootView;
		}		
	}
	
	public class DbConnector extends AsyncTask<Void, Integer, String>{

		protected String doInBackground(Void... arg0) {
			
			try {
//				HttpClient client = new DefaultHttpClient();
//				HttpPost post = new HttpPost("http://www.tankitanki.cba.pl/login.php");
		        //koleczko.setVisibility(View.VISIBLE);
				String login = ((EditText)findViewById(R.id.getlogin)).getText().toString();
				String haslo = ((EditText)findViewById(R.id.getpass)).getText().toString();
				String responseString = "";
				
//				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//				pairs.add(new BasicNameValuePair("name", login));
//				pairs.add(new BasicNameValuePair("pass", haslo));
//				
//				post.setEntity(new UrlEncodedFormEntity(pairs));
//				HttpResponse response = client.execute(post);
				/*ByteArrayOutputStream out = new ByteArrayOutputStream();
		        response.getEntity().writeTo(out);
		        out.close();*/
				
//				responseString = EntityUtils.toString(response.getEntity());	
				
				Class.forName("com.mysql.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague", "mtgadmin", "mtglol123");
		        /* System.out.println("Database connection success"); */
		        
		        String result = "";
		        Statement st = con.createStatement();
		        ResultSet rs = st.executeQuery("select Nick from Uzytkownik where email='" + login + "' AND haslo='" + haslo + "'");
		        ResultSetMetaData rsmd = rs.getMetaData();

		        result += rs.getString(1);
		        
		        responseString = result;
		        //koleczko.setVisibility(View.GONE);
		        return responseString;
		        
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.getCause();
				koleczko.setVisibility(View.GONE);
				return "B³êdny";			
			}	
			catch (CommunicationsException e) {
				// TODO Auto-generated catch block
				e.getCause();
				koleczko.setVisibility(View.GONE);
				return "B³¹d po³¹czenia z baz¹";			
			}	
			catch (SQLException e) {
				// TODO Auto-generated catch block
				if(e.getMessage().contains("Illegal operation on empty result set"))
				{
					koleczko.setVisibility(View.GONE);
					return "Niepoprawny login lub haslo";
				}
				
				koleczko.setVisibility(View.GONE);
				return "Waaaat?! Contact app developer";			
			}
		}
		
		protected void onProgressUpdate(Integer... progress) {
	        //setProgressPercent(progress[0]);
	    }

	    protected void onPostExecute(String result) {
	    	
	    }
	}
}
