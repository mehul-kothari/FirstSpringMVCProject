package com.employeemanagementportal;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

@Controller
public class EmployeeManagementController {

	@RequestMapping(value="/{typeOfUser}/loginForm.html", method = RequestMethod.GET)
	public ModelAndView getLoginForm(@PathVariable("typeOfUser") String typeOfUser) {

		ModelAndView model = new ModelAndView("EmployeeLoginForm");
		model.addObject("userType", typeOfUser);

		return model;
	}
	@RequestMapping(value="/XyzCompany.html", method = RequestMethod.GET)
	public ModelAndView getUserType() {

		ModelAndView model = new ModelAndView("XyzCompany");
		//model.addObject("userType", typeOfUser);

		return model;
	}
	
	//@RequestMapping("/submitAdmissionForm.html")
	//public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name, @RequestParam("studentHobby") String hobby) {

//		ModelAndView model = new ModelAndView("AdmissionSuccess");
//		model.addObject("msg","Details submitted by you:: Name: "+name+ ", Hobby: " + hobby);

//		return model;
//	}

	@RequestMapping(value="/{userType}/submitLoginForm.html", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestParam Map<String,String> reqPar, @PathVariable("userType") String typeOfUser) {
		//EmployeeLoginDetails employee1=new EmployeeLoginDetails();
		//employee1.setEmployeeID(Integer.valueOf(reqPar.get("employeeID")));
		//employee1.setEmployeePassword(reqPar.get("employeePassword"));
		String id = reqPar.get("employeeID");
		String pd = reqPar.get("employeePassword");
		System.out.println(pd);
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		if(typeOfUser.equals("Employee"))
		{
			EmployeeLoginDetails employee=new EmployeeLoginDetails();
		employee = (EmployeeLoginDetails) session.get(EmployeeLoginDetails.class, Integer.parseInt(id));
		if(employee==null || pd!=employee.getEmployeePassword())
		{
			
				ModelAndView model = new ModelAndView("EmployeeLoginForm");
				model.addObject("userType", typeOfUser);
				return model;
			
		}
		}
		else
		{
			Admin admin=new Admin();
			admin = (Admin) session.get(Admin.class, Integer.parseInt(id));
			if(admin==null || pd!=admin.getPassword())
			{
				
				ModelAndView model = new ModelAndView("Admin");
				model.addObject("msg","Details submitted by you:: Name: "+id+ ", Hobby: " + pd);
				return model;
				
			}
		}
		
		/*Query query = session.createQuery("from Admin where AdminId = :id ");
		query.setParameter("id", Integer.parseInt(id));
		List list = query.list();*/
		
		//System.out.println(admin);
		//session.save(employee1);
		//session.getTransaction().commit();
		
		
		

		ModelAndView model = new ModelAndView("Admin");
		model.addObject("msg","Details submitted by you:: Name: "+id+ ", Hobby: " + pd);

		return model;
	}
}
