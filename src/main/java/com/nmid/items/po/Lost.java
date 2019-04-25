package com.nmid.items.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Lost {
    private Integer lid;

    private String image;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date lostTime;

    private String lostAddress;

    private String species;

    private Integer lostUserid;

    private String characterStr;

    private String description;

    private Integer findUserid;

    private Integer lostStatus;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public String getLostAddress() {
        return lostAddress;
    }

    public void setLostAddress(String lostAddress) {
        this.lostAddress = lostAddress == null ? null : lostAddress.trim();
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species == null ? null : species.trim();
    }

    public Integer getLostUserid() {
        return lostUserid;
    }

    public void setLostUserid(Integer lostUserid) {
        this.lostUserid = lostUserid;
    }

    public String getCharacterStr() {
        return characterStr;
    }

    public void setCharacterStr(String characterStr) {
        this.characterStr = characterStr == null ? null : characterStr.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getFindUserid() {
        return findUserid;
    }

    public void setFindUserid(Integer findUserid) {
        this.findUserid = findUserid;
    }

    public Integer getLostStatus() {
        return lostStatus;
    }

    public void setLostStatus(Integer lostStatus) {
        this.lostStatus = lostStatus;
    }
}