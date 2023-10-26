package appendix.c;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;

public class GameGenMockTest {

	@Test
	void mockTest() {
		GameNumGen genMock = mock(GameNumGen.class);
		given(genMock.generate(GameLevel.EASY)).willReturn("123");

		String num = genMock.generate(GameLevel.EASY);
		assertEquals("123", num);
	}

	@Test
	void mockThrowTest() {
		GameNumGen genMock = mock(GameNumGen.class);
		given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

		assertThrows(IllegalArgumentException.class, () -> genMock.generate(null));
	}

	@Test
	void mockIllegalTest() {
		GameNumGen genMock = mock(GameNumGen.class);
		given(genMock.generate(GameLevel.EASY)).willReturn("123");

		String num = genMock.generate(GameLevel.NORMAL);
		assertNull(num);
	}
}
