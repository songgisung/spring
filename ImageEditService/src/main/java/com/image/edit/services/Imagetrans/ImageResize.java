package com.image.edit.services.Imagetrans;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageResize {

	public void getImageResize() {
		String imgOriginalPath= "C:/test/test.jpg";           // 원본 이미지 파일명
        String imgTargetPath= "C:/test/test_resize.jpg";    // 새 이미지 파일명
        String imgFormat = "jpg";                             // 새 이미지 포맷. jpg, gif 등
        int newWidth = 600;                                  // 변경 할 넓이
        int newHeight = 700;                                 // 변경 할 높이
        String mainPosition = "W";                             // W:넓이중심, H:높이중심, X:설정한 수치로(비율무시)

        Image image;
        int imageWidth;
        int imageHeight;
        double ratio;
        int w;
        int h;

        try{
            // 원본 이미지 가져오기
            image = ImageIO.read(new File(imgOriginalPath));

            // 원본 이미지 사이즈 가져오기
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);

            if(mainPosition.equals("W")){    // 넓이기준

                ratio = (double)newWidth/(double)imageWidth;
                w = (int)(imageWidth * ratio);
                h = (int)(imageHeight * ratio);

            }else if(mainPosition.equals("H")){ // 높이기준

                ratio = (double)newHeight/(double)imageHeight;
                w = (int)(imageWidth * ratio);
                h = (int)(imageHeight * ratio);

            }else{ //설정값 (비율무시)

                w = newWidth;
                h = newHeight;
            }

            // 이미지 리사이즈
            // Image.SCALE_DEFAULT : 기본 이미지 스케일링 알고리즘 사용
            // Image.SCALE_FAST    : 이미지 부드러움보다 속도 우선
            // Image.SCALE_REPLICATE : ReplicateScaleFilter 클래스로 구체화 된 이미지 크기 조절 알고리즘
            // Image.SCALE_SMOOTH  : 속도보다 이미지 부드러움을 우선
            // Image.SCALE_AREA_AVERAGING  : 평균 알고리즘 사용
            Image resizeImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);

            // 새 이미지  저장하기
            BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = newImage.getGraphics();
            g.drawImage(resizeImage, 0, 0, null);
            g.dispose();
            ImageIO.write(newImage, imgFormat, new File(imgTargetPath));

        }catch (Exception e){

            e.printStackTrace();

        }

    }
}


//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//
//import javax.imageio.ImageIO;
//
//public class ImageResize {
//
//    public static void main(String[] args) {
//
//        String imgOriginalPath= "C:/test/test.jpg";           // 원본 이미지 파일명
//        String imgTargetPath= "C:/test/test_resize.jpg";    // 새 이미지 파일명
//        String imgFormat = "jpg";                             // 새 이미지 포맷. jpg, gif 등
//        int newWidth = 600;                                  // 변경 할 넓이
//        int newHeight = 700;                                 // 변경 할 높이
//        String mainPosition = "W";                             // W:넓이중심, H:높이중심, X:설정한 수치로(비율무시)
//
//        Image image;
//        int imageWidth;
//        int imageHeight;
//        double ratio;
//        int w;
//        int h;
//
//        try{
//            // 원본 이미지 가져오기
//            image = ImageIO.read(new File(imgOriginalPath));
//
//            // 원본 이미지 사이즈 가져오기
//            imageWidth = image.getWidth(null);
//            imageHeight = image.getHeight(null);
//
//            if(mainPosition.equals("W")){    // 넓이기준
//
//                ratio = (double)newWidth/(double)imageWidth;
//                w = (int)(imageWidth * ratio);
//                h = (int)(imageHeight * ratio);
//
//            }else if(mainPosition.equals("H")){ // 높이기준
//
//                ratio = (double)newHeight/(double)imageHeight;
//                w = (int)(imageWidth * ratio);
//                h = (int)(imageHeight * ratio);
//
//            }else{ //설정값 (비율무시)
//
//                w = newWidth;
//                h = newHeight;
//            }
//
//            // 이미지 리사이즈
//            // Image.SCALE_DEFAULT : 기본 이미지 스케일링 알고리즘 사용
//            // Image.SCALE_FAST    : 이미지 부드러움보다 속도 우선
//            // Image.SCALE_REPLICATE : ReplicateScaleFilter 클래스로 구체화 된 이미지 크기 조절 알고리즘
//            // Image.SCALE_SMOOTH  : 속도보다 이미지 부드러움을 우선
//            // Image.SCALE_AREA_AVERAGING  : 평균 알고리즘 사용
//            Image resizeImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
//
//            // 새 이미지  저장하기
//            BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//            Graphics g = newImage.getGraphics();
//            g.drawImage(resizeImage, 0, 0, null);
//            g.dispose();
//            ImageIO.write(newImage, imgFormat, new File(imgTargetPath));
//
//        }catch (Exception e){
//
//            e.printStackTrace();
//
//        }
//
//    }
//
//}