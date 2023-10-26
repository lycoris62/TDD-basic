package appendix.c;

import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VoidMethodStubTest {

	@Test
	void voidMethodWillThrowTest() {
		List<String> mockList = mock(List.class);
		willThrow(UnsupportedOperationException.class)
			.given(mockList) // 모의 객체의 메서드 실행이 아닌 모의 객체 자체. 인자 그대로 리턴함.
			.clear();

		Assertions.assertThrows(UnsupportedOperationException.class, () -> mockList.clear());
	}
}
