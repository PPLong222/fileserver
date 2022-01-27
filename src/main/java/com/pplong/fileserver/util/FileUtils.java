package com.pplong.fileserver.util;

import com.pplong.fileserver.Constant;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

public class FileUtils {
    static FileUtils fileUtils;
    public static FileUtils getInstance() {
        if (fileUtils == null)
            fileUtils = new FileUtils();

        return fileUtils;
    }
    public static String calculateAccurateSize(long size) {
        double res;
        String str;
        if((res = size * 1.0 / Constant.GB) > 1) {
            str = String.format("%.2f", res) + "GB";
        }else if((res = size * 1.0  / Constant.MB) > 1) {
            str = String.format("%.2f", res) + "MB";
        }else{
            res = size * 1.0 / Constant.KB;
            str = String.format("%.2f", res) + "KiB";
        }
        return str;
    }
    // without check
    public static void checkDir() {
        File file = new File(Constant.Test.LOCAL_FILE_LOC);

        if(!file.exists()){
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static String judgeFileType(String name) {
        String[] type = name.split("\\.");
        String suffix = type[type.length - 1];
        StringBuilder sb = new StringBuilder();
        sb.append("/img/icon/");
        switch (suffix) {
            case "pdf":
                sb.append(Constant.IconType.FILE_PDF);
                break;
            /*case "jpg":
            case "jpeg":
            case "png":
                break;*/
            case "mp3":
                sb.append(Constant.IconType.FILE_MP3);
                break;
            case "mp4":
                sb.append(Constant.IconType.FILE_MP4);
                break;
            case "ppt":
                sb.append(Constant.IconType.FILE_PPT);
                break;
            case "xls":
                sb.append(Constant.IconType.FILE_EXCEL);
            case "txt":
                sb.append(Constant.IconType.FILE_TXT);
            case "doc":
            case "docx":
                sb.append(Constant.IconType.FILE_WORD);
                break;
            case "zip":
            case "gz":
                sb.append(Constant.IconType.FILE_ZIP);
                break;
            default:
                sb.append(Constant.IconType.FILE_UNKNOWN);
                break;
        }
        return sb.toString();
    }
    // bad example
    public static String getConvertTime(long time) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(time);
        return dateStr;
    }

    public static boolean deleteByName(String loc) {
        File file = new File(loc);
        if(file.exists()) {
            boolean delete = file.delete();
            return delete;
        }
        return true;
    }

    public static String encodeFileNameWithMD5(String originName) {
        String[] suffixArr = originName.split("\\.");
        String suffix = suffixArr[suffixArr.length - 1];
        if(originName.contains(".tar.gz")) {
            suffix = "tar.gz";
        }
        String name = DigestUtils.md5DigestAsHex(originName.getBytes(StandardCharsets.UTF_8));
        name += "." +suffix;
        return name;
    }
}
