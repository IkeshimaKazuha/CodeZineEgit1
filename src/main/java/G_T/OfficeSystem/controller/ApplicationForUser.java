package G_T.OfficeSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import G_T.OfficeSystem.model.ApplicationConditionModel;
import G_T.OfficeSystem.model.ApplicationModel;

@Controller
public class ApplicationForUser {
	@Autowired
	ApplicationModel applicationModel;

	@RequestMapping(value = "/ApplicationManage", method = RequestMethod.GET)
	public String ApplicationManage() {
		return "ApplicationManage";
	}

	@RequestMapping(value = "/ApplicationManage", method = RequestMethod.POST)
	public String ApplicationManage(HttpSession session, ApplicationConditionModel condition, Model model) {
		applicationModel.ApplyUser(condition);
		model.addAttribute("applicationModel", applicationModel);
		return ("_ApplicationList");
	}
}
