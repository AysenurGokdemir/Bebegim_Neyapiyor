package example.com.bbebegim_neyapiyor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Aysenur on 13.07.2017.
 */

public class Bakici_GirisActivity extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseUser fUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bakici_giris_activity);
        final EditText kullaniciAdi= (EditText) findViewById(R.id.kAdi);
        final EditText bakici_sifresi = (EditText) findViewById(R.id.edt_dadi_sifre);

        Button btn = (Button) findViewById(R.id.button2);
        fAuth=FirebaseAuth.getInstance();
        fUser=fAuth.getCurrentUser();
        if(fUser!=null){
            if (fUser.getEmail().equals(kullaniciAdi.getText().toString().trim())){
                Intent intent=new Intent(getApplicationContext(),DadiActivity_nav.class);
                startActivity(intent);
                return;

            }
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String kullaniciDadiAdi=kullaniciAdi.getText().toString().trim();
                    String sifreDadi=bakici_sifresi.getText().toString().trim();
                    fAuth.signInWithEmailAndPassword(kullaniciDadiAdi,sifreDadi).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(getApplicationContext(),DadiActivity_nav.class);
                                startActivity(intent);
                                finish();

                            }else{

                                Toast.makeText(getApplicationContext(),"kayıtlı degil",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });

        }


    }}