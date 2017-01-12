package fr.arnaudguyon.recyclerexample;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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
        holder.mEditView.setText(mProduct.getName());

    }

    @Override
    public void viewRecycled(RecyclerHolder parentHolder, int position) {
        super.viewRecycled(parentHolder, position);

        Holder holder = (Holder) parentHolder;
        mProduct.setName(holder.mEditView.getText().toString());    // Saves the user text
    }

    @Override
    public int getViewResId() {
        return PRODUCT_ITEM_RES_ID;
    }

    public static class Holder extends RecyclerHolder {

        private ImageView mPhotoView;
        private EditText mEditView;

        public Holder(View itemView) {
            super(itemView);
            mPhotoView = (ImageView) itemView.findViewById(R.id.photoView);
            mEditView = (EditText) itemView.findViewById(R.id.editView);
        }
    }

}
