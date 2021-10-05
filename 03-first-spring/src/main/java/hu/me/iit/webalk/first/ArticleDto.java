package hu.me.iit.webalk.first;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ArticleDto {

    private String author;
    @NotBlank
    private String title;
    @Min(10)
    private Integer pages;

    public String getAuthor() {
        return author;
    }
    @NotBlank
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
