package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianziwendangEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 电子文档 服务类
 */
public interface DianziwendangService extends IService<DianziwendangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}