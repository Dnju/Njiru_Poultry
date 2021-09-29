package njiru.poultry.com;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class createAccountFragment extends Fragment implements View.OnClickListener {
   private TextView FullName;
    private EditText email;
    private EditText Pass_word;
    private Button  create_account;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private TextView sign_in;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);
        FullName=view.findViewById(R.id.Fname);
        email = view.findViewById(R.id.Email);
        Pass_word = view.findViewById(R.id.password);
        sign_in = view.findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        create_account=view.findViewById(R.id.registerUser);
        //Check if the user has an account or already login




        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Fname=FullName.getText().toString().trim();
                String password=Pass_word.getText().toString().trim();

                //validating user credentials
                if (TextUtils.isEmpty(Email)){
                    email.setError("Email is Required");
                    return;

                }

                if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {


                    email.setError("Please provide valid Email");
                    email.requestFocus();
                    return;
                }


                if (TextUtils.isEmpty(Fname)){
                    FullName.setError("FullName is Required");
                    return;

                }
                if (TextUtils.isEmpty(password)){
                    Pass_word.setError("Password is Required");
                    return;

                }

                if (password.length()<6){
                    Pass_word.setError("Password must be >=6 characters");
                return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //register the user in firebase
                mAuth.createUserWithEmailAndPassword(Email,password)
                        .addOnCompleteListener(task -> {
                       if (task.isSuccessful()){
                           Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();
                           FragmentTransaction n=getParentFragmentManager().beginTransaction();
                           n.replace(R.id.container,new loginFragment());
                           n.commit();


                       }   else {
                           Toast.makeText(getContext(), "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           progressBar.setVisibility(View.GONE);
                       }
                        });
            }
        });
        progressBar = view.findViewById(R.id.progressBar_load);
       sign_in.setOnClickListener(v -> {
           FragmentTransaction lg = getParentFragmentManager().beginTransaction();
           lg.replace(R.id.container, new loginFragment());
           lg.commit();
       });

        return view;


    }

    @Override
    public void onClick(View v) {

    }
}
