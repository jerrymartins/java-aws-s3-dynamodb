package com.aws.trailix.controllers;

import com.amazonaws.services.s3.model.Bucket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Api("S3 Controller")
@RestController
@RequestMapping("/s3")
public class S3 {

    @PostMapping(value = "/createBucket")
    @ApiOperation("create bucket")
    public Bucket submit(@RequestParam("bucketName") String name) {
        Bucket bucket = com.aws.trailix.aws.S3.createBucket(name);
        return bucket;
    }

    @GetMapping(value = "/listBuckets")
    @ApiOperation("Listar buckets")
    public List<Bucket> bucketList() {
        List<Bucket> buckets = com.aws.trailix.aws.S3.bucketList();
        return buckets;
    }

    @PostMapping(value = "/uploadFile", consumes = {"multipart/form-data"})
    @ApiOperation("Upload File")
    public ResponseEntity<String> submit(@RequestParam("file") MultipartFile file) throws IOException {
        // file.ge

        String res = com.aws.trailix.aws.S3.putObject(file.getContentType(), file.getInputStream());

        return ResponseEntity.status(HttpStatus.OK).body("Arquivo alvo");
    }

}
