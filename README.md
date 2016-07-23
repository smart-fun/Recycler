# Recycler
Recycler is an Android Studio project (soon a library) which makes it easy to use the RecyclerView, especially with items of different types.

3 classes must be extended to use that library, they work together:
* RecyclerAdapter
* RecyclerItem
* RecyclerHolder

### RecyclerAdapter
This class extends RecyclerView.Adapter
It holds an ArrayList of RecyclerItem so that it is easy to manipulate always the same type of objects

### RecyclerItem
Item to extend depending on the content you want to display (ie Products or Ads)

### RecyclerHolder
Holds the View

## Usage

```java
public class ProductItem extends RecyclerItem {

    static final int PRODUCT_ITEM_RES_ID = R.layout.product_item;

    private Product mProduct;

    public ProductItem(Product product) {
        super();
        mProduct = product;
    }

    @Override
    public void updateView(RecyclerHolder parentHolder, int position) {
        ProductHolder holder = (ProductHolder) parentHolder;
        holder.mPhotoView.setImageResource(mProduct.getPhotoResId());
        holder.mTitleView.setText(mProduct.getName());
    }
}
```

``` java
public class ProductHolder extends RecyclerHolder {

    private ImageView mPhotoView;
    private TextView mTitleView;

    public ProductHolder(View itemView) {
        super(itemView);
        mPhotoView = (ImageView) itemView.findViewById(R.id.photoView);
        mTitleView = (TextView) itemView.findViewById(R.id.titleView);
    }
}
```

``` java
public class MainAdapter extends RecyclerAdapter {

    public MainAdapter() {
        super();
    }

    @Override
    protected Class<? extends RecyclerHolder> getHolderClassForViewType(int viewType) {
        switch(viewType) {
            case ProductItem.PRODUCT_ITEM_RES_ID:
                return ProductHolder.class;
            case AdItem.AD_ITEM_RES_ID:
                return AdHolder.class;
        }
        return null;
    }
}
```

``` java
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
```

## Result on screen

![alt text](https://github.com/smart-fun/Recycler/blob/master/screenshot.png?raw=true "Screenshot example")


