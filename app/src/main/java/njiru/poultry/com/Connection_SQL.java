package njiru.poultry.com;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;

public class Connection_SQL {
    Connection con;
    String uname, pass, ip, port, database;
    public Connection connectionclass()
    {

        ip="192.168.1.102";
        database="Njiru_db";
        uname="Dnju";
        pass="12345";
        port="1433";

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection=null;
         String ConnectionURL= null;

         try {

         }
         catch (Exception ex){
             Log.e("Error",ex.getMessage());

         }

        return null;


    }

}
