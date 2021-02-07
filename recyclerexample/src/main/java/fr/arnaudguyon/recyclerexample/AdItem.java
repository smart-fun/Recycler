package fr.arnaudguyon.recyclerexample;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import fr.arnaudguyon.recycler.RecyclerHolder;
import fr.arnaudguyon.recycler.RecyclerItem;

/**
 * Item corresponding to an Ad in the RecyclerAdapter
 */
public class AdItem extends RecyclerItem {

    private static final String TAG = "AdItem";
    static final int AD_ITEM_RES_ID = R.layout.ad_item;

    private final @NonNull Ad mAd;
    private final @NonNull AddListener listener;

    public AdItem(@NonNull Ad ad, @NonNull AddListener listener) {
        super();
        mAd = ad;
        this.listener = listener;
    }

    @Override
    public void updateView(RecyclerHolder parentHolder, final int position) {

        Holder holder = (Holder) parentHolder;

        holder.mTitleView.setText(mAd.getTitle());
        holder.mDescriptionView.setText(mAd.getDescription());
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeleteClick(AdItem.this);
            }
        });
    }

    @Override
    public void viewRecycled(RecyclerHolder parentHolder, int position) {
        super.viewRecycled(parentHolder, position);
        Log.i(TAG, "viewRecycled at position " + position);
    }

    @Override
    public void viewAttachedToWindow(RecyclerHolder parentHolder, int position) {
        super.viewAttachedToWindow(parentHolder, position);
        Log.i(TAG, "viewAttachedToWindow at position " + position);
    }

    @Override
    public void viewDetachedFromWindow(RecyclerHolder parentHolder, int position) {
        super.viewDetachedFromWindow(parentHolder, position);
        Log.i(TAG, "viewDetachedFromWindow at position " + position);
    }

    @Override
    public int getViewResId() {
        return AD_ITEM_RES_ID;
    }

    public static class Holder extends RecyclerHolder {

        private TextView mTitleView;
        private TextView mDescriptionView;
        private View deleteButton;

        public Holder(View itemView) {
            super(itemView);
            mTitleView = (TextView) itemView.findViewById(R.id.titleView);
            mDescriptionView = (TextView) itemView.findViewById(R.id.descriptionView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }

    public interface AddListener {
        void onDeleteClick(@NonNull AdItem adItem);
    }

}
