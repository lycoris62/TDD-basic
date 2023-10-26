package appendix.c;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	@DisplayName("모의 객체가 불렸는지를 검증")
	@Test
	void init() {
		GameNumGen genMock = mock(GameNumGen.class);
		Game game = new Game(genMock);
		game.init(GameLevel.EASY);

		then(genMock).should().generate(GameLevel.EASY);
		// 호출 여부를 검증할 모의 객체를 전달받고,
		// should() 메서드로 메서드가 불려야 한다는 것을 설정하고,
		// 다음으로 실제로 불려야 할 메서드를 지정한다.
		// 정확한 값이 아니라 메서드가 불렸는지 여부가 중요하다면 generate(any()) 를 쓰면 된다.
		// 정확히 한 번만 호출된 것을 검증하고 싶다면 should(only()) 를 쓰면 된다.
	}
}
