package example.com.bbebegim_neyapiyor;

        import android.app.Fragment;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

/**
 * Created by Aysenur on 19.07.2017.
 */

public class bakici_sifre_olusturFragment extends Fragment {
    View MyView;
    FirebaseDatabase fDatabase;
    DatabaseReference dbRef;
    FirebaseAuth fAuth;
    FirebaseUser fUser;

    private static EditText sifre_olustur,kullanici_adi_olustur;
    private Button olustur;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.bakici_sifre_olustur, container, false);
        fAuth=FirebaseAuth.getInstance();
        fUser=fAuth.getCurrentUser();
        fDatabase=FirebaseDatabase.getInstance();
        dbRef=fDatabase.getReference("Dadi giris bilgileri");

        kullanici_adi_olustur= (EditText) MyView.findViewById(R.id.dadi_kullanici_adi);
        sifre_olustur= (EditText) MyView.findViewById(R.id.bakıcı_sifresi_olustur);
        olustur= (Button) MyView.findViewById(R.id.olustur);

        olustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullanici_adi_dadi=kullanici_adi_olustur.getText().toString().trim();
                String sifreOlustur=sifre_olustur.getText().toString().trim();
                fAuth.createUserWithEmailAndPassword(kullanici_adi_dadi,sifreOlustur).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getActivity(),"olusturuldu",Toast.LENGTH_SHORT).show();
                        }else

                            Log.d("REGISTER",task.getException().getMessage());
                    }
                });
            }
        });
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               dbRef.child("Kullanici Adi").setValue(kullanici_adi_olustur.getText().toString().trim());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return MyView;
    }

}

