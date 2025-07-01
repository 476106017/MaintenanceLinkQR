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
import org.jeecg.modules.demo.cashless.entity.BTrade;
import org.jeecg.modules.demo.cashless.service.IBTradeService;

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
 * @Description: 交易记录
 * @Author: jeecg-boot
 * @Date:   2025-07-02
 * @Version: V1.0
 */
@Tag(name="交易记录")
@RestController
@RequestMapping("/cashless/bTrade")
@Slf4j
public class BTradeController extends JeecgController<BTrade, IBTradeService> {
	@Autowired
	private IBTradeService bTradeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bTrade
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "交易记录-分页列表查询")
	@Operation(summary="交易记录-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BTrade>> queryPageList(BTrade bTrade,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<BTrade> queryWrapper = QueryGenerator.initQueryWrapper(bTrade, req.getParameterMap());
		Page<BTrade> page = new Page<BTrade>(pageNo, pageSize);
		IPage<BTrade> pageList = bTradeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bTrade
	 * @return
	 */
	@AutoLog(value = "交易记录-添加")
	@Operation(summary="交易记录-添加")
	@RequiresPermissions("cashless:b_trade:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BTrade bTrade) {
		bTradeService.save(bTrade);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bTrade
	 * @return
	 */
	@AutoLog(value = "交易记录-编辑")
	@Operation(summary="交易记录-编辑")
	@RequiresPermissions("cashless:b_trade:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BTrade bTrade) {
		bTradeService.updateById(bTrade);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "交易记录-通过id删除")
	@Operation(summary="交易记录-通过id删除")
	@RequiresPermissions("cashless:b_trade:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bTradeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "交易记录-批量删除")
	@Operation(summary="交易记录-批量删除")
	@RequiresPermissions("cashless:b_trade:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bTradeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "交易记录-通过id查询")
	@Operation(summary="交易记录-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BTrade> queryById(@RequestParam(name="id",required=true) String id) {
		BTrade bTrade = bTradeService.getById(id);
		if(bTrade==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bTrade);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bTrade
    */
    @RequiresPermissions("cashless:b_trade:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BTrade bTrade) {
        return super.exportXls(request, bTrade, BTrade.class, "交易记录");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("cashless:b_trade:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BTrade.class);
    }

}
