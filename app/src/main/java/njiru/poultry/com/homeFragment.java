package njiru.poultry.com;

import android.content.Intent;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homeFragment extends Fragment {
    private ImageView meal;
    private ImageView egg;
    private ImageView chick;
    private ImageView vac;
    private TextView create_user;
    private FirebaseAuth fAuth;


    @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        meal=(ImageView) view.findViewById(R.id.Meal_grains);
        egg=(ImageView) view.findViewById(R.id.Egg_g);
        chick=(ImageView)view.findViewById(R.id.chick_chick);
        vac=(ImageView)view.findViewById(R.id.vac_c);
        create_user=(TextView)view.findViewById(R.id.user_create);
        fAuth=FirebaseAuth.getInstance();


        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction g = getParentFragmentManager().beginTransaction();
                g.replace(R.id.fragment_container, new MealFragment());
                g.commit();
            }

        });

        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction e=getParentFragmentManager().beginTransaction();
                e.replace(R.id.fragment_container,new EggFragment());
                e.commit();
            }
        });

        chick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction c=getParentFragmentManager().beginTransaction();
                c.replace(R.id.fragment_container,new ChickenFragment());
                c.commit();
            }
        });

       vac.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentTransaction cin=getParentFragmentManager().beginTransaction();
               cin.replace(R.id.fragment_container,new VaccineFragment());
               cin.commit();
           }
       });

        create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction u=getParentFragmentManager().beginTransaction();
                u.replace(R.id.fragment_container,new createAccountFragment());
                u.commit();
            }
        });


        return view;

    }
//Check the User is logged in or not
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser mFirebaseUser =fAuth.getCurrentUser();
        if (mFirebaseUser!=null){
           // user logged in
        }else{
            // user not logged in
           FragmentTransaction  uS=getParentFragmentManager().beginTransaction();
           uS.replace(R.id.fragment_container,new loginFragment());



        }


    }
}

