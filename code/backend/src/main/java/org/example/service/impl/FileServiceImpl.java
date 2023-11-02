package org.example.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author hzx
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${server.port}")
    private String port;

    @Value("${file.ip}")
    private String ip;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        // 获取源文件的名称
        String originalFilename = file.getOriginalFilename();
        // 定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        // 获取上传的路径
        String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;
        int lastIndex = originalFilename.lastIndexOf(".");
        if (lastIndex == -1) {
            rootFilePath += ".jpg";
        }
        File rootFile = new File(rootFilePath);
        if (!rootFile.getParentFile().exists()) {
            rootFile.getParentFile().mkdirs();
        }
        // 把文件写入到上传的路径
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        return "/api/files/get/" + flag;
    }

    @Override
    public void downloadFile(String flag, HttpServletResponse response) throws IOException {
        // 新建一个输出流对象
        OutputStream os;
        // 定于文件上传的根路径
        String basePath = System.getProperty("user.dir") + "/files/";
        // 获取所有的文件名称
        List<String> fileNames = FileUtil.listFileNames(basePath);
        // 找到跟参数一致的文件
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        if (StrUtil.isNotEmpty(fileName)) {
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/octet-stream");
            // 通过文件的路径读取文件字节流
            byte[] bytes = FileUtil.readBytes(basePath + fileName);
            // 通过输出流返回文件
            os = response.getOutputStream();
            os.write(bytes);
            os.flush();
            os.close();
        }
    }

    @Override
    public JSON uploadRichText(MultipartFile file) throws IOException {
        // 获取源文件的名称
        String originalFilename = file.getOriginalFilename();
        // 定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        // 获取上传的路径
        String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;
        File rootFile = new File(rootFilePath);
        if (!rootFile.getParentFile().exists()) {
            rootFile.getParentFile().mkdirs();
        }
        // 把文件写入到上传的路径
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        String url = "http://" + ip + ":" + port + "/api/files/get/" + flag;
        JSONObject json = new JSONObject();
        json.set("errno", 0);
        JSONArray arr = new JSONArray();
        JSONObject data = new JSONObject();
        arr.add(data);
        data.set("url", url);
        json.set("data", arr);
        // 返回结果 url
        return json;
    }
}
