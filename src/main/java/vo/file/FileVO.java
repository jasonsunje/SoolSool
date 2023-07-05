package vo.file;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {

	private String csTitle;
	private String csFilename; //업로드된 파일명...

	private MultipartFile csFile; // 파일을 받기위한 클래스


	public String getCsTitle() {
		return csTitle;
	}

	public void setCsTitle(String csTitle) {
		this.csTitle = csTitle;
	}

	public String getCsFilename() {
		return csFilename;
	}

	public void setCsFilename(String csFilename) {
		this.csFilename = csFilename;
	}

	public MultipartFile getCsFile() {
		return csFile;
	}

	public void setCsFile(MultipartFile csFile) {
		this.csFile = csFile;
	}


	
	
}
