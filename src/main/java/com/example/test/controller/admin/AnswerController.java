package com.example.test.controller.admin;

import com.example.test.entity.Answer;
import com.example.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    //TODO AnswerController
    @RequestMapping("/getAnswerById.action")
    public Answer getAnswer(@RequestParam(value="id", defaultValue="1") int id,
                            Model model, HttpSession session){
        Answer answer = answerService.get(id);
        model.addAttribute("answer",answer);
        System.out.println(answer);
        return answer;
    }
}
