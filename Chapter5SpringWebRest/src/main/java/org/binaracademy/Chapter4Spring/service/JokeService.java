package org.binaracademy.Chapter4Spring.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class JokeService {
    public String getJoke(){
        String theJoke = "";

        String uri = "https://v2.jokeapi.dev/joke/Any";
        try {
            URL url = new URL(uri);
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser jsonParser =  new JsonParser();
            JsonElement jsonElement = jsonParser.parse(
                    new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String type = jsonObject.get("type").getAsString();

            if(type.equalsIgnoreCase("single")){
                theJoke =  jsonObject.get("joke").getAsString();
            }else{
                theJoke =  jsonObject.get("setup").getAsString().concat(": ").concat(jsonObject.get("delivery").getAsString());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return theJoke;
    }
}
