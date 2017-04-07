# Recycler
Recycler is an Android Studio Library which makes it easy to use the RecyclerView, especially with items of different types.

3 classes that work together are used:
* RecyclerAdapter
* RecyclerItem
* RecyclerHolder

### RecyclerAdapter
It extends the RecyclerView.Adapter class, and handles RecyclerItem objects. Lots of convenient methods have been added to add / insert or remove items. You only have to override getHolderClassForViewType(). See the example below.

### RecyclerItem
Item used by the RecyclerAdapter. Depending on the content you want to display (ie Products or Ads), you will create different simple items. You only have to override updateView(). See the example below.

### RecyclerHolder
Holds the View. It's the same as the RecyclerView.ViewHolder class but ready to use with the RecyclerAdapter.

## Example of usage

Here is an example to display a list of products.
They have a name that can be edited by the user, and a photo.

The Holder for the view is as follows. The **holder class must be public**!

``` java

public class ProductHolder extends RecyclerHolder {

    private EditText mEditView;
    private ImageView mPhotoView;

    public ProductHolder(View itemView) {
        super(itemView);
        mEditView = (EditText) itemView.findViewById(R.id.editView);
        mPhotoView = (ImageView) itemView.findViewById(R.id.photoView);
    }
}
```

Now the Item class that holds the product. The important method is **updateView**, it is called when the view is refreshed. **viewRecycled** is optional and can be used to save values from the holder to the item when the view is scrolled. In this example, viewRecycled is used to save the name of the product to the Product.

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
        holder.mEditView.setText(mProduct.getName());
    }
    
    // optional callback that is used to update the product from the holder.
    // it is called when the view is scrolled.
    // this way if the user has modified the product name, it is updated in the product.
    @Override
    public void viewRecycled(RecyclerHolder parentHolder, int position) {
        super.viewRecycled(parentHolder, position);

        Holder holder = (Holder) parentHolder;
        mProduct.setName(holder.mEditView.getText().toString());    // Saves the user text
    }
}
```

And the Recycler itself. It just needs to return the class of the holder.

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
            default:
                Assert.assertTrue("No Holder class defined for this view", false);
                return null;
        }
    }
}
```

Imagine to do the same with Ads that you want to add in the recycler view: you need to create an AdItem and an AdHolder class. Finally, add the products and the ads to the recycler view:

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

## Installation with Gradle

Add the following maven{} line to your PROJECT build.gradle file

```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }		// add this line
    }
}
```

Add the libary to your APP build.gradle file

```
dependencies {
    compile 'com.github.smart-fun:Recycler:1.1.3'    // add this line
}
```

## License

Copyright 2016 Arnaud Guyon

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
