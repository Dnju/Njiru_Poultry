package njiru.poultry.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeScreen extends AppCompatActivity {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(WelcomeScreen.this, MainActivity.class));
            finish();
        }, 2000);
    }
}