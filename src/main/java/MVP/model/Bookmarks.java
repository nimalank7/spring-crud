package MVP.model;

import jakarta.persistence.*;


@Entity
@Table(name="Bookmarks")
public class Bookmarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="url")
    private String url;

    @Column(name="title")
    private String title;

    public Bookmarks(){}

    public Bookmarks(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public Integer getid() {
        return id;
    }

    public String geturl() {
        return url;
    }

    public String gettitle() {
        return title;
    }

    public void seturl(String url) {
        this.url = url;
    }

    public void settitle(String title) {
        this.title = title;
    }
}
