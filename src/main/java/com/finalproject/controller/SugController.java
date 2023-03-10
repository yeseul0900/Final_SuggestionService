package com.finalproject.controller;

import com.finalproject.SugService;
import com.finalproject.VO.SuggestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@RequestMapping(value = "/board")
public class SugController {
    @Autowired
    SugService sugService;
    @RequestMapping(value = "/")
    public String home(){return "board/index";}
    @RequestMapping(value = "/board/post", method = RequestMethod.GET)
    public String suglist(Model model){
        model.addAttribute("list",sugService.getSugList());
        return "board/post";
    }
    @RequestMapping(value = "/board/add", method= RequestMethod.GET)
    public String addPost(){
        return "board/addform";
    }
    @RequestMapping(value = "/board/addok", method = RequestMethod.GET)
    public String addPostOK(SuggestionVO vo){
        if(sugService.insertSug(vo) == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공");
        return "redirect:post";
    }
    @RequestMapping(value = "/board/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        SuggestionVO suggestionVO = sugService.getSug(id);
        model.addAttribute("u",suggestionVO);
        return "board/editform";
    }
    @RequestMapping(value = "/board/editok", method = RequestMethod.GET)
    public String editPostOK(SuggestionVO vo){
        if(sugService.updateSug(vo) == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공");
        return "redirect:post";
    }
    @RequestMapping(value = "/board/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOK(@PathVariable("id") int id){
        if(sugService.deleteSug(id) == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공");
        return "redirect:../post";
    }

}

