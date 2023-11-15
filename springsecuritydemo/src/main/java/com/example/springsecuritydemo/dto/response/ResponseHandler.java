package com.example.springsecuritydemo.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String status,
                                                   Object data,
                                                   String errorMessage,
                                                   HttpStatus httpStatus){

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("status", status);
        if(status.matches("success|fail")){
            responseMap.put("data", data);
        }else if(status.matches("error")){
            responseMap.put("message", errorMessage);
        }
        return new ResponseEntity<>(responseMap, httpStatus);

    }
}

/**
 * https://github.com/omniti-labs/jsend
 * {
 *     status : "success",
 *     data : {
 *         "posts" : [
 *             { "id" : 1, "title" : "A blog post", "body" : "Some useful content" },
 *             { "id" : 2, "title" : "Another blog post", "body" : "More content" },
 *         ]
 *      }
 * }
 *
 * {
 *     "status" : "fail",
 *     "data" : { "title" : "A title is required" }
 * }
 *
 * {
 *     "status" : "error",
 *     "message" : "Unable to communicate with database"
 * }
 */
