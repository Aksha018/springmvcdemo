package com.chainsys.leaveapplicationmanagement.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.leaveapplicationmanagement.dao.LeaveDao;
import com.chainsys.leaveapplicationmanagement.model.Leave;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	@Autowired
	LeaveDao leaveDao;
	
	@GetMapping("/addleave")
	public String insert() {
	  return "/add-leave.jsp";
	}

	@GetMapping("applyleave")
	public String insertLeave(@RequestParam("leaveId") int leaveId, @RequestParam("leaveType") String leaveType, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate, @RequestParam("id") int id, Model model) {
		            LocalDate date = LocalDate.parse(fromDate);
					LocalDate date1 = LocalDate.parse(toDate);
					Date leaveDate = Date.valueOf(date);
					Date leaveDate1 = Date.valueOf(date1);
					long noOfDays = ChronoUnit.DAYS.between(date, date1);

					Leave leave = new Leave();

					 leave.setLeaveId(leaveId);
					 leave.setLeaveType(leaveType);
					 leave.setFromDate(leaveDate);
					 leave.setToDate(leaveDate1);
					 leave.setNoOfDays(noOfDays);
					 leave.setId(id);
		
   int addLeave = leaveDao.applyLeave(leave);
   List<Leave> leaveList = leaveDao.listLeave();
   model.addAttribute(leaveList);
   return "/list-leave.jsp";
	}
	 
	@GetMapping("/updateform")
	public String update() {
	  return "/update-leave.jsp";
	}
@GetMapping("update")
public String updateLeave(@RequestParam("leaveType") String leaveType, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate, @RequestParam("id") int id,@RequestParam("leaveId")int leaveId , Model model) {
	LocalDate date = LocalDate.parse(fromDate);
	LocalDate date1 = LocalDate.parse(toDate);
	Date leaveDate =Date.valueOf(date);
	Date leaveDate1 = Date.valueOf(date1);
	long noOfDays1 = ChronoUnit.DAYS.between(date, date1);
	
	Leave leave = new Leave();
	
	leave.setLeaveType(leaveType);
	leave.setFromDate(leaveDate);
	leave.setToDate(leaveDate1);
	leave.setNoOfDays(noOfDays1);
	leave.setId(id);
	leave.setLeaveId(leaveId);
	
	int update = leaveDao.updateLeave(leave);
	List<Leave> leavelist = leaveDao.listLeave();
	model.addAttribute(leavelist);
	return "/list-leave.jsp";
	
}
    @GetMapping("/deleteform")
     public String delete() {
	   return "/delete-leave.jsp";
   }
    @GetMapping("delete")
    public String deleteLeave(@RequestParam("leaveId")int leaveId, Model model) {
    	
    	int delete = leaveDao.deleteLeave(leaveId);
    	
    	List<Leave> leavelist = leaveDao.listLeave();
    	model.addAttribute(leavelist);
    	return "/list-leave.jsp";
    }
    @GetMapping("/findbyidform")
    public String findByIds() {
    	return "/findby-leaveid.jsp";
    }
    @GetMapping("findbyleaveid")
    public String findByLeaveId(@RequestParam("leaveId")int leaveId, Model model) {
    	Leave leaveId1 = leaveDao.findByLeaveId(leaveId);
    	List<Leave> leavelist = new ArrayList<>();
    	leavelist.add(leaveId1);
    	model.addAttribute(leavelist);
    	return "/list-leave.jsp";
    	
    	
    }
  
}