package mvc.zhyonk.action;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import mvc.zhyonk.StringUtil;
import mvc.zhyonk.meta.Bean;

public class ClassHelper {
	/**
	 * 根据注解类在指定目录获取有该注解的类
	 * @param class1
	 * @param classPath
	 * @return
	 */
	public static List<Class<?>> getClassListByAnnotation(Class<Bean> class1,String classPath) {
		//获取了classPath目录下的所有的后缀为.class的文件
		File[] listFile = scanClassFile(classPath);
		List<Class<?>> allClassFile = null;
		try {
			allClassFile = getAllClassFile(listFile);
		} catch (ClassNotFoundException e) {
			System.out.println("类没有找到哦");
			e.printStackTrace();
		}
		
		return allClassFile;
	}
	/**
	 * 获取目录下所有的子类
	 * @param listFile
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> getAllClassFile(File[] listFile) throws ClassNotFoundException {
		List<Class<?>> list = new ArrayList<>();
		for (File classfile : listFile) {
			String fullName = StringUtil.getFullName(classfile.getAbsolutePath());
			list.add(Class.forName(fullName));
		}
		return list;
		
	}
	/**
	 * 应该是先扫描在web.xml中配置的信息,就是扫描那个注解的包是哪几个。是否启用注解包
	 * @param classPath
	 */
	private static File[] scanClassFile(String classPath) {
		if(classPath==null || classPath==""){
			System.out.println("路径不能为空");
			return null;
		}
		File file = new File(classPath);
		if(!file.exists()){
			System.out.println("目录不存在");
			return null;
		}
		//获取后缀为.class的文件
		File[] listFiles = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".class")){
					return true;
				}
				return false;
			}
		});
		if(listFiles.length>0){
			return listFiles;
		}else{
			return null;
		}
	}
	/**
	 * 根据接口获取该接口的子类
	 * @param interfacetype
	 */
	public static Class<?> getClassListByInterface(Class<?> interfacetype,String ImplPath) {
		List<Class<?>> list1 = new ArrayList<Class<?>>();
		File[] scanClassFile = scanClassFile(ImplPath);
		//这样比较麻烦，但就先这样吧
		List<Class<?>> allClassFile = null;
		try {
			allClassFile = getAllClassFile(scanClassFile);
		} catch (ClassNotFoundException e) {
			System.out.println("找实现子类的时候在目录下没有找到类哦");
			e.printStackTrace();
		}
		//遍历指定目录下的所有的类
		for (Class<?> class1 : allClassFile) {
			Class<?>[] interfaces = class1.getInterfaces();
			String supername = interfacetype.getName();
			//遍历类所有的父类
			for (Class<?> superclass : interfaces) {
				//判断父类有没有interfacetype类型的
				if(superclass.getName().equals(supername)){
					//添加子类的到list中
					list1.add(class1);
//					System.out.println("...");
				}
//				System.out.println("父类"+superclass.hashCode());
//				System.out.println("父类2"+interfacetype.hashCode());
			}
		}
		
		//判断有几个子类，就先返回第一个子类吧
		//如果子类数量大于1个
		if(list1.size()>1){
			System.out.println("抱歉目前只支持返回一个子类");
			return list1.get(0);
		}else{
			return list1.get(0);
		}
	}
	
}
