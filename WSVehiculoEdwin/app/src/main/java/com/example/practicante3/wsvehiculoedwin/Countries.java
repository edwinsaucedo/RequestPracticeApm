package com.example.practicante3.wsvehiculoedwin;

import java.util.List;

public class Countries {
public String messages;
public List<result> result;

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public List<result> getResult() {
        return result;
    }

    public void setResult(List<result> result) {
        this.result = result;
    }

    public Countries(String messages, List<result> result) {
        this.messages = messages;
        this.result = result;


    }
}
