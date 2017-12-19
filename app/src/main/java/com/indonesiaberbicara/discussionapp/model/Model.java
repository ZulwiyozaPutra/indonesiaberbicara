package com.indonesiaberbicara.discussionapp.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zulwiyozaputra on 19/12/17.
 */

public class Model {


    private UUID id;
    private Date created;
    private Date modified;

    public Model() {
        this.id = UUID.randomUUID();
        this.created = new Date();
        this.modified = new Date();
    }

    public Model(UUID id, Date created, Date modified) {
        this.id = id;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
