package njiru.poultry.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MealFragment extends Fragment {
    private TextView meal_name, meal_quantity;
    private FirebaseFirestore fStore;
    private RecyclerView mFirestorelist;
    private FirestoreRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal, container, false);
    mFirestorelist=view.findViewById(R.id.Recyclerview_meal);
    fStore=FirebaseFirestore.getInstance();
    mFirestorelist=view.findViewById(R.id.Recyclerview_chicken);


         //Query
        Query query=fStore.collection("MEALS");

        // RecyclerOptions
        FirestoreRecyclerOptions<MealModel>options=new FirestoreRecyclerOptions.Builder<MealModel>()
                .setQuery(query,MealModel.class)
                .build();

        //Firestore RecyclerAdapter
      adapter= new FirestoreRecyclerAdapter<MealModel, MealViewHolder>(options) {
            @NonNull
            @Override
            public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_meal, parent, false);
                return new MealViewHolder(view1);
            }

            @Override
            protected void onBindViewHolder(@NonNull MealViewHolder holder, int position, @NonNull MealModel model) {
                holder.list_Meal.setText(model.getMeal());
                holder.list_quantity.setText(model.getQuantity());
            }
        };


     mFirestorelist.setHasFixedSize(true);
     mFirestorelist.setLayoutManager(new LinearLayoutManager(getContext()));
     mFirestorelist.setAdapter(adapter);




//ViewHolder
        return view;
    }

    private class MealViewHolder extends RecyclerView.ViewHolder{
        private TextView list_Meal;
        private TextView list_quantity;
        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            list_Meal=itemView.findViewById(R.id.list_meal);
            list_quantity=itemView.findViewById(R.id.list_quantity);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}

