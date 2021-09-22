package njiru.poultry.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder> {
    Context context;
    ArrayList<Meals> MealsArrayList;

    public MealsAdapter(Context context, ArrayList<Meals> mealsArrayList) {
        this.context = context;
        MealsArrayList = mealsArrayList;
    }

    @NonNull
    @Override
    public MealsAdapter.MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item_meal,parent,false);
        return  new MealsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.MealsViewHolder holder, int position) {
        Meals meals= MealsArrayList.get(position);

        holder.Meals.setText(meals.Meals);
        holder.Quantity.setText(meals.Quantity);


    }

    @Override
    public int getItemCount() {
        return MealsArrayList.size();

    }

    public static class MealsViewHolder extends RecyclerView.ViewHolder{
     TextView Meals, Quantity;

        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            Meals=itemView.findViewById(R.id.list_quantity);
            Quantity=itemView.findViewById(R.id.list_meal);

        }
    }
}
