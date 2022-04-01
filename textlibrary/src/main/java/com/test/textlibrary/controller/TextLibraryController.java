package com.test.textlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.textlibrary.domain.WordFrequency;
import com.test.textlibrary.service.TextProcessingService;

/**
 * Word Processing Analyzer
 * This Class provides REST End point to handle web requests
 *
 */

@RestController
@RequestMapping("/wordprocessor/wordfrequency/rest/v1")
public class TextLibraryController {

	@Autowired
	TextProcessingService textProcessingService;
	/**
	 * Rest End Point to get High Frequency of a word in a given text
	 * @param text
	 * @return ResponseEntity
	 */
	@GetMapping("/getHighestFrequency")
	public ResponseEntity<Integer> getHighestFrequencyWord(@RequestParam String text) {
		return ResponseEntity.ok(textProcessingService.calculateHighestFrequency(text));
	}
	
	/**
	 * Rest End Point to calculate Frequency of a word in a given text
	 * @param text
	 * @return ResponseEntity
	 */
	@GetMapping("/getWordFrequency") 
	public ResponseEntity<Integer> calculatewordFrequency(@RequestParam String text, @RequestParam String word) {
		return ResponseEntity.ok(textProcessingService.calculateWordFrequency(text, word));
	}
	
	/**
	 * Rest End Point to get Most Frequent N Words in a given Text
	 * @param text
	 * @return ResponseEntity
	 */
	@GetMapping("/getFrequentNWord")  
	public ResponseEntity<List<WordFrequency>> mostFrequentNword(@RequestParam String text,@RequestParam int N) {
		return ResponseEntity.ok(textProcessingService.mostFrequentNWord(text, N));
	}
}
