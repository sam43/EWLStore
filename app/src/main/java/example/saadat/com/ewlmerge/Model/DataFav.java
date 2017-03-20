package example.saadat.com.ewlmerge.Model;

/**
 * Created by Saadat on 11/24/2016.
 */

public class DataFav {
    public DataFav(int img,String product_name,String new_price,String pre_price, String discount){
        this.setImg(img);
        this.setProductName(product_name);
        this.setNewPrice(new_price);
        this.setPrePrice(pre_price);
        this.setDiscount(discount);
    }

    private int img;
    private String product_name,new_price, pre_price, discount;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public String getNewPrice() {
        return new_price;
    }

    public void setNewPrice(String new_price) {
        this.new_price = new_price;
    }

    public String getPrePrice() {
        return pre_price;
    }

    public void setPrePrice(String pre_price) {
        this.pre_price = pre_price;
    }
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
