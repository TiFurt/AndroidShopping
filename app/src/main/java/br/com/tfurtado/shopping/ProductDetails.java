package br.com.tfurtado.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.MessageFormat;

import br.com.tfurtado.shopping.adapters.ProductModel;


public class ProductDetails extends AppCompatActivity {
    private ProductModel product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(50, systemBars.top, 50, systemBars.bottom);
            return insets;
        });

        getProducts();

        ((TextView) findViewById(R.id.name)).setText(product.getName());

        TextView description = findViewById(R.id.description);
        description.setText(product.getDescription());

        TextView price = findViewById(R.id.price);
        price.setText(String.format("R$ %.2f", product.getPrice()));

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // Keeps navigation within the WebView
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        String htmlContent = "<html><body style='margin:0; padding:0;'>" +
                "<img src='" +
                product.getImageUrl() +
                "' style='width:100%; height:100%;'/>" +
                "</body></html>";

        webView.loadData(htmlContent, "text/html", "UTF-8");
    }

    private void getProducts() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        product = ProductModel.getInstances().get(id);
    }
}