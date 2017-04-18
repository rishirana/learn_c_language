package info.rishi.learnc;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Feedback extends AppCompatActivity {

    TextInputLayout mname,memail,mdescription;
    TextInputEditText name,email,description;
    Button btn;
    String nm,eml,des;
    boolean valid = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        mname = (TextInputLayout)findViewById(R.id.name_layout);
        memail = (TextInputLayout)findViewById(R.id.emaillayout);
        mdescription = (TextInputLayout)findViewById(R.id.description_layout);

        name = (TextInputEditText)findViewById(R.id.name);
        email = (TextInputEditText)findViewById(R.id.email);
        description = (TextInputEditText)findViewById(R.id.description);

        btn = (Button)findViewById(R.id.send_feedback);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nm = name.getText().toString();
                eml = email.getText().toString();
                des = description.getText().toString();
                validate();
                Toast.makeText(getApplicationContext(),"send feedback",Toast.LENGTH_LONG).show();
            }
        });


    }

    private void validate(){
        if(nm.length()==0){
            name.setError("Name cannot be Empty");
            valid = false;
        }
        else if (eml.length()==0||eml.isEmpty()&&!isValidEmail(eml)){
            email.setError("Enter valid Email Id");
             valid = false;
        }
        else if(des.length()<10||des.isEmpty()){
            description.setError("Enter some description ");
             valid = false;
        }

        valid = true;
    }

    boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
