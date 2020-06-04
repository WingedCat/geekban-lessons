package edu.xpu.hcp.bean.creation;

import edu.xpu.hcp.entity.User;

public interface UserFactory {
    default User createUser(){
        User user = new User();
        user.setName("huchengpeng");
        user.setAge(25);
        return user;
    }

}
