package np.edu.nast.noticepark;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewActivity extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        webView=findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.getJavaScriptEnabled();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://nast.edu.np/");

    }
}