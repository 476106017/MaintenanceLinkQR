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
 * @Description: cs_resident
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Data
@TableName("cs_resident")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="cs_resident")
public class CsResident implements Serializable {
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
	/**编号*/
	@Excel(name = "编号", width = 15)
    @Schema(description = "编号")
    private java.lang.String residentCode;
	/**姓名*/
	@Excel(name = "姓名", width = 15)
    @Schema(description = "姓名")
    private java.lang.String name;
	/**姓名假名*/
	@Excel(name = "姓名假名", width = 15)
    @Schema(description = "姓名假名")
    private java.lang.String nameKana;
	/**性别（M:男, F:女）*/
	@Excel(name = "性别（M:男, F:女）", width = 15)
    @Schema(description = "性别（M:男, F:女）")
    private java.lang.String gender;
	/**出生日期*/
	@Excel(name = "出生日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "出生日期")
    private java.util.Date birthDate;
	/**死亡日期*/
	@Excel(name = "死亡日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "死亡日期")
    private java.util.Date deathDate;
	/**年龄（冗余字段）*/
	@Excel(name = "年龄（冗余字段）", width = 15)
    @Schema(description = "年龄（冗余字段）")
    private java.lang.Integer age;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @Schema(description = "联系电话")
    private java.lang.String phoneNumber;
	/**居住地址*/
	@Excel(name = "居住地址", width = 15)
    @Schema(description = "居住地址")
    private java.lang.String address;
	/**头像照片URL*/
	@Excel(name = "头像照片URL", width = 15)
    @Schema(description = "头像照片URL")
    private java.lang.String photoUrl;
	/**监护人姓名*/
	@Excel(name = "监护人姓名", width = 15)
    @Schema(description = "监护人姓名")
    private java.lang.String guardianName;
	/**与被照护者关系*/
	@Excel(name = "与被照护者关系", width = 15)
    @Schema(description = "与被照护者关系")
    private java.lang.String guardianRelationship;
	/**监护人联系电话*/
	@Excel(name = "监护人联系电话", width = 15)
    @Schema(description = "监护人联系电话")
    private java.lang.String guardianPhone;
	/**要介护等级*/
	@Excel(name = "要介护等级", width = 15)
    @Schema(description = "要介护等级")
    private java.lang.String careLevel;
	/**介护认证编号*/
	@Excel(name = "介护认证编号", width = 15)
    @Schema(description = "介护认证编号")
    private java.lang.String careCertNumber;
	/**开始照护日期*/
	@Excel(name = "开始照护日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "开始照护日期")
    private java.util.Date careStartDate;
	/**居住类型（独居/与家人同住/机构等）*/
	@Excel(name = "居住类型（独居/与家人同住/机构等）", width = 15)
    @Schema(description = "居住类型（独居/与家人同住/机构等）")
    private java.lang.String residenceType;
	/**是否有认知症*/
	@Excel(name = "是否有认知症", width = 15)
    @Schema(description = "是否有认知症")
    private java.lang.Integer isDementia;
	/**疾病备注*/
	@Excel(name = "疾病备注", width = 15)
    @Schema(description = "疾病备注")
    private java.lang.String diseaseNotes;
	/**过敏信息*/
	@Excel(name = "过敏信息", width = 15)
    @Schema(description = "过敏信息")
    private java.lang.String allergyNotes;
	/**状态（active/disabled/deceased）*/
	@Excel(name = "状态（active/disabled/deceased）", width = 15)
    @Schema(description = "状态（active/disabled/deceased）")
    private java.lang.String status;
	/**逻辑删除标识*/
	@Excel(name = "逻辑删除标识", width = 15)
    @Schema(description = "逻辑删除标识")
    private java.lang.Integer deleteFlag;
}
