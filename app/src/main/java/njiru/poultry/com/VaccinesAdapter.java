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
    Vaccines vaccines= vaccinesArrayList.get(position);
    holder.VAC.setText(vaccines.VAC);
    holder.DESC.setText(vaccines.DESC);
    holder.CHIC.setText(vaccines.CHIC);
    }

    @Override
    public int getItemCount() {
        return vaccinesArrayList.size();
    }

    public static class VaccinesViewHolder extends RecyclerView.ViewHolder{
        TextView CHIC,DESC, VAC;

        public VaccinesViewHolder(@NonNull View itemView) {
            super(itemView);
            CHIC=itemView.findViewById(R.id.List_Chicken);
            DESC=itemView.findViewById(R.id.List_Desc);
            VAC=itemView.findViewById(R.id.List_Vaccine);

        }
    }
}
