package org.ikgroup.table.export;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出标签
 * 
 * @author Glenlivet Kikyou
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Export {
	
	public static final String TRANSFORMER_NONE = "NONE";
	
	/**
	 * 导出列头
	 * 
	 * @return
	 */
	String label();		//导出列头
	
	/**
	 * 导出顺序 不可相同
	 * 
	 * @return
	 */
	int order();	//导出排序
	
	/**
	 * 转换类。依赖SPRING框架。参加{@link Transformer}。
	 * 
	 * @return	转换类的SPRING BEAN ID。
	 */
	String transformer() default TRANSFORMER_NONE;
}
