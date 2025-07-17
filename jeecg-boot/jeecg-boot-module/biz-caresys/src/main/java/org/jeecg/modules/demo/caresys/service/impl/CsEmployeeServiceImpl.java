package org.jeecg.modules.demo.caresys.service.impl;

import org.jeecg.modules.demo.caresys.entity.CsEmployee;
import org.jeecg.modules.demo.caresys.mapper.CsEmployeeMapper;
import org.jeecg.modules.demo.caresys.service.ICsEmployeeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: cs_employee
 * @Author: jeecg-boot
 * @Date:   2025-07-13
 * @Version: V1.0
 */
@Service
public class CsEmployeeServiceImpl extends ServiceImpl<CsEmployeeMapper, CsEmployee> implements ICsEmployeeService {

}
