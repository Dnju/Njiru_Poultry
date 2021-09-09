package njiru.poultry.com;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChickenFragment extends Fragment implements  View.OnClickListener {
    private Button addButton;
    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken, container, false);

        mFirestoreList=(RecyclerView)view.findViewById(R.id.Recyclerview);
        addButton = (Button) view.findViewById(R.id.btnAddChicken);
        firebaseFirestore=FirebaseFirestore.getInstance();

        //Query(Firestore)
        Query query=firebaseFirestore.collection("CHICKEN");

        //RecyclerOptions
        FirestoreRecyclerOptions<Chicken_ListsModel>options=new FirestoreRecyclerOptions.Builder<Chicken_ListsModel>()
                .setQuery(query,Chicken_ListsModel.class)
                .build();

       //FirestoreRecyclerAdapter
         adapter= new FirestoreRecyclerAdapter<Chicken_ListsModel, ChickenViewHolder>(options) {
             //ChickenViewHolder
             @NonNull
             @Override
             public ChickenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                 View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chicken,parent,false);
                 return new ChickenViewHolder(view);
             }
              // Chicken onBindHolder
             @Override
             protected void onBindViewHolder(@NonNull ChickenViewHolder holder, int position, @NonNull Chicken_ListsModel model) {
              holder.list_Chicken.setText(model.getChicken());
              holder.list_Vaccine.setText(model.getVaccine());
             }
         };
      mFirestoreList.setHasFixedSize(true);
      mFirestoreList.setLayoutManager(new LinearLayoutManager(getContext()));
      mFirestoreList.setAdapter(adapter);

        return view;
    }
//setHasFixedSize(new LinearLayoutManager(this));
    @Override
    public void onClick(View v) {

    }

    private class ChickenViewHolder extends RecyclerView.ViewHolder{
        private TextView list_Chicken;
        private TextView list_Vaccine;

        public ChickenViewHolder(@NonNull View itemView) {
            super(itemView);
            list_Chicken=itemView.findViewById(R.id.Chicken_List);
            list_Vaccine=itemView.findViewById(R.id.Vaccine_List);



        }
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
}

