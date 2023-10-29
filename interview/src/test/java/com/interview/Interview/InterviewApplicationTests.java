package com.interview.Interview;


import com.interview.Interview.controller.InterviewController;
import com.interview.Interview.controller.res.PagingResponse;
import com.interview.Interview.controller.res.ResponseObject;
import com.interview.Interview.model.Interview;
import com.interview.Interview.model.dto.InterviewDTO;
import com.interview.Interview.repository.InterviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InterviewApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

	@InjectMocks
	InterviewController interviewController;
	@Autowired
	InterviewRepository interviewRepository;

	//get Iterview by Id with status 200
	@Test
	public void getInterviewByIdWithStatus200() {
			ResponseEntity<ResponseObject> response = restTemplate.getForEntity("/api/get/Interview/1", ResponseObject.class);
			Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			Assertions.assertThat(response.getBody().getMessage()).isEqualTo("Get Success");
			Assertions.assertThat(response.getBody().getStatus()).isEqualTo(true);
			InterviewDTO interviewDTO = modelMapper.map(response.getBody().getData(), InterviewDTO.class);
			Assertions.assertThat(interviewDTO).isNotNull();
			System.out.println(interviewDTO);
		}
		//create
	@Test
	public void postInterviewSuccess() throws Exception{
		Interview interview = new Interview();
		Date date = new Date();
		Date date1 = new Date();
		String date2 = "25/03/2023";
		String date3 = "25/03/2023";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/DD");
		date = simpleDateFormat.parse(date2);
		date1 = simpleDateFormat.parse(date3);
		interview.setDate_feedback(date1);
		interview.setStatus(1);
		interview.setGrade(10);
		interview.setQuestion_id(2);
		interview.setTime_interview(date);
		interview.setCv_id(1);
		interview.setQuestion_id(1);
		interview.setFeedback("good");
		ResponseEntity<ResponseObject> createResponse = restTemplate.postForEntity("/api/post/Interview", interview, ResponseObject.class);
		Assertions.assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println(interview);

	}
	// Xóa cuộc phỏng vấn
	@Test
	public void testDeleteInterviewSuccess() {
		//create gia tri moi de test xoa
		int interviewId = 83;
		Assertions.assertThat(interviewRepository.existsById(interviewId)).isTrue();
		Interview interview = interviewRepository.findById(interviewId).orElse(null);
		Assertions.assertThat(interview).isNotNull();

		interview.setId(0);
		Interview creaInterview = interviewRepository.save(interview);
		System.out.println(creaInterview.getId());
		//xoa
		ResponseEntity<ResponseObject> deleteResponse = restTemplate.exchange("/api/delete/Interview/" + creaInterview.getId(), HttpMethod.DELETE, null, ResponseObject.class);
		Assertions.assertThat(deleteResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(interviewRepository.existsById(creaInterview.getId())).isFalse();
//		interviewRepository.save(interview);


	}

	@Test
	public void testUpdateInterviewSuccess() {
		int id = 1;
		Assertions.assertThat(interviewRepository.existsById(id));
		Optional<Interview> interviewOptional = interviewRepository.findById(id);
		Assertions.assertThat(interviewOptional).isNotNull();
		interviewOptional.get().setFeedback("Test");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Interview> requestEntity = new HttpEntity<>(interviewOptional.get(), headers);
		ResponseEntity<ResponseObject> response = restTemplate.exchange(
				"/api/update/Interview/{id}", HttpMethod.PUT, requestEntity, ResponseObject.class, id);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Interview updatedInterview = requestEntity.getBody();
		Assertions.assertThat(updatedInterview).isNotNull();
		Assertions.assertThat(updatedInterview.getFeedback()).isEqualTo("Test");
	}

	@Test
	public void testGetAllInterviewWithPageable() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		PageRequest pageable = PageRequest.of(0, 3); // Example values

		HttpEntity<?> entity = new HttpEntity<>(pageable, headers);
		ResponseEntity<PagingResponse> response = restTemplate.exchange("/api/getsAll",
				HttpMethod.GET,
				entity,
				PagingResponse.class
		);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
