package com.gitlab.techschool.pcbook.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DiskImageStore implements ImageStore {
    private String imageFolder;
    private ConcurrentMap<String, ImageMetaData> data;

    public DiskImageStore(String imageFolder) {
        this.imageFolder = imageFolder;
        this.data = new ConcurrentHashMap<>(0);
    }

    @Override
    public String Save(String laptopID, String imageType,
            ByteArrayOutputStream imageByte) throws IOException {
        var imageID = UUID.randomUUID().toString();
        var imagePath = String.format("%s/%s%s", imageFolder, imageID, imageType);

        var fileOutputStream = new FileOutputStream(imagePath);
        imageByte.writeTo(fileOutputStream);
        fileOutputStream.close();

        ImageMetaData metadata = new ImageMetaData(laptopID, imageType, imagePath);
        data.put(imageID, metadata);

        return imageID;
    }
}
