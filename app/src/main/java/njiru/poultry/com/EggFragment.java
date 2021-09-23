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

public class EggFragment extends Fragment {
RecyclerView recyclerView;
ArrayList<Eggs>eggsArrayList;
EggsAdapter eggsAdapter;
FirebaseFirestore db;
FloatingActionButton floatingActionButton;
ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_egg, container, false);
//shows progress before data is displayed
  progressDialog=new ProgressDialog(getContext());
   progressDialog.setCancelable(false);
   progressDialog.setMessage("Fetching Data");
   progressDialog.show();



recyclerView=view.findViewById(R.id.Recyclerview_egg);
floatingActionButton=view.findViewById(R.id.Fab_egg);
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


db=FirebaseFirestore.getInstance();
eggsArrayList=new ArrayList<Eggs>();

eggsAdapter= new EggsAdapter(getContext(),eggsArrayList);

recyclerView.setAdapter(eggsAdapter);




EventChangeListener();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction gg = getFragmentManager().beginTransaction();
                gg.replace(R.id.fragment_container, new EggFormFragment());
                gg.commit();
            }
        });

return view;

    }

    private void EventChangeListener() {
        db.collection("EGGS").orderBy("Eggs", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error !=null){

                            if (progressDialog.isShowing())
                            progressDialog.dismiss();


                            Log.e("firestore error",error.getMessage());
                            return;
                        }

                        for (DocumentChange dc:value.getDocumentChanges()){
                            if(dc.getType()==DocumentChange.Type.ADDED);{

                                eggsArrayList.add(dc.getDocument().toObject(Eggs.class));
                            }
                            eggsAdapter.notifyDataSetChanged();

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                        }


                    }
                });

    }


}



