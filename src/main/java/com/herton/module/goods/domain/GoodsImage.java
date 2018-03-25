package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("商品图片")
public class GoodsImage extends BaseEntity {
    @ApiModelProperty(value = "是否封面")
    private Boolean isCover;
    @ApiModelProperty(value = "商品id")
    @Column(length = 36)
    private String goodsId;
    @ApiModelProperty(value = "附件id")
    @Column(length = 36)
    private String attachmentId;

    public Boolean getIsCover() {
        return this.isCover;
    }

    public void setIsCover(Boolean isCover) {
        this.isCover = isCover;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
}
