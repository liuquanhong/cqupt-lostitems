package com.nmid.items.po;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;

    private String username;

    private String stdnumber;

    private String telephone;

    private String email;

    private String password;

    private String imge;

    private Integer lostId;

    private Integer foundId;

    private Integer integration;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getStdnumber() {
        return stdnumber;
    }

    public void setStdnumber(String stdnumber) {
        this.stdnumber = stdnumber == null ? null : stdnumber.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge == null ? null : imge.trim();
    }

    public Integer getLostId() {
        return lostId;
    }

    public void setLostId(Integer lostId) {
        this.lostId = lostId;
    }

    public Integer getFoundId() {
        return foundId;
    }

    public void setFoundId(Integer foundId) {
        this.foundId = foundId;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }
}