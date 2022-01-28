package adapters;

import models.NegativeResponseStatus;
import models.PositiveResponseStatus;
import models.Project;

public class ProjectAdapter extends BaseAdapter{

    public NegativeResponseStatus post(Project project, int statusCode){
        String response = post(gson.toJson(project), statusCode, "project");
        return gson.fromJson(response, NegativeResponseStatus.class);
    }


    public NegativeResponseStatus getProject(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, NegativeResponseStatus.class);
    }
    public PositiveResponseStatus getProject2(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, PositiveResponseStatus.class);
    }

    public String delete(int statusCode){
        return delete(statusCode);
    }
}
