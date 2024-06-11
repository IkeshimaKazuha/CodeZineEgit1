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
      <c:when test="${userManageModel.getAllUserManageList() != null}">
       <div class="soke">
        総件数：<span id="totalCount">${userManageModel.getAllUserManageList().size()}</span>件
       </div>
      </c:when>
	  <c:otherwise>
		総件数：<span id="totalCount">0</span>件
	   </c:otherwise>
  </c:choose>
 </div>
</td>
<!--   <td style="width:40px;border:none;text-align:right"> -->
		<c:set var="array" scope="request">選択,氏名,性別,生年月日,電話番号,メール,住所,所属,役職</c:set>
		<c:forEach var="item" items="${array}">	
		<td onclick="sort(this)">${item}   
 			</td>    
		</c:forEach>     
	</tr>
	<div name="検索結果一覧" id="div検索結果一覧">
		<c:if test="${not empty userManageModel.showUserManageList}">
    <c:forEach var="item" items="${userManageModel.showUserManageList}">
		<c:if test="${userManageModel.getShowUserManageList() != null}">
			<c:set var="i" value="0" scope="request" />
			<c:forEach var="item" items="${userManageModel.getShowUserManageList() }">
				<c:set var="i" value="${i+1}" scope="request"/>
			</c:forEach>
		</c:if>
				<tr onclick="sendData(this)">
					<td class="TextCenter">
						<input type="checkbox" id="selectUser_${item.getHibProfileInfoModel().getUserName() }" /></td>
					<td>${item.getHibProfileInfoModel().getUserName() }</td>
					<td class="TextCenter"><c:choose>
							<c:when test="${item.getHibProfileInfoModel().getSex() == 1 }">
								<c:out value="男" />
							</c:when>
							<c:when test="${item.getHibProfileInfoModel().getSex() == 2 }">
								<c:out value="女" />
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
                    <td>${item.getHibProfileInfoModel().getBirthday() }</td>
					<td>${item.getHibProfileInfoModel().getTel() }</td>
					<td>${item.getEmail() }</td>
					<td>${item.getHibProfileInfoModel().getAddress() }</td>
					<td>${item.getHibProfileInfoModel().getAffliation() }</td>
                    <td>${item.getHibProfileInfoModel().getPosition() }</td>
				</tr>
			</c:forEach>
		</c:if>
		</div>

		<!--空白の6列-->
	</table>
</div>	
	
	</body>