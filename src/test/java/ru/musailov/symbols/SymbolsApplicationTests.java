package ru.musailov.symbols;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.musailov.symbols.models.Answer;
import ru.musailov.symbols.models.Request;
import ru.musailov.symbols.service.SymbolsService;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class SymbolsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testEmptyString() {
		SymbolsService symbolsService = new SymbolsService();
		Request request = new Request("");
		Answer answer = symbolsService.getAnswer(request);
		assertEquals(null, "", answer.getAnswer());
	}

	@Test
	public void testSingleCharacter() {
		SymbolsService symbolsService = new SymbolsService();
		Request request = new Request("a");
		Answer answer = symbolsService.getAnswer(request);
		assertEquals(null,"'a': 1", answer.getAnswer());
	}

	@Test
	public void testMultipleCharacters() {
		SymbolsService symbolsService = new SymbolsService();
		Request request = new Request("abccba");
		Answer answer = symbolsService.getAnswer(request);
		assertEquals(null,"'a': 2, 'b': 2, 'c': 2", answer.getAnswer());
	}

	@Test
	public void testSpecialCharacters() {
		SymbolsService symbolsService = new SymbolsService();
		Request request = new Request("!@#$%^@");
		Answer answer = symbolsService.getAnswer(request);
		assertEquals(null,"'@': 2, '!': 1, '#': 1, '$': 1, '%': 1, '^': 1", answer.getAnswer());
	}

}
