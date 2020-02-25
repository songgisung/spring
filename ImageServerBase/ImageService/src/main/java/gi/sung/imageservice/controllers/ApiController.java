package gi.sung.imageservice.controllers;

import java.io.File;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gi.sung.imageservice.models.FileInfo;
import gi.sung.imageservice.services.ImageReSizeService;

@RestController
public class ApiController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ImageReSizeService imgReSizeService;

	@RequestMapping(value = "/get/imageresize", method=RequestMethod.POST )
	@ResponseBody
	public String imageReSize(@RequestBody Map<String, Object> imageInfo) {
		//return "api test";
		return imageInfo.toString();
	}

	@RequestMapping(value = "/get/test", method=RequestMethod.POST )
	@ResponseBody
	public String test(@RequestParam MultipartFile file ) {

		return "test";
	}

	/*
	 *멀티 파트 업로드 테스
	 */
	@RequestMapping(value = "/upload", headers = ("content-type=multipart/*" ), method = RequestMethod.POST )
    public ResponseEntity<FileInfo> upload(@RequestParam ("file") MultipartFile inputFile) {

         FileInfo fileInfo = new FileInfo();
         HttpHeaders headers = new HttpHeaders();
          if (!inputFile .isEmpty()) {

              try {

                  String oriFileNm = inputFile.getOriginalFilename();
                  File destinationFile = new File(context.getRealPath("/WEB-INF/uploaded" ) + File.separator + oriFileNm);
                   inputFile.transferTo(destinationFile );
                   headers.add("File Uploaded Successfully - ", oriFileNm);

                   fileInfo.setFileName(destinationFile .getPath());
                   fileInfo.setFileSize(inputFile .getSize());
                   return new ResponseEntity<FileInfo>(fileInfo , headers, HttpStatus.OK );

             } catch (Exception e ) {
                   return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
             }
         } else {
              return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
         }
    }

}
