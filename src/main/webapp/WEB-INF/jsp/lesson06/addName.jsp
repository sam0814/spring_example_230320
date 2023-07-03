<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- bootstrap CDN link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<%-- AJAX 사용하려면 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>

		<div class="form-group">
			<label for="name"><b>이름</b></label> 
			<div class="d-flex">
				<input type="text" id="name" class="form-control col-3" placeholder="이름을 입력하세요">
				<button type="button" class="btn btn-warning" id="nameCheckBtn">중복확인</button>
			</div>
			<small id="nameStatusArea"></small>
		</div>
		
		<input type="button" id="joinBtn" class="btn btn-primary" value="회원가입">
	</div>
	
	<script>
		$(document).ready(function() {
			// 중복확인 버튼 클릭
			$('#nameCheckBtn').on('click', function() {
				// nameStatusArea의 하의 태그들을 초기화
				$('#nameStatusArea').empty();	// 자식태그들을 모두 비움
				
				
				//alert("중복확인 버튼");
				let name = $('#name').val().trim();
				
				// validation
				// 이름이 입력됐는지 확인
				if (!name) {
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
					return;
				}
				
				// 이름 중복확인 AJAX 통신(DB 확인)
				$.ajax({
					// request
					type:"get"	// get일 때는 생략 가능
					, url:"/lesson06/ex02/is_duplication"
					, data: {"name" : name}
					
					// response
					, success:function(data) {
						//alert(data);
						if (data.isDuplication) {	// 중복
							$("#nameStatusArea").append('<span class="text-danger">중복된 이름입니다.</span>')
						}
					}
					, error:function(request, status, error) {
						alert("중복 확인에 실패했습니다.");
					}
				});
			});
			
			// 회원가입 버튼 클릭
			$("#joinBtn").on('click', function () {
				console.log($('nameStatusArea').children().length);
				
				// 만약 nameStatusArea에 아무 자식 노드가 없다면 회원가입을 한다.
				if ($('nameStatusArea').children().length == 0) {
				 	alert("가입 가능");
				} else {
					alert("가입 불가");
				}
			});
		});
	</script>
</body>
</html>