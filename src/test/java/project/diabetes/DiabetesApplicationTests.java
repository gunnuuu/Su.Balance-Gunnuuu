package project.diabetes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import project.diabetes.domain.Info;
import project.diabetes.repository.InfoRepository;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(value = false)
class DiabetesApplicationTests {

	@Autowired
	InfoRepository infoRepository;

	@Test
	@Transactional
	void contextLoads() throws Exception {
		Info info = new Info();
		info.setText("test1");

		Long saveId = infoRepository.save(info);
		Info findInfo = infoRepository.find(saveId);

		Assertions.assertThat(findInfo.getId()).isEqualTo(info.getId());
		Assertions.assertThat(findInfo.getText()).isEqualTo(info.getText());
	}

}