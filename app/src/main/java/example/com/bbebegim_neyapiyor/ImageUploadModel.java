package example.com.bbebegim_neyapiyor;

/**
 * Created by Aysenur on 23.07.2017.
 */

public class ImageUploadModel {
    public String isim;
    public String url;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageUploadModel(String isim, String url) {
        this.isim = isim;
        this.url = url;
    }
}
