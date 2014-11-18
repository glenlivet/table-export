package org.ikgroup.table.export;

/**
 * 将一个数值转换为另外一个数值。大部分用于DICT KEY VALUE转换。
 * 
 * @author Glenlivet Kikyou
 *
 */
public interface Transformer {
	
	public String tranform(Object o);

}
