package ru.smallgroup.recipesbook.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

public class BinaryMultipartFile implements MultipartFile {

    private final byte[] imgContent;

    public BinaryMultipartFile(byte[] imgContent) {
        this.imgContent = imgContent;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOriginalFilename() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

}
