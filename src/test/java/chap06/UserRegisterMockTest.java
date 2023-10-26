package chap06;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class UserRegisterMockTest {
	private UserRegister userRegister;
	private WeakPasswordChecker mockPasswordChecker = mock(WeakPasswordChecker.class);
	private MemoryUserRepository fakeRepository = new MemoryUserRepository();
	private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);

	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
	}

	@DisplayName("약한 암호면 가입 실패")
	@Test
	void weakPassword() {
		given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

		assertThrows(WeakPasswordException.class, () -> userRegister.register("id", "pw", "email"));
	}

	@DisplayName("회원 가입시 암호 검사 수행함")
	@Test
	void checkPassword() {
		userRegister.register("id", "pw", "email");
		// 특정 메서드가 호출됐는지 검증하는데, 임의의 String 타입 인자를 이용하여 확인
		then(mockPasswordChecker).should().checkPasswordWeak(anyString());
	}

	@DisplayName("가입하면 메일을 전송함")
	@Test
	void whenRegisterThenSendMail() {
		userRegister.register("id", "pw", "email@email.com");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		then(mockEmailNotifier)
			.should().sendRegisterEmail(captor.capture());

		String realEmail = captor.getValue();
		assertEquals("email@email.com", realEmail);
	}
}
