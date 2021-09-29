package njiru.poultry.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class createAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_SignUp,
                new createAccountFragment()).commit();
    }
}