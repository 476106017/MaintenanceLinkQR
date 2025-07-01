package org.jeecg.modules.demo.cashless.controller;

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
import org.jeecg.modules.demo.cashless.entity.BItemDemand;
import org.jeecg.modules.demo.cashless.service.IBItemDemandService;

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
 * @Description: 物品需求
 * @Author: jeecg-boot
 * @Date:   2025-07-02
 * @Version: V1.0
 */
@Tag(name="物品需求")
@RestController
@RequestMapping("/cashless/bItemDemand")
@Slf4j
public class BItemDemandController extends JeecgController<BItemDemand, IBItemDemandService> {
	@Autowired
	private IBItemDemandService bItemDemandService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bItemDemand
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "物品需求-分页列表查询")
	@Operation(summary="物品需求-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BItemDemand>> queryPageList(BItemDemand bItemDemand,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<BItemDemand> queryWrapper = QueryGenerator.initQueryWrapper(bItemDemand, req.getParameterMap());
		Page<BItemDemand> page = new Page<BItemDemand>(pageNo, pageSize);
		IPage<BItemDemand> pageList = bItemDemandService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bItemDemand
	 * @return
	 */
	@AutoLog(value = "物品需求-添加")
	@Operation(summary="物品需求-添加")
	@RequiresPermissions("cashless:b_item_demand:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BItemDemand bItemDemand) {
		bItemDemandService.save(bItemDemand);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bItemDemand
	 * @return
	 */
	@AutoLog(value = "物品需求-编辑")
	@Operation(summary="物品需求-编辑")
	@RequiresPermissions("cashless:b_item_demand:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BItemDemand bItemDemand) {
		bItemDemandService.updateById(bItemDemand);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "物品需求-通过id删除")
	@Operation(summary="物品需求-通过id删除")
	@RequiresPermissions("cashless:b_item_demand:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bItemDemandService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "物品需求-批量删除")
	@Operation(summary="物品需求-批量删除")
	@RequiresPermissions("cashless:b_item_demand:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bItemDemandService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "物品需求-通过id查询")
	@Operation(summary="物品需求-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BItemDemand> queryById(@RequestParam(name="id",required=true) String id) {
		BItemDemand bItemDemand = bItemDemandService.getById(id);
		if(bItemDemand==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bItemDemand);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bItemDemand
    */
    @RequiresPermissions("cashless:b_item_demand:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BItemDemand bItemDemand) {
        return super.exportXls(request, bItemDemand, BItemDemand.class, "物品需求");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("cashless:b_item_demand:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BItemDemand.class);
    }

}
