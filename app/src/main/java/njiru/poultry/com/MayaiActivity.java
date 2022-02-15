package njiru.poultry.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MayaiActivity extends AppCompatActivity {

    MayaiDatabaseHelper mdb;

EditText Eggs;
Button Save, View, Delete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mdb=new MayaiDatabaseHelper(this);
        Eggs=findViewById(R.id.Eggs_No);
        View=findViewById(R.id.View_Eggs);
        Save=findViewById(R.id.save_as_eggs);
        Delete=findViewById(R.id.Delete_Eggs);




    }

    public void savedata(){
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                boolean isInsertet = mdb.insertData(Eggs.getText().toString());
                if (isInsertet = true)
                    Toast.makeText(MayaiActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MayaiActivity.this, "Data Not Inserted ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}