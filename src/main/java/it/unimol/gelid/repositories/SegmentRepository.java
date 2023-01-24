package it.unimol.gelid.repositories;

import it.unimol.gelid.entities.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
}
