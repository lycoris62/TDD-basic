package appendix.c;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JUnit5ExtensionTest {

	@Mock
	private GameNumGen genMock; // @Mock 어노테이션으로 자동으로 모의 객체 생성
}
