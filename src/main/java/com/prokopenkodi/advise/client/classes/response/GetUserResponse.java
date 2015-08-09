package com.prokopenkodi.advise.client.classes.response;


import com.prokopenkodi.advise.client.pojo.User;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponse {
    private ErrorData errorData;
    private User user;

    public GetUserResponse(){

    }

    public GetUserResponse(ErrorData errorData, User user) {
        this.errorData = errorData;
        this.user = user;
    }

    public GetUserResponse(User user) {
        this.errorData = new ErrorData();
        this.user = user;
    }

    public GetUserResponse(ErrorData errorData) {
        this.errorData = new ErrorData();
    }
}
