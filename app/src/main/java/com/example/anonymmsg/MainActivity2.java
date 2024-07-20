package com.example.anonymmsg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Context context = MainActivity2.this;
        SharedPreferences sharedPreferences = context.getSharedPreferences("appsie", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("check", "no"); //no = not regs
//        editor.apply();

        txt = findViewById(R.id.user_name);
        btn = findViewById(R.id.register_btn);


        String s = sharedPreferences.getString("check", "0");
        if (s.equals("1")){
            startActivity(new Intent(MainActivity2.this, MainActivity.class));
        }
        else{
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!txt.getText().toString().trim().isEmpty())
                    {
                        editor.putString("check", "1");
                        editor.apply();

                        String name = txt.getText().toString().toLowerCase();

                        SimpleDateFormat sdf1 = new SimpleDateFormat("HH", Locale.getDefault());
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd", Locale.getDefault());
                        SimpleDateFormat sdf3 = new SimpleDateFormat("ss", Locale.getDefault());

                        String h = sdf1.format(new Date());
                        String d = sdf2.format(new Date());
                        String s = sdf3.format(new Date());


                        String uid = name+h+d+s+h;

                        editor.putString("uid", uid);
                        editor.apply();
                        Toast.makeText(MainActivity2.this, "UserID is "+uid, Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(MainActivity2.this, MainActivity.class);
//                        intent.putExtra("uid", uid);

                        startActivity(intent);


                    }else {
                        Toast.makeText(MainActivity2.this, "Enter username", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }
}