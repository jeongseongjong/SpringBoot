package com.biz.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.jpa.domain.BookVO;
import com.biz.jpa.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(value="/book")
@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	
	// @ResponseBody
	@RequestMapping(value="/pageList", method=RequestMethod.GET)
	public String getPageList(@PageableDefault Pageable page, Model model) {
		
		Page<BookVO> bookList = bookService.getPageList(page);
		model.addAttribute("bookList", bookList);
		
		return "book_list";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		model.addAttribute("book", new BookVO());
		
		return "/book_insert";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		
		log.debug(bookVO.toString());
		BookVO vo = bookService.save(bookVO);
		
		return "redirect:/book/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String bookList(Model model) {
		
		List<BookVO> bookList = bookService.selectAll();
		model.addAttribute("bookList", bookList);
		
		return "/book_list";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id, Model model) {
		
		long bookId = 0;
		try {
			bookId = Long.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Optional<BookVO> bookVO = bookService.findById(bookId);
		model.addAttribute("book",bookVO.get());
		
		return "/book_insert";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(BookVO bookVO) {
		
		BookVO vo = bookService.save(bookVO);
		
		return "redirect:/book/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id ) {
		
		long bookId = 0;
		
		try {
			bookId = Long.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bookService.delete(bookId);
		
		return "redirect:/book/list";
	}
}
