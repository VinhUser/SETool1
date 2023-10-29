package com.interview.Interview;

import com.interview.Interview.model.Interview;
import com.interview.Interview.model.dto.InterviewDTO;
import com.interview.Interview.service.InterviewService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestService {
    @Mock
    InterviewService interviewService;



    @Test
    void testServiceWithSave(){
        Interview interview = new Interview();
        interview.setCv_id(1);
        interview.setQuestion_id(1);
        interview.setFeedback("a");
        interviewService.saveInterview(interview);
        Assertions.assertThat(interview.getQuestion_id()).isEqualTo(1);
        Assertions.assertThat(interview.getCv_id()).isEqualTo(1);
        Assertions.assertThat(interview.getFeedback()).isEqualTo("a");
    }
    @Test
    void testServiceDelete(){
        int id = 48;
        InterviewDTO interviewDTO = interviewService.findInterviewById(id);
        if (interviewDTO != null) {
            interviewService.deleteInterview(id);
            System.out.println("Delete success");
        }else{
            System.out.println("id not found");
        }
    }
    @Test
    void testServiceUpdate(){

    }
    @Test
    void testServiceFindByID(){
        int id = 10;
        InterviewDTO interviewDTO = interviewService.findInterviewById(id);

        if (interviewDTO != null){
            System.out.println("success");
            System.out.println(interviewDTO);
        }else {
            System.out.println("id not found");
        }
    }
    @Test
    void testServiceFindAll(){

    }

}
