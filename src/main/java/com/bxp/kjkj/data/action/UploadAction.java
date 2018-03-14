package com.bxp.kjkj.data.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * 单个文件上传
 * 上传文件其实是上传了两份
 *
 * 首先将上传的文件保存到 default.properties 文件中 struts.multipart.saveDir键指定的目录中
 * 默认是空的
 * 保存在  Tomcat 6.0\work\Catalina\localhost\struts2目录下以.tmp后缀名的文件
 *
 * 如果要在 struts.multipart.saveDir 指定目录， 则可以在 src文件夹下 建一个 struts.properties,
 * 覆盖  default.properties 的某些键值
 *
 * 还有一份是 存放在自己设定的目录下
 */
public class UploadAction extends ActionSupport {

//    public UploadEbi uploadEbi;
//    public void setUploadEbi(UploadEbi uploadEbi) {
//        this.uploadEbi = uploadEbi;
//    }

    public String page(){
        return "page";
    }

    private String usename ;
    private File file1 ; //具体上传文件的 引用 , 指向临时目录中的临时文件
    private String file1FileName ;  // 上传文件的名字 ,FileName 固定的写法
    private String file1ContentType ; //上传文件的类型， ContentType 固定的写法

    public String getUsename() {
        return usename;
    }
    public void setUsename(String usename) {
        this.usename = usename;
    }
    public File getFile1() {
        return file1;
    }
    public void setFile1(File file1) {
        this.file1 = file1;
    }
    public String getFile1FileName() {
        return file1FileName;
    }
    public void setFile1FileName(String file1FileName) {
        this.file1FileName = file1FileName;
    }
    public String getFile1ContentType() {
        return file1ContentType;
    }
    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    @Override
    public String execute() throws Exception {
        //获取文件存储路径
        String path = ServletActionContext.getRequest().getRealPath("/upload");
        new File(path).mkdirs();
//        System.out.println("路径           " + path1);

        //输出流
        OutputStream os = new FileOutputStream(new File(path,file1FileName));
        //输入流
        InputStream is = new FileInputStream(file1);

        byte[] buf = new byte[1024];
        int length = 0 ;

        while(-1 != (length = is.read(buf) ) )
        {
            os.write(buf, 0, length) ;
        }
        is.close();
        os.close();

        return "page";
    }



}
