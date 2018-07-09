package po;
//package cn.core.test.dao.po;

import aos.framework.core.typewrap.PO;

/**
 * <b>zhu[zhu]数据持久化对象</b>
 * <p>
 * 注意:此文件由AOS平台自动生成-禁止手工修改。
 * </p>
 * 
 * @author koney
 * @date 2018-05-29 08:52:57
 */
public class ZhuPO extends PO {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String id_;
	
	/**
	 * 名称
	 */
	private String name_;
	
	/**
	 * 年龄
	 */
	private Integer age_;
	
	/**
	 * 性别
	 */
	private String sex_;
	

	/**
	 * ID
	 * 
	 * @return id_
	 */
	public String getId_() {
		return id_;
	}
	
	/**
	 * 名称
	 * 
	 * @return name_
	 */
	public String getName_() {
		return name_;
	}
	
	/**
	 * 年龄
	 * 
	 * @return age_
	 */
	public Integer getAge_() {
		return age_;
	}
	
	/**
	 * 性别
	 * 
	 * @return sex_
	 */
	public String getSex_() {
		return sex_;
	}
	

	/**
	 * ID
	 * 
	 * @param id_
	 */
	public void setId_(String id_) {
		this.id_ = id_;
	}
	
	/**
	 * 名称
	 * 
	 * @param name_
	 */
	public void setName_(String name_) {
		this.name_ = name_;
	}
	
	/**
	 * 年龄
	 * 
	 * @param age_
	 */
	public void setAge_(Integer age_) {
		this.age_ = age_;
	}
	
	/**
	 * 性别
	 * 
	 * @param sex_
	 */
	public void setSex_(String sex_) {
		this.sex_ = sex_;
	}
	

}