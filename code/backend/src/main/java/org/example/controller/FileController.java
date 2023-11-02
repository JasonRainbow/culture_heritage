package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.demo.common.Result;
import com.example.demo.entity.dto.FileVO;
import com.example.demo.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/api/files")
@Api(tags = "文件上传下载控制器")
public class FileController extends BaseController {
    @Value("${server.port}")
    private String port;

    @Value("${file.ip}")
    private String ip;


    /**
     * 上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件到本地接口")
    public Result upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();  // 获取源文件的名称
        // 定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;  // 获取上传的路径
        int lastIndex = originalFilename.lastIndexOf(".");
        if (lastIndex == -1) {
            rootFilePath += ".jpg";
        }
        File rootFile = new File(rootFilePath);
        if (!rootFile.getParentFile().exists()) {
            rootFile.getParentFile().mkdirs();
        }
        FileUtil.writeBytes(file.getBytes(), rootFilePath);  // 把文件写入到上传的路径
//        return Result.success("http://" + ip + ":" + port + "/api/files/" + flag);  // 返回结果 url
        return Result.success("/api/files/get/" + flag);  // 返回结果 url
    }

    /**
     * 富文本文件上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/editor/upload")
    @ApiOperation(value = "富文本文件上传接口")
    public JSON editorUpload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();  // 获取源文件的名称
        // 定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;  // 获取上传的路径
        File rootFile = new File(rootFilePath);
        if (!rootFile.getParentFile().exists()) {
            rootFile.getParentFile().mkdirs();
        }
        FileUtil.writeBytes(file.getBytes(), rootFilePath);  // 把文件写入到上传的路径
        String url = "http://" + ip + ":" + port + "/files/" + flag;
        JSONObject json = new JSONObject();
        json.set("errno", 0);
        JSONArray arr = new JSONArray();
        JSONObject data = new JSONObject();
        arr.add(data);
        data.set("url", url);
        json.set("data", arr);
        return json;  // 返回结果 url
    }

    /**
     * 下载接口
     * @param flag
     * @param response
     */
    @GetMapping("/get/{flag}")
    @ApiOperation(value = "文件下载接口")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/files/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }

    /**
     * OSS文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload/oss")
    @ApiOperation(value = "上传文件到OSS接口")
    public Result ossUpload(MultipartFile file) {
        return Result.success(AliOssUtil.upload("images/", file));  // 返回结果 url
    }

    /**
     * OSS文件删除
     * @param fileVO 文件存储路径
     * @return
     */
    @DeleteMapping("/delete/oss")
    @ApiOperation(value = "从OSS删除文件接口")
    public Result ossUpload(@RequestBody FileVO fileVO) {
        AliOssUtil.delete(fileVO.getFilekey());
        return Result.success();
    }
}
