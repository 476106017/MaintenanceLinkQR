package org.jeecg.modules.demo.caresys.controller;

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
import org.jeecg.modules.demo.caresys.entity.CsResident;
import org.jeecg.modules.demo.caresys.service.ICsResidentService;

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
 * @Description: cs_resident
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Tag(name="cs_resident")
@RestController
@RequestMapping("/caresys/csResident")
@Slf4j
public class CsResidentController extends JeecgController<CsResident, ICsResidentService> {
	@Autowired
	private ICsResidentService csResidentService;
	
	/**
	 * 分页列表查询
	 *
	 * @param csResident
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "cs_resident-分页列表查询")
	@Operation(summary="cs_resident-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CsResident>> queryPageList(CsResident csResident,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<CsResident> queryWrapper = QueryGenerator.initQueryWrapper(csResident, req.getParameterMap());
		Page<CsResident> page = new Page<CsResident>(pageNo, pageSize);
		IPage<CsResident> pageList = csResidentService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param csResident
	 * @return
	 */
	@AutoLog(value = "cs_resident-添加")
	@Operation(summary="cs_resident-添加")
	@RequiresPermissions("caresys:cs_resident:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CsResident csResident) {
		csResidentService.save(csResident);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param csResident
	 * @return
	 */
	@AutoLog(value = "cs_resident-编辑")
	@Operation(summary="cs_resident-编辑")
	@RequiresPermissions("caresys:cs_resident:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CsResident csResident) {
		csResidentService.updateById(csResident);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "cs_resident-通过id删除")
	@Operation(summary="cs_resident-通过id删除")
	@RequiresPermissions("caresys:cs_resident:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		csResidentService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "cs_resident-批量删除")
	@Operation(summary="cs_resident-批量删除")
	@RequiresPermissions("caresys:cs_resident:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.csResidentService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "cs_resident-通过id查询")
	@Operation(summary="cs_resident-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CsResident> queryById(@RequestParam(name="id",required=true) String id) {
		CsResident csResident = csResidentService.getById(id);
		if(csResident==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(csResident);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param csResident
    */
    @RequiresPermissions("caresys:cs_resident:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CsResident csResident) {
        return super.exportXls(request, csResident, CsResident.class, "cs_resident");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("caresys:cs_resident:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CsResident.class);
    }

}
