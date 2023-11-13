package com.example;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class MorseCodeConverterTest_STUDENT {
	File inputFile;

	@BeforeEach
	void setUp() throws Exception {}

	@AfterEach
	void tearDown() throws Exception {}

	@Test
	void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish("..-. .. .-.. .. .--. .. -. --- / ..-. --- --- -.. / .. ... / -.. . .-.. .. -.-. .. --- ..- ...");
		assertEquals("filipino food is delicious", converter1);
			
		String converter2 = MorseCodeConverter.convertToEnglish("-- -.-- / -.. --- --. .----. ... / -. .- -- . / .. ... / -.. --- .-.. .-.. .. .");
		assertEquals("my dog's name is dollie", converter2);
	}

	@Test
	void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="i like action movies";		
		getFile("MorseCodeTest.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converter1);
	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if (status == JFileChooser.APPROVE_OPTION) {
			try {
				inputFile = chooser.getSelectedFile();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

}
