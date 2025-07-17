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
import org.jeecg.modules.demo.caresys.entity.CsCalendarEvent;
import org.jeecg.modules.demo.caresys.service.ICsCalendarEventService;

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
 * @Description: cs_calendar_event
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Tag(name="cs_calendar_event")
@RestController
@RequestMapping("/caresys/csCalendarEvent")
@Slf4j
public class CsCalendarEventController extends JeecgController<CsCalendarEvent, ICsCalendarEventService> {
	@Autowired
	private ICsCalendarEventService csCalendarEventService;
	
	/**
	 * 分页列表查询
	 *
	 * @param csCalendarEvent
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "cs_calendar_event-分页列表查询")
	@Operation(summary="cs_calendar_event-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CsCalendarEvent>> queryPageList(CsCalendarEvent csCalendarEvent,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<CsCalendarEvent> queryWrapper = QueryGenerator.initQueryWrapper(csCalendarEvent, req.getParameterMap());
		Page<CsCalendarEvent> page = new Page<CsCalendarEvent>(pageNo, pageSize);
		IPage<CsCalendarEvent> pageList = csCalendarEventService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param csCalendarEvent
	 * @return
	 */
	@AutoLog(value = "cs_calendar_event-添加")
	@Operation(summary="cs_calendar_event-添加")
	@RequiresPermissions("caresys:cs_calendar_event:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CsCalendarEvent csCalendarEvent) {
		csCalendarEventService.save(csCalendarEvent);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param csCalendarEvent
	 * @return
	 */
	@AutoLog(value = "cs_calendar_event-编辑")
	@Operation(summary="cs_calendar_event-编辑")
	@RequiresPermissions("caresys:cs_calendar_event:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CsCalendarEvent csCalendarEvent) {
		csCalendarEventService.updateById(csCalendarEvent);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "cs_calendar_event-通过id删除")
	@Operation(summary="cs_calendar_event-通过id删除")
	@RequiresPermissions("caresys:cs_calendar_event:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		csCalendarEventService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "cs_calendar_event-批量删除")
	@Operation(summary="cs_calendar_event-批量删除")
	@RequiresPermissions("caresys:cs_calendar_event:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.csCalendarEventService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "cs_calendar_event-通过id查询")
	@Operation(summary="cs_calendar_event-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CsCalendarEvent> queryById(@RequestParam(name="id",required=true) String id) {
		CsCalendarEvent csCalendarEvent = csCalendarEventService.getById(id);
		if(csCalendarEvent==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(csCalendarEvent);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param csCalendarEvent
    */
    @RequiresPermissions("caresys:cs_calendar_event:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CsCalendarEvent csCalendarEvent) {
        return super.exportXls(request, csCalendarEvent, CsCalendarEvent.class, "cs_calendar_event");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("caresys:cs_calendar_event:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CsCalendarEvent.class);
    }

}
