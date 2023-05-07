package com.ccty.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfoDTO {
    public String goodsNo;
    private String goodsType;
    private BigDecimal price;
    private int qty;
    private Date date;
}
