
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
 * 课程信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kechng")
public class KechngController {
    private static final Logger logger = LoggerFactory.getLogger(KechngController.class);

    @Autowired
    private KechngService kechngService;


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
        PageUtils page = kechngService.queryPage(params);

        //字典表数据转换
        List<KechngView> list =(List<KechngView>)page.getList();
        for(KechngView c:list){
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
        KechngEntity kechng = kechngService.selectById(id);
        if(kechng !=null){
            //entity转view
            KechngView view = new KechngView();
            BeanUtils.copyProperties( kechng , view );//把实体数据重构到view中

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
    public R save(@RequestBody KechngEntity kechng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kechng:{}",this.getClass().getName(),kechng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KechngEntity> queryWrapper = new EntityWrapper<KechngEntity>()
            .eq("kechng_name", kechng.getKechngName())
            .eq("kechng_types", kechng.getKechngTypes())
            .eq("kechng_address", kechng.getKechngAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechngEntity kechngEntity = kechngService.selectOne(queryWrapper);
        if(kechngEntity==null){
            kechng.setCreateTime(new Date());
            kechngService.insert(kechng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KechngEntity kechng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kechng:{}",this.getClass().getName(),kechng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<KechngEntity> queryWrapper = new EntityWrapper<KechngEntity>()
            .notIn("id",kechng.getId())
            .andNew()
            .eq("kechng_name", kechng.getKechngName())
            .eq("kechng_types", kechng.getKechngTypes())
            .eq("kechng_address", kechng.getKechngAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechngEntity kechngEntity = kechngService.selectOne(queryWrapper);
        if("".equals(kechng.getKechngPhoto()) || "null".equals(kechng.getKechngPhoto())){
                kechng.setKechngPhoto(null);
        }
        if("".equals(kechng.getKechngFile()) || "null".equals(kechng.getKechngFile())){
                kechng.setKechngFile(null);
        }
        if(kechngEntity==null){
            kechngService.updateById(kechng);//根据id更新
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
        kechngService.deleteBatchIds(Arrays.asList(ids));
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
            List<KechngEntity> kechngList = new ArrayList<>();//上传的东西
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
                            KechngEntity kechngEntity = new KechngEntity();
//                            kechngEntity.setKechngName(data.get(0));                    //课程名称 要改的
//                            kechngEntity.setKechngTypes(Integer.valueOf(data.get(0)));   //课程类型 要改的
//                            kechngEntity.setKechngPhoto("");//详情和图片
//                            kechngEntity.setKechngFile(data.get(0));                    //课程文件 要改的
//                            kechngEntity.setKechngAddress(data.get(0));                    //教师 要改的
//                            kechngEntity.setKechngContent("");//详情和图片
//                            kechngEntity.setCreateTime(date);//时间
                            kechngList.add(kechngEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        kechngService.insertBatch(kechngList);
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
