package np.edu.nast.noticepark;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends AppCompatActivity {

    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_demo);

        listView = findViewById(R.id.listView);

        String[] pl = {"C", "C++", "Java", "Kotlin", "Python", "PHP", "C#",
                "JavaScript", "Ruby", "Swift", "R"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListViewDemoActivity.this, android.R.layout.simple_list_item_1, pl);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((av, view, i, l) -> {
            String sel = av.getItemAtPosition(i).toString();
            Toast.makeText(getApplicationContext(), sel, Toast.LENGTH_LONG).show();
        });

        spinner = findViewById(R.id.spCountry);
        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Nepal");
        spinnerArray.add("China");
        spinnerArray.add("India");
        spinnerArray.add("USA");
        spinnerArray.add("Japan");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> av, View view, int i, long l) {
                String sel = av.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), sel, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}