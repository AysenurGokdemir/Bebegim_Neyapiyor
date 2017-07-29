package example.com.bbebegim_neyapiyor;

import android.widget.CheckBox;

/**
 * Created by Aysenur on 20.07.2017.
 */

public class Yemek_model {

    public String sabah, ogle, aksam, tarih, notlar;


    public Yemek_model() {
    }

    public Yemek_model(String sabah, String ogle, String aksam, String tarih, String notlar) {
        this.sabah = sabah;
        this.ogle = ogle;
        this.aksam = aksam;
        this.tarih = tarih;
        this.notlar = notlar;

    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }

    public String getSabah() {
        return sabah;
    }

    public void setSabah(String sabah) {
        this.sabah = sabah;
    }

    public String getOgle() {
        return ogle;
    }

    public void setOgle(String ogle) {
        this.ogle = ogle;
    }

    public String getAksam() {
        return aksam;
    }

    public void setAksam(String aksam) {
        this.aksam = aksam;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

}
