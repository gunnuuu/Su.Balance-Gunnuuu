package project.diabetes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.diabetes.domain.Login;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class LoginRepository {

    private final EntityManager em;

    public void signUp(Login login){
        em.persist(login);
    }

    public Login Login(String login_userId){
        return em.createQuery("select l from Login l where l.userId=:user_id",Login.class)
                .setParameter("user_id",login_userId)
                .getSingleResult();
    }
}
