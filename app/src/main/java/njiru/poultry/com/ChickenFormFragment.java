package njiru.poultry.com;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ChickenFormFragment extends Fragment {
    private EditText chicken, vaccine;
    private Button save;
    private FirebaseFirestore db;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken_form, container, false);


            db = FirebaseFirestore.getInstance();
            chicken = view.findViewById(R.id.Et_chicken);
            vaccine = view.findViewById(R.id.Et_vaccine);
            save = view.findViewById(R.id.Chicken_Save_button);
            spinner=(Spinner) view.findViewById(R.id.Chicken_spinner);

            ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(getContext(),R.array.Chicken_type, android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Chicken = chicken.getText().toString();
                    String Vaccine = vaccine.getText().toString();

                    Map<String, Object> CHICKEN = new HashMap<>();
                    CHICKEN.put("Chicken", Chicken);
                    CHICKEN.put("Vaccine", Vaccine);
                    db.collection("CHICKEN")
                            .add(CHICKEN)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "Saved Successfully",
                                            Toast.LENGTH_SHORT).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception ex) {
                            Toast.makeText(getContext(), "Failed",
                                    Toast.LENGTH_SHORT).show();
                            Log.e(getContext().getClass().getSimpleName(),"Error: " + ex.getMessage());
                        }


                    });
                }
            });
        return view;
    }
    }
