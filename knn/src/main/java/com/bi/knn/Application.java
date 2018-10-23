package com.bi.knn;

import com.bi.knn.form.Input;
import com.bi.knn.run.KNN;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import static com.bi.knn.operations.Reader.duplicateFile;
import static com.bi.knn.operations.Reader.readDataFile;

/**
 * @author Petz
 * @since 09/10/18
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {

        Input form1 = new Input(new FileInputStream(new File("/home/gabriel/Downloads/weka-3-9-3/data/iris.arff")), 3);

        KNN knn = new KNN(3);

        knn.train(form1.getFile());

        List<String[]> arr = readDataFile(new FileInputStream(new File("/home/gabriel/Downloads/weka-3-9-3/data/iris.arff")));

        List<Double[]> iarr = new ArrayList<>();

        Double[] n;

        int d = 0;

        for (String[] a : arr) {
            n = new Double[arr.get(0).length - 1];
            for (int i = 0; i < a.length - 1; i++) {
                n[i] = Double.parseDouble(a[i]);
            }
            iarr.add(n);
        }


        for(Double[] p : iarr) {
            knn.predict(p);
        }
    }

}
