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
 * @Description: cs_shift_template
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Data
@TableName("cs_shift_template")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="cs_shift_template")
public class CsShiftTemplate implements Serializable {
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
	/**班次模板名称*/
	@Excel(name = "班次模板名称", width = 15)
    @Schema(description = "班次模板名称")
    private java.lang.String templateName;
	/**工作日设定（JSON）*/
	@Excel(name = "工作日设定（JSON）", width = 15)
    @Schema(description = "工作日设定（JSON）")
    private java.lang.String workingDays;
	/**休息日设定（JSON）*/
	@Excel(name = "休息日设定（JSON）", width = 15)
    @Schema(description = "休息日设定（JSON）")
    private java.lang.String restDays;
}
