package com.hackathon.barter.structs;

/**
 * Created by Charlton on 5/2/2015.
 */
public class MyItems {


    private String ownerId;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public MyItems(){}

    int id;
    String name;
    String img;
    String type;
    String desc;

    public MyItems(int id, String name, String img, String type, String desc, String origin, String owner, String loc) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.type = type;
        this.desc = desc;
        this.origin = origin;
        this.owner = owner;
        this.loc = loc;
    }

    String origin;
    String owner;
    String loc;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}

