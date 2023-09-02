package project.diabetes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.diabetes.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 추가적인 쿼리 메서드를 정의할 수 있음
}