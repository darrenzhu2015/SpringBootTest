package com.example.springboottest.service.impl;

import com.example.springboottest.dto.HolidayDTO;
import com.example.springboottest.service.HolidayService;
import com.example.springboottest.util.DateUtil;
import com.example.springboottest.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class HolidayServiceImpl implements HolidayService {
    @Override
    public HolidayDTO addOne(HolidayDTO holidayDTO) {
        log.info("Adding holiday: " + holidayDTO.toString());
        List<HolidayDTO> allHolidays = readAllHolidays();
        if(allHolidays.contains(holidayDTO)) {
            throw new RuntimeException("Holiday already exists");
        }
        allHolidays.add(holidayDTO);
        FileUtil.writeToFile(allHolidays);
        printAllHolidays();
        return holidayDTO;
    }

    @Override
    public int addMultiple(List<HolidayDTO> holidayDTOList) {
        log.info("Adding holidays: " + holidayDTOList.toString());
        List<HolidayDTO> allHolidays = readAllHolidays();
        if(holidayDTOList.containsAll(allHolidays)) {
            throw new RuntimeException("Holiday already exists");
        }
        allHolidays.addAll(holidayDTOList);
        FileUtil.writeToFile(allHolidays);
        printAllHolidays();
        return holidayDTOList.size();
    }

    @Override
    public HolidayDTO updateOne(HolidayDTO holidayDTO) {
        log.info("Updating holiday: " + holidayDTO.toString());
        List<HolidayDTO> allHolidays = readAllHolidays();
        if(allHolidays.contains(holidayDTO)) {
            allHolidays.remove(holidayDTO);
            allHolidays.add(holidayDTO);
            FileUtil.writeToFile(allHolidays);
            printAllHolidays();
            return holidayDTO;
        }
        return null;
    }

    @Override
    public int updateMultiple(List<HolidayDTO> holidayDTOList) {
        log.info("Updating holidays: " + holidayDTOList.toString());
        List<HolidayDTO> allHolidays = readAllHolidays();
        allHolidays.removeAll(holidayDTOList);
        allHolidays.addAll(holidayDTOList);
        FileUtil.writeToFile(allHolidays);
        printAllHolidays();
        return holidayDTOList.size();
    }

    @Override
    public HolidayDTO deleteOne(HolidayDTO holidayDTO) {
        log.info("Deleting holiday: " + holidayDTO.toString());
        List<HolidayDTO> allHolidays = readAllHolidays();
        allHolidays.remove(holidayDTO);
        FileUtil.writeToFile(allHolidays);
        printAllHolidays();
        return holidayDTO;
    }

    @Override
    public int deleteMultiple(List<HolidayDTO> holidayDTOList) {
        log.info("Deleting holidays: " + holidayDTOList.toString());
        List<HolidayDTO> allHolidays = readAllHolidays();
        allHolidays.removeAll(holidayDTOList);
        FileUtil.writeToFile(allHolidays);
        printAllHolidays();
        return allHolidays.size();
    }

    @Override
    public List<HolidayDTO> findAllNextYearHolidays(String countryCode) {
        log.info("Finding all next year holidays for countryCode: " + countryCode);
        List<HolidayDTO> nextYearHolidays = new ArrayList<>();
        List<HolidayDTO> allHolidays = readAllHolidays();
        Date today = new Date();
        String thisYear = DateUtil.parseDate(today.toString()).toString().substring(0, 4);
        Date nextYear = DateUtil.parseDate(String.valueOf(Integer.parseInt(thisYear) + 1));
        Date nextNextYear = DateUtil.parseDate(String.valueOf(Integer.parseInt(thisYear) + 2));
        for(HolidayDTO holidayDTO : allHolidays) {
            if(holidayDTO.getCountryCode().equals(countryCode) && DateUtil.parseDate(holidayDTO.getHolidayDate()).after(nextYear)) {
                if(DateUtil.parseDate(holidayDTO.getHolidayDate()).before(nextNextYear)) {
                    nextYearHolidays.add(holidayDTO);
                }
            }
        }
        return nextYearHolidays;
    }

    @Override
    public HolidayDTO findNextHolidayAfterToday(String countryCode) {
        log.info("Finding next holiday after today for countryCode: " + countryCode);
        List<HolidayDTO> allHolidays = readAllHolidays();
        Date today = new Date();
        for(HolidayDTO holidayDTO : allHolidays) {
            if(holidayDTO.getCountryCode().equals(countryCode) && DateUtil.parseDate(holidayDTO.getHolidayDate()).after(today)) {
                return holidayDTO;
            }
        }
        return null;
    }

    @Override
    public HolidayDTO validate(String holidayDate) {
        log.info("Validating holidayDate: " + holidayDate);
       List<HolidayDTO> allHolidays = readAllHolidays();
         for(HolidayDTO holidayDTO : allHolidays) {
              if(holidayDTO.getHolidayDate().equals(holidayDate)) {
                return holidayDTO;
              }
         }
            return null;
    }

    private List<HolidayDTO> readAllHolidays() {
        return FileUtil.readFromFile();
    }

    private void printAllHolidays() {
        log.info("All holidays in latest:");
        List<HolidayDTO> allHolidays = readAllHolidays();
        for(HolidayDTO holidayDTO : allHolidays) {
            log.info(holidayDTO.toString());
        }
    }
}
