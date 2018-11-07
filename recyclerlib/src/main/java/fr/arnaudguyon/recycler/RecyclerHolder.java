package fr.arnaudguyon.recycler;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Modified RecyclerView.ViewHolder
 */
public class RecyclerHolder extends RecyclerView.ViewHolder  {

    public View mItemView;

    public RecyclerHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
    }

    /**
     * Convenient method to get a Context
     * @return a Context, or null if no Views have been attached
     */
    public Context getContext() {
        if (mItemView != null) {
            return mItemView.getContext();
        }
        return null;
    }
}