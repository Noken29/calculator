package com.example.calculator.service;

import com.example.calculator.model.Coefficients;
import com.example.calculator.repository.CoefficientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoefficientsService {
    private final CoefficientsRepository coefficientsRepository;

    @Autowired
    public CoefficientsService(CoefficientsRepository coefficientsRepository) {
        this.coefficientsRepository = coefficientsRepository;
    }

    public Coefficients save(Coefficients coefficients)
    {
        return coefficientsRepository.save(coefficients);
    }

    public Coefficients getById(Long id)
    {
        Optional<Coefficients> coefficients = coefficientsRepository.findById(id);
        if(coefficients.isPresent())
            return coefficients.get();
        throw new NullPointerException();
    }
}
