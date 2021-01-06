package ba.university.project.respository.entity;

import javax.persistence.*;

@Entity
@Table(name = "BLOG", schema = "blog")
public class Blog extends ModelObject {
    @SequenceGenerator(
            schema = "blog",
            initialValue = 1,
            name = "blogSeq",
            sequenceName = "BLOG_SEQ"
    )
    @GeneratedValue(generator = "blogSeq", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "PICTURE", nullable = false)
    private String picture;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CONTENT", nullable = false, columnDefinition="TEXT")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
