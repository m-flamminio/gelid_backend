package it.unimol.gelid.controllers;

import it.unimol.gelid.entities.enums.IssueType;
import it.unimol.gelid.services.GelidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "/gelid")
public class GelidController {

    @Autowired
    private GelidService gelidService;

    @PostMapping("/video")
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        gelidService.saveVideo(file, name);
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
                                              @RequestParam Long issueId,
                                              @RequestParam IssueType issueType
                                              ) {
        gelidService.saveSegment(file, videoId, contextId, issueId, issueType);
        return ResponseEntity.ok("Segment saved");
    }
}
