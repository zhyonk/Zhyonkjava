package mvc.zhyonk.action;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import mvc.zhyonk.meta.Bean;
import mvc.zhyonk.meta.Inject;

public class BeanHelper {
	private static final HashMap<Class<?>,Object> beanmap = new HashMap<Class<?>,Object>();
	
	static{
		try {
			//就模拟一下，实现起来太麻烦了。直接给class的地址就好了
			List<Class<?>> classList = ClassHelper.getClassListByAnnotation(Bean.class, "C:/dev/workspace/Eclipseworkspace/zhyonk/bin/mvc/zhyonk/action");
			for (Class<?> class1 : classList) {
				//找着有Bean注解的类
				if(class1.isAnnotationPresent(Bean.class)){
					Object newInstance = class1.newInstance();
					beanmap.put(class1, newInstance);
				}
			}
			
			//遍历beanmap
			for (Entry<Class<?>, Object> class1 : beanmap.entrySet()) {
				Class<?> key = class1.getKey();
				Object value = class1.getValue();
				System.out.println(key);
				System.out.println(key+"..");
				Field[] fields = key.getDeclaredFields();
				Class<?> subclass = null;
				if(fields.length>0){
					for (Field field : fields) {
						System.out.println(key.getName());
						//如果有注入点Inject的注解
						if(field.isAnnotationPresent(Inject.class)){
							//获取Bean字段对应的接口
							Class<?> interfacetype = field.getType();
							String Implpath = "C:/dev/workspace/Eclipseworkspace/zhyonk/bin/mvc/zhyonk/action";
							//获取第一个子类啊
							subclass = ClassHelper.getClassListByInterface(interfacetype,Implpath);
							System.out.println(field);
							
							//如果有@inject注解，获取子类对象的实例
							if(subclass!=null){
								Object object =subclass.newInstance();
								field.setAccessible(true);
								field.set(value,object);
							}
							
						}else{
							System.out.println(key.getSimpleName()+"  里面没有Inject的注解信息");
						}
					}
				}else{
					System.out.println(key.getSimpleName()+"类  里面没有注解信息");
				}

			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HashMap<Class<?>, Object> getBeanmap() {
		return beanmap;
	}
	public static Object getBean(Class<?> clazz) {
		return beanmap.get(clazz);
	}
	
	
}
