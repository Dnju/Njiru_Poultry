package njiru.poultry.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mayai extends AppCompatActivity {
private TextView egg_no;
private Button save_eggs_no;

private static String ip="192.168.1.102";
private static String port="1433";
private static String Classes="net.sourceforge.jtds.jdbc.Driver";
private static String Database="Njiru_db";
private static String uname="Dnju";
private static String pass="12345";
private static String url="jdbc.jtds:sqlserver://"+ ip+":"+port+"/"+Database;

//sql connection
    private Connection connection=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayai);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
    egg_no=findViewById(R.id.Eggs_No);
    save_eggs_no=findViewById(R.id.save_as_eggs);

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        try {
            Class.forName(Classes);
            connection= DriverManager.getConnection(url,uname,pass);
            save_eggs_no.setText("Successful");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            save_eggs_no.setText("Error");
        } catch (SQLException e) {
            e.printStackTrace();
            save_eggs_no.setText("Failed");
        }
    }

    public void SqlButton(View view){
        if(connection!=null){

            Statement statement= null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet=statement.executeQuery("Select * from eggs;");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}
