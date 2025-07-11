package org.jeecg.modules.demo.qr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.demo.qr.entity.BizDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 设备二维码管理
 * @Author: jeecg-boot
 * @Date:   2025-06-06
 * @Version: V1.0
 */
public interface BizDeviceMapper extends BaseMapper<BizDevice> {

    /**
     * 查询所有目录
     */
    @Select("SELECT DISTINCT category FROM biz_device WHERE category IS NOT NULL")
    List<String> queryAllCategories();

}
