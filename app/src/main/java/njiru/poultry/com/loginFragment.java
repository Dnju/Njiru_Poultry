package njiru.poultry.com;

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
import com.google.firebase.auth.FirebaseUser;

public class loginFragment extends Fragment implements View.OnClickListener {
private TextView un_registered;
private EditText  Email, Password;
private Button SignIn;
private ProgressBar progressBar;
private FirebaseAuth mAuth;



    public loginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_login, container, false);

un_registered=view.findViewById(R.id.not_registered);
Email=view.findViewById(R.id.email_login);
Password=view.findViewById(R.id.password_login);
SignIn=view.findViewById(R.id.sign_in);
progressBar=view.findViewById(R.id.progressBar_load2);
mAuth = FirebaseAuth.getInstance();

SignIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String email_login=Email.getText().toString().trim();
        String password_login=Password.getText().toString().trim();

        //validating user credentials
        if (TextUtils.isEmpty(email_login)){
            Email.setError("Email is Required");
            return;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email_login).matches()) {


            Email.setError("Please provide valid Email");
            Email.requestFocus();
            return;
        }


        if (TextUtils.isEmpty(password_login)){
            Password.setError("Password is Required");
            return;

        }

        if (email_login.length()<6){
            Password.setError("Password must be >=6 characters");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //authenticate the user
        mAuth.createUserWithEmailAndPassword(email_login,password_login)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){

                       Toast.makeText(getContext(), "Logged in successfully", Toast.LENGTH_SHORT).show();
                       FragmentTransaction h=getParentFragmentManager().beginTransaction();
                       h.replace(R.id.fragment_container,new homeFragment());
                       h.commit();

                   }
                   else {
                       Toast.makeText(getContext(), "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                   }
                    }
                });
    }
});



un_registered.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction u=getParentFragmentManager().beginTransaction();
        u.replace(R.id.fragment_container,new createAccountFragment());
        u.commit();
    }
});



      return view;
    }

    @Override
    public void onClick(View v) {

    }
}
