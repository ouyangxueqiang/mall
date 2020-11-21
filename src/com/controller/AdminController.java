package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Admins;
import com.entity.Goods;
import com.entity.Orders;
import com.entity.Users;
import com.service.AdminService;
import com.service.GoodService;
import com.service.OrderService;
import com.service.UserService;

/**
 * 有关管理员的登录，以及商品的增删查改，用户的信息展示以及交易记录的展示
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodService goodService;

	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String login(Admins admin, HttpServletRequest request, HttpSession session) {
		if (adminService.checkUser(admin.getUsername(), admin.getPassword())) {//登录成功
			session.setAttribute("username", admin.getUsername());
			return "redirect:index";
		}
		request.setAttribute("msg", "账号或密码错误!");//登录失败
		return "/admin/login.jsp";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping("/adminReset")
	public String adminReset(@RequestParam("passwordNew") String passwordNew, @RequestParam("id") int id,
			@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) {
		if (adminService.checkUser(username, password)) {
			Admins admin = new Admins();
			admin.setPassword(passwordNew);
			admin.setId(id);
			admin.setUsername(username);
			adminService.update(admin);
			request.setAttribute("msg", "修改密码成功!请重新登录");
			return "/admin/login.jsp";
		} else {
			request.setAttribute("msg", "原密码错误!请重新输入");
			return "/admin/admin_reset.jsp";
		}
	}

	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "/admin/login.jsp";
	}

	/**
	 * 登录成功，返回首页
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("msg", "登录成功!");
		return "/admin/index.jsp";
	}

	/**
	 * 订单信息展示
	 */
	@RequestMapping("/showOrder")
	public String showOrder(HttpServletRequest request) {
		List<Orders> orderlist = orderService.getList();
		request.setAttribute("orderList", orderlist);
		return "/admin/order_list.jsp";
	}

	/**
	 * 增加商品
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/newGood")
	public String newGood(Goods good, HttpServletRequest request,
			@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2) throws IOException {
		InputStream input = file.getInputStream();//io
		String fileName = file.getOriginalFilename();
		OutputStream out = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ssmdemo2\\index\\images\\"+fileName);
		
		InputStream input1 = file1.getInputStream();//io
		String fileName1 = file1.getOriginalFilename();
		OutputStream out1 = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ssmdemo2\\index\\images\\"+fileName1);
		
		InputStream input2 = file2.getInputStream();//io
		String fileName2 = file2.getOriginalFilename();
		OutputStream out2 = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ssmdemo2\\index\\images\\"+fileName2);
		
		byte[] bs =new byte[1024];
		int len = -1;
		while((len = input.read(bs)) != -1) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		good.setCover(fileName);
		
		byte[] bs1 =new byte[1024];
		int len1 = -1;
		while((len1 = input1.read(bs1)) != -1) {
			out1.write(bs1, 0, len1);
		}
		out1.close();
		input1.close();
		good.setImage1(fileName1);
		
		byte[] bs2 =new byte[1024];
		int len2 = -1;
		while((len2 = input2.read(bs2)) != -1) {
			out2.write(bs2, 0, len2);
		}
		out2.close();
		input2.close();
		good.setImage2(fileName2);
		goodService.insertGood(good);
		request.setAttribute("msg", "新加商品成功");
		return "/admin/new_good.jsp";
	}

	/**
	 * 删除商品
	 */
	@RequestMapping("/deleteGood")
	public String deleteGood(@RequestParam("id") int id, HttpServletRequest request) {
		goodService.deleteGood(id);
		return "showGood";
	}

	/**
	 * 查询商品通过名字
	 */
	@RequestMapping("/queryGood")
	public String queryGood(@RequestParam("name") String name, HttpServletRequest request) {
		List<Goods> goodlist = goodService.getListByName(name);
		request.setAttribute("goodList", goodlist);
		request.setAttribute("msg", "查询商品结果如下");
		return "/admin/good_list.jsp";
	}
	
	/**
	 * 查询商品通过编号
	 */
	@RequestMapping("/queryGoodById")
	public String queryGoodById(@RequestParam("id") int id,HttpServletRequest request,HttpSession session) {
		Goods goodlist = goodService.queryGoodById(id);
		session.setAttribute("goodList", goodlist);
		return "/admin/update_good.jsp";
	}

	/**
	 * 展示商品
	 */
	@RequestMapping("/showGood")
	public String showGood(HttpServletRequest request) {
		List<Goods> goodlist = goodService.getList();
		request.setAttribute("goodList", goodlist);
		return "/admin/good_list.jsp";
	}

	/**
	 * 修改商品
	 */
	@RequestMapping("/updateGood")
	public String updateGood(@RequestParam("id") int id, HttpServletRequest request,Goods good,
			@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2) throws IOException  {
		InputStream input = file.getInputStream();//io
		String fileName = file.getOriginalFilename();
		OutputStream out = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ssmdemo2\\index\\images\\"+fileName);
		
		InputStream input1 = file1.getInputStream();//io
		String fileName1 = file1.getOriginalFilename();
		OutputStream out1 = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ssmdemo2\\index\\images\\"+fileName1);
		
		InputStream input2 = file2.getInputStream();//io
		String fileName2 = file2.getOriginalFilename();
		OutputStream out2 = new FileOutputStream("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ssmdemo2\\index\\images\\"+fileName2);
			
		byte[] bs =new byte[1024];
		int len = -1;
		while((len = input.read(bs)) != -1) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		good.setCover(fileName);
		
		byte[] bs1 =new byte[1024];
		int len1 = -1;
		while((len1 = input1.read(bs1)) != -1) {
			out1.write(bs1, 0, len1);
		}
		out1.close();
		input1.close();
		good.setImage1(fileName1);
		
		byte[] bs2 =new byte[1024];
		int len2 = -1;
		while((len2 = input2.read(bs2)) != -1) {
			out2.write(bs2, 0, len2);
		}
		out2.close();
		input2.close();
		good.setImage2(fileName2);
		goodService.updateGood(good);
		return "showGood";
	}
	
	/**
	 * 展示用户
	 */
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request) {
		List<Users> userlist = userService.getList();
		request.setAttribute("userList", userlist);
		return "/admin/user_list.jsp";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") int id, HttpServletRequest request) {
		userService.deleteUser(id);
		return "showUser";
	}

	/**
	 * 查询用户通过名字
	 */
	@RequestMapping("/queryUser")
	public String queryUser(@RequestParam("name") String name, HttpServletRequest request) {
		List<Users> userlist = userService.getListByName(name);
		request.setAttribute("userList", userlist);
		request.setAttribute("msg", "查询商品结果如上");
		return "/admin/user_list.jsp";
	}

}
