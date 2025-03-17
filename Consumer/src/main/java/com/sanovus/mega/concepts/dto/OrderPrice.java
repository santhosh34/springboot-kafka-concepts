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
public class OrderPrice implements Serializable {

    @Serial
    private static final long serialVersionUID = 5529055596423708524L;

    private long id;

    private String buyer;


}
