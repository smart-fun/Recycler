package fr.arnaudguyon.recyclerexample;

import junit.framework.Assert;

import fr.arnaudguyon.recycler.RecyclerAdapter;
import fr.arnaudguyon.recycler.RecyclerHolder;

/**
 * Example of an adapter with 2 item types: ProductItem and AdItem
 */
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
            default:
                Assert.assertTrue("No Holder class defined for this view", false);
                return null;
        }
    }

}
