package com.example.projectdicoding;

public class Singer {
    private String nama;
    private String judulLagu;
    private String lirik;
    private String tahunRilis;
    private String link;

    public String getLirik() {
        return lirik;
    }

    public void setLirik(String lirik) {
        this.lirik = lirik;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private int foto;

    public String getlirik() {
        return lirik;
    }

    public void setlirik(String lirik) {
        this.lirik = lirik;
    }

    public String getTahunRilis() {
        return tahunRilis;
    }

    public void setTahunRilis(String tahunRilis) {
        this.tahunRilis = tahunRilis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudulLagu() {
        return judulLagu;
    }

    public void setJudulLagu(String judulLagu) {
        this.judulLagu = judulLagu;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
