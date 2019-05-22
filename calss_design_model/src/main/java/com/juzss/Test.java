package com.juzss;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	private String userName;

	private Test() {
		System.out.println("对象初始化");
	}
	
	//有参构造函数
    private Test(String userName) {
		this.userName = userName;
		System.out.println("username:"+userName);
	}
    
    // 思考:怎么防止被反射  设置成私有的
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// 1.初始化的操作 无参数构造函数
//		UserEntity userEntity = new UserEntity();
//		userEntity.userName = "小马";
//		System.out.println(userEntity.userName);
		
		// 2.通过反射机制去创建对象 类的完整路径
		Class<?> forName = Class.forName("com.juzss.Test");
		// 3.使用反射机制创建对象
//		UserEntity userEntity = (UserEntity) forName.newInstance();
//		userEntity.userName = "反射对象";
//		System.out.println(userEntity.userName);
		// 4.反射应用场景1.jdbc连接、springIOC底层使用反射机制+DOM4J 2.框架Heibernate,mybatis 使用反射机制
		// 5.使用反射机制  获取类的方法信息
//		Method[] methods = forName.getMethods();
//		for (Method method : methods) {
//			System.out.println(method.getName());
//		}
//		// 6.获取类属性
//		Field[] fields = forName.getDeclaredFields();
//		for (Field field : fields) {
//			System.out.println(field.getName());
//		}
		//获取私有的构造函数
		Constructor<?> constructor = forName.getDeclaredConstructor(String.class);
		//允许私有被反射
		//constructor.setAccessible(true);
		Test test = (Test) constructor.newInstance("牛逼");
		System.out.println(test.userName);
	}
}
