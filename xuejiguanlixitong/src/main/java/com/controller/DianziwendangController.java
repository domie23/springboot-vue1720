
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 电子文档
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dianziwendang")
public class DianziwendangController {
    private static final Logger logger = LoggerFactory.getLogger(DianziwendangController.class);

    @Autowired
    private DianziwendangService dianziwendangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = dianziwendangService.queryPage(params);

        //字典表数据转换
        List<DianziwendangView> list =(List<DianziwendangView>)page.getList();
        for(DianziwendangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DianziwendangEntity dianziwendang = dianziwendangService.selectById(id);
        if(dianziwendang !=null){
            //entity转view
            DianziwendangView view = new DianziwendangView();
            BeanUtils.copyProperties( dianziwendang , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(dianziwendang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DianziwendangEntity dianziwendang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dianziwendang:{}",this.getClass().getName(),dianziwendang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            dianziwendang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DianziwendangEntity> queryWrapper = new EntityWrapper<DianziwendangEntity>()
            .eq("dianziwendang_name", dianziwendang.getDianziwendangName())
            .eq("dianziwendang_types", dianziwendang.getDianziwendangTypes())
            .eq("yonghu_id", dianziwendang.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianziwendangEntity dianziwendangEntity = dianziwendangService.selectOne(queryWrapper);
        if(dianziwendangEntity==null){
            dianziwendang.setCreateTime(new Date());
            dianziwendangService.insert(dianziwendang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianziwendangEntity dianziwendang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dianziwendang:{}",this.getClass().getName(),dianziwendang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            dianziwendang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DianziwendangEntity> queryWrapper = new EntityWrapper<DianziwendangEntity>()
            .notIn("id",dianziwendang.getId())
            .andNew()
            .eq("dianziwendang_name", dianziwendang.getDianziwendangName())
            .eq("dianziwendang_types", dianziwendang.getDianziwendangTypes())
            .eq("yonghu_id", dianziwendang.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianziwendangEntity dianziwendangEntity = dianziwendangService.selectOne(queryWrapper);
        if("".equals(dianziwendang.getDianziwendangFile()) || "null".equals(dianziwendang.getDianziwendangFile())){
                dianziwendang.setDianziwendangFile(null);
        }
        if(dianziwendangEntity==null){
            dianziwendangService.updateById(dianziwendang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        dianziwendangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DianziwendangEntity> dianziwendangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DianziwendangEntity dianziwendangEntity = new DianziwendangEntity();
//                            dianziwendangEntity.setDianziwendangName(data.get(0));                    //文档标题 要改的
//                            dianziwendangEntity.setDianziwendangTypes(Integer.valueOf(data.get(0)));   //文档类型 要改的
//                            dianziwendangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            dianziwendangEntity.setDianziwendangFile(data.get(0));                    //文档下载 要改的
//                            dianziwendangEntity.setDianziwendangContent("");//详情和图片
//                            dianziwendangEntity.setCreateTime(date);//时间
                            dianziwendangList.add(dianziwendangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        dianziwendangService.insertBatch(dianziwendangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
