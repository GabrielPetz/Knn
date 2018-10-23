package com.bi.knn.run;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bi.knn.operations.Reader.readDataFile;

/**
 * @author Petz
 * @since 10/10/18
 */
public class KNN {

    private List<String[]> train;
    private Double[] unclassified;
    private List<Map<Integer, Double>> distances;
    private Integer k;

    private List<Integer[]> randomArray;

    public KNN(Integer k) {

        this.train = null;
        this.unclassified = null;
        this.k = null;

    }

    public void train(FileInputStream f) {
        this.train = readDataFile(f);
    }

    public List<Double> takeMinDis() {

        List<Double> indexes = new ArrayList<>();
        Double distance;

        for (int i = 0; i < distances.size(); i++) {
            distance = 99999.0;
            for (Map.Entry<Integer, Double> d : distances.get(i).entrySet()) {
                if (distance > d.getValue()) {
                    distance = d.getValue();
                }
            }
            indexes.add(distance);
        }
        return indexes;
    }

    public void classifier() {

        List<Double> mindistances = takeMinDis();
        Integer minIndex = 0;
        Double di = 999.0;

        for (int i = 0; i < mindistances.size(); i++){
            if (di > mindistances.get(i)){
                di = mindistances.get(i);
                minIndex = i;
            }
        }

        System.out.println(minIndex);
        System.out.println(di);

    }

    public void predict(Double[] p) {
//        O primeiro indice é relativo a unclassified e o segundo a q, onde é armazenado o q mais proximo de cada unclassified.
        Map<Integer, Integer> minDis = new HashMap<>();
        List<Map<Integer, Double>> distances = new ArrayList<>();
        Integer size = 4;
        first:
        for (int y = 0; y < train.size(); y++) {
            Map<Integer, Double> d = new HashMap<>();
            Double min = 9999999999.9;
            Integer qIndex = 0;
            second:
            for (int x = 0; x < train.size(); x++) {
                Double val = 0.0;
                if (x != y) {
                    for (int index = 0; index < size; index++) {
                        this.unclassified = p;
                        String[] q = train.get(x);
                        val += Math.pow((unclassified[index] - Double.parseDouble(q[index])), 2);
                    }
                    if (min > val) {
                        min = val;
                        qIndex = x;
                    }
                    d.put(x, Math.sqrt(val));
                }
            }
            distances.add(d);
            minDis.put(y, qIndex);
        }
        this.distances = distances;

        classifier();
    }

}