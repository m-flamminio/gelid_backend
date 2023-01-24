package it.unimol.gelid.repositories;

import it.unimol.gelid.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
