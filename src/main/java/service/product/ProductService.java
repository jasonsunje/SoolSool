package service.product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dao.product.ProductDAO;
import vo.product.ProductVO;

public class ProductService {

	static ProductDAO productDao;
	
	
	public ProductService(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	public ProductVO productDetail(int productNo) {
		return productDao.productDetail(productNo);
	}
	
	public List<ProductVO> listProduct() {
		return productDao.listProduct();
	}
	
	
	public int updateProduct(ProductVO vo) {
		return productDao.updateProduct(vo);
	}
	
	public int deleteProduct(int productNo) {
		return productDao.deleteProduct(productNo);
	}
	
	public String getProductFIle(int productNo) {
		return productDao.getProductFile(productNo);
	}
	
	public static int getTotal(Map<String, Object> map) {
		return productDao.getTotal(map);
	}
	
	
	public static Map<String, Object> getContent(int no) {
		productDao.readCount(no);

		Map<String, Object> map = productDao.getContent(no);

		map.put("VO", productDao.selectOne(no));

		return map;
	}
	
	public static ProductVO selectOne(int productNo) {
		return productDao.selectOne(productNo);
	}
		
	public Object productImgSave (MultipartHttpServletRequest multipartRequest) {
		 
			List<HashMap> fileArrayList = new ArrayList<HashMap>();
			HashMap fileHashMap;
	 
			String filePath = "/views/admin/product/productimg"; //파일 저장 경로, 설정파일로 따로 관리한다.
	 
			File dir = new File(filePath); //파일 저장 경로 확인, 없으면 만든다.
				if (!dir.exists()) {
				dir.mkdirs();
				}
	 
			Iterator<String> itr =  multipartRequest.getFileNames(); //파일들을 Iterator 에 넣는다.
	 
			while (itr.hasNext()) { //파일을 하나씩 불러온다.
	 
	        MultipartFile mpf = multipartRequest.getFile(itr.next());
	 
	        fileHashMap = new HashMap();
	 
	        String originalFilename = mpf.getOriginalFilename(); //파일명
	 
	        String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
	 
	        try {
	            //파일 저장
	            mpf.transferTo(new File(fileFullPath)); //파일저장
	 
	            fileHashMap.put("originalFilename", originalFilename);
	            fileHashMap.put("fileFullPath", fileFullPath);
	 
	            fileArrayList.add(fileHashMap);
	 
	        } catch (Exception e) {
	            System.out.println("postTempFile_ERROR======>"+fileFullPath);
	            e.printStackTrace();
	        }
	 
	    }
	 
	    Map<String, Object> retVal = new HashMap<String, Object>(); //응답값 셋팅
	 
	    try{
	        retVal.put("fileInfoList", fileArrayList);    
	        retVal.put("code", "OK");
	    }catch(Exception e){
	        retVal.put("code", "FAIL");
	    }
	 
	    return retVal;
	}
}
