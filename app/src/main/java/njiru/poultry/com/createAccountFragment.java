package njiru.poultry.com;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class createAccountFragment extends Fragment  {
   private TextView First_Name;
    private TextView Last_Name;
    private EditText email;
    private EditText Pass_word;
    private Button  create_account;
     private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private TextView sign_in_opt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_create_account, container, false);
        First_Name=view.findViewById(R.id.firstName);
        Last_Name=view.findViewById(R.id.lastName);
        email=view.findViewById(R.id.Email);
        Pass_word=view.findViewById(R.id.password);
        create_account=view.findViewById(R.id.create_btn);
        sign_in_opt=view.findViewById(R.id.sign_up_option);
        mAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(getContext());

     return  view;

    }
}
