package com.entity.model;

import com.entity.KechngEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课程信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KechngModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private String kechngName;


    /**
     * 课程类型
     */
    private Integer kechngTypes;


    /**
     * 课程封面
     */
    private String kechngPhoto;


    /**
     * 课程文件
     */
    private String kechngFile;


    /**
     * 教师
     */
    private String kechngAddress;


    /**
     * 课程详情
     */
    private String kechngContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：课程名称
	 */
    public String getKechngName() {
        return kechngName;
    }


    /**
	 * 设置：课程名称
	 */
    public void setKechngName(String kechngName) {
        this.kechngName = kechngName;
    }
    /**
	 * 获取：课程类型
	 */
    public Integer getKechngTypes() {
        return kechngTypes;
    }


    /**
	 * 设置：课程类型
	 */
    public void setKechngTypes(Integer kechngTypes) {
        this.kechngTypes = kechngTypes;
    }
    /**
	 * 获取：课程封面
	 */
    public String getKechngPhoto() {
        return kechngPhoto;
    }


    /**
	 * 设置：课程封面
	 */
    public void setKechngPhoto(String kechngPhoto) {
        this.kechngPhoto = kechngPhoto;
    }
    /**
	 * 获取：课程文件
	 */
    public String getKechngFile() {
        return kechngFile;
    }


    /**
	 * 设置：课程文件
	 */
    public void setKechngFile(String kechngFile) {
        this.kechngFile = kechngFile;
    }
    /**
	 * 获取：教师
	 */
    public String getKechngAddress() {
        return kechngAddress;
    }


    /**
	 * 设置：教师
	 */
    public void setKechngAddress(String kechngAddress) {
        this.kechngAddress = kechngAddress;
    }
    /**
	 * 获取：课程详情
	 */
    public String getKechngContent() {
        return kechngContent;
    }


    /**
	 * 设置：课程详情
	 */
    public void setKechngContent(String kechngContent) {
        this.kechngContent = kechngContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
