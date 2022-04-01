package com.test.textlibrary.service.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.test.textlibrary.domain.WordFrequency;
import com.test.textlibrary.exception.TextProcessorException;
import com.test.textlibrary.service.TextProcessingService;

/**
 * This class is an implementation of TextProcessing Service
 *
 */
@Service
public class TextProcessingServiceImpl implements TextProcessingService {

	/**
	 * This is the Method returns Highest Frequency of word in the given text
	 * 
	 * @param text
	 * @return - Highest Frequency Number
	 */
	@Override
	public int calculateHighestFrequency(String text) {
		if (StringUtils.isBlank(text)) {
			throw new TextProcessorException("Input Text can not be null or empty");
		}
		return Arrays.stream(text.split("[\\W]"))
				.collect(Collectors.groupingBy(w -> w.toLowerCase(), HashMap::new, Collectors.counting())).values() // To get each word Count
				.stream().max(Comparator.naturalOrder()).orElse(Long.valueOf(0)).intValue(); // Find the highest value
	}

	/**
	 * This Method returns Frequency of specified word in the given text
	 * 
	 * @param text and word
	 * @return - Frequency of word
	 */
	@Override
	public int calculateWordFrequency(String text, String word) {
		if (StringUtils.isBlank(text) || StringUtils.isBlank(word)) {
			throw new TextProcessorException("Input Text can not be null or empty");
		}
		return Arrays.stream(text.split("[\\W]")) // Split on Nonword Characters
				.collect(Collectors.groupingBy(w -> w.toLowerCase(), HashMap::new, Collectors.counting()))
				.getOrDefault(word, (long) 0).intValue();
	}

	/**
	 * This Method returns Most Frequent N words in the given Text
	 * 
	 * @param text and N
	 * @return - List of Words with the Frequency
	 */

	@Override
	public List<WordFrequency> mostFrequentNWord(String text, int N) {
		if (StringUtils.isBlank(text)) {
			throw new TextProcessorException("Input Text can not be null or empty");
		}

		return Arrays.stream(text.split("[\\W]")).filter(word -> !StringUtils.isBlank(word)) // Filter Spaces in a text
				.collect(Collectors.groupingBy(w -> w.toLowerCase(), HashMap::new, Collectors.counting())).entrySet()
				.stream().map(entry -> new WordFrequency(entry.getKey(), entry.getValue().intValue()))
				.sorted(Comparator.comparing(WordFrequency::getFrequency)// Sort on the basis of Frequency Natural sorting																			
						.reversed().thenComparing(WordFrequency::getText)) // Sort the Text
				.limit(N).collect(Collectors.toList());
	}

}
