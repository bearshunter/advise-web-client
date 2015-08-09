package com.prokopenkodi.advise.client.pojo;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    private Long id;
    private String email;
    private String login;
    private String password;

    @JsonIgnore
    private String confirmPassword;
}
