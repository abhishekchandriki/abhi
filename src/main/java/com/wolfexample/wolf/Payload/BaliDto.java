package com.wolfexample.wolf.Payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Size(min = 2, message = "Should be more than 2 characters")

public class BaliDto {


    private Long id;

    private String name;


    private String email;

    private String mobile;


    private String message;
}