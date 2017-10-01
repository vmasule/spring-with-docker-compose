package com.bd.example.serviceone.controller;

import com.bd.example.serviceone.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SimpleController.class)
@AutoConfigureRestDocs(outputDir = "build/snippets")
public class SimpleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // private Snippet snippet;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Service one up and running!!")))
                .andDo(document("home", PayloadDocumentation.responseFields(
                        fieldWithPath("message").description("Service one up and running!!")
                )));
    }

    @Test
    public void shouldCreateUser() throws Exception {
        String user = "{\"firstName\": \"James\", \"lastName\": \"Bond\", \"email\": \"james.bond@gmail.com\", \"contactNumber\": 383247843}";
        // this.snippet.document();
        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/createUser")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName", is("James")))
                .andExpect(jsonPath("email", is("james.bond@gmail.com")))
                .andExpect(jsonPath("password", notNullValue()))
                // .andDo(MockMvcRestDocumentation.document("{ClassName}/{methodName}", PayloadDocumentation.requestFields(attribu)))
                .andDo(document("create-user", PayloadDocumentation.responseFields(
                        fieldWithPath("firstName").description("First name of user"),
                        fieldWithPath("lastName").description("Last name of user"),
                        fieldWithPath("contactNumber").description("Contact number of user"),
                        fieldWithPath("email").description("Email ID of user"),
                        fieldWithPath("password").description("Password of user")
                // ))).andDo(document("{ClassName}/{methodName}", PayloadDocumentation.requestFields(
                ))).andDo(document("create-user", PayloadDocumentation.requestFields(
                        attributes(key("title").value("Fields for user creation")),
                fieldWithPath("firstName").description("The user's first name").attributes(key("constraints").value("Must not be null. Must not be empty")),
                fieldWithPath("lastName").description("The user's last name").attributes(key("constraints").value("Must not be null. Must not be empty")),
                fieldWithPath("contactNumber").description("The user's contact number").attributes(key("constraints").value("Must not be null. Must not be empty")),
                fieldWithPath("email").description("The user's email address").attributes(key("constraints").value("Must be a valid email address")))));
    }
}
