package com.wolfexample.wolf.Service;

import com.wolfexample.wolf.Entity.Bali;
import com.wolfexample.wolf.Payload.BaliDto;

import java.util.List;

public interface BaliService {

    public BaliDto createBali(BaliDto baliDto );

    void deleteBaliById(long id);

    BaliDto updateBali(long id, BaliDto baliDto);

    List<BaliDto> getAllBali();

    //  List<BaliDto> getAllBali();

    //List<BaliDto> getAllBali();

    // List<BaliDto> getAllBali();


    // BaliDto updateBali(long id, BaliDto baliDto); //update methode is created next go to servise implementationlayer
    // and map the baliDto to bali and vice versa to update all the information like name ,email,mobile
}
