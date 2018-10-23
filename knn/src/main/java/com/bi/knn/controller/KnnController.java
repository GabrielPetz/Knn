package com.bi.knn.controller;

import com.bi.knn.form.Input;
import com.bi.knn.run.KNN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Petz
 * @since 09/10/18
 */
@Controller
@RequestMapping("/knn")
public class KnnController {

    @RequestMapping(value = "/upload", method = {RequestMethod.GET})
    public String upload(Model model) {

        model.addAttribute("formulario", new Input());

        return "index";
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public String upload(Model model, @ModelAttribute("formulario") Input form) {

        KNN knn = new KNN(3);

        model.addAttribute("formulario", form);
//        knn.takeMinDis();
//        System.out.println(KNN.predict(form));
        return "index";

    }


}
