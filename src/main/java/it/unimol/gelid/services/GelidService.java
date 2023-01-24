package it.unimol.gelid.services;

import it.unimol.gelid.repositories.ContextRepository;
import it.unimol.gelid.repositories.IssueRepository;
import it.unimol.gelid.repositories.SegmentRepository;
import it.unimol.gelid.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GelidService {

    private final VideoRepository videoRepository;
    private final SegmentRepository segmentRepository;
    private final ContextRepository contextRepository;
    private final IssueRepository issueRepository;

    @Autowired
    public GelidService(VideoRepository videoRepository, SegmentRepository segmentRepository, ContextRepository contextRepository, IssueRepository issueRepository) {
        this.videoRepository = videoRepository;
        this.segmentRepository = segmentRepository;
        this.contextRepository = contextRepository;
        this.issueRepository = issueRepository;
    }
}
