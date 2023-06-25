<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="pointMain" align="center">
	<div class = "pointSub">
		<div class="title">포인트</div>
	</div>
	<div class="subtitle">
		<div class= "point_level"> 현재 포인트</div>
		<div class="point_number">${vo.pointMy }</div>
	</div>
</div>
<div class="point_wrapper" align="center">
	<div class = "point_history">
	 	<div class = "point_history_header">포인트 내역</div>
	 	<div class = "point_history_item">
	 		<div class = "point_history_row">
	 			<div class = "point_history_text">날짜</div>
	 			<div class = "point_history_date">${vo.pointStart }</div>
	 		</div>
	 		<div class="point_history_row">
	 			<div class="point_histoty_label">내역</div>
	 			<div class="point_histoty_label">${vo.pointReason }</div>
	 		</div>
	 		<div class="point_history_itemstyle"></div>
	 		<div class="point_history_itemstyle_all">${vo.pointMy }
	 		</div>
	 	</div>
	</div>
</div>
</body>
</html>