<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<body>
	
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
			
						<td colspan="5" style="border-right:none" class="aaa">
							<div class="ddd">	
							<c:choose>
										<c:when test="${applicationModel.getAllApplicationList() != null}">
											<div class="soke">
												総件数：<span id="totalCount">${applicationModel.getAllApplicationList().size()}</span>件
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
					
					<tr>
						<c:set var="array" scope="request">状態,申請ID,申請書類,タイトル,申請日,承認日,連絡事項</c:set>
						<c:forEach var="item" items="${array}" >
				<td onclick="sort(this)" align="center">
							${item}
							<span>   
								<c:if test="${findModel.getSortColumn() == item}">  
								   <br />${findModel.getSortOrder()} 
								  </c:if>  
							  </span>  
						</td>
						</c:forEach>
					</tr>
					<div name="検索結果一覧" id="div検索結果一覧">
					<c:if test="${applicationModel.getAllApplicationList() != null}">
							<c:set var="i" value="0" scope="request" />

							<c:forEach var="item" items="${applicationModel.getAllApplicationList()}">
								<c:set var="i" value="${i+1}" scope="request"/>
							 <tr onclick="sendData(this)">
								<td class="TextCenter"><c:choose>
									<c:when test="${item.getApplyStatus() == 0 }">
										<c:out value="未承認" />
									</c:when>
									<c:when test="${item.getApplyStatus() == 1 }">
										<c:out value="承認済" />
									</c:when>
									<c:when test="${item.getApplyStatus() == 2 }">
										<c:out value="自分差し戻し" />
									</c:when>
									<c:when test="${item.getApplyStatus() == 3 }">
										<c:out value="差し戻し" />
									</c:when>
									<c:when test="${item.getApplyStatus() == 4 }">
										<c:out value="削除済" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose></td>

								<td>${item.getApplyId()}</td>
								<td>${item.getApplyFile()}</td>
								<td>${item.getTitle()}</td>
								<td>${item.getApplyTime()}</td>
								<td>${item.getApproveTime()}</td>
								<td>${item.getNoticeMatter()}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${applicationModel.getAllApplicationList() != null
									&& applicationModel.getShowApplicationList().size() < applicationModel.getAllApplicationList().size()}">
					</c:if>
					
				</table>
			</div>
		</body>
			
	
