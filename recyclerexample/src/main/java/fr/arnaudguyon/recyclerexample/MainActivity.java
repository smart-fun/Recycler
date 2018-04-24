package fr.arnaudguyon.recyclerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        for(int i=1; i<11; ++i) {
            Product product1 = new Product(R.drawable.ic_computer, "Computer A" + i);
            Product product2 = new Product(R.drawable.ic_mouse, "Mouse USB " + i);
            Product product3 = new Product(R.drawable.ic_keyboard, "French Keyboard " + i);
            Ad ad = new Ad("Promotion " + i, "-50% on all mouses!");

            adapter.addItem(new ProductItem(product1));
            adapter.addItem(new ProductItem(product2));
            adapter.addItem(new ProductItem(product3));
            adapter.addItem(new AdItem(ad));
        }

    }
}
