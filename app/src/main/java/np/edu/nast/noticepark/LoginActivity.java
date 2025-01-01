package np.edu.nast.noticepark;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;

    private Button btnLogin;

    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(view -> {
            //take user input and authenticate and forward to main activity if authenticated
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);

           // Toast.makeText(getApplicationContext(),"Clicked Me!!",Toast.LENGTH_LONG).show();
        });

        btnSignup.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
            startActivity(intent);
        });

    }
}