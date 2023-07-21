package com.example.springboottest.controller;

import com.example.springboottest.dto.HolidayDTO;
import com.example.springboottest.service.HolidayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class HolidayController {
    @Autowired
    private HolidayService holidayService;

    //add all the methods here based on holidayService
    @PostMapping(value = "/addOneHoliday", consumes = "application/json", produces = "application/json")
    public @ResponseBody HolidayDTO addOneHoliday(@RequestBody HolidayDTO holidayDTO) {
        return holidayService.addOne(holidayDTO);
    }

    @PostMapping(value = "/addMultipleHolidays", consumes = "application/json", produces = "application/json")
    public int addMultipleHolidays(@RequestBody List<HolidayDTO> holidayDTOList) {
        return holidayService.addMultiple(holidayDTOList);
    }

    @PutMapping(value = "/updateOneHoliday", consumes = "application/json", produces = "application/json")
    public HolidayDTO updateOneHoliday(@RequestBody HolidayDTO holidayDTO) {
        return holidayService.updateOne(holidayDTO);
    }

    @PutMapping(value = "/updateMultipleHolidays", consumes = "application/json", produces = "application/json")
    public int updateMultipleHolidays(@RequestBody List<HolidayDTO> holidayDTOList) {
        return holidayService.updateMultiple(holidayDTOList);
    }

    @DeleteMapping(value = "/deleteOneHoliday", consumes = "application/json", produces = "application/json")
    public HolidayDTO deleteOneHoliday(@RequestBody HolidayDTO holidayDTO) {
        return holidayService.deleteOne(holidayDTO);
    }

    @DeleteMapping(value = "/deleteMultipleHolidays", consumes = "application/json", produces = "application/json")
    public int deleteMultipleHolidays(@RequestBody List<HolidayDTO> holidayDTOList) {
        return holidayService.deleteMultiple(holidayDTOList);
    }

    @GetMapping(value = "/findAllNextYearHolidays", produces = "application/json")
    public List<HolidayDTO> findAllNextYearHolidays(@RequestParam String countryCode) {
        return holidayService.findAllNextYearHolidays(countryCode);
    }

    @GetMapping(value = "/findNextHolidayAfterToday", produces = "application/json")
    public HolidayDTO findNextHolidayAfterToday(@RequestParam String countryCode) {
        return holidayService.findNextHolidayAfterToday(countryCode);
    }

    @GetMapping(value = "/validate", produces = "application/json")
    public HolidayDTO validate(@RequestParam String holidayDate) {
        return holidayService.validate(holidayDate);
    }
}
