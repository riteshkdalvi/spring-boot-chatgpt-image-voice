package com.synechron.chatgptmicroservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTImageRequest implements Serializable {

    private String prompt;
    private Integer n;
    private String size;

}
