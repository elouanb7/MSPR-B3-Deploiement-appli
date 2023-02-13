package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Image;
import fr.epsi.b3.arosaje.dto.ImageResponse;
import fr.epsi.b3.arosaje.dto.MessageResponse;
import fr.epsi.b3.arosaje.services.ImageService;
import jakarta.persistence.Lob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/images/{askId}")
    public ResponseEntity<?> uploadFiles(@PathVariable Long askId, @RequestParam("images") List<MultipartFile> files) {
        String message = "";
        try {
            List<Image> images = imageService.storeAskImages(askId, files);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Uploaded-Image-Count", String.valueOf(images.size()));
            String imageURI = ServletUriComponentsBuilder.fromCurrentContextPath().path( "/images/" )
                    .path( String.valueOf( askId ) ).toUriString();
            headers.add("Location", ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                    .path(String.valueOf(askId))
                    .toUriString());

            List<ImageResponse> assetResponses = new ArrayList<>();
            for (Image image : images) {
                assetResponses.add(new ImageResponse(image.getFileName(), imageURI, image.getMimeType(), image.getSize()));
            }

            return ResponseEntity.status(HttpStatus.OK)
                    .headers(headers)
                    .body(assetResponses);
        } catch (Exception e) {
            message = "Could not upload the files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }






    @GetMapping("/images/{askId}")
    public ResponseEntity<byte[]> getFiles(@PathVariable Long askId) {
        List<Image> images = imageService.getAskImages(askId);
        byte[] body;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ZipOutputStream zos = new ZipOutputStream(baos)) {
            for (Image image : images) {
                zos.putNextEntry(new ZipEntry(image.getFileName()));
                zos.write(image.getImage());
                zos.closeEntry();
            }
            body = baos.toByteArray();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=images.zip");
        for (Image image : images) {
            headers.add("image-filename", image.getFileName());
        }

        return ResponseEntity.ok().headers(headers).body(body);
    }
}
