package np.edu.nast.noticepark;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        //for display
        TextView tvMessage = findViewById(R.id.tvMessage);
        //for taking input
        EditText etMessage = findViewById(R.id.etMessage);

        Button btnSet = findViewById(R.id.btnWrite);
        Button btnGet = findViewById(R.id.btnRead);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("my-pref", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name", etMessage.getText().toString());
                ed.putBoolean("status", true);
                ed.commit();
                etMessage.setText("");
                Toast.makeText(getApplicationContext(), "SharedPreferences Set:" + etMessage.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("my-pref", MODE_PRIVATE);
                tvMessage.setText(sp.getString("name", "Not Found")+ " Status: "+sp.getBoolean("status", false));
                Toast.makeText(getApplicationContext(), "Read Shared Pref: "
                        + sp.getString("name", "Not Found"), Toast.LENGTH_LONG).show();
            }
        });
    }
}
