<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.user.model.dao.UserDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<%@ include file="/views/common/header.jsp"%>



	<table align="center">
		<tbody>
			<h4 align="center">비밀번호 찾기</h4>
			<br>
			<tr>
				<th>아이디 &nbsp;</th>
				<td><input type="text" id="userIdf" required></td>
			</tr>
			<tr>
				<td>&emsp;</td>
			</tr>
			<tr>
				<th>이름 &nbsp;</th>
				<td><input type="text" id="userNamef" required></td>
			</tr>
			<tr>
				<td>&emsp;</td>
			</tr>
			<tr>
				<th>이메일 &nbsp;</th>
				<td><input type="email" id="userEmailf" required></td>
			</tr>
				<tr>
				<td><br></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<button type="button" id="findUserPwd" onclick="findUserPwd();" style="border:none;" class="gradient-btn">
						<span>비밀번호 찾기</span>
					</button>
				</td>
			</tr>
		
	</table>
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	
		
		<Script>
			function findUserPwd(){
				
				var findUserId =$("#userIdf").val();
				var findUserName=$("#userNamef").val();
				var findUserEmail=$("#userEmailf").val();
				console.log(findUserId);
				console.log(findUserName);
				console.log(findUserEmail);
				
				$.ajax({
					url:"${contextPath}/findPwd.us",
					type:"post",
					data:{
						findUserId: findUserId,
						findUserName: findUserName,
						findUserEmail: findUserEmail
					},
					success: function(userPwd){
						
						console.log("통신 성공");
						
						if(userPwd != null){
						alert("사용자의 비밀번호는 "+userPwd+"입니다");
							
						}else{
						alert("사용자의 정보를 다시 입력하세요");
						}
						
					},
					

					

				
				error : function() {
					alert("잘못된 정보입니다. 다시 입력해주세요.");
				}

			});
				
		}
	</Script>

</body>
</html>