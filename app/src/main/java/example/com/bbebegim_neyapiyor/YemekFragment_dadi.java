package example.com.bbebegim_neyapiyor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Aysenur on 13.07.2017.
 */

public class YemekFragment_dadi extends Fragment {
    FirebaseDatabase fDatabase;
    DatabaseReference dbRef;
    View MyView;
    EditText sabah_yemegi,oglen_yemegi,aksam_yemegi,Notlarr;
    Button btn_yemek_kaydet;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        MyView=inflater.inflate(R.layout.yemek_bilgisi_dadi_adminlayout,container,false);

        sabah_yemegi= (EditText) MyView.findViewById(R.id.sabah_yedikleri);
        oglen_yemegi= (EditText) MyView.findViewById(R.id.oglen_yedikleri);
        aksam_yemegi= (EditText) MyView.findViewById(R.id.aksam_yedikleri);
        Notlarr= (EditText) MyView.findViewById(R.id.not);

        btn_yemek_kaydet= (Button) MyView.findViewById(R.id.yemek_kaydet);
        btn_yemek_kaydet.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    String metin = "";
                                                    String sabah_yemek = sabah_yemegi.getText().toString().trim();
                                                    String oglen_yemek = oglen_yemegi.getText().toString().trim();
                                                    String aksam_yemek = aksam_yemegi.getText().toString().trim();
                                                    String notlary = Notlarr.getText().toString().trim();

                                                    /*String checkbox_sut = sut.getText().toString();
                                                    String checkbox_zeytin = zeytin.getText().toString();
                                                    String checkbox_yumurta = yumurta.getText().toString();
                                                    String checkbox_peynir = peynir.getText().toString();
                                                    if (sut.isChecked()) {
                                                        metin = metin + "sut";
                                                    }
                                                    if (zeytin.isChecked()) {
                                                        metin = metin + "zeytin";
                                                    }
                                                    if (yumurta.isChecked()) {
                                                        metin = metin + "yumurta";
                                                    }
                                                    if (peynir.isChecked())
                                                        metin = metin + "peynir";
                                                        Toast.makeText(getActivity(),metin,Toast.LENGTH_LONG).show();*/
                fDatabase=FirebaseDatabase.getInstance();
                dbRef=fDatabase.getReference("YemekBilgisi").child(config.android_id);
                Yemek_model Ymodel=new Yemek_model();
                Ymodel.sabah=sabah_yemek;
                Ymodel.ogle=oglen_yemek;
                Ymodel.aksam=aksam_yemek;
                Ymodel.notlar=notlary;
                dbRef.setValue(Ymodel);

            }
        });

        return MyView;
    }
}
