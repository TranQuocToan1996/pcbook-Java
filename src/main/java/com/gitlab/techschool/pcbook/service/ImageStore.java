package com.gitlab.techschool.pcbook.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface ImageStore {
    String Save(String laptopID, String ImageType, ByteArrayOutputStream imageData) throws IOException;
}
