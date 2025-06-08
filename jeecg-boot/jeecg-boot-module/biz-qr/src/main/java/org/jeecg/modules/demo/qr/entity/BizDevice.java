package org.jeecg.modules.demo.qr.entity;

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
 * @Description: 设备二维码管理
 * @Author: jeecg-boot
 * @Date:   2025-06-06
 * @Version: V1.0
 */
@Data
@TableName("biz_device")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="设备二维码管理")
public class BizDevice implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "id")
    private java.lang.Integer id;
	/**设备编号*/
	@Excel(name = "设备编号", width = 15)
    @Schema(description = "设备编号")
    private java.lang.String no;
	/**设备名*/
	@Excel(name = "设备名", width = 15)
    @Schema(description = "设备名")
    private java.lang.String name;
	/**生产批次*/
	@Excel(name = "生产批次", width = 15)
    @Schema(description = "生产批次")
    private java.lang.String productionBatch;
	/**生产日期*/
	@Excel(name = "生产日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "生产日期")
    private java.util.Date productionDate;
	/**生产人员*/
	@Excel(name = "生产人员", width = 15)
    @Schema(description = "生产人员")
    private java.lang.String productionPerson;
	/**设备照片*/
	@Excel(name = "设备照片", width = 15)
    @Schema(description = "设备照片")
    private java.lang.String picture;
	/**生产图纸*/
	@Excel(name = "生产图纸", width = 15)
    @Schema(description = "生产图纸")
    private java.lang.String drawingPdfUrl;
	/**出货状态*/
	@Excel(name = "出货状态", width = 15, dicCode = "qr-status")
	@Dict(dicCode = "qr-status")
    @Schema(description = "出货状态")
    private java.lang.String status;
	/**出货日期*/
	@Excel(name = "出货日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "出货日期")
    private java.util.Date shippedDate;
	/**出货去向*/
	@Excel(name = "出货去向", width = 15)
    @Schema(description = "出货去向")
    private java.lang.String shippedTo;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "创建时间")
    private java.util.Date createTime;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "更新时间")
    private java.util.Date updateTime;
}
