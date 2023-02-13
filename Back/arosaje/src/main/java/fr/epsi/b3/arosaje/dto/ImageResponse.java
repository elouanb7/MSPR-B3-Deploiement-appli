package fr.epsi.b3.arosaje.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageResponse {

    private String fileName;
    private String filePath;
    private String mimeType;
    private long size;

    public ImageResponse(String fileName, String filePath, String mimeType, long size) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.mimeType = mimeType;
        this.size = size;
    }

}
