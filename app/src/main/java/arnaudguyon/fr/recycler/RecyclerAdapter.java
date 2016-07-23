package arnaudguyon.fr.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Makes the use of RecyclerView.Adapter easier, especially with item of different types.
 * The Layout Resource Ids are used as View types (nice Google recommendation)
 */
public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    private ArrayList<RecyclerItem> mItems;

    public RecyclerAdapter() {
        mItems = new ArrayList<>();
    }

    public RecyclerAdapter(@NonNull ArrayList<? extends RecyclerItem> items) {
        if (items == null) {
            mItems = new ArrayList<>();
        } else {
            mItems = new ArrayList<>(items);
        }
    }

    @Override
    public int getItemCount() {
        return (mItems != null) ? mItems.size() : 0;
    }

    final public RecyclerItem getItem(int position) {
        if ((mItems != null) && (position >= 0) && (position < mItems.size())) {
            return mItems.get(position);
        }
        return null;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(viewType, parent, false);
        Class<? extends RecyclerHolder> holderClass = getHolderClassForViewType(viewType);
        try {
            Constructor<? extends RecyclerHolder> constructor = holderClass.getDeclaredConstructor(View.class);
            RecyclerHolder holder = constructor.newInstance(itemView);
            return holder;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    final public void onBindViewHolder(RecyclerHolder holder, int position) {
        RecyclerItem item = getItem(position);
        item.updateView(holder, position);
    }

    @Override
    final public int getItemViewType(int position) {
        RecyclerItem item = getItem(position);
        return item.getViewResId();
    }

    protected abstract Class<? extends RecyclerHolder> getHolderClassForViewType(int viewType);

    final public int getPosition(RecyclerItem item) {
        for(int position=0; position<mItems.size(); ++position) {
            if (item.equals(mItems.get(position))) {
                return position;
            }
        }
        return -1;
    }

    final public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    final public void setItems(ArrayList<? extends RecyclerItem> items) {
        if (items == null) {
            mItems = new ArrayList<>();
        } else {
            mItems = new ArrayList<>(items);
        }
        notifyDataSetChanged();
    }

    final public int addItem(RecyclerItem item) {
        mItems.add(item);
        int position = mItems.size() - 1;
        notifyItemInserted(position);
        return position;
    }

    final public void insertItem(RecyclerItem item, int position) {
        mItems.add(position, item);
        notifyItemInserted(position);
    }
    final public void removeItem(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }
}
