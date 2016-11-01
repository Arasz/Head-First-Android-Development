package com.arasz.wloskieconieco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;


public class MainActivity extends Activity {

    private ShareActionProvider shareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem share = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) share.getActionProvider();
        setShareActionIntent(shareActionProvider, "WopWop");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(ShareActionProvider provider, String text)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        provider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(!handleMenuItemClick(item))
            return  super.onOptionsItemSelected(item);
        return true;
    }

    /**
     * Handles menu item click
     * @param item
     * @return If click handled, returns true
     */
    private boolean handleMenuItemClick(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                return true;
            case R.id.action_make_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
