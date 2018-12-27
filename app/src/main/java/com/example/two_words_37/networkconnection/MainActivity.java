package com.example.two_words_37.networkconnection;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnCheckNetwork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasConnection();
            }
        });
    }

    public void hasConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            Toast.makeText(getApplicationContext(),"Connected to Wi-Fi Network",Toast.LENGTH_LONG).show();
            return;
        }

        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            Toast.makeText(getApplicationContext(),"Connected to Mobile Network",Toast.LENGTH_LONG).show();
            return;
        }

    }
}
