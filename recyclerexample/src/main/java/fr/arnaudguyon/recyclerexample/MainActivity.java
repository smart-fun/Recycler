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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);


        Product product1 = new Product(R.drawable.ic_computer, "Computer A");
        Product product2 = new Product(R.drawable.ic_mouse, "Mouse USB");
        Product product3 = new Product(R.drawable.ic_keyboard, "French Keyboard");
        Ad ad = new Ad("Promotion", "-50% on all mouses!");

        adapter.addItem(new ProductItem(product1));
        adapter.addItem(new ProductItem(product2));
        adapter.addItem(new AdItem(ad));
        adapter.addItem(new ProductItem(product3));

    }
}
