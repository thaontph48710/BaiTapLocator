package com.helpers;

import java.io.File;

public class SystemHelper {

    //SystemHelper đặt trong package helpers để lưu các hàm xử lý bổ trợ cho các class khác.
    // Lấy đường dẫn thư mục hiện tại của dự án
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
