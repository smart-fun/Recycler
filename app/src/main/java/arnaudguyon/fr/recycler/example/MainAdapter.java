package arnaudguyon.fr.recycler.example;

import arnaudguyon.fr.recycler.RecyclerAdapter;
import arnaudguyon.fr.recycler.RecyclerHolder;

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
        }
        return null;
    }

}
