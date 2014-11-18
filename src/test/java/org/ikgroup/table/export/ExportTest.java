package org.ikgroup.table.export;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExportTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void prepare() {
		context = new ClassPathXmlApplicationContext("app-context.xml");
	}

	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		List<BusinessObj> set = new ArrayList<BusinessObj>();
		set.add(new BusinessObj(0, "strVal0", new BigDecimal(0.123).setScale(2,
				BigDecimal.ROUND_FLOOR)));
		set.add(new BusinessObj(1, "strVal1", new BigDecimal(1.123).setScale(2,
				BigDecimal.ROUND_FLOOR)));
		set.add(new BusinessObj(2, "strVal2", new BigDecimal(2.123).setScale(2,
				BigDecimal.ROUND_FLOOR)));

		// 打印HEAD
		Set<ExportCell> heads = new TreeSet<ExportCell>();
		Method[] ms = BusinessObj.class.getMethods();
		List<Method> ml = new ArrayList<Method>();
		for (Method m : ms) {
			Export e = m.getAnnotation(Export.class);
			if (m.getAnnotation(Export.class) != null) {
				ExportCell h = new ExportCell(e.label(), true, e.order());
				heads.add(h);
				ml.add(m);
			}
		}
		for (ExportCell h : heads) {
			System.out.print(h.getValue() + "  ");
		}
		System.out.println();

		for (BusinessObj bo : set) {
			Set<ExportCell> cellSet = new TreeSet<ExportCell>();
			for (Method m : ml) {
				Export e = m.getAnnotation(Export.class);
				if (e.transformer().equals(Export.TRANSFORMER_NONE)) {
					String value = m.invoke(bo).toString();
					ExportCell cell = new ExportCell(value, false, e.order());
					cellSet.add(cell);
				} else {
					Transformer t = context.getBean(e.transformer(), Transformer.class);
					String value = t.tranform(m.invoke(bo));
					ExportCell cell = new ExportCell(value, false, e.order());
					cellSet.add(cell);
				}
			}
			for (ExportCell c : cellSet) {
				System.out.print(c.getValue() + " ");
			}
			System.out.println();
		}

	}

}
