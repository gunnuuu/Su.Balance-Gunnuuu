package project.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.diabetes.domain.RecordsEntity;

import java.util.ArrayList;
import java.util.List;

//Entity에 의해 생성된 데이터베이스에 접근하는 메소드를 사용하기 위한 역할(service 와 db연결 고리역할)
public interface RecordsRepository extends JpaRepository<RecordsEntity,Long> {
    List<String> recordlist = new ArrayList<>();
    List<String> glist = new ArrayList<>();
}