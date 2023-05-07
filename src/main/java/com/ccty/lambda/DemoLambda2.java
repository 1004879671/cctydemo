package com.ccty.lambda;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class DemoLambda2 {
        /**
         * 主函数
         */
        public static void main(String[] args) {
            List<String> list = Arrays.asList("a","b","C");
            String s = list.stream().collect(Collectors.joining(",")).toString();
            System.out.println(s);

            List<String> list1 = list.stream().map(x->x+"$").collect(Collectors.toList());
            System.out.println(list1);

            //对象集合获取某个字段的最小值：
            List<GoodsInfoDTO> goodsInfoList = new ArrayList<>();
            GoodsInfoDTO goodsInfo = new GoodsInfoDTO();
            goodsInfo.setGoodsNo("2022051001");
            goodsInfo.setGoodsType("MATERIAL");
            goodsInfo.setPrice(BigDecimal.valueOf(25.012));
            goodsInfo.setQty(2);
            goodsInfo.setDate(DateUtil.parse("20230508","yyyyMMdd"));
            goodsInfoList.add(goodsInfo);

            goodsInfo = new GoodsInfoDTO();
            goodsInfo.setGoodsNo("2022051002");
            goodsInfo.setGoodsType("MATERIAL");
            goodsInfo.setPrice(BigDecimal.valueOf(10.1123));
            goodsInfo.setQty(2);
            goodsInfo.setDate(DateUtil.parse("20230507","yyyyMMdd"));
            goodsInfoList.add(goodsInfo);

            goodsInfo = new GoodsInfoDTO();
            goodsInfo.setGoodsNo("2022051003");
            goodsInfo.setGoodsType("MATERIAL");
            goodsInfo.setPrice(BigDecimal.valueOf(30));
            goodsInfo.setQty(2);
            goodsInfo.setDate(DateUtil.parse("20230509","yyyyMMdd"));
            goodsInfoList.add(goodsInfo);

            Date minEntryDate = goodsInfoList.stream()
                    .map(GoodsInfoDTO::getDate)
                    .min(Date::compareTo)
                    .get();
            System.out.println(minEntryDate);

            //对象集合求某个值最大的对象
            GoodsInfoDTO dto = goodsInfoList.stream().max(Comparator.comparing(GoodsInfoDTO::getDate)).get();
            System.out.println(dto);

            GoodsInfoDTO dto1 = goodsInfoList.stream().min(Comparator.comparing(GoodsInfoDTO::getPrice)).get();
            System.out.println(dto1);
        }

}
