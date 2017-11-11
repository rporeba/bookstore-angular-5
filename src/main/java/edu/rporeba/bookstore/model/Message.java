package edu.rporeba.bookstore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

    public static final String ERROR = "error";
    public static final String SUCCESS = "success";
    private String message;
    private String type;

    public Message(String type, String message) {
        super();
        this.message = message;
        this.type = type;
    }

}
