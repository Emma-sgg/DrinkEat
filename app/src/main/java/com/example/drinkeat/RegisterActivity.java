package com.example.drinkeat;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.example.drinkeat.myrequest.MyRequest;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_send;
    private EditText et_pseudo, et_email, et_password, et_password2;
    private TextInputLayout til_pseudo, til_email, til_password, til_password2;
    private RequestQueue queue;
    private MyRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_send = (Button) findViewById(R.id.btn_send);
        til_pseudo = (TextInputLayout) findViewById(R.id.til_pseudo);
        til_email = (TextInputLayout) findViewById(R.id.til_email);
        til_password = (TextInputLayout) findViewById(R.id.til_password);
        til_password2 = (TextInputLayout) findViewById(R.id.til_password2);
        /*et_pseudo = (EditText) findViewById(R.id.et_pseudo);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password2 = (EditText) findViewById(R.id.et_password2);*/

        queue = VolleySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);
        btn_send.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String pseudo = til_pseudo.getEditText().getText().toString().trim();
                String email = til_email.getEditText().getText().toString().trim();
                String password = til_password.getEditText().getText().toString().trim();
                String password2 = til_password2.getEditText().getText().toString().trim();


                request.register(pseudo, email, password, password2);
            }
        });

    }
}

