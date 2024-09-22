<%@ page contentType = "text/html;charset=UTF-8" language="java"%>
<%-- tiles framework 선언부 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
</head>



<body>
    <div id="header">
	<!-- Tiles header 영역 -->
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="body" class="col-sm-7 text-left">
    			<!-- Tiles main 영역 -->
    	 		<tiles:insertAttribute name="body"/>
    		</div>
</body>
</html>