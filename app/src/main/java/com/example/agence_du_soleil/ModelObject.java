package com.example.agence_du_soleil;

public enum ModelObject {

    //PINK(R.color.pink_color, R.layout.filtre1_achat),
    DEEP_ORANGE(R.color.deep_orange_color, R.layout.filtre2_achat),
    ORANGE(R.color.orange_color, R.layout.filtre3_achat);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }
    public int getLayoutResId() {
        return mLayoutResId;
    }
}
