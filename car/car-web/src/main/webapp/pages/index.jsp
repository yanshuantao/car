<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<c:set var="urls" value="<%=request.getContextPath()%>"></c:set>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"> -->
	<script type="text/javascript">
	 var phoneWidth = parseInt(window.screen.width); 
	 var phoneScale = phoneWidth/640; 
	 var ua = navigator.userAgent; 
	 if (/Android (\d+\.\d+)/.test(ua)){ 
		var version = parseFloat(RegExp.$1);
		if(version>2.3){ 
			document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">'); 
		}else{ 
			document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">'); 
		} 
	} else { 
		document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">'); 
	} 
</script>
    
    <title>汽车商城</title>
    <link rel="stylesheet" href="${urls}/wxui/weui.css"/>
    <link rel="stylesheet" href="${urls}/wxui/example.css"/>
    <link rel="stylesheet" href="${urls}/css/web.css"/>
</head>
<body ontouchstart>
		<%-- <div>
           <ul class="searchDataContainer clearfix">
               <!--数据循环 开始-->
				<c:forEach items="${carList}" var="car">
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                
	                
	                
	                
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
	                <li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
	                </li>
               <!--数据循环 结束-->
			   </c:forEach>
               
           </ul>
           <div class="clearfloat"></div>
        </div> --%>
        <div>
        	<ul>
        		<li class="channelConCenterData searchSliderControl fl re">
               			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="150">
                       		</div>
                   		</a>
	                    <p class="channelConCenterDataP1 color333 ellipsis" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="channelConCenDataBot">
	                    			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                      		  <!-- <span class="fr color999">1课时</span> -->
	                        
	                    </div>
	                    <!-- <div class="clearfix searchDataBot">
	                        <span class="fr color999">0人学习</span>
	                    </div> -->
                </li>
        		<li class="li1">
        			    <a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
                   			<div style="position:relative;">
	                        	<img src="${car.imgStr}" width="100%">
                       		</div>
                   		</a>
                   		<p class="" title="${car.name}">
                			<a href="/dptweb/goods/findGoodsDetail.action?goodsId=10734" target="_blank">
	                			${car.name}
	                		</a>
	                    </p>
	                    <div class="">
                   			<span class="fl f14">${car.priceLow}~${car.priceHigh}</span>
	                    </div>
	                    
        			
        		</li>
        		<li class="li1">内容1</li>
        		<li class="li1">内容1</li>
        		<li class="li1">内容1</li>
        		<li class="li1">内容1</li>
        		<li class="li1">内容1</li>
       		</ul><div class="clearfloat"></div>
        </div>
</body>
</html>
