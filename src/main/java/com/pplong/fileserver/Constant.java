package com.pplong.fileserver;

public class Constant {
    public static final int RES_OK = 1;
    public static final int RES_ERROR = -1;

    public static final String LoginError = "Login Fail!";
    public static final int KB = 1024;
    public static final int MB = 1024 * 1024;
    public static final int GB = 1024 * 1024 * 1024;
    public static final String NOT_LOGIN = "Please login first!";

    public static class IconType {
        public static final String FILE_PDF = "pdf.svg";
        public static final String FILE_MP3 = "mp3.svg";
        public static final String FILE_MP4 = "mp4.svg";
        public static final String FILE_PPT = "ppt.svg";
        public static final String FILE_EXCEL = "excel.svg";
        public static final String FILE_WORD = "word.svg";
        public static final String FILE_TXT = "txt.svg";
        public static final String FILE_ZIP = "zip.svg";
        public static final String FILE_UNKNOWN = "file_unknown.svg";
    }

    public static class Test{
        public static final String REMOTE_FILE_LOC = "/home/ServerTest/upload/";
        public static final String LOCAL_FILE_LOC = "/opt/ServerTest/upload/";
    }
    public static class HTMLPage{
        public static final String MainPage = "main";
        public static final String LoginPage = "login";

    }
}
