package com.whv.scanFolders.files;

import com.whv.scanFolders.folders.FolderBean;

public class FileBean {
	/**名称*/
	private String name;
	/**路径*/
	private String path;
	/**目录*/
	private FolderBean folder;
	/**字节大小*/
	private Long bSize;
	/**KB大小*/
	private Double kbSize;
	/**MB大小*/
	private Double mbSize;
	/**GB大小*/
	private Double gbSize;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public FolderBean getFolder() {
		return folder;
	}
	public void setFolder(FolderBean folder) {
		this.folder = folder;
	}
	public Long getbSize() {
		return bSize;
	}
	public void setbSize(Long bSize) {
		this.bSize = bSize;
	}
	public Double getKbSize() {
		return kbSize;
	}
	public void setKbSize(Double kbSize) {
		this.kbSize = kbSize;
	}
	public Double getMbSize() {
		return mbSize;
	}
	public void setMbSize(Double mbSize) {
		this.mbSize = mbSize;
	}
	public Double getGbSize() {
		return gbSize;
	}
	public void setGbSize(Double gbSize) {
		this.gbSize = gbSize;
	}
	/**获取大小*/
	 public String getSize() {
		 String __size = null;
		 if(getGbSize()>=1) {
			 __size = getGbSize()+"GB";
		 }else if(getMbSize()>=1) {
			 __size = getMbSize()+"MB";
		 }else if(getKbSize()>=1) {
			 __size = getKbSize()+"KB";
		 }else {
			 __size = getbSize()+"B";
		 }
		 return __size;
	 }
	 /**获取格式*/
	 public String getFormat() {
		 String __format = null;
		 if(getGbSize()>=1) {
			 __format = "GB";
		 }else if(getMbSize()>=1) {
			 __format = "MB";
		 }else if(getKbSize()>=1) {
			 __format = "KB";
		 }else {
			 __format = "B";
		 }
		 return __format;
	 }
}
