/**
 * 
 */
package com.enuminfo.app.file.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.enuminfo.app.file.AppFile;

/**
 * @author Kumar
 */
public class CSVFileImpl extends AppFile {

	private FileWriter fileWriter = null;
	private BufferedReader fileReader = null;
	private String line = null;
	
	@Override
	public void writeIntoFile() {
		try {
			
			fileWriter =new FileWriter(readFileFromResources(),true);
			convertDTO2CSV(fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void readFromFile() {
		try {
			fileReader = new BufferedReader(new FileReader(readFileFromResources()));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				convertCSV2DTO(tokens);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
