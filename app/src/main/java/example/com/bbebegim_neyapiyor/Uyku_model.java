package example.com.bbebegim_neyapiyor;

/**
 * Created by Aysenur on 20.07.2017.
 */

public class Uyku_model {
    String sabahUyku, ogleUyku, aksamUyku, tarih,kullanici;

    public Uyku_model() {
    }
    public Uyku_model(String sabahUyku, String ogleUyku, String aksamUyku, String tarih) {
        this.sabahUyku = sabahUyku;
        this.ogleUyku = ogleUyku;
        this.aksamUyku = aksamUyku;
        this.tarih = tarih;

    }
    public String getSabahUyku() {
        return sabahUyku;
    }

    public void setSabahUyku(String sabahUyku) {
        this.sabahUyku = sabahUyku;
    }

    public String getOgleUyku() {
        return ogleUyku;
    }

    public void setOgleUyku(String ogleUyku) {
        this.ogleUyku = ogleUyku;
    }

    public String getAksamUyku() {
        return aksamUyku;
    }

    public void setAksamUyku(String aksamUyku) {
        this.aksamUyku = aksamUyku;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}