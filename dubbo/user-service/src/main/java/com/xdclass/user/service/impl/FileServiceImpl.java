package com.xdclass.user.service.impl;

import com.xdclass.user.service.FileService;

public class FileServiceImpl implements FileService {
    @Override
    public void upload(String msg) {
        System.out.println("服务被调用"+msg);
    }
}
