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
 * @Description: 闲置物品
 * @Author: jeecg-boot
 * @Date:   2025-07-02
 * @Version: V1.0
 */
@Data
@TableName("b_item")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="闲置物品")
public class BItem implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "id")
    private java.lang.String id;
	/**物主ID*/
	@Excel(name = "物主ID", width = 15)
    @Schema(description = "物主ID")
    private java.lang.String userId;
	/**物品名称*/
	@Excel(name = "物品名称", width = 15)
    @Schema(description = "物品名称")
    private java.lang.String itemName;
	/**物品描述*/
	@Excel(name = "物品描述", width = 15)
    @Schema(description = "物品描述")
    private java.lang.String itemDesc;
	/**图片URL*/
	@Excel(name = "图片URL", width = 15)
    @Schema(description = "图片URL")
    private java.lang.String imageUrls;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @Schema(description = "状态")
    private java.lang.String status;
	/**分类*/
	@Excel(name = "分类", width = 15)
    @Schema(description = "分类")
    private java.lang.String category;
	/**物品所在地*/
	@Excel(name = "物品所在地", width = 15)
    @Schema(description = "物品所在地")
    private java.lang.String location;
	/**创建人*/
    @Schema(description = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private java.util.Date createTime;
	/**更新人*/
    @Schema(description = "更新人")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新时间")
    private java.util.Date updateTime;
	/**所属部门*/
    @Schema(description = "所属部门")
    private java.lang.String sysOrgCode;
}
