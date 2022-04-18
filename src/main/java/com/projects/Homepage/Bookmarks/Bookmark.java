package com.projects.Homepage.Bookmarks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.MalformedURLException;
import java.net.URL;

@Entity
public class Bookmark {

    @Id
    @GeneratedValue
    int id;
    String name;
    URL url;
    URL ico;

    public Bookmark(){}

    public Bookmark(int id, String name, URL url) {
        this.id = id;
        this.name = name;
        this.url = url;
        try {
            this.ico = new URL(this.url.getHost() + "/favicon.ico");
        }catch (MalformedURLException exception){
            this.ico = null;
        }
    }

    public URL getIco() {
        return ico;
    }

    public void setIco(URL ico) {
        this.ico = ico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
