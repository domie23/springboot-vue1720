package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 成绩信息
 *
 * @author 
 * @email
 */
@TableName("chengji")
public class ChengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengjiEntity() {

	}

	public ChengjiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 成绩标题
     */
    @TableField(value = "chengji_name")

    private String chengjiName;


    /**
     * 学科类型
     */
    @TableField(value = "chengji_types")

    private Integer chengjiTypes;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 成绩
     */
    @TableField(value = "chengji")

    private Integer chengji;


    /**
     * 成绩下载
     */
    @TableField(value = "chengji_file")

    private String chengjiFile;


    /**
     * 成绩详情
     */
    @TableField(value = "chengji_content")

    private String chengjiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：成绩标题
	 */
    public String getChengjiName() {
        return chengjiName;
    }
    /**
	 * 获取：成绩标题
	 */

    public void setChengjiName(String chengjiName) {
        this.chengjiName = chengjiName;
    }
    /**
	 * 设置：学科类型
	 */
    public Integer getChengjiTypes() {
        return chengjiTypes;
    }
    /**
	 * 获取：学科类型
	 */

    public void setChengjiTypes(Integer chengjiTypes) {
        this.chengjiTypes = chengjiTypes;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：成绩
	 */
    public Integer getChengji() {
        return chengji;
    }
    /**
	 * 获取：成绩
	 */

    public void setChengji(Integer chengji) {
        this.chengji = chengji;
    }
    /**
	 * 设置：成绩下载
	 */
    public String getChengjiFile() {
        return chengjiFile;
    }
    /**
	 * 获取：成绩下载
	 */

    public void setChengjiFile(String chengjiFile) {
        this.chengjiFile = chengjiFile;
    }
    /**
	 * 设置：成绩详情
	 */
    public String getChengjiContent() {
        return chengjiContent;
    }
    /**
	 * 获取：成绩详情
	 */

    public void setChengjiContent(String chengjiContent) {
        this.chengjiContent = chengjiContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chengji{" +
            "id=" + id +
            ", chengjiName=" + chengjiName +
            ", chengjiTypes=" + chengjiTypes +
            ", yonghuId=" + yonghuId +
            ", chengji=" + chengji +
            ", chengjiFile=" + chengjiFile +
            ", chengjiContent=" + chengjiContent +
            ", createTime=" + createTime +
        "}";
    }
}
