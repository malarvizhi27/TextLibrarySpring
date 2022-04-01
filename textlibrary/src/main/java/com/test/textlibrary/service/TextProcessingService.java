package com.test.textlibrary.service;

import java.util.List;

import com.test.textlibrary.domain.WordFrequency;

/**
 * 
 * This Interface contains method for Text processingService
 *
 */

public interface TextProcessingService {

	public int calculateHighestFrequency(String text);

	public int calculateWordFrequency(String text, String word);

	public List<WordFrequency> mostFrequentNWord(String text, int N);

}
