package com.minsait.clients;

import com.minsait.DTO.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mvsc-student", url = "localhost:7090/api/v1/student")
public interface StudentClient {

    @GetMapping("/search-by-course/{idCourse}")
     List<StudentDTO> findByIdCourse(@PathVariable Long idCourse);
}
