package com.cognizant.fileUpload.fileUpload.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	@PostMapping(value = "/uploadChunk")
	@ResponseBody
	public void getChunkData(@RequestParam MultipartFile file, @RequestParam int fileSize) {
		try {
			byte[] chunkDatabytes = file.getBytes();
			output.write(chunkDatabytes);
			byte[] out = output.toByteArray();
			System.out.println("File Size: " + out.length);
			if (fileSize == out.length) {
				try (FileOutputStream fos = new FileOutputStream("C:\\Users\\761104\\OneDrive - Cognizant\\Documents\\DownloadFile\\Sample.pdf")) {
					fos.write(out);
					System.out.println("File Written Successfully..!!");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
