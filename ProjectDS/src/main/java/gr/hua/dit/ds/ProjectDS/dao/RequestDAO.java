package gr.hua.dit.ds.ProjectDS.dao;

import gr.hua.dit.ds.ProjectDS.entity.Request;

import java.util.List;

public interface RequestDAO {

    public List<Request> getRequests();

    public Request saveRequest(Request request);

    public Request getRequest(int id);

}
