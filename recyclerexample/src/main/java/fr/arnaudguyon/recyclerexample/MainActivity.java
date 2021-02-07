package fr.arnaudguyon.recyclerexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements AdItem.AddListener {

    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        for(int i=1; i<11; ++i) {
            Product product1 = new Product(R.drawable.ic_computer, "Computer A" + i);
            Product product2 = new Product(R.drawable.ic_mouse, "Mouse USB " + i);
            Product product3 = new Product(R.drawable.ic_keyboard, "French Keyboard " + i);
            Ad ad = new Ad("Promotion " + i, "-50% on all mouses!");

            adapter.addItem(new ProductItem(product1));
            adapter.addItem(new ProductItem(product2));
            adapter.addItem(new ProductItem(product3));
            adapter.addItem(new AdItem(ad, this));
        }

    }

    @Override
    public void onDeleteClick(@NonNull AdItem adItem) {
        if (adapter != null) {
            int position = adapter.getPosition(adItem);
            if (position >= 0) {
                adapter.removeItem(position);
            }
        }
    }
}
