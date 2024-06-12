package G_T.OfficeSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import G_T.OfficeSystem.model.UserManageConditionModel;
import G_T.OfficeSystem.model.UserManageModel;

@Controller
public class UserManagement {
	@Autowired
	UserManageModel userManageModel;

	@RequestMapping(value = "/UserManage", method = RequestMethod.GET)
	public String UserManage() {
		return "UserManage";
	}

	@RequestMapping(value = "/UserManage", method = RequestMethod.POST)
	public String UserManage(HttpSession session, UserManageConditionModel condition, Model model) {
		userManageModel.MUser(condition);
		model.addAttribute("userManageModel", userManageModel);
		return ("_UserManageList");
	}
	
	//書類申請画面　ソート
		@RequestMapping(value="/Sort_UserM", method = RequestMethod.POST)
			public String Sort(HttpSession session,  Model model
					, @RequestParam String sortColumn
					, @RequestParam String sortOrder){

				userManageModel.SortAll(sortColumn, sortOrder);//sort
				model.addAttribute("userManageModel", userManageModel);
				return ("_UserManageList");
			}

			//書類申請画面　ページ取得
	   @RequestMapping(value = "/GetPage_UserM", method = RequestMethod.POST)
		 public String GetPage(HttpSession session, Model model, @RequestParam int showNumber,
		   @RequestParam int currentPage) {
		  userManageModel.GetPage(showNumber, currentPage);
		  model.addAttribute("userManageModel", userManageModel);
		  return ("_UserManageList");
		 }
	
}