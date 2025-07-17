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
 * @Description: cs_employee
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Data
@TableName("cs_employee")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="cs_employee")
public class CsEmployee implements Serializable {
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
	/**系统用户ID（关联sys_user.id）*/
	@Excel(name = "系统用户ID（关联sys_user.id）", width = 15)
    @Schema(description = "系统用户ID（关联sys_user.id）")
    private java.lang.String userId;
	/**员工编号*/
	@Excel(name = "员工编号", width = 15)
    @Schema(description = "员工编号")
    private java.lang.String employeeCode;
	/**员工姓名*/
	@Excel(name = "员工姓名", width = 15)
    @Schema(description = "员工姓名")
    private java.lang.String name;
	/**性别*/
	@Excel(name = "性别", width = 15)
    @Schema(description = "性别")
    private java.lang.String gender;
	/**出生日期*/
	@Excel(name = "出生日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "出生日期")
    private java.util.Date birthDate;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @Schema(description = "联系电话")
    private java.lang.String phoneNumber;
	/**雇佣形态（全职/兼职等）*/
	@Excel(name = "雇佣形态（全职/兼职等）", width = 15)
    @Schema(description = "雇佣形态（全职/兼职等）")
    private java.lang.String employmentType;
}
