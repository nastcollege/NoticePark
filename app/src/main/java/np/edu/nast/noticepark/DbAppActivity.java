package np.edu.nast.noticepark;

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

public class DbAppActivity extends AppCompatActivity {
    private MyDbOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_db_app);

        db = new MyDbOpenHelper(this);
        Button btnCreate = findViewById(R.id.createRecord);
        final Button btnRead = findViewById(R.id.readRecord);
        final Button btnUpdate = findViewById(R.id.btnUpdate);
        final Button btnDelete = findViewById(R.id.btnDelete);
        final EditText etId = findViewById(R.id.etId);
        final EditText etFirstName = findViewById(R.id.et_first_name);
        final EditText etLastName = findViewById(R.id.et_last_name);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.insert(etFirstName.getText().toString(),
                        etLastName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Record Saved", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to Save  Record", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvDbResult = findViewById(R.id.db_result);
                StringBuffer buffer = new StringBuffer();
                for (String s : db.readAll()) {
                    buffer.append(s + "\n");
                }
                tvDbResult.setText(buffer);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = Integer.parseInt(etId.getText().toString());
                if (db.updateRecord(id, etFirstName.getText().toString(), etLastName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = Integer.parseInt(etId.getText().toString());
                if (db.deleteRecord(id)) {
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}