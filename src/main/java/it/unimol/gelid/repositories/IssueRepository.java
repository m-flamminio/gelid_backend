package it.unimol.gelid.repositories;

import it.unimol.gelid.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
