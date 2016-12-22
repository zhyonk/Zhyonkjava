package mvc.zhyonk;

public class StringUtil {

	public static String getFullName(String absolutePath) {
//		System.out.println(absolutePath);
		String[] split = absolutePath.split("bin");
		String string = split[1].substring(1).replaceAll("\\\\", ".");
		String fullName = string.substring(0, string.length()-6);
		return fullName;
	}
	
}
