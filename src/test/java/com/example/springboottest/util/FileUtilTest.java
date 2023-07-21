package com.example.springboottest.util;

import com.example.springboottest.dto.HolidayDTO;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void writeToFile() {
        List<HolidayDTO> list = new ArrayList<>();
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
    }

    @Test
    public void readFromFile() {
        List<HolidayDTO> list = FileUtil.readFromFile();
        assertEquals(8, list.size());
        assertEquals("US", list.get(0).getCountryCode());
    }
}