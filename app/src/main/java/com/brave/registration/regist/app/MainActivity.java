package com.brave.registration.regist.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.brave.registration.regist.app.ui.login.LoginActivity;
import static com.brave.registration.regist.app.TelegramHandler.sendTelegramMessage;

public class MainActivity extends AppCompatActivity {
    TextView id_1,phone_1;
    String ID, phone;
    Button newly;
    ImageButton yellow,green,red;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_1=(TextView) findViewById(R.id.textView2);
        phone_1=(TextView) findViewById(R.id.textView3);
        yellow = (ImageButton) findViewById(R.id.imageButton2);
        red = (ImageButton) findViewById(R.id.imageButton);
        green = (ImageButton) findViewById(R.id.imageButton3);
        newly= (Button) findViewById(R.id.button);
        SharedPreferences preferences_2 = getSharedPreferences("Data", MODE_PRIVATE);
        ID = preferences_2.getString("id", ""); /*The ID of the HERO*/
        phone = preferences_2.getString("number", ""); /*The phone no. of the HERO*/
        id_1.setText("ID: " + ID);
        phone_1.setText("No: " + phone);
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "הודעתך נשלחה", Toast.LENGTH_SHORT).show(); /* if the message was sent properly*/
                String message_text = "שלום מתנדבים יקרים!" + "%0A" + "אודה לעזרתכם עם מספר סידורים :)" + "%0A" + "אשמח אם תוכלו לחזור אליי לנייד: " + phone;
                sendTelegramMessage(ID,message_text);
            }

        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "הודעתך נשלחה", Toast.LENGTH_SHORT).show();/* if the message was sent properly*/
                String message_text = "שלום מתנדבים יקרים!" + "%0A" + "אשמח לקיים שיחה טלפונית, אודה לעזרתכם :)" + "%0A" + "מספר הפלאפון שלי: " + phone;
                sendTelegramMessage(ID,message_text);

            }

        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "הודעתך נשלחה", Toast.LENGTH_SHORT).show(); /* if the message was sent properly*/
                String message_text = "שלום מתנדבים יקרים!" + "%0A" + "אשמח אם נוכל להיפגש :)" + "%0A" + "מספר הפלאפון שלי לתיאום הפגישה: " + phone;
                sendTelegramMessage(ID,message_text);            }

        });

        newly.setOnClickListener(new View.OnClickListener() { /* resign in*/
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }

        });
    }



}