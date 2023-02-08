package it.unimol.gelid.repositories;

import it.unimol.gelid.entities.Segment;
import it.unimol.gelid.entities.enums.IssueType;
import it.unimol.gelid.repositories.projections.ReducedSegment;
import it.unimol.gelid.repositories.projections.SegmentContextInfo;
import it.unimol.gelid.repositories.projections.SegmentIssueType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
    Optional<Segment> findByVideo_IdAndId(Long videoId, Long segmentId);
    List<SegmentContextInfo> findDistinctByVideo_Id(Long id);
    List<SegmentIssueType> findDistinctByVideo_IdAndContext_Id(Long videoId, Long contextId);
    List<ReducedSegment> findByVideo_IdAndContext_IdAndIssue_Id(Long videoId, Long contextId, Long issueID);
    List<Segment> findDistinctByVideo_IdAndContext_IdAndIssueType(Long videoId, Long contextId, IssueType issueType);
}
