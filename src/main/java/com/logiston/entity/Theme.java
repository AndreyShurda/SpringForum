package com.logiston.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Theme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long themeId;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "theme_comments",
            joinColumns = { @JoinColumn(name = "themeId") },
            inverseJoinColumns = { @JoinColumn(name = "commentId") })
    private List<Comment> comments = new ArrayList<>();

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "themeId=" + themeId +
                ", title='" + title + '\'' +
                ", comments=" + comments +
                '}';
    }
}
