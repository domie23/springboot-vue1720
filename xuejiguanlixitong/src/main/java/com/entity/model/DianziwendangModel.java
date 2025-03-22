package com.entity.model;

import com.entity.DianziwendangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 电子文档
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DianziwendangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 文档标题
     */
    private String dianziwendangName;


    /**
     * 文档类型
     */
    private Integer dianziwendangTypes;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 文档下载
     */
    private String dianziwendangFile;


    /**
     * 文档详情
     */
    private String dianziwendangContent;


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
	 * 获取：文档标题
	 */
    public String getDianziwendangName() {
        return dianziwendangName;
    }


    /**
	 * 设置：文档标题
	 */
    public void setDianziwendangName(String dianziwendangName) {
        this.dianziwendangName = dianziwendangName;
    }
    /**
	 * 获取：文档类型
	 */
    public Integer getDianziwendangTypes() {
        return dianziwendangTypes;
    }


    /**
	 * 设置：文档类型
	 */
    public void setDianziwendangTypes(Integer dianziwendangTypes) {
        this.dianziwendangTypes = dianziwendangTypes;
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
	 * 获取：文档下载
	 */
    public String getDianziwendangFile() {
        return dianziwendangFile;
    }


    /**
	 * 设置：文档下载
	 */
    public void setDianziwendangFile(String dianziwendangFile) {
        this.dianziwendangFile = dianziwendangFile;
    }
    /**
	 * 获取：文档详情
	 */
    public String getDianziwendangContent() {
        return dianziwendangContent;
    }


    /**
	 * 设置：文档详情
	 */
    public void setDianziwendangContent(String dianziwendangContent) {
        this.dianziwendangContent = dianziwendangContent;
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
