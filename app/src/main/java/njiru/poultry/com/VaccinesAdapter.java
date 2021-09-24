package njiru.poultry.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VaccinesAdapter extends RecyclerView.Adapter<VaccinesAdapter.VaccinesViewHolder> {
   Context context;
    ArrayList<Vaccines>vaccinesArrayList;
    //generate a constructor for context and arraylist


    public VaccinesAdapter(Context context, ArrayList<Vaccines> vaccinesArrayList) {
        this.context = context;
        this.vaccinesArrayList = vaccinesArrayList;
    }

    @NonNull
    @Override
    public VaccinesAdapter.VaccinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item_vaccine,parent,false);

        return new VaccinesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VaccinesAdapter.VaccinesViewHolder holder, int position) {
    Vaccines vaccines=vaccinesArrayList.get(position);

    holder.chicken.setText(vaccines.Chicken);
    holder.description.setText(vaccines.Description);
    holder.vaccine.setText(vaccines.Vaccine);
    }

    @Override
    public int getItemCount() {

        return vaccinesArrayList.size();
    }

    public static class VaccinesViewHolder extends RecyclerView.ViewHolder{
        TextView chicken,description, vaccine;

        public VaccinesViewHolder(@NonNull View itemView) {
            super(itemView);
            chicken=itemView.findViewById(R.id.List_Chicken);
            vaccine=itemView.findViewById(R.id.List_Vaccine);
            description=itemView.findViewById(R.id.List_Desc);

        }
    }
}
