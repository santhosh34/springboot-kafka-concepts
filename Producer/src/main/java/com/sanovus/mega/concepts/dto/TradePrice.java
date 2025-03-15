package com.sanovus.mega.concepts.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Data
@ToString
public class TradePrice implements Serializable {

    private long id;
    private String trader;
}
