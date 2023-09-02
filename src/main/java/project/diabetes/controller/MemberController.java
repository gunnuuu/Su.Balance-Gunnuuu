//package project.diabetes.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import project.diabetes.domain.Member;
//import project.diabetes.repository.MemberRepository;
//
//
//public class MemberController {
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public MemberController(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @PostMapping("/info/member")
//    public String memberinfo(Member member) {
//        // Member 객체를 저장
//        memberRepository.save(member);
//        // 저장 후 다음 처리 또는 리다이렉트 등을 수행
//        return "redirect:/info"; // 예시로 /info 페이지로 리다이렉트
//    }
//
//}
