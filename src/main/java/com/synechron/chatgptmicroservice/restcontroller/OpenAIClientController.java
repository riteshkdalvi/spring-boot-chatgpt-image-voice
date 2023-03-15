package com.synechron.chatgptmicroservice.restcontroller;

import com.synechron.chatgptmicroservice.model.request.ChatGPTImageRequest;
import com.synechron.chatgptmicroservice.model.request.ChatRequest;
import com.synechron.chatgptmicroservice.model.request.TranscriptionRequest;
import com.synechron.chatgptmicroservice.model.response.ChatGPTImageResponse;
import com.synechron.chatgptmicroservice.model.response.ChatGPTResponse;
import com.synechron.chatgptmicroservice.model.response.WhisperTranscriptionResponse;
import com.synechron.chatgptmicroservice.service.OpenAIClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class OpenAIClientController {

    private final OpenAIClientService openAIClientService;

    @GetMapping("/")
    public String home(){
        return "Suceess";
    }


    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTResponse chat(@RequestBody ChatRequest chatRequest){
        return openAIClientService.chat(chatRequest);
    }

    @PostMapping(value = "/generateImage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTImageResponse chat(@RequestBody ChatGPTImageRequest chatGPTImageRequest){
        return openAIClientService.generateImage(chatGPTImageRequest);
    }


    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ChatGPTResponse createTranscription(@ModelAttribute TranscriptionRequest transcriptionRequest){
        return openAIClientService.createTranscription(transcriptionRequest);
    }
}
