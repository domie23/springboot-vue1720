package com.entity.vo;

import com.entity.DianziwendangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 电子文档
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dianziwendang")
public class DianziwendangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 文档标题
     */

    @TableField(value = "dianziwendang_name")
    private String dianziwendangName;


    /**
     * 文档类型
     */

    @TableField(value = "dianziwendang_types")
    private Integer dianziwendangTypes;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 文档下载
     */

    @TableField(value = "dianziwendang_file")
    private String dianziwendangFile;


    /**
     * 文档详情
     */

    @TableField(value = "dianziwendang_content")
    private String dianziwendangContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：文档标题
	 */
    public String getDianziwendangName() {
        return dianziwendangName;
    }


    /**
	 * 获取：文档标题
	 */

    public void setDianziwendangName(String dianziwendangName) {
        this.dianziwendangName = dianziwendangName;
    }
    /**
	 * 设置：文档类型
	 */
    public Integer getDianziwendangTypes() {
        return dianziwendangTypes;
    }


    /**
	 * 获取：文档类型
	 */

    public void setDianziwendangTypes(Integer dianziwendangTypes) {
        this.dianziwendangTypes = dianziwendangTypes;
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
	 * 设置：文档下载
	 */
    public String getDianziwendangFile() {
        return dianziwendangFile;
    }


    /**
	 * 获取：文档下载
	 */

    public void setDianziwendangFile(String dianziwendangFile) {
        this.dianziwendangFile = dianziwendangFile;
    }
    /**
	 * 设置：文档详情
	 */
    public String getDianziwendangContent() {
        return dianziwendangContent;
    }


    /**
	 * 获取：文档详情
	 */

    public void setDianziwendangContent(String dianziwendangContent) {
        this.dianziwendangContent = dianziwendangContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
