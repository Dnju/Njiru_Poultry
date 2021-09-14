package njiru.poultry.com;

import static android.service.controls.ControlsProviderService.TAG;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChickenFormFragment extends Fragment {
    private AutoCompleteTextView chicken, vaccine;
    private Button save;
    private FirebaseFirestore db;
    private ImageView image3, image4;
    private FloatingActionButton floatingActionButton;
    private TextView date;
    private Calendar myCalendar = Calendar.getInstance();
    private int mDate, mMonth, mYear;
    EditText date_d;
    ImageView cal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken_form, container, false);


        db = FirebaseFirestore.getInstance();
        chicken = view.findViewById(R.id.Et_chicken);
        vaccine = view.findViewById(R.id.Et_vaccine);
        save = view.findViewById(R.id.Chicken_Save_button);
        image3 = view.findViewById(R.id.imageView3);
        image4 = view.findViewById(R.id.imageView4);
        floatingActionButton = view.findViewById(R.id.FLOAT);


        // initiate the date picker and Edittext
        date_d = view.findViewById(R.id.date);
        cal = view.findViewById(R.id.datepicker);
        // OnclickListener For the date, month and year
        cal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int date) {
                                date_d.setText(date + "-" + month + "-" + year);
                            }
                        }, mYear, mMonth, mDate);
                datePickerDialog.show();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, chickens);
        chicken.setAdapter(adapter);

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, vaccines);
        vaccine.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.replace(R.id.fragment_container, new ChickenFragment());
                t.commit();


            }
        });


        //Chicken dropdown
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chicken.showDropDown();

            }


        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaccine.showDropDown();
            }
        });

        // Acquire or get chicken and vaccine entered data.
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Chicken = chicken.getText().toString();
                String Vaccine = vaccine.getText().toString();


                Map<String, Object> CHICKEN = new HashMap<>();
                CHICKEN.put("Chicken", Chicken);
                CHICKEN.put("Vaccine", Vaccine);
                db.collection("CHICKEN")
                        .add(CHICKEN)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getContext(), "Saved Successfully",
                                        Toast.LENGTH_SHORT).show();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception ex) {
                        Toast.makeText(getContext(), "Failed",
                                Toast.LENGTH_SHORT).show();
                        Log.e(getContext().getClass().getSimpleName(), "Error: " + ex.getMessage());
                    }


                });
            }
        });
        return view;

    }

    // Chicken and vaccine values to be displayed on click image.
    private static final String[] chickens = new String[]{"Broilers", "Layers"};
    private static final String[] vaccines = new String[]{"Mareks Disease Vaccine(HVT)", "Ranikhet Disease Vaccine",
            "infectious Bursal Disease Vaccine", "Infectious Bronchitis", "IB Vaccine Booster", "Fowl Pox Vaccine",
            "IB Booster"};


}


