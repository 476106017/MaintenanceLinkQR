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
 * @Description: cs_salary
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Data
@TableName("cs_salary")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="cs_salary")
public class CsSalary implements Serializable {
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
	/**员工ID*/
	@Excel(name = "员工ID", width = 15)
    @Schema(description = "员工ID")
    private java.lang.String employeeId;
	/**工资月份*/
	@Excel(name = "工资月份", width = 15)
    @Schema(description = "工资月份")
    private java.lang.String salaryMonth;
	/**工时数*/
	@Excel(name = "工时数", width = 15)
    @Schema(description = "工时数")
    private java.math.BigDecimal workingHours;
	/**基础工资*/
	@Excel(name = "基础工资", width = 15)
    @Schema(description = "基础工资")
    private java.math.BigDecimal baseSalary;
	/**奖金*/
	@Excel(name = "奖金", width = 15)
    @Schema(description = "奖金")
    private java.math.BigDecimal bonus;
}
