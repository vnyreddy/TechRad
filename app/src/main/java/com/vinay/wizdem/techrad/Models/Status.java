package com.vinay.wizdem.techrad.Models;

/**
 * Created by vinay_1 on 6/3/2017.
 */

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("songs")
    @Expose
    private List<Song> songs = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Status() {
    }

    /**
     *
     * @param id
     * @param desc
     * @param count
     * @param songs
     * @param name
     * @param active
     * @param typeId
     */
    public Status(String id, Integer typeId, String name, Boolean active, String desc, Integer count, List<Song> songs) {
        super();
        this.id = id;
        this.typeId = typeId;
        this.name = name;
        this.active = active;
        this.desc = desc;
        this.count = count;
        this.songs = songs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
