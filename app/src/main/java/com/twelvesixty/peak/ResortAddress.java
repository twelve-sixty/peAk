package com.twelvesixty.peak;

public class ResortAddress {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private int zipcode;

    public ResortAddress () {}

    public ResortAddress (String line1, String line2, String city, String state, int zipcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    ////////////////////// -- getters

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    ////////////////////// -- setters

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String toString() {
        if (this.line2 == null || this.line2.equals("")) {
            return this.line1 + "\n" + this.city + ", " + this.state + " " + this.zipcode;
        } else {
            return this.line1 + "\n" + this.line2 + "\n" + this.city + ", " + this.state + " " + this.zipcode;

        }
    }

}
