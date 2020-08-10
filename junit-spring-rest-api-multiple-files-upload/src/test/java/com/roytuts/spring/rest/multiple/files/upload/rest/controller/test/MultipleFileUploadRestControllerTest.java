package com.roytuts.spring.rest.multiple.files.upload.rest.controller.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.roytuts.spring.rest.multiple.files.upload.rest.controller.MultipleFileUploadRestController;

@WebMvcTest(MultipleFileUploadRestController.class)
public class MultipleFileUploadRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMultipleFilesUploadRestController() throws Exception {
		MockMultipartFile file1 = new MockMultipartFile("multipleFiles", "sql-changelog-alter-table.sql",
				"application/sql", this.getClass().getResourceAsStream("/sql-changelog-alter-table.sql"));

		MockMultipartFile file2 = new MockMultipartFile("multipleFiles", "WishNet.txt", "text/plain",
				this.getClass().getResourceAsStream("/WishNet.txt"));

		MockMultipartFile file3 = new MockMultipartFile("multipleFiles", "Static Data", "text/plain",
				"test data".getBytes());

		mockMvc.perform(MockMvcRequestBuilders.multipart("/upload/multiple/files").file(file1).file(file2).file(file3))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
