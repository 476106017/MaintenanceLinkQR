package org.jeecg.modules.demo.qr.service.impl;

import cn.hutool.core.map.MapUtil;
import org.jeecg.modules.demo.qr.entity.BizDevice;
import org.jeecg.modules.demo.qr.mapper.BizDeviceMapper;
import org.jeecg.modules.demo.qr.service.IBizDeviceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 设备二维码管理
 * @Author: jeecg-boot
 * @Date:   2025-06-06
 * @Version: V1.0
 */
@Service
public class BizDeviceServiceImpl extends ServiceImpl<BizDeviceMapper, BizDevice> implements IBizDeviceService {

    @Override
    public List<Map<String, String>> queryAllCategories() {
        final List<String> categories = this.baseMapper.queryAllCategories();
        return categories.stream().map(s-> (Map<String, String>)MapUtil.of("category",s)).toList();
    }

}
