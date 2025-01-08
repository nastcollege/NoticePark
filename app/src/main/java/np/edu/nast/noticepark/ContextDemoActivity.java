package np.edu.nast.noticepark;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContextDemoActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_context_demo);

        textView = findViewById(R.id.tvMessage);
        editText = findViewById(R.id.etLongPress);

        registerForContextMenu(textView);
        registerForContextMenu(editText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.tvMessage) {
            getMenuInflater().inflate(R.menu.context_menu_1, menu);
        }else if (v.getId()==R.id.etLongPress){
            getMenuInflater().inflate(R.menu.context_menu_cut_copy_paste, menu);
        }
    }
}