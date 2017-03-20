package example.saadat.com.ewlmerge.Model;

/**
 * Created by Tarana on 9/5/2016.
 */
public class Data {
    public Data(int img,String title1,String title2, String title3){
        this.setImg(img);
        this.setTitle1(title1);
        this.setTitle2(title2);
        this.setTitle3(title3);
    }

    private int img;
    private String title1,title2, title3;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }
}
