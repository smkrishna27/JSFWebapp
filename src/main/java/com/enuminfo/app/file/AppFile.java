/**
 * 
 */
package com.enuminfo.app.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.app.dto.RecepientDTO;
import com.enuminfo.app.file.impl.CSVFileImpl;

/**
 * @author Kumar
 */
public abstract class AppFile {

	protected static final String COMMA_DELIMITER = ",";
	protected static final String NEW_LINE_SEPARATOR = "\n";
	protected static final String FILE_HEADER = "recepientId,recepientName,bankInfo,transitInfo,address1,address2,city,zipcode";
	protected static final String CSV_FILE = "recepients.csv";
	public List<RecepientDTO> dtoRecepients = new ArrayList<RecepientDTO>();
	
	private static final int RECEPIENT_ID_IDX = 0;
    private static final int RECEPIENT_NAME_IDX = 1;
    private static final int BANK_INFO_IDX = 2;
    private static final int TRANSIT_INFO_IDX = 3;
	
	protected AppFile() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void writeIntoFile();
	public abstract void readFromFile();
	
	protected void convertDTO2CSV(FileWriter fileWriter) {
		for (Iterator<RecepientDTO> iterator = dtoRecepients.iterator(); iterator.hasNext();) {
			RecepientDTO dtoRecepient = iterator.next();
			try {				
				fileWriter.append(String.valueOf(dtoRecepient.getRecepientId()));				
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getRecepientName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getBankInfo());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getTransitInfo());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getAddress1());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getaddress2());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getCity());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(dtoRecepient.getZipCode());
				fileWriter.append(NEW_LINE_SEPARATOR);				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void convertCSV2DTO(String[] tokens) {
		if (tokens.length > 0) {
			RecepientDTO dtoRecepient = new RecepientDTO();
			dtoRecepient.setRecepientId(Integer.parseInt(tokens[RECEPIENT_ID_IDX]));			
			dtoRecepient.setRecepientName(tokens[RECEPIENT_NAME_IDX]);
			dtoRecepient.setBankInfo(tokens[BANK_INFO_IDX]);
			dtoRecepient.setTransitInfo(tokens[TRANSIT_INFO_IDX]);
			dtoRecepients.add(dtoRecepient);
		}
	}
	
	protected File readFileFromResources() {
		ClassLoader classLoader = new CSVFileImpl().getClass().getClassLoader();
		return new File(classLoader.getResource(CSV_FILE).getFile());
		
		
	}
}
