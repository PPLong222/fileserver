package com.pplong.fileserver.controller;

import com.pplong.fileserver.Constant;
import com.pplong.fileserver.mapper.FileMapper;
import com.pplong.fileserver.pojo.SingleFile;
import com.pplong.fileserver.util.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    FileMapper mapper;

    @RequestMapping("/main")
    public String getAllFiles(Model model) {
        List<SingleFile> singleFiles = mapper.queryAllFiles();
        String totalSize;
        if(singleFiles.size() != 0) {
            Long size = mapper.queryTotalSize();
            totalSize = FileUtils.calculateAccurateSize(size);
        }else{
            totalSize = "0";
        }
        model.addAttribute("files",singleFiles);
        model.addAttribute("totalSize",totalSize);
        model.addAttribute("fileUtils",FileUtils.getInstance());
        if(singleFiles.isEmpty()) {

        }
        return Constant.HTMLPage.MainPage;
    }
    @PostMapping("/uploadFiles")
    public String upload(@RequestPart("upLoadFiles") MultipartFile[] upLoadFiles) {
        FileUtils.checkDir();
        if(upLoadFiles != null && upLoadFiles.length > 0) {
            for (MultipartFile file : upLoadFiles) {
                System.out.println(file.getOriginalFilename());
                if(!file.isEmpty()) {
                    String newName = FileUtils.encodeFileNameWithMD5(file.getOriginalFilename());
                    String loc = Constant.Test.LOCAL_FILE_LOC + newName;
                    try {
                        file.transferTo(new File(loc));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SingleFile singleFile = new SingleFile(newName, file.getSize(), System.currentTimeMillis(), loc);
                    int i = mapper.insertSingleFileRec(singleFile);
                    if(i != 1) {

                    }
                }
            }
        }
        return "redirect:/main";
    }

    @GetMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name) {
        boolean b = FileUtils.deleteByName(Constant.Test.LOCAL_FILE_LOC + name);
        if(!b) {

        }
        int i = mapper.deleteSingleFile(name);
        if(i >= 1) {

        }else{

        }
        return "redirect:/main";
    }
    @RequestMapping(value = "/download/{name}")
    public String download(@PathVariable("name") String name, HttpServletResponse response) {
        String str = "redirect:/upload/" +  URLDecoder.decode(name,StandardCharsets.UTF_8);
        System.out.println();
        System.out.println(str);
        return str;
    }


}
