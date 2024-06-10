package G_T.OfficeSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}