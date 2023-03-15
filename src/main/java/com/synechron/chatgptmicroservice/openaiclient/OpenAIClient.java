package com.synechron.chatgptmicroservice.openaiclient;

import com.synechron.chatgptmicroservice.model.request.ChatGPTImageRequest;
import com.synechron.chatgptmicroservice.model.request.ChatGPTRequest;
import com.synechron.chatgptmicroservice.model.request.WhisperTranscriptionRequest;
import com.synechron.chatgptmicroservice.model.response.ChatGPTImageResponse;
import com.synechron.chatgptmicroservice.model.response.ChatGPTResponse;
import com.synechron.chatgptmicroservice.model.response.WhisperTranscriptionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = OpenAIClientConfig.class
)
public interface OpenAIClient {

    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

    @PostMapping(value ="${openai-service.urls.image-url}", headers = {"Content-Type=application/json"})
    ChatGPTImageResponse generateImage(@RequestBody ChatGPTImageRequest chatGPTImageRequest);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    String createTranscription(@ModelAttribute WhisperTranscriptionRequest whisperTranscriptionRequest);
}
