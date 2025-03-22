package com.dao;

import com.entity.DianziwendangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DianziwendangView;

/**
 * 电子文档 Dao 接口
 *
 * @author 
 */
public interface DianziwendangDao extends BaseMapper<DianziwendangEntity> {

   List<DianziwendangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
