package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 25.03.14.
 */
@Deprecated
@Entity
@Table(name = "news")
@Unique(fields = News.FIELD_SID, message = News.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class News extends IdentifiableEntity {
    public static final String FIELD_TITLE = "title";

    public static final String FIELD_CREATED_AT = "createdAt";

    public static final String FIELD_CONTENT = "content";

    public static final String FIELD_IMAGE_SRC = "imageSrc";

    public static final String FIELD_IMAGE_ALT = "imageAlt";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false, length = 128)
    @NotBlank
    @Length(max = 128)
    private String title;

    @Column(name = "created_at", nullable = false)
    @NotNull
    private String createdAt;

    @Column(nullable = false)
    @NotBlank
    private String content;

    @Column(name = "image_src", nullable = true, length = 1024)
    @Length(max = 1024)
    private String imageSrc;

    @Column(name = "image_alt", nullable = true, length = 256)
    @Length(max = 256)
    private String imageAlt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
