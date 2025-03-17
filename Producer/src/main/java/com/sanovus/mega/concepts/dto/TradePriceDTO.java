package com.sanovus.mega.concepts.dto;


import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TradePriceDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2119854387204312905L;


    private long id;

    private String trader;


}
