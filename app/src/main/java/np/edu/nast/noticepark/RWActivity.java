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

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class RWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rwactivity);
        TextView tvMessage = findViewById(R.id.tvMessage);
        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSet = findViewById(R.id.btnWrite);
        Button btnGet = findViewById(R.id.btnRead);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStream outputStream = openFileOutput("myfile.txt", MODE_APPEND);
                    outputStream.write(etMessage.getText().toString().getBytes());
                    outputStream.close();


                    Toast.makeText(getApplicationContext(), "The Data inserted is Successful", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Sorry: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream fileInputStream = openFileInput("myfile.txt");
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    StringBuffer sb = new StringBuffer();
                    int c;
                    while ((c = dataInputStream.read()) != -1) {
                        sb.append((char) c);
                    }
                    tvMessage.setText(sb.toString());

                    Toast.makeText(getApplicationContext(), "The data read from file is success", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Sorry: " +
                            e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
