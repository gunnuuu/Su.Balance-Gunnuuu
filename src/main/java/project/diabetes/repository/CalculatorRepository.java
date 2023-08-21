package project.diabetes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.diabetes.domain.Food;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor //자동 의존성 주입 (없으면 에러남)
public class CalculatorRepository {

    private final EntityManager em;

    public Food findOneByName(String name){
        return em.find(Food.class,name);
    }

}
