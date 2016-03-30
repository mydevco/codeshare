package com.mydevco.javabp.language;

import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;

public class LanguageTips {

	public LanguageTips() { };

	
	public static void main(String[] args){
		double x = 12.34655;
		double roundedFor4Decimal = Math.round(x * Math.pow(10,4))/Math.pow(10,4);
		System.out.println(roundedFor4Decimal); //prints 12.3466
		
		double downCastedDouble = 1 / 20.0;
		System.out.println(downCastedDouble);
		
		System.out.println("Unfriendly exponential number is " + (5.0/1000000));
		System.out.println("Friendly exponential number is " + new DecimalFormat("0.0").format(5.0/1000000));
		
		//format using excel formatter pattern, index is available in 
		DataFormatter df = new DataFormatter();
		String excelFormatString = "$#,##0_);($#,##0)";
		System.out.println(df.formatRawCellContents(-12345.8956734, HSSFDataFormat.getBuiltinFormat(excelFormatString), excelFormatString));
		
		System.out.println(Double.NaN + 1000.23); //NaN
		
	}

}
