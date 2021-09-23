package njiru.poultry.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChickenAdapter extends RecyclerView.Adapter<ChickenAdapter.ChickenViewHolder> {
    //Declare variables
    Context context;
    ArrayList<Chicken>chickenArrayList;
    //Generate context abd arraylist method
    public ChickenAdapter(Context context, ArrayList<Chicken> chickenArrayList) {
        this.context = context;
        this.chickenArrayList = chickenArrayList;
    }

    @NonNull
    @Override
    public ChickenAdapter.ChickenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.list_item_chicken,parent,false);

        return new ChickenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChickenAdapter.ChickenViewHolder holder, int position) {
    Chicken chicken=chickenArrayList.get(position);

    holder.Chicken.setText(chicken.getChicken());
    holder.Vaccine.setText(chicken.getVaccine());
    holder.Date.setText(chicken.getDate());
    ;

    }

    @Override
    public int getItemCount() {
        return chickenArrayList.size();
    }
//inner class

    public  static class ChickenViewHolder extends RecyclerView.ViewHolder{
    TextView Chicken, Vaccine;
    EditText Date;

        public ChickenViewHolder(@NonNull View itemView) {
            super(itemView);
            Chicken=itemView.findViewById(R.id.Chicken_List);
            Vaccine=itemView.findViewById(R.id.Vaccine_List);
            Date=itemView.findViewById(R.id.Date_List);


        }
    }


}
