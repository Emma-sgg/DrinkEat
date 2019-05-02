package com.example.drinkeat.myrequest;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {

    private Context context;
    private RequestQueue queue;

    public MyRequest(Context context, RequestQueue queue){
        this.context = context;
        this.queue = queue;
    }

    public void register (final String pseudo, final String email, final String password, final String password2){
        String url = "http://127.0.0.1/drinkeat/register.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("APP", response);

            }

            }, new Response.ErrorListener(){

                public void onErrorResponse(VolleyError error){
                    Log.d("APP", "ERROR = " + error);

                }

        }){
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> map = new HashMap<>(); // En gros, ici on met toute les infos qu'on envoie à notre bdd
                map.put("pseudo", pseudo);// en php : $_POST['pseudo']
                map.put("email",email); //on les met en final
                map.put("password",password);
                map.put("password2", password2);

                return map;
            }

        };
        queue.add(request);
    }

}
