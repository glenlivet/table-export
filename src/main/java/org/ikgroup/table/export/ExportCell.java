package org.ikgroup.table.export;

/**
 * 导出单元格
 * 
 * @author Glenlivet Kikyou
 *
 */
public class ExportCell implements Comparable<ExportCell>{
	
	/**
	 * 导出值
	 */
	private String value;
	
	/**
	 * 是否为头
	 */
	private boolean head;
	
	/**
	 * 导出顺序
	 */
	private int order;
	
	public ExportCell(String value, boolean head, int order) {
		this.value = value;
		this.head = head;
		this.order = order;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isHead() {
		return head;
	}

	public void setHead(boolean head) {
		this.head = head;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int compareTo(ExportCell o) {
		
		return this.order - o.order;
	}

}
