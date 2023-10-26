package appendix.c;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import chap06.EmailNotifier;
import chap06.MemoryUserRepository;
import chap06.StubWeakPasswordChecker;
import chap06.UserRegister;

public class UserRegisterMockTest {
	private UserRegister userRegister;
	private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);

	private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
	private MemoryUserRepository fakeRepository = new MemoryUserRepository();

	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository, mockEmailNotifier);

	}

	@DisplayName("가입하면 메일을 전송함")
	@Test
	void whenRegisterThenSendMail() {
		userRegister.register("id", "pw", "email@email.com");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		then(mockEmailNotifier)
			.should().sendRegisterEmail(captor.capture());

		String realEmail = captor.getValue();
		Assertions.assertEquals("email@email.com", realEmail);
	}
}
