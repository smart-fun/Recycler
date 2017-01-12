package fr.arnaudguyon.recyclerexample;

/**
 * Model for a Product
 */
public class Product {
    private int mPhotoResId;
    private String mName;

    public Product(int photoResId, String name) {
        mPhotoResId = photoResId;
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPhotoResId() {
        return mPhotoResId;
    }
}
