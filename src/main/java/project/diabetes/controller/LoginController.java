package project.diabetes.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.NonUniqueResultException;
import org.hibernate.QueryException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.diabetes.domain.Login;
import project.diabetes.service.LoginService;

import javax.persistence.NoResultException;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login") //로그인 페이지
    public String home(){
        return "logIn";
    }

    @PostMapping("/login")
    public String signUp(String userId, String userEmail, String userPassword, String userPassword2){

        if (!(userPassword.equals(userPassword2))){
            return "logIn";
        }

        Login user = new Login(userId,userEmail,userPassword);
        loginService.signUp(user);

        return "logIn";
    }

    @PostMapping("/real_login")
    public String logIn(String login_userId, String login_userPassword){

        // Login 객체에서 userId로 검색 (없으면 없다고 경고문)
        try {
            Login logincheck = loginService.login(login_userId);

            // 그에 맞는 userPassword 검색 (틀리면 없다고 경고문)
            if (!(login_userPassword.equals(logincheck.getUserPassword()))){
                System.out.println("비밀번호가 존재하지 않습니다"); //나중에 수정해야됨
                return "logIn";
            }
        } catch (NoResultException e) {
            System.out.println("아이디가 존재하지 않습니다."); //나중에 수정해야됨
            return "logIn";
        } catch (NonUniqueResultException e){
            System.out.println("아이디 중복 해결해야됨"); // 나중에 수정해야됨
            return "logIn";
        }

        return "info";
    }

}
