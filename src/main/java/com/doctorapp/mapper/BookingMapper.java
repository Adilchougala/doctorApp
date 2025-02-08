package com.doctorapp.mapper;

import com.doctorapp.entity.Booking;
import com.doctorapp.payload.BookingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking dtoToEntity(BookingDto bookingDto);

    BookingDto entityToDto(Booking booking);
}
