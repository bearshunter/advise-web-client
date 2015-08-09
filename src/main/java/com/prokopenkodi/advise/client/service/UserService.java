package com.prokopenkodi.advise.client.service;

import com.prokopenkodi.advise.client.classes.AdviseWebException;
import com.prokopenkodi.advise.client.classes.ErrorCode;
import com.prokopenkodi.advise.client.classes.response.ErrorData;
import com.prokopenkodi.advise.client.classes.response.GetUserResponse;
import com.prokopenkodi.advise.client.pojo.User;
import com.prokopenkodi.advise.client.rest.api.UserProxyAPI;
import com.prokopenkodi.advise.client.rest.client.AdviserHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private AdviserHttpClient adviserHttpClient;

    private UserProxyAPI userAPI;

    @PostConstruct
    private void init(){
        userAPI = adviserHttpClient.getUserProxyAPI();
    }


    public User getUserByEmail(String email) throws AdviseWebException {
        GetUserResponse userResponse = userAPI.getByEmail(email);
        return handleGetUserResponse(userResponse);
    }

    public void saveUser(User user) throws AdviseWebException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        ErrorData errorData = userAPI.save(user);
        if(errorData.getCode() != ErrorCode.SUCCESS){
            throw new AdviseWebException(getMessageForErrorCode(errorData.getCode()));
        }
    }

    public User getUserById(Long id) throws AdviseWebException {
        GetUserResponse userResponse = userAPI.get(id);
        return handleGetUserResponse(userResponse);
    }

    private User handleGetUserResponse(GetUserResponse userResponse) throws AdviseWebException {
        int code = userResponse.getErrorData().getCode();
        if(code == ErrorCode.SUCCESS){
            return userResponse.getUser();
        }
        throw new AdviseWebException(getMessageForErrorCode(code));
    }


    private String getMessageForErrorCode(int errorCode){
        switch (errorCode){
            case ErrorCode.DUPLICATED_PARAM: return "Email or login not unique.";
            case ErrorCode.INTERNAL_ERROR: return "Unknown error. Try later.";
            case ErrorCode.INVALID_PARAM: return "Some value is invalid.";
            case ErrorCode.NOT_FOUND: return "User not found.";
            default: return "Unknown error";
        }

    }
}
