package com.fdc.admin.dvlp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
.'"'.        ___,,,___        .'``.'
: (\  `."'"```         ```"'"-'  /) ;'
 :  \                         `./  .''
 `.                            :.''
   /        _         _        \)
  |         0}       {0         |
  |         /         \         |
  |        /           \        |
  |       /             \       |
   \     |      .-.      |     /
    `.   | . . /   \ . . |   .''
      `-._\.'.(     ).'./_.-''
          `\'  `._.'  '/' 
            `. --'-- .'
             `-...-''
*/

public class TestTemplate {

	public static Object getBean(String beanName) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return context.getBean(beanName);
	}

}
