package njiru.poultry.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class MealFormFragment extends Fragment {
    private EditText mMeal;
    private Button mSave;
    private EditText mQuantity;
    private FirebaseFirestore db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_form, container, false);

        mMeal = (EditText) view.findViewById(R.id.meal_c_name);
        mSave = (Button) view.findViewById(R.id.meal_save);
        mQuantity = (EditText) view.findViewById(R.id.meal_amount);
        db = FirebaseFirestore.getInstance();

        //get and save data to Firebase Firestore DB
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Meals = mMeal.getText().toString();
                String Quantity = mQuantity.getText().toString();


                Map<String, Object> MEALS = new HashMap<>();
                MEALS.put("Meals", Meals);
                MEALS.put("Quantity", Quantity);

                db.collection("MEALS")
                        .add(MEALS)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getContext(), "Meals Saved Successfully",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(), "Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });


        return view;
    }
}
