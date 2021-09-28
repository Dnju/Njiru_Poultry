package njiru.poultry.com;

import android.app.ProgressDialog;
import android.graphics.drawable.AdaptiveIconDrawable;
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

public class VaccineFragment extends Fragment {
RecyclerView recyclerView;
ArrayList<Vaccines> vaccinesArrayList;
VaccinesAdapter vaccinesAdapter;
FirebaseFirestore db;
ProgressDialog progressDialog;
FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccine, container, false);

        progressDialog=new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data");
        progressDialog.show();




        recyclerView=view.findViewById(R.id.Recyclerview_vaccine);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Firebase Firestore Initialize
        db=FirebaseFirestore.getInstance();

        //ArrayList initialize
        vaccinesArrayList=new ArrayList<>();

        //VaccinesAdapter Initialize
        vaccinesAdapter=new VaccinesAdapter(getContext(),vaccinesArrayList);

        recyclerView.setAdapter(vaccinesAdapter);
floatingActionButton=view.findViewById(R.id.Fab_vacc_list);


floatingActionButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction vvv= getParentFragmentManager().beginTransaction();
        vvv.replace(R.id.fragment_container, new VaccineFormFragment());
        vvv.commit();
    }
});

        //getting data from the Firestore
        EventChangeListener();







        return view;
    }

    private void EventChangeListener() {

        db.collection("VACCINES").orderBy("Vaccine", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error!=null){

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();

                            Log.e("Firestore error", error.getMessage());
                            return;

                        }

                        for (DocumentChange dc:value.getDocumentChanges()){

                            if (dc.getType()==DocumentChange.Type.ADDED) {

                                vaccinesArrayList.add(dc.getDocument().toObject(Vaccines.class));

                            }
                            vaccinesAdapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            }

                        }

                });

    }

}
