package com.example.socketiodemopr.data;

import lombok.Data;

@Data
public class Message {

    private String senderName;
    private String targetUserName;
    private String message;



}