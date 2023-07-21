package com.example.springboottest.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HolidayDTO {
    //add CountryCode, CountryDesc, HolidayDate with type Date, HolidayName fields and their getters and setters
    @CsvBindByPosition(position = 0)
    private String countryCode;
    @CsvBindByPosition(position = 1)
    private String countryDesc;
    @CsvBindByPosition(position = 2)
    private String holidayDate;
    @CsvBindByPosition(position = 3)
    private String holidayName;

    public HolidayDTO(String countryCode, String countryDesc, String holidayDate, String holidayName) {
        this.countryCode = countryCode;
        this.countryDesc = countryDesc;
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    private Date parseDate(String holidayDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(holidayDate);
        } catch (Exception e) {
            return null;
        }
    }

    //add equals and hashCode methods
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof HolidayDTO))
            return false;
        if (obj == this)
            return true;
        return this.getCountryCode().equals(((HolidayDTO) obj).getCountryCode()) &&
                this.getHolidayDate().equals(((HolidayDTO) obj).getHolidayDate());
    }

    @Override
    public int hashCode() {
        return this.getCountryCode().hashCode() +
                this.getHolidayDate().hashCode();
    }

    //add toString method
    @Override
    public String toString() {
        return "HolidayDTO{" +
                "countryCode='" + countryCode + '\'' +
                ", countryDesc='" + countryDesc + '\'' +
                ", holidayDate='" + holidayDate + '\'' +
                ", holidayName='" + holidayName + '\'' +
                '}';
    }

}
