package example.com.bbebegim_neyapiyor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Aysenur on 14.07.2017.
 */

public class UykuFragment_ebeveyn extends Fragment {
        View MyView;
        ListView lv_Uyku;
        ArrayAdapter<String> adapter;
        ArrayList<String> arrayList;
        private DatabaseReference mPostReference;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                MyView = inflater.inflate(R.layout.uyku_bilgisi_ebevynlayout,container, false);
                arrayList = new ArrayList<>();
                lv_Uyku = (ListView) MyView.findViewById(R.id.lv_uyku);
                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
                mPostReference=FirebaseDatabase.getInstance().getReference().child("uyku bilgisi");
                ValueEventListener postListener= new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                                Uyku_model Umodel=dataSnapshot.getValue(Uyku_model.class);
                                arrayList.add("sabahUyku: "+Umodel.getSabahUyku());
                                arrayList.add("ogleUyku: "+Umodel.getOgleUyku());
                                arrayList.add("aksamUyku: "+Umodel.getAksamUyku());
                                arrayList.add("Tarih: "+Umodel.getTarih());

                                lv_Uyku.setAdapter(adapter);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                };mPostReference.addValueEventListener(postListener);
                return MyView;
        }
        }