package G_T.OfficeSystem.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//GetPageに利用するライブラリを追加
import org.springframework.web.bind.annotation.RequestParam;

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
 @RequestMapping(value = "/GetPage", method = RequestMethod.POST)
 public String GetPage(HttpSession session, Model model, @RequestParam int showNumber,
   @RequestParam int currentPage) {
  applicationModel.GetPage(showNumber, currentPage);
  model.addAttribute("applicationModel", applicationModel);
  return ("_ApplicationList");
 }
 
 @RequestMapping(value="/Sort", method = RequestMethod.POST)      
 public String Sort(HttpSession session,  Model model      
   , @RequestParam String sortColumn    
   , @RequestParam String sortOrder){    
       
  applicationModel.Sort(sortColumn, sortOrder);     
  model.addAttribute("applicationModel", applicationModel);     
       
  return ("_ApplicationList");     
 }   
 
}