package com.wolfexample.wolf.Controller;

import com.wolfexample.wolf.Entity.Bali;
import com.wolfexample.wolf.Payload.BaliDto;
import com.wolfexample.wolf.Service.BaliService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v10/bali")
public class BaliController {

    private BaliService baliService;

    public BaliController(BaliService baliService) {
        this.baliService = baliService;
    }

    //http://localhost:8080/api/v10/bali
    @PostMapping
    public ResponseEntity<BaliDto> addbali(@RequestBody BaliDto baliDto) {
        BaliDto baliDto1 = baliService.createBali(baliDto);
        return new ResponseEntity<>(baliDto1, HttpStatus.CREATED);

    }
   // http://localhost:8080/api/v10/bali?id=
    //
    @DeleteMapping
    public ResponseEntity<String> deleteBaliById(@RequestParam long id) {
        baliService.deleteBaliById(id);
        return new ResponseEntity<>("Bali deleted",HttpStatus.OK);
    }


    // for update the Data
    //   @ RequestParam long id updation of happens by id
            // @ Request Body balidto it gives the request for bali dto to update from it
        // this vl go to service layer for update and than its return back to balidto after this alt enter on update
    // gor to service layer for create method of update

@PutMapping
    public ResponseEntity<BaliDto> updateBali(
    @RequestParam long id,
     @RequestBody BaliDto baliDto,
    BindingResult result
    ) {
//        if(result.hasErrors()){
    BaliDto dto = baliService.updateBali(id, baliDto);
    return new ResponseEntity<>(dto,HttpStatus.OK);

}
    //http://localhost:8080/api/v10/bali
//  @GetMapping
//
//public ResponseEntity<List<BaliDto>> getAllBali(){
//   List<BaliDto> dtos= baliService.getAllBali();
//   return  new ResponseEntity<>(dtos,HttpStatus.OK);
//
//
//}

//    @GetMapping
//    public ResponseEntity<List<BaliDto>> getAllBali(){
//        List<BaliDto> dtos =  baliService.getAllBali();
//        return new ResponseEntity<>(dtos,HttpStatus.OK);
//
//
//
//
//    }

//    @GetMapping
//    public ResponseEntity<List<BaliDto>> getAllBali(){
//      List<BaliDto> baliDtos =  baliService.getAllBali();
//      return new ResponseEntity<>(baliDtos,HttpStatus.OK);
//    }
//

    @GetMapping

    public ResponseEntity<List<BaliDto>> getAllBali(){

     List<BaliDto> baliDtos =   baliService.getAllBali();
     return new ResponseEntity<>(baliDtos,HttpStatus.OK);

    }

}
            
            



