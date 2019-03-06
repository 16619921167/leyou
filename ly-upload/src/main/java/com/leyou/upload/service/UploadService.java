package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import org.assertj.core.error.ShouldHaveOnlyElementsOfType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    public static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg","image/png","image/bmp");
    public String uploadImage(MultipartFile file) {
        try {
        //准备目标路径
        //校验文件的类型
        String contentType = file.getContentType();
        if(!ALLOW_TYPES.contains(contentType)){
            throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
        }

        //校验文件的内容

            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image == null){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //准备目标路径
            File dest = new File("D:\\software\\upload", file.getOriginalFilename());
            //保存文件
            file.transferTo(dest);
        //返回路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
