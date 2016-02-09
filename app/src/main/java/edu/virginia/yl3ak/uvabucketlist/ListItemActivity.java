package edu.virginia.yl3ak.uvabucketlist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class ListItemActivity extends SingleFragmentActivity {
    public static final String EXTRA_ITEM_ID = "edu.virginia.yl3ak.uvabucketlist.item_id";

    public static Intent newIntent(Context packageContext, UUID itemId) {
        Intent intent = new Intent(packageContext, ListItemActivity.class);
        intent.putExtra(EXTRA_ITEM_ID, itemId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return new ListItemFragment();
    }



}
