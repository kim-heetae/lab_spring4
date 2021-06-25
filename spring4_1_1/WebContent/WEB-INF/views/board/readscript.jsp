<%@ page language="java" contentType="text/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%
	StringBuilder path = new StringBuilder(request.getContextPath());
path.append("/");
List<Map<String, Object>> boardDetail = null;
boardDetail = (List<Map<String, Object>>) request.getAttribute("boardDetail");
int size = 0;
if (boardDetail != null) {
	size = boardDetail.size();
}
out.print("size : " + size);

String rb_email = null;
String rb_file = null;
String rb_title = null;
String rb_writer = null;
String rb_content = null;
String rb_pwd = null;
String rb_no = null;
String rb_group = null;
String rb_pos = null;
String rb_step = null;
if (boardDetail != null && boardDetail.size() > 0) {
	rb_email 	= (String)boardDetail.get(0).get("BM_EMAIL");
	rb_file 	= (String)boardDetail.get(0).get("BS_FILE");
	rb_title	= (String)boardDetail.get(0).get("BM_TITLE");
	rb_writer 	= (String)boardDetail.get(0).get("BM_WRITER");
	rb_content 	= (String)boardDetail.get(0).get("BM_CONTENT");
	rb_pwd 		= (String)boardDetail.get(0).get("BM_PW");
	rb_no 		= boardDetail.get(0).get("BM_NO").toString();
	rb_group 	= boardDetail.get(0).get("BM_GROUP").toString();
	rb_pos 		= boardDetail.get(0).get("BM_POS").toString();
	rb_step 	= boardDetail.get(0).get("BM_STEP").toString();
}
%>
<script>
	function addAction(){
		$("#f_boardAdd").attr("action","./boardInsert.sp4");
		$("#f_boardAdd").submit();
	}
	function updateForm(){
		const imsi = $('#bs_file').val();
		if($('#bm_pw_user').textbox('getValue') == <%=rb_pwd%>)
		{
		if(imsi.trim() == '해당없음'){
		}
		   $('#f_detail').attr("method", "post");
		   $('#f_detail').attr("action", "./boardUpdate.sp4");		
		   $('#f_detail').submit();
		}
		else{
			$('#bm_pw_user').textbox('setValue','');
			alert('비밀번호를 확인해주세요');
		}
	}
	function boardDelView(){
		alert("boardDelView호출 성공");
		if($('#bm_pw_user').textbox('getValue') == <%=rb_pwd%>)
		{
		   $('#f_detail').attr("method", "post");
		   $('#f_detail').attr("action", "./boardDelete.sp4");		
		   $('#f_detail').submit();
		}
		else{
			$('#bm_pw_user').textbox('setValue','');
			alert('비밀번호를 확인해주세요');
		}
	}
	//댓글쓰기
	function repleForm() {
		$("#dlg_boardAdd").dialog('open');
	}
	function boardList(){
		location.href = "./getBoardList.sp4";
	}
	
</script>