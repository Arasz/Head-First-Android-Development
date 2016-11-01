package com.example.raraszkiewicz.wloskieconieco.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.example.raraszkiewicz.wloskieconieco.R;

public class OrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_order, menu);
        setShareActionIntent(menu.findItem(R.id.action_share));
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(MenuItem shareAction)
    {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "WopWop");
        ShareActionProvider shareActionProvider = (ShareActionProvider) shareAction.getActionProvider();
        shareActionProvider.setShareIntent(shareIntent);
    }
}
