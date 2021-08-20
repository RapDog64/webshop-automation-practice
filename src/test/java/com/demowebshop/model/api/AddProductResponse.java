package com.demowebshop.model.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductResponse {

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("message")
	private String message;

	@JsonProperty("updatetopcartsectionhtml")
	private String updatetopcartsectionhtml;

	@JsonProperty("updateflyoutcartsectionhtml")
	private String updateflyoutcartsectionhtml;
}