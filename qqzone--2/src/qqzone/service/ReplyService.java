package qqzone.service;

import qqzone.pojo.Reply;
import qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {

    //根据topic的id查询获取其所有的reply
    List<Reply> getReplyListByTopicId(Integer topicTId);
    //添加回复
    void addReply(Reply reply);
    //删除指定回复
    void delReply(Integer id);
    //删除topic关联的所有回复
    void delReplyList(Topic topic);
}
