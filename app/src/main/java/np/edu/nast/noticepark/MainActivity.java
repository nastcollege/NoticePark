package np.edu.nast.noticepark;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mFile) {
            Toast.makeText(getApplicationContext(), "File Clicked", Toast.LENGTH_LONG).show();

        }
        if (item.getItemId() == R.id.mEdit) {
            Toast.makeText(getApplicationContext(), "Edit Clicked", Toast.LENGTH_LONG).show();

        }
//        switch (optionId){
//            case R.id.mFile:
//                Toast.makeText(getApplicationContext(),"File Clicked",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.mEdit:
//                Toast.makeText(getApplicationContext(),"Edit Clicked",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.mLanguage:
//                Toast.makeText(getApplicationContext(),"Language Clicked",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.mCalender:
//                Toast.makeText(getApplicationContext(),"Calender Clicked",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.logout:
//                Toast.makeText(getApplicationContext(),"Logout Clicked",Toast.LENGTH_LONG).show();
//                break;
//
//            default:
//                Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_LONG).show();
//        }

        return super.onOptionsItemSelected(item);
    }
}