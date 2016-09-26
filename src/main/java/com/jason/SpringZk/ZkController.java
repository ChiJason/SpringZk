package com.jason.SpringZk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;


public class ZkController extends SelectorComposer<Component> {
	
	private SayHello sayHello;
	@Wire
	private Button add, minus, multiple, divided, result;
	@Wire
	private Label label_1, sayhi;
	@Wire
	private Intbox intbox_1;
	@Wire
	private Window win_1;
	
	private Integer count;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		String id = comp.getId();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		sayHello = (SayHello) context.getBean("sayHello");
		count = sayHello.getCount();
		sayhi.setValue(sayHello.getMessage());
		
	}
	
	@Listen("onClick= #add, #minus, #multiple, #divided, #result, #next")
	public void answer(MouseEvent event){
		
		switch (event.getTarget().getId()) {
		case "add":
			count += intbox_1.getValue();
			intbox_1.setValue(null);
			label_1.setValue(count.toString());

			break;
		case "minus":
			count -= intbox_1.getValue();
			intbox_1.setValue(null);
			label_1.setValue(count.toString());
			
			break;
		case "multiple":
			count *= intbox_1.getValue();
			intbox_1.setValue(null);
			label_1.setValue(count.toString());
			
			break;
		case "divided":
			count /= intbox_1.getValue();
			intbox_1.setValue(null);
			label_1.setValue(count.toString());
			
			break;
		case "result":
			count = 0;
			label_1.setValue(count.toString());
			
		default:
			break;
		}
		
	}

}
