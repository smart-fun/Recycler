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
        Holder holder = (Holder) parentHolder;
        holder.mPhotoView.setImageResource(mProduct.getPhotoResId());
        holder.mTitleView.setText(mProduct.getName());
    }
}
```

``` java
public class Holder extends RecyclerHolder {

    private ImageView mPhotoView;
    private TextView mTitleView;

    public Holder(View itemView) {
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
                return ProductItem.Holder.class;
            case AdItem.AD_ITEM_RES_ID:
                return AdItem.Holder.class;
        }
        return null;
    }
}
```

