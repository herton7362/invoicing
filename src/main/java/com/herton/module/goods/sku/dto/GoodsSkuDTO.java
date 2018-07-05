package com.herton.module.goods.sku.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.ParentField;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.sku.domain.GoodsSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Component
@ApiModel("商品最小库存单元")
public class GoodsSkuDTO extends BaseDTO<GoodsSkuDTO, GoodsSku> {
    @ParentField
    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "商品")
    private Goods goods;
    @ApiModelProperty(value = "条码")
    private String barcode;
    @ApiModelProperty(value = "sku编号")
    private String code;
    @ApiModelProperty(value = "属性值id（逗号分隔）")
    private String goodsAttributeIds;
    @ApiModelProperty(value = "上次进货价")
    private Double lastPurchasePrice;
    @ApiModelProperty(value = "库存数量")
    private Double stockNumber;
    @ApiModelProperty(value = "库存预警值")
    private Double stockWarnNumber;
    @ApiModelProperty("商品属性值，用逗号分隔 例 attrId:红色")
    private String goodsAttributes;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof GoodsSkuDTO)) {
            return false;
        }
        GoodsSkuDTO dto = (GoodsSkuDTO) obj;
        if(StringUtils.isNotBlank(this.getGoodsId())
                && StringUtils.isNotBlank(dto.getGoodsAttributeIds())
                && StringUtils.isNotBlank(this.getGoodsAttributeIds())) {
            String[] attrIds1 = dto.getGoodsAttributeIds().split(",");
            String[] attrIds2 = this.getGoodsAttributeIds().split(",");
            List<String> attrIdList1 = Arrays.asList(attrIds1);
            List<String> attrIdList2 = Arrays.asList(attrIds2);
            return attrIdList1
                    .stream()
                    .allMatch(attrIdList2::contains) && this.getGoodsId().equals(dto.getGoodsId());
        }
        return super.equals(obj);
    }
}
