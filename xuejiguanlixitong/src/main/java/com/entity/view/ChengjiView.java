package com.entity.view;

import com.entity.ChengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 成绩信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 学科类型的值
		*/
		private String chengjiValue;



		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 院系
			*/
			private Integer yuanxiTypes;
				/**
				* 院系的值
				*/
				private String yuanxiValue;
			/**
			* 政治面貌
			*/
			private Integer zhengzimianmaoTypes;
				/**
				* 政治面貌的值
				*/
				private String zhengzimianmaoValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 学科类型的值
			*/
			public String getChengjiValue() {
				return chengjiValue;
			}
			/**
			* 设置： 学科类型的值
			*/
			public void setChengjiValue(String chengjiValue) {
				this.chengjiValue = chengjiValue;
			}














				//级联表的get和set yonghu

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 院系
					*/
					public Integer getYuanxiTypes() {
						return yuanxiTypes;
					}
					/**
					* 设置： 院系
					*/
					public void setYuanxiTypes(Integer yuanxiTypes) {
						this.yuanxiTypes = yuanxiTypes;
					}


						/**
						* 获取： 院系的值
						*/
						public String getYuanxiValue() {
							return yuanxiValue;
						}
						/**
						* 设置： 院系的值
						*/
						public void setYuanxiValue(String yuanxiValue) {
							this.yuanxiValue = yuanxiValue;
						}

					/**
					* 获取： 政治面貌
					*/
					public Integer getZhengzimianmaoTypes() {
						return zhengzimianmaoTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setZhengzimianmaoTypes(Integer zhengzimianmaoTypes) {
						this.zhengzimianmaoTypes = zhengzimianmaoTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getZhengzimianmaoValue() {
							return zhengzimianmaoValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setZhengzimianmaoValue(String zhengzimianmaoValue) {
							this.zhengzimianmaoValue = zhengzimianmaoValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}


}
