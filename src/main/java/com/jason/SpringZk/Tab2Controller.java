package com.jason.SpringZk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Calendar;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;


public class Tab2Controller extends SelectorComposer<Component>{
	
	private Tab2 mytab2;
	@Wire
	private Label l1;
	@Wire
	private Calendar cal;
	@Wire
	private Hlayout h1;
	private ListModel<Users> listbox;
	@Wire
	private Listbox mylb;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		mytab2 = (Tab2) context.getBean("bean1");
		
		l1.setValue(mytab2.getDate().toString());
		
		cal.setWeekOfYear(true);
		
		listbox = new ListModelList<Users>(mytab2.getUsersArray());
		
		for (Users aUsers : mytab2.getUsersArray()) {
			System.out.println(aUsers.getName() +" "+ aUsers.getAge());
			
		}
		
	}
}
