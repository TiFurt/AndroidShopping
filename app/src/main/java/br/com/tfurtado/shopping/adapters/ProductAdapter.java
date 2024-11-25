package br.com.tfurtado.shopping.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.List;

import br.com.tfurtado.shopping.ProductDetails;
import br.com.tfurtado.shopping.R;

public class ProductAdapter extends BaseAdapter {
    private final List<ProductModel> products;
    private final LayoutInflater inflater;

    public ProductAdapter(Context context, List<ProductModel> products) {
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public ProductModel getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.product, container, false);
        }

        ProductModel product = getItem(position);

        ((TextView) view.findViewById(R.id.name)).setText(product.getName());

        TextView price = view.findViewById(R.id.price);
        price.setText(String.format("R$ %.2f", product.getPrice()));

        WebView webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // Keeps navigation within the WebView
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        String htmlContent = "<html><body style='margin:0; padding:0;'>" +
                "<img src='" +
                product.getImageUrl() +
                "' style='width:100%; height:100%;'/>" +
                "</body></html>";

        webView.loadData(htmlContent, "text/html", "UTF-8");

        TextView grade = view.findViewById(R.id.grade);
        grade.setText(String.format("Nota: %.1f", product.getGrade()));

        view.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProductDetails.class);
            intent.putExtra("id", position);
            v.getContext().startActivity(intent);
        });
        return view;
    }
}
