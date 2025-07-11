package org.jeecg.modules.demo.qr.service;

import cn.hutool.core.map.MapUtil;
import org.jeecg.modules.demo.qr.entity.BizDevice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 设备二维码管理
 * @Author: jeecg-boot
 * @Date:   2025-06-06
 * @Version: V1.0
 */
public interface IBizDeviceService extends IService<BizDevice> {

    /**
     * 查询所有目录
     *
     * @return
     */
    public List<Map<String, String>> queryAllCategories();
}
