package com.nmid.items.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Find {
    private Integer fid;

    private String image;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date findTime;

    private String findAddress;

    private String species;

    private Integer findUserid;

    private String characterStr;

    private String description;

    private Integer lostUserid;

    private Integer findStatus;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getFindTime() {
        return findTime;
    }

    public void setFindTime(Date findTime) {
        this.findTime = findTime;
    }

    public String getFindAddress() {
        return findAddress;
    }

    public void setFindAddress(String findAddress) {
        this.findAddress = findAddress == null ? null : findAddress.trim();
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species == null ? null : species.trim();
    }

    public Integer getFindUserid() {
        return findUserid;
    }

    public void setFindUserid(Integer findUserid) {
        this.findUserid = findUserid;
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

    public Integer getLostUserid() {
        return lostUserid;
    }

    public void setLostUserid(Integer lostUserid) {
        this.lostUserid = lostUserid;
    }

    public Integer getFindStatus() {
        return findStatus;
    }

    public void setFindStatus(Integer findStatus) {
        this.findStatus = findStatus;
    }
}