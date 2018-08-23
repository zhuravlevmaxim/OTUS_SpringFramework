package ru.otus.lesson14hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.lesson14hw.domain.Comment;
import ru.otus.lesson14hw.repository.CommentRepository;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/comment")
    public String author(@RequestParam String id, Model model){
        Comment comment = commentRepository.findById(id).get();
        model.addAttribute("comment", comment);
        return "comment";
    }

    @RequestMapping(value = "/editComment", method = RequestMethod.POST)
    public String editAuthor(@ModelAttribute Comment comment){
        commentRepository.save(comment);
        String id = comment.getId();
        return "redirect:/comment?id=" + id;
    }
}
