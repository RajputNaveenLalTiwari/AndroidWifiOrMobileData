package com.example.workingonwifiormobiledata;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isOnline())
        {
            Toast.makeText(this,"connected to wifi",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"This app doesn't work without wifi",Toast.LENGTH_LONG).show();
        }
    }

    private boolean isOnline()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo!=null && networkInfo.isConnectedOrConnecting())
        {
            if (networkInfo.getType() != ConnectivityManager.TYPE_WIFI)
            {
                Toast.makeText(this,"This app doesn't work with wifi",Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }
        return false;
    }
}
