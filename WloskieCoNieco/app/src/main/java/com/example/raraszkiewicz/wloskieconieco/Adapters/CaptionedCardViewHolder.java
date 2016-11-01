package com.example.raraszkiewicz.wloskieconieco.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Rafal on 01.11.2016.
 */

public class CaptionedCardViewHolder extends RecyclerView.ViewHolder
{

    private CardView cardView;

    public CaptionedCardViewHolder(CardView cardView)
    {
        super(cardView);
        this.cardView = cardView;
    }

    public CardView getCardView()
    {
        return cardView;
    }
}
