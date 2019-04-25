package com.nmid.items.po;

public class UserCustomVo {

    //我丢失物品信息
    private Lost lost;

    //我发现的物品信息
    private Find find;

    public Find getFind() {
        return find;
    }

    public void setFind(Find find) {
        this.find = find;
    }

    public Lost getLost() {
        return lost;
    }

    public void setLost(Lost lost) {
        this.lost = lost;
    }

}
