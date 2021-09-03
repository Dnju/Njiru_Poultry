package njiru.poultry.com;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ChickenFragment extends Fragment {
    EditText chicken, vaccine;
    Button save;
    FirebaseFirestore db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        db=FirebaseFirestore.getInstance();
        chicken = findViewById(R.id.Et_chicken);
        vaccine = findViewById(R.id.Et_vaccine);
        save=findViewById(R.id.Chicken_Save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Chicken=chicken.getText().toString();
                String Vaccine=vaccine.getText().toString();
                Map<String,Object>CHICKEN=new HashMap<>();
                CHICKEN.put("Chicken",chicken);
                CHICKEN.put("Vaccine",vaccine);
                db.collection("CHICKEN")
                        .add(CHICKEN)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(ChickenFragment.this,"Saved Successfully",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ChickenFragment.this,"Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
