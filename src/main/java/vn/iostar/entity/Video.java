package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "videos")
@Data @NoArgsConstructor @AllArgsConstructor
public class Video {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "VideoId")
  private Integer id;

  @Column(name="Title", columnDefinition="NVARCHAR(255)")
  private String title;

  @Column(name="Description", columnDefinition="NVARCHAR(MAX)")
  private String description;

  @Column(name="Poster") private String poster;
  @Column(name="Views")  private Integer views;
  @Column(name="Active") private Boolean active;

  @ManyToOne
  @JoinColumn(name="CategoryId")
  private Category category;
  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getPoster() { return poster; }
  public void setPoster(String poster) { this.poster = poster; }

  public Integer getViews() { return views; }
  public void setViews(Integer views) { this.views = views; }

  public Boolean getActive() { return active; }
  public void setActive(Boolean active) { this.active = active; }

  public Category getCategory() { return category; }
  public void setCategory(Category category) { this.category = category; }
}
