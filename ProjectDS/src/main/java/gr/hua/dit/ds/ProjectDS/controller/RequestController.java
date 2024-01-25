package gr.hua.dit.ds.ProjectDS.controller;

import gr.hua.dit.ds.ProjectDS.entity.Request;
import gr.hua.dit.ds.ProjectDS.dao.RequestDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("request")
public class RequestController {

    @Autowired
    private RequestDAO requestDAO;

    private List<Request> requests = new ArrayList<Request>();

    @PostConstruct
    public void setup(){
        Request r1 = new Request("2021-2-3","uiui","uiui","uiui");
        Request r2 = new Request("2021-2-3","uiui","uiui","uiui");
        Request r3 = new Request("2021-2-3","uiui","uiui","uiui");
        requests.add(r1);
        requests.add(r2);
        requests.add(r3);
    }

    @GetMapping("")
    public String showRequests(Model model){


        model.addAttribute("Request", requestDAO.getRequests());

        return "requests";
    }

    @GetMapping("/{id}")
    public String showRequest(@PathVariable Integer id, Model model){
        Request request = requestDAO.getRequest(id);
        model.addAttribute("requests", request);
        return "requests";
    }

    @GetMapping("/new")
    public String addRequest(Model model){
        Request request = new Request("2021-2-3", "uiui", "uiui", "uiui");
        model.addAttribute("request", request);

        return "add_request";

    }

    @PostMapping("/new")
    public String saveRequest(@ModelAttribute("student") Request request, Model model) {
        requestDAO.saveRequest(request);
        model.addAttribute("students", requestDAO.getRequests());
        return "requests";
    }

}
