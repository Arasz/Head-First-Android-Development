package com.example.raraszkiewicz.wloskieconieco.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.example.raraszkiewicz.wloskieconieco.Data.Pizza;
import com.example.raraszkiewicz.wloskieconieco.R;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PizzaDetailActivity extends Activity
{
	public static final String EXTRA_PIZZA_NUMBER = "PIZZA_NUMBER";

	@BindView(R.id.detail_text)
	 TextView detailTextView;

	@BindView(R.id.detail_image)
	 ImageView detailImage;

	private Pizza selectedPizza;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pizza_detail);
		ButterKnife.bind(this);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		int selectedPizzaNumber = getIntent().getExtras().getInt(EXTRA_PIZZA_NUMBER);
		selectedPizza = Pizza.pizzas[selectedPizzaNumber];

		detailTextView.setText(selectedPizza.getName());
		detailImage.setImageDrawable(ContextCompat.getDrawable(this, selectedPizza.getImageId()));
		detailImage.setContentDescription(selectedPizza.getName());
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu_order, menu);

		MenuItem shareItem = menu.findItem(R.id.action_share);

		ShareActionProvider shareActionProvider = (ShareActionProvider) shareItem.getActionProvider();

		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(intent.EXTRA_TEXT, selectedPizza.getName());

		shareActionProvider.setShareIntent(intent);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId() == R.id.action_order)
		{
			Intent intent = new Intent(this, OrderActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
