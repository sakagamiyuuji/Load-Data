package com.e.loaddata;

public class DataDiri {

    String nama, phone, email, city, alamat;

    public String getNama() {
        return nama;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAlamat() {
        return alamat;
    }

    public DataDiri(String nama, String phone, String email, String city, String alamat) {
        this.nama = nama;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.alamat = alamat;
    }
}
