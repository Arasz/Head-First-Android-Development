package com.example.raraszkiewicz.wloskieconieco.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raraszkiewicz.wloskieconieco.Data.Pizza;
import com.example.raraszkiewicz.wloskieconieco.R;

/**
 * Created by Rafal on 01.11.2016.
 */

public class CaptionedCardAdapter extends RecyclerView.Adapter<CaptionedCardViewHolder> {


    private Pizza[] pizzaData;

    public CaptionedCardAdapter(Pizza[] pizzaData)
    {
        this.pizzaData = pizzaData;
    }

    @Override
    public CaptionedCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new CaptionedCardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(CaptionedCardViewHolder holder, int position)
    {
        CardView bindedCardView = holder.getCardView();
        
        ImageView imageView = (ImageView) bindedCardView.findViewById(R.id.info_image);
        TextView textView = (TextView) bindedCardView.findViewById(R.id.info_text);

        imageView.setImageDrawable(getImage(bindedCardView.getContext(),
                pizzaData[position].getImageId()));
        imageView.setContentDescription(pizzaData[position].getName());

        textView.setText(pizzaData[position].getName());
    }

    private Drawable getImage(Context context, int id)
    {
        return ContextCompat.getDrawable(context, id);
    }

    @Override
    public int getItemCount()
    {
        return pizzaData.length;
    }
}
