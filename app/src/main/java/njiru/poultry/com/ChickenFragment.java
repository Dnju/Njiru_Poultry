package njiru.poultry.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ChickenFragment extends Fragment implements  View.OnClickListener {
    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;
    private FloatingActionButton floatingActionButton2;
    //private EditText editText;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken, container, false);

        mFirestoreList=(RecyclerView)view.findViewById(R.id.Recyclerview1);
        floatingActionButton2=(FloatingActionButton) view.findViewById(R.id.FA_btn_egg);
        firebaseFirestore=FirebaseFirestore.getInstance();

        //Query(Firestore)
        Query query=firebaseFirestore.collection("CHICKEN");
      //Chicken FloatingActionButton2
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t= getFragmentManager().beginTransaction();
                t.replace(R.id.fragment_container,new ChickenFormFragment());
                t.commit();

            }
        });

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
              holder.list_Date.setText(model.getDate());
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

    private static class ChickenViewHolder extends RecyclerView.ViewHolder{
        private final TextView list_Chicken;
        private final TextView list_Vaccine;
        private final EditText list_Date;

        public ChickenViewHolder(@NonNull View itemView) {
            super(itemView);
            list_Chicken=itemView.findViewById(R.id.Chicken_List);
            list_Vaccine=itemView.findViewById(R.id.Vaccine_List);
            list_Date=itemView.findViewById(R.id.Date_List);
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

