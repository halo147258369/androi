package luanvan.com.jobsinhviennc;

import java.util.Date;

public class Hstd {

    private int id;
    private String title;
    public String namefrom;
    public String nameto;
    private String phone;
    public String day_go;
    private String seat;
    private String price;
    private String number;

    public Hstd(int id, String title, String namefrom, String nameto, String phone, String day_go, String seat, String price, String number) {
        this.id = id;
        this.title = title;
        this.namefrom = namefrom;
        this.nameto = nameto;
        this.phone = phone;
        this.day_go = day_go;
        this.seat = seat;
        this.price = price;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNamefrom() {
        return namefrom;
    }

    public void setNamefrom(String namefrom) {
        this.namefrom = namefrom;
    }

    public String getNameto() {
        return nameto;
    }

    public void setNameto(String nameto) {
        this.nameto = nameto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDay_go() {
        return day_go;
    }

    public void setDay_go(String day_go) {
        this.day_go = day_go;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}



