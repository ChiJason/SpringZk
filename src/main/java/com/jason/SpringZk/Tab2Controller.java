package com.jason.SpringZk;

import java.io.File;

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
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Tab2Controller extends SelectorComposer<Component>{
	
	private Tab2 mytab2;
	@Wire
	private Label l1;
	@Wire
	private Calendar cal;
	@Wire
	private Hlayout h1;
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
		
		for (Users aUsers : mytab2.getUsersArray()) {
			Listitem listitem = new Listitem();
			new Listcell(aUsers.getName()).setParent(listitem);
			new Listcell(aUsers.getAge().toString()).setParent(listitem);
			listitem.setParent(mylb);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		Tab2 myTab2 = mapper.readValue(new File("C:/Users/JasonChi/Desktop/sayhello.json"), Tab2.class);
		
		System.out.println(myTab2.getTb2Message() + "\n" +
							myTab2.getUsersArray());
	}
}
