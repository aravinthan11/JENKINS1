package com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	
	public static void generateJVM(String jsonFile) {
		File loc = new File(System.getProperty("user.dir") + "\\scott\\AdactinOrderId\\Reportss");
		Configuration con = new Configuration(loc, "Adactin Automation");
		con.addClassifications("OS", "windows 8.1 pro");
		con.addClassifications("Browser Name", "Chrome");
		con.addClassifications("Version", "80");
		con.addClassifications("Sprint", "23");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder r = new ReportBuilder(jsonFiles, con);
		r.generateReports();
	}

}
