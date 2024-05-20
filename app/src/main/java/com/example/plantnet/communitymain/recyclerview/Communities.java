package com.example.plantnet.communitymain.recyclerview;

public class Communities {
    private String name;
    private String imageUrl;
    private String imageBackgroundUrl;

    public Communities(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageBackgroundUrl() {
        return imageBackgroundUrl;
    }

    public void setImageBackgroundUrl(String imageBackgroundUrl) {
        this.imageBackgroundUrl = imageBackgroundUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Communities{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageBackgroundUrl='" + imageBackgroundUrl + '\'' +
                '}';
    }
}
