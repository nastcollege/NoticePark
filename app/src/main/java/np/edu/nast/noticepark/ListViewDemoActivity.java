package np.edu.nast.noticepark;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewDemoActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_demo);

        listView=findViewById(R.id.listView);

        String[] pl = {"C", "C++", "Java", "Kotlin", "Python", "PHP", "C#",
                "JavaScript", "Ruby", "Swift", "R" };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListViewDemoActivity.this, android.R.layout.simple_list_item_1,pl);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String sel=pl[i];
                Toast.makeText(getApplicationContext(),sel,Toast.LENGTH_LONG).show();
            }
        });

    }
}