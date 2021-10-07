package njiru.poultry.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Retrofit;

public class Egg_testapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_testapi);
        getEggsResponse();
    }

    private void getEggsResponse() {
        Retrofit retrofit= new Retrofit.Builder()
                .build()
                .baseUrl("https://localhost:5001/api/Egg/all")


    }
}