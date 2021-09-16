package njiru.poultry.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class homeFragment extends Fragment {
    private ImageView meal;
    private ImageView egg;
    private ImageView chick;
    private ImageView vac;


    @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        meal=(ImageView) view.findViewById(R.id.Meal_grains);
        egg=(ImageView) view.findViewById(R.id.Egg_g);
        chick=(ImageView)view.findViewById(R.id.chick_chick);
        vac=(ImageView)view.findViewById(R.id.vac_c);

        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction g = getFragmentManager().beginTransaction();
                g.replace(R.id.fragment_container, new MealFragment());
                g.commit();
            }

        });

        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction e=getFragmentManager().beginTransaction();
                e.replace(R.id.fragment_container,new EggFragment());
                e.commit();
            }
        });

        chick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction c=getFragmentManager().beginTransaction();
                c.replace(R.id.fragment_container,new ChickenFragment());
                c.commit();
            }
        });

       vac.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentTransaction cin=getFragmentManager().beginTransaction();
               cin.replace(R.id.fragment_container,new VaccineFragment());
               cin.commit();
           }
       });
        return view;

    }
}
