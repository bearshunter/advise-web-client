package com.prokopenkodi.advise.client.service;

import com.prokopenkodi.advise.client.rest.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String getDesc() {
        logger.debug("getDesc() is executed!");
        return new HttpClient().getRequester();

    }

    public String getTitle(String name) {

        logger.debug("getTitle() is executed! $name : {}", name);

        if(StringUtils.isEmpty(name)){
            return "Hello World";
        }else{
            return "Hello " + name;
        }

    }

}
