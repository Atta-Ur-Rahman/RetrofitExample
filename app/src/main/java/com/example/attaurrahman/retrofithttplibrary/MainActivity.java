package com.example.attaurrahman.retrofithttplibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        APIServices services = APIClient.getClient().create(APIServices.class);
        Call<LoginModel> call = services.userLogin("attaurrahman321@gmail.com","asd");
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body().getSuccess()){
                    String  string =  response.body().getUser().getEmail();
                    int i =  response.body().getUser().getUserId();
                    Toast.makeText(MainActivity.this, string+"  "+String.valueOf(i), Toast.LENGTH_SHORT).show();

                    Log.d("id",String .valueOf(i));
                    Log.d("email",string);

                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();



            }
        });
    }
}
