package com.example.raraszkiewicz.activitymessager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent receivedIntent = getIntent();
        String messageText = receivedIntent.getStringExtra(getString(R.string.message_name));

        TextView receivedMessage = (TextView) findViewById(R.id.receivedMessage);
        receivedMessage.setText(messageText);

    }
}