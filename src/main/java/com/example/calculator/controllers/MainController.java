package com.example.calculator.controllers;

import com.example.calculator.model.Coefficients;
import com.example.calculator.service.CoefficientsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    private final CoefficientsService coefficientsService;

    @Autowired
    public MainController(CoefficientsService coefficientsService) {
        this.coefficientsService = coefficientsService;
    }

    @PostMapping("/save")

    public void saveCoefficients(@RequestBody String coefficients)
    {
        JSONObject jsonObject = JSONObject.fromObject(coefficients);
        String a = jsonObject.get("a").toString();
        String b = jsonObject.get("b").toString();
        String c = jsonObject.get("c").toString();
        String result = jsonObject.get("result").toString();
        coefficientsService.save(new Coefficients(a, b, c, result));
    }
}
