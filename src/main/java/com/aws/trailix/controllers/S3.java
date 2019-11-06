package com.aws.trailix.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api("S3 Controller")
@RestController
@RequestMapping("/s3")
public class S3 {

    @PostMapping(value = "/uploadFile")
    @ApiOperation("Upload File")
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }
}
