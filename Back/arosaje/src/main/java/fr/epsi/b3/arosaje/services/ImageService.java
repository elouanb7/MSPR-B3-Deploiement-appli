package fr.epsi.b3.arosaje.services;

import fr.epsi.b3.arosaje.bo.*;
import fr.epsi.b3.arosaje.dal.ImageDAO;
import fr.epsi.b3.arosaje.dal.PlantDAO;
import fr.epsi.b3.arosaje.dal.AskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    AskDAO askRepository;
    @Autowired
    PlantDAO plantRepository;

    // for asks
    public List<Image> storeAskImages(Long askId, List<MultipartFile> files ) throws IOException {

        List<Image> images = null;
        Optional<Ask> askTemp = askRepository.findById( askId );
        List<Image> imagesObjects;
        if ( askTemp.isPresent() ) {
            Ask ask = askTemp.get();
            images = ask.getImages();
            imagesObjects = ask.getImages();
            int index = 0;
            for (Image image : images) {
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(files.get(index).getOriginalFilename()));
                if (image != null) {
                    image.setFileName(fileName);
                    image.setMimeType(files.get(index).getContentType());
                    image.setSize(files.get(index).getSize());
                    image.setImage(files.get(index).getBytes());
                    imagesObjects.add(image);
                } else {
                    image = new Image(fileName, files.get(index).getContentType(), files.get(index).getSize(), files.get(index).getBytes());
                    imagesObjects.add(image);
                }
                index++;
            }
            try {
                ask.setImages(imagesObjects);
                askRepository.save(ask);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return images;
    }

    public List<Image> getAskImages( Long askId ) {

        List<Image> assets  = null;
        Optional<Ask> ask = askRepository.findById( askId );
        if ( ask.isPresent() ) {
            assets = ask.get().getImages();
        }
        return assets;
    }

}
