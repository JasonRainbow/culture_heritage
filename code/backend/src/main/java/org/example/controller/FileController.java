package org.example.controller;

import cn.hutool.json.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.FileService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @author hzx
 */
@RestController
@RequestMapping("/files")
@Api(tags = "文件上传下载控制器")
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * 上传接口
     * @param file 文件对象
     * @return 响应结果
     * @throws IOException IO异常
     */
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件到本地接口")
    public Result upload(MultipartFile file) throws IOException {
        // 返回结果 url
        return Result.success(fileService.uploadFile(file));
    }

    /**
     * 富文本文件上传接口
     * @param file 富文本文件对象
     * @return JSON对象
     * @throws IOException 写入文件失败
     */
    @PostMapping("/editor/upload")
    @ApiOperation(value = "富文本文件上传接口")
    public JSON editorUpload(MultipartFile file) throws IOException {
        return fileService.uploadRichText(file);
    }

    /**
     * 下载接口
     * @param flag 文件标识
     * @param response http响应对象
     */
    @GetMapping("/get/{flag}")
    @ApiOperation(value = "文件下载接口")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) throws IOException {
        fileService.downloadFile(flag, response);
    }
}
