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
import org.jeecg.modules.demo.caresys.entity.CsRiskReport;
import org.jeecg.modules.demo.caresys.service.ICsRiskReportService;

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
 * @Description: cs_risk_report
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Tag(name="cs_risk_report")
@RestController
@RequestMapping("/caresys/csRiskReport")
@Slf4j
public class CsRiskReportController extends JeecgController<CsRiskReport, ICsRiskReportService> {
	@Autowired
	private ICsRiskReportService csRiskReportService;
	
	/**
	 * 分页列表查询
	 *
	 * @param csRiskReport
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "cs_risk_report-分页列表查询")
	@Operation(summary="cs_risk_report-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CsRiskReport>> queryPageList(CsRiskReport csRiskReport,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<CsRiskReport> queryWrapper = QueryGenerator.initQueryWrapper(csRiskReport, req.getParameterMap());
		Page<CsRiskReport> page = new Page<CsRiskReport>(pageNo, pageSize);
		IPage<CsRiskReport> pageList = csRiskReportService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param csRiskReport
	 * @return
	 */
	@AutoLog(value = "cs_risk_report-添加")
	@Operation(summary="cs_risk_report-添加")
	@RequiresPermissions("caresys:cs_risk_report:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CsRiskReport csRiskReport) {
		csRiskReportService.save(csRiskReport);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param csRiskReport
	 * @return
	 */
	@AutoLog(value = "cs_risk_report-编辑")
	@Operation(summary="cs_risk_report-编辑")
	@RequiresPermissions("caresys:cs_risk_report:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CsRiskReport csRiskReport) {
		csRiskReportService.updateById(csRiskReport);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "cs_risk_report-通过id删除")
	@Operation(summary="cs_risk_report-通过id删除")
	@RequiresPermissions("caresys:cs_risk_report:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		csRiskReportService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "cs_risk_report-批量删除")
	@Operation(summary="cs_risk_report-批量删除")
	@RequiresPermissions("caresys:cs_risk_report:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.csRiskReportService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "cs_risk_report-通过id查询")
	@Operation(summary="cs_risk_report-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CsRiskReport> queryById(@RequestParam(name="id",required=true) String id) {
		CsRiskReport csRiskReport = csRiskReportService.getById(id);
		if(csRiskReport==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(csRiskReport);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param csRiskReport
    */
    @RequiresPermissions("caresys:cs_risk_report:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CsRiskReport csRiskReport) {
        return super.exportXls(request, csRiskReport, CsRiskReport.class, "cs_risk_report");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("caresys:cs_risk_report:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CsRiskReport.class);
    }

}
