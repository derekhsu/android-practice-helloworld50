package idv.derekhsu.helloword50.data01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by derekhsu on 2016/9/28.
 */

public class Place {
    private long id;
    private double latitude;
    private double longitude;
    private double accuracy;
    private String datetime;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Place(long id, double latitude, double longitude, double accuracy, String datetime, String note) {

        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
        this.datetime = datetime;
        this.note = note;
    }

    public Place() {


    }

    public void setDatetime(long now) {
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        datetime = sdf.format(date);
    }
}
