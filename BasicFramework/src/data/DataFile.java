package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
	public String incorrectEmail = d.getCellData("Data1","UserName" , 3);
	public String incorrectpassword = d.getCellData("Data1","Password", 2);
	public String invalidemail = d.getCellData("Data1","UserName", 4);
	public String globalerr = d.getCellData("Data1","GlobalError", 2);
	public String emailspecialcharerr = d.getCellData("Data1","Email Error" , 2);
	public String emptyemailerr = d.getCellData("Data1","Email Error", 3);
	public String emptypassworderr = d.getCellData("Data1","Password Error" , 2);
}
