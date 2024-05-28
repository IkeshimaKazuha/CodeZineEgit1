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
						<td colspan="7" style="border-right:none" class="aaa">
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
	
						<!-- <td style="width:80px;border:none"> -->
					</tr>
					<tr>
						<tr style="border-bottom: 2px solid #69a4d8; height: 40px">
							<td style="width: 8%" class="TextCenter">状態</td>
							<td style="width: 8%" class="TextCenter">申請ID</td>
							<td style="width: 15%" class="TextCenter">申請書類</td>
							<td style="width: 15%" class="TextCenter">タイトル</td>
							<td style="width: 20%" class="TextCenter">申請日</td>
							<td style="width: 20%" class="TextCenter">承認日</td>
							<td style="width: *" class="TextCenter">連絡事項</td>
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
	
				</table>
			</div>
		</body>

	
</html>
