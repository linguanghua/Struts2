package com.junxu.action;

import com.junxu.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by LinXu on 2016/12/17.
 */
public class LoginAction extends ActionSupport implements ModelDriven<User>{
    User user = new User();
    @Override
    public String execute() throws Exception {
        System.out.println(user.getUsername());
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }
}
