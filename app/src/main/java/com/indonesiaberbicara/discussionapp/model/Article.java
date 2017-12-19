package com.indonesiaberbicara.discussionapp.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zulwiyozaputra on 19/12/17.
 */

public class Article extends Content {
    List<Message> messages;

    public Article(UUID id, Date created, Date modifed, String title, String photoURL, String contentURL, List<Message> messages) {
        super(id, created, modifed, title, photoURL, contentURL);
        this.messages = messages;
    }

    public Article(String title, String photoURL, String contentURL) {
        super(title, photoURL, contentURL);
    }

    public String getTitle() {
        return this.title;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
