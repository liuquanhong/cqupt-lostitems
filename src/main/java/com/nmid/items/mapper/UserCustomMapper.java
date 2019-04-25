package com.nmid.items.mapper;

import com.nmid.items.po.User;
import com.nmid.items.po.UserCustom;

import java.util.List;

public interface UserCustomMapper {

    public UserCustom selectUserByStdNumber(String stdNumber);

    public void updateUserByStdNumber(User user);

    public int selectUserTotalIntegration(String stdnumber);

    public void updateUserIntegration(String stdnumber);

    public List<User> selectGoodManInfo();

}
