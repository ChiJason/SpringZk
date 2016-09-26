package com.jason.SpringZk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Calendar;
import org.zkoss.zul.Label;

public class Tab2Controller extends SelectorComposer<Component>{
	
	private Tab2 mytab2;
	@Wire
	private Label l1;
	@Wire
	private Calendar cal;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		mytab2 = (Tab2) context.getBean("bean1");
		
		l1.setValue(mytab2.getDate().toString());
		
		cal.setWeekOfYear(true);
		
	}
}
