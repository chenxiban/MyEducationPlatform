package com.cxb.cyj.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.UUID;
import org.junit.Test;
import com.cxb.cyj.entity.FileSlice;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 操作Properties文件的工具类
 * @author 	MaShuai
 * @date	2018-12-18
 * 注意:每个流使用完毕都要关闭掉,此类中有所省略
 * 如果流没有关闭,删除文件才会返回false
 */
public class PropUtil {
	
	//文件上传准备文件,属性值;属性是文件名称.文件大小[.文件最后修改时间]=值是文件的uuid唯一标志存盘存储文件名称
	private static final String FILEPREFIX = "D:\\fileUpload\\";//文件目录
	private static final String FILEPATH = "fileslice.properties";
	private static  ObjectMapper objectMapper = new ObjectMapper();//Jackson
	
	
	/**
	 * 上传之前获取(fileslice.properties)Properties文件对象
	 * @return
	 * @throws IOException 
	 */
	private static Properties getProp() {
		Properties properties = new Properties();
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(FILEPATH);//它取的是classepath:下的文件
		try {
			InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
			properties.load(reader);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		return properties;
	}
	
	/**
	 * 断点续传根据文件唯一标志获取Properties文件对象
	 * @param uuid 即 fid
	 * @return 有文件则返回文件,无文件则返回null
	 */
	private static Properties getProp(String uuid) {
		
//		String uuidFile =  uuid+".properties";
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(FILEPATH);//它取的是classepath:下的文件
		System.out.println("inputStream=>"+inputStream);//uuid.properties文件不存在则会输出null
		if(inputStream == null)return null;
		Properties properties = new Properties();
		try {
			InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
			properties.load(reader);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	/**
	 * 根据文件信息获取文件UUID
	 * @param fileName
	 * @param totalSize
	 * @return
	 */
	public static String queryUUIDbyFileinfo(String fileName,Long totalSize) {
		String key = fileName+"."+totalSize;
		Properties prop = getProp();//获取fileslice.properties
		return prop.getProperty(key);//如果取不到则返回null
	}
	
	
	/**
	 * 断点续传根据文件唯一标志获取Properties文件对象
	 * @param uuid 即 fid
	 * @return 有文件则返回文件,无文件则返回null
	 */
	private static Properties getUuidProp(String uuid) {
		
		String uuidFile =  uuid+".properties";
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(uuidFile);//它取的是classepath:下的文件
		System.out.println("inputStream=>"+inputStream);//uuid.properties文件不存在则会输出null
		if(inputStream == null)return null;
		Properties properties = new Properties();
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(inputStream, "UTF-8");
			properties.load(reader);
			String fileSliceStr = properties.getProperty(uuid);
			System.out.println("PropUtil.getProp(String) fileSliceStr=>"+fileSliceStr);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return properties;
	}
	/**
	 * 根据文件的UUID获取文件上传的状态信息
	 * @param uuid
	 * @return
	 */
	public static FileSlice queryFileSliceByFid(String uuid) {
		System.out.println("根据文件的UUID获取文件上传的状态信息 uuid=>"+uuid);
		FileSlice fileSlice = null;
//		String uuid = fileSlice.getFid();
		Properties prop = getUuidProp(uuid);//获取uuid的文件状态信息
		System.out.println("根据文件的UUID获取"+prop.values());
		String fileSliceStr = prop.getProperty(uuid);
		System.out.println("PropUtil.queryFileSliceByFid(String) fileSliceStr=>"+fileSliceStr);
		if(fileSliceStr == null || fileSliceStr == "")return fileSlice;//断点续传记录找不到.
		try {
			fileSlice = objectMapper.readValue(fileSliceStr, FileSlice.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileSlice;
	}
	
	/**
	 * 根据文件信息,删除文件的UUID;并删除记录在fileslice.properties文件
	 * @param fileName
	 * @param totalSize
	 * @return UUID
	 */
	public static String deleteUUIDbyFileinfo(String fileName,Long totalSize) {
		String key = fileName+"."+totalSize;//键值
//		String value = UUID.randomUUID().toString().replace("-", "");//生成唯一不重复的32位uuid字符串,例如 66377a7daf914f17ba4ed9e7147a0a53
		try {
			deleteFileSliceByFileInfo(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return key;
	}
	
	/**
	 * 删除文件传输记录
	 * 修改fileslice.properties文件
	 * @throws IOException
	 */
	private static void deleteFileSliceByFileInfo(String key) throws IOException{
		Properties properties = new Properties();
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即  target/classes
		InputStream inputStream = PropUtil.class.getClassLoader().getResourceAsStream(FILEPATH);
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		
//		String clapath = this.getClass().getResource("").toString();
		String clapath = PropUtil.class.getResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/com/ysd/
		System.out.println("clapath => "+clapath);
		
		String classpath = ClassLoader.getSystemResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/
		System.out.println("classpath => "+classpath);
		
		// file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/../../
		//去掉文件路径其前面   file:/
		classpath = classpath.replaceAll("file:/", "");
//		classpath = classpath.replaceAll("%20", " ");
		System.out.println("去掉文件路径其前面   file:/ classpath => "+classpath);
		
		String realPath = classpath+FILEPATH;//文件的真实路径
		
		
		properties.load(reader);
		/*
		System.out.println("test2  name => "+properties.getProperty("name"));
		System.out.println("test2  age => "+properties.getProperty("age"));
		System.out.println("test2  sex => "+properties.getProperty("sex"));*/
		
		System.out.println("修改文件-------------- "+realPath);
		File file = new File(realPath);
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream,Charset.defaultCharset());//UTF-8
		
//		properties.put(key, value);
		properties.remove(key);
//		properties.put("age", "88");
		properties.store(writer, "我是Properties文件头注释信息");
		reader.close();
		inputStream.close();
		writer.flush();
		writer.close();
		outputStream.close();
		
		System.out.println("fileslice.properties文件删除<<  "+key+"  >>成功---------------------------");
//		properties = new Properties();
//		filePath = "maindata.properties";	//src 下 文件路径
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即   WEB-INF/classes
//		inputStream = this.getClass().getClassLoader().getResourceAsStream(FILEPATH);

		
		
	}
	
	/**
	 * 根据文件信息,生成文件的UUID;并记录在fileslice.properties文件
	 * @param fileName
	 * @param totalSize
	 * @return UUID
	 */
	public static String createUUIDbyFileinfo(String fileName,Long totalSize) {
		String key = fileName+"."+totalSize;//键值
		String value = UUID.randomUUID().toString().replace("-", "");//生成唯一不重复的32位uuid字符串,例如 66377a7daf914f17ba4ed9e7147a0a53
		try {
			updateFileSlice(key, value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return value;
	}
	
	/**
	 * 修改fileslice.properties文件
	 * @throws IOException
	 */
	@Test
	private static void updateFileSlice(String key,String value) throws IOException{
		Properties properties = new Properties();
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即  target/classes
		InputStream inputStream = PropUtil.class.getClassLoader().getResourceAsStream(FILEPATH);
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		
//		String clapath = this.getClass().getResource("").toString();
		String clapath = PropUtil.class.getResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/com/ysd/
		System.out.println("clapath => "+clapath);
		
		String classpath = ClassLoader.getSystemResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/
		System.out.println("classpath => "+classpath);
		
		// file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/../../
		//去掉文件路径其前面   file:/
		classpath = classpath.replaceAll("file:/", "");
//		classpath = classpath.replaceAll("%20", " ");
		System.out.println("去掉文件路径其前面   file:/ classpath => "+classpath);
		
		String realPath = classpath+FILEPATH;//文件的真实路径
		
		
		properties.load(reader);
		/*System.out.println("test2  name => "+properties.getProperty("name"));
		System.out.println("test2  age => "+properties.getProperty("age"));
		System.out.println("test2  sex => "+properties.getProperty("sex"));*/
		
		System.out.println("修改文件-------------- "+realPath);
		File file = new File(realPath);
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream,Charset.defaultCharset());//UTF-8
		
		properties.put(key, value);
//		properties.put("age", "88");
		properties.store(writer, "我是Properties文件头注释信息");
		
		writer.flush();
		writer.close();
		outputStream.close();
		
		System.out.println("fileslice.properties文件修改成功---------------------------");
		properties = new Properties();
//		filePath = "maindata.properties";	//src 下 文件路径
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即   WEB-INF/classes
//		inputStream = this.getClass().getClassLoader().getResourceAsStream(FILEPATH);

		
		
	}
	
	/**
	 * 创建文件上传状态FileSlice
	 * @param fileSlice
	 * @return
	 */
	public static FileSlice createFileSlice(FileSlice fileSlice) {
		String uuid = fileSlice.getFid();
		String value = null;
		try {
			value = objectMapper.writeValueAsString(fileSlice);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			createUuidProperties(uuid, uuid, value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileSlice;
	}
	/**
	 * 修改文件上传状态FileSlice
	 * @param fileSlice
	 * @return
	 */
	public static FileSlice updateFileSlice(FileSlice fileSlice) {
		String uuid = fileSlice.getFid();
		String value = null;
		try {
			value = objectMapper.writeValueAsString(fileSlice);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			updateUuidProperties(uuid, uuid, value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileSlice;
	}
	
	/**
	 * 创建uuid.properties文件
	 * 文件中存储的是uuid对应的文件上传状态信息
	 * @throws IOException
	 */
	@Test
	private static void createUuidProperties(String uuid,String key,String value) throws IOException{
		String uuidFile =  uuid+".properties";
		Properties properties = new Properties();
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即  target/classes
//		InputStream inputStream = PropUtil.class.getClassLoader().getResourceAsStream(uuidFile);
//		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		
//		String clapath = this.getClass().getResource("").toString();
		String clapath = PropUtil.class.getResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/com/ysd/
		System.out.println("clapath => "+clapath);
		
		String classpath = ClassLoader.getSystemResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/
		System.out.println("classpath => "+classpath);
		
		// file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/../../
		//去掉文件路径其前面   file:/
		classpath = classpath.replaceAll("file:/", "");
//		classpath = classpath.replaceAll("%20", " ");
		System.out.println("创建uuid.properties文件 去掉文件路径其前面   file:/ classpath => "+classpath);
		
		String realPath = classpath+uuidFile;//文件的真实路径
		
		
//		properties.load(reader);
//		System.out.println("test2  name => "+properties.getProperty("name"));
//		System.out.println("test2  age => "+properties.getProperty("age"));
//		System.out.println("test2  sex => "+properties.getProperty("sex"));
		
		System.out.println("创建文件-------------- "+realPath);
		File file = new File(realPath);
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream,Charset.defaultCharset());//UTF-8
		
		properties.put(key, value);
//		properties.put("age", "88");
		properties.store(writer, "我是Properties文件头注释信息");
		
		writer.flush();
		writer.close();
		outputStream.close();
		
		System.out.println(uuid+".properties文件创建成功---------------------------记录信息"+value);
//		properties = new Properties();
//		filePath = "maindata.properties";	//src 下 文件路径
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即   WEB-INF/classes
//		inputStream = this.getClass().getClassLoader().getResourceAsStream(uuidFile);

	}
	
	
	/**
	 * 修改uuid.properties文件
	 * 文件中存储的是uuid对应的文件上传状态信息
	 * @throws IOException
	 */
	@Test
	private static void updateUuidProperties(String uuid,String key,String value) throws IOException{
		String uuidFile =  uuid+".properties";
		Properties properties = new Properties();
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即  target/classes
		InputStream inputStream = PropUtil.class.getClassLoader().getResourceAsStream(uuidFile);
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		
//		String clapath = this.getClass().getResource("").toString();
		String clapath = PropUtil.class.getResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/com/ysd/
		System.out.println("clapath => "+clapath);
		
		String classpath = ClassLoader.getSystemResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/
		System.out.println("classpath => "+classpath);
		
		// file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/../../
		//去掉文件路径其前面   file:/
		classpath = classpath.replaceAll("file:/", "");
//		classpath = classpath.replaceAll("%20", " ");
		System.out.println("去掉文件路径其前面   file:/ classpath => "+classpath);
		
		String realPath = classpath+uuidFile;//文件的真实路径
		
		
		properties.load(reader);
		/*System.out.println("test2  name => "+properties.getProperty("name"));
		System.out.println("test2  age => "+properties.getProperty("age"));
		System.out.println("test2  sex => "+properties.getProperty("sex"));*/
		
		System.out.println("修改文件-------------- "+realPath);
		File file = new File(realPath);
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream,Charset.defaultCharset());//UTF-8
		
		properties.put(key, value);
//		properties.put("age", "88");
		properties.store(writer, "我是Properties文件头注释信息");
		
		reader.close();
		writer.flush();
		writer.close();
		outputStream.close();
		
		System.out.println("fileslice.properties文件修改成功---------------------------");
//		properties = new Properties();
//		filePath = "maindata.properties";	//src 下 文件路径
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即   WEB-INF/classes
//		inputStream = this.getClass().getClassLoader().getResourceAsStream(uuidFile);

	}
	/**
	 * 删除uuid.properties文件
	 * 文件中存储的是uuid对应的文件上传状态信息
	 * 当文件上传成功时,不需要uuid.properite文件记录上传的状态信息了
	 * @param uuid
	 */
	public static Boolean deleteFileSlice(String uuid) {
		String uuidFile =  uuid+".properties";
//		ClassLoader classLoader = this.getClass().getClassLoader();//它取的是classepath:下的文件  即  target/classes
		//		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(uuidFile);
		//		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		
		//		String clapath = this.getClass().getResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/com/ysd/
		//		System.out.println("clapath => "+clapath);
		
		String classpath = ClassLoader.getSystemResource("").toString();
		//file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/
		System.out.println("classpath => "+classpath);
		
		// file:/D:/Workspace8.6/FileData/WebRoot/WEB-INF/classes/../../
		//去掉文件路径其前面   file:/
		classpath = classpath.replaceAll("file:/", "");
//		classpath = classpath.replaceAll("%20", " ");
		System.out.println("去掉文件路径其前面   file:/ classpath => "+classpath);
		
		String realPath = classpath+uuidFile;//文件的真实路径
		
		
		System.out.println("删除文件-------------- "+realPath);
		File file = new File(realPath);
		Boolean boo = true;
		if(file.exists()) {
			
			boo = file.delete();
			System.out.println("删除文件["+boo+"],文件存在删除成功-------------- "+realPath);
			return boo;
		}else {
			System.out.println("删除文件,文件不存在-------------- "+realPath);
			return boo;
		}
		//		OutputStream outputStream = new FileOutputStream(file);
		//		OutputStreamWriter writer = new OutputStreamWriter(outputStream,Charset.defaultCharset());//UTF-8
		
		//		properties.put(key, value);
//		properties.put("age", "88");
//		properties.store(writer, "我是Properties文件头注释信息");
		
		//		writer.flush();
		//		writer.close();
		//		outputStream.close();
	}
	
	

}
