package fr.arnaudguyon.recyclerexample;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.arnaudguyon.recycler.RecyclerHolder;
import fr.arnaudguyon.recycler.RecyclerItem;

/**
 * Item corresponding to a Product in the RecyclerAdapter
 */
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

        Log.i("ITEM", "ITEM " + position + " updated");
    }

    @Override
    public void viewRecycled(RecyclerHolder parentHolder, int position) {
        super.viewRecycled(parentHolder, position);
        Log.i("ITEM", "ITEM " + position + " recycled");
    }

    @Override
    public int getViewResId() {
        return PRODUCT_ITEM_RES_ID;
    }

    public static class Holder extends RecyclerHolder {

        private ImageView mPhotoView;
        private TextView mTitleView;

        public Holder(View itemView) {
            super(itemView);
            mPhotoView = (ImageView) itemView.findViewById(R.id.photoView);
            mTitleView = (TextView) itemView.findViewById(R.id.titleView);
        }
    }

}
