package example.com.bbebegim_neyapiyor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Aysenur on 13.07.2017.
 */

public class UykuFragment_dadi extends Fragment {
    FirebaseDatabase fDatabase;
    DatabaseReference dbRef;
    View MyView;
    EditText et_sabah_uyku_bilgisi,et_ogle_uyku_bilgisi,et_aksam_uyku_bilgisi,et_tarih;
    Button uyku_kayit;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        MyView=inflater.inflate(R.layout.uyku_bilgisi_dadi_adminlayout,container,false);

        et_sabah_uyku_bilgisi= (EditText) MyView.findViewById(R.id.sabah_uyku);
        et_ogle_uyku_bilgisi= (EditText) MyView.findViewById(R.id.oglen_uyku);
        et_aksam_uyku_bilgisi= (EditText) MyView.findViewById(R.id.aksam_uyku);
        et_tarih= (EditText) MyView.findViewById(R.id.tarih);

        uyku_kayit= (Button) MyView.findViewById(R.id.uyku_kaydet);
        uyku_kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String sabah_uyku_bilgisi=et_sabah_uyku_bilgisi.getText().toString().trim();
            final String oglen_uyku_bilgisi=et_ogle_uyku_bilgisi.getText().toString().trim();
            final String aksam_uyku_bilgisi=et_aksam_uyku_bilgisi.getText().toString().trim();
            final String Tarih=et_tarih.getText().toString().trim();

            fDatabase=FirebaseDatabase.getInstance();
                dbRef=fDatabase.getReference("uyku bilgisi").child("");
                Uyku_model model=new Uyku_model();
                model.sabahUyku=sabah_uyku_bilgisi;
                model.ogleUyku=oglen_uyku_bilgisi;
                model.aksamUyku=aksam_uyku_bilgisi;
                model.tarih=Tarih;

                dbRef.setValue(model);

            }
        });

        return MyView;
    }


    }

