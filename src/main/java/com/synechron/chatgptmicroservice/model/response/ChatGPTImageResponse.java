package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChatGPTImageResponse implements Serializable {

    private Integer created;

    private List<ImageUrl> data;

}
