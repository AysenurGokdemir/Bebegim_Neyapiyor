package example.com.bbebegim_neyapiyor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Aysenur on 13.07.2017.
 */
//burda ilk giris yapan
public class Aile_GirisActivity extends Activity {

    FirebaseAuth fAuth;
    FirebaseUser fUser;
    private Context context;
    EditText edt_kullaniciAdi,edt_mail,edt_sifre;
    Button btn_girisyap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aile_giris_activity);

        edt_kullaniciAdi= (EditText) findViewById(R.id.edt_kullanici_adi);
        edt_mail= (EditText) findViewById(R.id.edt_Mail_Adresi);
        edt_sifre= (EditText) findViewById(R.id.edt_sifre);
        btn_girisyap= (Button) findViewById(R.id.btn_aile_giris_yap);

        fAuth=FirebaseAuth.getInstance();
        fUser=fAuth.getCurrentUser();


        if (fUser!=null){//veri tabanına kayıtlıysa o kullanıcı su isleri yap
            if (fUser.getEmail().equals(edt_mail.getText().toString())) {
            Intent i=new Intent(getApplicationContext(),AnaSayfaActivity.class);
            startActivity(i);

            finish();
           return;


        }
        btn_girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=edt_mail.getText().toString();
                String sifre=edt_sifre.getText().toString();

                fAuth.signInWithEmailAndPassword(mail,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {


                            Intent intent = new Intent(getApplicationContext(), EbeveynAktivity_nav.class);
                            startActivity(intent);


                        }
                        else
                        {


                            Log.d("LOGIN",task.getException().getMessage());
                        }
                    }
                });

            }
        });

    }
}}
