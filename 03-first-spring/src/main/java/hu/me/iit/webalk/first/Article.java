package hu.me.iit.webalk.first;

import javax.validation.constraints.NotNull;

public class Article {
    @NotNull
    private String id;

    @NotNull
    private String author;

    @NotNull
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
