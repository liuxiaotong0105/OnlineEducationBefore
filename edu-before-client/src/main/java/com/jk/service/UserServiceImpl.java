package com.jk.service;

        import com.jk.mapper.UserMapper;
        import com.jk.modelapi.UserBean;
        import com.jk.util.StringUtil;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

/**
 * @Auther: 赵黎明
 * @Date: 2018/10/21 11:55
 * 描述: 用一段话来简述
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;


    public UserBean getUserByLoginName(UserBean userBean) {
        return userMapper.getUserByLoginName(userBean);
    }

    public UserBean getUserphoneName(String phone) {

        return userMapper.getUserphoneName(phone);
    }

    public void addUser(UserBean userBean) {


        userMapper.addUser(userBean);
    }
}
