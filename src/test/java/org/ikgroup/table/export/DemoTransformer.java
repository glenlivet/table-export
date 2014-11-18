package org.ikgroup.table.export;

import org.springframework.stereotype.Component;


@Component
public class DemoTransformer implements Transformer {

	public String tranform(Object o) {
		int i = Integer.parseInt(o.toString());
		switch (i) {
		case 0:
			return "dict0";
		case 1:
			return "dict1";
		case 2:
			return "dict2";
		default:
			return "dictDefault";
		}
	}

}
