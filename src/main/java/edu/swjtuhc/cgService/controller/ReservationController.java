package edu.swjtuhc.cgService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.swjtuhc.cgService.model.News;
import edu.swjtuhc.cgService.model.Reservation;
import edu.swjtuhc.cgService.service.ReservationService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/create" ,method = RequestMethod.GET)
	public JSONObject create(@RequestBody Reservation n) {
		JSONObject result = new JSONObject(); 
		try {
			int i = reservationService.createReservation(n);
			if (i==-1) {
				result.put("state", "fail");
				result.put("msg", "老师名字不能为空");
			}else if (i==-2) {
				result.put("state", "fail");
				result.put("msg", "学生名字不能为空");
			}else if (i==-3) {
				result.put("state", "fail");
				result.put("msg", "预约时间不能为空");
			}else if (i==-4) {
				result.put("state", "fail");
				result.put("msg", "预约项目不能不空");
			}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "预约成功");
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}
		return result;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public JSONObject update(@RequestBody Reservation n) {
		JSONObject result = new JSONObject(); 
		try {
			int i = reservationService.updateReservation(n);
			if (i==-1) {
				result.put("state", "fail");
				result.put("msg", "老师名字不能为空");
			}else if (i==-2) {
				result.put("state", "fail");
				result.put("msg", "学生名字不能为空");
			}else if (i==-3) {
				result.put("state", "fail");
				result.put("msg", "预约时间不能为空");
			}else if (i==-4) {
				result.put("state", "fail");
				result.put("msg", "预约项目不能不空");
			}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "修改成功");
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}
		return result;
}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public JSONObject delete(@RequestBody Reservation n) {
		JSONObject result = new JSONObject(); 
		try {
			int i = reservationService.deleteReservation(n);
			 if(i==-1) {
        		result.put("state","fail");
        		result.put("msg", "编号不能为空");
        	}else if(i==0) {
        		result.put("state","fail");
        		result.put("msg", "内部错误");
        	}else if(i==1) {
        		result.put("state","success");
        		result.put("msg", "删除成功");
        	}
		} catch (Exception e) {
			e.printStackTrace(); 
			result.put("state","fail");
    		result.put("msg", "服务器内部错误");
		}
		return result;
}
	@RequestMapping(value="/getreservation",method=RequestMethod.GET)
	public List<Reservation> getList(){
		return reservationService.getReservationList();
	}
	@RequestMapping(value="/getAllreservation",method=RequestMethod.GET)
	public List<Reservation> getList2(){
		return reservationService.getAllReservationList();
	}

}
