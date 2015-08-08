package com.prokopenkodi.advise.client.service;

import com.prokopenkodi.advise.client.rest.HttpClient;
import com.prokopenkodi.advise.client.rest.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    public String getDesc() {
        return new HttpClient().getRequester();

    }

    public String getTitle(String name) {
        if(StringUtils.isEmpty(name)){
            return "Hello World";
        }else{
            return "Hello " + name;
        }

    }

    public User getUser(String colibri) {
        return new User();
    }
}
