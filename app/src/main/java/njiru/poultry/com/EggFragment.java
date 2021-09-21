package njiru.poultry.com;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class EggFragment extends Fragment {
  private FirebaseFirestore firebaseFirestore;
  private RecyclerView mFirestoreList1;
  private FloatingActionButton floatingActionButton_eggs;
  private FirestoreRecyclerAdapter adapter1;
  private static final String TAG = MainActivity.class.getSimpleName();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_egg, container, false);

       firebaseFirestore=FirebaseFirestore.getInstance();
       mFirestoreList1 = view.findViewById(R.id.Recyclerview_eggs);
       floatingActionButton_eggs=view.findViewById(R.id.FA_btn_egg);


       //Query
        Query query=firebaseFirestore.collection("EGGS");



        //RecyclerOptions
        FirestoreRecyclerOptions<Egg_ListModel> options=new FirestoreRecyclerOptions.Builder<Egg_ListModel>()
                .setQuery(query,Egg_ListModel.class)
                .build();



         adapter1= new FirestoreRecyclerAdapter<Egg_ListModel, EggViewHolder>(options) {
            @NonNull
            @Override
            public EggViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_egg,parent, false);
                return new EggViewHolder(view1);
            }

            @Override
            protected void onBindViewHolder(@NonNull EggViewHolder holder, int position, @NonNull Egg_ListModel model) {
                holder.list_eggs.setText(model.getEggs());
            }
        };


        mFirestoreList1.setHasFixedSize(true);
        mFirestoreList1.setLayoutManager(new LinearLayoutManager(getContext()));
        mFirestoreList1.setAdapter(adapter1);
        //viewHolder







        floatingActionButton_eggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction gg=getFragmentManager().beginTransaction();
                gg.replace(R.id.fragment_container,new EggFormFragment());
                gg.commit();
            }
        });

        return view;

    }


    private static class EggViewHolder extends RecyclerView.ViewHolder {
        private TextView list_eggs;


        public EggViewHolder(@NonNull View itemView) {
            super(itemView);
            list_eggs=itemView.findViewById(R.id.list_egg);

        }

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter1.startListening();
    }


}



