package np.edu.nast.noticepark;

import android.os.Bundle;
import android.view.View;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        btnAlert=findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(view -> {
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

    }
}