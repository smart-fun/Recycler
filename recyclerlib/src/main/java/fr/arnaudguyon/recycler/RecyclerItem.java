package fr.arnaudguyon.recycler;

/**
 * Base class for all Items used by the RecyclerAdapter.
 * If you have different items types like a Product and an Advertising, create 2 classes
 * that extend RecyclerItem, and then add a Product or Advertising as a member of the class.
 */
public abstract class RecyclerItem {

    /**
     * This is where you will update the View using the holder and the data from your item
     * @param parentHolder Holder of the View. You will probably Cast it in your own specific Holder class.
     * @param position Position in the list. Could be helpful when you interact with item, for example to insert a replace item with another when you click on it.
     */
    public abstract void updateView(RecyclerHolder parentHolder, int position);

    /**
     * Required so that the Adapter knows what Layout to inflate for that Item
     * @return The Layout Resource Id for the View
     */
    public abstract int getViewResId();

}