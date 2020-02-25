package gi.sung.imageservice.models;

@Data
public class FileInfo {

	private String fileName;
    private long fileSize ;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


}
