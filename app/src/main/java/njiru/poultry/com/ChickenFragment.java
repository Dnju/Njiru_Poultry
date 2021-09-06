package njiru.poultry.com;

import android.os.Bundle;
import android.util.Log;
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

public class ChickenFragment extends Fragment implements  View.OnClickListener {
    private Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken, container, false);


        addButton = view.findViewById(R.id.btnAddChicken);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == addButton){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.Layout_container, nextFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();, nextFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        }
    }
}
