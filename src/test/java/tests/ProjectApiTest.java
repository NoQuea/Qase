package tests;

import adapters.ProjectAdapter;
import models.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectApiTest {

    @Test
    public void negativeTestApi(){

        Project project = Project.builder()
                .title("Blabla")
                .code("!!!")
                .build();
        NegativeResponseStatus actual = new ProjectAdapter().post(project,422);

        NegativeResponseStatus expected = NegativeResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();

        assertEquals(actual, expected);

    }
    @Test
    public void getProjectInvalidNameProject(){
        NegativeResponseStatus actual = new ProjectAdapter().getProject(404, "ASDWAasdwad");
        NegativeResponseStatus expected = NegativeResponseStatus.builder()
                .status(false)
                .errorMessage("Project code is invalid")
                .build();

        assertEquals(actual, expected);
    }
    @Test
    public void getEmptyProjectValidName() {
        PositiveResponseStatus actual = new ProjectAdapter().getProject2(200, "QASDAA");
        PositiveResponseStatus expected = PositiveResponseStatus.builder()
                .status(true)
                .result(Result.builder()
                        .title("blabla")
                        .code("QASDAA")
                        .counts(Counts.builder()
                                .cases(0)
                                .suites(0)
                                .milestones(0)
                                .runs(Runs.builder()
                                        .total(0)
                                        .active(0)
                                        .build())
                                .defects(Defects.builder()
                                        .total(0)
                                        .open(0)
                                        .build())
                                .build())
                        .build())
                .build();

        assertEquals(actual, expected);
    }
    @Test
    public void getProjectValidNameWithOneTestCase() {
        PositiveResponseStatus actual = new ProjectAdapter().getProject2(200, "SL");
        PositiveResponseStatus expected = PositiveResponseStatus.builder()
                .status(true)
                .result(Result.builder()
                        .title("ShareLane")
                        .code("SL")
                        .counts(Counts.builder()
                                .cases(6)
                                .suites(3)
                                .milestones(0)
                                .runs(Runs.builder()
                                        .total(1)
                                        .active(0)
                                        .build())
                                .defects(Defects.builder()
                                        .total(0)
                                        .open(0)
                                        .build())
                                .build())
                        .build())
                .build();

        assertEquals(actual, expected);
    }


//    @Test
//    public void positiveTestApi(){
//        Project project = Project.builder()
//                .title("ForApiTestProject")
//                .code("QWERTY")
//                .build();
//        String actual = new ProjectAdapter().post(project, 200);
//
//        assertEquals(actual,
//                "{\"status\":true,\"result\":{\"code\":\"QWERTY\"}}");
//
//    }
}

