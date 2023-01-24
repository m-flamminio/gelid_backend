package it.unimol.gelid.controllers;

import it.unimol.gelid.services.GelidService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
