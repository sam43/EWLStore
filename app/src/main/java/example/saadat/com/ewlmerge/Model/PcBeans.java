package example.saadat.com.ewlmerge.Model;

/**
 * Created by Saadat on 11/14/2016.
 */

public class PcBeans {
    private int image1;
    private String title1;
    private String discription1;
    private String date1;

    public PcBeans(int image, String title, String discription, String date) {
        this.image1 = image;
        this.title1 = title;
        this.discription1 = discription;
        this.date1 = date;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getDiscription1() {
        return discription1;
    }

    public void setDiscription1(String discription1) {
        this.discription1 = discription1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
}
