package it.unimol.gelid.repositories.projections;

import it.unimol.gelid.entities.enums.IssueType;

/**
 * A Projection for the {@link it.unimol.gelid.entities.Segment} entity
 */
public interface SegmentIssueType {
    IssueType getIssueType();
}