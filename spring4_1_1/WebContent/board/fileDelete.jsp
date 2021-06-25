<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.net.*" %>    
<%
// 	request.setCharacterEncoding("UTF-8");
// 	String b_file = request.getParameter("b_file");
// 	String fname = b_file;
// 	out.print("b_file: 8->euc"+b_file);		
// 	out.print("<br>");		
// 	String filePath = "C://portfolio_hit//lab_spring4//spring4_1_1//WebContent//pds//"; // 절대경로.	
// 	File file = new File(filePath,b_file.trim());
//  	String mimeType = getServletContext().getMimeType(file.toString());
// 	if(mimeType == null){
// 		response.setContentType("application/octet-stream");
// 	}
// 	String downName = null;
// 	if(request.getHeader("user-agent").indexOf("MSIE")==-1){
// 		downName = new String(b_file.getBytes("UTF-8"),"8859_1");
// 	}else{
// 		downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
// 	}
//    	response.setHeader("Content-Disposition", "attachment;filename="+downName);
//  	FileInputStream fis = new FileInputStream(file);
//  	///////////////////////////////////
// 	out.clear();
// 	out=pageContext.pushBody();
//  	///////////////////////////////////
// 	ServletOutputStream sos = response.getOutputStream();
// 	try{
// 		byte b[] = new byte[1024*10];
// 		int data = 0;
// 		while((data=(fis.read(b,0,b.length)))!=-1){
// 			sos.write(b,0,data);
// 		}
// 		sos.flush();		
// 	}catch(Exception e){
// 		out.print(e.toString());
// 	}finally{
// 		if(sos != null) sos.close();
// 		if(fis != null) fis.close();
// 	}
	File file1 = new File("C:/dir"); 
	if( file1.exists() ){ //파일존재여부확인
		if(file1.isDirectory()){ //파일이 디렉토리인지 확인
			File[] files = file1.listFiles(); 
			for( int i=0; i<files.length; i++){ 
				if( files[i].delete() ){ 
					out.print(files[i].getName()+" 삭제성공"); 
				}
				else{ 
					out.print(files[i].getName()+" 삭제실패"); 
				} 
			} 
			if(file1.delete()){ 
				out.print("파일삭제 성공"); 
			}
			else{ 
				out.print("파일삭제 실패"); 
			} 
		}
		else{ 
			out.print("파일이 존재하지 않습니다."); 
		}
	}
%>  
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다운로드</title>
</head>
<body>

</body>
</html>