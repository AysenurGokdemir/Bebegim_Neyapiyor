package example.com.bbebegim_neyapiyor;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity{
    Button btn_aile_girisi,btn_bakiciGirisi,mesaj,uye;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        config.android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        uye= (Button) findViewById(R.id.uye);
        uye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),KayitOlActivity.class);
                startActivity(intent);
            }
        });
        btn_aile_girisi= (Button) findViewById(R.id.btn_aile_giris);


        btn_aile_girisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Aile_GirisActivity.class);
                startActivity(intent);

            }
        });
        btn_bakiciGirisi= (Button) findViewById(R.id.btn_bakici_giris);
        btn_bakiciGirisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Bakici_GirisActivity.class);
                startActivity(intent);
            }
        });

       fab= (FloatingActionButton) findViewById(R.id.mesaj);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
