package ru.itmo.tpl.model;

public class Post {
    private long id;
    private long user_id;
    private String title;
    private String text;

    public Post(long id, long user_id, String title, String text) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
