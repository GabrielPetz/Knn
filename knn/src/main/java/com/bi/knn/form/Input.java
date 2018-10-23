package com.bi.knn.form;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Petz
 * @since 09/10/18
 */
public class Input {

    private FileInputStream file;
    private Integer k;

    public Input() {
    }

    public Input(FileInputStream file, Integer k) {
        this.file = file;
        this.k = k;
    }

    public void setK(String k) {
        this.k = Integer.parseInt(k);
    }

    public void setFile(MultipartFile file) {
        try {
            this.file = (FileInputStream) file.getInputStream();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public Integer getK() {
        return k;
    }

    public FileInputStream getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "Input{" +
                "file=" + file +
                ", k=" + k +
                '}';
    }
}

