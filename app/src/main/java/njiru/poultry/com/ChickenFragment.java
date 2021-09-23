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

public class ChickenFragment extends Fragment{

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private FirebaseFirestore db;

    ArrayList<Chicken> chickenArrayList;
    ChickenAdapter chickenAdapter;
    ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken, container, false);


        progressDialog=new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data.....");
        progressDialog.show();

         floatingActionButton=view.findViewById(R.id.Fab_egg);
        recyclerView = view.findViewById(R.id.Recyclerview_chicken);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        db = FirebaseFirestore.getInstance();

        chickenArrayList = new ArrayList<Chicken>();
        chickenAdapter = new ChickenAdapter(getContext(), chickenArrayList);
        recyclerView.setAdapter(chickenAdapter);




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction cc = getFragmentManager().beginTransaction();
                cc.replace(R.id.fragment_container, new ChickenFormFragment());
                cc.commit();

            }
        });
        EventChangeListener();



return view;
    }

    private void EventChangeListener() {
        db.collection("CHICKEN").orderBy("Chicken", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error !=null){
                         if (progressDialog.isShowing())
                             progressDialog.dismiss();

                            Log.e("Firestore error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc:value.getDocumentChanges()){
                            if(dc.getType()==DocumentChange.Type.ADDED){

                                chickenArrayList.add(dc.getDocument().toObject(Chicken.class));

                            }
                            chickenAdapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();


                        }

                    }
                });


    }
}

