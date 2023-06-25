package vo.file;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO2 {

	private String title;
	private String filename1; //업로드된 파일명...
	private String filename2; //업로드된 파일명...

	private MultipartFile[] photo; // 파일을 받기위한 클래스

	public String getTitle() {
		return title;
	}

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public MultipartFile[] getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile[] photo) {
		this.photo = photo;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
