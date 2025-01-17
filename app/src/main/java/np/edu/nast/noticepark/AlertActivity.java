package np.edu.nast.noticepark;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlertActivity extends AppCompatActivity {
    private Button btnAlert;
    private Button btnCustomToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        btnAlert = findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnAlert.setOnClickListener((view) -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(AlertActivity.this);
            alert.setMessage("Login Success");
            alert.setTitle("This is title Page!");
            alert.setIcon(R.drawable.alert);
            alert.setCancelable(true);

            alert.setPositiveButton("OK", (dialog, which) -> {
                Toast.makeText(AlertActivity.this, "OK Clicked",
                        Toast.LENGTH_LONG).show();
            });
            alert.setNegativeButton("CANCLE", (dialog, which) -> {
                Toast.makeText(AlertActivity.this, "Cancel Clicked",
                        Toast.LENGTH_LONG).show();
            });
            alert.show();
        });

        btnCustomToast = findViewById(R.id.btnCustomToast);
        btnCustomToast.setOnClickListener(view -> {

            //Creating the LayoutInflater instance
            LayoutInflater li = getLayoutInflater();

            //Getting the View object as defined in the customtoast.xml file
            View layout = li.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customToastLayout));

            //Creating the Toast object
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);//setting the view of custom toast layout
            toast.show();

        });

    }
}