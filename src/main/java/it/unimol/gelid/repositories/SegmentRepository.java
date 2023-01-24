package it.unimol.gelid.repositories;

import it.unimol.gelid.entities.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
    Optional<Segment> findByVideo_IdAndId(Long videoId, Long segmentId);
}
