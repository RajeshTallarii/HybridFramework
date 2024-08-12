package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	//below name should be different from data one dataprovider to another
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\excelTest.xlsx";//taking xl file from testData
		//invoking excelutility to invoke methods
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		//capturing rows and columns in excel sheet
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
		//creating 2 dimensional array		
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		//the below for loop will read all the data from the excel sheet rows and col and put that in 2 dimensional array
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
		//this is the data provider method which will get data from excel sheet and store into the 2 dimensional array and
		//and finally it is returning 2 dimensional array
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
