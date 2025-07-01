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
 * @Description: 物品评价
 * @Author: jeecg-boot
 * @Date:   2025-07-02
 * @Version: V1.0
 */
@Data
@TableName("b_review")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="物品评价")
public class BReview implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "id")
    private java.lang.String id;
	/**关联交易ID*/
	@Excel(name = "关联交易ID", width = 15)
    @Schema(description = "关联交易ID")
    private java.lang.String tradeId;
	/**评价人ID*/
	@Excel(name = "评价人ID", width = 15)
    @Schema(description = "评价人ID")
    private java.lang.String reviewerId;
	/**被评价人ID*/
	@Excel(name = "被评价人ID", width = 15)
    @Schema(description = "被评价人ID")
    private java.lang.String targetUserId;
	/**评分 1-5*/
	@Excel(name = "评分 1-5", width = 15)
    @Schema(description = "评分 1-5")
    private java.lang.Integer rating;
	/**评价内容*/
	@Excel(name = "评价内容", width = 15)
    @Schema(description = "评价内容")
    private java.lang.String comment;
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
