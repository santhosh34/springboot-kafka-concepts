package com.sanovus.mega.concepts.dto;


import lombok.*;

import java.io.Serial;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderPriceDTO implements IBaseDTO {

    @Serial
    private static final long serialVersionUID = 5529055596423708524L;

    private int id;

    private String buyer;


}
