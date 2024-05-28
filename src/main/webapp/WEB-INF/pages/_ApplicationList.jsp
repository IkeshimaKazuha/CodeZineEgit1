<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<body>
	<%-- 					alert(${applicationInfoModel.getAllApplicationList()!=null});
						alert(${applicationInfoModel.getShowApplicationList().size()});
						alert(${applicationInfoModel.getAllApplicationList().size()}); --%>
	
		<div class="background">
	
				<table class="table" border="3" name="table">
					<colgroup>
						<col style='width:60px;'>
						<col style='width:80px;'>
						<col style='width:150px;'>
						<col style='width:150px;'>
						<col style='width:120px;'>
						<col style='width:120px;'>
						<col style='width:200px;'>
					</colgroup>
					<tr class="ue">
						<td colspan="5" style="border-right:none" class="aaa">
							<div class="ddd">
									<c:choose>
										<c:when test="${applicationInfoModel.getAllApplicationList() != null}">
											<div class="soke">
												総件数：<span id="totalCount">${applicationInfoModel.getAllApplicationList().size()}</span>件
											</div>
										</c:when>
										<c:otherwise>
											総件数：<span id="totalCount">0</span>件
										</c:otherwise>
									</c:choose>
							</div>
						</td>
						<!-- 		<td style="width:40px;border:none;text-align:right"> -->
						<td style="border-left:none;border-right:none;text-align:right" class="bbb">
							表示件数：
						</td>
						<!-- <td style="width:80px;border:none"> -->
						<td style="border-left:none" class="ccc">
							<c:set var="disabled" value=""/>
							<c:if test="${applicationInfoModel.getAllApplicationList() == null}">
								<c:set var="disabled" value="disabled"/>
							</c:if>
							<select class="Select select2" name="showNumber" id="showNumber" style="width:100%;float:right" ${disabled}>
								<c:set var="array" scope="request" >0,5,10,20,50,100</c:set>
								<c:forEach var="item" items="${array}">
									<c:choose>
										<c:when test="${applicationInfoModel.getShowNumber() == item}">
											   <c:set var="selected" value="selected" scope="request"/>
										</c:when>
										<c:otherwise>
											<c:set var="selected" value="" scope="request"/>
										</c:otherwise>
									</c:choose>
									   <c:choose>
										<c:when test="${item == 0}">
											   <c:set var="text" value="すべて" scope="request"/>
										</c:when>
										<c:otherwise>
											<c:set var="text" value="${item}件" scope="request"/>
										</c:otherwise>
									</c:choose>
									<option value="${item}" ${selected}>${text}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<c:set var="array" scope="request">状態,申請ID,申請書類,タイトル,申請日,承認日,連絡事項</c:set>
						<%-- <c:set var="array_width" scope="request">100px,200px,250px,250px,200px,200px,250px</c:set> --%>
						<c:forEach var="item" items="${array}" >
							<td onclick="sort(this)" align="center">
								${item}
								<span>
									<c:if test="${applicationInfoModel.getSortColumn() == item}">
										<br />${applicationInfoModel.getSortOrder()}
									</c:if>
								</span>
							</td>
						</c:forEach>
					</tr>
					<c:if test="${applicationInfoModel.getAllApplicationList() != null}">
						<c:forEach var="item" items="${applicationInfoModel.getShowApplicationList()}">
							 <tr onclick="sendData(this)">
								 <td class="applyStatus">${item.getApplyStatus()}</td>
								<td class="applyId">${item.getApplyId()}</td>
								<td class="applyFile">${item.getApplyFile()}</td>
								<td class="title">${item.getTitle()}</td>
								<td class="applyTime">${item.getApplyTime()}</td>
								<td class="approveTime">${item.getApproveTime()}</td>
								<td class="noticeMatter">${item.getNoticeMatter()}</td>
							</tr>
						</c:forEach>
					</c:if>
	
					<c:if test="${applicationInfoModel.getAllApplicationList() != null
									&& applicationInfoModel.getShowApplicationList().size() < applicationInfoModel.getAllApplicationList().size()}">
						<tr>
							<td colspan="7" style="border:none;">
								<div style="float:right">
									<c:choose>
										<c:when test="${applicationInfoModel.getCurrentPage() == 1}">
											<input type="image" src="${pageContext.request.contextPath}/img/left_triangle_disable.png"
													id="previousPage" style="width:30px;float:left" />
										   </c:when>
										   <c:otherwise>
											   <input type="image" src="${pageContext.request.contextPath}/img/left_triangle.png" id="previousPage"
													style="width:30px;float:left" />
										   </c:otherwise>
									   </c:choose>
									   <select class="Select" name="currentPage" id="currentPage" class="currentPage"
											style="width:60px;height:30px;float:left;margin:0px 5px 0px 5px;">
										<c:set var="modulo" value="${applicationInfoModel.getAllApplicationList().size() % applicationInfoModel.getShowNumber()}"
												scope="request"/>
										<c:set var="plus" value="${(modulo == 0? 0:1)}" scope="request"/>
										<c:set var="loopCount" value="${applicationInfoModel.getAllApplicationList().size() / applicationInfoModel.getShowNumber() + plus}"
												scope="request"/>
										<c:if test="${findModel.getShowNumber() != 0
														&& (applicationInfoModel.getAllApplicationList().size() / applicationInfoModel.getShowNumber() + 1) >= 1}">
											<c:forEach var="loop" begin="1" end="${loopCount}">
												<c:choose>
													<c:when test="${applicationInfoModel.getCurrentPage() == loop}">
														<option selected value="${loop}">${loop}</option>
													</c:when>
													<c:otherwise>
														<option value="${loop}">${loop}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
									<fmt:parseNumber var="numberData" value="${applicationInfoModel.getAllApplicationList().size() / applicationInfoModel.getShowNumber()}" integerOnly="true" />
									<c:choose>
										<c:when test="${applicationInfoModel.getAllApplicationList().size() % applicationInfoModel.getShowNumber() != 0}">
											<fmt:parseNumber var="numberData2" value="${numberData+1}" integerOnly="true" />
										</c:when>
										<c:otherwise>
											<fmt:parseNumber var="numberData2" value="${numberData}" integerOnly="true" />
										</c:otherwise>
									</c:choose>
									<%-- <c:out value="${numberData}*${numberData2}"></c:out> --%>
									   <c:choose>
										   <c:when test="${applicationInfoModel.getCurrentPage() == numberData2 }">
											<input type="image" src="${pageContext.request.contextPath}/img/right_triangle_disable.png"
													id="nextPage" style="width:30px;float:left" />
										   </c:when>
										   <c:otherwise>
											   <input type="image" src="${pageContext.request.contextPath}/img/right_triangle.png" id="nextPage"
													style="width:30px;float:left" />
										   </c:otherwise>
									   </c:choose>
								</div>
							</td>
						</tr>
					</c:if>
				</table>
			</div>
		</body>
		<script>
			function sendData(obj) {
				var applyStatus = obj.getElementsByClassName("applyStatus")[0].innerHTML;
				var applyId = obj.getElementsByClassName("applyId")[0].innerHTML;
				var applyFile = obj.getElementsByClassName("applyFile")[0].innerHTML;
				var title = obj.getElementsByClassName("title")[0].innerHTML;
	/* 			var currentPage = obj.getElementsByClassName("currentPage")[0].innerHTML;
				var showNumber = obj.getElementsByClassName("showNumber")[0].innerHTML;
				var sortColumn = obj.getElementsByClassName("sortColumn")[0].innerHTML;
				var sortOrder = obj.getElementsByClassName("sortOrder")[0].innerHTML; */
				var status = document.getElementById("status").value;
				//alert(status+"*");
	
				//var a = encodeURI(applyFile);
				//var b = encodeURI(title);
				x = (screen.width) / 1;
				y = (screen.height) / 1;
	
				var URI = "applyStatus="+applyStatus+"&applyId="+applyId+"&applyFile="+applyFile +"&title="+title +"&status="+status;
				//var URI = "applyStatus="+applyStatus+"&applyId="+applyId+"&applyFile="+applyFile +"&title="+title+
				//currentPage,applyStatus,showNumber,sortColumn,sortOrder
				//alert(URI);
				var ApplicationInfoWindow = window.open( "ApplicationInsertDataGet?"+URI,"a","screenX=0,screenY=0,left=0,top=0,width="+(x-10)+",height="+(y-90)+",scrollbars=1,toolbar=1,menubar=1,staus=1,resizable=1");
	/* 			var ApplicationInfoWindow = window.open( "ApplicationInsertDataGet?"
						+"applyStatus="+applyStatus+"&applyId="+applyId+"&applyFile="+a +"&title="+b
						,"a","screenX=0,screenY=0,left=0,top=0,width="+x+",height="+y+",scrollbars=1,toolbar=1,menubar=1,staus=1,resizable=1"); */
	/*
				var fd = new FormData();
				fd.append("applyStatus",applyStatus);
				fd.append("applyId",applyId);
				fd.append("applyFile",applyFile);
				fd.append("title",title);
	
				$.ajax({
					url  : "${pageContext.request.contextPath}/ApplicationInsertData",
					type : "post",
					data:fd,
					processData: false,
					contentType: false
				})
				.done(function(data, textStatus, jqXHR){
					//console.error(jqXHR.responseText);
				})
				.fail(function(jqXHR, textStatus, errorThrown){
					//console.error(jqXHR.responseText);
				}); */
	
			}
	
	
		</script>
	
	
