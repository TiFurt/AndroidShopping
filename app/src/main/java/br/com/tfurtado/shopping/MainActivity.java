package br.com.tfurtado.shopping;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.tfurtado.shopping.adapters.ProductAdapter;
import br.com.tfurtado.shopping.adapters.ProductModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.allProducts);
        listView.setAdapter(new ProductAdapter(this, ProductModel.getInstances()));
    }
}