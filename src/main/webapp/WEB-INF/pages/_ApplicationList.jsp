<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<body>

	<div class="background">

		<table class="table" border="3" name="table">

			<td colspan="5" style="border-right: none" class="aaa">
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
			<td style="border-left: none; border-right: none; text-align: right"
				class="bbb">表示件数：</td>
			<!-- <td style="width:80px;border:none"> -->
			<td style="border-left: none" class="ccc"><c:set var="disabled"
					value="" /> <c:if
					test="${applicationModel.getAllApplicationList() == null}">
					<c:set var="disabled" value="disabled" />
				</c:if> <select class="Select select2" name="showNumber" id="showNumber"
				style="width: 100%; float: right" ${disabled}>
					<c:set var="array" scope="request">0,5,10,20,50,100</c:set>
					<c:forEach var="item" items="${array}">
						<c:choose>
							<c:when test="${applicationModel.getShowNumber() == item}">
								<c:set var="selected" value="selected" scope="request" />
							</c:when>
							<c:otherwise>
								<c:set var="selected" value="" scope="request" />
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${item == 0}">
								<c:set var="text" value="すべて" scope="request" />
							</c:when>
							<c:otherwise>
								<c:set var="text" value="${item}件" scope="request" />
							</c:otherwise>
						</c:choose>
						<option value="${item}" ${selected}>${text}</option>
					</c:forEach>
			</select></td>

			<tr>
				<c:set var="array" scope="request">状態,申請ID,申請書類,タイトル,申請日,承認日,連絡事項</c:set>

				<c:forEach var="item" items="${array}">
					<td onclick="sort(this)">${item} <span> <c:if
								test="${applicationModel.getSortColumn() == item}">
								<br />${applicationModel.getSortOrder()} 
   					</c:if>
					</span>
					</td>
				</c:forEach>
			</tr>
			<div name="検索結果一覧" id="div検索結果一覧">
				<c:if test="${applicationModel.getShowApplicationList() != null}">
					<c:set var="i" value="0" scope="request" />

					<c:forEach var="item"
						items="${applicationModel.getShowApplicationList()}">
						<c:set var="i" value="${i+1}" scope="request" />
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
		</table>
	</div>

	<!--空白の6列-->
	<c:if
		test="${applicationModel.getShowApplicationList() != null 
		&& applicationModel.getShowApplicationList().size() < applicationModel.getAllApplicationList().size()}">
		<tr>
			<td colspan="7" style="border:none;">
			 <div style="float:right">
		 
			  <c:choose>
			   <c:when test="${applicationModel.getCurrentPage() == 1}">
				<input type="image" src="${pageContext.request.contextPath}/img/left_triangle_disable.png"   
		   id="previousPage" style="width:30px;float:left" />
			   </c:when>
			   <c:otherwise>    
			  
			   <input type="image" src="${pageContext.request.contextPath}/img/left_triangle.png" id="previousPage"    
				 style="width:30px;float:left" /> 
				 </c:otherwise>    
				</c:choose>
			  <select class="Select" name="currentPage" id="currentPage"          
				  style="width:60px;height:30px;float:left;margin:0px 5px 0px 5px;">       
				<c:set var="modulo" value="${applicationModel.getAllApplicationList().size() % applicationModel.getShowNumber()}"         
				   scope="request"/>      
				<c:set var="plus" value="${(modulo == 0? 0:1)}" scope="request"/>        
				<c:set var="loopCount" value="${applicationModel.getAllApplicationList().size() / applicationModel.getShowNumber() + plus}"         
				   scope="request"/>      
				 <c:if test="${applicationModel.getShowNumber() != 0         
					  && (applicationModel.getAllApplicationList().size() / applicationModel.getShowNumber() + 1) >= 1}">    
				<c:forEach var="loop" begin="1" end="${loopCount}">
		 
				<c:choose>   
				<c:when test="${applicationModel.getCurrentPage() == loop}">  
				 <option selected value="${loop}">${loop}</option> 
				</c:when>  
				<c:otherwise>  
				 <option value="${loop}">${loop}</option> 
				</c:otherwise>  
				  </c:choose>   
				 </c:forEach>    
				</c:if>     
			   </select>
		   <fmt:parseNumber var="numberData" value="${applicationModel.getAllApplicationList().size() / applicationModel.getShowNumber() + 1}"    
		   integerOnly="true" /> 
		  <c:choose>
		   <c:when test="${applicationModel.getCurrentPage() == numberData }">
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
</body>


