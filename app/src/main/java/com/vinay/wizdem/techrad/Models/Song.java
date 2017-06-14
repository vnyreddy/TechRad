package com.vinay.wizdem.techrad.Models;

/**
 * Created by vinay_1 on 6/3/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

    @SerializedName("songName")
    @Expose
    private String songName;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("ownerLink")
    @Expose
    private String ownerLink;
    @SerializedName("thumbNailIcon")
    @Expose
    private String thumbNailIcon;
    @SerializedName("songUrl")
    @Expose
    private String songUrl;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("disLikes")
    @Expose
    private Integer disLikes;
    @SerializedName("shareCount")
    @Expose
    private Integer shareCount;
    @SerializedName("SongType")
    @Expose
    private Integer songType;
    @SerializedName("Visible")
    @Expose
    private Integer visible;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     *
     */
    public Song() {
    }

    /**
     *
     * @param id
     * @param thumbNailIcon
     * @param ownerLink
     * @param desc
     * @param visible
     * @param disLikes
     * @param views
     * @param songType
     * @param likes
     * @param owner
     * @param songName
     * @param createdDate
     * @param shareCount
     * @param songUrl
     */
    public Song(String songName, String desc, String createdDate, String owner, String ownerLink, String thumbNailIcon, String songUrl, Integer views, Integer likes, Integer disLikes, Integer shareCount, Integer songType, Integer visible, String id) {
        super();
        this.songName = songName;
        this.desc = desc;
        this.createdDate = createdDate;
        this.owner = owner;
        this.ownerLink = ownerLink;
        this.thumbNailIcon = thumbNailIcon;
        this.songUrl = songUrl;
        this.views = views;
        this.likes = likes;
        this.disLikes = disLikes;
        this.shareCount = shareCount;
        this.songType = songType;
        this.visible = visible;
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerLink() {
        return ownerLink;
    }

    public void setOwnerLink(String ownerLink) {
        this.ownerLink = ownerLink;
    }

    public String getThumbNailIcon() {
        return thumbNailIcon;
    }

    public void setThumbNailIcon(String thumbNailIcon) {
        this.thumbNailIcon = thumbNailIcon;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(Integer disLikes) {
        this.disLikes = disLikes;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getSongType() {
        return songType;
    }

    public void setSongType(Integer songType) {
        this.songType = songType;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
