package com.synechron.chatgptmicroservice.service;


import com.synechron.chatgptmicroservice.model.request.*;
import com.synechron.chatgptmicroservice.model.response.ChatGPTImageResponse;
import com.synechron.chatgptmicroservice.model.response.ChatGPTResponse;
import com.synechron.chatgptmicroservice.model.response.WhisperTranscriptionResponse;
import com.synechron.chatgptmicroservice.openaiclient.OpenAIClient;
import com.synechron.chatgptmicroservice.openaiclient.OpenAIClientConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {

    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    private final static String ROLE_USER = "user";

    public ChatGPTResponse chat(ChatRequest chatRequest){
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(chatRequest.getQuestion())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        return openAIClient.chat(chatGPTRequest);
    }

    public ChatGPTImageResponse generateImage(ChatGPTImageRequest chatGPTImageRequest){
//        Message message = Message.builder()
//                .role(ROLE_USER)
//                .content(chatGPTImageRequest.getPrompt())
//                .build();
//        ChatGPTImageRequest chatGPTImageRequest1 = ChatGPTImageRequest.builder()
//                .prompt(Collections.singletonList(c))
//                .build();
        return openAIClient.generateImage(chatGPTImageRequest);
    }

    public ChatGPTResponse createTranscription(TranscriptionRequest transcriptionRequest){
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
                .model(openAIClientConfig.getAudioModel())
                .file(transcriptionRequest.getFile())
                .build();
        String transcription = openAIClient.createTranscription(whisperTranscriptionRequest);
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(transcription)
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();

        return openAIClient.chat(chatGPTRequest);
    }
}
