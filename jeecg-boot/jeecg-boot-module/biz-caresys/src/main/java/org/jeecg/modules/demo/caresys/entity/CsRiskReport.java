package org.jeecg.modules.demo.caresys.entity;

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
 * @Description: cs_risk_report
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Data
@TableName("cs_risk_report")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="cs_risk_report")
public class CsRiskReport implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**创建人*/
    @Schema(description = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @Schema(description = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @Schema(description = "所属部门")
    private java.lang.String sysOrgCode;
	/**所属公司*/
	@Excel(name = "所属公司", width = 15)
    @Schema(description = "所属公司")
    private java.lang.String companyId;
	/**所属事务所*/
	@Excel(name = "所属事务所", width = 15)
    @Schema(description = "所属事务所")
    private java.lang.String officeId;
	/**关联老人*/
	@Excel(name = "关联老人", width = 15)
    @Schema(description = "关联老人")
    private java.lang.String residentId;
	/**报告类型（跌倒等）*/
	@Excel(name = "报告类型（跌倒等）", width = 15)
    @Schema(description = "报告类型（跌倒等）")
    private java.lang.String reportType;
	/**报告时间*/
	@Excel(name = "报告时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "报告时间")
    private java.util.Date reportTime;
	/**详情描述*/
	@Excel(name = "详情描述", width = 15)
    @Schema(description = "详情描述")
    private java.lang.String description;
}
