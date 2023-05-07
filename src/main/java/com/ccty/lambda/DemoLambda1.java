package com.ccty.lambda;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DemoLambda1 {
        /**
         * 主函数
         */
        public static void main(String[] args) {
            List<GoodsInfoDTO> goodsInfoList = new ArrayList<>();
            GoodsInfoDTO goodsInfo = new GoodsInfoDTO();
            goodsInfo.setGoodsNo("2022051001");
            goodsInfo.setGoodsType("MATERIAL");
            goodsInfo.setPrice(BigDecimal.valueOf(25.0));
            goodsInfo.setQty(2);
            goodsInfoList.add(goodsInfo);

            goodsInfo = new GoodsInfoDTO();
            goodsInfo.setGoodsNo("2022051002");
            goodsInfo.setGoodsType("MATERIAL");
            goodsInfo.setPrice(BigDecimal.valueOf(30));
            goodsInfo.setQty(2);
            goodsInfoList.add(goodsInfo);

            goodsInfo = new GoodsInfoDTO();
            goodsInfo.setGoodsNo("2022052001");
            goodsInfo.setGoodsType("RECHARGE");
            goodsInfo.setPrice(BigDecimal.valueOf(10.0));
            goodsInfo.setQty(1);
            goodsInfoList.add(goodsInfo);

            // 汇总1：单列累加（65.0）
            System.out.println(goodsInfoList.stream().map(GoodsInfoDTO::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
            // 汇总2：先过滤再单列累加（55.0）
            System.out.println(goodsInfoList.stream().filter(goods -> "MATERIAL".equals(goods.getGoodsType()))
                    .map(GoodsInfoDTO::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
            // 汇总3：双列乘积并累加（120.0）
            System.out.println(goodsInfoList.stream().map(x -> x.getPrice().multiply(BigDecimal.valueOf(x.getQty())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
            // 积汇4：双列乘积并累加（120.0）
            System.out.println(goodsInfoList.stream().reduce(BigDecimal.ZERO, (x, y) -> {
                return x.add(y.getPrice().multiply(BigDecimal.valueOf(y.getQty())));
            }, BigDecimal::add));
        }

}
