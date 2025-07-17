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
import org.jeecg.modules.demo.caresys.entity.CsSalary;
import org.jeecg.modules.demo.caresys.service.ICsSalaryService;

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
 * @Description: cs_salary
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Tag(name="cs_salary")
@RestController
@RequestMapping("/caresys/csSalary")
@Slf4j
public class CsSalaryController extends JeecgController<CsSalary, ICsSalaryService> {
	@Autowired
	private ICsSalaryService csSalaryService;
	
	/**
	 * 分页列表查询
	 *
	 * @param csSalary
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "cs_salary-分页列表查询")
	@Operation(summary="cs_salary-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CsSalary>> queryPageList(CsSalary csSalary,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<CsSalary> queryWrapper = QueryGenerator.initQueryWrapper(csSalary, req.getParameterMap());
		Page<CsSalary> page = new Page<CsSalary>(pageNo, pageSize);
		IPage<CsSalary> pageList = csSalaryService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param csSalary
	 * @return
	 */
	@AutoLog(value = "cs_salary-添加")
	@Operation(summary="cs_salary-添加")
	@RequiresPermissions("caresys:cs_salary:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CsSalary csSalary) {
		csSalaryService.save(csSalary);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param csSalary
	 * @return
	 */
	@AutoLog(value = "cs_salary-编辑")
	@Operation(summary="cs_salary-编辑")
	@RequiresPermissions("caresys:cs_salary:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CsSalary csSalary) {
		csSalaryService.updateById(csSalary);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "cs_salary-通过id删除")
	@Operation(summary="cs_salary-通过id删除")
	@RequiresPermissions("caresys:cs_salary:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		csSalaryService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "cs_salary-批量删除")
	@Operation(summary="cs_salary-批量删除")
	@RequiresPermissions("caresys:cs_salary:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.csSalaryService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "cs_salary-通过id查询")
	@Operation(summary="cs_salary-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CsSalary> queryById(@RequestParam(name="id",required=true) String id) {
		CsSalary csSalary = csSalaryService.getById(id);
		if(csSalary==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(csSalary);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param csSalary
    */
    @RequiresPermissions("caresys:cs_salary:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CsSalary csSalary) {
        return super.exportXls(request, csSalary, CsSalary.class, "cs_salary");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("caresys:cs_salary:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CsSalary.class);
    }

}
