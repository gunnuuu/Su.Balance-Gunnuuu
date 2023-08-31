package project.diabetes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.diabetes.domain.Login;
import project.diabetes.repository.LoginRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    @Transactional
    public void signUp(Login login){
        loginRepository.signUp(login);
    }

    @Transactional
    public Login login(String login_userId){
        return loginRepository.Login(login_userId);
    }

}
