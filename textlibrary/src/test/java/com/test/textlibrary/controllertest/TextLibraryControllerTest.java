package com.test.textlibrary.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.textlibrary.controller.TextLibraryController;
import com.test.textlibrary.domain.WordFrequency;
import com.test.textlibrary.service.TextProcessingService;

@SpringBootTest
public class TextLibraryControllerTest {
	
	@Mock
	TextProcessingService textProcessingService;
	@InjectMocks
	TextLibraryController textLibraryController;
	
	@Test
	public void whengetHighestFrequencyWordCalled_thenReturnResponse () {
		
		String text = "Java java ";
		when(textProcessingService.calculateHighestFrequency(text)).thenReturn(2);
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(2), textLibraryController.getHighestFrequencyWord(text));
	}
	@Test
	public void whenCalculateWordFrequencyCalled_thenReturnResponse() {
		
		String text = "Hello Java Program";
		String word = "Java";
		when(textProcessingService.calculateWordFrequency(text, word)).thenReturn(1);
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(1), textLibraryController.calculatewordFrequency(text, word));

	}
	
	
	
	
	
	
	public void whenMostFrequentNwordCalled_thenReturnResponse() {
		
		List<WordFrequency> wordFrequencyList = new ArrayList<WordFrequency>();
		String text = "Java Java Program";
		
		wordFrequencyList.add(new WordFrequency("Java Java Program", 2));
		wordFrequencyList.add(new WordFrequency("Java World world world", 3));		
		when(textProcessingService.mostFrequentNWord(text,2)).thenReturn(wordFrequencyList);
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(wordFrequencyList), textLibraryController.mostFrequentNword(text, 2));

	}
	
	
	
	
	
	
	
	
	private static Stream<Arguments> provideStringForMostFrequentNWord() {
		return Stream.of(Arguments.of("I love Java java programming", 2), Arguments.of("I love Java  programming", 1),
				Arguments.of("I love Java java Love java Programming", 3), Arguments.of("welcome to Java world", 1));
	}


}
