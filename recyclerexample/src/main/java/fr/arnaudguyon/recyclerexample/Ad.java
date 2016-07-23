package fr.arnaudguyon.recyclerexample;

/**
 * Model for an Ad
 */
public class Ad {
    private String mTitle;
    private String mDescription;

    public Ad(String brand, String slogan) {
        mTitle = brand;
        mDescription = slogan;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }
}
