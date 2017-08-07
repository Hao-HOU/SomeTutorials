package com.acehouhao.controller;

import com.acehouhao.domain.Admin;
import com.acehouhao.domain.User;
import com.acehouhao.domain.UserListForm;
import com.acehouhao.domain.UserSetForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Hao HOU on 2017/8/7.
 */
@Controller
public class TestController {
    //http://localhost:8080/baseType.do?xage=10
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam(value = "xage") int age) {
        return "age: " + age;
    }

    //http://localhost:8080/baseType2.do?age=10
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age: " + age;
    }

    //http://localhost:8080/array.do?names=hao&names=jie&names=xun
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] names) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ");
        }
        return sb.toString();
    }

    //http://localhost:8080/domain.do?name=houhao&age=24
    //http://localhost:8080/domain.do?name=houhao&age=24&contactInfo.phone=10086
    //http://localhost:8080/domain.do?user.name=houhao&age=24&admin.name=bit
    @RequestMapping(value = "domain.do")
    @ResponseBody
    public String domain(User user, Admin admin) {
        return user.toString() + " " + admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    //http://localhost:8080/list.do?users[0].name=oo&users[1].name=pp
    //http://localhost:8080/list.do?users[0].name=oo&users[1].name=pp&users[20].name=uio
    //UserListForm{users=[User{name='oo', age=null, contactInfo=null}, User{name='pp', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='null', age=null, contactInfo=null}, User{name='null', age=null, contactInfo=null},
    // User{name='uio', age=null, contactInfo=null}]}
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return userListForm.toString();
    }

    @RequestMapping(value = "set.do")
    @ResponseBody
    public String list(UserSetForm userSetForm) {
        return userSetForm.toString();
    }
}
