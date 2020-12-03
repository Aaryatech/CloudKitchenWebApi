package com.ats.ckweb.model;

public class ImageUploadResponse {

	Info info;
	String fileName;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "ImageUploadResponse [info=" + info + ", fileName=" + fileName + "]";
	}

}
