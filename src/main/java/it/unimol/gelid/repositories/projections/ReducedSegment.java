package it.unimol.gelid.repositories.projections;

import it.unimol.gelid.entities.enums.IssueType;

public interface ReducedSegment {
    Long getId();
    IssueType getIssueType();
}