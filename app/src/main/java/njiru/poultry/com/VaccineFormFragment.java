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
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class VaccineFormFragment extends Fragment {
   private EditText mVaccine;
   private TextInputEditText desc;
   private EditText mChicken;
   private Button save_vaccine;
   private FirebaseFirestore db;
   private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_vaccine_form, container, false);

      mVaccine=(EditText) view.findViewById(R.id.vac_id);
      desc=(TextInputEditText)view.findViewById(R.id.vac_desc);
      mChicken=(EditText) view.findViewById(R.id.vac_id);
      save_vaccine=(Button)view.findViewById(R.id.vac_save);
      floatingActionButton=view.findViewById(R.id.Fab_vaccine);

      db=FirebaseFirestore.getInstance();
      floatingActionButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FragmentTransaction vv = getFragmentManager().beginTransaction();
              vv.replace(R.id.fragment_container, new VaccineFragment());
              vv.commit();
          }
      });

     //get and save data to Firebase Firestore DB
      save_vaccine.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String Vaccine =mVaccine .getText().toString();
              String Description=desc.getText().toString();
              String Chicken=mChicken.getText().toString();



              Map<String, Object> VACCINES = new HashMap<>();
              VACCINES.put("Vaccine", Vaccine);
              VACCINES.put("Chicken", Chicken);
              VACCINES.put("Description", Description);

       db.collection("VACCINES")
               .add(VACCINES)
               .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                   @Override
                   public void onSuccess(DocumentReference documentReference) {
                       Toast.makeText(getContext(), "Vaccines saved Successfully",
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
