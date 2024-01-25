package gr.hua.dit.ds.ProjectDS.rest;

import gr.hua.dit.ds.ProjectDS.dao.RequestDAO;
import gr.hua.dit.ds.ProjectDS.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request")
public class RequestRestController {

    @Autowired
    private RequestDAO requestDAO;

    @GetMapping("")
    public List<Request> getRequest(){ return requestDAO.getRequests(); }

    @PostMapping("")
    public Request saveRequest(@RequestBody Request request){ return requestDAO.saveRequest(request); }

}
