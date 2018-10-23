package com.bi.knn.operations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Petz
 * @since 10/10/18
 */
public class Reader {

    public static List<String[]> readDataFile(FileInputStream file) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(file));

        List<String[]> listArray = new ArrayList<String[]>();
        try {
            while (bf.ready()) {
                String line = bf.readLine().trim();
                if (!line.contains("%") && !line.contains("@") && !line.equals("")) {
                    listArray.add(line.split(","));
//                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listArray;

    }

//    public static List<Integer[]> readDataFileInteger(FileInputStream file) {
//        try {
//            BufferedReader bf = new BufferedReader(new InputStreamReader(file));
//
//            List<Integer[]> re = new ArrayList<>();
//
//            while (bf.ready()) {
//
////                re.add((Integer) bf.readLine().split(",", 4));
//
//            }
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }
//    }
}
