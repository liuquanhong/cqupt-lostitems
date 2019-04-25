package com.nmid.items.mapper;

import com.nmid.items.po.TalkCustom;
import com.nmid.items.po.User;

import java.util.List;

public interface TalkCustomMapper {

    public List<TalkCustom> selectTalkWithUser();

    public User selectUserInfoByTalkId(Integer id);
}
