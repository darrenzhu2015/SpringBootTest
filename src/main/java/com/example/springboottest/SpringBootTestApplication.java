package com.example.springboottest;

import com.example.springboottest.dto.HolidayDTO;
import com.example.springboottest.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);

        List<HolidayDTO> list = new ArrayList<>();
        //add 4 holidays for countryCode "US" and 4 holidays for countryCode "UK"
        list.add(new HolidayDTO("US", "United States", "2020-01-01", "New Year's Day"));
        list.add(new HolidayDTO("US", "United States", "2020-01-20", "Birthday of Martin Luther King, Jr."));
        list.add(new HolidayDTO("US", "United States", "2020-02-17", "Washington's Birthday"));
        list.add(new HolidayDTO("US", "United States", "2020-05-25", "Memorial Day"));

        //add more holidays for countryCode "UK"
        list.add(new HolidayDTO("UK", "United Kingdom", "2020-01-01", "New Year's Day"));
        list.add(new HolidayDTO("UK", "United Kingdom", "2020-04-10", "Good Friday"));
        list.add(new HolidayDTO("UK", "United Kingdom", "2020-04-13", "Easter Monday"));
        list.add(new HolidayDTO("UK", "United Kingdom", "2020-05-08", "Early May bank holiday"));

        FileUtil.writeToFile(list);
        log.info("8 initial holidays added to file demo.csv");
        log.info("All holidays in latest:");
        List<HolidayDTO> allHolidays = FileUtil.readFromFile();
        for(HolidayDTO holidayDTO : allHolidays) {
            log.info(holidayDTO.toString());
        }
    }

    private void generateTestDataInJson(){
        String HolidayJson = "{\"countryCode\":\"US\",\"countryDesc\":\"United States\",\"holidayDate\":\"2020-01-01\",\"holidayName\":\"New Year's Day\"}";
    }

}
