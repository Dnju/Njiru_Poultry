package njiru.poultry.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class EggsAdapter extends RecyclerView.Adapter<EggsAdapter.EggsViewHolder>{
    Context context;
    ArrayList<Eggs> eggsArrayList;
    //Context and ArrayList constructor
    public EggsAdapter(Context context, ArrayList<Eggs> eggsArrayList) {
        this.context = context;
        this.eggsArrayList = eggsArrayList;
    }

    //implement EggAdapter method
    @NonNull
    @Override
    public EggsAdapter.EggsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item_egg,parent,false);



        return new EggsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EggsAdapter.EggsViewHolder holder, int position) {
Eggs eggs=eggsArrayList.get(position);


        holder.Eggs.setText(eggs.eggs);



    }

    @Override
    public int getItemCount() {
        return eggsArrayList.size();
    }

    //EggViewHolder inner class
    public static class EggsViewHolder extends RecyclerView.ViewHolder{
        TextView Eggs;
        public EggsViewHolder(@NonNull View itemView) {
            super(itemView);
            Eggs=itemView.findViewById(R.id.list_eggs);
        }
    }

}
