package com.indonesiaberbicara.discussionapp;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.indonesiaberbicara.discussionapp.model.Article;
import com.indonesiaberbicara.discussionapp.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zulwiyozaputra on 19/12/17.
 */

class DataSource {

    private static final DataSource ourInstance = new DataSource();

    Article activeArticle;

    static DataSource getInstance() {
        return ourInstance;
    }

    public DataSource() {
        this.activeArticle = createArticle();
    }

    private Article createArticle() {
        String title = "Title Here";
        String photoURL = "";
        String contentURL = "";
        List<Message> messages = createMessages();
        Article article = new Article(title, photoURL, contentURL);
        article.setMessages(messages);
        return article;
    }


    private List<Message> createMessages() {

        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // Change this when after implement firebase auth
            UUID userID = UUID.randomUUID();
            UUID messageID = UUID.randomUUID();
            Date now = new Date();
            Message message = new Message("Hi, There!", userID, messageID, now, now);
            messages.add(message);
        }
        return messages;
    }

    public List<Message> getMessages() {
        // fetch from Firebase Realtime
        final List<Message> messages = new ArrayList<>();
       getDataMessage(messages);
        return messages;

    }
    public SnapshotParser<Message> getDataMessage(final List<Message> messages){
        SnapshotParser<Message> parser = new SnapshotParser<Message>() {
            @Override
            public Message parseSnapshot(DataSnapshot snapshot) {
                Message message = snapshot.getValue(Message.class);
                messages.add(message);
                return message;
            }
        };
        return parser;
    }

    //
    public Article getArticle() {
//         fetch from Firestore
        return null;
    }
};
