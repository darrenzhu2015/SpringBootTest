package com.example.springboottest.util;

import com.example.springboottest.dto.HolidayDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class FileUtil {
    public static void writeToFile(List<HolidayDTO> list) {
        //sort the list by holidayDate
        list.sort((o1, o2) -> DateUtil.parseDate(o1.getHolidayDate()).compareTo(DateUtil.parseDate(o2.getHolidayDate())));

        try {
            String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String fileName = classpath+"holidays.csv";
            File f = new File(fileName);
            if(f.exists()) {
                f.delete();
            }
            f.getParentFile().mkdirs();
            f.createNewFile();

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8"));
            StatefulBeanToCsv<HolidayDTO> statefulBeanToCsv = new StatefulBeanToCsvBuilder<HolidayDTO>(writer)
                    .withApplyQuotesToAll(false)
                    .build();
            statefulBeanToCsv.write(list);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<HolidayDTO> readFromFile()  {
        List<HolidayDTO> list = null;
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String fileName = classpath+"holidays.csv";
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8"));
            // 不需要标题行，列的顺序通过CsvBindByPosition注解的position属性指定
            CsvToBean<HolidayDTO> csvToBean = new CsvToBeanBuilder<HolidayDTO>(reader)
                    .withType(HolidayDTO.class)
                    .build();
            list = csvToBean.parse();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
