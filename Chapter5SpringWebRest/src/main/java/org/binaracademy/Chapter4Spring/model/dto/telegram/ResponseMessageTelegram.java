package org.binaracademy.Chapter4Spring.model.dto.telegram;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseMessageTelegram {
    private String ok;
    private Result result;


    @Setter
    @Getter
    static public class Result{
        long message_id;
        long date;
        String text;
    }
}
