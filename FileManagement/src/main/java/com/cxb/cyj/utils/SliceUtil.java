package com.cxb.cyj.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import com.cxb.cyj.entity.FileSlice;
/**
 * 分片上传文件的工具类
 * @author 	MaShuai
 * @date	2018-12-18
 */
public class SliceUtil {
	
	/**
	 * 分片写文件
	 * 把新传输的文件字节数据追加到断点文件字节之后
	 * @param slice
	 * @param sliceData
	 * @return 写入数据之后,更新之后的文件传输状态,主要更新了断点
	 */
	public static FileSlice writeSlice(FileSlice slice,byte[] sliceData) {
		String fileName = slice.getName();//原始文件名称
		String fileSuffix  = fileName.substring(fileName.lastIndexOf("."));//获取文件后缀名称
		String fileNameEnd = "D:\\fileUpload\\"+slice.getFid()+fileSuffix;
		System.out.println("******分片写入"+slice.getFid()+"."+"断点"+slice.getPoint()+"文件的数据大小"+sliceData.length);//1048576 字节= 1M = 1024 * 1024 字节
//		File fileEnd = new File(fileNameEnd);
		
		Long point = slice.getPoint() ;//开始写的断点
//		Long sliceSize = 1204L * 1024L ;//1M = 1204 * 1024;每片字节数,每次读的长度
		
		// 创建输入流关联源,因为要指定位置读和写,所以我们需要用随机访问流
        
		try {
//			RandomAccessFile src = new RandomAccessFile(fileNameSrc, "rw");
			RandomAccessFile desc = new RandomAccessFile(fileNameEnd, "rw");
			System.out.println("分片写入前文件的大小"+desc.length());
	       	 	//开始读写
	       	   //每次读1M = 1024 * 1024 字节
		            int len = 0;
		            long count = 0;	            	
		            			            	
		            	desc.seek(point);//设置写文件指针偏移,即断点
		            	desc.write(sliceData);//本次读到的内容
			System.out.println("分片写入之后文件的大小=>"+desc.length());
			System.out.println("分片写入之后文件的信息FileSlice=>"+slice);
			slice.setPoint(point+sliceData.length);//断点向后移动量就是新写入数据的数据字节大小
			desc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return slice;		
		 
	} 

}
