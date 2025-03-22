package com.entity.model;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 成绩信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 成绩标题
     */
    private String chengjiName;


    /**
     * 学科类型
     */
    private Integer chengjiTypes;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 成绩
     */
    private Integer chengji;


    /**
     * 成绩下载
     */
    private String chengjiFile;


    /**
     * 成绩详情
     */
    private String chengjiContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：成绩标题
	 */
    public String getChengjiName() {
        return chengjiName;
    }


    /**
	 * 设置：成绩标题
	 */
    public void setChengjiName(String chengjiName) {
        this.chengjiName = chengjiName;
    }
    /**
	 * 获取：学科类型
	 */
    public Integer getChengjiTypes() {
        return chengjiTypes;
    }


    /**
	 * 设置：学科类型
	 */
    public void setChengjiTypes(Integer chengjiTypes) {
        this.chengjiTypes = chengjiTypes;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：成绩
	 */
    public Integer getChengji() {
        return chengji;
    }


    /**
	 * 设置：成绩
	 */
    public void setChengji(Integer chengji) {
        this.chengji = chengji;
    }
    /**
	 * 获取：成绩下载
	 */
    public String getChengjiFile() {
        return chengjiFile;
    }


    /**
	 * 设置：成绩下载
	 */
    public void setChengjiFile(String chengjiFile) {
        this.chengjiFile = chengjiFile;
    }
    /**
	 * 获取：成绩详情
	 */
    public String getChengjiContent() {
        return chengjiContent;
    }


    /**
	 * 设置：成绩详情
	 */
    public void setChengjiContent(String chengjiContent) {
        this.chengjiContent = chengjiContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
