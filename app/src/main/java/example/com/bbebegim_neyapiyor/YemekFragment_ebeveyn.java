package example.com.bbebegim_neyapiyor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
        import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

/**
 * Created by Aysenur on 14.07.2017.
 */

public class YemekFragment_ebeveyn extends Fragment {
    View MyView;

    ListView lw_yemek;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    private DatabaseReference mPostReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.yemek_bilgisi_ebeveynlayout, container, false);

        arrayList = new ArrayList<>();
        lw_yemek = (ListView) MyView.findViewById(R.id.lv_yemek);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);

        //referans olarak sadece verisini almak istediğim referansı gosterdim.okuma işlemi
        mPostReference=FirebaseDatabase.getInstance().getReference().child("YemekBilgisi");
        ValueEventListener postListener= new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Yemek_model Ymodel=dataSnapshot.getValue(Yemek_model.class);
                arrayList.add("sabah: "+Ymodel.getSabah());
                arrayList.add("ogle: "+Ymodel.getOgle());
                arrayList.add("aksam: "+Ymodel.getAksam());
                arrayList.add("notlar: "+Ymodel.getNotlar());
                lw_yemek.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };mPostReference.addValueEventListener(postListener);



        return MyView;

    }
}