package org.jeecg.modules.demo.qr.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.qr.entity.BizDevice;
import org.jeecg.modules.demo.qr.service.IBizDeviceService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 设备二维码管理
 * @Author: jeecg-boot
 * @Date:   2025-06-06
 * @Version: V1.0
 */
@Tag(name="设备二维码管理")
@RestController
@RequestMapping("/qr/bizDevice")
@Slf4j
public class BizDeviceController extends JeecgController<BizDevice, IBizDeviceService> {
	@Autowired
	private IBizDeviceService bizDeviceService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bizDevice
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "设备二维码管理-分页列表查询")
	@Operation(summary="设备二维码管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BizDevice>> queryPageList(BizDevice bizDevice,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("status", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<BizDevice> queryWrapper = QueryGenerator.initQueryWrapper(bizDevice, req.getParameterMap(),customeRuleMap);
		Page<BizDevice> page = new Page<BizDevice>(pageNo, pageSize);
		IPage<BizDevice> pageList = bizDeviceService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bizDevice
	 * @return
	 */
	@AutoLog(value = "设备二维码管理-添加")
	@Operation(summary="设备二维码管理-添加")
	@RequiresPermissions("qr:biz_device:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BizDevice bizDevice) {
		bizDeviceService.save(bizDevice);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bizDevice
	 * @return
	 */
	@AutoLog(value = "设备二维码管理-编辑")
	@Operation(summary="设备二维码管理-编辑")
	@RequiresPermissions("qr:biz_device:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BizDevice bizDevice) {
		bizDeviceService.updateById(bizDevice);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "设备二维码管理-通过id删除")
	@Operation(summary="设备二维码管理-通过id删除")
	@RequiresPermissions("qr:biz_device:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bizDeviceService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "设备二维码管理-批量删除")
	@Operation(summary="设备二维码管理-批量删除")
	@RequiresPermissions("qr:biz_device:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bizDeviceService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "设备二维码管理-通过id查询")
	@Operation(summary="设备二维码管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BizDevice> queryById(@RequestParam(name="id",required=true) String id) {
		BizDevice bizDevice = bizDeviceService.getById(id);
		if(bizDevice==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bizDevice);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bizDevice
    */
    @RequiresPermissions("qr:biz_device:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BizDevice bizDevice) {
        return super.exportXls(request, bizDevice, BizDevice.class, "设备二维码管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("qr:biz_device:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BizDevice.class);
    }

}
