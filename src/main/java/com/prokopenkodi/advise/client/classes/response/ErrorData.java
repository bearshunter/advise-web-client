package com.prokopenkodi.advise.client.classes.response;

import com.prokopenkodi.advise.client.classes.ErrorCode;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class ErrorData {
    private int code;
    private String message;

    public ErrorData(){
        this.code = ErrorCode.SUCCESS;
        this.message = "OK";
    }

    public ErrorData(int code){
        this.code = code;
        this.message = "ERROR";
    }

    public ErrorData(int code, String message){
        this.code = code;
        this.message = message;
    }

}
