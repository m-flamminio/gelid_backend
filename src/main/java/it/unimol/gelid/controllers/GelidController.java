package it.unimol.gelid.controllers;

import it.unimol.gelid.entities.Segment;
import it.unimol.gelid.entities.enums.IssueType;
import it.unimol.gelid.repositories.projections.SegmentIssueType;
import it.unimol.gelid.repositories.projections.SegmentContextInfo;
import it.unimol.gelid.services.GelidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/gelid")
public class GelidController {

    @Autowired
    private GelidService gelidService;

    @PostMapping("/video")
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                                            @RequestParam("url") String url) {
        gelidService.saveVideo(file, title, url);
        return ResponseEntity.ok("Video saved successfully.");
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<Resource> getVideoById(@PathVariable("id") Long videoId) {
        return ResponseEntity
                .ok(new ByteArrayResource(gelidService.getVideo(videoId).getData()));
    }

    @PostMapping("/video/{videoId}/segments")
    public ResponseEntity<String> saveSegment(@RequestParam("file") MultipartFile file,
                                              @PathVariable("videoId") Long videoId,
                                              @RequestParam Long contextId,
                                              @RequestParam(required = false) Long issueId,
                                              @RequestParam IssueType issueType,
                                              @RequestParam Long startSecond,
                                              @RequestParam Long endSecond
    ) {
        gelidService.saveSegment(file, videoId, contextId, issueId, issueType, startSecond, endSecond);
        return ResponseEntity.ok("Segment saved");
    }

    @GetMapping("/video/{videoId}/segments/{segmentId}")
    public ResponseEntity<Resource> getSegmentById(@PathVariable("segmentId") Long segmentId,
                                                   @PathVariable("videoId") Long videoId) {
        return ResponseEntity
                .ok(new ByteArrayResource(gelidService.getSegmentById(videoId, segmentId).getData()));
    }

    @GetMapping("video/{videoId}/contexts")
    public ResponseEntity<List<SegmentContextInfo>> getContextsByVideoId(@PathVariable("videoId") Long videoId) {
        return ResponseEntity
                .ok(gelidService.getContextsByVideoId(videoId));
    }

    @GetMapping("video/{videoId}/contexts/{contextId}/issues")
    public ResponseEntity<List<SegmentIssueType>> getIssuesByVideoAndContext(@PathVariable("videoId") Long videoId,
                                                                             @PathVariable("contextId") Long contextId) {
        return ResponseEntity.ok(gelidService.getIssuesByVideoAndContext(videoId, contextId));
    }

    @GetMapping("video/{videoId}/segments")
    public ResponseEntity<List<Segment>> getSegmentsByContext(@PathVariable("videoId") Long videoId,
                                                            @RequestParam Long contextId,
                                                            @RequestParam(required = false) Long issueId,
                                                            @RequestParam IssueType issueType
                                                                   ) {
        return ResponseEntity.ok(gelidService.getSegmentsByVideoAndContextAndIssueType(videoId, contextId, issueType));
    }

    @PostMapping("contexts")
    public ResponseEntity<String> addContext(@RequestParam String name) {
        gelidService.addContext(name);
        return ResponseEntity.ok("Context added");
    }

    @PostMapping("issues")
    public ResponseEntity<String> addIssue(@RequestParam String name) {
        gelidService.addIssue(name);
        return ResponseEntity.ok("Issue added");
    }

    @GetMapping("users")
    public ResponseEntity<Boolean> checkUsernameAndPassword(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return ResponseEntity.ok(gelidService.checkUsernameAndPassword(username, password));
    }

    @PostMapping("users")
    public ResponseEntity<String> addUser(
            @RequestParam String username,
            @RequestParam String password
    ) {
        gelidService.addUser(username, password);
        return ResponseEntity.ok("Username Added");
    }
}
