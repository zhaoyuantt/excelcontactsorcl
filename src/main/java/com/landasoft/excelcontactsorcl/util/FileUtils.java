package com.landasoft.excelcontactsorcl.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 文件工具类
 * @author zhaoyuan
 * @date 2020,May 23 10:32 pm
 */
public class FileUtils {

    /**
     * 将上传的文件拷贝到指定目录
     * @param multipartFile
     * @param filePath
     * @throws IOException
     * @return 拷贝的文件路径
     */
    public static String copyFile(MultipartFile multipartFile,String filePath) throws IOException {
        //原始文件名
        String filename = multipartFile.getOriginalFilename();

        String suffix=filename.substring(filename.lastIndexOf("."));

        String newFilename = IDUtils.genImageName()+suffix;

        File file = new File(filePath);

        if(!file.exists()) {
            file.mkdir();
        }

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file.getPath()+"\\"+newFilename);

            inputStream = multipartFile.getInputStream();

            int b = 0;

            while((b=inputStream.read())!=-1){ //读取文件
                outputStream.write(b);
            }

            outputStream.flush();

        } finally {
            if(null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return newFilename;
    }
}
