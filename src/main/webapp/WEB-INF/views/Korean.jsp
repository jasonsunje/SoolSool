<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<style>
.wrap {
	position: absolute;
	left: 0;
	bottom: 40px;
	width: 288px;
	height: 132px;
	margin-left: -144px;
	text-align: left;
	overflow: hidden;
	font-size: 12px;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	line-height: 1.5;
}

.wrap * {
	padding: 0;
	margin: 0;
}

.wrap .info {
	width: 286px;
	height: 120px;
	border-radius: 5px;
	border-bottom: 2px solid #ccc;
	border-right: 1px solid #ccc;
	overflow: hidden;
	background: #fff;
}

.wrap .info:nth-child(1) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.info .title {
	padding: 5px 0 0 10px;
	height: 30px;
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-size: 18px;
	font-weight: bold;
}

.info .close {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #888;
	width: 17px;
	height: 17px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
	cursor: pointer;
}

.info .body {
	position: relative;
	overflow: hidden;
}

.info .desc {
	position: relative;
	margin: 13px 0 0 90px;
	height: 75px;
}

.desc .ellipsis {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.desc .jibun {
	font-size: 11px;
	color: #888;
	margin-top: -2px;
}

.info .img {
	position: absolute;
	top: 6px;
	left: 5px;
	width: 73px;
	height: 71px;
	border: 1px solid #ddd;
	color: #888;
	overflow: hidden;
}

.info:after {
	content: '';
	position: absolute;
	margin-left: -12px;
	left: 50%;
	bottom: 0;
	width: 22px;
	height: 12px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
	color: #5085BB;
}
</style>
</head>
<body>
	<div id="map" style="width: 100%; height: 600px;"></div>
	<p>
		<button onclick="setBounds()">충청도</button>
		<button onclick="setBounds2()">제주도</button>
		<button onclick="setBounds3()">강원도</button>
		<button onclick="setBounds4()">경상도</button>
		<button onclick="setBounds5()">경기도</button>
		<button onclick="setBounds6()">전라도</button>
		<button onclick="setBounds7()">광역시</button>
		<button onclick="setBounds8()">전국</button>
	</p>

	<div id="map" style="width: 100%; height: 800px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=233dce2282719dbbd89f84d8703453bb"></script>
	<script>
		var positions = [
				{
					title : '신평양조장',
					latlng : new kakao.maps.LatLng(36.88359126845671,
							126.77478160231092),
					address : '충남 당진시 신평면 신평로 813',
					postcode : '(우) 25162',
					website : 'http://www.koreansul.co.kr',
					image : 'https://i.ibb.co/BBhxPcx/image.jpg', // 첫 번째 오버레이에 표시할 이미지 URL
					tel : '041-362-6080'
				},

				{
					title : '예산사과와인',
					latlng : new kakao.maps.LatLng(36.76184753769927,
							126.6980712843757),
					address : '충남 예산군 고덕면 대몽로 107-25',
					postcode : '(우) 25266',
					website : 'http://www.chusawine.com',
					image : 'https://i.ibb.co/mXPh4HB/2.jpg', // 두 번째 오버레이에 표시할 이미지 URL
					tel : '041-337-9584',
					distillery : 'http://localhost:8080/sool/Yesanapple'
				},

				{
					title : '양촌양조',
					latlng : new kakao.maps.LatLng(36.13819669581555,
							127.2341883320937),
					address : '충남 논산시 양촌면 매죽헌로1665번길 14-9',
					postcode : '(우) 26505',
					website : 'http://www.yangchon.co.kr/',
					image : 'https://cdn.imweb.me/thumbnail/20220927/503f694413099.png', // 세 번째 오버레이에 표시할 이미지 URL
					tel : '041-741-2011',
					distillery : 'http://localhost:8080/sool/YangchonBrewing'
				},

				{
					title : '한산소곡주',
					latlng : new kakao.maps.LatLng(36.08003679972075,
							126.80233711301648),
					address : '충남 서천군 한산면 충절로 1118',
					postcode : '(우) 25106',
					website : 'http://www.sogokju.co.kr',
					image : 'https://cf.channel.io/thumb/200x200/pub-file/83763/62332ea772b93835ff1a/file.png', // 세 번째 오버레이에 표시할 이미지 URL
					tel : '041-741-2011',
					distillery : 'http://localhost:8080/sool/hansansogokju'
				},

				{
					title : '중원당',
					latlng : new kakao.maps.LatLng(36.99706273399605,
							127.87877618474425),
					address : '충북 충주시 가금면 창동리 243',
					postcode : '(우) 25266',
					website : 'http://www.xn--v42bo8x7wc.com/main/index.php',
					image : 'https://cdn-pro-web-250-114.cdn-nhncommerce.com/jwd2021_godomall_com/data/skin/front/moment/img/banner/1c5844188586cd0f85f1aa1bd3371b5a_50317.png', // 두 번째 오버레이에 표시할 이미지 URL
					tel : '043-842-5005',
					distillery : 'http://localhost:8080/sool/jungwondang'
				},

				{
					title : '대강양조장',
					latlng : new kakao.maps.LatLng(36.92220485992229,
							128.35371683858602),
					address : '충북 단양군 대강면 대강로 60',
					postcode : '(우) 25266',
					website : 'http://www.krwine.com',
					tel : '043-422-0077',
					image : 'http://www.krwine.com/include/images/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '조은술 세종',
					latlng : new kakao.maps.LatLng(36.67704019195783,
							127.48007865749041),
					address : '충북 청주시 청원구 사천로 18번길 5-2',
					postcode : '(우) 25266',
					website : 'http://www.joeunsulsj.co.kr',
					tel : '043-218-7689',
					image : 'https://www.joeunsulsj.co.kr:5009/project/design/com/logo.png', // 두 번째 오버레이에 표시할 이미지 URL
					distillery : 'http://localhost:8080/sool/goodsoolsejong'

				},

				{
					title : '화양',
					latlng : new kakao.maps.LatLng(36.70162238828038,
							127.54544238447356),
					address : '충북 청주시 청원구 내수읍 풍정1길 8-2',
					postcode : '(우) 25266',
					website : 'http://hwayang.co/',
					tel : '043-214-9424',
					image : 'https://cdn-std-web-151-94.cdn-nhncommerce.com/hwayang_godomall_com/data/skin/front/hyskin_2/img/banner/34925a88254b390859c2bd876964adc7_98130.svg' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '이원양조장',
					latlng : new kakao.maps.LatLng(36.246971853078946,
							127.6206163944885),
					address : '충청북도 옥천군 이원면 묘목로 113',
					postcode : '(우) 25266',
					website : 'http://iwonwine.com/new/index.php',
					tel : '043-732-2177',
					image : 'http://iwonwine.com/new/images/common/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '여포와인농장',
					latlng : new kakao.maps.LatLng(36.12622364473387,
							127.74454096620207),
					address : '충북 영동군 양강면 유점지촌길 75',
					postcode : '(우) 25266',
					website : 'https://yeopo.modoo.at/',
					tel : '043-744-7702 ',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg', // 두 번째 오버레이에 표시할 이미지 URL //로고 이미지 없음 공용으로 바꿔야함
					distillery : 'http://localhost:8080/sool/Yeopo'

				},

				{
					title : '도란원',
					latlng : new kakao.maps.LatLng(36.19209163123898,
							127.93672023843477),
					address : '충북 영동군 매곡면 유전장척길 143',
					postcode : '(우) 25266',
					website : 'http://xn--hg3b13gpoq4muubvz4a.kr/',
					tel : '043-743-2109',
					image : 'https://xn--hg3b13gpoq4muubvz4a.kr/_wg/img/logo_off.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '장희',
					latlng : new kakao.maps.LatLng(36.71424528801202,
							127.60509400485338),
					address : '충북 청주 청원구 내수읍 미원초정로 1275',
					postcode : '(우) 25266',
					website : 'https://jhdg3491.modoo.at/',
					tel : '010-4741-6567',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 두 번째 오버레이에 표시할 이미지 URL //로고 이미지 없음 공용으로 바꿔야함
				},

				{
					title : '산막와이너리',
					latlng : new kakao.maps.LatLng(36.16672335847733,
							127.82060170621504),
					address : '충북 영동군 영동읍 산막골길 31-45',
					postcode : '(우) 25266',
					website : 'https://smartstore.naver.com/sanmacwine',
					tel : '043-745-3888',
					image : 'https://shop-phinf.pstatic.net/20221024_32/1666595578584MQyL3_PNG/67731358294538092_1250483317.png?type=m120' // 두 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '예술주조',
					latlng : new kakao.maps.LatLng(37.79411570958423,
							128.1692505239543),
					address : '강원도 홍천군 내촌면 물걸리 508-2',
					postcode : '(우) 25162',
					website : 'http://www.ye-sul.co.kr',
					tel : '033-261-1525',
					image : 'http://www.ye-sul.co.kr/images/logo.png' // 첫 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '국순당',
					latlng : new kakao.maps.LatLng(37.487550003725424,
							128.19504574660732),
					address : '강원도 횡성군 둔내면 현천리 120',
					postcode : '(우) 25266',
					website : 'http://www.ksdb.co.kr',
					image : 'http://www.ksdb.co.kr/icing/imsi/ci.jpg', // 두 번째 오버레이에 표시할 이미지 URL
					tel : '033-261-1525',
					distillery : 'http://localhost:8080/sool/Kuksundang'

				},

				{
					title : '모월',
					latlng : new kakao.maps.LatLng(37.29941061244301,
							127.97344782694009),
					address : '강원 원주시 판부면 판부신촌길 84',
					postcode : '(우) 26505',
					website : 'http://www.mowall.co.kr/',
					tel : '033-748-8008',
					image : 'https://cdn-std-web-220-13.cdn-nhncommerce.com/hhaik71_godomall_com/data/skin/front/story_g/img/banner/9869501113dc8561114e96b32b182a00_64354.png' // 세 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '미담양조장',
					latlng : new kakao.maps.LatLng(37.6523264240245,
							127.77120612890327),
					address : '강원 홍천군 남면 남노일로 574-19',
					postcode : '(우) 25106',
					website : 'https://www.midamju.co.kr/',
					tel : '033-433-3839',
					image : 'https://www.midamju.co.kr/web/upload/category/editor/2020/11/25/title.jpg' // 세 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '산머루농원',
					latlng : new kakao.maps.LatLng(37.960045019926795,
							126.95762863051807),
					address : '경기 파주시 적성면 객현리 67-1',
					postcode : '(우) 25162',
					website : 'http://www.sanmeoru.com',
					tel : '031-958-4558',
					image : 'http://www.sanmeoru.com/jeonyul/images/layout/header/logo_san41.png' // 첫 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '배상면주가',
					latlng : new kakao.maps.LatLng(37.90599336448984,
							127.30934940315562),
					address : '경기도 포천시 화현면 화현리 512',
					postcode : '(우) 25266',
					website : 'https://www.soolsool.co.kr/',
					tel : '02-6917-8888',
					image : 'https://www.soolsool.co.kr/html/soolsool/_images/main/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '우리술',
					latlng : new kakao.maps.LatLng(37.82009296355001,
							127.35549299645979),
					address : '경기 가평군 하면 대보간선로 26, 29',
					postcode : '(우) 26505',
					website : 'http://www.woorisool.kr',
					tel : '02-3394-8561',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 세 번째 오버레이에 표시할 이미지 URL //조종양조장을 계승한 양조장 근대 이미지를 쓸꺼없어서 조종양조장으로씀 문제시 공용으로 변경
				},

				{
					title : '그린영농조합',
					latlng : new kakao.maps.LatLng(37.257467572067696,
							126.58253589524682),
					address : '경기도 안산시 단원구 뻐꾹산길 107',
					postcode : '(우) 25106',
					website : 'http://www.grandcoteau.co.kr',
					tel : '032-886-9873',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 세 번째 오버레이에 표시할 이미지 URL 공용이미지 사유)사진이 안따짐
				},

				{
					title : '배혜정도가',
					latlng : new kakao.maps.LatLng(37.14958076157803,
							126.96093970191166),
					address : '경기도 화성시 정남면 서봉로 835',
					postcode : '(우) 25266',
					website : 'http://www.baedoga.co.kr/',
					tel : '02-3462-7328',
					image : 'http://www.baedoga.co.kr/img/logo_dark.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '밝은세상영농조합',
					latlng : new kakao.maps.LatLng(36.9710677474385,
							126.87357461204847),
					address : '경기도 평택시 포승읍 충열길 37',
					postcode : '(우) 25266',
					website : 'https://www.instagram.com/tigercalyx/',
					tel : '031-683-0981',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 두 번째 오버레이에 표시할 이미지 URL 공용이미지 사유)인스타
				},

				{
					title : '좋은술',
					latlng : new kakao.maps.LatLng(37.000488311730244,
							126.98939008762025),
					address : '경기 평택시 오성면 숙성뜰길 108',
					postcode : '(우) 25266',
					website : 'https://jsul.modoo.at/',
					tel : '031-681-8929',
					image : 'https://modo-phinf.pstatic.net/20201220_209/1608441449485O6WuC_PNG/mosayvhwRM.png?type=f320_320', // 두 번째 오버레이에 표시할 이미지 URL
					distillery : 'http://localhost:8080/sool/goodsool'

				},

				{
					title : '술샘',
					latlng : new kakao.maps.LatLng(37.23349885301383,
							127.29861101327222),
					address : '경기도 용인시 처인구 양지면 죽양대로 2298-1',
					postcode : '(우) 25266',
					website : 'http://www.sulseam.com',
					image : 'http://www.sulseam.com/theme/daontheme_business10/html/image/top_logo.png', // 두 번째 오버레이에 표시할 이미지 URL
					tel : '070-4218-5225',
					distillery : 'http://localhost:8080/sool/soolsamm'
				},

				{
					title : '술아원',
					latlng : new kakao.maps.LatLng(37.245940322693144,
							127.64440251064579),
					address : '경기 여주 점봉길 93-12',
					postcode : '(우) 25266',
					website : 'https://soolawon.co.kr/',
					image : 'https://soolawon.co.kr/data/skin/default_gl/images/design/logo_90x90.png', // 두 번째 오버레이에 표시할 이미지 URL
					tel : '070-8288-1694',
					distillery : 'http://localhost:8080/sool/soolAone'
				},

				{
					title : '오산양조',
					latlng : new kakao.maps.LatLng(37.15450844370109,
							127.06913333078734),
					address : '경기 오산시 시장길 63',
					postcode : '(우) 25266',
					website : 'https://www.osansool.com/',
					tel : '031-374-2139',
					image : 'https://cdn-pro-web-240-197.cdn-nhncommerce.com/omai63_godomall_com/data/skin/front/awesome_D_C/img/etc/bt-logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '오미나라',
					latlng : new kakao.maps.LatLng(36.73613285339592,
							128.09136761702905),
					address : '경북 문경시 문경읍 새재로 609',
					postcode : '(우)36919',
					website : 'http://www.omynara.com/',
					image : 'https://www.omynara.com/wp-content/uploads/2017/08/%EC%98%A4%EB%AF%B8%EB%82%98%EB%9D%BC_160X43.png', // 첫 번째 오버레이에 표시할 이미지 URL 
					tel : '054-572-0601',
					distillery : 'http://localhost:8080/sool/Ominara'
				},

				{
					title : '문경주조',
					latlng : new kakao.maps.LatLng(36.772369953754904,
							128.31354291654216),
					address : '경상북도 문경시 동로면 노은리 192번지',
					postcode : '(우)36903',
					website : 'https://mgomijasul.modoo.at/',
					tel : '054-552-8252',
					image : 'https://modo-phinf.pstatic.net/20170109_4/1483887606888YPuXX_JPEG/mosaKMSoxI.jpeg?type=f320_320' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '명인안동소주',
					latlng : new kakao.maps.LatLng(36.6038742847714,
							128.5413564977596),
					address : '경북 안동시 풍산읍 산업단지6길 6',
					postcode : '(우)36619',
					website : 'http://www.adsoju.com',
					tel : '054-856-6903',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 세 번째 오버레이에 표시할 이미지 URL 공용이미지 사유)이미지보안
				},

				{
					title : '한국애플리즈',
					latlng : new kakao.maps.LatLng(36.43699529956324,
							128.72290014909538),
					address : '경북 의성군 단촌면 일직점곡로 755',
					postcode : '(우)37320',
					website : 'http://www.applewine.co.kr/',
					tel : '054-834-7800',
					image : 'https://www.applewine.co.kr/_images/ft_logo.png' // 세 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '은척양조장',
					latlng : new kakao.maps.LatLng(36.53113980994618,
							128.07012822345524),
					address : '경북 상주시 은척면 봉중2길 16-4',
					postcode : '(우)37104',
					website : 'https://takbaeki.modoo.at/',
					tel : '054-541-6409',
					image : 'https://modo-phinf.pstatic.net/20170128_138/1485598877264HF3Ry_PNG/mosa4NyoEe.png?type=f320_320' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '한국와인 뱅꼬레',
					latlng : new kakao.maps.LatLng(35.907099387901916,
							128.88283206983536),
					address : '경상북도 영천시 금호읍 원기리 414-2',
					postcode : '(우)38882',
					website : 'http://www.vincoreewinery.com/',
					tel : '054-333-3010',
					image : 'https://cdn.imweb.me/thumbnail/20210705/de939ea128be9.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '고도리 와이너리',
					latlng : new kakao.maps.LatLng(35.98326685089034,
							128.99886359455573),
					address : '경상북도 영천시 고경면 고도리 494-3',
					postcode : '(우)38904',
					website : 'http://고도리와인.com',
					tel : '054-335-3174',
					image : 'https://xn--299as4kvof95ouob.com/_wg/img/logo_on.png', // 두 번째 오버레이에 표시할 이미지 URL
					distillery : 'http://localhost:8080/sool/godori'
				},

				{
					title : '수도산와이너리',
					latlng : new kakao.maps.LatLng(35.874344166981395,
							128.04654187482046),
					address : '경상북도 김천시 증산면 금곡리 226-1번지',
					postcode : '(우)39696',
					website : 'https://smartstore.naver.com/sdsmeru',
					tel : '070-8065-4595',
					image : 'https://shop-phinf.pstatic.net/20230316_288/1678964738072Wa0dx_JPEG/%B9%E8%B3%CA3.jpg?type=w640' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '명가원',
					latlng : new kakao.maps.LatLng(35.56639192555853,
							127.7754757404286),
					address : '경상남도 함양군 지곡면 지곡창촌길 3',
					postcode : '(우)50018',
					website : 'http://www.mgwkorea.com',
					tel : '055-963-8992',
					image : 'https://cdn-pro-web-241-113.cdn-nhncommerce.com/solsontr4898_godomall_com/data/skin/front/fresh/img/banner/dc4d89861da876a3fb8154d45d96f0b1_17641.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '맑은내일',
					latlng : new kakao.maps.LatLng(35.16301944848959,
							128.612102498184),
					address : '경남 창원시 성산구 삼귀로 411-8 (귀산동)',
					postcode : '(우) 51706',
					website : 'https://www.good-tomorrow.co.kr/',
					tel : '010-4595-6353',
					image : 'https://www.good-tomorrow.co.kr/theme/shop_responsive_malgeunaeil/include/img/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '한산도가',
					latlng : new kakao.maps.LatLng(34.63567493871246,
							128.26613413454658),
					address : '경남 통영시 욕지면 천왕로 16-2 2층',
					postcode : '(우)53100',
					website : 'http://hansandoga.com/',
					tel : '070-4114-7081',
					image : 'http://hansandoga.com/theme/IDEN02/img/logo2.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '오름주가',
					latlng : new kakao.maps.LatLng(34.9864657570145,
							128.0554955218134),
					address : '사천시 미룡길 31-20',
					postcode : '(우) 25266',
					website : 'http://daraewineshop.co.kr/',
					tel : '055-855-3626',
					image : 'http://daraewineshop.co.kr/darae/logo.jpg' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '대밭고을',
					latlng : new kakao.maps.LatLng(35.05973898125098,
							127.95743156608428),
					address : '사천시 곤양면 후전길 16',
					postcode : '(우)52504',
					website : 'https://smartstore.naver.com/bamboosul',
					tel : '010-9321-4000',
					image : 'https://shop-phinf.pstatic.net/20221121_70/1668992503410APxGo_JPEG/pc.jpg?type=w640' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '밀양클래식술도가',
					latlng : new kakao.maps.LatLng(35.512736041361784,
							128.8582216971516),
					address : '경상남도 밀양시 단장면 표충로 176-5',
					postcode : '(우) 50417',
					website : 'https://www.instagram.com/montst123/',
					tel : '055-356-1616',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 두 번째 오버레이에 표시할 이미지 URL 공용이미지 사유)인스타
				},

				{
					title : '영농조합법인 밀향',
					latlng : new kakao.maps.LatLng(35.49868690525518,
							128.74940571267038),
					address : '경상남도 밀양시 북성로 62-1 1층',
					postcode : '(우) 50428',
					website : 'https://smartstore.naver.com/pinktakju',
					tel : '010-5067-1109',
					image : 'https://i.ibb.co/TYXmvfc/image.jpg' // 두 번째 오버레이에 표시할 이미지 URL 공용이미지 사유)로고없음
				},

				{
					title : '성포양조장',
					latlng : new kakao.maps.LatLng(34.90792213064868,
							128.51651485525827),
					address : '거제시,거제시 사등면 지석3길 3',
					postcode : '(우) 53275',
					website : 'http://www.seongpo.co.kr/',
					tel : '010-1324-4444',
					image : 'http://www.seongpo.co.kr/img/main/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '우포의아침',
					latlng : new kakao.maps.LatLng(35.53798564994001,
							128.46041007914351),
					address : '창녕군,대지면 대지농공단지길 40',
					postcode : '(우) 50319',
					website : 'https://smartstore.naver.com/upo2017',
					tel : '010-4595-6353',
					image : 'https://shop-phinf.pstatic.net/20210812_20/1628736218552kDo1K_PNG/pc1.png?type=w640' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '몬스터빌리지',
					latlng : new kakao.maps.LatLng(35.4152273495059,
							127.88477048790092),
					address : '산청군 산청읍 친환경로2720번길 73',
					postcode : '(우) 52225',
					website : 'https://smartstore.naver.com/monstervillage',
					tel : '055-974-2178',
					image : 'https://shop-phinf.pstatic.net/20211208_97/1638932516877Wwjuy_PNG/1207_%BD%BA%C5%E4%BE%EE%C0%CC%B8%A7_PC.png?type=w640' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '거창사과원예농협',
					latlng : new kakao.maps.LatLng(35.67183481269631,
							127.9350337537105),
					address : '경남 거창군 거창읍 거함대로 3452-41',
					postcode : '(우) 50147',
					website : 'https://kcapple.nonghyup.com/user/indexMain.do?siteId=kcapple',
					tel : '055-943-3244',
					image : 'https://kcapple.nonghyup.com/user/kcapple/mycodyimages/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '해플스팜사이더리',
					latlng : new kakao.maps.LatLng(35.715325203554166,
							127.89955097897263),
					address : '거창군 거창읍 가지리 799-5',
					postcode : '(우) 50124',
					website : 'https://smartstore.naver.com/happlesfarmcidery',
					tel : '010-5904-7562',
					image : 'https://shop-phinf.pstatic.net/20210914_299/1631605292944xk80j_PNG/Untitled-2-Recovered.png?type=w640' // 두 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '제주샘주',
					latlng : new kakao.maps.LatLng(33.44448251802017,
							126.33735209502413),
					address : '제주 제주시 애월읍 애언로 283',
					postcode : '(우) 25162',
					website : 'http://www.jejusaemju.co.kr',
					image : 'https://cdn.imweb.me/thumbnail/20211129/16757752434f6.png', // 첫 번째 오버레이에 표시할 이미지 URL
					tel : '064-799-4225',
					distillery : 'http://localhost:8080/sool/Jejusamju'
				},

				{
					title : '제주고소리술익는집',
					latlng : new kakao.maps.LatLng(33.384872700950986,
							126.79401462848973),
					address : '제주도 서귀포시 표선면 중산간동로 4726',
					postcode : '(우) 25266',
					website : 'http://jejugosorisul.com/',
					tel : '064-787-5046',
					image : 'https://www.jejugosorisul.com/res/images/top/cia.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '제주곶밭',
					latlng : new kakao.maps.LatLng(33.457233179927854,
							126.56429143976577),
					address : ' 제주시 제주대학로 102 제주테크노파크 바이오융합2호관 208호',
					postcode : '(우) 26505',
					website : 'https://www.instagram.com/jeju.gott.batt/',
					tel : '0507-1394-8312',
					image : 'https://shop-phinf.pstatic.net/20230411_272/1681178625611d5nzi_PNG/sddd.png?type=w640' // 세 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '태인합동주조장',
					latlng : new kakao.maps.LatLng(35.65141741389307,
							126.94488001795698),
					address : '전라북도 정읍시 태인면 태흥리 392-1',
					postcode : '(우)56115',
					website : 'https://taein.modoo.at/',
					tel : '063-534-4018 ',
					image : 'http://www.태인양조장.com/css/images/main/logo.png' // 첫 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '지리산 운봉주조',
					latlng : new kakao.maps.LatLng(35.43719614000475,
							127.52404627671716),
					address : '전라북도 남원시 운봉읍 서천리 622번지',
					postcode : '(우)55718',
					website : 'http://www.herbsul.com/',
					tel : '063-634-0009 ',
					image : 'http://www.herbsul.com/imgv2/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '청산녹수',
					latlng : new kakao.maps.LatLng(35.34521500243583,
							126.81284700733383),
					address : '전라남도 장성군 장섭읍 남양촌길 19',
					postcode : '(우)57209',
					website : 'https://smartstore.naver.com/bluegreenk',
					tel : '061-393-4141 ',
					image : 'https://shop-phinf.pstatic.net/20210726_248/1627279136354jsYbD_PNG/115333212550076757_-1973953854.png?type=w640' // 세 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '추성고을',
					latlng : new kakao.maps.LatLng(35.3663780118092,
							126.98528159323561),
					address : '전라남도 담양군 용면 추령로 29',
					postcode : '(우)57302',
					website : 'http://www.chusungju.co.kr',
					tel : '061-393-4141',
					image : 'https://modo-phinf.pstatic.net/20170125_181/1485314075006D5aUU_PNG/mosaUkBP6n.png?type=f320_320' // 세 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '대대로영농조합법인',
					latlng : new kakao.maps.LatLng(34.55229806138254,
							126.30347321311008),
					address : '전남 진도군 군내면 둔전리 98',
					postcode : '(우)58902',
					website : 'http://www.e-hongju.co.kr',
					tel : '061-542-2266',
					image : 'http://e-hongju.co.kr/wp-content/uploads/2017/12/w_logo.png' // 세 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '해창주조장',
					latlng : new kakao.maps.LatLng(34.51761669124835,
							126.53810574758961),
					address : '전남 해남군 화산면 해창길 1',
					postcode : '(우)59048',
					website : 'https://haechangjujo.modoo.at/',
					tel : '061-532-5152',
					image : 'https://modo-phinf.pstatic.net/20170109_214/1483952849455UWdsg_JPEG/mosarlBs7u.jpeg?type=f320_320' // 세 번째 오버레이에 표시할 이미지 URL
				},
				{
					title : '금풍양조',
					latlng : new kakao.maps.LatLng(37.63845213025968,
							126.49133387271675),
					address : '인천 강화군 길상면 삼랑성길 8',
					postcode : '(우) 23050',
					website : 'https://www.instagram.com/on_sul/',
					tel : '070-4400-1931',
					image : 'https://shop-phinf.pstatic.net/20211122_242/1637550077241u2Jkx_JPEG/%B7%CE%B0%ED_1111.jpg?type=w640' // 첫 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '금정산성 토산주',
					latlng : new kakao.maps.LatLng(35.25034562253184,
							129.05642883179692),
					address : '부산 금정구 산성로 453',
					postcode : '(우) 46237',
					website : 'http://www.sanmak.kr/',
					tel : ' 051-517-0202 ',
					image : 'http://www.sanmak.kr/images/logo.png' // 두 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '벗드림 양조장',
					latlng : new kakao.maps.LatLng(35.21393290375016,
							128.982044603811),
					address : '부산광역시 강서구 대저1동 2376-2 A동',
					postcode : '(우) 46702',
					website : 'https://butdream.modoo.at/',
					tel : ' 051-337-3762 ',
					image : 'https://modo-phinf.pstatic.net/20230208_111/1675829053347Ak2IB_JPEG/mosaPD1Bfp.jpeg?type=f320_320' // 세 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '복순도가',
					latlng : new kakao.maps.LatLng(35.57020272533078,
							129.11683794171975),
					address : '울산광역시 울주군 상북면 향산리 439',
					postcode : '(우) 44943',
					website : 'http://www.boksoon.com/',
					tel : ' 1577-6746',
					image : 'https://www.boksoon.com/web/upload/category/logo/cab1248a92a7832f40ed8ecf69fe39a6_srqN3FzeG_9_top.jpg' // 세 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '주방장 양조장',
					latlng : new kakao.maps.LatLng(36.36796895109804,
							127.31686000537574),
					address : '대전 유성구 노은서로 76번길 75-15',
					postcode : '(우) 34092',
					website : 'https://www.instagram.com/jubangjang_brewery/',
					tel : '0507-1342-4880',
					image : 'https://k.kakaocdn.net/dn/AdI75/btrJwpgXIPH/sZBOHl3u9tOJeIw4LTFumk/img_xl.jpg' // 세 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '달성주조',
					latlng : new kakao.maps.LatLng(35.727614491364974,
							128.43437762877406),
					address : '대구광역시 달성군 논공읍 비슬로208길 10',
					postcode : '(우) 42978',
					website : 'https://smartstore.naver.com/dalseongkr/products/8634065543',
					tel : '0507-1367-1911',
					image : 'https://shop-phinf.pstatic.net/20230612_138/1686536326441pTYwD_JPEG/87672106159349310_887016337.jpg?type=m120' // 세 번째 오버레이에 표시할 이미지 URL
				},

				{
					title : '월광주조',
					latlng : new kakao.maps.LatLng(35.146447133727534,
							126.92771705844622),
					address : '광주광역시 동구 필문대로 279 (동명동) 2층',
					postcode : '(우) 61449',
					website : 'https://moonlight-brewery.com/shopinfo/company.html',
					tel : '070-7729-1022',
					image : 'https://moonlight-brewery.com/web/urban_img/logo.png' // 세 번째 오버레이에 표시할 이미지 URL
				}

		];
		var Chungcheong = [
				new kakao.maps.LatLng(36.88359126845671, 126.77478160231092),
				new kakao.maps.LatLng(36.76184753769927, 126.6980712843757),
				new kakao.maps.LatLng(36.13819669581555, 127.2341883320937),
				new kakao.maps.LatLng(36.08003679972075, 126.80233711301648),
				new kakao.maps.LatLng(36.99706273399605, 127.87877618474425),
				new kakao.maps.LatLng(36.92220485992229, 128.35371683858602),
				new kakao.maps.LatLng(36.67704019195783, 127.48007865749041),
				new kakao.maps.LatLng(36.70162238828038, 127.54544238447356),
				new kakao.maps.LatLng(36.246971853078946, 127.6206163944885),
				new kakao.maps.LatLng(36.12622364473387, 127.74454096620207),
				new kakao.maps.LatLng(36.19209163123898, 127.93672023843477),
				new kakao.maps.LatLng(36.71424528801202, 127.60509400485338),
				new kakao.maps.LatLng(36.16672335847733, 127.82060170621504)

		];
		var jeju = [
				new kakao.maps.LatLng(33.44448251802017, 126.33735209502413),
				new kakao.maps.LatLng(33.384872700950986, 126.79401462848973),
				new kakao.maps.LatLng(33.457233179927854, 126.56429143976577) ];
		var Gangwon = [
				new kakao.maps.LatLng(37.79411570958423, 128.1692505239543),
				new kakao.maps.LatLng(37.487550003725424, 128.19504574660732),
				new kakao.maps.LatLng(37.29941061244301, 127.97344782694009),
				new kakao.maps.LatLng(37.6523264240245, 127.77120612890327) ];

		var Gyeongsang = [
				new kakao.maps.LatLng(36.73613285339592, 128.09136761702905),
				new kakao.maps.LatLng(36.772369953754904, 128.31354291654216),
				new kakao.maps.LatLng(36.6038742847714, 128.5413564977596),
				new kakao.maps.LatLng(36.43699529956324, 128.72290014909538),
				new kakao.maps.LatLng(36.53113980994618, 128.07012822345524),
				new kakao.maps.LatLng(35.907099387901916, 128.88283206983536),
				new kakao.maps.LatLng(35.98326685089034, 128.99886359455573),
				new kakao.maps.LatLng(35.874344166981395, 128.04654187482046),
				new kakao.maps.LatLng(35.56639192555853, 127.7754757404286),
				new kakao.maps.LatLng(35.16301944848959, 128.612102498184),
				new kakao.maps.LatLng(34.63567493871246, 128.26613413454658),
				new kakao.maps.LatLng(34.9864657570145, 128.0554955218134),
				new kakao.maps.LatLng(35.05973898125098, 127.95743156608428),
				new kakao.maps.LatLng(35.512736041361784, 128.8582216971516),
				new kakao.maps.LatLng(35.49868690525518, 128.74940571267038),
				new kakao.maps.LatLng(34.90792213064868, 128.51651485525827),
				new kakao.maps.LatLng(35.53798564994001, 128.46041007914351),
				new kakao.maps.LatLng(35.4152273495059, 127.88477048790092),
				new kakao.maps.LatLng(35.67183481269631, 127.9350337537105),
				new kakao.maps.LatLng(35.715325203554166, 127.89955097897263) ];

		var Gyeonggi = [
				new kakao.maps.LatLng(37.960045019926795, 126.95762863051807),
				new kakao.maps.LatLng(37.90599336448984, 127.30934940315562),
				new kakao.maps.LatLng(37.82009296355001, 127.35549299645979),
				new kakao.maps.LatLng(37.257467572067696, 126.58253589524682),
				new kakao.maps.LatLng(37.14958076157803, 126.96093970191166),
				new kakao.maps.LatLng(36.9710677474385, 126.87357461204847),
				new kakao.maps.LatLng(37.000488311730244, 126.98939008762025),
				new kakao.maps.LatLng(37.23349885301383, 127.29861101327222),
				new kakao.maps.LatLng(37.245940322693144, 127.64440251064579),
				new kakao.maps.LatLng(37.15450844370109, 127.06913333078734)

		];
		var Jeolla = [
				new kakao.maps.LatLng(35.65141741389307, 126.94488001795698),
				new kakao.maps.LatLng(35.43719614000475, 127.52404627671716),
				new kakao.maps.LatLng(35.34521500243583, 126.81284700733383),
				new kakao.maps.LatLng(35.3663780118092, 126.98528159323561),
				new kakao.maps.LatLng(34.55229806138254, 126.30347321311008),
				new kakao.maps.LatLng(34.51761669124835, 126.53810574758961),
				new kakao.maps.LatLng(35.73781597006896, 126.73659893044751)

		];

		var Metropolitan = [
				new kakao.maps.LatLng(37.63845213025968, 126.49133387271675),
				new kakao.maps.LatLng(35.25034562253184, 129.05642883179692),
				new kakao.maps.LatLng(35.21393290375016, 128.982044603811),
				new kakao.maps.LatLng(35.57020272533078, 129.11683794171975),
				new kakao.maps.LatLng(36.36796895109804, 127.31686000537574),
				new kakao.maps.LatLng(35.727614491364974, 128.43437762877406),
				new kakao.maps.LatLng(35.146447133727534, 126.92771705844622)

		];
		var Korean = [
				new kakao.maps.LatLng(36.88359126845671, 126.77478160231092),
				new kakao.maps.LatLng(36.76184753769927, 126.6980712843757),
				new kakao.maps.LatLng(36.13819669581555, 127.2341883320937),
				new kakao.maps.LatLng(36.08003679972075, 126.80233711301648),
				new kakao.maps.LatLng(36.99706273399605, 127.87877618474425),
				new kakao.maps.LatLng(36.92220485992229, 128.35371683858602),
				new kakao.maps.LatLng(36.67704019195783, 127.48007865749041),
				new kakao.maps.LatLng(36.70162238828038, 127.54544238447356),
				new kakao.maps.LatLng(36.246971853078946, 127.6206163944885),
				new kakao.maps.LatLng(36.12622364473387, 127.74454096620207),
				new kakao.maps.LatLng(36.19209163123898, 127.93672023843477),
				new kakao.maps.LatLng(36.71424528801202, 127.60509400485338),
				new kakao.maps.LatLng(36.16672335847733, 127.82060170621504),
				new kakao.maps.LatLng(33.44448251802017, 126.33735209502413),
				new kakao.maps.LatLng(33.384872700950986, 126.79401462848973),
				new kakao.maps.LatLng(33.457233179927854, 126.56429143976577),
				new kakao.maps.LatLng(37.79411570958423, 128.1692505239543),
				new kakao.maps.LatLng(37.487550003725424, 128.19504574660732),
				new kakao.maps.LatLng(37.29941061244301, 127.97344782694009),
				new kakao.maps.LatLng(37.6523264240245, 127.77120612890327),
				new kakao.maps.LatLng(36.73613285339592, 128.09136761702905),
				new kakao.maps.LatLng(36.772369953754904, 128.31354291654216),
				new kakao.maps.LatLng(36.6038742847714, 128.5413564977596),
				new kakao.maps.LatLng(36.43699529956324, 128.72290014909538),
				new kakao.maps.LatLng(36.53113980994618, 128.07012822345524),
				new kakao.maps.LatLng(35.907099387901916, 128.88283206983536),
				new kakao.maps.LatLng(35.98326685089034, 128.99886359455573),
				new kakao.maps.LatLng(35.874344166981395, 128.04654187482046),
				new kakao.maps.LatLng(35.56639192555853, 127.7754757404286),
				new kakao.maps.LatLng(35.16301944848959, 128.612102498184),
				new kakao.maps.LatLng(34.63567493871246, 128.26613413454658),
				new kakao.maps.LatLng(34.9864657570145, 128.0554955218134),
				new kakao.maps.LatLng(35.05973898125098, 127.95743156608428),
				new kakao.maps.LatLng(35.512736041361784, 128.8582216971516),
				new kakao.maps.LatLng(35.49868690525518, 128.74940571267038),
				new kakao.maps.LatLng(34.90792213064868, 128.51651485525827),
				new kakao.maps.LatLng(35.53798564994001, 128.46041007914351),
				new kakao.maps.LatLng(35.4152273495059, 127.88477048790092),
				new kakao.maps.LatLng(35.67183481269631, 127.9350337537105),
				new kakao.maps.LatLng(35.715325203554166, 127.89955097897263),
				new kakao.maps.LatLng(37.960045019926795, 126.95762863051807),
				new kakao.maps.LatLng(37.90599336448984, 127.30934940315562),
				new kakao.maps.LatLng(37.82009296355001, 127.35549299645979),
				new kakao.maps.LatLng(37.257467572067696, 126.58253589524682),
				new kakao.maps.LatLng(37.14958076157803, 126.96093970191166),
				new kakao.maps.LatLng(36.9710677474385, 126.87357461204847),
				new kakao.maps.LatLng(37.000488311730244, 126.98939008762025),
				new kakao.maps.LatLng(37.23349885301383, 127.29861101327222),
				new kakao.maps.LatLng(37.245940322693144, 127.64440251064579),
				new kakao.maps.LatLng(37.15450844370109, 127.06913333078734),
				new kakao.maps.LatLng(35.65141741389307, 126.94488001795698),
				new kakao.maps.LatLng(35.43719614000475, 127.52404627671716),
				new kakao.maps.LatLng(35.34521500243583, 126.81284700733383),
				new kakao.maps.LatLng(35.3663780118092, 126.98528159323561),
				new kakao.maps.LatLng(34.55229806138254, 126.30347321311008),
				new kakao.maps.LatLng(34.51761669124835, 126.53810574758961),
				new kakao.maps.LatLng(35.73781597006896, 126.73659893044751),
				new kakao.maps.LatLng(37.63845213025968, 126.49133387271675),
				new kakao.maps.LatLng(35.25034562253184, 129.05642883179692),
				new kakao.maps.LatLng(35.21393290375016, 128.982044603811),
				new kakao.maps.LatLng(35.57020272533078, 129.11683794171975),
				new kakao.maps.LatLng(36.36796895109804, 127.31686000537574),
				new kakao.maps.LatLng(35.727614491364974, 128.43437762877406),
				new kakao.maps.LatLng(35.146447133727534, 126.92771705844622) ];

		/* var points = [Chungcheong
		 new kakao.maps.LatLng(36.88359126845671,126.77478160231092),
		 new kakao.maps.LatLng(36.76184753769927,126.6980712843757),
		 new kakao.maps.LatLng(36.13819669581555,127.2341883320937),
		 new kakao.maps.LatLng(36.08003679972075,126.80233711301648),
		 new kakao.maps.LatLng(36.99706273399605,127.87877618474425),
		 new kakao.maps.LatLng(36.92220485992229,128.35371683858602),
		 new kakao.maps.LatLng(36.67704019195783,127.48007865749041),
		 new kakao.maps.LatLng(36.70162238828038,127.54544238447356),
		 new kakao.maps.LatLng(36.246971853078946,127.6206163944885),
		 new kakao.maps.LatLng(36.12622364473387,127.74454096620207),
		 new kakao.maps.LatLng(36.19209163123898,127.93672023843477),
		 new kakao.maps.LatLng(36.71424528801202,127.60509400485338),
		 new kakao.maps.LatLng(36.16672335847733,127.82060170621504)
		
		 ];

		 */

		/* 변수  기존 1차에 사용한 변수 
		var imageSrc 마커 이미지
		var markers = []; 마커들 배열
		var overlays = []; 오버레이 배열
		var map = new kakao.maps.Map(mapContainer, mapOption); 카카오 지도
		var mapContainer 카카오 지도 
		var marker 마커
		var overlay 오버레이
		var content 오버레이 내용
		 */

		/*  2차 추가 키워드로 장소검색하고 목록으로 표출하기
		
		var markers = [];  중복
		var mapContainer = document.getElementById('map')  중복
		var map = new kakao.maps.Map(mapContainer, mapOption); 중복
		
		
		
		
		//장소 검색 객체를 생성합니다 추가된 변수
		var ps = new kakao.maps.services.Places();  

		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다 추가된 변수
		var infowindow = new kakao.maps.InfoWindow({zIndex:1});
		
		//키워드 검색을 요청하는 함수입니다
		function searchPlaces() {

		    var keyword = document.getElementById('keyword').value;

		    if (!keyword.replace(/^\s+|\s+$/g, '')) {
		        alert('키워드를 입력해주세요!');
		        return false;
		    }
		    
		    var listEl = document.getElementById('placesList'), 
		    menuEl = document.getElementById('menu_wrap'),
		    fragment = document.createDocumentFragment(), 
		    bounds = new kakao.maps.LatLngBounds(), 
		    listStr = '';
		
		 */

		var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png';//마커 이미지 이게 야구공 이미지라서 다른걸로 바꾸면 될뜻?
		var markers = [];
		var overlays = [];

		var mapContainer = document.getElementById('map'), mapOption = {
			center : new kakao.maps.LatLng(36.53113980994618,
					128.07012822345524),
			level : 13
		};

		var map = new kakao.maps.Map(mapContainer, mapOption);

		for (var i = 0; i < positions.length; i++) {
			var markerImage = new kakao.maps.MarkerImage(imageSrc,
					new kakao.maps.Size(44, 49));

			var marker = new kakao.maps.Marker({
				map : map,
				position : positions[i].latlng,
				title : positions[i].title,
				image : markerImage
			});

			kakao.maps.event.addListener(marker, 'click', (function(marker, i) {
				return function() {
					openOverlay(i);
				}
			})(marker, i));

			markers.push(marker);
		}

		// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다

		// LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다// 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
		function setBounds() {
			var bounds = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Chungcheong.length; i++) {
				bounds.extend(Chungcheong[i]);
			}

			map.setBounds(bounds);
		}

		function setBounds2() {
			var bounds2 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < jeju.length; i++) {
				bounds2.extend(jeju[i]);
			}

			map.setBounds(bounds2);
		}

		function setBounds3() {
			var bounds3 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Gangwon.length; i++) {
				bounds3.extend(Gangwon[i]);
			}

			map.setBounds(bounds3);
		}

		function setBounds4() {
			var bounds4 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Gyeongsang.length; i++) {
				bounds4.extend(Gyeongsang[i]);
			}

			map.setBounds(bounds4);
		}

		function setBounds5() {
			var bounds5 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Gyeonggi.length; i++) {
				bounds5.extend(Gyeonggi[i]);
			}

			map.setBounds(bounds5);
		}

		function setBounds6() {
			var bounds6 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Jeolla.length; i++) {
				bounds6.extend(Jeolla[i]);
			}

			map.setBounds(bounds6);
		}

		function setBounds7() {
			var bounds7 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Metropolitan.length; i++) {
				bounds7.extend(Metropolitan[i]);
			}

			map.setBounds(bounds7);
		}

		function setBounds8() {
			var bounds8 = new kakao.maps.LatLngBounds();

			for (var i = 0; i < Korean.length; i++) {
				bounds8.extend(Korean[i]);
			}

			map.setBounds(bounds8);
		}

		function createOverlay(content, position) {
			var overlay = new kakao.maps.CustomOverlay({
				content : content,
				position : position,
				yAnchor : 1
			});

			return overlay;
		}

		function openOverlay(index) {
			closeOverlay();

			var overlay = overlays[index];

			if (!overlay) {
				var content = '<div class="wrap">' + '    <div class="info">'
						+ '        <div class="title">' + '            '
						+ positions[index].title
						+ '            <div class="close" onclick="closeOverlay('
						+ index
						+ ');"></div>'
						+ '        </div>'
						+ '        <div class="body">'
						+ '            <div class="img">'
						+ '                <img src="' + positions[index].image + '" width="73" height="71">'
						+ // 해당 오버레이에 표시할 이미지
						'           </div>'
						+ '            <div class="desc">'
						+ '                <div class="ellipsis">'
						+ positions[index].address
						+ '</div>'
						+ '                <div class="jibun ellipsis">'
						+ positions[index].postcode
						+ '</div>'
						+ '                <div class="tel">'
						+ positions[index].tel
						+ '</div>'
						+ '                <div>'
						+ '                    <a href="' + positions[index].website + '" target="_blank" class="link">홈페이지</a>'
						+ '                    <a href="' + positions[index].distillery + '" target="_blank" class="link">양조장 정보</a>'
						+ '                </div>'
						+ '            </div>'
						+ '        </div>' + '    </div>' + '</div>';
				overlay = createOverlay(content, markers[index].getPosition());
				overlays[index] = overlay;
			}

			overlay.setMap(map);
		}

		function closeOverlay(index) {
			for (var i = 0; i < overlays.length; i++) {
				if (overlays[i]) {
					overlays[i].setMap(null);
				}
			}
		}
	</script>
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>