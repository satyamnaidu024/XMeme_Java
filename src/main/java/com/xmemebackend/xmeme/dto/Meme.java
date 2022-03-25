package com.xmemebackend.xmeme.dto;

public class Meme {
    Integer id;
    String name;
    String caption;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Meme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", caption='" + caption + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
