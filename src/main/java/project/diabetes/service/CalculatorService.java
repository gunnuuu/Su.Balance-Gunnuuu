package project.diabetes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.diabetes.domain.Food;
import project.diabetes.repository.CalculatorRepository;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public Food FindOneByName(String name){
        return calculatorRepository.findOneByName(name);
    }


}
