package it.unimol.gelid.services;

import it.unimol.gelid.entities.Context;
import it.unimol.gelid.entities.Issue;
import it.unimol.gelid.entities.Segment;
import it.unimol.gelid.entities.Video;
import it.unimol.gelid.entities.enums.IssueType;
import it.unimol.gelid.exceptions.ElementNotFoundException;
import it.unimol.gelid.repositories.ContextRepository;
import it.unimol.gelid.repositories.IssueRepository;
import it.unimol.gelid.repositories.SegmentRepository;
import it.unimol.gelid.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    public void saveVideo(MultipartFile file, String name) {
        Video newVid = new Video();

        newVid.setName(name);
        try {
            newVid.setData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        videoRepository.save(newVid);
    }

    public Video getVideo(Long videoId) {
        return videoRepository.findById(videoId).orElseThrow(() -> new ElementNotFoundException("Video: " + videoId));
    }

    public void saveSegment(MultipartFile file, Long videoId, Long contextId, Long issueId, IssueType issueType) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ElementNotFoundException("Video: " + videoId));

        Context context = contextRepository.findById(contextId)
                .orElseThrow(() -> new ElementNotFoundException("context: " + contextId));

        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new ElementNotFoundException("issue: " + issueId));

        Segment newSegment = new Segment();
        newSegment.setVideo(video);
        newSegment.setContext(context);
        newSegment.setIssue(issue);
        newSegment.setIssueType(issueType);

        try {
            newSegment.setData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        segmentRepository.save(newSegment);
    }
}
