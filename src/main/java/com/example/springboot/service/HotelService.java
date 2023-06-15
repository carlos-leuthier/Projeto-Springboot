package com.example.springboot.service;

import org.springframework.stereotype.Service;

import com.example.springboot.model.Hotel;
import com.example.springboot.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.orElse(null);
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setNome(updatedHotel.getNome());
            hotel.setDescricao(updatedHotel.getDescricao());
            hotel.setClassificacao(updatedHotel.getClassificacao());
            hotel.setPrecoMedioDiaria(updatedHotel.getPrecoMedioDiaria());
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public boolean deleteHotel(Long id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotelRepository.delete(hotel);
            return true;
        }
        return false;
    }
}
