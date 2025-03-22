package com.entity.vo;

import com.entity.KechngEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课程信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kechng")
public class KechngVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课程名称
     */

    @TableField(value = "kechng_name")
    private String kechngName;


    /**
     * 课程类型
     */

    @TableField(value = "kechng_types")
    private Integer kechngTypes;


    /**
     * 课程封面
     */

    @TableField(value = "kechng_photo")
    private String kechngPhoto;


    /**
     * 课程文件
     */

    @TableField(value = "kechng_file")
    private String kechngFile;


    /**
     * 教师
     */

    @TableField(value = "kechng_address")
    private String kechngAddress;


    /**
     * 课程详情
     */

    @TableField(value = "kechng_content")
    private String kechngContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：课程名称
	 */
    public String getKechngName() {
        return kechngName;
    }


    /**
	 * 获取：课程名称
	 */

    public void setKechngName(String kechngName) {
        this.kechngName = kechngName;
    }
    /**
	 * 设置：课程类型
	 */
    public Integer getKechngTypes() {
        return kechngTypes;
    }


    /**
	 * 获取：课程类型
	 */

    public void setKechngTypes(Integer kechngTypes) {
        this.kechngTypes = kechngTypes;
    }
    /**
	 * 设置：课程封面
	 */
    public String getKechngPhoto() {
        return kechngPhoto;
    }


    /**
	 * 获取：课程封面
	 */

    public void setKechngPhoto(String kechngPhoto) {
        this.kechngPhoto = kechngPhoto;
    }
    /**
	 * 设置：课程文件
	 */
    public String getKechngFile() {
        return kechngFile;
    }


    /**
	 * 获取：课程文件
	 */

    public void setKechngFile(String kechngFile) {
        this.kechngFile = kechngFile;
    }
    /**
	 * 设置：教师
	 */
    public String getKechngAddress() {
        return kechngAddress;
    }


    /**
	 * 获取：教师
	 */

    public void setKechngAddress(String kechngAddress) {
        this.kechngAddress = kechngAddress;
    }
    /**
	 * 设置：课程详情
	 */
    public String getKechngContent() {
        return kechngContent;
    }


    /**
	 * 获取：课程详情
	 */

    public void setKechngContent(String kechngContent) {
        this.kechngContent = kechngContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
