package com.test.textlibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This class is a domain Model for Wordfrequency
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordFrequency {

	String text;
	int frequency;
}
