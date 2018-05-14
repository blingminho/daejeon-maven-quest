<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<%@include file="/include/jquery.jsp" %>
<%@include file="/include/bootstrap.jsp" %>
<script type="text/javascript">
	$(function(){
		$('button').on('click', function(){
			var mem_id = $('#id').val().trim();
			var mem_pass = $('#pass').val().trim();
			
			if (mem_id == '' || mem_pass == '') {
				console.log('empty');
			} else {
				$('form').submit();
			}
			
		})
	})
</script>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath }/login">
			<div>
				<h2>ID</h2>
				<input type="text" id="id" name="mem_id" class="form-control" placeholder="아이디를 입력하세요" autofocus>
			</div>
			<div>
				<h2>PASSWORD</h2>
				<input type="password" id="pass" name="mem_pass" class="form-control" placeholder="비밀번호를 입력하세요">
			</div>
			<hr>
			<div>
				<button type="button" class="btn btn-lg btn-block btn-primary" name="mem_id">Log In</button>
			</div>
		</form>
	</div>
</body>
</html>