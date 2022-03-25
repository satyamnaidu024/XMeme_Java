package com.xmemebackend.xmeme.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostMemeRequest {
    private int id;
    private String name;
    private String caption;
    private String url;

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

    @Override
    public String toString() {
        return "PostMemeRequest{" +
                "name='" + name + '\'' +
                ", caption='" + caption + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
