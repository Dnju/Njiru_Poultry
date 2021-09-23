package njiru.poultry.com;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VaccineFragment extends Fragment{

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private FirebaseFirestore db;

    ArrayList<Vaccines> vaccinesArrayList;
    ChickenAdapter vaccinesAdapter;
    ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccine, container, false);


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data.....");
        progressDialog.show();

        floatingActionButton = view.findViewById(R.id.Fab_vacc_list);

        recyclerView = view.findViewById(R.id.Recyclerview_vaccine);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        db = FirebaseFirestore.getInstance();
        vaccinesArrayList=new ArrayList<Vaccines>();
        vaccinesAdapter =new VaccinesAdapter(getContext(),vaccinesArrayList);



                floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction vv = getFragmentManager().beginTransaction();
                vv.replace(R.id.fragment_container, new VaccineFormFragment());
                vv.commit();

            }
        });
return view;
    }
}

