package com.example.springboottest.service;

import com.example.springboottest.dto.HolidayDTO;

import java.util.List;

public interface HolidayService {
    HolidayDTO addOne(HolidayDTO holidayDTO);
    int addMultiple(List<HolidayDTO> holidayDTOList);
    HolidayDTO updateOne(HolidayDTO holidayDTO);
    int updateMultiple(List<HolidayDTO> holidayDTOList);
    HolidayDTO deleteOne(HolidayDTO holidayDTO);
    int deleteMultiple(List<HolidayDTO> holidayDTOList);
    List<HolidayDTO> findAllNextYearHolidays(String countryCode);
    HolidayDTO findNextHolidayAfterToday(String countryCode);
    HolidayDTO validate(String holidayDate);
}
