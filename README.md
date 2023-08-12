# asana-pom
Page Object Model based test automation framework with Java and TestNG


===================

package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MatrixCreator {

	public static void main(String[] args) throws IOException {
		geekforgeeks();
	}

	public static void geekforgeeks() throws IOException{
        
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("sheet1");
           
           // Creating HashMap and entering data
           LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();
           map.put("Qtest TC id","Product;Type;Sub-type;Count");
           map.put("TC-122", "ASM;Generate;;1");
           map.put("TC-178", "ASM;Reject;;1");
           map.put("TC-877", "TFS;buy;existing;1");
           map.put("TC-9900", "TFS;Sell;new;1");
             
           int rowno = 0;
             
           for(HashMap.Entry<String,String> entry:map.entrySet()) {
               XSSFRow row=sheet.createRow(rowno++);
               row.createCell(0).setCellValue((String)entry.getKey());
               String arr[] = ((String)entry.getValue()).split(";");
               for(int i = 0 ;i < arr.length;i++) {
            	   row.createCell(i+1).setCellValue(arr[i]);
               }
               
           }
      
           FileOutputStream file = new FileOutputStream("Hash.xlsx");
           workbook.write(file);
           file.close();
           System.out.println("Data Copied to Excel");
        
   }
}


===============================================================
<HTML>
<HEAD>
 <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">

    <link rel="stylesheet" type="text/css" href="../dependencies/js/kendo.common.min.css">
    <link rel="stylesheet" type="text/css" href="../dependencies/js/kendo.default.min.css">
    <script type="text/javascript" src="../dependencies/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../dependencies/js/kendo.all.min.js"></script>
    <script type="text/javascript" src="../dependencies/js/createChart.js"></script>
    <script type="text/javascript" src="../dependencies/js/downloadToExcel.js"></script>
    
<TITLE FONT COLOR=#E0E0E0>AUTOMATION TEST EXECUTION RESULTS</TITLE>
<style>#table1{	width : 320px;	float : left;}#table2{	width : 320px;	float : left;	margin-left : 100px;}
tr.myStyle1 td{	color : #E0E0E0;font-family : Arial;font-size : 13px;width : 150px;text-align : center;background-color : #153E7E;}
tr.myStyle2 td{	color : black;font-family : Arial;font-size : 13px;width : 150px;text-align : center;background-color : white;}
td.myStyle2 {	color : #E0E0E0;font-family : Arial;font-size : 13px;width : 150px;text-align : center;background-color : #153E7E;}
</style>
</HEAD>
<BODY bgcolor=white id="body">
	<div id="example" class="k-content">
            <div class="chart-wrapper">
                <div id="chart"></div>
            </div>
    </div>
    
<!-- <h2 align=center><FONT COLOR=black FACE=AriaL SIZE=3><b>AUTOMATION TEST EXECUTION RESULTS</b></h2> -->
<table  align=center border=1 cellspacing=1    cellpadding=1 width=20%>
<tr class="myStyle1">
<td><b>AUTOMATION TEST EXECUTION RESULTS</b></td>
</tr>
</table>
<br><br>
<table  border=1 cellspacing=1    cellpadding=1 width=12.5%>
<tr class="myStyle1">
<td><b>SUITE   DETAILS</b></td>
</tr>
</table>

<table  id ="myTable" border=1 cellspacing=1 cellpadding=1 width=100%>
<!--<caption style="text-align:left"><FONT COLOR=maroon FACE=AriaL SIZE=2><b>SUITE DETAILS</b></caption>-->
<tr class="myStyle1">
<td><b>Run Start Time</b></td>
<td><b>Run End Time</b></td>
<td><b>Duration</b></td>
<td><b>Environment</b></td>
<td><b>Suite</b></td>
<td><b>Browser</b></td>
<td><b>Total</b></td>
<td><b>Pass</b></td>
<td><b>Fail</b></td>
</tr>

<tr class="myStyle2">
<td><b> 13.February.2015 07.31.49 PM </b></td>
<td><b> 13.February.2015 07.32.35 PM </b></td>
<td><b> 45 Secs  </b></td>
<td><b><a href='http://ggsaimsqapub01.sapient.com:4503' TARGET="_blank"> QA_Pub01 </a></b></td>
<td><b>Regression Test</b></td>
<td><b>Chrome</b></td>



<td><b> 2 </b></td>
<td><b> 0 <b></td>
<td><b> 2 </b></td>
</tr>
</table>


<input type="button" onclick="getCount()" value="View Pie Chart" style="float: right;>

<p align="right">
<a id="dlink"  style="display:none;"></a>
<input type="button" onclick="tableToExcel('body', 'Automation Run Report','Automation_Run_Report.xls')" value="Export to Excel">
</p>

<table  border=1 cellspacing=1    cellpadding=1 width=20%>
<tr class="myStyle1">
<td><b>MODULES   DETAILS</b></td>
</tr>
</table>


<table  border=1 cellspacing=1    cellpadding=1 width=100%>
<!--<caption style="text-align:left"><FONT COLOR=maroon FACE=AriaL SIZE=2><b>MODULES  DETAILS</b></caption>-->
<tr class="myStyle1">
<td><b>MODULE NAME</b></td>
<td><b>MANUAL COUNT</b></td>
<td><b>Total</b></td>
<td><b>Pass</b></td>
<td><b>Fail</b></td>
<td><b>Start Time</b></td>
<td><b>End Time</b></td>
<td><b>Duration</b></td>
</tr>

<tr>
<td width=15% align=center ><FONT COLOR=blue FACE= Arial  SIZE=2><b><a href='footer.html' TARGET="_blank"> footer </a></b></td>
<td width=5% align=center ><FONT COLOR=black FACE= Arial  SIZE=2><b>2</b></td>
<td width=10% align=center ><FONT COLOR=black FACE= Arial  SIZE=2><b>2 </b></td>
<td width=10% align=center > <FONT  COLOR=black > <b>0</b></FONT></td>
<td width=10% align=center > <FONT  COLOR=red >  <b>2</b></FONT></td>
<td width=20% align=center ><FONT COLOR=black FACE= Arial  SIZE=2><b>13.February.2015 07.32.09 PM</b></td>
<td width=20% align=center ><FONT COLOR=black FACE= Arial  SIZE=2><b>13.February.2015 07.32.35 PM</b></td>
<td width=10% align=center ><FONT COLOR=black FACE= Arial  SIZE=2><b>25 Secs  </b></td>
</tr>
</table>

</BODY>
</HTML>


------------------------------------------------------------------------------------------------------------------------


var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table)
    var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
    var currentdate = new Date();
var datetime = currentdate.getDate() + "/"+(currentdate.getMonth()+1) 
    + "/" + currentdate.getFullYear() + "/"+currentdate.getHours() + ":" 
    + currentdate.getMinutes() + ":" + currentdate.getSeconds();
    document.getElementById("dlink").href = uri + base64(format(template, ctx));
    document.getElementById("dlink").download = document.title+datetime+'.xls';
    document.getElementById("dlink").click();
  }
})()
