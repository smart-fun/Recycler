package fr.arnaudguyon.recyclerexample;

import android.view.View;
import android.widget.TextView;

import fr.arnaudguyon.recycler.RecyclerHolder;
import fr.arnaudguyon.recycler.RecyclerItem;

/**
 * Item corresponding to an Ad in the RecyclerAdapter
 */
public class AdItem extends RecyclerItem {

    static final int AD_ITEM_RES_ID = R.layout.ad_item;

    private Ad mAd;

    public AdItem(Ad ad) {
        super();
        mAd = ad;
    }

    @Override
    public void updateView(RecyclerHolder parentHolder, int position) {

        Holder holder = (Holder) parentHolder;

        holder.mTitleView.setText(mAd.getTitle());
        holder.mDescriptionView.setText(mAd.getDescription());
    }

    @Override
    public int getViewResId() {
        return AD_ITEM_RES_ID;
    }

    static class Holder extends RecyclerHolder {

        private TextView mTitleView;
        private TextView mDescriptionView;

        public Holder(View itemView) {
            super(itemView);
            mTitleView = (TextView) itemView.findViewById(R.id.titleView);
            mDescriptionView = (TextView) itemView.findViewById(R.id.descriptionView);
        }
    }
}
