package org.jeecg.modules.demo.cashless.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 物品需求
 * @Author: jeecg-boot
 * @Date:   2025-07-02
 * @Version: V1.0
 */
@Data
@TableName("b_item_demand")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="物品需求")
public class BItemDemand implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "id")
    private java.lang.String id;
	/**需求发起人*/
	@Excel(name = "需求发起人", width = 15)
    @Schema(description = "需求发起人")
    private java.lang.String userId;
	/**需求标题*/
	@Excel(name = "需求标题", width = 15)
    @Schema(description = "需求标题")
    private java.lang.String title;
	/**详细描述*/
	@Excel(name = "详细描述", width = 15)
    @Schema(description = "详细描述")
    private java.lang.String description;
	/**分类*/
	@Excel(name = "分类", width = 15)
    @Schema(description = "分类")
    private java.lang.String expectedCategory;
	/**物品名称关键词*/
	@Excel(name = "物品名称关键词", width = 15)
    @Schema(description = "物品名称关键词")
    private java.lang.String expectedName;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @Schema(description = "状态")
    private java.lang.String status;
	/**期望地区*/
	@Excel(name = "期望地区", width = 15)
    @Schema(description = "期望地区")
    private java.lang.String location;
	/**createBy*/
    @Schema(description = "createBy")
    private java.lang.String createBy;
	/**createTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "createTime")
    private java.util.Date createTime;
	/**updateBy*/
    @Schema(description = "updateBy")
    private java.lang.String updateBy;
	/**updateTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "updateTime")
    private java.util.Date updateTime;
	/**sysOrgCode*/
    @Schema(description = "sysOrgCode")
    private java.lang.String sysOrgCode;
}
