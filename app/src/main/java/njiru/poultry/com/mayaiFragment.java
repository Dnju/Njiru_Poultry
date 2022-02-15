package njiru.poultry.com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class mayaiFragment extends Fragment {

    MayaiDatabaseHelper mdb;

    EditText Eggs;
    Button save, View_Eggs, Delete;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mayai, container, false);
        Eggs=view.findViewById(R.id.Eggs_No);
        save=view.findViewById(R.id.save_as_eggs);








        return view;
    }
}