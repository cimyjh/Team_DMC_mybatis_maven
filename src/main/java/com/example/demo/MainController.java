package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.DetailService;
import com.example.service.EventService;
import com.example.service.NewService;
import com.example.vo.EventVO;
import com.example.vo.MemberVO;
import com.example.vo.NewVO;
import com.example.vo.ReviewVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {// 모든 경로를 관리

	@Autowired
	private EventService eventService;

	@Autowired
	private NewService newService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private DetailService detailService;

	@GetMapping("/")
	public String index() {
		return "index"; // templates/index.html
	}

	// 신제품
	@GetMapping("/new")
	public String news(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.newService.selectAllNew(map);
		List<NewVO> list = (List<NewVO>) map.get("results");
		model.addAttribute("news", list);
		return "new"; // templates/new.html
	}

	@GetMapping("/new/{n_store}")
	public String news(@PathVariable String n_store, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("n_store", n_store);
		this.newService.selelctNew(map);
		List<NewVO> list = (List<NewVO>) map.get("result");
		model.addAttribute("news", list);
		return "new";

	}

	// 행사제품

	// event 작업
	@GetMapping("/event")
	public String event(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.eventService.selectAllEvent(map);
		List<EventVO> list = (List<EventVO>) map.get("results");
		model.addAttribute("events", list);
		return "event";
	}

	@GetMapping("/event/{e_store}")
	public String event(@PathVariable String e_store, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("e_store", e_store);

		this.eventService.selectAllEvent_store(map);
		List<EventVO> list = (List<EventVO>) map.get("results");
		EventVO event = list.get(0);
		model.addAttribute("events", list);
		return "event"; // templates/display.html

	}

	@GetMapping("/register")
	public String register() {
		return "register"; // templates/register.html
	}




	@PostMapping("/register")
	public String register(MemberVO member) {
		log.info("member={}", member);

		this.memberService.insertMember(member);
		return "redirect:/";
	}




	@GetMapping("/list")
	public String list(Model model) {
		List<MemberVO> list = null;
		model.addAttribute("member", list);
		return "list"; // template/list.html
	}

	// detail
	@GetMapping("/detail/{n_num}")
	public String detail(@PathVariable int n_num, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("n_num", n_num);
		this.detailService.selectDetailNew(map);
		List<NewVO> list = (List<NewVO>) map.get("result");
		NewVO news = list.get(0);
		model.addAttribute("news", news);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("n_num", n_num);
		this.detailService.selectDetailReview(map2);
		List<ReviewVO> list2 = (List<ReviewVO>) map2.get("resultsReview");
		model.addAttribute("review", list2);

		for (ReviewVO reviewVO : list2) {
			log.info("review={}", reviewVO);
		}

		return "detail";

	}

	@GetMapping("/event/form")
	public String event_form(@RequestParam(value = "e_evt") String e_evt,
			@RequestParam(value = "e_product1") String e_product1, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("e_evt", e_evt);
		map.put("e_product1", e_product1);
		this.eventService.select_Event_form(map);

		List<EventVO> list = (List<EventVO>) map.get("results");
		model.addAttribute("events", list);

		log.info(" " + list.size());
		log.info("" + e_evt);
		log.info("" + e_product1);

		return "event";

	}

	@GetMapping("/event/search")
	public String event_search(@RequestParam(value = "e_name") String e_name, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("e_name", e_name);
		this.eventService.select_Textbox(map);
		;

		List<EventVO> list = (List<EventVO>) map.get("results");
		model.addAttribute("events", list);

		log.info(" " + list.size());
		log.info("" + e_name);

		return "event";

	}

	@GetMapping("/new/form")
	public String new_form(@RequestParam(value = "n_product1") String n_product1, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("n_product1", n_product1);
		this.newService.select_new_form(map);

		List<NewVO> list = (List<NewVO>) map.get("results");
		model.addAttribute("news", list);
		return "new";

	}

	//////////////// new 상품 검색
	@GetMapping("/new/search")
	public String new_search(@RequestParam(value = "n_name") String n_name,

			Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("n_name", n_name);

		this.newService.search_new_name(map);

		List<NewVO> list = (List<NewVO>) map.get("results");
		model.addAttribute("news", list);

		return "new";
	}

	//login
	@GetMapping("/login")
	public void login() {}


	//detail에서 review 작성

	@GetMapping("/review/{n_num}")
	public String review(@PathVariable int n_num,
						 @RequestParam(value = "nickname") String nickname,
						 @RequestParam(value = "r_comment") String r_comment,
						 @RequestParam(value = "r_like") String r_like
						 ) {

		log.info("review 작성에 대한 것 입니다:" + n_num+ "  " + nickname+ "  " +r_comment + " " + r_like);

		this.detailService.insertReview(n_num, nickname, r_comment, r_like);
		return "redirect:/new";
	}

}
