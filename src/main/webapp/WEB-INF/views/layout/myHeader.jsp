<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .mypage {
            width: 1200px;
            margin-bottom:200px;
        }

        .top_nav {
            height: 100px;
        }
        td{
            text-align: left;
        }
        
    </style>
</head>

<body>
    <div class="mypage">
        <div class="top_nav">
            <table style="border-spacing: 30px; border-collapse: separate;">
                <tr>
                   <td id="border">${nickName}님</td>
                    <td></td>
                    <td style="border-right: 1px solid;">
                        <p><a href="경로">잔여포인트</a>&nbsp;&nbsp;&nbsp;&nbsp;[잔여포인트]&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p><a href="${ pageContext.request.contextPath }/ususer/coupons">잔여쿠폰</a>&nbsp;&nbsp;&nbsp;&nbsp;[${count}]</p>
                    </td>
                    <td><button onclick="location.href='${ pageContext.request.contextPath }/ususer/orderList'">주문내역</button></td>
                    <td><button onclick="location.href='경로'">취소 / 환불내역</button></td>
                    <td><button onclick="location.href='${ pageContext.request.contextPath }/uuser/reviewList'">리뷰</button></td>
                    <td><button onclick="location.href='${ pageContext.request.contextPath }/uuser/uuserInfo'">회원정보</button></td>
                    <td><button onclick="location.href='${ pageContext.request.contextPath }/delivery/form'">배송지관리</button></td>
                    <td><button onclick="location.href='${ pageContext.request.contextPath }/cs/list'">고객센터</button></td>
                </tr>
            </table>
        </div>
    </div>
</body>
