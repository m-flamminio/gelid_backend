package it.unimol.gelid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "video")
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;
    
    @Column(nullable = false, name = "url")
    private String url;

    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    private byte[] data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "video", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Segment> segments = new ArrayList<>();
}