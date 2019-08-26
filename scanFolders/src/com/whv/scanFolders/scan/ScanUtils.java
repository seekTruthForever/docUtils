package com.whv.scanFolders.scan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.whv.scanFolders.utils.FileUtil;

public class ScanUtils {
	public static void getFiles(String strPath) {
		List<File> filelist = new ArrayList<File>();
		filelist = FileUtil.getFileList(strPath, filelist);
		for(File file : filelist) {
			System.out.println(file.getAbsolutePath()+"-------"+FileUtil.getFileSize(file));
		}
	}
	
	public static void getFiles(String strPath,String type,String nameRegex) {
		List<File> filelist = new ArrayList<File>();
		filelist = FileUtil.getFileList(strPath, filelist,type,nameRegex);
		for(File file : filelist) {
			System.out.println(file.getAbsolutePath()+"-------"+FileUtil.getFileSize(file));
		}
	}
}
