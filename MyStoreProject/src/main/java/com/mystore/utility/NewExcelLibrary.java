package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class NewExcelLibrary {

    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx";

    public Object[][] readTestData(String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(FILE_PATH));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1); // Start from row 1 (assuming row 0 is header)
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i][j] = cell.toString();
                }
            }
            workbook.close();
            fis.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
