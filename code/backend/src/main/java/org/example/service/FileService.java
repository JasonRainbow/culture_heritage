package org.example.service;

import cn.hutool.json.JSON;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hzx
 * 提供文件相关的服务
 */
public interface FileService {

    /**
     * 上传文件服务
     * @param file 文件对象
     * @return uri
     * @throws IOException IO异常
     */
    String uploadFile(MultipartFile file) throws IOException;

    /**
     * 下载文件服务
     * @param flag 文件uri
     * @param response http响应对象
     * @throws IOException IO异常
     */
    void downloadFile(String flag, HttpServletResponse response) throws IOException;

    /**
     * 上传富文本文件服务
     * @param multipartFile 富文本文件对象
     * @return JSON对象
     * @throws IOException IO异常
     */
    JSON uploadRichText(MultipartFile multipartFile) throws IOException;
}
