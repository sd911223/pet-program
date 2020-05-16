package com.live.util;

import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作
 * @author gql
 *
 */
public class StringUtil {

	private static final Pattern PATTERN_ONE = Pattern.compile("^(\\d{6})(19|20)(\\d{2})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$"); //粗略的校验

	private static final Pattern PATTERN_NAME = Pattern.compile("[\\u4e00-\\u9fa5]+(·[\\u4e00-\\u9fa5]+)*");

	/**
	 * 判断字符串是否为空
	 * @param paramStr 待判断字符串
	 * @return 为空返回true 不为空返回false
	 */
	public static boolean isNull(String paramStr){
		boolean result = false;
		if(paramStr == null || paramStr.isEmpty()){
			result = true;
			return result;
		}
		paramStr = paramStr.trim();
		if("".equals(paramStr) || "null".equals(paramStr) || "NULL".equals(paramStr)){
			result = true;
			return result;
		}
		return result;
	}
	/**
	 * 字符串非空判断
	 * 属于空的：（NULL，‘’， ‘null’,'NULL'）
	 * @param paramStr  待判断的字符串
	 * @return  true：非空，false：空
	 */
	public static boolean isNotNull(String paramStr){
		if(paramStr == null){
			return false;
		}
		if(paramStr.isEmpty()){
			return false;
		}
		paramStr = paramStr.trim();
		if(paramStr.equals("")){
			return false;
		}
		if(paramStr.equals("null")){
			return false;
		}
        return !paramStr.equals("NULL");
    }

	/**
	 * 对字符串进行处理，把'null'、'NULL'处理成''空字符串，非空的字符串会执行trim
	 * @param paramStr  待处理的字符串
	 * @return  处理后的字符串
	 */
	public static String stringNullHandle(String paramStr){
		if(isNotNull(paramStr)){
			return paramStr.trim();
		}else{
			return "";
		}
	}

    /**
     * 处理页面传递的特殊字符，将<>()&;:/\'"替换为" "
     *
     * @param source 处理前的字符串
     * @return 处理后的字符串
     */
    public static String rightfulString(String source) {
        if (source == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            switch (c) {
                case '<':
                    buffer.append(" ");
                    break;
                case '>':
                    buffer.append(" ");
                    break;
                case '(':
                    buffer.append(" ");
                    break;
                case ')':
                    buffer.append(" ");
                    break;
                case '&':
                    buffer.append(" ");
                    break;
                case ':':
                    buffer.append(" ");
                    break;
                case ';':
                    buffer.append(" ");
                    break;
                case '\'':
                    buffer.append(" ");
                    break;
                case '\"':
                    buffer.append(" ");
                    break;
                case '\\':
                    buffer.append(" ");
                    break;
                case '/':
                    buffer.append(" ");
                    break;
                case '*':
                    buffer.append(" ");
                    break;
                default:
                    buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * <pre>
     * 判断是否为空，为空则返回true
     * 为空的条件：null、""、"null"
     * </pre>
     *
     * @param obj
     * @return
     */
    public static boolean isBlank(Object obj) {
        if (obj == null) {
            return true;
        }
        String str = obj.toString().trim();
        return "".equals(str) || "null".equalsIgnoreCase(str);
    }

    /**
     * <pre>
     * 判断是否不为空，不为空则返回true
     * 为空的条件：null、""、"null"
     * </pre>
     *
     * @param obj
     * @return
     */
    public static boolean isNotBlank(Object obj) {
        return !isBlank(obj);
    }
    /**
     * 获取uuid字符串
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取uuid字符串，无横杠
     */
    public static String uuidNotLine() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取字符串存在某个字符的数量
     * @param src 传入字符串
     * @param find 某个字符
     * @return
     */
    public static int getOccur(String src,String find){
        int o = 0;
        int index=-1;
        while((index=src.indexOf(find,index))>-1){
            ++index;
            ++o;
        }
        return o;
    }


    public static String getUrlStr(Map<String, String> map){
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String,String> entry : map.entrySet()) {
            str.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
        }
        return str.toString().substring(0, str.lastIndexOf("&"));
    }
}
