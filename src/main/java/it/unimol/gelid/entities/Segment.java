package it.unimol.gelid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unimol.gelid.entities.enums.IssueType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "segment")
@NoArgsConstructor
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    private byte[] data;

    @Column(name = "start_second", nullable = false)
    private Long startSecond;

    @Column(name = "end_second", nullable = false)
    private Long endSecond;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "context_id")
    private Context context;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "issue_id", nullable = true)
    private Issue issue;

    @Enumerated(EnumType.STRING)
    @Column(name = "issue_type")
    private IssueType issueType;
}