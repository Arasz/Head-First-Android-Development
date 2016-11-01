package com.example.raraszkiewicz.activitymessager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    protected void onMessageSend(View view)
    {
        EditText messageInput = (EditText) findViewById(R.id.messageText);
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_USER, "Paulina Sadowska");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Wiadomość od listonosza");
        intent.putExtra(Intent.EXTRA_TEXT, messageInput.getText().toString());

        Intent applicationIntent = Intent.createChooser(intent, getString(R.string.activity_chooser));

        startActivity(applicationIntent);
    }
}
