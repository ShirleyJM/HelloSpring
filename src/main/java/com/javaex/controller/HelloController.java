package com.javaex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.vo.UserVo;

@Controller //난 컨트롤러야 *
public class HelloController {
	@RequestMapping( "/hello")
	public String hello(){
		System.out.println("/hellospring/hello");
		return "/WEB-INF/views/index.jsp";
	}	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(){
		System.out.println("/hellospring/main");
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String form(){
		
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute UserVo userVo){
			//위에 짧게 선언해 줌. -> 스스로 new()해 줌. 우리가 따로 해줄 필요 없음.
					/*@RequestParam("age") int age,
					@RequestParam("name") String name*/
		
		
/*//		UserVo vo = new UserVo(age, name);
		System.out.println(age);
		System.out.println(name);*/
		System.out.println(userVo.toString());
		return "";
	}
	
	
	@RequestMapping(value="/read/{no}", method=RequestMethod.GET)//{ }안의 내용은 변수 값
	public String read(@PathVariable("no") int no){ //변수를 내가 정한 int의 no 변수에 담아준다
		
		System.out.println(no + "번 글 가져오기");
		
		return "";
	}
	
	@RequestMapping(value="add3", method=RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		request.getParameter("name");
		System.out.println(name);
		return "";
	}
	
	@RequestMapping(value="/userlist", method=RequestMethod.GET)
	public String list(Model model){
		
		List<UserVo> userlist= new ArrayList<UserVo>();
		UserVo user01 = new UserVo(11,"유재석");
		UserVo user02 = new UserVo(22,"정준하");
		UserVo user03 = new UserVo(33,"박명수");
		
		userlist.add(user01);
		userlist.add(user02);
		userlist.add(user03);
		System.out.println(userlist.toString());
		
		model.addAttribute("userlist",userlist);
		return "/WEB-INF/views/index.jsp";
	}
	
}
