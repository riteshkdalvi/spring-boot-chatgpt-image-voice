package com.synechron.chatgptmicroservice.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.synechron.chatgptmicroservice.model.request.Message;
import lombok.Data;

import java.io.Serializable;

@Data
public class Choice implements Serializable {
    private Integer index;
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
