package com.module.orangeHrm.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomData {
	private final static String NAME_LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHANUM_LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final static String Number_LEXICON = "123456789";
	private final static Random rand = new Random();

	public static String getRandomName() {
		StringBuilder builder = new StringBuilder();
		int length = rand.nextInt(5) + 5;
		for (int i = 0; i < length; i++)
			builder.append(NAME_LEXICON.charAt(rand.nextInt(NAME_LEXICON.length())));
		return builder.toString();
	}

	public static String getRandomNumber() {
		StringBuilder builder = new StringBuilder();
		int length = rand.nextInt(5) + 8;
		for (int i = 0; i < length; i++) {
			builder.append(Number_LEXICON.charAt(rand.nextInt(Number_LEXICON.length())));
		}
		return builder.toString();
	}

	public static long getRandomNumberBetween(long low, long high) {
		if (low == high) {
			return low;
		}
		long result = low + (rand.nextLong() % (high - low));
		return result;
	}

	public static String getRandomAlphaNumericString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 8; i++)
			builder.append(ALPHANUM_LEXICON.charAt(rand.nextInt(ALPHANUM_LEXICON.length())));
		return builder.toString();
	}

	public static int getRandomNumberBetween(int low, int high) {
		if (low == high) {
			return low;
		}
		int result = rand.nextInt(high - low) + low;
		return result;
	}
}
