package it.unimol.gelid.repositories;

import it.unimol.gelid.entities.Segment;
import it.unimol.gelid.repositories.projections.SegmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
    Optional<Segment> findByVideo_IdAndId(Long videoId, Long segmentId);
    List<SegmentInfo> findDistinctByVideo_Id(Long id);
}
