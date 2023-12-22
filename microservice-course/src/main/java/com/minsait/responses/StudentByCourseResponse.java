package com.minsait.responses;

import com.minsait.DTO.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentByCourseResponse {
    String courseName;
    String teacher;
    List<StudentDTO> studentDTOList;

}
