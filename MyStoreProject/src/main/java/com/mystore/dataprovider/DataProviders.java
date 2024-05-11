package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {

    private static final NewExcelLibrary EXCEL_READER = new NewExcelLibrary();
    private static final String DATA_SHEET_NAME = "Credentials"; // Assuming sheet name

    @DataProvider(name = "Credentials")
    public static Object[][] getcredentials() {
        return EXCEL_READER.readTestData(DATA_SHEET_NAME);
    }

    // Add more data providers for other test cases as needed
    @DataProvider(name = "Email")
    public static Object[][] getEmailData() {
        return EXCEL_READER.readTestData("Email");
    }

}
