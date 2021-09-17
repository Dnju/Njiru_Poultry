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

public class EggFragment extends Fragment {
   private EditText eggs;
   private Button save_eggs;
   private FirebaseFirestore db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_egg, container, false);

      eggs=(EditText) view.findViewById(R.id.Et_eggs);
      save_eggs=(Button) view.findViewById(R.id.save_egg);
      db=FirebaseFirestore.getInstance();

     //get and save data to Firebase Firestore DB
      save_eggs.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String Eggs = eggs.getText().toString();


              Map<String, Object> EGGS = new HashMap<>();
              EGGS.put("Eggs", Eggs);

       db.collection("EGGS")
               .add(EGGS)
               .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                   @Override
                   public void onSuccess(DocumentReference documentReference) {
                       Toast.makeText(getContext(), "Eggs saved Successfully",
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
