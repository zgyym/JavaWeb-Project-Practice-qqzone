package qqzone.service;

import qqzone.pojo.Reply;

import java.util.List;

public interface ReplyService {

    //根据topic的id查询获取其所有的reply
    List<Reply> getReplyListByTopicId(Integer topicTId);
}
