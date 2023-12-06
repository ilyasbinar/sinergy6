package com.example.socketiodemo.socketio;

import lombok.Data;

@Data
public class TheMessage {
    private String from;
    private String to;
    private String message;
}
