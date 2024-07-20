package com.example.anonymmsg;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText id_inp;
    private TextInputEditText msg_inp;
    private Button btn_send, btn_msgs;
    private TextView uidview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        id_inp = findViewById(R.id.receiver_id);
        msg_inp = findViewById(R.id.msgg);
        btn_send= findViewById(R.id.btn_send);
        btn_msgs = findViewById(R.id.btn_msgs);
        uidview = findViewById(R.id.uid_display);

        Button btncopy = findViewById(R.id.btn_copy);

        Context context = MainActivity.this;
        SharedPreferences sharedPreferences = context.getSharedPreferences("appsie", Context.MODE_PRIVATE);

        String u = sharedPreferences.getString("uid", "USER ID");
        uidview.setText("USERID: "+u);

        btncopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", u);
                clipboard.setPrimaryClip(clip);

//                Toast.makeText(MainActivity.this, "Copied "+u, Toast.LENGTH_SHORT).show();
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> msg = new HashMap<>();
                msg.put("msg", msg_inp.getText().toString());

//                msg_inp.clearComposingText();

                db.collection(id_inp.getText().toString()).add(msg)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(MainActivity.this, "doc id:"+documentReference.getId(), Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "error"+e, Toast.LENGTH_SHORT).show();
                            }
                        });
                msg_inp.setText("");
                id_inp.setText("");

            }
        });

        btn_msgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });


    }
}