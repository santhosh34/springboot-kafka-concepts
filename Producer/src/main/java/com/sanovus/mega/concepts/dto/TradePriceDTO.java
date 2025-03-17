package com.sanovus.mega.concepts.dto;


import lombok.*;

import java.io.Serial;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TradePriceDTO implements IBaseDTO {

    @Serial
    private static final long serialVersionUID = -2119854387204312905L;

    private int id;

    private String trader;


}
