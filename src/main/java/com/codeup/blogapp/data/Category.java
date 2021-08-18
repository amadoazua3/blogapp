package com.codeup.blogapp.data;

import java.util.Collection;

public class Category {

    private Long id;
    private String name;
//    private Collection<Post> posts;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
//        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Collection<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Collection<Post> posts) {
//        this.posts = posts;
//    }
}
