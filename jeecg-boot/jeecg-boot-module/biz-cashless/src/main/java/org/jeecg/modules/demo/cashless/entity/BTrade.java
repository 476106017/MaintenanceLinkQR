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
 * @Description: 交易记录
 * @Author: jeecg-boot
 * @Date:   2025-07-02
 * @Version: V1.0
 */
@Data
@TableName("b_trade")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="交易记录")
public class BTrade implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "id")
    private java.lang.String id;
	/**发起人*/
	@Excel(name = "发起人", width = 15)
    @Schema(description = "发起人")
    private java.lang.String fromUserId;
	/**响应人*/
	@Excel(name = "响应人", width = 15)
    @Schema(description = "响应人")
    private java.lang.String toUserId;
	/**发起人提供物品*/
	@Excel(name = "发起人提供物品", width = 15)
    @Schema(description = "发起人提供物品")
    private java.lang.String fromItemId;
	/**响应人提供物品*/
	@Excel(name = "响应人提供物品", width = 15)
    @Schema(description = "响应人提供物品")
    private java.lang.String toItemId;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @Schema(description = "状态")
    private java.lang.String status;
	/**留言*/
	@Excel(name = "留言", width = 15)
    @Schema(description = "留言")
    private java.lang.String message;
	/**达成交易时间*/
	@Excel(name = "达成交易时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "达成交易时间")
    private java.util.Date dealTime;
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
