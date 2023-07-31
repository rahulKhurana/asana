package reporting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.SuiteVariables;

public class HTMLReporting extends SuiteVariables {

	FileWriter fstream = null;
	BufferedWriter out = null;

	public void createTableHeader(String alignment,String tableName) throws IOException{

		out.write("<table  align="+alignment+" border=1 cellspacing=1 cellpadding=1 table-layout=fixed width=20%>");
		out.write("<tr>");
		out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+tableName+"</b></td>");
		out.write("</tr>");
		out.write("</table>");

	}

	public void addTableDataValues(String alignment,String...  columnNames) throws IOException{

		out.write("<tr>");
		for(int i=0;i<columnNames.length;i++){
				out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+columnNames[i]+"</b></td>\n");
		}
		out.write("</tr> ");
		out.write("</table> ");
	}


	public void addTableData(String alignment,String...  columnNames) throws IOException{
		out.write("<table  border=1 cellspacing=1 cellpadding=1 table-layout=fixed width=100%>");

		out.write("<tr> ");
		for(int i=0;i<columnNames.length;i++){
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+columnNames[i]+"</b></td>\n");
		}
		out.write("</tr> ");

	}

	public void createIndexFile(String filename) throws IOException {

		createHtmlBody(filename);

		createTableHeader("center","AUTOMATION TEST EXECUTION RESULTS");

		createTableHeader("left","SUITE DETAILS");

		addTableData("","Run Start Time","Run End Time","Duration","Environment","Suite","Browser","Total","Pass","Fail");
		addTableDataValues("","a","b","c","d","e","f","g","h","i");
		out.write("<br><br>");

		createTableHeader("left","MODULE DETAILS");
		addTableData("","MODULE NAME","Total","Pass","Fail","Start Time","End Time","Duration");
		//		addTableDataValues("","a","b","c","d","e","f","g","h","i");
		out.write("<br><br>");
		out.close();
	} 




	public void createHtmlBody(String filename){


		try {
			fstream = new FileWriter(filename,true);
			out = new BufferedWriter(fstream);

			out.write("<html>");
			out.write("<head>");
			out.write("<title>");
			out.write("</title>");
			out.write("</head>");
			out.write("<body>");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void createBaseReport(String filename){

		try{
			createHtmlBody(filename);

			out.write("<table  border=1 cellspacing=1 cellpadding=1 table-layout=fixed width=100%>");

			out.write("<tr> ");

			//			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"TS_ID"+"</b></td>\n");
			//			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"Test_Steps"+"</b></td>\n");
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"Keyword"+"</b></td>\n");
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"ORProperty"+"</b></td>\n");
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"LocatorValue"+"</b></td>\n");
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"TestData"+"</b></td>\n");
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"FailInfo"+"</b></td>\n");
			out.write("<td align=center width=100px  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>"+"Screenshot"+"</b></td>\n");

			out.write("</tr>");
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {

			fstream = null;
			out = null;
		}
	}

	public void finishReport(String filename){


		try {

			out.write("</table>\n");
			out.write("</body>\n");
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {

			fstream = null;
			out = null;
		}
	}

	public void linkToIndex(String filenameToLink) throws IOException{

		fstream = new FileWriter(indexHtml,true);
		out = new BufferedWriter(fstream);
		
		out.write("<table  border=1 cellspacing=1 cellpadding=1 table-layout=fixed width=100%>");
//		addTableDataValues("",filenameToLink.substring(filenameToLink.lastIndexOf('/') + 1),"","","","","","");
		
		String name = filenameToLink.substring(filenameToLink.lastIndexOf('\\') + 1);
		
		out.write("<tr>");
		for(int i=0;i<7;i++){
			if(i==0){
				out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b><a href='"+filenameToLink+"' TARGET=\"_blank\">"+name+"</b></td>\n");
			}else
				out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+"null"+"</b></td>\n");
		}
		
		out.write("</tr> ");
		out.write("</table> ");
		
		
		out.close();
		fstream = null;
		out = null;
	}

	//	public void startTesting(File filename, String testStartTime,ArrayList<String> arrayList) {
	public void startTesting(String filename,HashMap<String, String> myMap) {
		//		indexResultFilename = filename;

		FileWriter fstream = null;
		BufferedWriter out = null;

		try {

			fstream = new FileWriter(filename,true);
			out = new BufferedWriter(fstream);

			out.write("<tr> ");

			String keywordRunStatus = myMap.get("keywordRunStatus");
			String keyword = myMap.get("keywordName");
			String pName = myMap.get("ORPropertyName");
			String locator = myMap.get("ORPropertyValue");
			String tData = myMap.get("TestData");
			String scr = myMap.get("Screenshot");
			String st = myMap.get("StackTrace");

			if(keywordRunStatus.equalsIgnoreCase("Pass"))
				out.write("<td align=center width=100px  align=center bgcolor=#BCE954><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+keyword+"</b></td>\n");
			else
				out.write("<td align=center width=100px  align=center bgcolor=Red><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+keyword+"</b></td>\n");	

			out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+pName+"</b></td>\n");
			out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+locator+"</b></td>\n");
			out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+tData+"</b></td>\n");
			out.write("<td align=center width=100px  align=center><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+st+"</b></td>\n");

			if(keywordRunStatus.equalsIgnoreCase("Pass"))
				out.write("<td align=center width=100px  align=center ><FONT COLOR=#000000 FACE=Arial SIZE=2><b>"+""+"</b></td>\n");
			else
				out.write("<td align=center width=100px  align=center ><FONT COLOR=#000000 FACE=Arial SIZE=2><b><a href=\""+ scr + "\" target=_blank>Screen Shot</a></b></td>\n");

			out.write("</tr>");

			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {

			fstream = null;
			out = null;
		}
	}
}
