package com.mylike.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class poiUtils {
    public static void createExcel(List dataLists,String[] titles,OutputStream out){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFCellStyle titleCellStyle = workbook.createCellStyle();

        //设置单元标题样式
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleCellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.SKY_BLUE.getIndex());
        titleCellStyle.setWrapText(true);
        //设置单元标题字体
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short)13);
        titleCellStyle.setFont(titleFont);

        //填写标题
        HSSFRow headRow = sheet.createRow(0);
        HSSFCell headerCell = null;
        for(int i=0;i<titles.length;i++) {
            headerCell = headRow.createCell(i);
            headerCell.setCellStyle(titleCellStyle);
            headerCell.setCellValue(titles[i]);
            sheet.setColumnWidth(i, (30*160));
        }

        //设置表格内容单元样式
        HSSFCellStyle valueCellStyle = workbook.createCellStyle();
        valueCellStyle.setAlignment(HorizontalAlignment.CENTER);
        valueCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFDataFormat format= workbook.createDataFormat();
        valueCellStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));

        HSSFFont cellFont = workbook.createFont();
        cellFont.setFontHeightInPoints((short)12);
        valueCellStyle.setFont(cellFont);

        for(int i=0;i<dataLists.size();i++) {
            HSSFRow row = sheet.createRow(i+1);
            Class clazz = dataLists.get(i).getClass();
            Field fields[] = clazz.getDeclaredFields();
            for(int j=0;j<fields.length;j++) {
                String fieldName = fields[j].getName();
                fieldName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                //执行get方法，获取属性
                Method gMethod;
                try {
                    gMethod = clazz.getMethod("get"+fieldName);
                    String value = gMethod.invoke(dataLists.get(i)).toString();
                    if(value==null) {
                        value = "";
                    }
                    HSSFCell valueCell = row.createCell(j);
                    valueCell.setCellStyle(valueCellStyle);
                    valueCell.setCellValue(value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();

                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }


        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //导出成功!

    }
}
