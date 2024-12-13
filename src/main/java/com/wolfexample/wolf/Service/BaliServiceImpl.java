package com.wolfexample.wolf.Service;


import com.wolfexample.wolf.Entity.Bali;
import com.wolfexample.wolf.Payload.BaliDto;
import com.wolfexample.wolf.Repository.BaliRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BaliServiceImpl implements BaliService {

    private BaliRepository baliRepository;

    public BaliServiceImpl(BaliRepository baliRepository) {
        this.baliRepository = baliRepository;
    }


    @Override
    public BaliDto createBali(BaliDto baliDto) {
        Bali bali = mapToEntity(baliDto);
        Bali savedEntity = baliRepository.save(bali);
        BaliDto dto = mapToDto(savedEntity);
        dto.setMessage("Bali saved");
        return dto;

    }

    @Override
    public void deleteBaliById(long id) {
        baliRepository.deleteById(id);
    }



    // after overide then give then give the adress or place where to do the update give the process details
    //in this method   **mcv architecture is used to do the process details
    //step by step of work flow
    //step 1 : postman calls controller
    //step 2 : controller calls service
    //step 3 : service calls repository
    //step 4 : repository back to service
    //step 5 : service back controller
    //step 6 : controller back to postman
    @Override
    public BaliDto updateBali(long id, BaliDto baliDto) {
       Optional<Bali> optionalBali = baliRepository.findById(id);

        Bali bali = optionalBali.get();

        bali.setName(baliDto.getName());
        bali.setEmail(bali.getEmail());
        bali.setMobile(bali.getMobile());
        BaliDto dto = mapToDto(bali);
        return null;
    }

    @Override
    public List<BaliDto> getAllBali() {
        List<Bali> baliList = baliRepository.findAll();
        List<BaliDto> baliDtos = baliList.stream().map(b->mapToDto(b)).collect(Collectors.toList());
        return baliDtos;
    }

//    @Override
//    public List<BaliDto> getAllBali() {
//        List<Bali> baliList = baliRepository.findAll();
//          List<BaliDto> baliDtos = baliList.stream().map(b->mapToDto(b)).collect(Collectors.toList());
//          return baliDtos;
//    }

//    @Override
//    public List<BaliDto> getAllBali() {
//       List<Bali> baliList = baliRepository.findAll();
//      List<BaliDto> balidtos= baliList.stream().map(b->mapToDto(b)).collect(Collectors.toList());
//        return balidtos;
//    }

//    @Override
//    public List<BaliDto> getAllBali() {
//        List<Bali> baliList = baliRepository.findAll();
//       List<BaliDto> baliDtos = baliList.stream().map(b->mapToDto(b)).collect(Collectors.toList());
//        return baliDtos ;
//
//    }





    Bali mapToEntity(BaliDto dto) {

        Bali entity = new Bali();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;
    }

    BaliDto mapToDto(Bali bali) {
        BaliDto dto = new BaliDto();
        dto.setId(bali.getId());
        dto.setName(bali.getName());
        dto.setEmail(bali.getEmail());
        dto.setMobile(bali.getMobile());
        return dto;

    }
}
