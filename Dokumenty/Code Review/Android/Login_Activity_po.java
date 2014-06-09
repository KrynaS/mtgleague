package com.example.mtgorganizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mysql.jdbc.CommunicationsException;

public class Login_Activity extends Activity {

	@Override
	// Za³adowanie widoku
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	// Metoda wywo³ywana przy starcie
	protected void onStart() {
		super.onStart();
		setButtonZaloguj();
	}

	// Ustawienie przycisku logowania
	private void setButtonZaloguj() {
		Button zaloguj = (Button) findViewById(R.id.zalogujbutton);
		zaloguj.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				AsyncTask<Void, Integer, String> conn = new DbConnector();
				try {
					String response = conn.execute().get();
					Intent myIntent = new Intent(Login_Activity.this,
							MainActivity.class);
					myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_NEW_TASK);

					if (response.contains("Niepoprawny login lub haslo")) {
						Toast.makeText(getApplicationContext(),
								"Niepoprawny login lub haslo",
								Toast.LENGTH_SHORT).show();
					} else if (response.contains("B³¹d po³¹czenia z baz¹")) {
						Toast.makeText(getApplicationContext(),
								"B³¹d po³¹czenia z serwerem",
								Toast.LENGTH_SHORT).show();
					} else {
						myIntent.putExtra("login",
								((EditText) findViewById(R.id.getlogin))
										.getText().toString());
						Login_Activity.this.startActivity(myIntent);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(),
							"Waaaat?! Contact app developer",
							Toast.LENGTH_SHORT).show();
				} catch (ExecutionException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(),
							"Waaaat?! Contact app developer",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	// Stworzenie menu
	public boolean onCreateOptionsMenu(Menu menu) {

		// getMenuInflater().inflate(R.menu.login_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// int id = item.getItemId();
		// if (id == R.id.action_settings) {
		// return true;
		// }
		// return super.onOptionsItemSelected(item);
		return true;
	}

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

	// Klasa obs³uguj¹ca po³¹czenie z baz¹ danych na oddzielnym w¹tku
	public class DbConnector extends AsyncTask<Void, Integer, String> {

		protected String doInBackground(Void... arg0) {
			// Logowanie do aplikacji
			try {
				String login = ((EditText) findViewById(R.id.getlogin))
						.getText().toString();
				String haslo = ((EditText) findViewById(R.id.getpass))
						.getText().toString();
				String responseString = "";

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://db4free.net:3306/mtgleague", "mtgadmin",
						"mtglol123");

				String result = "";
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("select Nick from Uzytkownik where email='"
								+ login + "' AND haslo='" + haslo + "'");
				ResultSetMetaData rsmd = rs.getMetaData();

				result += rs.getString(1);

				responseString = result;
				return responseString;

			} catch (ClassNotFoundException e) {
				e.getCause();
				return "B³êdny driver bazy danych, skontaktuj siê z programist¹";
			} catch (CommunicationsException e) {
				e.getCause();
				return "B³¹d po³¹czenia z baz¹";
			} catch (SQLException e) {
				if (e.getMessage().contains(
						"Illegal operation on empty result set")) {
					return "Niepoprawny login lub haslo";
				}
				return "Waaaat?! Contact app developer";
			}
		}

		protected void onProgressUpdate(Integer... progress) {
		}

		protected void onPostExecute(String result) {
		}
	}
}
