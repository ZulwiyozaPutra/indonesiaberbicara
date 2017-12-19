package com.indonesiaberbicara.discussionapp.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zulwiyozaputra on 19/12/17.
 */

public class Content extends Model {
    String title;
    String photoURL;
    String contentURL;

    public Content(String title, String photoURL, String contentURL) {
        super();
        this.title = title;
        this.photoURL = photoURL;
        this.contentURL = contentURL;
    }

    public Content(UUID id, Date created, Date modified, String title, String photoURL, String contentURL) {
        super(id, created, modified);
        this.title = title;
        this.photoURL = photoURL;
        this.contentURL = contentURL;

    }
}
